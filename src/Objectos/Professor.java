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
public class Professor extends Pessoa implements Serializable{

    private String grauAcademico;

    public Professor(String grauAcademico, int idPessoa, String pNome, String apelido, char sexo, String nrBI, String estadoCivil, String tel1, String tel2) {
        super(idPessoa, pNome, apelido, sexo, nrBI, estadoCivil, tel1, tel2);
        this.grauAcademico = grauAcademico;
    }

    public String getGrauAcademico() {
        return grauAcademico;
    }

    public void setGrauAcademico(String grauAcademico) {
        this.grauAcademico = grauAcademico;
    }

    public String toString() {
        String format = "%-20s";
        return super.toString() + String.format(format, grauAcademico);
    }

}
