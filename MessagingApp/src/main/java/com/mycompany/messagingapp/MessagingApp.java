/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.messagingapp;

/**
 *
 * @author ongan
 */
import java.util.Scanner;

public class MessagingApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("--- Registration ---");
        Login login = Registration.registerUser();
        
        System.out.println("\n --- Login ---");
        boolean loggedIn = false;
        while(!loggedIn){
            
            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine();
           
            System.out.print("Enter Password: ");
            String loginPassword= scanner.nextLine();
            
            String status= login.returnLoginStatus(loginUsername, loginPassword);
            System.out.println(status);
            if (status.contains("Welcome")){
                loggedIn=true;
            }
        }
        
        
    }
}
