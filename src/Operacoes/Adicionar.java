/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes;

import Objectos.Aluno;
import Objectos.AnoAcademico;
import Objectos.Classe;
import Objectos.ClasseDiscProf;
import Objectos.Disciplina;
import Objectos.EncarregadoEducacao;
import Objectos.Matricula;
import Objectos.Pessoa;
import Objectos.Professor;
import Objectos.Teste;
import Objectos.Turma;
import Validar.Validar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import static sistemagestaoescolar.Menu.vecMatricula;
import static sistemagestaoescolar.Menu.vecAluno;
import static sistemagestaoescolar.Menu.vecAnoAcademico;
import static sistemagestaoescolar.Menu.vecClasse;
import static sistemagestaoescolar.Menu.vecClasseDiscProf;
import static sistemagestaoescolar.Menu.vecDisciplina;
import static sistemagestaoescolar.Menu.vecProfessor;
import static sistemagestaoescolar.Menu.vecEncarregado;
import static sistemagestaoescolar.Menu.vecTeste;
import static sistemagestaoescolar.Menu.vecTurma;

/**
 *
 * @author isacl
 */
public class Adicionar {

    public static void MatricularAluno() {
        Pessoa x;
        Date dt = new Date();
        x = addPessoa();
        int nrEstudante = Validar.GetNrEstudante();
        System.out.println("Numero de Estudante: " + nrEstudante);
        String date = Validar.texto("Data de Nascimento(19/07/2021): ", 10);
        try {
            dt = new SimpleDateFormat("dd/mm/yyyy").parse(date);
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }
        int idEnc = (int) Validar.numero("ID encarregado: ", 1, 9999);

        // Caso o id do encarregado nao existir o aluno tem que registrar o encarregado.
        if (!verificarIDEncarregado(idEnc)) {
            System.out.println("O encarregado ainda nao foi registrado!\nPor favor registe o encarregado...");
            idEnc = registrarEnc();
        }

        // Criar uma matricula para o aluno
        System.out.println("Dados da Matricula do Estudante");
        AddMatricula(nrEstudante);

        Aluno al = new Aluno(x, nrEstudante, dt, idEnc);

        vecAluno.addElement(al);
        vecAluno.trimToSize();
        System.out.println("Sucesso!!!");
    }

    public static void AddProfessor() {
        Pessoa x;
        x = addPessoa();
        String grau = Validar.texto("Grau Academico: ", 3);
        Professor prof = new Professor(x, grau);

        vecProfessor.addElement(prof);
        vecProfessor.trimToSize();
    }

    static int registrarEnc() {
        Pessoa x;
        x = addPessoa();
        x.setIdPessoa(x.getIdPessoa() + 1);
        String parentesco = Validar.texto("Grau de Parentesco: ", 3);
        EncarregadoEducacao enc = new EncarregadoEducacao(x, parentesco);

        vecEncarregado.addElement(enc);
        vecEncarregado.trimToSize();

        return enc.getIdPessoa();
    }

    private static boolean verificarIDEncarregado(int id) {
        EncarregadoEducacao tmp;
        for (int i = 0; i < vecEncarregado.size(); i++) {
            tmp = (EncarregadoEducacao) vecEncarregado.elementAt(i);
            if (id == tmp.getIdPessoa()) {
                return true;
            }
        }
        return false;
    }

    static Pessoa addPessoa() {
        int id = Validar.GetIdPessoa();
        System.out.println("ID: " + id);
        String nome = Validar.texto("Nome: ", 4);
        String apelido = Validar.texto("Apelido: ", 4);
        System.out.println("Escolha o sexo:");
        System.out.println("1. Masculino");
        System.out.println("2. Feminino");
        int esc = (int) Validar.numero("->", 1, 2);
        char sexo = '-';
        if (esc == 1) {
            sexo = 'M';
        } else if (esc == 2) {
            sexo = 'F';
        }

        String nrBI = Validar.texto("BI: ", 4);
        String estadoCivil = Validar.texto("Estado civil: ", 4);
        String tell1 = Validar.texto("Telefone 1: ", 9);
        String tell2 = Validar.texto("Telefone 2: ", 9);

        Pessoa x = new Pessoa(id, nome, apelido, sexo, nrBI, estadoCivil, tell1, tell2);
        return x;
    }

