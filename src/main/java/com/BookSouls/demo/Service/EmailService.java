package com.BookSouls.demo.Service;

import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.BookSouls.Entity.User;
import com.BookSouls.demo.DAO.UserRepository;

@Service
public class EmailService {
	
	@Autowired
	UserRepository userRepository;

    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public int sendMail(String username) throws MessagingException {

    	
    	
//    	 SimpleMailMessage msg = new SimpleMailMessage();
//         msg.setTo(toEmail);
//
//         msg.setSubject("Testing from Spring Boot");
//         msg.setText("Hello World \n Spring Boot Email");
//
//         javaMailSender.send(msg);
    	
    	String toEmail = new String();
    	Optional<User> user = userRepository.findByUsername(username);
    	if(user.isPresent()) {
    		User _user = user.get();
    		toEmail = _user.getEmail();
    	}

    	if(userRepository.existsByEmail(username)) {
    		toEmail = username;
    	}
    	if(toEmail != null) {
	    	int otp = (int) (1000000 * Math.random());
	    	MimeMessage msg = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
	        helper.setTo(toEmail);
	        helper.setSubject("Testing from Spring Boot");
	        helper.setText("We heard that you lost your BookSouls Account password.Sorry about that! <br/> "
	        		+ "But don't worry! You can use the following code to rest it <strong>"+ otp +"</strong> <br/>Thanks,<br/>The BookSouls Team", true);
	
	        helper.addAttachment("BookSolus", new ClassPathResource("logo.jpg"));
	
	        javaMailSender.send(msg);
	        
	        return otp;
    	}
    	return 0;
    }
}
