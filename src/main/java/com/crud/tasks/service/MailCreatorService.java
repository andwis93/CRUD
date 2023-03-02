package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import java.util.ArrayList;
import java.util.List;


@Service
public class MailCreatorService {
    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provide connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://andwis93.github.io/");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("preview_message", "Message From Trello");
        context.setVariable("goodbye_message", "Enjoy your day!");
        context.setVariable("company_name", adminConfig.getCompanyName());
        context.setVariable("company_goal", adminConfig.getCompanyGoal());
        context.setVariable("company_phone", adminConfig.getCompanyPhone());
        context.setVariable("company_email", adminConfig.getCompanyEmail());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildInfTaskEmail(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("Great person");
        functionality.add("Highly motivated");
        functionality.add("Looking for place to do Java");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("preview_message", "Message from Kodilla CRUD app");
        context.setVariable("hello", "Hi there!");
        context.setVariable("goodbye", "Enjoy your day!");
        context.setVariable("button", "Go To Tasks");
        context.setVariable("tasks_url", "https://andwis93.github.io/");
        context.setVariable("show_button", true);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-inf-task-mail", context);
    }


}
