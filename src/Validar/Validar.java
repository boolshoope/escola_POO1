/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validar;

import Objectos.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import static sistemagestaoescolar.Menu.vecAluno;
import static sistemagestaoescolar.Menu.vecAnoAcademico;
import static sistemagestaoescolar.Menu.vecClasse;
import static sistemagestaoescolar.Menu.vecDisciplina;
import static sistemagestaoescolar.Menu.vecEncarregado;
import static sistemagestaoescolar.Menu.vecProfessor;
import static sistemagestaoescolar.Menu.vecTurma;

/**
 *
 * @author isacl
 */
public class Validar {

    private static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static double numero(String guide, int min, int max) {
        double num = 0;
        do {
            System.out.print(guide);
            try {
                num = Double.parseDouble(rd.readLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IOException io) {
                System.out.println(io.getMessage());
            }
            if (num < min || num > max) {
                System.out.println("Informe correctamente o numero");
            }
        } while (num < min || num > max);
        return num;
    }

    public static String texto(String guide, int minLength) {
        String txt = "";
        do {
            System.out.print(guide);
            try {
                txt = rd.readLine();
            } catch (IOException io) {
                System.out.println(io.getMessage());
            }
            if (txt.isEmpty() || txt.length() < minLength) {
                System.out.println("Informe correctamente o texto");
            }
        } while (txt.isEmpty() || txt.length() < minLength);
        return txt;
    }

    //Gerar id automaticamente
    public static int GetIdPessoa() {
        /*
        id[0] - idPessoa referente ao aluno
        id[1] - idPessoa referente ao encarregado
        id[2] - idPessoa referente ao professor
         */
        int[] id = new int[3];

        if (vecAluno.isEmpty()) {
            id[0] = 0;
        } else {
            Aluno aluno = (Aluno) vecAluno.elementAt(vecAluno.size() - 1);
            id[0] = aluno.getIdPessoa();
        }

        if (vecEncarregado.isEmpty()) {
            id[1] = 0;
        } else {
            EncarregadoEducacao encEd = (EncarregadoEducacao) vecEncarregado.elementAt(vecEncarregado.size() - 1);
            id[1] = encEd.getIdPessoa();
        }

        if (vecProfessor.isEmpty()) {
            id[2] = 0;
        } else {
            Professor prof = (Professor) vecProfessor.elementAt(vecProfessor.size() - 1);
            id[2] = prof.getIdPessoa();
        }

        //Serve para saber qual eh o maior numero no array id
        IntSummaryStatistics stat = Arrays.stream(id).summaryStatistics();
        int max = stat.getMax() + 1;

        return max;
    }

    public static int GetNrEstudante() {
        int nrEstudante;
        if (vecAluno.isEmpty()) {
            return 1000;
        }
        Aluno aluno = (Aluno) vecAluno.elementAt(vecAluno.size() - 1);
        nrEstudante = aluno.getNrEstudante() + 1;

        return nrEstudante;
    }

    public static int GetIdAnoAcademico() {
        int idAnoAcademico;
        if (vecAnoAcademico.isEmpty()) {
            return 1;
        }
        AnoAcademico ano = (AnoAcademico) vecAnoAcademico.elementAt(vecAnoAcademico.size() - 1);
        idAnoAcademico = ano.getIdAnoAcademico() + 1;

        return idAnoAcademico;
    }

    public static int GetIdDisciplina() {
        int idDisciplina;
        if (vecDisciplina.isEmpty()) {
            return 1;
        }
        Disciplina disc = (Disciplina) vecDisciplina.elementAt(vecDisciplina.size() - 1);
        idDisciplina = disc.getIdDisciplina() + 1;

        return idDisciplina;
    }

    public static int GetIdClasse() {
        int idClasse;
        if (vecClasse.isEmpty()) {
            return 1;
        }
        Classe classe = (Classe) vecAnoAcademico.elementAt(vecAnoAcademico.size() - 1);
        idClasse = classe.getIdClasse() + 1;

        return idClasse;
    }

    public static int GetIdTurma() {
        int idTurma;
        if (vecTurma.isEmpty()) {
            return 1;
        }
        Turma turma = (Turma) vecTurma.elementAt(vecTurma.size() - 1);
        idTurma = turma.getIdTurma() + 1;

        return idTurma;
    }

    public static boolean VerificarIDClasse(int id) {
        Classe classe;
        boolean bool = false;
        for (int i = 0; i < vecClasse.size(); i++) {
            classe = (Classe) vecClasse.elementAt(i);
            if (id == classe.getIdClasse()) {
                bool = true;
            }
        }
        if (!bool) {
            System.out.println("Id Classe nao encontrado, introduza novamente");
        }
        return bool;
    }
}
