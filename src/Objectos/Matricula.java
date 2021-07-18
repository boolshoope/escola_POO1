/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objectos;

import java.io.Serializable;

/**
 *
 * @author isacl
 */
public class Matricula implements Serializable{
    private int nrEstudante;
    private int idTurma;
    private int idAnoAcademico;

    public Matricula(int nrEstudante, int idTurma, int idAnoAcademico) {
        this.nrEstudante = nrEstudante;
        this.idTurma = idTurma;
        this.idAnoAcademico = idAnoAcademico;
    }

    public int getNrEstudante() {
        return nrEstudante;
    }

    public void setNrEstudante(int nrEstudante) {
        this.nrEstudante = nrEstudante;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public int getIdAnoAcademico() {
        return idAnoAcademico;
    }

    public void setIdAnoAcademico(int idAnoAcademico) {
        this.idAnoAcademico = idAnoAcademico;
    }
    
    
}
