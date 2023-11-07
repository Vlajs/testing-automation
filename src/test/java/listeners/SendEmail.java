/*
package listeners;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.sql.DataSource;
import java.util.Properties;
public class SendEmail3 {
    public static void sendmail(){
        final String username = "YourEmail";
        final String password = "YourPassword";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "mail.example.com");
        props.put("mail.smtp.port", "25");
        props.put("java.net.preferIPv4Stack", "true");
        Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
        }
        });

        try {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("YourEmail"));
        message.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse("Emailid to which you want to send Report"));
        message.setSubject("Email Subject");



        BodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Body text");

//4) create new MimeBodyPart object and set DataHandler object to this object
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();

        String filename = "File path if you want to attach in mail";//change accordingly
        DataSource source = new FileDataSource(filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(filename);


//5) create Multipart object and add MimeBodyPart objects to this object
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);

//6) set the multiplart object to the message object
        message.setContent(multipart );
        Transport.send(message);

        System.out.println("Mail Sent Successfully");

        } catch (MessagingException e) {
        throw new RuntimeException(e);
        }
    }}*/
package listeners;
import org.testng.annotations.AfterTest;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class SendEmail {
    @AfterTest
    public static void send(String senderEmail, String senderPassword, String recipientEmail, String file) throws MessagingException{

        //Recipient's Mail id
        String receipientTo = recipientEmail;

        //Sender's Mail id
        String senderFrom = senderEmail;

        //Path of PDF test report
        String path = file;

        //Getting System properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.port", "587");

        // Create a Session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        MimeMessage msg = new MimeMessage(session);

        //Instance of From Internet address
        InternetAddress frmAddress = new InternetAddress(senderFrom);

        //Instance of To Internet address
        InternetAddress toAddress = new InternetAddress(receipientTo);

        //Setting up sender's address
        msg.setFrom(frmAddress);

        //Setting up recipient's address
        msg.addRecipient(Message.RecipientType.TO, toAddress);

        //Setting email's subject
        msg.setSubject("Test Status Report");

        BodyPart msgBody = new MimeBodyPart();

        //Setting email's message body
        msgBody.setText("This is test report through mail");

        //Instance of second part
        Multipart multiPart = new MimeMultipart();

        multiPart.addBodyPart(msgBody);

        //Another mail body
        msgBody = new MimeBodyPart();

        //Path to pdf file for attachment
        DataSource source = new FileDataSource(path);

        DataHandler dataHandler = new DataHandler(source);

        msgBody.setDataHandler(dataHandler);

        msgBody.setFileName(path);

        multiPart.addBodyPart(msgBody);

        msg.setContent(multiPart);

        // Send the message
        Transport.send(msg);
        System.out.println("Bug report sent successfully.");


    }
}