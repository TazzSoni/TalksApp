package Model;

import org.json.JSONObject;

/**
 * @author Samuel
 */
public class DadosConexao {
    private String nome;
    private int privatePort;
    private int publicPort;
    private String host;
    private String serverHost;
    private int serverPort;

    public String getServerHost() {
        return serverHost;
    }

    public int getServerPort() {
        return serverPort;
    }

    public String getNome() {
        return nome;
    }

    public int getPrivatePort() {
        return privatePort;
    }

    public int getPublicPort() {
        return publicPort;
    }

    public String getHost() {
        return host;
    }

    public DadosConexao(String nome, int privatePort, int publicPort, String host, String serverHost, int serverPort) {
        this.nome = nome;
        this.privatePort = privatePort;
        this.publicPort = publicPort;
        this.host = host;
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }

    public JSONObject getConexaoCliente() {
        JSONObject json = new JSONObject();
        json.put("host", this.getHost());
        json.put("port", this.getPublicPort());
        return json;
    }
}
