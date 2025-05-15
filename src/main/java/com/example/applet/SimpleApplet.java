package com.example.applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * A simple Java Applet example.
 * Note: Java Applets are deprecated in modern Java, but this is for demonstration purposes.
 * 
 * @deprecated Java Applets are no longer supported in modern browsers
 */
@Deprecated
public class SimpleApplet extends Applet {
    private static final long serialVersionUID = 1L;
    
    @Override
    public void init() {
        // Initialization code
        setBackground(Color.WHITE);
    }
    
    @Override
    public void paint(Graphics g) {
        // Set text color and font
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        
        // Draw a string
        g.drawString("Hello from Java Applet!", 50, 50);
        
        // Draw a rectangle
        g.setColor(Color.RED);
        g.drawRect(50, 70, 200, 100);
        
        // Fill an oval
        g.setColor(Color.GREEN);
        g.fillOval(100, 100, 100, 40);
    }
}

/*
 * To run this applet, you would need to create an HTML file with the following content:
 * 
 * <html>
 * <head>
 *   <title>Simple Applet Example</title>
 * </head>
 * <body>
 *   <applet code="com.example.applet.SimpleApplet.class" width="400" height="300">
 *     Your browser does not support Java Applets.
 *   </applet>
 * </body>
 * </html>
 * 
 * Then open this HTML file in a browser with Java Plugin support.
 */ 