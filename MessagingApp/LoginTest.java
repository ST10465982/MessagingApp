package com.mycompany.messagingapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    static Login login;

    @BeforeAll
    public static void setUpClass() {
        // Create a new Login object with default test values
        login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "kyle", "emily");
    }

    @AfterAll
    public static void tearDownClass() {
        login = null;
    }

    @Test
    public void testCheckUserName_Correct() {
        assertTrue(login.checkUserName());
    }

    @Test
    public void testCheckUserName_Incorrect() {
        Login testLogin = new Login("kyle!!!!!!!", "Pass123!", "+27838968976", "Test", "User");
        assertFalse(testLogin.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexity_Correct() {
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexity_Incorrect() {
        Login testLogin = new Login("user_", "password", "+27830000000", "Test", "User");
        assertFalse(testLogin.checkPasswordComplexity());
    }

    @Test
    public void testCheckCellPhoneNumber_Correct() {
        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void testCheckCellPhoneNumber_Incorrect() {
        Login testLogin = new Login("user_", "Password1!", "08966553", "Test", "User");
        assertFalse(testLogin.checkCellPhoneNumber());
    }

    @Test
    public void testRegisterUser_Success() {
        Login testLogin = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "kyle", "emily");
        String message = testLogin.registerUser();
        assertEquals("User registered successfully", message);
    }

    @Test
    public void testLoginUser_Success() {
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginUser_Failure() {
        assertFalse(login.loginUser("wrongUser", "wrongPass"));
    }

    @Test
    public void testReturnLoginStatus_Success() {
        String message = login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!");
        assertEquals("Welcome kyle ,emily it is great to see you again.", message);
    }

    @Test
    public void testReturnLoginStatus_Failure() {
        String message = login.returnLoginStatus("kyl_1", "wrongPass");
        assertEquals(" Username or password incorrect; please try again", message);
    }
}
