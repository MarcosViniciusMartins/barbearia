import model.Agendamento;
import model.Cliente;
import model.Servico;
import observer.ClienteObserver;
import service.AgendamentoService;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        Cliente cliente1 =
                new Cliente(
                        "Marcos",
                        "31999999999"
                );

        Cliente cliente2 =
                new Cliente(
                        "João",
                        "31888888888"
                );

        Servico corte =
                new Servico(
                        "Corte de Cabelo",
                        35.00
                );

        AgendamentoService agenda =
                new AgendamentoService();

        ClienteObserver barbeiro =
                new ClienteObserver(
                        "Barbeiro"
                );

        agenda.adicionarObserver(
                barbeiro
        );

        LocalDateTime horario1 =
                LocalDateTime.of(
                        2026,
                        7,
                        10,
                        14,
                        0
                );

        Agendamento ag1 =
                new Agendamento(
                        cliente1,
                        corte,
                        horario1
                );

        agenda.criarAgendamento(ag1);

        Agendamento ag2 =
                new Agendamento(
                        cliente2,
                        corte,
                        horario1
                );

        agenda.criarAgendamento(ag2);

        agenda.listarAgenda(
                LocalDate.of(
                        2026,
                        7,
                        10
                )
        );

        agenda.cancelarAgendamento(
                horario1
        );

        agenda.listarAgenda(
                LocalDate.of(
                        2026,
                        7,
                        10
                )
        );
    }
}
