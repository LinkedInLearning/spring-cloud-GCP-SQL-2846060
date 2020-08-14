package com.cecilireid.puzzleinventory;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;

@SpringJUnitConfig(PuzzleControllerUnitTests.Config.class)
public class PuzzleControllerUnitTests {
    @Configuration
    static class Config {
         @Bean
        public PuzzleController puzzleController() {
             return new PuzzleController(puzzleRepository());
         }

         @Bean
         public PuzzleRepository puzzleRepository() {
             return Mockito.mock(PuzzleRepository.class);
         }
    }

    @Autowired
    private PuzzleController puzzleController;

    @Autowired
    private PuzzleRepository puzzleRepository;

    @Test
    public void testGet() {
        Puzzle puzzle = new Puzzle();
        puzzle.setName("SOme Puzzle");

        Mockito.when(puzzleRepository.findById(anyLong())).thenReturn(Optional.of(puzzle));

        Puzzle actual = puzzleController.read(100L);

        assertEquals(puzzle, actual);
    }

    @Test
    public void testGetThrowsExceptions() {
        Mockito.when(puzzleRepository.findById(anyLong())).thenReturn(Optional.empty());

        HttpClientErrorException errorException = assertThrows(HttpClientErrorException.class, () -> puzzleController.read(100L));

        assertEquals(HttpStatus.NOT_FOUND, errorException.getStatusCode());
    }
    @Test
    public void testUpdateThrowsException() {
        Mockito.when(puzzleRepository.findById(anyLong())).thenReturn(Optional.empty());

        Puzzle expected = new Puzzle();
        expected.setName("sagrada de familia");
        
        HttpClientErrorException errorException = assertThrows(HttpClientErrorException.class, () -> puzzleController.update(expected, 1000L));

        assertEquals(HttpStatus.NOT_FOUND, errorException.getStatusCode());
    }
}
