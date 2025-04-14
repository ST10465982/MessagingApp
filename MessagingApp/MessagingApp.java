/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.messagingapp;

/**
 *
 * @author ongan
 */
import java.util.Scanner; // IMPORTING SCANNER TO GET USER INPUT

public class MessagingApp {

    public static void main(String[] args) {
        // scanner object to read input from the end user 
        Scanner scanner = new Scanner(System.in);
        
        // registration process
        
        System.out.println("--- Registration ---");
        
        // Calls the registerUser method from the Registration class and stores the returned Login object
        Login login = Registration.registerUser();
        
        // login process 
        System.out.println("\n --- Login ---");
        boolean loggedIn = false;
        while(!loggedIn){
            
            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine(); // read user  username
           
            System.out.print("Enter Password: ");
            String loginPassword= scanner.nextLine(); // read user password
            
            String status= login.returnLoginStatus(loginUsername, loginPassword);
            System.out.println(status);
            
             // If login is successful (status contains "Welcome"), exit the loop
             
            if (status.contains("Welcome")){
                loggedIn=true;
            }
        }
        
       
    }
}
