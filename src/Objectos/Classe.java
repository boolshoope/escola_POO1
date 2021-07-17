/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objectos;

/**
 *
 * @author isacl
 */
public class Classe {
    //, 
    private int idClasse;
    private String nome;

    public Classe(int idClasse, String nome) {
        this.idClasse = idClasse;
        this.nome = nome;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String toString(){
        String format = "%-20s %-20s";
        return String.format(format, idClasse, nome);
    }
}
