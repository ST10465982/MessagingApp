/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
package com.mycompany.messagingapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    static Login login;

    @BeforeAll
    public static void setUpClass() {
        login = new Login();
    }

    @AfterAll
    public static void tearDownClass() {
        login = null;
    }

    @Test
    public void testCheckUserName_Correct() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUserName_Incorrect() {
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexity_Correct() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testCheckPasswordComplexity_Incorrect() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumber_Correct() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCheckCellPhoneNumber_Incorrect() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testRegisterUser_Success() {
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        login.setCellPhone("+27838968976");

        String message = login.registerUser();
        assertEquals("User registered successfully.", message);
    }

    @Test
    public void testLoginUser_Success() {
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        login.registerUser();

        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginUser_Failure() {
        assertFalse(login.loginUser("wrongUser", "wrongPass"));
    }

    @Test
    public void testReturnLoginStatus_Success() {
        login.setFirstName("kyle");
        login.setLastName("emily");
        login.setUsername(""Ch&&sec@ke99!");
        login.setPassword("P@ssw0rd1");
        login.registerUser();

        login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertEquals("Welcome kyle ,Doe it is great to see you again.", login.returnLoginStatus());
    }

    @Test
    public void testReturnLoginStatus_Failure() {
        login.loginUser("kyl_1", "wrongPass");
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus());
    }
