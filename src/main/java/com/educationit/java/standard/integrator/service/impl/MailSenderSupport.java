
package com.educationit.java.standard.integrator.service.impl;


import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class MailSenderSupport {


    public MailSenderSupport () {

        super ();
    }

    public void sendMail (final String from, final String to, final String subject,
                          final String msg) {

        Properties props = new Properties ();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                        "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,

            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("byte21.mail.testing","dcd16cqwerty");
                }
        });

         try {

            Message message = new MimeMessage(session);
            message.setFrom (new InternetAddress (from));
            message.setRecipients (Message.RecipientType.TO,
                            InternetAddress.parse(to));
            message.setSubject (subject);

            message.setContent(msg, "text/html; charset=utf-8");


            Transport.send(message);

        } catch (MessagingException e) {

             e.printStackTrace();
         }
    }
}