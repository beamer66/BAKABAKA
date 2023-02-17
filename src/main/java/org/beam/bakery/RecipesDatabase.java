package org.beam.bakery;

import org.beam.bakery.ingredients.Bases;
import org.beam.bakery.ingredients.Fillings;
import org.beam.bakery.ingredients.TopCovers;
import org.beam.bakery.ingredients.Toppings;

import java.util.ArrayList;


public class RecipesDatabase {
    private ArrayList princessCakeRecipe;
    private ArrayList operaCakeRecipe;
    private ArrayList chocolateCakeRecipe;

    public RecipesDatabase() {
        princessCakeRecipe = new ArrayList<>();
        operaCakeRecipe = new ArrayList<>();
        chocolateCakeRecipe = new ArrayList<>();
        addRecipies();
    }

    private void addRecipies() {
        princessCakeRecipe.add("Princesstårta");
        princessCakeRecipe.add(Bases.CAKEBASE);
        princessCakeRecipe.add(Fillings.VANILLA_CREAM);
        princessCakeRecipe.add(Bases.CAKEBASE);
        princessCakeRecipe.add(Fillings.VANILLA_CREAM);
        princessCakeRecipe.add(Bases.CAKEBASE);
        princessCakeRecipe.add(Fillings.WHIPPED_CREAM);
        princessCakeRecipe.add(TopCovers.GREEN_MARZIPANCOVER);
        princessCakeRecipe.add(Toppings.MARZIPAN_ROSE);
        princessCakeRecipe.add(Toppings.ICING_SUGAR);

        operaCakeRecipe.add("Operatårta");
        operaCakeRecipe.add(Bases.CAKEBASE);
        operaCakeRecipe.add(Fillings.VANILLA_CREAM);
        operaCakeRecipe.add(Bases.CAKEBASE);
        operaCakeRecipe.add(Fillings.RASPBERRY_JAM);
        operaCakeRecipe.add(Bases.CAKEBASE);
        operaCakeRecipe.add(Fillings.WHIPPED_CREAM);
        operaCakeRecipe.add(TopCovers.PINK_MARZIPANCOVER);
        operaCakeRecipe.add(Toppings.MARZIPAN_ROSE);
        operaCakeRecipe.add(Toppings.ICING_SUGAR);

        chocolateCakeRecipe.add("Chokladtårta");
        chocolateCakeRecipe.add(Bases.CHOCOLATECAKEBASE);
        chocolateCakeRecipe.add(Fillings.RASPBERRY_MOUSSE);
        chocolateCakeRecipe.add(Bases.CHOCOLATECAKEBASE);
        chocolateCakeRecipe.add(Fillings.RASPBERRY_MOUSSE);
        chocolateCakeRecipe.add(Bases.CHOCOLATECAKEBASE);
        chocolateCakeRecipe.add(Fillings.CHOCOLATE_BUTTERCREAM);
        chocolateCakeRecipe.add(TopCovers.CHOCOLATEGANASH);
        chocolateCakeRecipe.add(Toppings.RASPBERRY);
    }

    public ArrayList getPrincessCakeRecipe() {
        return princessCakeRecipe;
    }

    public ArrayList getOperaCakeRecipe() {
        return operaCakeRecipe;
    }

    public ArrayList getChocolateCakeRecipe() {
        return chocolateCakeRecipe;
    }
}
