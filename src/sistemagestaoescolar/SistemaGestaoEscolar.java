/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemagestaoescolar;

import Validar.Validar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author isacl
 */
public class SistemaGestaoEscolar {

    /**
     * @param args the command line arguments
     */
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
    static void MatricularAluno() {

    }

    static void AddPessoa(String aux) {

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

    }

    static void ViewDisciplina() {

    }

    static void ViewClasse() {

    }

    static void ViewTurma() {

    }
    // </editor-fold>
}
