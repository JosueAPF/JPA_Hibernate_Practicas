package Practica_3_JavaSwing;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Practica_3_JavaSwing.Estudiante;
import java.util.ArrayList;
import java.util.List;

public class AplicandoPersistencia {

    private static EntityManager Manager;
    private static EntityManagerFactory FactoryManager;
    private List<Estudiante> listadoEstudiantes;

    public AplicandoPersistencia() {
        listadoEstudiantes = new ArrayList<>();
        /*Estableciendo la conexion ala base de datos*/
        FactoryManager = Persistence.createEntityManagerFactory("Persistencia_practica1");
        Manager = FactoryManager.createEntityManager();
    }

    public void InsercionDatos(Estudiante ObjEstudiante) {
        try {
            Manager.getTransaction().begin();
            Manager.persist(ObjEstudiante);
            Manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StringBuilder MostrarDatos() {
        StringBuilder CadenaDatos = new StringBuilder();
        listadoEstudiantes = Manager.createQuery("From Estudiante").getResultList();
        for (int i = 0; i < listadoEstudiantes.size(); i++) {
            //System.out.println(listadoEstudiantes.get(i).toString());
            Estudiante estudiantes = listadoEstudiantes.get(i);
            CadenaDatos.append("ID :").append(estudiantes.getId()).append("Nombre :").
                    append(estudiantes.getNombre()).append("Apellido :").append(estudiantes.getApellido()).
                    append("Edad :").append(estudiantes.getEdad()).append("Grado Academico").
                    append(estudiantes.getGradoAcademico());
        }
        return CadenaDatos;
    }
    //busca un estudiante segun un id existente y muestar los datos en un text area
    public StringBuilder BuscarPorId(Long id) {
        StringBuilder datoId = new StringBuilder();
        Manager.getTransaction().begin();

        // Busca el estudiante por id y lo guarda en una variable
        Estudiante estudiante = Manager.find(Estudiante.class, id);

        // Verifica si se encontró el estudiante
        if (estudiante != null) {
            datoId.append("ID: ").append(estudiante.getId())
                    .append(" Nombre: ").append(estudiante.getNombre())
                    .append(" Apellido: ").append(estudiante.getApellido())
                    .append(" Edad: ").append(estudiante.getEdad())
                    .append(" Grado Academico: ").append(estudiante.getGradoAcademico());
        } else {
            System.out.println("Nada que Modificar");
        }

        Manager.getTransaction().commit();
        return datoId;
    }

    /*
    public static void main(String[] args){
        Estudiante objE1 = new Estudiante(1L,"pepe","perez",18,"cuarto");
        Estudiante objE2 = new Estudiante(2L,"miguel","sanchez",16,"segundo");

        AplicandoPersistencia obj1  = new AplicandoPersistencia();
        
        obj1.InsercionDatos(objE1);
        obj1.InsercionDatos(objE2);
        obj1.MostrarDatos();
    }*/
}
