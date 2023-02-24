package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import java.util.Optional;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SimpleEmailServiceTest {

//    @InjectMocks
//    private SimpleEmailService simpleEmailService;
//
//    @Mock
//    private JavaMailSender javaMailSender;
//
//    @Test
//    public void shouldSendEmail() {
//        //Give
//        Mail mail = new Mail.MailBuilder()
//                .mailTo("test@test.com")
//                .subject("Test")
//                .message("Test Message")
//                .toCcs("testCc@testCc.com")
//                .toCcs("SecondTestCc@testCc.com")
//                .build();
//
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//
//        mailMessage.setTo(mail.getMailTo());
//        mailMessage.setSubject(mail.getSubject());
//        mailMessage.setText(mail.getMessage());
//        Optional.ofNullable(mail.getToCcs()).ifPresent(Cc -> mailMessage.setCc(mail.getToCcs()));
//
//        //When
//        simpleEmailService.send(mail);
//
//        //Then
//        verify(javaMailSender, times(1)).send(mailMessage);
//    }
}