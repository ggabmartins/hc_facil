package br.fiap.com.main;

import br.fiap.com.bean.Paciente;
import br.fiap.com.bean.Responsavel;
import br.fiap.com.bean.Gestante;
import br.fiap.com.bean.Endereco;
import br.fiap.com.bean.Contato;
import br.fiap.com.bean.HistoricoMedico;
import br.fiap.com.bean.PlanoDeSaude;
import br.fiap.com.bean.Agendamento;
import br.fiap.com.bean.Consulta;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MainPaciente {
    public static void main(String[] args) {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Paciente paciente = null;

        // Nome do paciente
        JOptionPane.showMessageDialog(null, "Ola seja bem vindo (a) ao HC-Facil! \nPara iniciar clique em OK.", "Bem-Vindo(a)",
                JOptionPane.INFORMATION_MESSAGE);
        String nomePaciente = "";
        while (nomePaciente == null || nomePaciente.equals("")) {
            nomePaciente = JOptionPane.showInputDialog(null,
                    "Digite o nome do paciente:", "Nome do Paciente", JOptionPane.QUESTION_MESSAGE);
            if (nomePaciente == null || nomePaciente.equals("")) {
                JOptionPane.showMessageDialog(null, "Nome do paciente não pode ficar vazio.");
            }
        }

        // Data de nascimento
        LocalDate dtDeNascimento = null;
        while (dtDeNascimento == null) {
            try {
                String dataNascStr = JOptionPane.showInputDialog(null,
                        "Digite a data de nascimento (dd/MM/yyyy):", "Data de Nascimento", JOptionPane.QUESTION_MESSAGE);
                if (dataNascStr == null || dataNascStr.equals("")) {
                    JOptionPane.showMessageDialog(null, "Data de nascimento não pode ficar vazia.");
                    continue;
                }
                LocalDate data = LocalDate.parse(dataNascStr, formatoData);
                if (data.isAfter(LocalDate.now())) {
                    JOptionPane.showMessageDialog(null,
                            "Data de nascimento não pode ser no futuro.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                dtDeNascimento = data;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Data inválida! Use o formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Sexo do paciente
        String sexoPaciente = "";
        while (sexoPaciente.equals("")) {
            String inputSexo = JOptionPane.showInputDialog(null,
                    "Digite o sexo do paciente:\nM = Masculino\nF = Feminino",
                    "Sexo do Paciente", JOptionPane.QUESTION_MESSAGE);
            if (inputSexo == null || inputSexo.equals("")) {
                JOptionPane.showMessageDialog(null, "Sexo não pode ficar vazio.");
                continue;
            }
            inputSexo = inputSexo.toUpperCase();
            switch (inputSexo) {
                case "M":
                    sexoPaciente = "Masculino";
                    break;
                case "F":
                    sexoPaciente = "Feminino";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Digite M ou F.");
            }
        }

        // Deficiência
        String deficienciaPaciente = "";
        while (deficienciaPaciente.equals("")) {
            String inputDeficiencia = JOptionPane.showInputDialog(null,
                    "Paciente possui deficiência?\nS - Sim\nN - Não",
                    "Deficiência", JOptionPane.QUESTION_MESSAGE);
            if (inputDeficiencia == null || inputDeficiencia.equals("")) {
                JOptionPane.showMessageDialog(null, "Resposta não pode ficar vazia.");
                continue;
            }
            inputDeficiencia = inputDeficiencia.toUpperCase();
            switch (inputDeficiencia) {
                case "S":
                    String descricaoDeficiencia = "";
                    while (descricaoDeficiencia == null || descricaoDeficiencia.equals("")) {
                        descricaoDeficiencia = JOptionPane.showInputDialog(null,
                                "Digite a deficiência do paciente:", "Deficiência do Paciente", JOptionPane.QUESTION_MESSAGE);
                        if (descricaoDeficiencia == null || descricaoDeficiencia.equals("")) {
                            JOptionPane.showMessageDialog(null, "Descrição da deficiência não pode ficar vazia.");
                        }
                    }
                    deficienciaPaciente = descricaoDeficiencia;
                    break;
                case "N":
                    deficienciaPaciente = "Não possui.";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Digite S ou N.");
            }
        }


        paciente = new Paciente(nomePaciente, dtDeNascimento, deficienciaPaciente, sexoPaciente);


        int idade = Period.between(dtDeNascimento, LocalDate.now()).getYears();
        Responsavel responsavel = null;
        if (idade < 18 || idade > 75) {
            JOptionPane.showMessageDialog(null,
                    "Paciente tem " + idade + " anos. Cadastro de responsável obrigatório.","Cadastro obrigatório", JOptionPane.INFORMATION_MESSAGE);

            String nomeResponsavel = "";
            while (nomeResponsavel == null || nomeResponsavel.equals("")) {
                nomeResponsavel = JOptionPane.showInputDialog(null,"Nome do responsável:", "Nome do Responsável", JOptionPane.QUESTION_MESSAGE);
                if (nomeResponsavel == null || nomeResponsavel.equals("")) {
                    JOptionPane.showMessageDialog(null, "Nome do responsável não pode ficar vazio.","Erro",JOptionPane.ERROR_MESSAGE);
                }
            }

            String parentesco = "";
            while (parentesco == null || parentesco.equals("")) {
                parentesco = JOptionPane.showInputDialog(null,"Parentesco com o paciente:", "Parentesco", JOptionPane.QUESTION_MESSAGE);
                if (parentesco == null || parentesco.equals("")) {
                    JOptionPane.showMessageDialog(null, "Parentesco não pode ficar vazio.","Erro",JOptionPane.ERROR_MESSAGE);
                }
            }

            String telefoneResponsavel = "";
            while (telefoneResponsavel == null || telefoneResponsavel.equals("")) {
                telefoneResponsavel = JOptionPane.showInputDialog(null,"Telefone do responsável:", "Telefone do Responsável", JOptionPane.QUESTION_MESSAGE);
                if (telefoneResponsavel == null || telefoneResponsavel.equals("")) {
                    JOptionPane.showMessageDialog(null, "Telefone não pode ficar vazio.","Erro",JOptionPane.ERROR_MESSAGE);
                }
            }

            String emailResponsavel = "";
            while (emailResponsavel == null || emailResponsavel.equals("")) {
                emailResponsavel = JOptionPane.showInputDialog(null,"Email do responsável:", "Email do responsável", JOptionPane.QUESTION_MESSAGE);
                if (emailResponsavel == null || emailResponsavel.equals("")) {
                    JOptionPane.showMessageDialog(null, "Email não pode ficar vazio.","Erro",JOptionPane.ERROR_MESSAGE);
                }
            }

            responsavel = new Responsavel(nomeResponsavel, parentesco, telefoneResponsavel, emailResponsavel);
        }

        // Declaração inicial da variável gestante
        Gestante gestante = null;
        String respostaGestante = "";

// Verifica se o paciente é do sexo feminino para perguntar sobre gestação
        if (sexoPaciente.equalsIgnoreCase("Feminino")) {
            while (!respostaGestante.equals("S") && !respostaGestante.equals("N")) {
                String resposta = JOptionPane.showInputDialog(null,
                        "Paciente está gestante? (S/N)", "Gestante", JOptionPane.QUESTION_MESSAGE);

                if (resposta == null || resposta.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Resposta obrigatória.");
                    continue;
                }

                resposta = resposta.toUpperCase();

                switch (resposta) {
                    case "S":
                        int meses = -1;
                        while (meses < 0 || meses > 9) {
                            try {
                                String mesesStr = JOptionPane.showInputDialog(null,
                                        "Digite quantos meses de gestação (0 a 9):",
                                        "Meses de Gestação", JOptionPane.QUESTION_MESSAGE);
                                if (mesesStr == null || mesesStr.trim().isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Resposta obrigatória.");
                                    continue;
                                }
                                meses = Integer.parseInt(mesesStr);
                                if (meses < 0 || meses > 9) {
                                    JOptionPane.showMessageDialog(null,
                                            "Número inválido, digite um valor entre 0 e 9.");
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Digite um número válido.");
                                meses = -1;
                            }
                        }
                        gestante = new Gestante("Sim", meses);  // Usando construtor correto
                        respostaGestante = "S";
                        break;

                    case "N":
                        gestante = new Gestante("Não", 0);
                        respostaGestante = "N";
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida. Digite S ou N.");
                }
            }
        } else {
            gestante = new Gestante("Não se aplica", 0);
        }

        JOptionPane.showMessageDialog(null, "Vamos para o cadastro do endereco do paciente.\nPara continuar clique em OK",
                "Cadastro do endereco", JOptionPane.INFORMATION_MESSAGE);
        Endereco endereco = null;
        String rua, numero, bairro, cidade, estado, cep;

        rua = "";
        while (rua == null || rua.equals("")) {
            rua = JOptionPane.showInputDialog(null, "Digite a rua:", "Endereço - Rua", JOptionPane.QUESTION_MESSAGE);
            if (rua == null || rua.equals("")) {
                JOptionPane.showMessageDialog(null, "Rua não pode ficar vazia.");
            }
        }
        numero = "";
        while (numero == null || numero.equals("")) {
            numero = JOptionPane.showInputDialog(null, "Digite o número:", "Endereço - Número", JOptionPane.QUESTION_MESSAGE);
            if (numero == null || numero.equals("")) {
                JOptionPane.showMessageDialog(null, "Número não pode ficar vazio.");
            }
        }
        bairro = "";
        while (bairro == null || bairro.equals("")) {
            bairro = JOptionPane.showInputDialog(null, "Digite o bairro:", "Endereço - Bairro", JOptionPane.QUESTION_MESSAGE);
            if (bairro == null || bairro.equals("")) {
                JOptionPane.showMessageDialog(null, "Bairro não pode ficar vazio.");
            }
        }
        cidade = "";
        while (cidade == null || cidade.equals("")) {
            cidade = JOptionPane.showInputDialog(null, "Digite a cidade:", "Endereço - Cidade", JOptionPane.QUESTION_MESSAGE);
            if (cidade == null || cidade.equals("")) {
                JOptionPane.showMessageDialog(null, "Cidade não pode ficar vazia.");
            }
        }
        estado = "";
        while (estado == null || estado.equals("")) {
            estado = JOptionPane.showInputDialog(null, "Digite o estado:", "Endereço - Estado", JOptionPane.QUESTION_MESSAGE);
            if (estado == null || estado.equals("")) {
                JOptionPane.showMessageDialog(null, "Estado não pode ficar vazio.");
            }
        }
        cep = "";
        while (cep == null || cep.equals("")) {
            cep = JOptionPane.showInputDialog(null, "Digite o CEP:", "Endereço - CEP", JOptionPane.QUESTION_MESSAGE);
            if (cep == null || cep.equals("")) {
                JOptionPane.showMessageDialog(null, "CEP não pode ficar vazio.");
            }
        }
        endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);

        JOptionPane.showMessageDialog(null, "Agora o cadastro do contato do paciente. \nClique em OK para continuar.");
        Contato contato = null;
        try {
            String telefone = JOptionPane.showInputDialog(null,
                    "Digite o telefone do paciente:", "Contato - Telefone", JOptionPane.QUESTION_MESSAGE);
            String email = JOptionPane.showInputDialog(null,
                    "Digite o email do paciente:", "Contato - Email", JOptionPane.QUESTION_MESSAGE);
            contato = new Contato(telefone, email);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar contato.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        // Histórico Médico
        JOptionPane.showMessageDialog(null, "Hora de cadastrar o historico medico do paciente.\nClique em OK para conti" +
                "nuar.", "Cadastro do historico medico", JOptionPane.INFORMATION_MESSAGE);
        HistoricoMedico historicoMedico = null;
        String doencas = "Nenhuma", alergias = "Nenhuma", medicamentos = "Nenhum";
        try {
            // Doenças
            String respostaDoenca = "";
            while (!respostaDoenca.equals("S") && !respostaDoenca.equals("N")) {
                respostaDoenca = JOptionPane.showInputDialog(null,
                        "O paciente possui doenças?\nS - Sim\nN - Não",
                        "Histórico Médico - Doenças", JOptionPane.QUESTION_MESSAGE);
                if (respostaDoenca != null) respostaDoenca = respostaDoenca.toUpperCase();
                switch (respostaDoenca) {
                    case "S":
                        doencas = JOptionPane.showInputDialog(null,
                                "Digite as doenças do paciente (separadas por vírgula):",
                                "Histórico Médico - Doenças", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "N":
                        doencas = "Nenhuma";
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,
                                "Opção inválida. Digite S ou N.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            // Alergias
            String respostaAlergia = "";
            while (!respostaAlergia.equals("S") && !respostaAlergia.equals("N")) {
                respostaAlergia = JOptionPane.showInputDialog(null,
                        "O paciente possui alergias?\nS - Sim\nN - Não",
                        "Histórico Médico - Alergias", JOptionPane.QUESTION_MESSAGE);
                if (respostaAlergia != null) respostaAlergia = respostaAlergia.toUpperCase();
                switch (respostaAlergia) {
                    case "S":
                        alergias = JOptionPane.showInputDialog(null,
                                "Digite as alergias do paciente (separadas por vírgula):",
                                "Histórico Médico - Alergias", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "N":
                        alergias = "Nenhuma";
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,
                                "Opção inválida. Digite S ou N.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            // Medicamentos
            String respostaMedicamento = "";
            while (!respostaMedicamento.equals("S") && !respostaMedicamento.equals("N")) {
                respostaMedicamento = JOptionPane.showInputDialog(null,
                        "O paciente faz uso de medicamentos?\nS - Sim\nN - Não",
                        "Histórico Médico - Medicamentos", JOptionPane.QUESTION_MESSAGE);
                if (respostaMedicamento != null) respostaMedicamento = respostaMedicamento.toUpperCase();
                switch (respostaMedicamento) {
                    case "S":
                        medicamentos = JOptionPane.showInputDialog(null,
                                "Digite os medicamentos que o paciente utiliza (separados por vírgula):",
                                "Histórico Médico - Medicamentos", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "N":
                        medicamentos = "Nenhum";
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,
                                "Opção inválida. Digite S ou N.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            historicoMedico = new HistoricoMedico(doencas, alergias, medicamentos);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao cadastrar histórico médico.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        // Plano de Saúde
        JOptionPane.showMessageDialog(null, "Cadastro do plano de saude. \nClique em OK para continuar.", "Plano de saude"
                , JOptionPane.INFORMATION_MESSAGE);
        PlanoDeSaude planoDeSaude = null;
        DateTimeFormatter formatoValidade = DateTimeFormatter.ofPattern("MM/yyyy");
        try {
            String respostaPlano = "";
            String nomePlano = "Não possui plano de saúde.";
            String numeroCarteira = "";
            LocalDate validadeCarteira = null;
            while (!respostaPlano.equals("S") && !respostaPlano.equals("N")) {
                respostaPlano = JOptionPane.showInputDialog(null,
                        "O paciente possui plano de saúde?\nS - Sim\nN - Não",
                        "Plano de Saúde", JOptionPane.QUESTION_MESSAGE);
                if (respostaPlano != null) respostaPlano = respostaPlano.toUpperCase();
                switch (respostaPlano) {
                    case "S":
                        nomePlano = JOptionPane.showInputDialog(null,
                                "Digite o nome do plano de saúde:", "Plano de Saúde", JOptionPane.INFORMATION_MESSAGE);
                        numeroCarteira = JOptionPane.showInputDialog(null,
                                "Digite o número da carteirinha:", "Plano de Saúde", JOptionPane.INFORMATION_MESSAGE);
                        while (validadeCarteira == null) {
                            try {
                                String validadeStr = JOptionPane.showInputDialog(null,
                                        "Digite a validade da carteirinha (MM/yyyy):",
                                        "Plano de Saúde", JOptionPane.QUESTION_MESSAGE);
                                validadeCarteira = LocalDate.parse("01/" + validadeStr,
                                        DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Data inválida. Use o formato MM/yyyy.", "Erro",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        break;
                    case "N":
                        validadeCarteira = LocalDate.of(1900, 1, 1);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,
                                "Opção inválida. Digite S ou N.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            planoDeSaude = new PlanoDeSaude(nomePlano, numeroCarteira, validadeCarteira);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao cadastrar plano de saúde.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        JOptionPane.showMessageDialog(null, "Agendamento da consulta. \nClique em OK para continuar.", "Agendamento da consulta",
                JOptionPane.INFORMATION_MESSAGE);

        Agendamento agendamento = null;
        while (agendamento == null) {
            try {
                String dataStr = JOptionPane.showInputDialog(
                        null,
                        "Digite a data e hora da consulta (dd/MM/yyyy HH:mm):",
                        "Agendamento de Consulta",
                        JOptionPane.QUESTION_MESSAGE
                );
                if (dataStr == null) {
                    JOptionPane.showMessageDialog(
                            null, "Agendamento cancelado.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                LocalDateTime dataHoraConsulta = LocalDateTime.parse(dataStr, formatoDataHora);
                agendamento = new Agendamento(dataHoraConsulta.toLocalDate(), dataHoraConsulta.toLocalTime(), paciente);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato inválido. Use o padrão dd/MM/yyyy HH:mm para a data e hora.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }


        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime dataHoraAgendada = LocalDateTime.of(
                agendamento.getData(),
                agendamento.getHorario()
        );

        String descricaoConsulta;
        if (dataHoraAgendada.isAfter(agora)) {
            descricaoConsulta = "Consulta ainda não realizada";
        } else {

            JOptionPane.showMessageDialog(null, "Registro da descrição da consulta. \nClique em OK para continuar.",
                    "Descrição da consulta", JOptionPane.INFORMATION_MESSAGE);
            descricaoConsulta = "";
            String continuar = "";
            while (!continuar.equals("S")) {
                try {
                    String descriçãoDaConsulta = JOptionPane.showInputDialog(null, "Digite a descrição da consulta realizada:",
                            "Descrição da Consulta",JOptionPane.QUESTION_MESSAGE);
                    if (descriçãoDaConsulta == null) {
                        JOptionPane.showMessageDialog(null, "Cadastro da consulta cancelado.", "Cancelado",
                                JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    if (descriçãoDaConsulta.trim().isEmpty()) {
                        throw new Exception("vazio");
                    }
                    descricaoConsulta = descriçãoDaConsulta;
                    continuar = "S";
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Descrição não pode ficar vazia.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        String resumo = "=== Resumo da Consulta ===\n";
        resumo += agendamento.exibirResumo();
        resumo += "\nDescrição: " + descricaoConsulta;


        if (responsavel != null) {
            resumo += "\n\n=== Responsável pelo Paciente ===\n"
                    + responsavel.exibirResumo();
        }


        if (gestante != null && "Sim".equalsIgnoreCase(gestante.getGravida())) {
            resumo += "\n\n=== Informações sobre Gestação ===\n"
                    + gestante.exibirResumo();
        }


        if (endereco != null) {
            resumo += "\n\n=== Endereço do Paciente ===\n"
                    + endereco.exibirResumo();
        }


        if (contato != null) {
            resumo += "\n\n=== Contato do Paciente ===\n"
                    + contato.exibirResumo();
        }


        if (historicoMedico != null) {
            resumo += "\n\n=== Histórico Médico ===\n"
                    + historicoMedico.exibirResumo();
        }


        if (planoDeSaude != null) {
            resumo += "\n\n=== Plano de Saúde ===\n"
                    + planoDeSaude.exibirResumo();
        }

        JOptionPane.showMessageDialog(
                null,
                resumo,
                "Resumo Geral do Paciente",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}