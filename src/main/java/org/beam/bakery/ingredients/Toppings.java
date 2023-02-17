package org.beam.bakery.ingredients;

public enum Toppings {
    RASPBERRY("Hallon"),
    MARZIPAN_ROSE("Marsipanros"),
    ICING_SUGAR("Florsocker");

    private final String topping;

    Toppings(String topping) {
        this.topping= topping;
    }

    @Override
    public String toString() {
        return topping;
    }
}
