package org.beam.main;

import java.io.*;
import java.net.*;

public class Vd {
    public static void main(String[] args){
        System.out.println("VD VIEW");
        try{
            while(true) {
                ServerSocket ss = new ServerSocket(6666);
                Socket s = ss.accept();//establishes connection
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = (String) dis.readUTF();
                System.out.println(str);
                ss.close();
            }
        }catch(Exception e){System.out.println(e);}
    }
}  