/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author isacl
 */
public class Validar {

    static String ValidarString(String txt) {
        while (txt.equals("")) {
            System.out.print("O texto não pode ser vazio, por favor introduza novamente: ");
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                txt = br.readLine();
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }
        return txt;
    }

    static int VerificarInt(String txt) {
        int num = 0;
        boolean bool;
        try {
            num = Integer.parseInt(ValidarString(txt + ""));
            bool = false;
        } catch (NumberFormatException ex) {
            bool = true;
        }

        if (bool) {
            System.out.print("Introduza um número não uma palavra: ");
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                num = VerificarInt(br.readLine());
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }

        if (num <= 0) {
            System.out.print("O número deve ser maior que zero, por favor introduza novamente: ");
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                num = VerificarInt(br.readLine());
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }
        return num;
    }

    static boolean ValidarNumRangeFloat(float num, float min, float max) {
        boolean bool = false;
        if (num < min || num > max) {
            System.out.println("O numero deve estar entre " + min + " e " + max);
            bool = true;
        }

        return bool;
    }

    static boolean ValidarNumRangeInt(int num, int min, int max) {
        boolean bool = false;
        if (num < min || num > max) {
            System.out.println("O numero deve estar entre " + min + " e " + max);
            bool = true;
        }

        return bool;
    }
}
