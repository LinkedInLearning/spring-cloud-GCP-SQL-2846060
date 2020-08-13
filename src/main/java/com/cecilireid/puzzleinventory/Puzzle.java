package com.cecilireid.puzzleinventory;

public class Puzzle {
    private Long id;
    private String name;
    private String description;
    private String placeOfPurchase;
    private int pieces;

    public Puzzle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlaceOfPurchase() {
        return placeOfPurchase;
    }

    public void setPlaceOfPurchase(String placeOfPurchase) {
        this.placeOfPurchase = placeOfPurchase;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }
}
