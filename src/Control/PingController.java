package Control;

import Model.DadosConexao;
import org.json.JSONObject;

import java.io.PrintWriter;
import java.net.Socket;

public class PingController extends Thread {
    private DadosConexao cliente;

    public PingController(DadosConexao cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = new Socket(this.cliente.getServerHost(), this.cliente.getServerPort());
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                JSONObject json = new JSONObject();

                json.put("acao", "ping");
                json.put("mensagem", this.cliente.getConexaoCliente());

                out.println(json.toString());

                socket.close();
                out.close();
                Thread.sleep(1000);
            } catch (Exception e) {
                break;
            }
        }
    }
}
