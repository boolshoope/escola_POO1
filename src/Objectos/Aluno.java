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
public class Aluno extends Pessoa implements Serializable{

    private int nrEstudante;
    private Date dataNascimento;
    private int idEncarregadoEducacao;

    public Aluno(int nrEstudante, Date dataNascimento, int idEncarregadoEducacao, int idPessoa, String pNome, String apelido, char sexo, String nrBI, String estadoCivil, String tel1, String tel2) {
        super(idPessoa, pNome, apelido, sexo, nrBI, estadoCivil, tel1, tel2);
        this.nrEstudante = nrEstudante;
        this.dataNascimento = dataNascimento;
        this.idEncarregadoEducacao = idEncarregadoEducacao;
    }

    public int getNrEstudante() {
        return nrEstudante;
    }

    public void setNrEstudante(int nrEstudante) {
        this.nrEstudante = nrEstudante;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdEncarregadoEducacao() {
        return idEncarregadoEducacao;
    }

    public void setIdEncarregadoEducacao(int idEncarregadoEducacao) {
        this.idEncarregadoEducacao = idEncarregadoEducacao;
    }

    public String toString(String encEd) {
        String format1 = "%-20s", format2 = "%-20s %-20s";
        return String.format(format1, nrEstudante) + super.toString() + String.format(format2, dataNascimento, encEd);
    }
}
