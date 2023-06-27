package com.grouping;

import org.testng.annotations.Test;

public class NewTest2 {
    @Test(groups = {"smoke", "sanity", "windows.functional"})
    public void test4() {
        System.out.println("test4");
    }
    @Test(groups = {"regression", "functional", "sanity"})
    public void test5() {
        System.out.println("test5");
    }
    @Test(groups = {"sanity", "regression", "ios.smoke"})
    public void test6() {
        System.out.println("test6");
    }
    @Test
    public void test7() {
        System.out.println("test7");
    }
}
