package com.crud.tasks.trello.client;

import com.crud.tasks.domain.CreateTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.*;

@Component
@RequiredArgsConstructor
public class TrelloClient {
    private final RestTemplate restTemplate;
    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;
    @Value("${trello.app.username}")
    private String trelloUserName;
    @Value("${trello.app.key}")
    private String trelloAppKey;
    @Value("${trello.app.token}")
    private String trelloToken;

    private URI uriBuild() {
        try {
            return UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/" + trelloUserName + "/boards")
                    .queryParam("key", trelloAppKey)
                    .queryParam("token", trelloToken)
                    .queryParam("fields", "name,id")
                    .queryParam("lists", "all")
                    .build()
                    .encode()
                    .toUri();
        } catch (Exception err)  {
            throw new IllegalArgumentException(err.getMessage(),err);
        }
    }

    public List<TrelloBoardDto> getTrelloBoards() {

        TrelloBoardDto[] boardsResponse = restTemplate.getForObject(uriBuild(), TrelloBoardDto[].class);

        List<TrelloBoardDto> trelloBoardDtoList = Optional.ofNullable(boardsResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());

        return trelloBoardDtoList.stream()
                .filter(name -> name.getName() != null)
                .filter(id -> id.getId() != null)
                .filter(name -> name.getName().contains("Kodilla"))
                .toList();
    }

    public CreateTrelloCard createNewCard(TrelloCardDto trelloCardDto) {
        URI url = UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/cards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("name", trelloCardDto.getName())
                .queryParam("desc", trelloCardDto.getDescription())
                .queryParam("pos", trelloCardDto.getPos())
                .queryParam("idList", trelloCardDto.getListId())
                .build()
                .encode()
                .toUri();

        return restTemplate.postForObject(url, null, CreateTrelloCard.class);
    }

//    private URI uriBuildForCardGet() {
//        try {
//            return UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/boards/636cc8f3d867bd0029c52a00/cards" )
//                    .queryParam("key", trelloAppKey)
//                    .queryParam("token", trelloToken)
//                    .queryParam("name", "name")
//                    .queryParam("desc", "desc")
//                    .queryParam("pos", "pos")
//                    .queryParam("idList", "idList")
//                    .build()
//                    .encode()
//                    .toUri();
//        } catch (Exception err)  {
//            throw new IllegalArgumentException(err.getMessage(),err);
//        }
//    }
//
//    public List<TrelloCardDto> getTrelloCard() {
//        TrelloCardDto[] cardsResponse = restTemplate.getForObject(uriBuildForCardGet(), TrelloCardDto[].class);
//              return Optional.ofNullable(cardsResponse)
//                      .map(Arrays::asList)
//                      .orElse(Collections.emptyList());
//    }

}
