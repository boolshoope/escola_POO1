/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objectos;

import java.util.Date;

/**
 *
 * @author isacl
 */
public class Teste {

    private int idTeste;
    private float nota;
    private String tipo;
    private Date dataRealizacao;
    private float peso;
    private String comentario;
    private int idAnoAcademico;
    private int idDisciplina;
    private int nrEstudante;

    public Teste(int idTeste, float nota, String tipo, Date dataRealizacao, float peso, String comentario, int idAnoAcademico, int idDisciplina, int nrEstudante) {
        this.idTeste = idTeste;
        this.nota = nota;
        this.tipo = tipo;
        this.dataRealizacao = dataRealizacao;
        this.peso = peso;
        this.comentario = comentario;
        this.idAnoAcademico = idAnoAcademico;
        this.idDisciplina = idDisciplina;
        this.nrEstudante = nrEstudante;
    }

    public int getIdTeste() {
        return idTeste;
    }

    public void setIdTeste(int idTeste) {
        this.idTeste = idTeste;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(Date dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdAnoAcademico() {
        return idAnoAcademico;
    }

    public void setIdAnoAcademico(int idAnoAcademico) {
        this.idAnoAcademico = idAnoAcademico;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getNrEstudante() {
        return nrEstudante;
    }

    public void setNrEstudante(int nrEstudante) {
        this.nrEstudante = nrEstudante;
    }

    public String toString(String est, String disc, String anoAcademico) {
        String format = "%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s";
        return String.format(format, idTeste, est, disc, nota, tipo, dataRealizacao, peso, anoAcademico, comentario);
    }
}
