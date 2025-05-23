package br.fiap.com.bean;

import javax.swing.*;

public class Responsavel {
    private String nome;
    private String parentesco;
    private Contato contato;

    //construtores
    public Responsavel(){
    }

    public Responsavel(String nome, String parentesco, String telefone, String email) {
        this.nome = nome;
        this.parentesco = parentesco;
        this.contato = new Contato(telefone, email);
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    //metodos particulares
    public String exibirResumo() {
        return "Responsável:\n" +
                "Nome: " + nome + "\n" +
                "Parentesco: " + parentesco + "\n" +
                contato.exibirResumo();
    }

    public static Responsavel cadastrarSeNecessario(int idade) {
        if (idade < 18 || idade > 75) {
            JOptionPane.showMessageDialog(null, "Paciente possui " + idade + " anos.\nCadastro de responsável é obrigatório.");
            String nome = JOptionPane.showInputDialog("Nome do responsável:");
            String parentesco = JOptionPane.showInputDialog("Parentesco com o paciente:");
            String telefone = JOptionPane.showInputDialog("Telefone do responsável:");
            String email = JOptionPane.showInputDialog("Email do responsável:");
            return new Responsavel(nome, parentesco, telefone, email);
        }
        return null;
    }
}

