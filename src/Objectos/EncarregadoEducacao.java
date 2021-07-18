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
public class EncarregadoEducacao extends Pessoa implements Serializable{
    private String grauParentesco;

    public EncarregadoEducacao(String grauParentesco, int idPessoa, String pNome, String apelido, char sexo, String nrBI, String estadoCivil, String tel1, String tel2) {
        super(idPessoa, pNome, apelido, sexo, nrBI, estadoCivil, tel1, tel2);
        this.grauParentesco = grauParentesco;
    }

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }
    
    public String toString() {
        String format = "%-20s";
        return super.toString() + String.format(format, grauParentesco);
    }
}
