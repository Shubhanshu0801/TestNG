package com.listeners;

import org.testng.annotations.Test;

public class TestClass {
    @Test
    public void testMethod1() {
        System.out.println("testMethod1 executed");
    }
    @Test
    public void testMethod2() {
        System.out.println(5/0);
        System.out.println("testMethod2 executed");
    }
    @Test(dependsOnMethods = "testMethod2")
    public void testMethod3() {
        System.out.println("testMethod3 executed");
    }
    @Test
    public void testMethod4() {
        System.out.println("testMethod4 executed");
    }
}
