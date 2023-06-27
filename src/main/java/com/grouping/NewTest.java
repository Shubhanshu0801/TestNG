package com.grouping;

import org.testng.annotations.Test;

public class NewTest {
    @Test(groups = {"smoke", "windows.smoke"})
    public void test1() {
        System.out.println("test1");
    }
    @Test(groups = {"smoke", "functional", "windows.sanity", "ios.sanity"})
    public void test2() {
        System.out.println("test2");
    }
    @Test(groups = {"functional", "regression"})
    public void test3() {
        System.out.println("test3");
    }
}
