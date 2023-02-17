package org.beam.commands;

import org.beam.abstractClasses.Cake;
import org.beam.businessObjects.cakes.PrincessCake;
import org.beam.businessObjects.cakes.OperaCake;
import org.beam.bakery.ingredients.Toppings;
import org.beam.repositories.Command;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class AddToppingCommand implements Command {

    @Override
    public Cake addIngredient(Cake cake, ArrayList recipe) {
        String message = "";
        switch (cake.getName()) {
            case "Princesstårta" -> {
                PrincessCake princessCake = (PrincessCake) cake;
                princessCake.setTopping(Toppings.MARZIPAN_ROSE);
                princessCake.setSecondTopping(Toppings.ICING_SUGAR);
                message = "Garnerar med en: " + princessCake.getTopping() + " och pudrar över " + princessCake.getSecondTopping();
            }
            case "Operatårta" -> {
                OperaCake operaCake = (OperaCake) cake;
                operaCake.setTopping(Toppings.MARZIPAN_ROSE);
                operaCake.setSecondTopping(Toppings.ICING_SUGAR);
                message = "Garnerar med en: " + operaCake.getTopping() + " och pudrar över " + operaCake.getSecondTopping();
            }
            case "Chokladtårta" -> {
                cake.setTopping(Toppings.RASPBERRY);
                message = "Garnerar med: " + cake.getTopping();
            }

        }

        try {
            Socket s = new Socket("localhost", 6668);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(message+"\n");
            dout.flush();
            dout.close();
            s.close();
        } catch (IOException e) {
            System.out.println(message);
        }

        return cake;
    }
}
