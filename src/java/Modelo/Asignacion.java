/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Gabriel
 */
public class Asignacion {
    private int codigoAsignacion;
    private int codigoCurso;
    private int codigoCarnet;
    private Date fecha;

    public Asignacion() {
    }

    public Asignacion(int codigoAsignacion, int codigoCurso, int codigoCarnet, Date fecha) {
        this.codigoAsignacion = codigoAsignacion;
        this.codigoCurso = codigoCurso;
        this.codigoCarnet = codigoCarnet;
        this.fecha = fecha;
    }

    public int getCodigoAsignacion() {
        return codigoAsignacion;
    }

    public void setCodigoAsignacion(int codigoAsignacion) {
        this.codigoAsignacion = codigoAsignacion;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getCodigoCarnet() {
        return codigoCarnet;
    }

    public void setCodigoCarnet(int codigoCarnet) {
        this.codigoCarnet = codigoCarnet;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Asignacion{" + "codigoAsignacion=" + codigoAsignacion + ", codigoCurso=" + codigoCurso + ", codigoCarnet=" + codigoCarnet + ", fecha=" + fecha + '}';
    }
    
}
