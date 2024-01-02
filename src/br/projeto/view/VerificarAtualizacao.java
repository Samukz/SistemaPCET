package br.projeto.view;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class VerificarAtualizacao {

    // Definir a versão atual do programa
    private static final String VERSAO_ATUAL = "0.0.0";

    // Método para verificar se há uma nova versão disponível
    public static boolean verificarAtualizacao() throws IOException {

        // Obter a versão mais recente do programa
        String ultimaVersao = obterUltimaVersao();

        // Comparar as versões
        if (!VERSAO_ATUAL.equals(ultimaVersao)) {
            return true;
        } else {
            return false;
        }
    }

    // Método para obter a última versão do programa a partir de um arquivo de texto remoto
    private static String obterUltimaVersao() throws IOException {
        URL url = new URL("https://pastebin.com/raw/NT1eW4Rd");
        URLConnection conn = url.openConnection();
        BufferedReader leitor = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String ultimaVersao = leitor.readLine();
        leitor.close();
        return ultimaVersao;
    }
}
