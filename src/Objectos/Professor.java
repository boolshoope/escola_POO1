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

    public Professor(Pessoa x, String grauAcademico){
        super(x);
        this.grauAcademico = grauAcademico;
    }
    
    public void update(Pessoa x, String grauAcademico){
        update(x);
        this.grauAcademico = grauAcademico;
    }

    public String getGrauAcademico() {
        return grauAcademico;
    }

    public String toString() {
        String format = "%-20s";
        return super.toString() + String.format(format, grauAcademico);
    }

}