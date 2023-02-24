package com.crud.tasks.trello.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.*;
import com.crud.tasks.service.SimpleEmailService;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TrelloServiceTest {
    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private SimpleEmailService emailService;

    @Mock
    private AdminConfig adminConfig;

    @Test
    void testCreatTrelloCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto(
                "NameDto", "DescriptionDto", "PositionDto", "IdListDto" );
        CreatedTrelloCardDto newCard;
        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(new CreatedTrelloCardDto());
        TrelloDto trelloDto = new TrelloDto();
        AttachmentsByTypeDto attachments = new AttachmentsByTypeDto();
        BadgesDto badgesDto = new BadgesDto();
        trelloDto.setCard(1);
        trelloDto.setBoard(2);
        badgesDto.setVotes(3);

        //When
        newCard = trelloService.createdTrelloCard(trelloCardDto);
        attachments.setTrello(trelloDto);
        badgesDto.setAttachments(attachments);
        newCard.setBadges(badgesDto);

        //Then
        assertNotNull(newCard);
        assertNotNull(newCard.getBadges());
        assertEquals(3, newCard.getBadges().getVotes());
        assertEquals(2, newCard.getBadges().getAttachments().getTrello().getBoard());
        assertEquals(1,newCard.getBadges().getAttachments().getTrello().getCard());
    }

    @Test
    void testFetchTrelloBoard() {
        //Given
        //When
        List<TrelloBoardDto> theTrelloBoardDtoList =  trelloService.fetchTrelloBoards();

        //Then
        assertNotNull(theTrelloBoardDtoList);
    }
}
