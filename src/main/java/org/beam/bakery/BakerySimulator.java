package org.beam.bakery;

import org.beam.abstractClasses.Cake;
import org.beam.commands.AddFillingCommand;
import org.beam.commands.AddTopCoverCommand;
import org.beam.commands.AddToppingCommand;

import java.util.ArrayList;


public class BakerySimulator {

    private final CommandPipeLine COMMAND_PIPELINE;
    private final CakeBaseBuilderNextGen CAKE_BASE_BUILDER_NEXT_GEN;
    private final RecipesDatabase RECIPES_DATABASE;

    private ArrayList recipe;
    private Cake cake;

    public BakerySimulator() {
        COMMAND_PIPELINE = new CommandPipeLine();
        CAKE_BASE_BUILDER_NEXT_GEN = new CakeBaseBuilderNextGen();
        RECIPES_DATABASE = new RecipesDatabase();
    }

    public void setRecipe(String cakeToMake) {
        switch (cakeToMake) {
            case "Princesstårta" -> recipe = RECIPES_DATABASE.getPrincessCakeRecipe();
            case "Operatårta" -> recipe = RECIPES_DATABASE.getOperaCakeRecipe();
            case "Chokladtårta" -> recipe = RECIPES_DATABASE.getChocolateCakeRecipe();
        }
    }

    public Cake makeCakeBase() {
        cake = CAKE_BASE_BUILDER_NEXT_GEN.build(recipe);

        return cake;
    }

    public Cake finishCake() {
        COMMAND_PIPELINE.addCommand(new AddFillingCommand());
        COMMAND_PIPELINE.addCommand(new AddTopCoverCommand());
        COMMAND_PIPELINE.addCommand(new AddToppingCommand());

        cake = COMMAND_PIPELINE.execute(cake, recipe);

        return cake;
    }
}