package br.com.vinypaulino.mobile.signosnew;

import java.io.Serializable;

/**
 * Created by Naja on 08/11/2017.
 */

public class Signo implements Serializable {
    private int diaInicio;
    private int diaFim;
    private int mesInicio;
    private int mesFim;
    private String nome;
    private String imagem;


    //Como essa clase implementa serializable é obrigatório informar o construtor vazio
    public Signo(){
    }

    //sobrecarga de construtor ou seja, os atributos são passados para a classe na instancia do objeto
    public Signo(int diaInicio, int mesInicio,
                 int diaFim, int mesFim,
                 String nome, String imagem){
        this.diaInicio = diaInicio;
        this.diaFim = diaFim;
        this.mesInicio = mesInicio;
        this.mesFim = mesFim;
        this.nome = nome;
        this.imagem = imagem;

    }

    public int getDiaInicio() {
        return diaInicio;
    }

    public int getDiaFim() {
        return diaFim;
    }

    public int getMesInicio() {
        return mesInicio;
    }

    public int getMesFim() {
        return mesFim;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }
}
