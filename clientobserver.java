package observer;

public class ClienteObserver implements Observer {

    private String nome;

    public ClienteObserver(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println(
                "[NOTIFICAÇÃO] "
                + nome
                + ": "
                + mensagem
        );
    }
}
