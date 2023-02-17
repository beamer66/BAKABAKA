package org.beam.main;

import org.beam.controller.Controller;
import org.beam.utils.VisualDelay;

public class Main {

    public static void main(String[] args) {

        VisualDelay.getInstance().setDelay(2500);

        Controller controller = new Controller();
        controller.launch();

    }
}