package com.example.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * A simple Java Socket Client example.
 * This client connects to a server on localhost:9090 and allows the user
 * to send messages that the server will echo back.
 */
public class SocketClient {
    
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 9090;
    
    public static void main(String[] args) {
        System.out.println("Socket Client starting...");
        
        try (
            // Connect to the server
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            
            // Set up input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            // For reading user input
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Connected to server at " + SERVER_ADDRESS + ":" + SERVER_PORT);
            
            // Read welcome message from the server
            String serverMessage = in.readLine();
            System.out.println("Server: " + serverMessage);
            
            String userInput;
            
            // Loop to send messages to the server
            while (true) {
                System.out.print("Enter message (type 'exit' to quit): ");
                userInput = scanner.nextLine();
                
                // Send the message to server
                out.println(userInput);
                
                // Read the response from server
                serverMessage = in.readLine();
                System.out.println("Server: " + serverMessage);
                
                // If the user typed 'exit', break out of the loop
                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }
            }
            
        } catch (IOException e) {
            System.out.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("Client shutting down...");
    }
} 