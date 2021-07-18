/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemagestaoescolar;

import Objectos.*;
import Validar.Validar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author isacl
 */
public class SistemaGestaoEscolar {

    /**
     * @param args the command line arguments
     */
    public final static String nomeFich[] = {"aluno","professor"};
    public static Vector aluno, professor, encarregado;
    
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
    static void matricularAluno() throws ParseException {
        Pessoa x;
        Date dt;
        x = addPessoa();
        int nrEstudante = (int) Validar.numero("Numero de Estudante: ",1111,9999);
        String date = Validar.texto("Data de Nasciento(19/07/2021): ",10);
        dt = new SimpleDateFormat("dd/mm/yyyy").parse(date);
        int idEnc =(int) Validar.numero("ID encarregado: ", 1111, 9999);
        
        // Caso o id do encarregado nao existir o aluno tem que registrar o encarregado.
        if(!verificarEncarregado(idEnc)){
            System.out.println("O encarregado ainda nao foi registrado!\nPor favor registe o encarregado...");
            idEnc = registrarEnc();
        }
        
        // Verificar se o aluno ja foi registado
        Aluno tmp;
        for(int i=0;i<aluno.size();i++) {
            tmp = (Aluno) aluno.elementAt(i);
            if(tmp.getNrEstudante() == nrEstudante){
                System.out.println("O estudante ja foi matriculado!\nTente novamente");
                return;
            }
        }
        
        Aluno al = new Aluno(x,nrEstudante,dt,idEnc);
        
        aluno.addElement(al);
        aluno.trimToSize();
    }
    
    static void registrarProf() {
        Pessoa x;
        x = addPessoa();
        String grau = Validar.texto("Grau Academico: ",3);
        Professor prof = new Professor(x,grau);
        
        Professor tmp;
        for(int i=0;i<professor.size();i++){
            tmp = (Professor) professor.elementAt(i);
            if(prof.getIdPessoa() == tmp.getIdPessoa()){
                System.out.println("O professor ja esta registrado!\n Tente novamente");
                return;
            }
        }
        
        professor.addElement(prof);
        professor.trimToSize();
    }
    
    static int registrarEnc() {
        Pessoa x;
        x = addPessoa();
        String parentesco = Validar.texto("Grau de Parentesco: ",3);
        EncarregadoEducacao enc = new EncarregadoEducacao(x,parentesco);
        
        if(verificarEncarregado(enc.getIdPessoa())){
            System.out.println("O encarregado ja esta registrado!\nTente novamente....");
            return -1;
        }
        
        encarregado.addElement(enc);
        encarregado.trimToSize();
        
        return enc.getIdPessoa();
    }
    
    private static boolean verificarEncarregado(int id){
        EncarregadoEducacao tmp;
        for(int i=0;i<encarregado.size();i++){
           tmp =(EncarregadoEducacao) encarregado.elementAt(i);
           if(id == tmp.getIdPessoa())
               return true;
        }
        return false;
    }
    
    static Pessoa addPessoa() {
        int id =(int) Validar.numero("ID: ",1111, 9999);
        String nome = Validar.texto("Nome: ", 4);
        String apelido = Validar.texto("Apelido: ",4);
        char sexo = Validar.texto("Sexo: ",1).charAt(0);
        String nrBI = Validar.texto("BI: ", 4);
        String estadoCivil = Validar.texto("Estado civil: ", 4);
        String tell1 = Validar.texto("Telefone 1: ",9);
        String tell2 = Validar.texto("Telefone 2: ",9);
        
        Pessoa x = new Pessoa(id,nome,apelido,sexo,nrBI,estadoCivil,tell1,tell2);
        return x;
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
