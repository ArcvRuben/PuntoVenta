package MVC.Modelo;

import java.sql.*;

public class Persona {

    private String idPersona;
    private String nombrePersona;
    private String apellidoPersona;
    Date fechaNacimiento;
    private String telefono;
    private String sexo;
    private double sueldo;
    private int cupo;
    private byte[] foto;


    public Persona(String idPersona, String nombrePersona, String apellidoPersona, Date fechaNacimiento, String telefono, String sexo, double sueldo, int cupo, byte[] foto) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.sexo = sexo;
        this.sueldo = sueldo;
        this.cupo = cupo;
        this.foto = foto;
    }

    public Persona() {
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

}
