package com.crud.tasks.trello;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.facade.TrelloFacade;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TrelloFacadeTest {

//    @InjectMocks
//    private TrelloFacade trelloFacade;
//    @Mock
//    private TrelloService trelloService;
//    @Mock
//    private TrelloValidator trelloValidator;
//    @Mock
//    private TrelloMapper trelloMapper;
//
//    @Test
//    void shouldFetchEmptyList() {
//        //Given
//        List<TrelloListDto> trelloLists = List.of(new TrelloListDto("1", "test_list", false));
//        List<TrelloBoardDto> trelloBoards = List.of(new TrelloBoardDto("1", "test", trelloLists));
//        List<TrelloList> mappedTrelloLists = List.of(new TrelloList("1", "test_list", false));
//        List<TrelloBoard> mappedTrelloBoards = List.of(new TrelloBoard("1", "test", mappedTrelloLists));
//
//        when(trelloService.fetchTrelloBoards()).thenReturn(trelloBoards);
//        when(trelloMapper.mapToBoards(trelloBoards)).thenReturn(mappedTrelloBoards);
//        when(trelloMapper.mapToBoardsDto(anyList())).thenReturn(List.of());
//        when(trelloValidator.validateTrelloBoards(mappedTrelloBoards)).thenReturn(List.of());
//
//        //When
//        List<TrelloBoardDto> trelloBoardDtos = trelloFacade.fetchTrelloBoards();
//
//        //Then
//        assertNotNull(trelloBoardDtos);
//        assertEquals(0, trelloBoardDtos.size());
//    }
//
//    @Test
//    void testCreateCard() {
//        //Given
//        TrelloCard trelloCard = new TrelloCard("Name", "Description", "Position", "IdList");
//        TrelloCardDto trelloCardDto = new TrelloCardDto(
//                "NameDto", "DescriptionDto", "PositionDto", "IdListDto" );
//
//        when(trelloMapper.mapToCard(trelloCardDto)).thenReturn(trelloCard);
//        when(trelloMapper.mapToCardDto(trelloCard)).thenReturn(trelloCardDto);
//        when(trelloService.createdTrelloCard(trelloCardDto)).thenReturn(new CreatedTrelloCardDto());
//
//        //When
//        CreatedTrelloCardDto createdTrelloCardDto = trelloFacade.createCard(trelloCardDto);
//
//        //Then
//        assertNotNull(createdTrelloCardDto);
//    }
}
