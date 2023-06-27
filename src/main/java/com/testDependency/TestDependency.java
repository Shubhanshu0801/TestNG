package com.testDependency;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestDependency {
    static String trackingNumber = null;
    @Test(enabled = false)
    public void createShipment() {
        System.out.println(5/0);
        trackingNumber = "ABC@123";
        System.out.println("Shipment is created");
    }
    @Test(dependsOnMethods = {"createShipment"}, ignoreMissingDependencies = true)
    public void trackShipment() throws Exception {
        if(trackingNumber != null)
            System.out.println("Shipment is tracked");
        else
            throw new Exception("Invalid Tracking Number");
    }
    @Test(dependsOnMethods = {"createShipment", "trackShipment"})
    public void cancelShipment() throws Exception {
        if(trackingNumber != null)
            System.out.println("Shipment is cancelled");
        else
            throw new Exception("Invalid Tracking Number");
    }
}
