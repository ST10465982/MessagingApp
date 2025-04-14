/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.messagingapp;

/**
 *
 * @author ongan
 */
public class Login {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellphoneNumber;
    
    public Login(String username, String password,String cellphoneNumber, String firstName,String lastName){
        
    this.firstName= firstName;
    this.lastName= lastName;
    this.username=username;
    this.password=password;
    this.cellphoneNumber= cellphoneNumber;
}
    public boolean checkUserName(){
        return username.contains("_") && username.length() <= 5;
        
    }
    public boolean checkPasswordComplexity(){
        return password.matches("(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=]).{8,}");

    }
    public boolean checkCellPhoneNumber(){
        return cellphoneNumber.matches("^\\ +27\\d{9}$");
    }
    public String registerUser(){
        if (!checkUserName()){
            return "Username is not correctly formatted please ensure that your username contains an underscore and is no more than five characters in length.";
            }else if (!checkPasswordComplexity()){
                return "Password is not correctly formatted, please ensure that the password contains atleast eight characters , a capital letter, a number and a special character.";
            }else if (!checkCellPhoneNumber()){
                return" Cell phone number incorrectly formatted or does not contain international code";
            }
        return" User registered successfully";
        
    }
    public boolean loginUser(String enteredUsername, String enteredPassword){
        return this.username.equals(enteredUsername)&& this.password.equals(enteredPassword);
    }
    public String returnLoginStatus(String enteredUsername, String enteredPassword){
        if (loginUser(enteredUsername,enteredPassword)){
            return "Welcome " + firstName + " ," + lastName + " it is great to see you again.";
            
        }else {
            return " Username or password incorrect; please try again";
            
    }
    }
}