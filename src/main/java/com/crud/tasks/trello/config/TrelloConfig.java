package com.crud.tasks.trello.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class TrelloConfig {
    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;
    @Value("${trello.app.username}")
    private String trelloUserName;
    @Value("${trello.app.key}")
    private String trelloAppKey;
    @Value("${trello.app.token}")
    private String trelloToken;


    public String getTrelloApiEndpoint() {
        return trelloApiEndpoint;
    }

    public void setTrelloApiEndpoint(String trelloApiEndpoint) {
        this.trelloApiEndpoint = trelloApiEndpoint;
    }

    public String getTrelloUserName() {
        return trelloUserName;
    }

    public void setTrelloUserName(String trelloUserName) {
        this.trelloUserName = trelloUserName;
    }

    public String getTrelloAppKey() {
        return trelloAppKey;
    }

    public void setTrelloAppKey(String trelloAppKey) {
        this.trelloAppKey = trelloAppKey;
    }

    public String getTrelloToken() {
        return trelloToken;
    }

    public void setTrelloToken(String trelloToken) {
        this.trelloToken = trelloToken;
    }
}
