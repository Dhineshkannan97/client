package com.client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
public class client {
    public void clientServer(String ip ,int port) throws IOException {
        Socket s ;
        DataOutputStream out ;
        DataInputStream input;
        try{
            s= new Socket(ip,port);
            input =new DataInputStream(System.in);
            out=new DataOutputStream(s.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String line="";
        while (!line.equals("end")){
            try{
                line = input.readLine();
                out.writeUTF(line);
            } catch (IOException e) {
                s.close();
                throw new RuntimeException(e);
            }
        }
        try{
            input.close();
            out.close();
            s.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        client client= new client();
        client.clientServer("localhost",5000);
    }
}
