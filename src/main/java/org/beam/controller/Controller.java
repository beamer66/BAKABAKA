package org.beam.controller;

import org.beam.businessObjects.Customer;
import org.beam.abstractClasses.Cake;
import org.beam.businessObjects.cakes.ChocolateCake;
import org.beam.businessObjects.cakes.OperaCake;
import org.beam.businessObjects.cakes.PrincessCake;
import org.beam.businessObjects.Order;
import org.beam.observer.OrderObserver;
import org.beam.bakery.BakerySimulator;
import org.beam.ui.UserInterface;
import org.beam.utils.IdGenerator;
import org.beam.utils.VisualDelay;

import java.util.ArrayList;

public class Controller {

    private final BakerySimulator bakerySimulator;
    private final ArrayList<Customer>customerList;


    private final UserInterface userInterface;
    private final OrderObserver orderObserver;

    private Customer customerAdmin;
    private Customer customerTeacher;
    private Customer customer;
    private Customer activeUser;
    private Cake cake;
    private Order order;

    private int princessCount, operaCount, chocolateCount;

    public Controller() {
        this.userInterface = new UserInterface(this);
        this.customerAdmin = new Customer("jim", 1, "hej");
        this.customerTeacher = new Customer("tomas", 2, "wigell");
        this.customerList = new ArrayList<>();
        this.customerList.add(customerAdmin);
        this.customerList.add(customerTeacher);
        this.bakerySimulator = new BakerySimulator();
        this.orderObserver = new OrderObserver();
    }

    public void launch() {
        userInterface.start();
    }

    public boolean validateLogin(String username, String password) {
        for(Customer c : customerList) {
            if(c.getName().equals(username) && c.getPassword().equals(password)) {
                setActiveUser(c);
                order = activeUser.getOrder();
                order.addPropertyChangeListener(orderObserver);
                return true;
            }
        }
        System.out.println("Fel användarnamn eller lösenord");
        return false;
    }

    public void validateRegisterNewUser(String username, String password, String validatePassword) {
        if(!password.equals(validatePassword)) {
            System.out.println("Du måste ange samma lösenord");
            return;
        }
        for (Customer value : customerList) {
            if (value.getName().equals(username)) {
                System.out.println("En användare med det användarnamnet finns redan registrerad");
                return;
            }
        }

        customer = new Customer();
        customer.setName(username);
        customer.setPassword(password);
        customer.setId(customerList.size()+1);
        customerList.add(customer);
        System.out.println("Registering lyckades!");

    }

    public void addCakeToCheckOut(String cake, int amountOfCakes) {
        for(int i=0; i<amountOfCakes; i++) {
            order.addCakeToCheckOut(cake);
        }
        if (amountOfCakes>0){
            System.out.println(amountOfCakes + " " + cake + " är tillagd i kundvagnen");
        }
    }

    public void showCheckOut() {
        System.out.println("=========KUNDVAGN==========");
        if(order.getCheckOut().size()<1){
            System.out.println("Här var det tomt");
            System.out.println();
            return;
        }

        getAmountOfCakes();

        if(princessCount >= 1) {
            System.out.println("Princesstårta antal: " + princessCount);
        }
        if(operaCount >= 1) {
            System.out.println("Operatårta antal: " + operaCount);
        }
        if(chocolateCount >=1) {
            System.out.println("Chokladtårta antal: " + chocolateCount);
        }
        System.out.println();
    }

    public void clearCheckOut() {
        order.getCheckOut().clear();
        System.out.println("Kundvagnen rensad!\n");
    }

    public void makeOrder() {
        if (order.getCheckOut().size()>0) {
            order.setOrderMade(true, activeUser);
            for(int i=0; i<order.getCheckOut().size(); i++){
                bakerySimulator.setRecipe(order.getCheckOut().get(i));
                cake = bakerySimulator.makeCakeBase();
                cake = bakerySimulator.finishCake();
                cake.setId(IdGenerator.getInstance().generateCakeId());
                addToUsersFinishedCakes();
                System.out.println("###" + cake.getName() + " är klar!###");
                VisualDelay.getInstance().simulateDelay();
            }

            order.setOrderMade(false, activeUser);
            order.setOrderFinished(true, activeUser);
            order.getCheckOut().clear();
            order.setOrderFinished(false, activeUser);
        }
        else {
            System.out.println("Du har inte lagt till några tårtor i kundvagnen!");
        }
    }

    public void previousOrders() throws ClassCastException {
        for(int i=0; i<order.getFinishedCakes().size(); i++) {
            cake = order.getFinishedCakes().get(i);
            if(cake instanceof PrincessCake) {
                printCommonCakeInfo(i);
                System.out.println(((PrincessCake) cake).getSecondTopping());
            }
            if(cake instanceof OperaCake) {
                printCommonCakeInfo(i);
                System.out.println(((OperaCake) cake).getSecondTopping());
            }

            if (cake instanceof ChocolateCake) {
                printCommonCakeInfo(i);
            }
            System.out.println();
        }
    }

    private void printCommonCakeInfo(int i) {
        System.out.println(order.getFinishedCakes().get(i).getName());
        System.out.println("Id:" + order.getFinishedCakes().get(i).getId());
        System.out.println("===Ingredienser===");
        System.out.println(order.getFinishedCakes().get(i).getFirstBase());
        System.out.println(order.getFinishedCakes().get(i).getFirstFilling());
        System.out.println(order.getFinishedCakes().get(i).getSecondBase());
        System.out.println(order.getFinishedCakes().get(i).getSecondFilling());
        System.out.println(order.getFinishedCakes().get(i).getThirdBase());
        System.out.println(order.getFinishedCakes().get(i).getThirdFilling());
        System.out.println(order.getFinishedCakes().get(i).getTopCover());
        System.out.println(order.getFinishedCakes().get(i).getTopping());
    }

    private void getAmountOfCakes() {
        princessCount=0;
        operaCount=0;
        chocolateCount=0;
        for(int i=0; i<order.getCheckOut().size(); i++){
            if(order.getCheckOut().get(i).equals("Princesstårta")) {
                princessCount++;
            }
            if(order.getCheckOut().get(i).equals("Operatårta")) {
                operaCount++;
            }
            if(order.getCheckOut().get(i).equals("Chokladtårta")) {
                chocolateCount++;
            }
        }
    }

    private void addToUsersFinishedCakes() {
        order.addCakeToFinishedCakes(cake);
    }

    public Customer getActiveUser() {
        return activeUser;
    }

    public UserInterface getUserInterface() {
        return userInterface;
    }

    public void setActiveUser(Customer activeUser) {
        this.activeUser = activeUser;
    }
}
