package com.BookSouls.demo.Contoller;



import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookSouls.demo.Service.EmailService;





@RestController
@RequestMapping (value = "/sendmail")
public class EmailController {

	 @Autowired
	    private EmailService emailService;

	    @GetMapping(value = "/forgot")
	    public int sendmail(@RequestParam (name = "username") String username) throws MessagingException {
	        return emailService.sendMail(username);
	    }
}
