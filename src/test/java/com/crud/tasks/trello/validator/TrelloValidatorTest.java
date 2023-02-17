package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TrelloValidatorTest {
    @InjectMocks
    private TrelloValidator trelloValidator;

    @Test
    void testValidateCard() {
        //Given
        TrelloCard trelloCard = new TrelloCard(
                "Name test Card","Description", "Position", "ListId");
        //When
        trelloValidator.validateCard(trelloCard);

        //Then
    }

    @Test
    void testValidateTrelloBoard() {
        //Given
        List<TrelloList> trelloLists = List.of(new TrelloList("1", "test_list", false));
        List<TrelloBoard> trelloBoards = List.of(new TrelloBoard("1", "test", trelloLists),
                new TrelloBoard("2", "SecondBoard", trelloLists));

        //When
        List<TrelloBoard> filteredBoard = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertEquals(1,filteredBoard.size());
    }
}
