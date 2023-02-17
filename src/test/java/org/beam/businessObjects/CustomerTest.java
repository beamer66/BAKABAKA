package org.beam.businessObjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    public void testFullConstructor() {
        Customer customer = new Customer("Jens", 6, "Dahl");

        String actual = customer.getName();
        String expected = "Jens";
        assertEquals(expected, actual);

        int actualInt = customer.getId();
        int expectedInt = 6;
        assertEquals(expectedInt, actualInt);

        actual = customer.getPassword();
        expected = "Dahl";
        assertEquals(actual, expected);

    }

    @Test
    public void testSetOrder() {
        Customer customer = new Customer();
        Order order1 = new Order();
        customer.setOrder(order1);

        Order newOrder = new Order();

        newOrder = customer.getOrder();

        assertEquals(order1, newOrder);
    }
}