package org.beam.utils;

import java.util.Scanner;

public class UserInput {
    private Scanner scan;

    public UserInput() {
        scan = new Scanner(System.in);
    }

    public String getInput() {
        try {
            String string = scan.nextLine();
            return string;
        } catch (Exception e) {
            System.out.println("Wrong input");
            return null;
        }
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }
}
