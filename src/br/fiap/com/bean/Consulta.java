package br.fiap.com.bean;

import javax.swing.*;

public class Consulta {
    private  Agendamento agendamento;
    private String descricao;

    //Contrsutores
    public Consulta(){
    }

    public Consulta(Agendamento agendamento, String descricao) {
        this.agendamento = agendamento;
        this.descricao = descricao;
    }

    //getters e setters
    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public String getDescricao() {
        return descricao;
    }

        public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //metodos particulares
    public String exibirResumo() {
        return "=== Consulta realizada ===\n" +
                agendamento.exibirResumo() + "\n" +
                "Descrição da consulta: " + descricao;
    }
}