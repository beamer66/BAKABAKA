package org.beam.repositories;

import org.beam.abstractClasses.Cake;

import java.util.ArrayList;

public interface Command {

    Cake addIngredient(Cake cake, ArrayList<Enum> recipe);
}
