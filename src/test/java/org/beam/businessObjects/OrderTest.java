package org.beam.businessObjects;

import org.beam.abstractClasses.Cake;
import org.beam.businessObjects.cakes.ChocolateCake;
import org.beam.businessObjects.cakes.OperaCake;
import org.beam.businessObjects.cakes.PrincessCake;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    public void testOrderIsMade() {
        Customer customer = new Customer();

        customer.getOrder().setOrderMade(true,customer);

        boolean actual = customer.getOrder().isOrderMade();
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    public void testOrderIsFinished() {
        Customer customer = new Customer();

        customer.getOrder().setOrderFinished(true, customer);

        boolean actual = customer.getOrder().isOrderFinished();
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    public void testOrderCheckOut() {
        Customer customer = new Customer();
        ArrayList<String> fakeCheckOut = new ArrayList<>();
        customer.getOrder().setCheckOut(fakeCheckOut);
        customer.getOrder().addCakeToCheckOut("cake1");
        customer.getOrder().addCakeToCheckOut("cake2");

        String actual = customer.getOrder().getCheckOut().get(1);
        String expected = "cake2";

        assertEquals(expected, actual);
    }

    @Test
    public void testFinishedCakes() {
        Customer customer = new Customer();
        ArrayList<Cake> fakeFinishedCakes = new ArrayList<>();
        customer.getOrder().setFinishedCakes(fakeFinishedCakes);
        customer.getOrder().addCakeToFinishedCakes(new PrincessCake());
        customer.getOrder().addCakeToFinishedCakes(new OperaCake());
        customer.getOrder().addCakeToFinishedCakes(new ChocolateCake());
        customer.getOrder().addCakeToFinishedCakes(new PrincessCake());

        String actual = customer.getOrder().getFinishedCakes().get(1).getName();
        String expected = "Operatårta";

        assertEquals(expected, actual);
    }

    @Test
    public void testGetStringValueOfid() {
        Order order = new Order();

        String actual = order.getStringValueOfId(99);
        String expected = "099";
        assertEquals(expected, actual);

        actual = order.getStringValueOfId(999);
        expected = "999";

        assertEquals(expected, actual);

    }
}