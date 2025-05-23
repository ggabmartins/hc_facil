package br.fiap.com.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

public class Agendamento {
    private LocalDate dataConsulta;
    private LocalTime horarioConsulta;
    private Paciente paciente;

    // Construtor vazio
    public Agendamento() {
    }

    // Construtor com LocalDate e LocalTime
    public Agendamento(LocalDate data, LocalTime horario, Paciente paciente) {
        this.dataConsulta = data;
        this.horarioConsulta = horario;
        this.paciente = paciente;
    }

    // Construtor que recebe data e hora em String, converte para LocalDate e LocalTime
    public Agendamento(String dataConsultaStr, String horaConsultaStr, Paciente paciente) {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        try {
            this.dataConsulta = LocalDate.parse(dataConsultaStr, formatoData);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Data inválida no agendamento! Use dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
            this.dataConsulta = null;
        }
        try {
            this.horarioConsulta = LocalTime.parse(horaConsultaStr, formatoHora);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Horário inválido no agendamento! Use HH:mm.", "Erro", JOptionPane.ERROR_MESSAGE);
            this.horarioConsulta = null;
        }
        this.paciente = paciente;
    }

    public Agendamento(LocalDateTime dataHoraConsulta, String especialidade, String local) {

    }

    // Getters e setters
    public LocalDate getData() {
        return dataConsulta;
    }

    public void setData(LocalDate data) {
        this.dataConsulta = data;
    }

    public LocalTime getHorario() {
        return horarioConsulta;
    }

    public void setHorario(LocalTime horario) {
        this.horarioConsulta = horario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    // Método para exibir resumo do agendamento
    public String exibirResumo() {
        if (dataConsulta == null || horarioConsulta == null) {
            return "Agendamento inválido.";
        }
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        return "Data: " + dataConsulta.format(formatoData) + "\n" +
                "Horário: " + horarioConsulta.format(formatoHora) + "\n" +
                paciente.exibirResumo();
    }
}