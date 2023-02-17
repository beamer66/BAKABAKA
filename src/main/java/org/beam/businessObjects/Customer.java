package org.beam.businessObjects;

import org.beam.abstractClasses.BusinessObject;

public class Customer extends BusinessObject {
    private String password;
    private Order order;

    public Customer() {
        this.order = new Order();
    }

    public Customer(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.order = new Order();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
