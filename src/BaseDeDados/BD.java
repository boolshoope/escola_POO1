/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDados;

import Objectos.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import static sistemagestaoescolar.Menu.*;

/**
 *
 * @author isacl
 */
public class BD {

    public static void LerFicheiro() {
        vecTeste = new Vector();
        String[] data;
        String umaLinha = "", adata;
        try {
            FileReader fr = new FileReader("Teste.txt");
            BufferedReader fichIn = new BufferedReader(fr);
            umaLinha = fichIn.readLine();

            while (umaLinha != null) {
                //adata = umaLinha.replace(" ", "");
                adata = umaLinha.replace("'", "");
                adata = adata.replace("-", "/");
                data = adata.split(",");
                Date dt = new Date();
                try {
                    dt = new SimpleDateFormat("dd/mm/yyyy").parse(data[3]);
                } catch (ParseException ex) {
                    System.out.println(ex.toString());
                }

                vecTeste.addElement(new Teste(Integer.parseInt(data[0]), Float.parseFloat(data[1]), data[2], dt, Float.parseFloat(data[4]), 
                        data[5], Integer.parseInt(data[6]), Integer.parseInt(data[7]), Integer.parseInt(data[8])));
                umaLinha = fichIn.readLine();
            }
            GravarFichObj(vecTeste, "Teste");
            fichIn.close();
        } catch (FileNotFoundException fn) {
            System.out.println("Ficheiro nao encontrado!");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void LerFicheiroMatricula() {
        vecMatricula = new Vector();
        String[] data;
        String umaLinha = "";
        try {
            FileReader fr = new FileReader("Matricula.txt");
            BufferedReader fichIn = new BufferedReader(fr);
            umaLinha = fichIn.readLine();

            while (umaLinha != null) {
                data = umaLinha.split(",");

                vecMatricula.addElement(new Matricula(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
                umaLinha = fichIn.readLine();
            }
            GravarFichObj(vecMatricula, "Matricula");
            fichIn.close();
        } catch (FileNotFoundException fn) {
            System.out.println("Ficheiro nao encontrado!");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void GravarFichObj(Vector vec, String obj) {
        try {
            FileOutputStream ff = new FileOutputStream(obj + ".dat");
            ObjectOutputStream ss = new ObjectOutputStream(ff);
            ss.writeObject(vec);
            ss.close();
        } catch (IOException xx) {
            System.out.println(xx.toString());
        }
    }

    public static Vector LerDadosDoFichObj(String obj) {
        Vector vec = new Vector();
        try {
            FileInputStream ii = new FileInputStream(obj + ".dat");
            ObjectInputStream tt = new ObjectInputStream(ii);
            vec = (Vector) tt.readObject();
            tt.close();

        } catch (FileNotFoundException ff) {
            System.out.println("Ficheiro de obj nao encontrado!");
        } catch (ClassNotFoundException cc) {
            System.out.println("Verifique a existencia da classe " + obj);
        } catch (IOException pp) {
            System.out.println("Problemas no leitura do ficheiro!");
        }
        return vec;
    }
}
