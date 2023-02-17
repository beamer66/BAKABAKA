package org.beam.bakery.ingredients;

public enum TopCovers {
    GREEN_MARZIPANCOVER("Grönt marsipanlock"),
    PINK_MARZIPANCOVER("Rosa marsipanlock"),
    CHOCOLATEGANASH("Chokladganash");

    private final String topCover;

    TopCovers(String topCover) {
        this.topCover = topCover;
    }

    @Override
    public String toString() {
        return topCover;
    }
}
