package com.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestAttributes {
    @Test(timeOut = 100000)
    public void test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/");
        driver.quit();
    }
    @Test(expectedExceptions = {NoSuchElementException.class})
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/");
        driver.findElement(By.id("abcd")).click();// we failed this test case intentionally.
        driver.quit();
    }
}
