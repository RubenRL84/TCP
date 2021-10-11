package com.company;// A Java program for a Server
import java.net.*;
import java.util.Arrays;
import java.io.*;

public class Server
{
    //initialize socket and input stream
    private Socket   socket = null;
    private ServerSocket server = null;
    private InputStream in  = null;
    private OutputStream out = null;

    // constructor with port
    public Server(int port)
    {
         Boolean serveron = true;
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");
            while (serveron ){
            socket = server.accept();

            System.out.println("Client accepted");

            // takes input from the client socket
            in = new DataInputStream(socket.getInputStream());
            //writes on client socket
            out = new DataOutputStream(socket.getOutputStream());


            // Receiving data from client
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte buffer[] = new byte[1024];
            baos.write(buffer, 0 , in.read(buffer));

            byte result[] = baos.toByteArray();

            String res = Arrays.toString(result);
            System.out.println("Recieved from client : "+res);

                //echoing back to client
                byte[] arr = new byte[]{1,67,0,30,0,30,0,0,30,0,0,0,0,2,67,0,97,0,114,0,100,0,105,0,111,0,108,0,111,0,103,0,105,0,97,0, (byte) 254,0,49,0, (byte) 255,0,67,0,105,0,114,0,117,0,114,0,103,0,105,0,97,0, (byte) 254,0,50,0, (byte) 255,0,3,0,4};
                   out.write(arr);

        }

        }
        catch(IOException i)
        {
            System.out.println(i);

        }
    }

    public static void main(String args[])
    {
        new Server(5000);
    }
}