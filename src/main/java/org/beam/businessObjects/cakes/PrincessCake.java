package org.beam.businessObjects.cakes;

import org.beam.abstractClasses.Cake;
import org.beam.bakery.ingredients.Toppings;

public class PrincessCake extends Cake {

    private Toppings secondTopping;

    public PrincessCake() {
        this.name = "Princesstårta";
    }

    public Toppings getSecondTopping() {
        return secondTopping;
    }

    public void setSecondTopping(Toppings secondTopping) {
        this.secondTopping = secondTopping;
    }

}
