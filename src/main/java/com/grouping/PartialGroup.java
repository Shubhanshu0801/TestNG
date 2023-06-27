package com.grouping;

import org.testng.annotations.Test;

@Test(groups = {"all"})
public class PartialGroup {
    @Test(groups = {"smoke"})
    public void partialGroup() {
        System.out.println("PartialGroup");
    }
    @Test(groups = {"smoke", "regression"})
    public void partialGroup2() {
        System.out.println("PartialGroup2");
    }
    @Test(groups = {"functional", "regression"})
    public void partialGroup3() {
        System.out.println("PartialGroup3");
    }
    @Test
    public void partialGroup4() {
        System.out.println("PartialGroup4");
    }
}
