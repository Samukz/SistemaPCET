

import javax.mail.Message;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;


public class PasswordResetEmail {

    private final String fromEmail = "noreply@doitlogistica.com"; // E-mail remetente
    private final String password = "zdoiebmcukihnqiu"; // Senha do e-mail remetente
    private final String toEmail; // E-mail destinatário
    private final String subject = "Redefinição de Senha"; // Assunto do e-mail
    private String newPassword; // Nova senha gerada

    public PasswordResetEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public void sendPasswordResetEmail() {
        // Gerar nova senha
        newPassword = generateNewPassword();

        // Configurar propriedades do servidor de e-mail
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");




        // Autenticar com o servidor de e-mail
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, password);
                    }
                });

        try {
            // Criar mensagem de e-mail
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText("Sua nova senha de acesso ao sistema GET é: " + newPassword);

            // Enviar mensagem de e-mail
            Transport.send(message);

            System.out.println("E-mail enviado com sucesso!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private String generateNewPassword() {
    String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    StringBuilder password = new StringBuilder();
    Random random = new Random();

    for (int i = 0; i < 6; i++) {
        int index = random.nextInt(validChars.length());
        char c = validChars.charAt(index);
        password.append(c);
    }

    return password.toString();
}

    public String getNewPassword() {
        
        
        return newPassword;
    }

    public static void main(String[] args) {
        // Exemplo de uso
        String toEmail = "samuelsilva@doitlogistica.com"; // E-mail do destinatário
        PasswordResetEmail passwordResetEmail = new PasswordResetEmail(toEmail);
        passwordResetEmail.sendPasswordResetEmail();
        String newPassword = passwordResetEmail.getNewPassword();
//        System.out.println("Nova senha gerada: " + newPassword);
    }
    
}

