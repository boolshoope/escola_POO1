/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes;

import Objectos.Aluno;
import Objectos.EncarregadoEducacao;
import Objectos.Pessoa;
import Objectos.Professor;
import Validar.Validar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static sistemagestaoescolar.Menu.vecAluno;
import static sistemagestaoescolar.Menu.vecProfessor;
import static sistemagestaoescolar.Menu.vecEncarregado;

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
        String date = Validar.texto("Data de Nasciento(19/07/2021): ", 10);
        try {
            dt = new SimpleDateFormat("dd/mm/yyyy").parse(date);
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }
        int idEnc = (int) Validar.numero("ID encarregado: ", 1, 9999);

        // Caso o id do encarregado nao existir o aluno tem que registrar o encarregado.
        if (!verificarEncarregado(idEnc)) {
            System.out.println("O encarregado ainda nao foi registrado!\nPor favor registe o encarregado...");
            idEnc = registrarEnc();
        }

        Aluno al = new Aluno(x, nrEstudante, dt, idEnc);
        
        vecAluno.addElement(al);
        vecAluno.trimToSize();
    }
    
    public static void registrarProf() {
        Pessoa x;
        x = addPessoa();
        String grau = Validar.texto("Grau Academico: ", 3);
        Professor prof = new Professor(x, grau);
        
        Professor tmp;
        for (int i = 0; i < vecProfessor.size(); i++) {
            tmp = (Professor) vecProfessor.elementAt(i);
            if (prof.getIdPessoa() == tmp.getIdPessoa()) {
                System.out.println("O professor ja esta registrado!\n Tente novamente");
                return;
            }
        }
        
        vecProfessor.addElement(prof);
        vecProfessor.trimToSize();
    }
    
    static int registrarEnc() {
        Pessoa x;
        x = addPessoa();
        x.setIdPessoa(x.getIdPessoa() + 1);
        String parentesco = Validar.texto("Grau de Parentesco: ", 3);
        EncarregadoEducacao enc = new EncarregadoEducacao(x, parentesco);

        /*
        if (verificarEncarregado(enc.getIdPessoa())) {
            System.out.println("O encarregado ja esta registrado!\nTente novamente....");
            return -1;
        }
         */
        vecEncarregado.addElement(enc);
        vecEncarregado.trimToSize();
        
        return enc.getIdPessoa();
    }
    
    private static boolean verificarEncarregado(int id) {
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
        char sexo = Validar.texto("Sexo: ", 1).charAt(0);
        String nrBI = Validar.texto("BI: ", 4);
        String estadoCivil = Validar.texto("Estado civil: ", 4);
        String tell1 = Validar.texto("Telefone 1: ", 9);
        String tell2 = Validar.texto("Telefone 2: ", 9);
        
        Pessoa x = new Pessoa(id, nome, apelido, sexo, nrBI, estadoCivil, tell1, tell2);
        return x;
    }
    
    public static void AddAnoAcademico() {
        
    }
    
    public static void AddDisciplina() {
        
    }
    
    public static void AddClasse() {
        
    }
    
    public static void AddTurma() {
        
    }

    // <editor-fold defaultstate="collapsed" desc="Renovar Matricula/Alocar">
    public static void RenovarMatricula() {
        
    }
    
    public static void Alocar() {
        
    }
    // </editor-fold>

}
