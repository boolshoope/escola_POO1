/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemagestaoescolar;

import Objectos.*;
import Validar.Validar;
import java.util.Vector;

/**
 *
 * @author isacl
 */
public class SistemaGestaoEscolar {

    /**
     * @param args the command line arguments
     */
    static String nomeFich[] = {"aluno","professor"};
    
    static Vector vecAnoAcademico, vecDisciplina, vecClasse, vecTurma;

    public static void main(String[] args) {
        // TODO code application logic here
        int opEsc;
        System.out.println("|*********** Sistema de Gestão de uma Escola ***********|");

        do {
            System.out.println("|*********** MENU PRINCIPAL ***********|");
            System.out.println("Selecione a opção:");
            System.out.println("1. Operações básicas");
            System.out.println("2. Alocar/Renovação de Matricula");
            System.out.println("3. Visualizar notas dos alunos");
            System.out.println("4. Visualizar outros dados");
            System.out.println("5. Sair");

            opEsc = (int) Validar.numero("-> ", 1, 5);

            switch (opEsc) {
                case 1:
                    System.out.println("|**** Operações básicas ****|");
                    Menu.MainCase1();
                    break;
                case 2:
                    System.out.println("\n|**** Alocar/Renovação de Matricula ****|");
                    Menu.MainCase2();
                    break;
                case 3:
                    System.out.println("\n|**** Visualizar notas dos alunos ****|");
                    Menu.MainCase3();
                    break;
                case 4:
                    System.out.println("\n|**** Visualizar outros dados ****|");
                    Menu.MainCase4();
                    break;
                case 5:
                    System.out.println("Obrigado.");
                    System.exit(0);
                    break;
            }
            System.out.println("");
        } while (opEsc != 5);
    }

    // <editor-fold defaultstate="collapsed" desc="Adicionar">
    static void MatricularAluno() {
        
    }

    static void AddPessoa(String aux) {

    }

    static void AddAnoAcademico() {

    }

    static void AddDisciplina() {

    }

    static void AddClasse() {

    }

    static void AddTurma() {

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Editar">
    static void EditPessoa(String aux) {

    }

    static void EditAnoAcademico() {

    }

    static void EditDisciplina() {

    }

    static void EditClasse() {

    }

    static void EditTurma() {

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Remover">
    static void DelPessoa(String aux) {

    }

    static void DelAnoAcademico() {

    }

    static void DelDisciplina() {

    }

    static void DelClasse() {

    }

    static void DelTurma() {

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Renovar Matricula/Alocar">
    static void RenovarMatricula() {

    }

    static void Alocar() {

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Visualizar Notas Alunos">
    static void VisualizarNotasTurmaAnoAcademico() {

    }

    static void VisualizarMediasNotaGlobal() {

    }

    static void VisualizarNotasAlunoTrimestre() {

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Visualizar Outros Dados">
    static void ViewPessoa(String aux) {

    }

    static void ViewAnoAcademico() {
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

    static void ViewDisciplina() {
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

    static void ViewClasse() {
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

    static void ViewTurma() {
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
                classe = (Classe)vecClasse.elementAt(j);
                if (classe.getIdClasse()== turma.getIdClasse()) {
                    System.out.println(turma.toString(classe.getNome()));
                }
            }
        }
    }
    // </editor-fold>
}
