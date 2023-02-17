package org.beam.ui;
import org.beam.controller.Controller;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserInterfaceTest {

    @Test
    public void testUiLogin() {
        Controller controller = spy(new Controller());
        UserInterface userInterface = spy(new UserInterface(controller));
        Scanner scannerMock = mock(Scanner.class);
        userInterface.getUserInput().setScan(scannerMock);

        when(userInterface.getUserInput().getInput())
                .thenReturn("ett")
                .thenReturn("1")
                .thenReturn("jim")
                .thenReturn("hej")
                .thenReturn("9");

        userInterface.start();

        verify(userInterface,times(1)).start();
    }

    @Test
    public void testUserInterfaceRegister() {
        Controller controller = new Controller();
        UserInterface userInterface = spy(new UserInterface(controller));
        Scanner scannerMock = mock(Scanner.class);

        userInterface.getUserInput().setScan(scannerMock);

        when(userInterface.getUserInput().getInput())
                .thenReturn("2")
                .thenReturn("oliver")
                .thenReturn("hej")
                .thenReturn("hej")
                .thenReturn("3");
        userInterface.start();

        verify(userInterface,times(1)).start();
    }

    @Test
    public void addPrincessCakes() {
        Controller controller = spy(new Controller());
        UserInterface userInterface = spy(new UserInterface(controller));
        Scanner scannerMock = mock(Scanner.class);
        userInterface.getUserInput().setScan(scannerMock);

        when(userInterface.getUserInput().getInput())
                .thenReturn("1")
                .thenReturn("jim")
                .thenReturn("hej")
                .thenReturn("1")
                .thenReturn("fem")
                .thenReturn("1")
                .thenReturn("5")
                .thenReturn("9");

        userInterface.start();

        int actual = controller.getActiveUser().getOrder().getCheckOut().size();
        int expected = 5;

        assertEquals(expected,actual);
    }

    @Test
    public void addOperaCakes() {
        Controller controller = spy(new Controller());
        UserInterface userInterface = spy(new UserInterface(controller));
        Scanner scannerMock = mock(Scanner.class);
        userInterface.getUserInput().setScan(scannerMock);

        when(userInterface.getUserInput().getInput())
                .thenReturn("1")
                .thenReturn("jim")
                .thenReturn("hej")
                .thenReturn("2")
                .thenReturn("10")
                .thenReturn("9");

        userInterface.start();

        int actual = controller.getActiveUser().getOrder().getCheckOut().size();
        int expected = 10;

        assertEquals(expected, actual);
    }

    @Test
    public void addChocolatecake() {
        Controller controller = spy(new Controller());
        UserInterface userInterface = spy(new UserInterface(controller));
        Scanner scannerMock = mock(Scanner.class);
        userInterface.getUserInput().setScan(scannerMock);

        when(userInterface.getUserInput().getInput())
                .thenReturn("1")
                .thenReturn("jim")
                .thenReturn("hej")
                .thenReturn("3")
                .thenReturn("25")
                .thenReturn("9");

        userInterface.start();

        int actual = controller.getActiveUser().getOrder().getCheckOut().size();
        int expected = 25;

        assertEquals(expected, actual);
    }

    @Test
    public void verifyCheckOutIsCalled() {
        Controller controller = spy(new Controller());
        UserInterface userInterface = spy(new UserInterface(controller));
        Scanner scannerMock = mock(Scanner.class);
        userInterface.getUserInput().setScan(scannerMock);

        when(userInterface.getUserInput().getInput())
                .thenReturn("1")
                .thenReturn("jim")
                .thenReturn("hej")
                .thenReturn("4")
                .thenReturn("9");

        userInterface.start();

        verify(controller, times(1)).showCheckOut();
    }

    @Test
    public void verifyclearCheckOutIsCalled() {
        Controller controller = spy(new Controller());
        UserInterface userInterface = spy(new UserInterface(controller));
        Scanner scannerMock = mock(Scanner.class);
        userInterface.getUserInput().setScan(scannerMock);

        when(userInterface.getUserInput().getInput())
                .thenReturn("1")
                .thenReturn("jim")
                .thenReturn("hej")
                .thenReturn("5")
                .thenReturn("9");

        userInterface.start();

        verify(controller, times(1)).clearCheckOut();
    }

    @Test
    public void verifyMakeOrderIsCalled() {
        Controller controller = spy(new Controller());
        UserInterface userInterface = spy(new UserInterface(controller));
        Scanner scannerMock = mock(Scanner.class);
        userInterface.getUserInput().setScan(scannerMock);

        when(userInterface.getUserInput().getInput())
                .thenReturn("1")
                .thenReturn("jim")
                .thenReturn("hej")
                .thenReturn("6")
                .thenReturn("9");

        userInterface.start();

        verify(controller, times(1)).makeOrder();
    }

    @Test
    public void verifyPreviousOrdersIsCalled() {
        Controller controller = spy(new Controller());
        UserInterface userInterface = spy(new UserInterface(controller));
        Scanner scannerMock = mock(Scanner.class);
        userInterface.getUserInput().setScan(scannerMock);

        when(userInterface.getUserInput().getInput())
                .thenReturn("1")
                .thenReturn("jim")
                .thenReturn("hej")
                .thenReturn("7")
                .thenReturn("10")
                .thenReturn("8")
                .thenReturn("3");

        userInterface.start();

        verify(controller, times(1)).previousOrders();
    }
}