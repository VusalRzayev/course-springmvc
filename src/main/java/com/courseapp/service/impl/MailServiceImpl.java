package com.courseapp.service.impl;

import com.courseapp.model.MailModel;
import com.courseapp.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailServiceImpl implements MailService {


    @Autowired
    private JavaMailSender javaMailSender;


    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMessage(MailModel mailModel) {
        SimpleMailMessage smm=new SimpleMailMessage();
        smm.setFrom(mailModel.getFrom());
        smm.setTo(mailModel.getTo());
        smm.setSubject(mailModel.getSubject());
        smm.setText(mailModel.getContent());
        javaMailSender.send(smm);
    }
}
