package com.demoIgnore;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class IgnoreDemo2 {
    @Ignore
    @Test
    public void test4() {
        System.out.println("test4");
    }
    @Test
    public void test5() {
        System.out.println("test5");
    }
    @Test
    public void test6() {
        System.out.println("test");
    }
}
