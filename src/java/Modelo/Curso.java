/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Gabriel
 */
public class Curso {
    private int codigo;
    private int creditos;
    private String curso;

    public Curso(){}
    
    public Curso(int codigo, int creditos, String curso) {
        this.codigo = codigo;
        this.creditos = creditos;
        this.curso = curso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", creditos=" + creditos + ", curso=" + curso + '}';
    }
}
