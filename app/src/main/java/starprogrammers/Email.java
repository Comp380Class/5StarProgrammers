package starprogrammers;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Email {
    private static String USER_NAME = "5starprogrammers@gmail.com";
    private static String PASSWORD = "wvalhyiaxohievqu";

    private static Reservation res;
    private static Room room; 

    Email(Reservation res, Room room){
        this.res = res;
        this.room = room;
    }

    /**
     * Sends the customer an email with booking information
     */
    public static void sendEmail(String type) {
        final String RECIPIENT = res.getEmail();
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", USER_NAME);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", 587);

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(USER_NAME));
            InternetAddress toAddress = new InternetAddress();

            toAddress = new InternetAddress(RECIPIENT);
            message.addRecipient(Message.RecipientType.TO, toAddress);
            // email will vary based on cancellation, reservation, or changes
            switch(type){
                case "reserve":
                message.setSubject("Reservation for " + res.getName()); 
                message.setText(res.confirmationEmail(room)); break;
                case "cancel":
                message.setSubject("Cancellation for " + res.getName()); 
                message.setText(res.cancellationEmail(room)); break;
                case "change":                
                message.setSubject("Changes for " + res.getName()); 
                message.setText(res.changeEmail(room)); break;
            }

      
            Transport transport = session.getTransport("smtp");
            transport.connect(host, USER_NAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}