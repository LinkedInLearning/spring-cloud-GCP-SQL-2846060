package com.cecilireid.puzzleinventory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface PuzzleRepository extends CrudRepository<Puzzle, Long> {
    /**
     * Find Puzzles by its name
     *
     * @param name name of search to search for
     * @param pageable pagination object to handle paged results
     * @return Paged results of puzzles with matching name
     */
    Page<Puzzle> findByName(String name, Pageable pageable);
}
