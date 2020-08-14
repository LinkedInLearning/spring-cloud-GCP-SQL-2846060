package com.cecilireid.puzzleinventory;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("memory")
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
        expected.setName("Golden Gate Bridge");

        mockMvc.perform(post("/puzzles").contentType(MediaType.APPLICATION_JSON_VALUE).content(mapper.writeValueAsString(expected))).andExpect(status().isOk());

        Page<Puzzle> puzzles = puzzleRepository.findByName(expected.getName(), null);

        assertTrue(puzzles.getTotalElements() >= 1);

        Optional<Puzzle> puzzle = puzzles.get().findFirst();
        assertTrue(puzzle.isPresent());

        Puzzle actual = puzzle.get();
        assertEquals(expected.getName(), actual.getName());
        assertNotNull(actual.getId());

    }
}
