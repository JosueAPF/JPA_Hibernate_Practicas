
package Practica_2_consola;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Mascotas")
public class Mascotas {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "NombreAmo")
    private String NombreAmo;
    @Column(name = "Edad")
    private int Edad;
    @Column(name = "Fecha_ingreso")
    private Date Fecha_ingreso;
    public Mascotas(){
    }

    public Mascotas(Long id, String Nombre, String NombreAmo, int Edad, Date Fecha_ingreso) {
        this.id = id;
        this.Nombre = Nombre;
        this.NombreAmo = NombreAmo;
        this.Edad = Edad;
        this.Fecha_ingreso = Fecha_ingreso;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getNombreAmo() {
        return NombreAmo;
    }

    public int getEdad() {
        return Edad;
    }

    public Date getFecha_ingreso() {
        return Fecha_ingreso;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setNombreAmo(String NombreAmo) {
        this.NombreAmo = NombreAmo;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public void setFecha_ingreso(Date Fecha_ingreso) {
        this.Fecha_ingreso = Fecha_ingreso;
    }

    @Override
    public String toString() {
        return "Mascotas{" + "id=" + id + ", Nombre=" + Nombre + ", NombreAmo=" + NombreAmo + ", Edad=" + Edad + ", Fecha_ingreso=" + Fecha_ingreso + '}';
    }
    
    
    
}
