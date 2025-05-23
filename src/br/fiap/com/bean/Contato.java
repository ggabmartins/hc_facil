package br.fiap.com.bean;

public class Contato {
    private String telefone;
    private String email;

    //Contrutores
    public Contato() {
    }

    public Contato(String telefone, String email) {
        this.telefone = telefone;
        this.email = email;
    }

    public Contato(String telefone, String celular, String email) {
    }

    //getters e setters
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //metodos particulares
    public String exibirResumo() {
        return "Telefone: " + telefone + "\n" +
                "Email: " + email;
    }
}
