package com.crud.tasks.controller;

import com.crud.tasks.domain.CreateTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("v1/trello")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TrelloController {

    private final TrelloClient trelloClient;

    @GetMapping("boards")
    public void getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.forEach(trelloBoardDto -> {
            System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
            System.out.println("This board contains lists: ");
            trelloBoardDto.getLists().forEach(trelloList -> {
                System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed());
            });
        });
    }

    @PostMapping("cards")
    public CreateTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloClient.createNewCard(trelloCardDto);
    }

//    @GetMapping("cards")
//    public void getTrelloCard() {
//
//        List<TrelloCardDto> trelloCards = trelloClient.getTrelloCard();
//
//        trelloCards.forEach(trelloCardDto -> {
//            System.out.println(trelloCardDto.getName());
//            System.out.println("description = " + trelloCardDto.getDescription());
//            System.out.println("List Id = " + " - " + trelloCardDto.getListId());
//            System.out.println("board = " + trelloCardDto.getBadges().getAttachments().getTrello().getBoard());
//            System.out.println("card = " + trelloCardDto.getBadges().getAttachments().getTrello().getCard());
//        });
//    }

}
