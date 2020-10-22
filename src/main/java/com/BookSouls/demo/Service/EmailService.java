package com.BookSouls.demo.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String toEmail, String subject, String message) throws MessagingException {

//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//
//        mailMessage.setTo(toEmail);
//        mailMessage.setSubject(subject);
//        mailMessage.setText(message);
//        
//
//        mailMessage.setFrom("booksoulsmailmanager@gmail.com");
//
//        javaMailSender.send(mailMessage);
    	
//    	 SimpleMailMessage msg = new SimpleMailMessage();
//         msg.setTo(toEmail);
//
//         msg.setSubject("Testing from Spring Boot");
//         msg.setText("Hello World \n Spring Boot Email");
//
//         javaMailSender.send(msg);
    	
    	MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(toEmail);

        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("We heard that you lost your BookSouls Account password.Sorry about that! <br/> "
        		+ "But don't worry! You can use the following code to rest it <br/>Thanks,<br/>The BookSouls Team", true);

        helper.addAttachment("BookSolus", new ClassPathResource("logo.jpg"));

        javaMailSender.send(msg);
    }
}
