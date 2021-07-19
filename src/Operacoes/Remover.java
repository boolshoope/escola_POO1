/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes;

import Objectos.*;
import Validar.*;
import static sistemagestaoescolar.Menu.vecAluno;
import static sistemagestaoescolar.Menu.vecAnoAcademico;
import static sistemagestaoescolar.Menu.vecClasse;
import static sistemagestaoescolar.Menu.vecClasseDiscProf;
import static sistemagestaoescolar.Menu.vecDisciplina;
import static sistemagestaoescolar.Menu.vecEncarregado;
import static sistemagestaoescolar.Menu.vecMatricula;
import static sistemagestaoescolar.Menu.vecProfessor;
import static sistemagestaoescolar.Menu.vecTurma;
import static sistemagestaoescolar.Menu.vecTeste;

/**
 *
 * @author isacl
 */
public class Remover {

    public static void DelAluno() {
        int nrEstudante;

        nrEstudante = (int) Validar.numero("Numero de estudante: ", 100, 9999);

        rmAluno(nrEstudante);
    }

    public static void rmAluno(int nrEstudante) {
        Aluno tmp;
        Teste t;
        Matricula m;
        int pos;

        pos = -1;
        for (int i = 0; i < vecAluno.size(); i++) {
            tmp = (Aluno) vecAluno.elementAt(i);
            if (tmp.getNrEstudante() == nrEstudante) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("Estudante nao encontrado.");
            return;
        }

        vecAluno.removeElementAt(pos);
        vecAluno.trimToSize();

        for (int i = 0; i < vecTeste.size(); i++) {
            t = (Teste) vecTeste.elementAt(i);
            if (t.getNrEstudante() == nrEstudante) {
                vecTeste.removeElementAt(i);
                vecTeste.trimToSize();
            }
        }

        for (int i = 0; i < vecMatricula.size(); i++) {
            m = (Matricula) vecMatricula.elementAt(i);
            if (m.getNrEstudante() == nrEstudante) {
                vecMatricula.removeElementAt(i);
                vecMatricula.trimToSize();
            }
        }
    }

    public static void DelProfessor() {
        Professor tmp;
        int id, pos;

        id = (int) Validar.numero("ID(professor): ", 1, 9999);

        pos = -1;
        for (int i = 0; i < vecProfessor.size(); i++) {
            tmp = (Professor) vecProfessor.elementAt(i);
            if (tmp.getIdPessoa() == id) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("Professor nao encontrado.");
            return;
        }

        vecProfessor.removeElementAt(pos);
        vecProfessor.trimToSize();
    }

    public static void DelDisciplina() {
        int id;

        id = (int) Validar.numero("ID(disciplina): ", 1, 9999);

        rmDisciplina(id);
    }

    public static void rmDisciplina(int id) {
        Teste t;
        Disciplina tmp;
        int pos;

        pos = -1;
        for (int i = 0; i < vecDisciplina.size(); i++) {
            tmp = (Disciplina) vecDisciplina.elementAt(i);
            if (tmp.getIdDisciplina() == id) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("Disciplina nao encontrada.");
            return;
        }

        vecDisciplina.removeElementAt(pos);
        vecDisciplina.trimToSize();

        for (int i = 0; i < vecTeste.size(); i++) {
            t = (Teste) vecTeste.elementAt(i);
            if (t.getIdDisciplina() == id) {
                vecTeste.removeElementAt(i);
                vecTeste.trimToSize();
            }
        }
    }

    public static void DelClasse() {
        int id;

        id = (int) Validar.numero("ID(Classe): ", 1, 9999);

        rmClasse(id);
    }

    public static void rmClasse(int id) {
        ClasseDiscProf cdp;
        Classe tmp;
        Turma t;
        int pos;

        pos = -1;
        for (int i = 0; i < vecClasse.size(); i++) {
            tmp = (Classe) vecClasse.elementAt(i);
            if (tmp.getIdClasse() == id) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("Classe nao encontrada.");
            return;
        }

        vecClasse.removeElementAt(pos);
        vecClasse.trimToSize();

        for (int i = 0; i < vecClasseDiscProf.size(); i++) {
            cdp = (ClasseDiscProf) vecClasseDiscProf.elementAt(i);
            if (cdp.getIdClasse() == id) {
                rmDisciplina(cdp.getIdDisciplina());
                vecClasseDiscProf.removeElementAt(i);
                vecClasseDiscProf.trimToSize();
            }
        }

        for (int i = 0; i < vecTurma.size(); i++) {
            t = (Turma) vecTurma.elementAt(i);
            if (t.getIdClasse() == id) {
                rmTurma(t.getIdTurma());
            }
        }
    }

    public static void DelTurma() {
        int id;

        id = (int) Validar.numero("ID(turma): ", 1, 9999);

        rmTurma(id);
    }

    public static void rmTurma(int id) {
        Turma tmp;
        Matricula m;
        int pos;

        pos = -1;
        for (int i = 0; i < vecTurma.size(); i++) {
            tmp = (Turma) vecTurma.elementAt(i);
            if (tmp.getIdTurma() == id) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("Turma nao encontrada.");
            return;
        }

        vecTurma.removeElementAt(pos);
        vecTurma.trimToSize();

        for (int i = 0; i < vecMatricula.size(); i++) {
            m = (Matricula) vecMatricula.elementAt(i);
            if (m.getIdTurma() == id) {
                rmAluno(m.getNrEstudante());
            }
        }
    }

    public static void DelEncaregado() {
        EncarregadoEducacao tmp;
        int id, pos;

        id = (int) Validar.numero("ID(encarregado): ", 1, 9999);

        pos = -1;
        for (int i = 0; i < vecEncarregado.size(); i++) {
            tmp = (EncarregadoEducacao) vecEncarregado.elementAt(i);
            if (tmp.getIdPessoa() == id) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("Encarregado nao encontradao");
            return;
        }

        vecEncarregado.removeElementAt(pos);
        vecEncarregado.trimToSize();
    }
}
