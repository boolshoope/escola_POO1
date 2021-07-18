/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes;

import Objectos.*;
import static sistemagestaoescolar.Menu.vecAluno;
import static sistemagestaoescolar.Menu.vecProfessor;
import static sistemagestaoescolar.Menu.vecEncarregado;
import static sistemagestaoescolar.Menu.vecAnoAcademico;
import static sistemagestaoescolar.Menu.vecDisciplina;
import static sistemagestaoescolar.Menu.vecClasse;
import static sistemagestaoescolar.Menu.vecTurma;

/**
 *
 * @author isacl
 */
public class Visualizar {
    // <editor-fold defaultstate="collapsed" desc="Visualizar Notas Alunos">
    public static void VisualizarNotasTurmaAnoAcademico() {

    }

    public static void VisualizarMediasNotaGlobal() {

    }

    public static void VisualizarNotasAlunoTrimestre() {

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Visualizar Outros Dados">
    public static void ViewPessoa(String aux) {
        
    }

    public static void ViewAnoAcademico() {
        AnoAcademico ano;
        boolean ctrl = true;

        for (int i = 0; i < vecAnoAcademico.size(); i++) {
            ano = (AnoAcademico) vecAnoAcademico.elementAt(i);
            if (ctrl) {
                String format = "%-20s %-20s %-20s";
                System.out.println(String.format(format, "idAnoAcademico", "Ano", "Trimestre"));
                ctrl = false;
            }
            System.out.println(ano.toString());
        }
    }

    public static void ViewDisciplina() {
        Disciplina disc;
        boolean ctrl = true;

        for (int i = 0; i < vecDisciplina.size(); i++) {
            disc = (Disciplina) vecDisciplina.elementAt(i);
            if (ctrl) {
                String format = "%-20s %-20s";
                System.out.println(String.format(format, "idDisciplina", "Nome"));
                ctrl = false;
            }
            System.out.println(disc.toString());
        }
    }

    public static void ViewClasse() {
        Classe classe;
        boolean ctrl = true;

        for (int i = 0; i < vecClasse.size(); i++) {
            classe = (Classe) vecClasse.elementAt(i);
            if (ctrl) {
                String format = "%-20s %-20s";
                System.out.println(String.format(format, "idClasse", "Nome"));
                ctrl = false;
            }
            System.out.println(classe.toString());
        }
    }

    public static void ViewTurma() {
        Turma turma;
        Classe classe;
        boolean ctrl = true;

        for (int i = 0; i < vecTurma.size(); i++) {
            turma = (Turma) vecTurma.elementAt(i);
            if (ctrl) {
                String format = "%-20s %-20s %-20s %-20s";
                System.out.println(String.format(format, "idTurma", "Nome", "Maximo de alunos", "Classe"));
                ctrl = false;
            }
            for (int j = 0; j < vecClasse.size(); j++) {
                classe = (Classe) vecClasse.elementAt(j);
                if (classe.getIdClasse() == turma.getIdClasse()) {
                    System.out.println(turma.toString(classe.getNome()));
                }
            }
        }
    }
    // </editor-fold>
}
