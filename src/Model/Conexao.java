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
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Rodrigo
 */
public class Conexao {

	private static ArrayList<String> portas = new ArrayList<>();
	
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(80);
        System.out.println("Aguardando conexão...");

        while (true) {            
            try (Socket conn = server.accept()) {
                System.out.println("Conectado com: "
                        + conn.getInetAddress().getHostAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                PrintWriter out = new PrintWriter(conn.getOutputStream(), true);

                JSONObject request = new JSONObject(in.readLine());
                JSONObject response = new JSONObject();
                if (request.getString("acao").equals("getClientes")) {

                } else if (request.getString("acao").equals("conectar")) {

                }
                out.println(response.toString());
            }
        }
    }
}
