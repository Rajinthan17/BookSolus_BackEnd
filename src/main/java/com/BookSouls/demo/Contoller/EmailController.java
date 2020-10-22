package com.BookSouls.demo.Contoller;



import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookSouls.demo.Service.EmailService;





@RestController
@RequestMapping (value = "/forgot")
public class EmailController {

	 @Autowired
	    private EmailService emailService;

	    @GetMapping(value = "/sendmail")
	    public String sendmail() throws MessagingException {

	        emailService.sendMail("rajinthan.rk@gmail.com", "Test Subject", "Test mail");

	        return "emailsent";
	    }
}
