package Practica_1_consola;
//Persistencia_practica1

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import jakarta.persistence.EntityManager;

public class AplicandoEntidad {

    //creacion del gestor de Entidades 
    private static EntityManager Manager;
    private static EntityManagerFactory Emanagerfactory;
    protected static List<EntidadPersona> ListadoPersona;

    public static void addPersonas() {
        EntidadPersona PersonaObj1 = new EntidadPersona(10L, "Pepillo", "Ramirez", 12);

        try {
            Manager.getTransaction().begin();
            Manager.persist(PersonaObj1);
            Manager.getTransaction().commit();
        } catch (Exception e) {
            if (Manager.getTransaction().isActive()) {
                Manager.getTransaction().rollback();
            }
            e.printStackTrace(); // Mostrar la excepción en caso de error
        }
    }

    public static void showPersonas() {
        ListadoPersona = Manager.createQuery("From EntidadPersona", EntidadPersona.class).getResultList();
        for (int i = 0; i < ListadoPersona.size(); i++) {
            System.out.println("\n"+ListadoPersona.get(i).toString());
        }
    }

    public static void main(String[] args) {
        Emanagerfactory = Persistence.createEntityManagerFactory("Persistencia_practica1");
        Manager = Emanagerfactory.createEntityManager();

        try {
            addPersonas();
            showPersonas();
        } finally {
            Manager.close(); // Cerrar el EntityManager
            Emanagerfactory.close(); // Cerrar el EntityManagerFactory
        }
    }
}
