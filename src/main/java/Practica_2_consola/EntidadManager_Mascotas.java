package Practica_2_consola;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.time.LocalDate;
import java.util.Date;
import Practica_2_consola.Mascotas;

public class EntidadManager_Mascotas {

    private static EntityManager EManager;
    private static EntityManagerFactory FManager;
    private static LocalDate fechaActual = LocalDate.now();
    private static Date fechaDate = java.sql.Date.valueOf(fechaActual);

    public EntidadManager_Mascotas() {
        //estableciendo conexion a ala base de datos
        FManager = Persistence.createEntityManagerFactory("Persistencia_practica1");
        EManager = FManager.createEntityManager();
    }

    @SuppressWarnings("Unchecked")
    public void InsertarDatos() {
        Mascotas perro1 = new Mascotas(10L, "Pepillo", "Juan Jose", 2, fechaDate);
        Mascotas gato1 = new Mascotas(20L, "Adolf", "Pedro", 1, fechaDate);

        EManager.getTransaction().begin();
        EManager.persist(perro1);
        EManager.persist(gato1);
        EManager.getTransaction().commit();
    }

    @SuppressWarnings("Unchecked")
    public void MostrarDatos() {
        List<Mascotas> ListadoMascotas = EManager.createQuery("FROM Mascotas").getResultList();
        for (int i = 0; i < ListadoMascotas.size(); i++) {
            System.out.println(ListadoMascotas.get(i).toString());
        }
    }

    public static void main(String[] args) {
        EntidadManager_Mascotas obj1 = new EntidadManager_Mascotas();
        obj1.InsertarDatos();
        obj1.MostrarDatos();
        EManager.close();
    }
}
