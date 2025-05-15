package com.example;

public class BeanDemo {
    public static void main(String[] args) {
        // Create a new Person bean
        Person person = new Person();
        
        // Set properties using setter methods
        person.setName("Gaurav Sharma");
        person.setAge(21);
        person.setEmail("sharmagauravxox@gmail.com");
        
        // Display the person information
        System.out.println("Person Bean Demo:");
        System.out.println("----------------");
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Email: " + person.getEmail());
        System.out.println();
        
        // Using toString method
        System.out.println("Using toString():");
        System.out.println(person);
    }
} 