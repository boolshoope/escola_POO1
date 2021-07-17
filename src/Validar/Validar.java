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
}
