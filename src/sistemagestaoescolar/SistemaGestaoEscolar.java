/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemagestaoescolar;

import Objectos.*;
import java.util.Vector;

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
        
        System.out.println("escola");
        Vector vec = new Vector();
        Pessoa pes;
        Professor prof;
        prof = new Professor("Mestre", 1, "Isac", "Lapow", 'M', "123456", "Solt", "132", "123");
        vec.addElement(prof);
        vec.trimToSize();
        prof = new Professor("Lic", 2, "Laer", "Po", 'M', "123456", "CAs", "132", "123");
        vec.addElement(prof);
        vec.trimToSize();

        for (int i = 0; i < vec.size(); i++) {
            pes = (Pessoa) vec.elementAt(i);
            
            if (pes instanceof Professor) {
                prof = (Professor) pes;
                System.out.println(prof.toString());
                
            }
        }
    }

}
