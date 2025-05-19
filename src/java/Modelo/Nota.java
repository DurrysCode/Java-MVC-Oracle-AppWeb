/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Gabriel
 */
public class Nota {
    private int asignacion;
    private int primerParcial;
    private int segundoParcial;
    private int actividades;
    private int examenFinal;
    private int examenRecuperacion;

    public Nota() {
    }

    public Nota(int asignacion, int primerParcial, int segundoParcial, int actividades, int examenFinal, int examenRecuperacion) {
        this.asignacion = asignacion;
        this.primerParcial = primerParcial;
        this.segundoParcial = segundoParcial;
        this.actividades = actividades;
        this.examenFinal = examenFinal;
        this.examenRecuperacion = examenRecuperacion;
    }
    
    public boolean necesitaRecuperacion(){
        int notaTotal = primerParcial + segundoParcial + actividades + examenFinal;
        if(notaTotal > 65){
            return false;
        } else{
            return true;
        }
    }
    
    public int calcularNotaTotal(){
        int notaTotal = primerParcial + segundoParcial + actividades + examenFinal;
        return notaTotal;
    }

    public int getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(int asignacion) {
        this.asignacion = asignacion;
    }

    public int getPrimerParcial() {
        return primerParcial;
    }

    public void setPrimerParcial(int primerParcial) {
        this.primerParcial = primerParcial;
    }

    public int getSegundoParcial() {
        return segundoParcial;
    }

    public void setSegundoParcial(int segundoParcial) {
        this.segundoParcial = segundoParcial;
    }

    public int getActividades() {
        return actividades;
    }

    public void setActividades(int actividades) {
        this.actividades = actividades;
    }

    public int getExamenFinal() {
        return examenFinal;
    }

    public void setExamenFinal(int examenFinal) {
        this.examenFinal = examenFinal;
    }

    public int getExamenRecuperacion() {
        return examenRecuperacion;
    }

    public void setExamenRecuperacion(int examenRecuperacion) {
        this.examenRecuperacion = examenRecuperacion;
    }

    @Override
    public String toString() {
        return "Nota{" + "asignacion=" + asignacion + ", primerParcial=" + primerParcial + ", segundoParcial=" + segundoParcial + ", actividades=" + actividades + ", examenFinal=" + examenFinal + ", examenRecuperacion=" + examenRecuperacion + '}';
    }
    
}
