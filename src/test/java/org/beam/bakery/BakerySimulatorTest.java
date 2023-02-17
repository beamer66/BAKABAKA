package org.beam.bakery;

import org.beam.abstractClasses.Cake;
import org.beam.bakery.ingredients.Bases;
import org.beam.bakery.ingredients.Fillings;
import org.beam.bakery.ingredients.TopCovers;
import org.beam.bakery.ingredients.Toppings;
import org.beam.businessObjects.cakes.PrincessCake;
import org.beam.utils.VisualDelay;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class BakerySimulatorTest {

    private BakerySimulator bakerySimulator = new BakerySimulator();
    private Cake cake;

    BakerySimulatorTest() {
        VisualDelay.getInstance().setDelay(0);
    }

    @Test
    void cakeBaseFirstBaseAssigned() {
        bakerySimulator.setRecipe("Princesstårta");
        cake = bakerySimulator.makeCakeBase();

        String expected = Bases.CAKEBASE.toString();
        String actual = cake.getFirstBase().toString();

        assertEquals(expected, actual);
    }

    @Test
    void cakeBaseFirstFillingAssigned() {
        bakerySimulator.setRecipe("Operatårta");
        cake = bakerySimulator.makeCakeBase();

        String expected = Fillings.VANILLA_CREAM.toString();
        String actual = cake.getFirstFilling().toString();

        assertEquals(expected, actual);
    }

    @Test
    void cakeBaseSecondBaseAssigned() {
        bakerySimulator.setRecipe("Chokladtårta");
        cake = bakerySimulator.makeCakeBase();

        String expected = Bases.CHOCOLATECAKEBASE.toString();
        String actual = cake.getSecondBase().toString();

        assertEquals(expected, actual);
    }

    @Test
    void cakeBaseSecondFillingAssigned() {
        bakerySimulator.setRecipe("Princesstårta");
        cake = bakerySimulator.makeCakeBase();

        String expected = Fillings.VANILLA_CREAM.toString();
        String actual = cake.getSecondFilling().toString();

        assertEquals(expected, actual);
    }

    @Test
    void cakeBaseThirdBaseAssigned() {
        bakerySimulator.setRecipe("Operatårta");
        cake = bakerySimulator.makeCakeBase();

        String expected = Bases.CAKEBASE.toString();
        String actual = cake.getThirdBase().toString();

        assertEquals(expected, actual);
    }

    @Test
    void finishCakeThirdFillingAssigned() {
        bakerySimulator.setRecipe("Princesstårta");

        cake = bakerySimulator.makeCakeBase();
        cake = bakerySimulator.finishCake();

        String expected = Fillings.WHIPPED_CREAM.toString();
        String actual = cake.getThirdFilling().toString();

        assertEquals(expected, actual);
    }

    @Test
    void finishCakeTopCoverAssigned() {
        bakerySimulator.setRecipe("Operatårta");

        cake = bakerySimulator.makeCakeBase();
        cake = bakerySimulator.finishCake();

        String expected = TopCovers.PINK_MARZIPANCOVER.toString();
        String actual = cake.getTopCover().toString();

        assertEquals(expected, actual);
    }

    @Test
    void finishCakeToppingAssigned() {
        bakerySimulator.setRecipe("Chokladtårta");

        cake = bakerySimulator.makeCakeBase();
        cake = bakerySimulator.finishCake();

        String expected = Toppings.RASPBERRY.toString();
        String actual = cake.getTopping().toString();

        assertEquals(expected, actual);
    }

    @Test
    void finishCakeSecondToppingAssigned() {
        bakerySimulator.setRecipe("Princesstårta");

        cake = bakerySimulator.makeCakeBase();
        cake = bakerySimulator.finishCake();

        String expected = Toppings.ICING_SUGAR.toString();

        String actual = ((PrincessCake)cake).getSecondTopping().toString();

        assertEquals(expected, actual);
    }

   @Test
   public void testExceptionForMissingFirstCakeBase() {
    CakeBaseBuilderNextGen cakeBaseBuilderNextGen = new CakeBaseBuilderNextGen();

       ArrayList fakeRecipe = new ArrayList<>();
       fakeRecipe.add("Princesstårta");
       fakeRecipe.add(null);
       fakeRecipe.add(Fillings.VANILLA_CREAM);
       fakeRecipe.add(Bases.CAKEBASE);
       fakeRecipe.add(Fillings.VANILLA_CREAM);
       fakeRecipe.add(Bases.CAKEBASE);
       fakeRecipe.add(Fillings.WHIPPED_CREAM);
       fakeRecipe.add(TopCovers.GREEN_MARZIPANCOVER);
       fakeRecipe.add(Toppings.MARZIPAN_ROSE);
       fakeRecipe.add(Toppings.ICING_SUGAR);

        try
        {
            cakeBaseBuilderNextGen.build(fakeRecipe);
        }

        catch(RuntimeException e) {
            String expected = null;
            assertEquals(expected, e.getMessage());
        }
    }
    @Test
    public void testExceptionForMissingFirstFilling() {
        CakeBaseBuilderNextGen cakeBaseBuilderNextGen = new CakeBaseBuilderNextGen();

        ArrayList fakeRecipe = new ArrayList<>();
        fakeRecipe.add("Princesstårta");
        fakeRecipe.add(Bases.CAKEBASE);
        fakeRecipe.add(null);
        fakeRecipe.add(Bases.CAKEBASE);
        fakeRecipe.add(Fillings.VANILLA_CREAM);
        fakeRecipe.add(Bases.CAKEBASE);
        fakeRecipe.add(Fillings.WHIPPED_CREAM);
        fakeRecipe.add(TopCovers.GREEN_MARZIPANCOVER);
        fakeRecipe.add(Toppings.MARZIPAN_ROSE);
        fakeRecipe.add(Toppings.ICING_SUGAR);

        try
        {
            cakeBaseBuilderNextGen.build(fakeRecipe);
        }

        catch(RuntimeException e) {
            String expected = null;
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    public void testExceptionForMissingSecondCakeBase() {
        CakeBaseBuilderNextGen cakeBaseBuilderNextGen = new CakeBaseBuilderNextGen();

        ArrayList fakeRecipe = new ArrayList<>();
        fakeRecipe.add("Princesstårta");
        fakeRecipe.add(Bases.CAKEBASE);
        fakeRecipe.add(Fillings.VANILLA_CREAM);
        fakeRecipe.add(null);
        fakeRecipe.add(Fillings.VANILLA_CREAM);
        fakeRecipe.add(Bases.CAKEBASE);
        fakeRecipe.add(Fillings.WHIPPED_CREAM);
        fakeRecipe.add(TopCovers.GREEN_MARZIPANCOVER);
        fakeRecipe.add(Toppings.MARZIPAN_ROSE);
        fakeRecipe.add(Toppings.ICING_SUGAR);

        try
        {
            cakeBaseBuilderNextGen.build(fakeRecipe);
        }

        catch(RuntimeException e) {
            String expected = null;
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    public void testExceptionForMissingSecondFilling() {
        CakeBaseBuilderNextGen cakeBaseBuilderNextGen = new CakeBaseBuilderNextGen();

        ArrayList fakeRecipe = new ArrayList<>();
        fakeRecipe.add("Princesstårta");
        fakeRecipe.add(Bases.CAKEBASE);
        fakeRecipe.add(Fillings.VANILLA_CREAM);
        fakeRecipe.add(Bases.CAKEBASE);
        fakeRecipe.add(null);
        fakeRecipe.add(Bases.CAKEBASE);
        fakeRecipe.add(Fillings.WHIPPED_CREAM);
        fakeRecipe.add(TopCovers.GREEN_MARZIPANCOVER);
        fakeRecipe.add(Toppings.MARZIPAN_ROSE);
        fakeRecipe.add(Toppings.ICING_SUGAR);

        try
        {
            cakeBaseBuilderNextGen.build(fakeRecipe);
        }

        catch(RuntimeException e) {
            String expected = null;
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    public void testExceptionForMissingThirdCakeBase() {
        CakeBaseBuilderNextGen cakeBaseBuilderNextGen = new CakeBaseBuilderNextGen();

        ArrayList fakeRecipe = new ArrayList<>();
        fakeRecipe.add("Princesstårta");
        fakeRecipe.add(Bases.CAKEBASE);
        fakeRecipe.add(Fillings.VANILLA_CREAM);
        fakeRecipe.add(Bases.CAKEBASE);
        fakeRecipe.add(Fillings.VANILLA_CREAM);
        fakeRecipe.add(null);
        fakeRecipe.add(Fillings.WHIPPED_CREAM);
        fakeRecipe.add(TopCovers.GREEN_MARZIPANCOVER);
        fakeRecipe.add(Toppings.MARZIPAN_ROSE);
        fakeRecipe.add(Toppings.ICING_SUGAR);

        try
        {
            cakeBaseBuilderNextGen.build(fakeRecipe);
        }

        catch(RuntimeException e) {
            String expected = null;
            assertEquals(expected, e.getMessage());
        }
    }
}