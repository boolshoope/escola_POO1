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
            System.out.println("Problemas no leitura do ficheiro! " + obj);
        }
        return vec;
    }

    
    
}
