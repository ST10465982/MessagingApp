/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.messagingapp;

/**
 *
 * @author ongan
 */
// imports scanner to get user input 

import java.util.Scanner;


public class Registration {
     //  method handles the user registration process
    public static Login registerUser(){
        Scanner scanner = new Scanner(System.in);
        
        // enter first name
        
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        
        
        // enter last name 
        
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        
        
        // enter username ,  the correct username should contain an under score 
        String username= " ";
        boolean validUsername= false;
        while (! validUsername){
            System.out.print("Enter Username: ");
            username = scanner.nextLine();
            if (username.contains("_")&& username.length() <=5){
                validUsername = true;
                
            }else {
                System.out.println("Username is not correctly formatted ; please ensure that your username contains an underscore and not more than five letters in length.");
            }
        }
        
        // user must create a password that contains upper case etc
        
        String password =" ";
        boolean validPassword= false;
        while (!validPassword){
            System.out.print("Enter password: ");
            password= scanner.nextLine();
            if (password.matches("(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=]).{8,}")){

                validPassword = true;
                
            } else{
                System.out.println("Password is not correctly formatted , please ensure that the password contains eight characters , a capita letter , a number and a special character.");
            }
        }
        
        // user must enter a valid cellphone number that starts with +27
        String cellNumber= "";
        boolean validCellNumber = false ;
        while (!validCellNumber){
            System.out.print("Enter cell phone number(+27 ...): ");
            cellNumber= scanner.nextLine();
            if (cellNumber.matches("\\+27\\d{9}$")){
                validCellNumber=true;
            }else{
                System.out.println("Cell phone number incorrectly formatted or code does not contain international code");
                
            }
        }
        // when user logged successful it must display 
        
        
        Login login = new Login(username,password,cellNumber,firstName,lastName);
        System.out.println("User registered successfully.");
        return login;
        }
    }


