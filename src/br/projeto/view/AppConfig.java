package br.projeto.view;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    private static final String CONFIG_FILE = "config.properties";
    private static final String EMAIL_KEY = "email";

    public static String getEmail() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            // Arquivo não existe ou não pode ser lido
            return null;
        }
        return properties.getProperty(EMAIL_KEY);
    }

    public static void setEmail(String email) {
        Properties properties = new Properties();
        properties.setProperty(EMAIL_KEY, email);
        try (FileOutputStream fileOutputStream = new FileOutputStream(CONFIG_FILE)) {
            properties.store(fileOutputStream, "Configurações do aplicativo");
        } catch (IOException e) {
            // Erro ao salvar o arquivo de configuração
        }
    }
}
