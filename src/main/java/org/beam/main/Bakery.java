package org.beam.main;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Bakery {

    public static void main(String[] args){
        System.out.println("Bakery");
        try{
            while(true) {
                ServerSocket ss = new ServerSocket(6668);
                Socket s = ss.accept();//establishes connection
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = (String) dis.readUTF();
                System.out.println(str);
                ss.close();
            }
        }catch(Exception e){System.out.println(e);}
    }
}
