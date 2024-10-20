package Practica_3_JavaSwing;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Estudiante")
public class Estudiante {
    @Id
    @Column(name = "Id")
    private Long id;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Apellido")
    private String Apellido;
    @Column(name = "Edad")
    private int Edad;
    @Column(name = "Grado_Academico")
    private String gradoAcademico;
    public Estudiante(){}
    public Estudiante(Long id, String Nombre, String Apellido, int Edad, String gradoAcademico) {
        this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.gradoAcademico = gradoAcademico;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    @Override
    public String toString() {
        return "EntidadEstudiante{" + "id=" + id + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Edad=" + Edad + ", gradoAcademico=" + gradoAcademico + '}';
    }
    
    
}
