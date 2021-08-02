/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes;

import Objectos.*;
import Validar.Validar;
import java.util.Vector;
import static sistemagestaoescolar.Menu.*;

/**
 *
 * @author isacl
 */
public class Visualizar {

    // <editor-fold defaultstate="collapsed" desc="Visualizar Notas Alunos">
    public static void VisualizarNotasTurmaAnoAcademico() {
        Matricula mat;
        Aluno aluno;
        Teste teste;
        Disciplina disc;
        boolean ctrl = true;
        String format = "%-20s %-20s";

        int idTurma, idAnoAcademico, ano;

        do {
            idTurma = (int) Validar.numero("Id Turma: ", 1, 9999);
        } while (!Validar.VerificarIdTurma(idTurma));

        do {
            ano = (int) Validar.numero("Ano Lectivo: ", 2000, 3000);
        } while (Validar.VerificarAnoLectivo(ano) == -1);
        idAnoAcademico = Validar.VerificarAnoLectivo(ano);

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

                            if (ctrl) {
                                format = "%-20s %-15s %-15s %-15s %-15s";
                                System.out.println(String.format(format, "Nome do Aluno", "Nota", "Disciplina", "Tipo do teste", "Peso"));
                                ctrl = false;
                            }
                            System.out.println(String.format(format, aluno.getpNome() + " " + aluno.getApelido(), teste.getNota(), disc.getNome(),
                                    teste.getTipo(), teste.getPeso() + "%"));
                        }
                    }
                }
            }
        }
    }

    public static void VisualizarMediasNotaGlobal() {
        Matricula mat;
        Teste teste;
        Disciplina disc;
        Turma turma;
        ClasseDiscProf cdp;
        AnoAcademico ac;
        int ano = 2020, idAno, nrEstudante, idTurma = 0, idClasse = 0, countDisc = 0, countTrim = 3, mediaF = 0;

        Vector vecDiscCod = new Vector(), vecDiscNome = new Vector();
        int[][] medTrim;
        int media[];
        String format;

        do {
            nrEstudante = (int) Validar.numero("Nr Estudante: ", 100, 9999);
        } while (!Validar.VerificarNrEstudante(nrEstudante));

        do {
            ano = (int) Validar.numero("Ano Lectivo: ", 2000, 3000);
        } while (Validar.VerificarAnoLectivo(ano) == -1);
        idAno = Validar.VerificarAnoLectivo(ano);

        //Obter o idTurma
        for (Object m : vecMatricula) {
            mat = (Matricula) m;
            if (mat.getNrEstudante() == nrEstudante && mat.getIdAnoAcademico() == idAno) {
                idTurma = mat.getIdTurma();
            }
        }

        //Obter o idTurma
        for (Object t : vecTurma) {
            turma = (Turma) t;
            if (turma.getIdTurma() == idTurma) {
                idClasse = turma.getIdClasse();
            }
        }

        //obter as disciplinas que o aluno fez no ano academico
        for (Object t : vecClasseDiscProf) {
            cdp = (ClasseDiscProf) t;
            for (Object d : vecDisciplina) {
                disc = (Disciplina) d;
                if (cdp.getIdClasse() == idClasse && cdp.getIdDisciplina() == disc.getIdDisciplina()) {
                    vecDiscCod.addElement(cdp.getIdDisciplina());
                    vecDiscCod.trimToSize();
                    vecDiscNome.addElement(disc.getNome());
                    vecDiscNome.trimToSize();
                    countDisc++;
                }
            }
        }

        medTrim = new int[countDisc][countTrim];
        int vecDiscPos = 0;
        for (Object t : vecTeste) {
            teste = (Teste) t;
            for (Object a : vecAnoAcademico) {
                ac = (AnoAcademico) a;
                if (teste.getNrEstudante() == nrEstudante && vecDiscCod.contains(teste.getIdDisciplina()) && ac.getIdAnoAcademico() == teste.getIdAnoAcademico()) {
                    for (int i = 0; i < vecDiscCod.size(); i++) {
                        if ((int) vecDiscCod.elementAt(i) == teste.getIdDisciplina()) {
                            vecDiscPos = i;
                        }
                    }
                    medTrim[vecDiscPos][ac.getTrimestre() - 1] += (teste.getNota() * (int) teste.getPeso()) / 100;
                }
            }
        }

        //calcular a media global
        media = new int[countDisc];
        for (int i = 0; i < medTrim.length; i++) {
            for (int j = 0; j < medTrim[i].length; j++) {
                media[i] += medTrim[i][j];
            }
            media[i] /= medTrim[i].length;
            mediaF += media[i];
        }
        mediaF /= medTrim.length;

        System.out.println("Medias Globais");
        format = "%-20s %-20s";
        System.out.println(String.format(format, "Disciplina", "Nota"));
        for (int i = 0; i < media.length; i++) {
            System.out.println(String.format(format, vecDiscNome.elementAt(i), media[i]));
        }
        System.out.println("Media final: " + mediaF);
    }

    public static void VisualizarNotasAlunoTrimestre() {
        Matricula mat;
        Teste teste;
        Aluno aluno;
        Disciplina disc;
        boolean ctrl = true;
        String format = "%-20s %-20s";

        int nrEst, ano, trimestre, idTrimestre;

        do {
            nrEst = (int) Validar.numero("Nr Estudante: ", 100, 9999);
        } while (!Validar.VerificarNrEstudante(nrEst));

        do {
            ano = (int) Validar.numero("Ano Lectivo: ", 2000, 3000);
        } while (Validar.VerificarAnoLectivoT(ano) == -1);

        do {
            trimestre = (int) Validar.numero("Trimestre: ", 1, 3);
        } while (Validar.VerificarTrimestre(trimestre, ano) == -1);
        idTrimestre = Validar.VerificarTrimestre(trimestre, ano);

        for (Object al : vecAluno) {
            aluno = (Aluno) al;
            for (Object m : vecMatricula) {
                mat = (Matricula) m;
                for (Object t : vecTeste) {
                    teste = (Teste) t;
                    for (Object d : vecDisciplina) {
                        disc = (Disciplina) d;
                        if (nrEst == mat.getNrEstudante() && teste.getIdDisciplina() == disc.getIdDisciplina() && teste.getNrEstudante() == nrEst
                                && teste.getIdAnoAcademico() == idTrimestre && mat.getIdAnoAcademico() == idTrimestre
                                && aluno.getNrEstudante() == nrEst) {

                            if (ctrl) {
                                System.out.println("Nome: " + aluno.getpNome() + " " + aluno.getApelido());
                                format = "%-20s %-15s %-15s %-15s %-15s";
                                System.out.println(String.format(format, "Disciplina", "Nota", "Tipo do teste", "Peso", "Trimestre"));
                                ctrl = false;
                            }
                            System.out.println(String.format(format, disc.getNome(), teste.getNota(), teste.getTipo(),
                                    teste.getPeso() + "%", trimestre));
                        }
                    }
                }
            }
        }
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
                String format = "%-15s %-12s %-14s %-20s %-12s %-20s %-20s %-25s %-20s %-20s";
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
                String format = "%-12s %-15s %-20s %-12s %-20s %-20s %-25s %-20s";
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
                String format = "%-12s %-14s %-20s %-12s %-20s %-20s %-25s %-20s";
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
    
    public static void viewAlunoProf() {
        ClasseDiscProf cdp;
        Professor prof;
        int idClasse;
        String format =  "%-20 %-20 %-20";
        boolean ctrl = true;
        
        do {
            idClasse =(int) Validar.numero("ID(Classe) do aluno: ",1,99999999);
        }while(!Validar.VerificarIDClasse(idClasse));
        
        for(int i=0;i<vecClasseDiscProf.size();i++) {
            cdp = (ClasseDiscProf) vecClasseDiscProf.elementAt(i);
            if(cdp.getIdClasse() != idClasse)
                continue;
            for(int j=0;j<vecProfessor.size();j++) {
                prof = (Professor) vecProfessor.elementAt(j);
                if(prof.getIdPessoa() != cdp.getIdProfessor())
                    continue;
                if(ctrl) {
                    System.out.println(String.format(format,"Nome", "Apelido","Grau Academico"));
                    ctrl = false;
                }
                
                System.out.println(String.format(format,prof.getpNome(),prof.getApelido(),prof.getGrauAcademico()));
            }
        }
    }
    
    public static void viewDiscEst() {
        Disciplina d;
        ClasseDiscProf cdp;
        int idClasse;
        String format = "%-20";
        boolean ctrl = true;
        
        do {
            idClasse =(int) Validar.numero("ID(Classe) do aluno: ",1,99999999);
        }while(!Validar.VerificarIDClasse(idClasse));
        
        for(int i=0;i<vecClasseDiscProf.size();i++) {
            cdp = (ClasseDiscProf) vecClasseDiscProf.elementAt(i);
            if(cdp.getIdClasse() != idClasse)
                continue;
            for(int j=0;j<vecDisciplina.size();j++){
                d =(Disciplina) vecDisciplina.elementAt(j);
                if(cdp.getIdDisciplina() != d.getIdDisciplina())
                    continue;
                if(ctrl) {
                    System.out.println(String.format(format,"Nome"));
                    ctrl = false;
                }
                System.out.println(String.format(format,d.getNome()));
            }
        }
    }
    
    public static void viewProfDisc() {
        Disciplina d;
        ClasseDiscProf cdp;
        int idProf;
        String format = "%-20";
        boolean ctrl = true;
        
        do {
            idProf =(int) Validar.numero("ID(Classe) do aluno: ",1,99999999);
        }while(!Validar.VerificarIDClasse(idProf));
        
        for(int i=0;i<vecClasseDiscProf.size();i++) {
            cdp = (ClasseDiscProf) vecClasseDiscProf.elementAt(i);
            if(cdp.getIdProfessor() != idProf)
                continue;
            for(int j=0;j<vecDisciplina.size();j++){
                d =(Disciplina) vecDisciplina.elementAt(j);
                if(cdp.getIdDisciplina() != d.getIdDisciplina())
                    continue;
                if(ctrl) {
                    System.out.println(String.format(format,"Nome"));
                    ctrl = false;
                }
                System.out.println(String.format(format,d.getNome()));
            }
        }
    }
}