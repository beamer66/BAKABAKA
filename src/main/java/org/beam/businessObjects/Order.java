package org.beam.businessObjects;

import org.beam.abstractClasses.BusinessObject;
import org.beam.abstractClasses.Cake;
import org.beam.utils.IdGenerator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Order extends BusinessObject {

    private final PropertyChangeSupport propertyChangeSupport;

    private String orderNumber;
    private ArrayList<String> checkOut;
    private ArrayList<Cake> finishedCakes;

    private boolean orderMade;
    private boolean orderFinished;

    public Order() {
        this.checkOut = new ArrayList<>();
        this.finishedCakes = new ArrayList<>();
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public boolean isOrderMade() {
        return orderMade;
    }

    public void setOrderMade(boolean orderMade, Customer activeUser) {
        if(orderMade) {
            id = IdGenerator.getInstance().generateOrderId();
            orderNumber = getStringValueOfId(id);
            propertyChangeSupport.firePropertyChange(
                    "\t===NY ORDER===\n"+
                    "\t\s\s===#"+orderNumber+"===\n",
                    "ANVÄNDARE: " + activeUser.getName() + " ID: " + activeUser.getId()+"\n",
                    "TÅRTOR: " + getCheckOut());
        }
        this.orderMade = orderMade;
    }

    public boolean isOrderFinished() {
        return orderFinished;
    }

    public void setOrderFinished(boolean orderFinished, Customer activeUser) {
        if(orderFinished) {
            propertyChangeSupport.firePropertyChange(
                    "\t===ORDER KLAR===\n"+
                            "\t\s\s===#"+orderNumber+"===\n",
                    "ANVÄNDARE: " + activeUser.getName() + " ID: " + activeUser.getId()+"\n",
                    "TÅRTOR: " + getCheckOut());
        }
        this.orderFinished = orderFinished;
    }

    public ArrayList<String> getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(ArrayList<String> checkOut) {
        this.checkOut = checkOut;
    }

    public void addCakeToCheckOut(String cake) {
        checkOut.add(cake);
    }

    public ArrayList<Cake> getFinishedCakes() {
        return finishedCakes;
    }

    public void setFinishedCakes(ArrayList<Cake> finishedCakes) {
        this.finishedCakes = finishedCakes;
    }

    public void addCakeToFinishedCakes(Cake cake) {
        finishedCakes.add(cake);
    }

    public String getStringValueOfId(int id) {
        if(id<=9){
            return "00"+id;
        }
        else if (id<=99){
            return "0"+id;
        }
        else {
            return String.valueOf(id);
        }
    }
}