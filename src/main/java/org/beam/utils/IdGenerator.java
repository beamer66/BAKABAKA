package org.beam.utils;

import java.util.ArrayList;

public class IdGenerator {

    private final ArrayList<Integer> listOfIds;
    private final ArrayList<Integer> orderIds;

    private static IdGenerator instance;

    private IdGenerator() {
        listOfIds = new ArrayList<>();
        orderIds = new ArrayList<>();
    }

    public static IdGenerator getInstance() {
        if(instance==null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    public int generateCakeId() {
        int number;
        if (listOfIds.size() < 1) {
            number = 1001;
            listOfIds.add(number);
        } else {
            number = (listOfIds.get(listOfIds.size()-1) + 1);
            listOfIds.add(number);
        }
        return number;
    }

    public int generateOrderId() {
        int number;
        if(orderIds.size() < 1) {
            number = 1;
            orderIds.add(number);
        } else {
            number = (orderIds.get(orderIds.size()-1)+1);
            orderIds.add(number);
        }
        return number;
    }
}
