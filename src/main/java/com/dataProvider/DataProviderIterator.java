package com.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderIterator {
    @Test(dataProvider = "dp2")
    public void test(Object[] obj) {
        System.out.println(obj[0] + "-" + obj[1]);
    }
    @DataProvider
    public Iterator<Object[]> dp2() {
        List<Object[]> l  = new ArrayList<>();
        l.add(new Object[]{"Shubhanshu", 1004});
        l.add(new Object[]{"Dubey", 1991});
        return l.iterator();
    }
}
