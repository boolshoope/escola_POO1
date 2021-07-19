/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemagestaoescolar;

import BaseDeDados.BD;
import Operacoes.Adicionar;
import Operacoes.Editar;
import Operacoes.Remover;
import Operacoes.Visualizar;
import Validar.Validar;
import java.util.Vector;

/**
 *
 * @author isacl
 */
public class Menu {

    private static int opEsc;

    public final static String nomeFich[] = {"aluno", "professor"};
    public static Vector vecAluno, vecProfessor, vecEncarregado, vecAnoAcademico, vecDisciplina, vecClasse, vecTurma;

    static void MainMenu() {
        InicializarVectores();

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
                    MainCase1();
                    break;
                case 2:
                    System.out.println("\n|**** Alocar/Renovação de Matricula ****|");
                    MainCase2();
                    break;
                case 3:
                    System.out.println("\n|**** Visualizar notas dos alunos ****|");
                    MainCase3();
                    break;
                case 4:
                    System.out.println("\n|**** Visualizar outros dados ****|");
                    MainCase4();
                    break;
                case 5:
                    GravarVectores();
                    System.out.println("Obrigado.");
                    System.exit(0);
                    break;
            }
            System.out.println("");
        } while (opEsc != 5);
    }

    static void InicializarVectores() {
        vecAluno = BD.LerDadosDoFichObj("Aluno");
        vecProfessor = BD.LerDadosDoFichObj("Professor");
        vecEncarregado = BD.LerDadosDoFichObj("EncarregadoEducacao");
        vecAnoAcademico = BD.LerDadosDoFichObj("AnoAcademico");
        vecDisciplina = BD.LerDadosDoFichObj("Disciplina");
        vecClasse = BD.LerDadosDoFichObj("Classe");
        vecTurma = BD.LerDadosDoFichObj("Turma");

        //BD.GravarFichObj(new Vector(), "Aluno");
    }

    static void GravarVectores() {
        BD.GravarFichObj(vecAluno, "Aluno");
        BD.GravarFichObj(vecProfessor, "Professor");
        BD.GravarFichObj(vecEncarregado, "EncarregadoEducacao");
        BD.GravarFichObj(vecAnoAcademico, "AnoAcademico");
        BD.GravarFichObj(vecDisciplina, "Disciplina");
        BD.GravarFichObj(vecClasse, "Classe");
        BD.GravarFichObj(vecTurma, "Turma");
    }

    static void MainCase1() {
        System.out.println("Selecione a opção:");
        System.out.println("1. Matricular Aluno");
        System.out.println("2. Adicionar");
        System.out.println("3. Editar");
        System.out.println("4. Remover");
        System.out.println("5. Voltar");

        opEsc = (int) Validar.numero("-> ", 1, 5);
        switch (opEsc) {
            case 1:
                System.out.println("|**** Matricular Aluno ****|");
                Adicionar.MatricularAluno();
                break;
            case 2:
                System.out.println("\n|**** Adicionar ****|");
                MainCase12();
                break;
            case 3:
                System.out.println("\n|**** Editar ****|");
                MainCase13();
                break;
            case 4:
                System.out.println("\n|**** Remover ****|");
                MainCase14();
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="MainCase12 - Adicionar">
    static void MainCase12() {
        System.out.println("Selecione a opção:");
        System.out.println("1. Encarregado de Educacao");
        System.out.println("2. Professor");
        System.out.println("3. Ano Academico");
        System.out.println("4. Disciplina");
        System.out.println("5. Classe");
        System.out.println("6. Turma");
        System.out.println("7. Voltar");

        opEsc = (int) Validar.numero("-> ", 1, 7);
        switch (opEsc) {
            case 1:
                System.out.println("|**** Adicionar Encarregado de Educacao ****|");
                //SistemaGestaoEscolar.AddPessoa("encarregadoEducacao");
                break;
            case 2:
                System.out.println("|**** Adicionar Professor ****|");
                Adicionar.AddProfessor();
                break;
            case 3:
                System.out.println("|**** Adicionar Ano Academico ****|");
                Adicionar.AddAnoAcademico();
                break;
            case 4:
                System.out.println("|**** Adicionar Disciplina ****|");
                Adicionar.AddDisciplina();
                break;
            case 5:
                System.out.println("|**** Adicionar Classe ****|");
                Adicionar.AddClasse();
                break;
            case 6:
                System.out.println("|**** Adicionar Turma ****|");
                Adicionar.AddTurma();
                break;
            case 7:
                SistemaGestaoEscolar.main(null);
                break;
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="MainCase13 - Editar">
    static void MainCase13() {
        System.out.println("Selecione a opção:");
        System.out.println("1. Encarregado de Educacao");
        System.out.println("2. Professor");
        System.out.println("3. Ano Academico");
        System.out.println("4. Disciplina");
        System.out.println("5. Classe");
        System.out.println("6. Turma");
        System.out.println("7. Aluno");
        System.out.println("8. Voltar");

        opEsc = (int) Validar.numero("-> ", 1, 8);
        switch (opEsc) {
            case 1:
                System.out.println("|**** Editar Encarregado de Educacao ****|");
                Editar.EditPessoa("encarregadoEducacao");
                break;
            case 2:
                System.out.println("|**** Editar Professor ****|");
                Editar.EditPessoa("professor");
                break;
            case 3:
                System.out.println("|**** Editar Ano Academico ****|");
                Editar.EditAnoAcademico();
                break;
            case 4:
                System.out.println("|**** Editar Disciplina ****|");
                Editar.EditDisciplina();
                break;
            case 5:
                System.out.println("|**** Editar Classe ****|");
                Editar.EditClasse();
                break;
            case 6:
                System.out.println("|**** Editar Turma ****|");
                Editar.EditTurma();
                break;
            case 7:
                System.out.println("|**** Editar Aluno ****|");
                Editar.EditPessoa("aluno");
                break;
            case 8:
                break;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="MainCase14 - Remover">
    static void MainCase14() {
        System.out.println("ATENÇÃO - Ao remover algum dado, todos dados relacionados a ele tambem serão apagados");
        System.out.println("Ex: Se remover um encarregado de educação, todos alunos relacionados a ele tambem serão removidos.\n");
        System.out.println("Selecione a opção:");
        System.out.println("1. Encarregado de Educacao");
        System.out.println("2. Professor");
        System.out.println("3. Ano Academico");
        System.out.println("4. Disciplina");
        System.out.println("5. Classe");
        System.out.println("6. Turma");
        System.out.println("7. Aluno");
        System.out.println("8. Voltar");

        opEsc = (int) Validar.numero("-> ", 1, 8);
        switch (opEsc) {
            case 1:
                System.out.println("|**** Remover Encarregado de Educacao ****|");
                Remover.DelPessoa("encarregadoEducacao");
                break;
            case 2:
                System.out.println("|**** Remover Professor ****|");
                Remover.DelPessoa("professor");
                break;
            case 3:
                System.out.println("|**** Remover Ano Academico ****|");
                Remover.DelAnoAcademico();
                break;
            case 4:
                System.out.println("|**** Remover Disciplina ****|");
                Remover.DelDisciplina();
                break;
            case 5:
                System.out.println("|**** Remover Classe ****|");
                Remover.DelClasse();
                break;
            case 6:
                System.out.println("|**** Remover Turma ****|");
                Remover.DelTurma();
                break;
            case 7:
                System.out.println("|**** Remover Aluno ****|");
                Remover.DelPessoa("aluno");
                break;
            case 8:
                break;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="MainCase2 - Matricular Aluno/Alocar">
    static void MainCase2() {
        System.out.println("Selecione a opção:");
        System.out.println("1. Renovar matricula de um aluno");
        System.out.println("2. Alocar um professor a uma disciplina e a disciplina em uma classe");
        System.out.println("3. Voltar");

        opEsc = (int) Validar.numero("-> ", 1, 3);
        switch (opEsc) {
            case 1:
                System.out.println("|**** Renovar matricula de um aluno ****|");
                Adicionar.RenovarMatricula();
                break;
            case 2:
                System.out.println("\n|**** Alocar um professor a uma disciplina e a disciplina em uma classe ****|");
                Adicionar.Alocar();
                break;
            case 3:
                SistemaGestaoEscolar.main(null);
                break;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="MainCase3 - Visualizar Notas Alunos">
    static void MainCase3() {
        System.out.println("Selecione a opção:");
        System.out.println("1. Listar as notas de uma turma num determinado ano acadêmico");
        System.out.println("2. Listar as medias e a nota global de um aluno num determinado ano academico");
        System.out.println("3. Listar as notas de um determinado aluno num trimestre");
        System.out.println("4. Voltar");

        opEsc = (int) Validar.numero("-> ", 1, 4);
        switch (opEsc) {
            case 1:
                System.out.println("|**** Listar as notas de uma turma num determinado ano acadêmico ****|");
                Visualizar.VisualizarNotasTurmaAnoAcademico();
                break;
            case 2:
                System.out.println("\n|**** Listar as medias e a nota global de um aluno num determinado ano academico ****|");
                Visualizar.VisualizarMediasNotaGlobal();
                break;
            case 3:
                System.out.println("\n|**** Listar as notas de um determinado aluno num trimestre ****|");
                Visualizar.VisualizarNotasAlunoTrimestre();
                break;
            case 4:
                SistemaGestaoEscolar.main(null);
                break;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="MainCase4 - Visualiar outros dados">
    static void MainCase4() {
        System.out.println("Selecione a opção:");
        System.out.println("1. Encarregado de Educacao");
        System.out.println("2. Professor");
        System.out.println("3. Ano Academico");
        System.out.println("4. Disciplina");
        System.out.println("5. Classe");
        System.out.println("6. Turma");
        System.out.println("7. Aluno");
        System.out.println("8. Voltar");

        opEsc = (int) Validar.numero("-> ", 1, 8);
        switch (opEsc) {
            case 1:
                System.out.println("|**** Visualizar Encarregados de Educacao ****|");
                Visualizar.ViewEncarregadoEducacao();
                break;
            case 2:
                System.out.println("|**** Visualizar Professores ****|");
                Visualizar.ViewProfessor();
                break;
            case 3:
                System.out.println("|**** Visualizar Ano Academico ****|");
                Visualizar.ViewAnoAcademico();
                break;
            case 4:
                System.out.println("|**** Visualizar Disciplinas ****|");
                Visualizar.ViewDisciplina();
                break;
            case 5:
                System.out.println("|**** Visualizar Classes ****|");
                Visualizar.ViewClasse();
                break;
            case 6:
                System.out.println("|**** Visualizar Turmas ****|");
                Visualizar.ViewTurma();
                break;
            case 7:
                System.out.println("|**** Visualizar Alunos ****|");
                Visualizar.ViewAluno();
                break;
            case 8:
                break;
        }
    }
    // </editor-fold>
}
