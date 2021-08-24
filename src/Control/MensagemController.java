package Control;

import Model.CriaConexao;
import Model.DadosConexao;
import View.ViewChat;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MensagemController {

    private DadosConexao cliente;
    private ViewChat chat;

    public MensagemController(DadosConexao dados, ViewChat chat) {
        this.cliente = dados;
        this.chat = chat;
    }

    public void conectar() throws IOException {
        JSONObject request = new JSONObject();

        request.put("acao", "conectar");
        request.put("mensagem", this.cliente.getConexaoCliente());
        this.getContatos(request);

        CriaConexao ponte = new CriaConexao(this.cliente, this.chat);
        ponte.start();
    }

    public JSONObject getContatos(JSONObject json) throws IOException {
        Socket socket = new Socket(this.cliente.getServerHost(), this.cliente.getServerPort());
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println(json.toString());
        return new JSONObject(in.readLine());
    }

    public void enviaMensagem(String texto) throws IOException {
        JSONObject request = new JSONObject();
        request.put("acao", "clientes");
        JSONArray clients = new JSONArray(this.getContatos(request).getString("clientes"));

        for (int i = 0; i < clients.length(); i++) {
            JSONObject client = clients.getJSONObject(i);
            int port = client.getInt("port");

            if (port == this.cliente.getPublicPort()) {
                continue;
            }

            Socket socket = new Socket(client.getString("host"), port);
            JSONObject json = new JSONObject();

            json.put("nome", this.cliente.getNome());
            json.put("mensagem", texto);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(json.toString());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            in.readLine();
            socket.close();
            out.close();
        }
    }
}
