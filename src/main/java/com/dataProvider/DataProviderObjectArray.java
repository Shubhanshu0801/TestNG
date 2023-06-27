package com.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderObjectArray {
    @Test(dataProvider = "dp1")
    public void test(Object o) {
        System.out.println(o);
    }
    @DataProvider
    public Object[] dp1() {
        Object[] data = new Object[] {1, "Hello", 2};
        return data;
    }
}
