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

    public EncarregadoEducacao(Pessoa x, String grauParentesco){
        super(x);
        this.grauParentesco = grauParentesco;
    }
    
    public void update(Pessoa x, String grauParentesco) {
        update(x);
        this.grauParentesco = grauParentesco;
    }

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public String toString() {
        String format = "%-20s";
        return super.toString() + String.format(format, grauParentesco);
    }
}