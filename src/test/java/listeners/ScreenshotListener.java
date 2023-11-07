package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.sql.DataSource;
import java.io.File;
import java.util.Date;
import java.util.Properties;

public class ScreenshotListener implements ITestListener {
    public String location;
    public File newFile;
    @Override
    public void onTestFailure(ITestResult result){
        String senderEmail = "sender email";
        String senderPassword = "sender password";
        String recipientEmail = "recipient email";
        Object currentClas = result.getInstance();
        WebDriver webDriver = ((BaseTest) currentClas).getDriver();
        screenshotTest(webDriver, result);
        // Option #1
        sendBugReport(senderEmail, senderPassword, recipientEmail, "Bug Report Subject",
                "Bug report details and steps to reproduce", newFile);

        //Option #2
        /*try {
            SendEmail.send(senderEmail, senderPassword, recipientEmail, location);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }*/
    }
    public void screenshotTest(WebDriver driver, ITestResult result) {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        newFile = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            Date date = new Date();
            String screenshotName = result.getName() + "_" + date.toString().replace(":", "_")
                    .replace(" ", "_");
            location = "./Screenshot/" + screenshotName + ".png";
            FileUtils.copyFile(newFile, new File(location));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public void sendBugReport(String senderEmail, String senderPassword, String recipientEmail, String subject, String body, File attachment) {
        // Email configuration
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

        try {
            // Create a message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);

            // Create message body
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(body);

            // Attach the screenshot
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(attachment);

            // Create multipart message
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            // Send the message
            Transport.send(message);
            System.out.println("Bug report sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
