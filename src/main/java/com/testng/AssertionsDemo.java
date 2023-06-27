package com.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AssertionsDemo {
    @Test
    public void testHYRTutorials() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String expectedTitle = "H Y R Tutorials - H Y R Tutorials";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title is mismatched");
        driver.quit();
    }

    @Test
    public void openFacebook() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("email")).sendKeys("HYR Tutorials", Keys.ENTER);
        Thread.sleep(5000);

        SoftAssert softAssert = new SoftAssert();
        //1. Title Assertion
        String expectedTitle = "log in to Facebook";
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle, expectedTitle, "Title is mismatched");

        //2. Url Assertion
        String expectedUrl = "https://www.facebook.com/";
        String actualUrl = driver.getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "URL is mismatched");

        //Border Assertion
        String expectedBorder = "1px solid rgb(221, 223, 226)";//#dddfe2 is a hexa value- converting it into rgb value
        String actualBorder = driver.findElement(By.id("email")).getCssValue("border");
        softAssert.assertEquals(actualBorder, expectedBorder, "user text border is mismatched");

        //Error message Assertion
        String expectedErrorMessage = "The password that you've entered is incorrect. Forgotten password?";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@id='email_container']" +
                "//following-sibling::div[1]//child::div[2]")).getText();
        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "error message is mismatched");

        driver.quit();
    }
}