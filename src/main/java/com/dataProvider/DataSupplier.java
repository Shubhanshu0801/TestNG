package com.dataProvider;

import org.testng.annotations.DataProvider;

public class DataSupplier {
    @DataProvider
    public Object[] dp4() {
        Object[] data = new Object[] {
                "David Warner",
                "Steve Smith",
                "Pat Cummins",
                "Nathan Lyon"
        };
        return data;
    }
}
