package br.fiap.com.bean;

import javax.swing.*;

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

    // Construtor que faltava implementar
    public Gestante(String gravida, int mesesGestacao) {
        this.gravida = gravida;
        this.mesesGestacao = String.valueOf(mesesGestacao);
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
        if ("Sim".equalsIgnoreCase(gravida)) {
            return "Grávida: Sim\nMeses de gestação: " + (mesesGestacao != null ? mesesGestacao : "Não informado");
        } else {
            return "Grávida: " + (gravida != null ? gravida : "Não informado");
        }
    }
}
