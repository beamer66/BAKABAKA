package org.beam.businessObjects.cakes;

import org.beam.abstractClasses.Cake;
import org.beam.bakery.ingredients.Toppings;

public class OperaCake extends Cake {

    private Toppings secondTopping;

    public OperaCake() {
        this.name = "Operatårta";
    }

    public Toppings getSecondTopping() {
        return secondTopping;
    }

    public void setSecondTopping(Toppings secondTopping) {
        this.secondTopping = secondTopping;
    }
}
