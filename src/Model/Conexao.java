/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Rodrigo
 */
public class Conexao {

    public static JSONArray clientes = new JSONArray();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);
        System.out.println("Aguardando conexão...");

        while (true) {
            try (Socket conn = server.accept()) {
                System.out.println("Conectado com: "
                        + conn.getInetAddress().getHostAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                PrintWriter out = new PrintWriter(conn.getOutputStream(), true);

                JSONObject request = new JSONObject(in.readLine());
                JSONObject response = new JSONObject();
                if (request.getString("acao").equals("clientes")) {
                    response.put("clientes", clientes.toString());
                } else if (request.getString("acao").equals("conectar")) {
                    clientes.put(request.getJSONObject("mensagem"));
                    response.put("conectado", true);
                }
                out.println(response.toString());
            }
        }
    }
}
