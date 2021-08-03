/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objectos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author isacl
 */
public class Aluno extends Pessoa implements Serializable{

    private int nrEstudante;
    private Date dataNascimento;
    private int idEncarregadoEducacao;

    public Aluno(Pessoa x, int nrEstudante, Date dataNascimento, int idEncarregadoEducacao) {
        super(x);
        this.nrEstudante = nrEstudante;
        this.dataNascimento = dataNascimento;
        this.idEncarregadoEducacao = idEncarregadoEducacao;
    }
    
    public void update(Pessoa x, Date dataNascimento) {
        update(x);
        this.dataNascimento = dataNascimento;
    }

    public int getNrEstudante() {
        return nrEstudante;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public int getIdEncarregadoEducacao() {
        return idEncarregadoEducacao;
    }

    public String toString(String encEd) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(dataNascimento);
        String format1 = "%-15s", format2 = "%-20s %-20s";
        return String.format(format1, nrEstudante) + super.toString() + String.format(format2, strDate, encEd);
    }
}