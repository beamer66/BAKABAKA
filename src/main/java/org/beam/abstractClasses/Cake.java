package org.beam.abstractClasses;


import org.beam.bakery.ingredients.Bases;
import org.beam.bakery.ingredients.Fillings;
import org.beam.bakery.ingredients.TopCovers;
import org.beam.bakery.ingredients.Toppings;

public abstract class Cake extends BusinessObject {

    protected Bases firstBase;
    protected Fillings firstFilling;
    protected Bases secondBase;
    protected Fillings secondFilling;
    protected Bases thirdBase;
    protected Fillings thirdFilling;
    protected TopCovers topCover;
    protected Toppings topping;

    public Bases getFirstBase() {
        return firstBase;
    }

    public void setFirstBase(Bases firstBase) {
        this.firstBase = firstBase;
    }

    public Fillings getFirstFilling() {
        return firstFilling;
    }

    public void setFirstFilling(Fillings firstFilling) {
        this.firstFilling = firstFilling;
    }

    public Bases getSecondBase() {
        return secondBase;
    }

    public void setSecondBase(Bases secondBase) {
        this.secondBase = secondBase;
    }

    public Fillings getSecondFilling() {
        return secondFilling;
    }

    public void setSecondFilling(Fillings secondFilling) {
        this.secondFilling = secondFilling;
    }

    public Bases getThirdBase() {
        return thirdBase;
    }

    public void setThirdBase(Bases thirdBase) {
        this.thirdBase = thirdBase;
    }

    public Fillings getThirdFilling() {
        return thirdFilling;
    }

    public void setThirdFilling(Fillings thirdFilling) {
        this.thirdFilling = thirdFilling;
    }

    public TopCovers getTopCover() {
        return topCover;
    }

    public void setTopCover(TopCovers topCover) {
        this.topCover = topCover;
    }

    public Toppings getTopping() {
        return topping;
    }

    public void setTopping(Toppings topping) {
        this.topping = topping;
    }
}
