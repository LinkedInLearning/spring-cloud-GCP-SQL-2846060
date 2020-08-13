package com.cecilireid.puzzleinventory;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("puzzles")
public class PuzzleController {
    private PuzzleRepository puzzleRepository;

    public PuzzleController(PuzzleRepository puzzleRepository) {
        this.puzzleRepository = puzzleRepository;
    }

    @PostMapping
    public Puzzle create(@RequestBody Puzzle inputPuzzle) {
        return new Puzzle();
    }

    @GetMapping("/{id}")
    public Puzzle read(@PathVariable Long id) {
        return new Puzzle();
    }

    @PutMapping("/{id}")
    public Puzzle update(@RequestBody Puzzle inputPuzzle, @PathVariable Long id) {
        return new Puzzle();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    }
}
