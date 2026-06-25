package model;

import java.time.LocalDateTime;

public class Agendamento {

    private Cliente cliente;
    private Servico servico;
    private LocalDateTime horario;
    private String status;

    public Agendamento(Cliente cliente,
                       Servico servico,
                       LocalDateTime horario) {

        this.cliente = cliente;
        this.servico = servico;
        this.horario = horario;
        this.status = "AGENDADO";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
