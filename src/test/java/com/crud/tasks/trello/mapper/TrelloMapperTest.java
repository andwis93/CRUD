package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void testMapToListDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "FirstList", true));
        trelloLists.add(new TrelloList("2","SecondList", false));
        //When
        List<TrelloListDto> trelloListDtoList = trelloMapper.mapToListDto(trelloLists);
        //Then
        assertEquals(2,trelloListDtoList.size());
        assertEquals("2", trelloListDtoList.get(1).getId());
        assertEquals("FirstList", trelloListDtoList.get(0).getName());
        assertTrue(trelloListDtoList.get(0).isClosed());
    }

    @Test
    void testMapToList() {
        //Given
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(new TrelloListDto("1", "FirstList", true));
        trelloListsDto.add(new TrelloListDto("2","SecondList", false));
        //When
        List<TrelloList> trelloListList = trelloMapper.mapToList(trelloListsDto);
        //Then
        assertEquals(2,trelloListList.size());
        assertEquals("2", trelloListList.get(1).getId());
        assertEquals("FirstList", trelloListList.get(0).getName());
        assertTrue(trelloListList.get(0).isClosed());
    }

    @Test
    void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Name", "Description", "Position", "ListId");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("Name", trelloCard.getName());
        assertEquals("Description", trelloCard.getDescription());
        assertEquals("Position", trelloCard.getPos());
        assertEquals("ListId", trelloCard.getListId());
    }

    @Test
    void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Name", "Description", "Position", "ListId");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("Name", trelloCard.getName());
        assertEquals("Description", trelloCard.getDescription());
        assertEquals("Position", trelloCard.getPos());
        assertEquals("ListId", trelloCard.getListId());
    }

    @Test
    void testMapToBoardDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "FirstList", true));
        trelloLists.add(new TrelloList("2","SecondList", false));
        List<TrelloBoard> trelloCardList = new ArrayList<>();
        trelloCardList.add(new TrelloBoard("1", "FirstBoard", trelloLists));
        //When
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloCardList);
        //Then
        assertEquals("1", trelloBoardDtoList.get(0).getId());
        assertEquals("FirstBoard", trelloBoardDtoList.get(0).getName());
        assertEquals(2, trelloBoardDtoList.get(0).getLists().size());
    }

    @Test
    void testMapToBoard() {
        //Given
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(new TrelloListDto("1", "FirstList", true));
        trelloListsDto.add(new TrelloListDto("2","SecondList", false));
        List<TrelloBoardDto> trelloCardListDto = new ArrayList<>();
        trelloCardListDto.add(new TrelloBoardDto("1", "FirstBoard", trelloListsDto));
        //When
        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoards(trelloCardListDto);
        //Then
        assertEquals("1", trelloBoardList.get(0).getId());
        assertEquals("FirstBoard", trelloBoardList.get(0).getName());
        assertEquals(2, trelloBoardList.get(0).getLists().size());
    }
}
