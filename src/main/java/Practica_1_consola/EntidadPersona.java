
package Practica_1_consola;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EntidadPersona")
public class EntidadPersona {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Apellido")
    private String Apellido;
    @Column(name = "Edad")
    private int Edad;
    
    public EntidadPersona(){}
    public EntidadPersona(Long id, String Nombre, String Apellido, int Edad) {
        this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
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

    @Override
    public String toString() {
        return "EntidadPersona{" + "id=" + id + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Edad=" + Edad + '}';
    }
    
    
}
