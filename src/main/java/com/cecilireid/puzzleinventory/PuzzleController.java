package com.cecilireid.puzzleinventory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@RestController
@RequestMapping("puzzles")
public class PuzzleController {
    private final PuzzleRepository repository;
    public PuzzleController(PuzzleRepository puzzleRepository) { this.repository = puzzleRepository;}

    @PostMapping
    @ResponseBody
    public Puzzle create(@RequestBody Puzzle inputPuzzle) {
        return repository.save(inputPuzzle);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Puzzle read(@PathVariable Long id) {
        Optional<Puzzle> puzzle = repository.findById(id);
        if (puzzle.isPresent()) {
            return puzzle.get();
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Puzzle update(@RequestBody Puzzle inputPuzzle, @PathVariable Long id) {
        Optional<Puzzle> puzzle = repository.findById(id);
        if (puzzle.isPresent()) {
            // Hacky and not ideal
            inputPuzzle.setId(id);
            return repository.save(inputPuzzle);
        }
        else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping
    @ResponseBody
    public Page<Puzzle> findAll(@RequestParam String name) {
        return repository.findByName(name, Pageable.unpaged());
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleClientException() {
    }
}
