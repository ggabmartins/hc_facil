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
        DateTimeFormatter validadeFrmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Plano de Saúde: " + nomeDoPlano +
                "\nNúmero da carteirinha: " + nmrDaCarteirinha +
                "\nValidade: " + validade.format(validadeFrmt);
    }
}
