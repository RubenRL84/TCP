package com.company;


import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import com.company.Converter;

public class Main {


    public static void main(String[] args) {
       // int[] dep = new int[]{1, 67, 0, 30, 0, 30, 0, 0, 30, 0, 0, 0, 0, 2, 67, 0, 97, 0, 114, 0, 100, 0, 105, 0, 111, 0, 108, 0, 111, 0, 103, 0, 105, 0, 97, 0, -2, 0, 49, 0, -1, 0, 67, 0, 105, 0, 114, 0, 117, 0, 114, 0, 103, 0, 105, 0, 97, 0, -2, 0, 50, 0, -1, 0, 3, 0, 4};
       // Converter.Verify(dep);
        //String[] departments = new String[]{"49", "0", "254", "0", "67", "0", "97", "0", "114", "0", "100", "0", "105", "0", "111", "0", "108", "0", "111", "0", "103", "0", "105", "0", "97", "0", "255", "0", "50", "0", "254", "0", "67", "0", "105", "0", "114", "0", "117", "0", "114", "0", "103", "0", "105", "0", "97", "0", "255"};

       // new Client("GPS.ZAPTO.ORG", 1235);
        new Client("127.0.0.1", 5000);
    }

}

class Client {
    // initialize socket and input output streams
    private Socket socket = null;
    private OutputStream out = null;
    private InputStream in = null;

    // constructor to put ip address and port
    public Client(String address, int port) {
        // establish a connection
        try {
            socket = new Socket(address, port);
            if (socket.isConnected()) {
                System.out.println("Connected");
            }
            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
            //takes input from socket
            in = new DataInputStream(socket.getInputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }


        try {
         //   byte[] arr = {(byte) 0x1, (byte) 0x17, (byte) 0x00, (byte) 0x1E, (byte) 0x1, (byte) 0x1E, (byte) 0x1, (byte) 0x0, (byte) 0x1E, (byte) 0x0, (byte) 0x0, (byte) 0x0, (byte) 0x0, (byte) 0x2, (byte) 0x41, (byte) 0x4C, (byte) 0x52, (byte) 0x01, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x01, (byte) 0x00};

            // sending data to server
           // byte[] arr = new byte[]{1, 23, 0, 30, 1, 30, 1, 0, 30, 0, 0, 0, 0, 2, 65, 76, 82, 1, 0, 1, 0, 1, 0};
            byte[] arr = new byte[]{1, 28, 0, 30, 1, 30, 1, 0, 30, 1,2,3,4,2,76,79,71,1,0,1,0,1,2,3,4,3,0,4};
            out.write(arr);

            String req = Arrays.toString(arr);
            //printing request to console
            System.out.println("Sent to server : " + req);




            // Receiving reply from server
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte buffer[] = new byte[1024];
            baos.write(buffer, 0, in.read(buffer));

            byte[] result = baos.toByteArray();

            Converter.Verify(result);
        } catch (IOException i) {
            System.out.println(i);
        }
        // }

        // close the connection
        try {
           //  input.close();
            in.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }
}