package org.beam.utils;

public class VisualDelay {

    private int delay;

    private static VisualDelay instance;

    private VisualDelay() {
        delay = 0;
    }

    public static VisualDelay getInstance() {
        if(instance == null) {
            instance = new VisualDelay();
        }
        return instance;
    }

    public void simulateDelay() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            System.out.println("Cake ruined");
        }
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
