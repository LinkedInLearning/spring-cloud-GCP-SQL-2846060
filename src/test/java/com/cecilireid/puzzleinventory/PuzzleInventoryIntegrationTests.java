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
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    public void testGetNotFound() throws Exception {
        mockMvc.perform(get("/puzzles/100")).andExpect(status().isNotFound());
    }

    @Test
    public void testGet() throws Exception {
        // Setup
        Puzzle puzzle = new Puzzle();
        puzzle.setName("Route 66");

        // Run
        MvcResult result = mockMvc.perform(post("/puzzles").contentType(MediaType.APPLICATION_JSON_VALUE).content(mapper.writeValueAsString(puzzle))).andExpect(status().isOk()).andReturn();
        Puzzle expected = mapper.readValue(result.getResponse().getContentAsString(), Puzzle.class);

        // TODO: Update this test to retrieve an "actual" puzzle that makes this test pass.
        MvcResult getResult = mockMvc.perform(get("/puzzles/" + expected.getId())).andExpect(status().isOk()).andReturn();
        Puzzle actual = mapper.readValue(getResult.getResponse().getContentAsString(), Puzzle.class);

        // Assert
        assertNotNull(actual);
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getPieces(), actual.getPieces());
        assertEquals(expected.getPlaceOfPurchase(), actual.getPlaceOfPurchase());
    }


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
