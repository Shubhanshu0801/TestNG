package com.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PartialDataProvider {
    @Test(dataProvider = "dp3")
    public void test(Object obj) {
        System.out.println(obj);
    }
    @DataProvider(indices = {0,2})
    public Object[] dp3() {
        Object[] data = new Object[] {
                "Tony",
                "Stark",
                "Steve",
                "Rogers"
        };
        return data;
    }
}
