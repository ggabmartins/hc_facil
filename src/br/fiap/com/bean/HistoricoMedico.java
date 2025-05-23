package br.fiap.com.bean;

public class HistoricoMedico {
    private String doencasPreExistentes;
    private String alergias;
    private String medicamentosEmUso;

    //construtores
    public HistoricoMedico() {
    }

    public HistoricoMedico(String doencasPreExistentes, String alergias, String medicamentosEmUso) {
        this.doencasPreExistentes = doencasPreExistentes;
        this.alergias = alergias;
        this.medicamentosEmUso = medicamentosEmUso;
    }

    //getters e setters

    public String getDoencasPreExistentes() {
        return doencasPreExistentes;
    }

    public void setDoencasPreExistentes(String doencasPreExistentes) {
        this.doencasPreExistentes = doencasPreExistentes;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getMedicamentosEmUso() {
        return medicamentosEmUso;
    }

    public void setMedicamentosEmUso(String medicamentosEmUso) {
        this.medicamentosEmUso = medicamentosEmUso;
    }

    //metodos particulares
    public String exibirResumo() {
        return "Histórico Médico:" +
                "\nDoenças pré-existentes: " + doencasPreExistentes +
                "\nMedicamentos em uso: " + medicamentosEmUso +
                "\nAlergias: " + alergias;
    }
}
