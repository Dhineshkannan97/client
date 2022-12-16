package com.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public Client() {
    }

    public void clientServer() {
        Socket socket;
        DataOutputStream output;
        DataInputStream input;
        try {
            socket = new Socket("localhost", 5000);
            input = new DataInputStream(System.in);
            output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String line = "";
        while (!line.equals("end")) {
            try {
                line = input.readLine();
                output.writeUTF(line);
                System.out.println(line);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            socket.close();
            input.close();
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Client client1 = new Client();
        client1.clientServer();
    }
}
