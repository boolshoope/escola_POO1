/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validar;

import Objectos.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Vector;
import static sistemagestaoescolar.Menu.vecAluno;
import static sistemagestaoescolar.Menu.vecEncarregado;
import static sistemagestaoescolar.Menu.vecProfessor;

/**
 *
 * @author isacl
 */
public class Validar {

    private static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static double numero(String guide, int min, int max) {
        double num = 0;
        do {
            System.out.print(guide);
            try {
                num = Double.parseDouble(rd.readLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IOException io) {
                System.out.println(io.getMessage());
            }
            if (num < min || num > max) {
                System.out.println("Informe correctamente o numero");
            }
        } while (num < min || num > max);
        return num;
    }

    public static String texto(String guide, int minLength) {
        String txt = "";
        do {
            System.out.print(guide);
            try {
                txt = rd.readLine();
            } catch (IOException io) {
                System.out.println(io.getMessage());
            }
            if (txt.isEmpty() || txt.length() < minLength) {
                System.out.println("Informe correctamente o texto");
            }
        } while (txt.isEmpty() || txt.length() < minLength);
        return txt;
    }

    //Gerar id automaticamente
    public static int GetIdPessoa() {
        /*
        id[0] - idPessoa referente ao aluno
        id[1] - idPessoa referente ao encarregado
        id[2] - idPessoa referente ao professor
        */
        int[] id = new int[3];

        if (vecAluno.isEmpty()) {
            id[0] = 0;
        } else {
            Aluno aluno = (Aluno) vecAluno.elementAt(vecAluno.size() - 1);
            id[0] = aluno.getIdPessoa() + 1;
        }
        
        if (vecEncarregado.isEmpty()) {
            id[1] = 0;
        } else {
            EncarregadoEducacao encEd = (EncarregadoEducacao) vecEncarregado.elementAt(vecEncarregado.size() - 1);
            id[1] = encEd.getIdPessoa() + 1;
        }
        
        if (vecProfessor.isEmpty()) {
            id[2] = 0;
        } else {
            Professor prof = (Professor) vecProfessor.elementAt(vecProfessor.size() - 1);
            id[2] = prof.getIdPessoa() + 1;
        }
        
        //Serve para saber qual eh o maior numero no array id
        IntSummaryStatistics stat = Arrays.stream(id).summaryStatistics();
        int max = stat.getMax() + 1;

        return max;
    }

    public static int GetIdEncarregado() {
        int idEnc;
        if (vecEncarregado.isEmpty()) {
            return 0;
        }
        EncarregadoEducacao encEd = (EncarregadoEducacao) vecEncarregado.elementAt(vecEncarregado.size() - 1);
        idEnc = encEd.getIdPessoa() + 1;

        return idEnc;
    }

    public static int GetNrEstudante() {
        int nrEstudante;
        if (vecAluno.isEmpty()) {
            return 1000;
        }
        Aluno aluno = (Aluno) vecAluno.elementAt(vecAluno.size() - 1);
        nrEstudante = aluno.getNrEstudante() + 1;

        return nrEstudante;
    }

}
