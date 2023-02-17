package org.beam.controller;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ControllerTest {

    private Controller controller = new Controller();

    @Test
    public void verifyLaunchMethodBeingCalled() {
        Controller controllerSpy = spy(new Controller());
        Scanner scannerMock = mock(Scanner.class);
        controllerSpy.getUserInterface().getUserInput().setScan(scannerMock);

        when(controllerSpy.getUserInterface().getUserInput().getInput()).thenReturn("3");

        controllerSpy.launch();

        verify(controllerSpy, times(1)).launch();
    }

    @Test
    public void validateLoginSuccess() {
        boolean expected = true;
        boolean actual = this.controller.validateLogin("jim", "hej");
        assertEquals(expected, actual);
    }

    @Test
    public void validateLoginFailed() {
        boolean expected = false;
        boolean actual = this.controller.validateLogin("beam", "FYFANFÖRTEST");
        assertEquals(expected, actual);
    }

    @Test
    public void registerNewUserSuccsess() {
        ByteArrayOutputStream consoleOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOut));
        this.controller.validateRegisterNewUser("BonnTjyv", "Fest", "Fest");
        String expected = "Registering lyckades!\r\n";
        String actual = consoleOut.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void registerNewUserDifferentPasswords() {
        ByteArrayOutputStream consoleOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOut));
        this.controller.validateRegisterNewUser("BonnTjyv", "Fest", "Fes");
        String expected = "Du måste ange samma lösenord\r\n";
        String actual = consoleOut.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void registerNewUserNameAlreadyRegistered() {
        ByteArrayOutputStream consoleOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOut));
        this.controller.validateRegisterNewUser("jim", "Fest", "Fest");
        String expected = "En användare med det användarnamnet finns redan registrerad\r\n";
        String actual = consoleOut.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testShowCheckOutMethodBeingCalled() {
        Controller controllerSpy = spy(new Controller());

        controllerSpy.validateLogin("jim", "hej");
        controllerSpy.addCakeToCheckOut("Princesstårta", 1);
        controllerSpy.addCakeToCheckOut("Operatårta", 1);
        controllerSpy.addCakeToCheckOut("Chokladtårta", 1);
        controllerSpy.showCheckOut();

        verify(controllerSpy, times(1)).showCheckOut();
    }

    @Test
    public void testMakeOrderMethod() {
        Controller controllerSpy = spy(new Controller());

        controllerSpy.validateLogin("jim", "hej");
        controllerSpy.addCakeToCheckOut("Princesstårta", 1);
        controllerSpy.addCakeToCheckOut("Operatårta", 1);
        controllerSpy.addCakeToCheckOut("Chokladtårta", 1);

        controllerSpy.makeOrder();

        verify(controllerSpy, times(1)).makeOrder();
    }

    @Test
    public void testPreviousOrdersMethod() {
        Controller controllerSpy = spy(new Controller());

        controllerSpy.validateLogin("jim", "hej");
        controllerSpy.addCakeToCheckOut("Princesstårta", 1);
        controllerSpy.addCakeToCheckOut("Operatårta", 1);
        controllerSpy.addCakeToCheckOut("Chokladtårta", 1);

        controllerSpy.makeOrder();
        controllerSpy.previousOrders();

        verify(controllerSpy, times(1)).previousOrders();
    }

    @Test
    public void previousOrders() {
    }
}