package org.beam.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class OrderObserver implements PropertyChangeListener {
    private Date date;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String message = evt.getPropertyName() + evt.getOldValue() + evt.getNewValue();
        try {
            date = new Date();
            Socket s = new Socket("localhost", 6666);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(date +"\n"+ message+"\n");
            dout.flush();
            dout.close();
            s.close();
        } catch (IOException e) {
            System.out.println();
            System.out.println(date +"\n" + message);
            System.out.println();
        }
    }
}
