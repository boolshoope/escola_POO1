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
import static sistemagestaoescolar.Menu.vecMatricula;
import static sistemagestaoescolar.Menu.vecTeste;
import static sistemagestaoescolar.Menu.vecTurma;

/**
 *
 * @author isacl
 */
public class Visualizar {

    // <editor-fold defaultstate="collapsed" desc="Visualizar Notas Alunos">
    public static void VisualizarNotasTurmaAnoAcademico() {
        Turma turma;
        AnoAcademico ano;
        Matricula mat;
        Aluno aluno;
        Teste teste;
        Disciplina disc;

        int idTurma = 1, idAnoAcademico = 1;

        for (Object al : vecAluno) {
            aluno = (Aluno) al;
            for (Object m : vecMatricula) {
                mat = (Matricula) m;
                for (Object t : vecTeste) {
                    teste = (Teste) t;
                    for (Object d : vecDisciplina) {
                        disc = (Disciplina) d;
                        if (aluno.getNrEstudante() == mat.getNrEstudante() && teste.getIdDisciplina() == disc.getIdDisciplina()
                                && teste.getNrEstudante() == aluno.getNrEstudante() && teste.getIdAnoAcademico() == idAnoAcademico
                                && mat.getIdTurma() == idTurma && mat.getIdAnoAcademico() == idAnoAcademico) {
                            System.out.println(aluno.getpNome() + "  " + teste.getNota() + " " + disc.getNome());
                        }
                    }
                }
            }
        }
    }

    public static void VisualizarMediasNotaGlobal() {

    }

    public static void VisualizarNotasAlunoTrimestre() {

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Visualizar Outros Dados">
    public static void ViewAluno() {
        Aluno aluno;
        EncarregadoEducacao ed;
        boolean ctrl = true;

        for (int i = 0; i < vecAluno.size(); i++) {
            aluno = (Aluno) vecAluno.elementAt(i);
            if (ctrl) {
                String format = "%-15s %-12s %-14s %-20s %-12s %-20s %-20s %-20s %-20s %-20s";
                System.out.println(String.format(format, "nrEstudante", "idPessoa", "pNome", "apelido", "sexo", "nrBI", "estadoCivil",
                        "Telefone 1 & 2", "Data de Nascimento", "Nome do Encarregado"));
                ctrl = false;
            }
            for (int j = 0; j < vecEncarregado.size(); j++) {
                ed = (EncarregadoEducacao) vecEncarregado.elementAt(j);
                if (ed.getIdPessoa() == aluno.getIdEncarregadoEducacao()) {
                    System.out.println(aluno.toString(ed.getpNome() + " " + ed.getApelido()));
                }
            }
        }
    }

    public static void ViewEncarregadoEducacao() {
        EncarregadoEducacao ed;
        boolean ctrl = true;

        for (int i = 0; i < vecEncarregado.size(); i++) {
            ed = (EncarregadoEducacao) vecEncarregado.elementAt(i);
            if (ctrl) {
                String format = "%-12s %-15s %-20s %-12s %-20s %-20s %-20s %-20s";
                System.out.println(String.format(format, "idPessoa", "pNome", "apelido", "sexo", "nrBI", "estadoCivil",
                        "Telefone 1 & 2", "Grau Parentesco"));
                ctrl = false;
            }
            System.out.println(ed.toString());
        }
    }

    public static void ViewProfessor() {
        Professor prof;
        boolean ctrl = true;

        for (int i = 0; i < vecProfessor.size(); i++) {
            prof = (Professor) vecProfessor.elementAt(i);
            if (ctrl) {
                String format = "%-12s %-14s %-20s %-12s %-20s %-20s %-20s %-20s";
                System.out.println(String.format(format, "idPessoa", "pNome", "apelido", "sexo", "nrBI", "estadoCivil",
                        "Telefone 1 & 2", "Grau Academico"));
                ctrl = false;
            }
            System.out.println(prof.toString());
        }
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
