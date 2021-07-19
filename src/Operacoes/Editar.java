/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes;

import Objectos.*;
import Validar.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static sistemagestaoescolar.Menu.vecAluno;
import static sistemagestaoescolar.Menu.vecAnoAcademico;
import static sistemagestaoescolar.Menu.vecClasse;
import static sistemagestaoescolar.Menu.vecClasseDiscProf;
import static sistemagestaoescolar.Menu.vecDisciplina;
import static sistemagestaoescolar.Menu.vecEncarregado;
import static sistemagestaoescolar.Menu.vecMatricula;
import static sistemagestaoescolar.Menu.vecProfessor;
import static sistemagestaoescolar.Menu.vecTurma;

/**
 *
 * @author isacl
 */
public class Editar {
    
    public static void EditAluno() {
        Aluno tmp;
        Pessoa x;
        int nrEstudante, pos;
        
        nrEstudante =(int) Validar.numero("Numero do estudante: ",1000, 9999);
        
        pos = -1;
        for(int i=0;i<vecAluno.size();i++) {
            tmp = (Aluno) vecAluno.elementAt(i);
            if(tmp.getNrEstudante() == nrEstudante){
                pos = i;
                break;
            }
        }
        
        if(pos == -1){
            System.out.println("Aluno nao matriculado.");
            return;
        }
        
        tmp = (Aluno) vecAluno.elementAt(pos);
        x = EditPessoa(tmp.getIdPessoa());
        String date = Validar.texto("Data de Nasciento(19/07/2021): ", 10);
        Date dt = new Date();
        try {
            dt = new SimpleDateFormat("dd/mm/yyyy").parse(date);
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }
        
        tmp.update(x, dt);
        
        vecAluno.setElementAt(tmp,pos);
        vecAluno.trimToSize();
    }
    
    public static void EditProfessor() {
        Professor tmp;
        Pessoa x;
        int id, pos;
        
        id = (int) Validar.numero("ID professor: ",0,9999);
        
        pos = -1;
        for(int i=0;i<vecProfessor.size();i++){
            tmp = (Professor) vecProfessor.elementAt(i);
            if(tmp.getIdPessoa() == id){
                pos = i;
                break;
            }
        }
        
        if(pos == -1) {
            System.out.println("Professor nao registado!");
            return;
        }
        
        tmp = (Professor) vecProfessor.elementAt(pos);
        x = EditPessoa(tmp.getIdPessoa());
        String grau = Validar.texto("Grau Academico: ", 3);
        
        tmp.update(x,grau);
        
        vecProfessor.setElementAt(tmp,pos);
        vecProfessor.trimToSize();
    }
    
    public static void EditEncarregado(){
        EncarregadoEducacao tmp;
        Pessoa x;
        int id, pos;
        
        id = (int) Validar.numero("ID professor: ",0,9999);
        
        pos = -1;
        for(int i=0;i<vecEncarregado.size();i++){
            tmp = (EncarregadoEducacao) vecEncarregado.elementAt(i);
            if(tmp.getIdPessoa() ==  id) {
                pos = i;
                break;
            }
        }
        
        if(pos == -1) {
            System.out.println("Encarregado nao encontrado.");
            return;
        }
        
        tmp = (EncarregadoEducacao) vecEncarregado.elementAt(pos);
        x = EditPessoa(tmp.getIdPessoa());
        String parentesco = Validar.texto("Grau de Parentesco: ", 3);
        
        tmp.update(x,parentesco);
        
        vecEncarregado.setElementAt(tmp,pos);
        vecEncarregado.trimToSize();
    } 

    public static Pessoa EditPessoa(int id) {
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

    public static void EditAnoAcademico() {
        AnoAcademico tmp;
        int id, pos;
        
        id = (int) Validar.numero("ID(Ano academico): ",1,9999);
        
        pos = -1;
        for(int i=0;i<vecAnoAcademico.size();i++) {
            tmp = (AnoAcademico) vecAnoAcademico.elementAt(i);
            if(tmp.getIdAnoAcademico() == id) {
                pos = i;
                break;
            }
        }
        
        if(pos == -1){
            System.out.println("Ano academico nao encontrado.");
            return;
        }
        
        tmp = (AnoAcademico) vecAnoAcademico.elementAt(pos);
        int ano = (int) Validar.numero("Ano: ", 2000, 3000);
        int trimestre = (int) Validar.numero("Trimestre: ", 1, 3);
        
        tmp.setAno(ano);
        tmp.setTrimestre(trimestre);
        
        vecAnoAcademico.setElementAt(tmp,pos);
        vecAnoAcademico.trimToSize();
    }

    public static void EditDisciplina() {
        Disciplina tmp;
        int id, pos;
        
        id = (int) Validar.numero("ID(disciplina): ",1,9999);
        
        pos = -1;
        for(int i=0;i<vecDisciplina.size();i++){
            tmp = (Disciplina) vecDisciplina.elementAt(i);
            if(tmp.getIdDisciplina() == id){
                pos = i;
                break;
            }
        }
        
        if(pos == -1){
            System.out.println("Disciplina nao registrada.");
            return;
        }
        
        tmp = (Disciplina) vecDisciplina.elementAt(pos);
        
        String nome = Validar.texto("Nome: ",4);
        
        tmp.setNome(nome);
        
        vecDisciplina.setElementAt(tmp,pos);
        vecDisciplina.trimToSize();
    }

    public static void EditClasse() {
        Classe tmp;
        int id, pos;
        
        id = (int) Validar.numero("ID(Classe): ",1,9999);
        
        pos = -1;
        for(int i=0;i<vecClasse.size();i++){
            tmp = (Classe) vecClasse.elementAt(i);
            if(tmp.getIdClasse() == id) {
                pos = i;
                break;
            }
        }
        
        if(pos == -1) {
            System.out.println("Classe nao registada.");
            return;
        }
        
        tmp = (Classe) vecClasse.elementAt(pos);
        String nome = Validar.texto("Nome: ",4);
        
        tmp.setNome(nome);
        
        vecClasse.setElementAt(tmp,pos);
        vecClasse.trimToSize();
    }

    public static void EditTurma() {
        Turma tmp;
        int id, pos;
        
        id = (int) Validar.numero("ID(Turma): ",1,9999);
        
        pos = -1;
        for(int i=0;i<vecTurma.size();i++){
            tmp = (Turma) vecTurma.elementAt(i);
            if(tmp.getIdTurma() == id) {
                pos = i;
                break;
            }
        }
        
        if(pos == -1){
            System.out.println("A turma nao existe.");
            return;
        }
        
        tmp = (Turma) vecTurma.elementAt(pos);
        String nome = Validar.texto("Nome: ", 1);
        int maxAlunos = (int) Validar.numero("Numero maximo de alunos: ", 10, 99);
        int idClasse;
        do{
            idClasse = (int) Validar.numero("Id Classe: ", 1, 9999);
        }while(!Validar.VerificarIDClasse(idClasse));
        
        tmp.setNome(nome);
        tmp.setMaxAlunos(maxAlunos);
        tmp.setIdClasse(idClasse);
        
        vecTurma.setElementAt(tmp,pos);
        vecTurma.trimToSize();
    }
}