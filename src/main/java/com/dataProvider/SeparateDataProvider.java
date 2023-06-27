package com.dataProvider;

import org.testng.annotations.Test;

public class SeparateDataProvider {
    @Test(dataProvider = "dp4", dataProviderClass = DataSupplier.class)
    public void test(Object obj) {
        System.out.println(obj);
    }
}
