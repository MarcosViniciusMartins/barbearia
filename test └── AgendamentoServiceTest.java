import model.Agendamento;
import model.Cliente;
import model.Servico;
import org.junit.jupiter.api.Test;
import service.AgendamentoService;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class AgendamentoServiceTest {

    @Test
    void deveCriarAgendamento() {

        Cliente cliente =
                new Cliente("Marcos", "9999");

        Servico servico =
                new Servico("Corte", 30);

        AgendamentoService service =
                new AgendamentoService();

        Agendamento agendamento =
                new Agendamento(
                        cliente,
                        servico,
                        LocalDateTime.now()
                );

        assertTrue(
                service.criarAgendamento(
                        agendamento
                )
        );
    }

    @Test
    void naoDevePermitirHorarioDuplicado() {

        Cliente cliente =
                new Cliente("Marcos", "9999");

        Servico servico =
                new Servico("Corte", 30);

        AgendamentoService service =
                new AgendamentoService();

        LocalDateTime horario =
                LocalDateTime.of(
                        2026,
                        7,
                        10,
                        15,
                        0
                );

        Agendamento ag1 =
                new Agendamento(
                        cliente,
                        servico,
                        horario
                );

        Agendamento ag2 =
                new Agendamento(
                        cliente,
                        servico,
                        horario
                );

        service.criarAgendamento(ag1);

        assertFalse(
                service.criarAgendamento(ag2)
        );
    }
}
