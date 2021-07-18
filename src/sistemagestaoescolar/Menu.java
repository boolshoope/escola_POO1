/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemagestaoescolar;

import Validar.Validar;

/**
 *
 * @author isacl
 */
public class Menu {

    private static int opEsc;

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
                SistemaGestaoEscolar.MatricularAluno();
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
            case 5:
                SistemaGestaoEscolar.main(null);
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
                SistemaGestaoEscolar.AddPessoa("encarregadoEducacao");
                break;
            case 2:
                System.out.println("|**** Adicionar Professor ****|");
                SistemaGestaoEscolar.AddPessoa("professor");
                break;
            case 3:
                System.out.println("|**** Adicionar Ano Academico ****|");
                SistemaGestaoEscolar.AddAnoAcademico();
                break;
            case 4:
                System.out.println("|**** Adicionar Disciplina ****|");
                SistemaGestaoEscolar.AddDisciplina();
                break;
            case 5:
                System.out.println("|**** Adicionar Classe ****|");
                SistemaGestaoEscolar.AddClasse();
                break;
            case 6:
                System.out.println("|**** Adicionar Turma ****|");
                SistemaGestaoEscolar.AddTurma();
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
                SistemaGestaoEscolar.EditPessoa("encarregadoEducacao");
                break;
            case 2:
                System.out.println("|**** Editar Professor ****|");
                SistemaGestaoEscolar.EditPessoa("professor");
                break;
            case 3:
                System.out.println("|**** Editar Ano Academico ****|");
                SistemaGestaoEscolar.EditAnoAcademico();
                break;
            case 4:
                System.out.println("|**** Editar Disciplina ****|");
                SistemaGestaoEscolar.EditDisciplina();
                break;
            case 5:
                System.out.println("|**** Editar Classe ****|");
                SistemaGestaoEscolar.EditClasse();
                break;
            case 6:
                System.out.println("|**** Editar Turma ****|");
                SistemaGestaoEscolar.EditTurma();
                break;
            case 7:
                System.out.println("|**** Editar Aluno ****|");
                SistemaGestaoEscolar.EditPessoa("aluno");
                break;
            case 8:
                SistemaGestaoEscolar.main(null);
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
                SistemaGestaoEscolar.DelPessoa("encarregadoEducacao");
                break;
            case 2:
                System.out.println("|**** Remover Professor ****|");
                SistemaGestaoEscolar.DelPessoa("professor");
                break;
            case 3:
                System.out.println("|**** Remover Ano Academico ****|");
                SistemaGestaoEscolar.DelAnoAcademico();
                break;
            case 4:
                System.out.println("|**** Remover Disciplina ****|");
                SistemaGestaoEscolar.DelDisciplina();
                break;
            case 5:
                System.out.println("|**** Remover Classe ****|");
                SistemaGestaoEscolar.DelClasse();
                break;
            case 6:
                System.out.println("|**** Remover Turma ****|");
                SistemaGestaoEscolar.DelTurma();
                break;
            case 7:
                System.out.println("|**** Remover Aluno ****|");
                SistemaGestaoEscolar.DelPessoa("aluno");
                break;
            case 8:
                SistemaGestaoEscolar.main(null);
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
                SistemaGestaoEscolar.RenovarMatricula();
                break;
            case 2:
                System.out.println("\n|**** Alocar um professor a uma disciplina e a disciplina em uma classe ****|");
                SistemaGestaoEscolar.Alocar();
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
                SistemaGestaoEscolar.VisualizarNotasTurmaAnoAcademico();
                break;
            case 2:
                System.out.println("\n|**** Listar as medias e a nota global de um aluno num determinado ano academico ****|");
                SistemaGestaoEscolar.VisualizarMediasNotaGlobal();
                break;
            case 3:
                System.out.println("\n|**** Listar as notas de um determinado aluno num trimestre ****|");
                SistemaGestaoEscolar.VisualizarNotasAlunoTrimestre();
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
                SistemaGestaoEscolar.ViewPessoa("encarregadoEducacao");
                break;
            case 2:
                System.out.println("|**** Visualizar Professores ****|");
                SistemaGestaoEscolar.ViewPessoa("professor");
                break;
            case 3:
                System.out.println("|**** Visualizar Ano Academico ****|");
                SistemaGestaoEscolar.ViewAnoAcademico();
                break;
            case 4:
                System.out.println("|**** Visualizar Disciplinas ****|");
                SistemaGestaoEscolar.ViewDisciplina();
                break;
            case 5:
                System.out.println("|**** Visualizar Classes ****|");
                SistemaGestaoEscolar.ViewClasse();
                break;
            case 6:
                System.out.println("|**** Visualizar Turmas ****|");
                SistemaGestaoEscolar.ViewTurma();
                break;
            case 7:
                System.out.println("|**** Visualizar Alunos ****|");
                SistemaGestaoEscolar.ViewPessoa("aluno");
                break;
            case 8:
                SistemaGestaoEscolar.main(null);
                break;
        }
    }
    // </editor-fold>
}
