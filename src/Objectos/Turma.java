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
public class Turma implements Serializable{

    private int idTurma;
    private String nome;
    private int maxAlunos;
    private int idClasse;

    public Turma(int idTurma, String nome, int maxAlunos, int idClasse) {
        this.idTurma = idTurma;
        this.nome = nome;
        this.maxAlunos = maxAlunos;
        this.idClasse = idClasse;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMaxAlunos() {
        return maxAlunos;
    }

    public void setMaxAlunos(int maxAlunos) {
        this.maxAlunos = maxAlunos;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String toString(String classe) {
        String format = "%-20s %-20s %-20s %-20s";
        return String.format(format, idTurma, nome, maxAlunos, classe);
    }
}
