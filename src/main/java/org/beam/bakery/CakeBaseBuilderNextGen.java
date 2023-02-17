package org.beam.bakery;

import org.beam.abstractClasses.Cake;
import org.beam.bakery.ingredients.Bases;
import org.beam.bakery.ingredients.Fillings;
import org.beam.businessObjects.cakes.ChocolateCake;
import org.beam.businessObjects.cakes.OperaCake;
import org.beam.businessObjects.cakes.PrincessCake;
import org.beam.utils.VisualDelay;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class CakeBaseBuilderNextGen {


    private PrincessCake princessCake;
    private OperaCake operaCake;
    private ChocolateCake chocolateCake;
    private Cake cake;

    public CakeBaseBuilderNextGen() {

    }

    public Cake build(ArrayList recipe){
        switch (recipe.get(0).toString()) {
            case "Princesstårta" -> {princessCake = new PrincessCake(); cake = princessCake;}
            case "Operatårta" -> {operaCake = new OperaCake(); cake = operaCake;}
            case "Chokladtårta" -> {chocolateCake = new ChocolateCake(); cake = chocolateCake;}
        }

        System.out.println("###Påbörjar tårtbasen...###");

        VisualDelay.getInstance().simulateDelay();
        setFirstCakeBase(recipe);
        VisualDelay.getInstance().simulateDelay();
        setFirstFilling(recipe);
        VisualDelay.getInstance().simulateDelay();
        setSecondCakeBase(recipe);
        VisualDelay.getInstance().simulateDelay();
        setSecondFilling(recipe);
        VisualDelay.getInstance().simulateDelay();
        setThirdCakeBase(recipe);

        return cake;
    }

    private void setFirstCakeBase(ArrayList recipe) {
        cake.setFirstBase((Bases) recipe.get(1));
        getOutput(recipe, 1);
    }

    private void setFirstFilling(ArrayList recipe) {
        if(cake.getFirstBase()==null) {
            System.out.println("Tårtbotten saknas!");
            throw new RuntimeException();
        }
        else {
            cake.setFirstFilling((Fillings) recipe.get(2));
            getOutput(recipe, 2);
        }
    }

    private void setSecondCakeBase(ArrayList recipe) {
        if(cake.getFirstFilling()==null) {
            System.out.println("Fyllning saknas");
            throw new RuntimeException();
        }
        else {
            cake.setSecondBase((Bases) recipe.get(3));
            getOutput(recipe, 3);
        }
    }

    private void setSecondFilling(ArrayList recipe) {
        if(cake.getSecondBase()==null) {
            System.out.println("Tårtbotten saknas");
            throw new RuntimeException();
        }
        else {
            cake.setSecondFilling((Fillings) recipe.get(4));
            getOutput(recipe, 4);
        }
    }

    private void setThirdCakeBase(ArrayList recipe) {
        if(cake.getSecondFilling()==null) {
            System.out.println("Fyllning saknas");
            throw new RuntimeException();
        }
        else {
            cake.setThirdBase((Bases) recipe.get(5));
            getOutput(recipe, 5);
        }
    }

    private void getOutput(ArrayList recipe, int num) {
        String message ="" ;
            try {
                if (recipe.get(num).getClass().getName().equals("org.beam.bakery.ingredients.Bases") && num == 1) {
                    message = "Lägger ut en " + recipe.get(num);
                } else if (recipe.get(num).getClass().getName().equals("org.beam.bakery.ingredients.Bases") && num > 1) {
                    message = "Lägger på en " + recipe.get(num);
                }

                if (recipe.get(num).getClass().getName().equals("org.beam.bakery.ingredients.Fillings")) {
                    message = "Brer på ett lager " + recipe.get(num);
                }
            }
            catch (NullPointerException ignored) {

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