    public static void AddAnoAcademico() {
        int id = Validar.GetIdAnoAcademico();
        System.out.println("ID: " + id);
        int ano = (int) Validar.numero("Ano: ", 2000, 3000);
        int trimestre = (int) Validar.numero("Trimestre: ", 1, 3);

        AnoAcademico anoAc = new AnoAcademico(id, ano, trimestre);
        vecAnoAcademico.addElement(anoAc);
        vecAnoAcademico.trimToSize();
        System.out.println("Sucesso!!!");
    }

    public static void AddDisciplina() {
        int id = Validar.GetIdDisciplina();
        System.out.println("ID: " + id);
        String nome = Validar.texto("Nome: ", 4);

        Disciplina disc = new Disciplina(id, nome);
        vecDisciplina.addElement(disc);
        vecDisciplina.trimToSize();
        System.out.println("Sucesso!!!");
    }

    public static void AddClasse() {
        int id = Validar.GetIdClasse();
        System.out.println("ID: " + id);
        String nome = Validar.texto("Nome: ", 1);

        Classe classe = new Classe(id, nome);
        vecClasse.addElement(classe);
        vecClasse.trimToSize();
        System.out.println("Sucesso!!!");
    }

    public static void Turma() {
        int idClasse;

        do {
            idClasse = (int) Validar.numero("Id Classe: ", 1, 9999);
        } while (!Validar.VerificarIDClasse(idClasse));

        AddTurma(idClasse);
        System.out.println("Sucesso!");
    }

    private static int AddTurma(int idClasse) {
        int id = Validar.GetIdTurma();
        System.out.println("ID Turma: " + id);
        String nome = Validar.texto("Nome: ", 1);
        int maxAlunos = (int) Validar.numero("Capacidade maxima da turma: ", 1, 99);
        Turma turma = new Turma(id, nome, maxAlunos, idClasse);
        vecTurma.addElement(turma);
        vecTurma.trimToSize();
        System.out.println("Sucesso!!!");
        return id;
    }

    public static int classeTurma(int idAno, int idClasse) {
        Vector vecT = new Vector();
        Turma turma;
        Matricula mat;
        int index = -1, countT = 0;

        for (int i = 0; i < vecTurma.size(); i++) {
            turma = (Turma) vecTurma.elementAt(i);
            if (idClasse == turma.getIdClasse()) {
                vecT.addElement(turma);
                vecT.trimToSize();
            }
        }

        for (int i = 0; i < vecT.size(); i++) {
            countT = 0;
            turma = (Turma) vecT.elementAt(i);
            for (int j = 0; j < vecMatricula.size(); j++) {
                mat = (Matricula) vecMatricula.elementAt(j);
                if (turma.getIdTurma() == mat.getIdTurma() && idAno == mat.getIdAnoAcademico()) {
                    countT++;
                }
                if (countT == turma.getMaxAlunos()) {
                    break;
                }
            }
            index = turma.getIdTurma();
            return index;
        }
        return index;
    }

    private static int indTurma(int idTurma) {
        Turma turma;
        int index = -1;
        for (int i = 0; i < vecTurma.size(); i++) {
            turma = (Turma) vecTurma.elementAt(i);
            if (turma.getIdTurma() == idTurma) {
                index = i;
            }
        }
        return index;
    }

    public static void AddMatricula(int nrEst) {
        Turma turma;
        int idTurma, idAnoAcademico, idClasse, index;

        do {
            idAnoAcademico = (int) Validar.numero("Id AnoAcademico: ", 1, 9999);
        } while (!Validar.VerificarIdAnoAcademico(idAnoAcademico));

        do {
            idClasse = (int) Validar.numero("Id Classe: ", 1, 9999);
        } while (!Validar.VerificarIDClasse(idClasse));

        if ((index = classeTurma(idAnoAcademico, idClasse)) == -1) {
            idTurma = AddTurma(idClasse);
            index = indTurma(idTurma);
            turma = (Turma) vecTurma.elementAt(index);
        } else {
            //turma = (Turma) vecTurma.elementAt(index);
            idTurma = index;
        }

        //turma.addAluno();
        //vecTurma.setElementAt(turma, index);
        Matricula mat = new Matricula(nrEst, idTurma, idAnoAcademico);
        vecMatricula.addElement(mat);
        vecMatricula.trimToSize();
        System.out.println("Sucesso!!!");
    }

