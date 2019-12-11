package co.com.poli.finalcloudaq.finalcloudaq.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name= "student")
public class Student implements Serializable {
    @Id
    private String cedula;
    private String nombre;
    private double notaParcial;
    private double notaFinal;
    private double notaSeguimiento;
    private double notaDefinitiva;

    public Student() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNotaParcial() {
        return notaParcial;
    }

    public void setNotaParcial(double notaParcial) {
        this.notaParcial = notaParcial;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public double getNotaSeguimiento() {
        return notaSeguimiento;
    }

    public void setNotaSeguimiento(double notaSeguimiento) {
        this.notaSeguimiento = notaSeguimiento;
    }

    public double getNotaDefinitiva() {
        return notaDefinitiva;
    }

    public void setNotaDefinitiva(double notaDefinitiva) {
        this.notaDefinitiva = notaDefinitiva;
    }
}
