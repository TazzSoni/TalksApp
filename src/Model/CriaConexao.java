/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.ViewChat;
import org.json.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Rodrigo
 */
public class CriaConexao extends Thread {
    //private ChatView view;
    private DadosConexao cliente;
    private ViewChat chat;
    private BufferedReader in;

    public CriaConexao(DadosConexao cliente, ViewChat chat) {
        this.cliente = cliente;
        this.chat = chat;
    }

    @Override
    public void run() {
        ServerSocket servidor = null;
        try {
            servidor = new ServerSocket(this.cliente.getPrivatePort());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                Socket cliente = servidor.accept();
                this.in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);
                String clienteMenssagem = this.in.readLine();
                if (clienteMenssagem == null || clienteMenssagem.equals("null")) {
                    break;
                }
                JSONObject json = new JSONObject(clienteMenssagem);

                //Cria a mensagem na tela do cliente e retorna
                JSONObject response = new JSONObject();
                response.put("recebida", true);
                out.println(response.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
