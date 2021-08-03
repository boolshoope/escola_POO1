/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objectos;

import java.io.Serializable;

/**
 *
 * @author isacl
 */
public class Pessoa implements Serializable{

    protected int idPessoa;
    protected String pNome;
    protected String apelido;
    protected char sexo;
    protected String nrBI;
    protected String estadoCivil;
    protected String tel1;
    protected String tel2;

    public Pessoa(int idPessoa, String pNome, String apelido, char sexo, String nrBI, String estadoCivil, String tel1, String tel2) {
        this.idPessoa = idPessoa;
        this.pNome = pNome;
        this.apelido = apelido;
        this.sexo = sexo;
        this.nrBI = nrBI;
        this.estadoCivil = estadoCivil;
        this.tel1 = tel1;
        this.tel2 = tel2;
    }
    
    public Pessoa(Pessoa ob){
        this.idPessoa = ob.idPessoa;
        this.pNome = ob.pNome;
        this.apelido = ob.apelido;
        this.sexo = ob.sexo;
        this.nrBI = ob.nrBI;
        this.estadoCivil = ob.estadoCivil;
        this.tel1 = ob.tel1;
        this.tel2 = ob.tel2;
    }
    
    public void update(Pessoa ob) {
        this.pNome = ob.pNome;
        this.apelido = ob.apelido;
        this.sexo = ob.sexo;
        this.nrBI = ob.nrBI;
        this.estadoCivil = ob.estadoCivil;
        this.tel1 = ob.tel1;
        this.tel2 = ob.tel2;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getpNome() {
        return pNome;
    }


    public String getApelido() {
        return apelido;
    }


    public char getSexo() {
        return sexo;
    }


    public String getNrBI() {
        return nrBI;
    }


    public String getEstadoCivil() {
        return estadoCivil;
    }


    public String getTel1() {
        return tel1;
    }

    public String getTel2() {
        return tel2;
    }


    public String toString() {
        String format = "%-12s %-15s %-20s %-12s %-20s %-20s %-25s", s = "";
        if (sexo == 'M') {
            s = "Masculino";
        }else if (sexo == 'F') {
            s = "Feminino";
        }
        
        return String.format(format, idPessoa, pNome, apelido, s, nrBI, estadoCivil, tel1 + "  " + tel2);
    }
}