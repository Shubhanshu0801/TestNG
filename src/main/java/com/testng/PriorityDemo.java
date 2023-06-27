package com.testng;

import org.testng.annotations.Test;

public class PriorityDemo {
    @Test
    public void signup() {
        System.out.println("Signup");
    }
    @Test
    public void login() {
        System.out.println("Login");
    }
    @Test
    public void searchForTheFlight() {
        System.out.println("Search for the flight");
    }
    @Test
    public void bookFlight() {
        System.out.println("Book flight");
    }
    @Test
    public void saveTicket() {
        System.out.println("Save ticket");
    }
    @Test
    public void logout() {
        System.out.println("logout");
    }
}
