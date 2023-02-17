package org.beam.bakery.ingredients;

public enum Bases {
    CAKEBASE("Tårtbotten"),
    CHOCOLATECAKEBASE("Chokladtårtbotten");

    private final String base;

    Bases(String base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return base;
    }
}