    // <editor-fold defaultstate="collapsed" desc="Renovar Matricula/Alocar">
    public static void RenovarMatricula() {
        int nrEst;
        do {
            nrEst = (int) Validar.numero("Nr Estudante: ", 100, 9999);
        } while (!Validar.VerificarNrEstudante(nrEst));
        AddMatricula(nrEst);
    }

    public static void Alocar() {
        int idProf, idClasse, idDisciplina;
        do {
            idProf = (int) Validar.numero("Id Professor: ", 1, 9999);
        } while (!Validar.VerificarIdProfessor(idProf));

        do {
            idClasse = (int) Validar.numero("Id Classe: ", 1, 9999);
        } while (!Validar.VerificarIDClasse(idClasse));

        do {
            idDisciplina = (int) Validar.numero("Id Disciplina: ", 1, 9999);
        } while (!Validar.VerificarIdDisciplina(idDisciplina));

        ClasseDiscProf cdp = new ClasseDiscProf(idClasse, idDisciplina, idProf);
        vecClasseDiscProf.addElement(cdp);
        vecClasseDiscProf.trimToSize();
        System.out.println("Sucesso!!!");
    }

    public static void AddTeste() {
        Teste test;
        Matricula mat;
        Aluno aluno;
        Turma turma;
        int idDisciplina, ano, trimestre, idTrimestre, idClasse;
        int idTeste = Validar.GetIdTeste();
        /*
        tipo,peso,dataRealizacao,idAnoAcademico,idDisciplina
         */
        String tipo = Validar.texto("Tipo: ", 2);
        float peso = (float) Validar.numero("Peso: ", 0, 100);
        String date = Validar.texto("Data de Realizacao(19/07/2021): ", 10);
        Date dataRealizacao = new Date();
        try {
            dataRealizacao = new SimpleDateFormat("dd/mm/yyyy").parse(date);
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }
        do {
            ano = (int) Validar.numero("Ano Lectivo: ", 2000, 3000);
        } while (Validar.VerificarAnoLectivoT(ano) == -1);
        do {
            trimestre = (int) Validar.numero("Trimestre: ", 1, 3);
        } while (Validar.VerificarTrimestre(trimestre, ano) == -1);
        idTrimestre = Validar.VerificarTrimestre(trimestre, ano);
        do {
            idClasse = (int) Validar.numero("Id Classe: ", 1, 9999);
        } while (!Validar.VerificarIDClasse(idClasse));
        do {
            idDisciplina = (int) Validar.numero("Id Disciplina: ", 1, 9999);
        } while (!Validar.VerificarIdDisciplina(idDisciplina, idClasse));
        
        for (Object al : vecAluno) {
            aluno = (Aluno) al;
            for (Object m : vecMatricula) {
                mat = (Matricula) m;
                for (Object tu : vecTurma) {
                    turma = (Turma) tu;
                    if (aluno.getNrEstudante() == mat.getNrEstudante() && mat.getIdAnoAcademico() == idTrimestre
                            && turma.getIdClasse() == idClasse && turma.getIdTurma() == mat.getIdTurma()) {
                        System.out.println("Nome do aluno: " + aluno.getpNome() + " " + aluno.getApelido());
                        float nota = (float) Validar.numero("Nota: ", 0, 20);
                        String comentario = Validar.texto("Comentario: ", 2);
                        test = new Teste(idTeste, nota, tipo, dataRealizacao, peso, comentario, idTrimestre, idDisciplina, aluno.getNrEstudante());
                        vecTeste.addElement(test);
                        vecTeste.trimToSize();
                        idTeste++;
                    }
                }
            }
        }

        System.out.println("Sucesso!!!");
    }
    // </editor-fold>

}
