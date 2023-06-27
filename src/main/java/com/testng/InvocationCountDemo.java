package com.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InvocationCountDemo {
    @Test(invocationCount = 3, invocationTimeOut = 200000, threadPoolSize = 2)
    public void test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://randomuser.me/");
        driver.findElement(By.xpath("//li[@data-label='name']")).click();
        System.out.println(driver.findElement(By.xpath("//p[@id='user_value']")).getText());
        driver.quit();
    }
}
