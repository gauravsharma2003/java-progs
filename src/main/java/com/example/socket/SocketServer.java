package com.example.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A simple Java Socket Server example.
 * This server listens on port 9090 and echoes back any message it receives.
 */
public class SocketServer {
    
    private static final int PORT = 9090;
    
    public static void main(String[] args) {
        System.out.println("Socket Server starting on port " + PORT);
        
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            
            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
                
                // Handle client in a separate thread
                new Thread(() -> handleClient(clientSocket)).start();
            }
            
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void handleClient(Socket clientSocket) {
        try (
            // Get input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            // Send welcome message
            out.println("Connected to server. Type 'exit' to quit.");
            
            String inputLine;
            // Read messages from client and echo them back
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received from client: " + inputLine);
                
                // If client sends 'exit', break the loop
                if ("exit".equalsIgnoreCase(inputLine)) {
                    out.println("Goodbye!");
                    break;
                }
                
                // Echo back the message
                out.println("Server echo: " + inputLine);
            }
            
        } catch (IOException e) {
            System.out.println("Client handling exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
                System.out.println("Client disconnected");
            } catch (IOException e) {
                System.out.println("Error closing client socket: " + e.getMessage());
            }
        }
    }
} 