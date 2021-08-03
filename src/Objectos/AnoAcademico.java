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
public class AnoAcademico implements Serializable{
    private int idAnoAcademico;
    private int ano;
    private int trimestre;

    public AnoAcademico(int idAnoAcademico, int ano, int trimestre) {
        this.idAnoAcademico = idAnoAcademico;
        this.ano = ano;
        this.trimestre = trimestre;
    }

    public int getIdAnoAcademico() {
        return idAnoAcademico;
    }

    public int getAno() {
        return ano;
    }

    public int getTrimestre() {
        return trimestre;
    }
    
    public String toString(){
        String format = "%-20s %-20s %-20s";
        return String.format(format, idAnoAcademico, ano, trimestre);
    }
}
