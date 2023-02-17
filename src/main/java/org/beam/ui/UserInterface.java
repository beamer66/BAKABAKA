package org.beam.ui;

import org.beam.controller.Controller;
import org.beam.utils.UserInput;

public class UserInterface {

    private UserInput userInput;
    private Controller controller;
    private String username, password, validatePassword;
    private int amountOfCakes;
    private boolean loggedIn;
    private boolean running = true;

    public UserInterface(Controller controller) {
        this.controller = controller;
        this.userInput = new UserInput();
    }

    public void start() {
        System.out.println("Välkommen till Wigell Bageri");
        while(running){
            System.out.println("1. Logga in");
            System.out.println("2. Registrera");
            System.out.println("3. Avsluta");
            switch (userInput.getInput()) {
                case "1" -> {login();}
                case "2" -> {register();}
                case "3" -> {running = false;}
                default -> System.out.println("Ange 1-3");
            }
        }
    }

    private void register() {
        System.out.print("Ange ett användarnamn: ");
        username = userInput.getInput();
        System.out.print("Ange ett lösenord: ");
        password = userInput.getInput();
        System.out.print("Ange lösenord igen: ");
        validatePassword = userInput.getInput();
        controller.validateRegisterNewUser(username, password, validatePassword);
    }

    private void login() {
        System.out.print("Ange användarnamn: ");
        username = userInput.getInput();
        System.out.print("Ange lösenord: ");
        password = userInput.getInput();
        loggedIn = controller.validateLogin(username, password);

        if(loggedIn) {
            loggedInMenu();
        }
    }

    private void loggedInMenu() {
        System.out.println();
        System.out.println("Inloggad som " + username);
        while(loggedIn) {
            System.out.println("Lägg till tårtor i kundvagnen");
            System.out.println("1. Prinsesstårta");
            System.out.println("2. Operatårta");
            System.out.println("3. Chokladtårta");
            System.out.println("4. Visa kundvagn");
            System.out.println("5. Rensa kundvagn");
            System.out.println("6. Lägg beställning");
            System.out.println("7. Visa tidigare beställningar");
            System.out.println("8. Logga ut");
            System.out.println("9. Avsluta");

            switch (userInput.getInput()) {
                case "1" -> {
                    System.out.println("Hur många Princesstårtor? ");
                    setAmountOfCakes();
                    controller.addCakeToCheckOut("Princesstårta", amountOfCakes);}
                case "2" -> {
                    System.out.println("Hur många Operatårtor? ");
                    setAmountOfCakes();
                    controller.addCakeToCheckOut("Operatårta", amountOfCakes);}
                case "3" -> {
                    System.out.println("Hur många Chokladtårtor? ");
                    setAmountOfCakes();
                    controller.addCakeToCheckOut("Chokladtårta", amountOfCakes);}
                case "4" -> controller.showCheckOut();
                case "5" -> controller.clearCheckOut();
                case "6" -> controller.makeOrder();
                case "7" -> controller.previousOrders();
                case "8" -> loggedIn = false;
                case "9" -> {loggedIn = false; running = false;}
                default -> System.out.println("Ange 1-9");
            }
        }
    }

    private void setAmountOfCakes() {
        try {
            amountOfCakes = Integer.parseInt(userInput.getInput());
        } catch (NumberFormatException e) {
            System.out.println("Ange med siffror");
            System.out.println();
        }
    }

    public UserInput getUserInput() {
        return userInput;
    }
}
