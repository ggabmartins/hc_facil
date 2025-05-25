package br.fiap.com.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PlanoDeSaude {
    private String nomeDoPlano;
    private String nmrDaCarteirinha;
    private LocalDate validade;

    //contrutores
    public PlanoDeSaude(){
    }

    public PlanoDeSaude(String nomeDoPlano, String nmrDaCarteirinha, LocalDate validade) {
        this.nomeDoPlano = nomeDoPlano;
        this.nmrDaCarteirinha = nmrDaCarteirinha;
        this.validade = validade;
    }

    //getters e setters
    public String getNomeDoPlano() {
        return nomeDoPlano;
    }

    public void setNomeDoPlano(String nomeDoPlano) {
        this.nomeDoPlano = nomeDoPlano;
    }

    public String getNmrDaCarteirinha() {
        return nmrDaCarteirinha;
    }

    public void setNmrDaCarteirinha(String nmrDaCarteirinha) {
        this.nmrDaCarteirinha = nmrDaCarteirinha;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    //metodos particulares
    public String exibirResumo() {
        if ("Não possui plano de saúde.".equalsIgnoreCase(nomeDoPlano)
                || nomeDoPlano == null || nomeDoPlano.trim().isEmpty()) {
            return "Não possui plano de saúde.";
        }
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String validadeFrmt = (validade != null)
                ? validade.format(formatoData)
                : "Não informado";
        return "Plano de Saúde: " + nomeDoPlano +
                "\nNúmero da carteirinha: " + nmrDaCarteirinha +
                "\nValidade: " + validadeFrmt;
    }
}
