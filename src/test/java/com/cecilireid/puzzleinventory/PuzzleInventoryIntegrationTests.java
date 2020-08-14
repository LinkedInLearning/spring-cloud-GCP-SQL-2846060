package com.cecilireid.puzzleinventory;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PuzzleInventoryIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PuzzleRepository puzzleRepository;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void testFindByName() throws Exception {
        Puzzle expected = new Puzzle();
        expected.setName("The Rialto Bridge");
    }
}
