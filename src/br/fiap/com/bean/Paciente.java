package br.fiap.com.bean;

import java.time.LocalDate;
import java.time.Period;

public class Paciente {
    private  String nome;
    private LocalDate dtDeNascimento;
    private String deficiencia;
    private String precisaDeResponsavel;
    private String msgResponsavel;
    private String sexo;
    private Gestante gestante;
    private Endereco endereco;
    private Contato contato;
    private HistoricoMedico historicoMedico;
    private PlanoDeSaude planoDeSaude;
    private Agendamento agendamento;
    private Consulta consulta;
    private Responsavel responsavel;

    //Construtores
    public Paciente() {
    }

    public Paciente(String nome, LocalDate dtDeNascimento, String deficiencia,String sexo) {
        this.nome = nome;
        setDtDeNascimento(dtDeNascimento);
        this.deficiencia = deficiencia;
        this.sexo = sexo;
        this.gestante = new Gestante();
    }



    //Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDtDeNascimento(LocalDate dtDeNascimento) {
        this.dtDeNascimento = dtDeNascimento;
        LocalDate dtAtual = LocalDate.now();
        LocalDate limiteMenorIdade = dtAtual.minusYears(18);
        LocalDate limiteIdoso = dtAtual.minusYears(75);

        if (dtDeNascimento.isAfter(limiteMenorIdade) || dtDeNascimento.isBefore(limiteIdoso)) {
            this.precisaDeResponsavel = "Sim";
            this.msgResponsavel = "Este paciente precisa de Responsável";
        } else {
            this.precisaDeResponsavel = "Não";
            this.msgResponsavel = "Este paciente não precisa de Responsável";
        }

    }

    public String getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(String deficiencia) {
        this.deficiencia = deficiencia;
    }

    public String getPrecisaDeResponsavel() {
        return precisaDeResponsavel;
    }

    public String getMsgResponsavel() {
        return msgResponsavel;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Gestante getGestante() {
        return gestante;
    }

    public void setGestante(Gestante gestante) {
        this.gestante = gestante;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato (Contato contato) {
        this.contato = contato;
    }

    public HistoricoMedico getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(HistoricoMedico historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    public PlanoDeSaude getPlanoDeSaude() {
        return planoDeSaude;
    }

    public void setPlanoDeSaude(PlanoDeSaude planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    // Métodos particulares
    public String exibirResumo() {
        return "Nome: " + nome + "\n" +
                "Data de nascimento: " + dtDeNascimento + "\n" +
                "Deficiência: " + deficiencia + "\n" +
                "Precisa de Responsável? " + precisaDeResponsavel +"\n" + msgResponsavel +  "\n" +
                gestante.exibirResumo();
    }

}
