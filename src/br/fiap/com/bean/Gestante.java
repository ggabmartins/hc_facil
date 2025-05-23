package br.fiap.com.bean;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;

public class Gestante {
    private String gravida;
    private String mesesGestacao;

    public Gestante() {
        this.gravida = "Não";
        this.mesesGestacao = "0";
    }

    public Gestante(String gravida, String mesesGestacao) {
        this.gravida = gravida;
        this.mesesGestacao = mesesGestacao;
    }

    public Gestante(String sim, int meses) {
    }

    // getters e setters

    public String getGravida() {
        return gravida;
    }

    public void setGravida(String gravida) {
        this.gravida = gravida;
    }

    public String getMesesGestacao() {
        return mesesGestacao;
    }

    public void setMesesGestacao(String mesesGestacao) {
        this.mesesGestacao = mesesGestacao;
    }

    // resumo simples
    public String exibirResumo() {
        return "Grávida: " + gravida + "\n" +
                (gravida.equalsIgnoreCase("Sim") ? "Meses de                 gestação: " + mesesGestacao : "");
    }
}

