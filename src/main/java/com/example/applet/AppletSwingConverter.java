package com.example.applet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A Swing equivalent of the SimpleApplet.
 * This demonstrates the same functionality as the deprecated Applet but using Swing.
 */
public class AppletSwingConverter {
    
    public static void main(String[] args) {
        // Create and configure the frame
        JFrame frame = new JFrame("Applet as Swing Application");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Add our custom panel that has the same drawing code
        frame.add(new AppletPanel());
        
        // Display the frame
        frame.setVisible(true);
    }
    
    // Custom panel with the same drawing code as the applet
    static class AppletPanel extends JPanel {
        
        public AppletPanel() {
            setBackground(Color.WHITE);
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            // This is the same drawing code as in the applet
            // Set text color and font
            g.setColor(Color.BLUE);
            g.setFont(new Font("Times New Roman", Font.BOLD, 20));
            
            // Draw a string
            g.drawString("Hello from gaurav!", 50, 50);
            
            // Draw a rectangle
            g.setColor(Color.RED);
            g.drawRect(50, 70, 200, 100);
            
            // Fill an oval
            g.setColor(Color.GREEN);
            g.fillOval(100, 100, 100, 100);
        }
    }
} 