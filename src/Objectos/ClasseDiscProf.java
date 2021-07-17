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
public class ClasseDiscProf {
    private int idClasse;
    private int idDisciplina;
    private int idProfessor;

    public ClasseDiscProf(int idClasse, int idDisciplina, int idProfessor) {
        this.idClasse = idClasse;
        this.idDisciplina = idDisciplina;
        this.idProfessor = idProfessor;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }
    
}
