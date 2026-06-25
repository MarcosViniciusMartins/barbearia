package service;

import model.Agendamento;
import observer.Observer;
import observer.Subject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoService implements Subject {

    private List<Agendamento> agendamentos;
    private List<Observer> observers;

    public AgendamentoService() {
        agendamentos = new ArrayList<>();
        observers = new ArrayList<>();
    }

    @Override
    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers(String mensagem) {
        for (Observer observer : observers) {
            observer.atualizar(mensagem);
        }
    }

    public boolean criarAgendamento(Agendamento novo) {

        for (Agendamento agendamento : agendamentos) {

            if (agendamento.getHorario()
                    .equals(novo.getHorario())
                    && agendamento.getStatus()
                    .equals("AGENDADO")) {

                System.out.println(
                        "Erro: horário já reservado."
                );

                return false;
            }
        }

        agendamentos.add(novo);

        notificarObservers(
                "Novo agendamento para "
                + novo.getCliente().getNome()
        );

        return true;
    }

    public void cancelarAgendamento(
            LocalDateTime horario) {

        for (Agendamento agendamento : agendamentos) {

            if (agendamento.getHorario()
                    .equals(horario)) {

                agendamento.setStatus(
                        "CANCELADO"
                );

                notificarObservers(
                        "Agendamento cancelado."
                );
            }
        }
    }

    public void listarAgenda(LocalDate data) {

        System.out.println("\n===== AGENDA =====");

        for (Agendamento agendamento : agendamentos) {

            if (agendamento.getHorario()
                    .toLocalDate()
                    .equals(data)) {

                System.out.println(
                        "Cliente: "
                        + agendamento.getCliente().getNome()
                        + " | Serviço: "
                        + agendamento.getServico().getNome()
                        + " | Horário: "
                        + agendamento.getHorario()
                        + " | Status: "
                        + agendamento.getStatus()
                );
            }
        }
    }

    public int totalAgendamentos() {
        return agendamentos.size();
    }
}
