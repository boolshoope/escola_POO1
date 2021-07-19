/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes;

import static BaseDeDados.BD.GravarFichObj;
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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        }else if (esc == 2) {
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

    public static void AddTurma() {
        int id = Validar.GetIdTurma();
        System.out.println("ID: " + id);
        String nome = Validar.texto("Nome: ", 1);
        int maxAlunos = (int) Validar.numero("Numero maximo de alunos: ", 10, 99);
        int idClasse;
        do {
            idClasse = (int) Validar.numero("Id Classe: ", 1, 9999);
        } while (!Validar.VerificarIDClasse(idClasse));
        Turma turma = new Turma(id, nome, maxAlunos, idClasse);
        vecTurma.addElement(turma);
        vecTurma.trimToSize();
        System.out.println("Sucesso!!!");
    }

    public static void AddMatricula(int nrEst) {
        int idTurma, idAnoAcademico;
        do {
            idTurma = (int) Validar.numero("Id Turma: ", 1, 9999);
        } while (!Validar.VerificarIdTurma(idTurma));

        do {
            idAnoAcademico = (int) Validar.numero("Id AnoAcademico: ", 1, 9999);
        } while (!Validar.VerificarIdAnoAcademico(idAnoAcademico));

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
            idDisciplina = (int) Validar.numero("Id Classe: ", 1, 9999);
        } while (!Validar.VerificarIdDisciplina(idDisciplina));

        ClasseDiscProf cdp = new ClasseDiscProf(idClasse, idDisciplina, idProf);
        vecClasseDiscProf.addElement(cdp);
        vecClasseDiscProf.trimToSize();
        System.out.println("Sucesso!!!");
    }

    public static void AddTeste() {
        Teste test;
        int idTeste = Validar.GetIdTeste();
        float nota = (float) Validar.numero("Nota: ", 0, 20);
        String tipo = Validar.texto("Tipo: ", 2);
        String date = Validar.texto("Data de Realizacao(19/07/2021): ", 10);
        Date dataRealizacao = new Date();
        try {
            dataRealizacao = new SimpleDateFormat("dd/mm/yyyy").parse(date);
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }
        float peso = (float) Validar.numero("Peso: ", 0, 100);
        String comentario = Validar.texto("Comentario: ", 2);

        int idAnoAcademico, idDisciplina, nrEstudante;
        do {
            idAnoAcademico = (int) Validar.numero("Id Ano Academico: ", 1, 9999);
        } while (!Validar.VerificarIdAnoAcademico(idAnoAcademico));
        do {
            idDisciplina = (int) Validar.numero("Id Disciplina: ", 1, 9999);
        } while (!Validar.VerificarIdDisciplina(idDisciplina));
        do {
            nrEstudante = (int) Validar.numero("Id Estudante: ", 1, 9999);
        } while (!Validar.VerificarNrEstudante(nrEstudante));

        test = new Teste(idTeste, nota, tipo, dataRealizacao, peso, comentario, idAnoAcademico, idDisciplina, nrEstudante);
        vecTeste.addElement(test);
        vecTeste.trimToSize();
        System.out.println("Sucesso!!!");
    }
    // </editor-fold>

}
