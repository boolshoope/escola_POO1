/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objectos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author isacl
 */
public class Teste implements Serializable{

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

    public float getNota() {
        return nota;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getDataRealizacao() {
        return dataRealizacao;
    }

    public float getPeso() {
        return peso;
    }

    public String getComentario() {
        return comentario;
    }

    public int getIdAnoAcademico() {
        return idAnoAcademico;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public int getNrEstudante() {
        return nrEstudante;
    }

    public String toString(String est, String disc, String anoAcademico) {
        String format = "%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s";
        return String.format(format, idTeste, est, disc, nota, tipo, dataRealizacao, peso, anoAcademico, comentario);
    }
}
