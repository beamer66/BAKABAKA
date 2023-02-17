package org.beam.commands;

import org.beam.abstractClasses.Cake;
import org.beam.bakery.ingredients.Fillings;
import org.beam.repositories.Command;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class AddFillingCommand implements Command {

    @Override
    public Cake addIngredient(Cake cake, ArrayList recipe) {
        for(int i=5; i<recipe.size(); i++) {
            if(recipe.get(i).getClass().getName().equals("org.beam.bakery.ingredients.Fillings")) {
                cake.setThirdFilling((Fillings)recipe.get(i));
                getOutput(cake);
            }
        }

        return cake;
    }

    private void getOutput(Cake cake) {
        String message = "";
        switch (cake.getName()) {
            case "Princesstårta", "Operatårta" ->
                    message = "Fördelar " + cake.getThirdFilling() + " på tårtan så den får en kupolform";
            case "Chokladtårta" ->
                    message = "Spacklar tårtan med: " + cake.getThirdFilling();
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
