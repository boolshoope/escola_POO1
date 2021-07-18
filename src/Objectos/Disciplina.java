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
public class Disciplina implements Serializable{
    private int idDisciplina;
    private String nome;

    public Disciplina(int idDisciplina, String nome) {
        this.idDisciplina = idDisciplina;
        this.nome = nome;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String toString(){
        String format = "%-20s %-20s";
        return String.format(format, idDisciplina, nome);
    }
}
