package com.crud.tasks.controller;

import com.crud.tasks.domain.CreateTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("v1/trello")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TrelloController {

    private final TrelloService trelloService;

    @GetMapping("boards")
    public ResponseEntity<List<TrelloBoardDto>> getTrelloBoards() {
        return ResponseEntity.ok(trelloService.fetchTrelloBoards());
    }

    @PostMapping("cards")
    public ResponseEntity<CreateTrelloCard> createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return ResponseEntity.ok(trelloService.createdTrelloCard(trelloCardDto));
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
