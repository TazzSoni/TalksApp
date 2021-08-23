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

public class ClientController {

    private DadosConexao cliente;
    private ViewChat chat;

    public ClientController(DadosConexao dados, ViewChat chat) {
        this.cliente = dados;
        this.chat = chat;
    }

    public void connect() throws IOException {
        JSONObject request = new JSONObject();

        request.put("name", "connect");
        request.put("message", this.cliente.getConexaoCliente());
        this.getContatos(request);

        CriaConexao ponte = new CriaConexao(this.cliente, this.chat);
        ponte.start();

        new PingController(this.cliente).start();
    }

    public JSONObject getContatos(JSONObject json) throws IOException {
        Socket socket = new Socket(this.cliente.getServerHost(), this.cliente.getServerPort());
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println(json.toString());
        return new JSONObject(in.readLine());
    }

    public void enviaMenssagem(String texto) throws IOException {
        JSONObject request = new JSONObject();
        request.put("name", "getClients");
        JSONArray clients = new JSONArray(this.getContatos(request).getString("clients"));
        for (int i = 0; i < clients.length(); i++) {
            JSONObject client = clients.getJSONObject(i);
            int port = client.getInt("port");
            if (port == this.cliente.getPublicPort()) {
                continue;
            }
            Socket socket = new Socket(client.getString("host"), port);
            JSONObject json = new JSONObject();
            json.put("name", this.cliente.getNome());
            json.put("message", texto);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(json.toString());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            in.readLine();
            socket.close();
            out.close();
        }
    }
}
