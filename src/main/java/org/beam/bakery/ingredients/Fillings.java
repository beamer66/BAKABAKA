package org.beam.bakery.ingredients;

public enum Fillings {
    WHIPPED_CREAM("Vispad grädde"),
    RASPBERRY_MOUSSE("Hallonmousse"),
    RASPBERRY_JAM("Hallonsylt"),
    VANILLA_CREAM("Vaniljkräm"),
    CHOCOLATE_BUTTERCREAM("Chokladsmörkräm");

    private final String filling;

    Fillings(String filling) {
        this.filling = filling;
    }

    @Override
    public String toString() {
        return filling;
    }
}
