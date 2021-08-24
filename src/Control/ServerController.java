package Control;

import Model.DadosConexao;
import org.json.JSONObject;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ServerController extends Thread {
    private DadosConexao cliente;

    public JSONObject getClient() {
        return cliente.getConexaoCliente();
    }

    public ServerController(DadosConexao cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        /*final ScheduledExecutorService conexao = Executors.newScheduledThreadPool(1);
        final Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(countdownStarter);
                countdownStarter--;
                if (countdownStarter < 0) {
                    System.out.println("Timer Over!");
                    scheduler.shutdown();
                    removeClient();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS)*/;
    }

}
