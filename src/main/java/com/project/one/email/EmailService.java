package com.project.one.email;

import com.project.one.config.EmailConfiguration;
import com.project.one.models.request.ClientRegisterInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private EmailConfiguration emailConfiguration;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailTemplate emailTemplate;

    public void sendEmailOnUserRegistration(ClientRegisterInput clientRegisterInput) throws Exception {
        String to = clientRegisterInput.getEmail();
        String from = "shadabeqbal2008@gmail.com"; //emailConfiguration.getAdminEmail();
        String subject = "Email Testing "+clientRegisterInput.getName();

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(to);
        helper.setText(emailTemplate.composeUserRegisterTemplate(clientRegisterInput), true);
        helper.setSubject(subject);
        helper.setFrom(from);

        mailSender.send(message);

    }
}
