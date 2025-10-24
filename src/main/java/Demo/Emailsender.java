package Demo;

import java.io.File;
import java.util.Properties;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class Emailsender {

    public static void main(String[] args) {

        final String sendermail = "akshayvaidya376@gmail.com";
        final String apppassword = "xelxukjosnxosenx"; // your Gmail App Password
        final String reciptionmail = "akshayvaidya376@gmail.com";

        Properties pop = new Properties();
        pop.put("mail.smtp.auth", "true");
        pop.put("mail.smtp.host", "smtp.gmail.com");
        pop.put("mail.smtp.starttls.enable", "true");
        pop.put("mail.smtp.port", "587");

        Session sess = Session.getInstance(pop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sendermail, apppassword);
            }
        });

        sess.setDebug(true);

        try {
            // create mail message
            Message mess = new MimeMessage(sess);
            mess.setFrom(new InternetAddress(sendermail));
            mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reciptionmail));
            mess.setSubject("Test Email From QA Automation");
           // mess.setText("Hello \nThis is a test email from Java.\nRegards,\nQA Team");
            
            // email body part
            MimeBodyPart text= new MimeBodyPart();
            text.setText("Hello \n\nThis is a test email from Java.\n\nRegards,\\nQA Team");
            
            MimeBodyPart attach=new MimeBodyPart();
            String filepath=System.getProperty("user.dir")+"/reports/ExtentReport.html";
            
            System.out.println("attach file path"+filepath);
            attach.attachFile(new File(filepath));
            
            // combine body and attach reports
            
            MimeMultipart multi= new MimeMultipart();
            multi.addBodyPart(text);
            multi.addBodyPart(attach);
            mess.setContent(multi);
            
            
            
            

            // send mail
            Transport.send(mess);
            System.out.println("✅ Mail sent successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
