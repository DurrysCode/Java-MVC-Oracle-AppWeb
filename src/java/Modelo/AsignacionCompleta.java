/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Gabriel
 */
public class AsignacionCompleta {
    private Asignacion asignacion = new Asignacion();
    private Nota nota = new Nota();
    private int notaTotal;
    private boolean recuperacion;

    public AsignacionCompleta() {
    }

    public AsignacionCompleta(Asignacion asignacion, Nota nota, int notaTotal, boolean recuperacion) {
        this.asignacion = asignacion;
        this.nota = nota;
        this.notaTotal = notaTotal;
        this.recuperacion = recuperacion;
    }

    public Asignacion getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Asignacion asignacion) {
        this.asignacion = asignacion;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public int getNotaTotal() {
        return notaTotal;
    }

    public void setNotaTotal(int notaTotal) {
        this.notaTotal = notaTotal;
    }

    public boolean isRecuperacion() {
        return recuperacion;
    }

    public void setRecuperacion(boolean recuperacion) {
        this.recuperacion = recuperacion;
    }
    
    
}
