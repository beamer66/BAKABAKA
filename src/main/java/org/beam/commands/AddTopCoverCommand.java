package org.beam.commands;

import org.beam.abstractClasses.Cake;
import org.beam.bakery.ingredients.TopCovers;
import org.beam.repositories.Command;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class AddTopCoverCommand implements Command {

    @Override
    public Cake addIngredient(Cake cake, ArrayList recipe) {
        for(int i=5; i<recipe.size(); i++) {
            if(recipe.get(i).getClass().getName().equals("org.beam.bakery.ingredients.TopCovers")) {
                cake.setTopCover((TopCovers)recipe.get(i));
                getOutput(cake);
            }
        }

        return cake;
    }

    private void getOutput(Cake cake) {
        String message="";
        switch (cake.getName()) {
            case "Princesstårta", "Operatårta" ->
                    message = "Lägger på ett: " + cake.getTopCover();
            case "Chokladtårta" ->
                    message = "Häller " + cake.getTopCover() + " och låter det rinna över kanten";
        }
        try {
            Socket s = new Socket("localhost", 6668);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(message);
            dout.flush();
            dout.close();
            s.close();
        } catch (IOException e) {
            System.out.println(message);
        }
    }
}
