package com.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMTest {
    WebDriver driver;
    @Test(priority = 1)
    public void launchApp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test(priority = 2)
    public void login() {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Test(priority = 3)
    public void homePageTitleTest() {
        String expectedTitle = driver.getTitle();
        String actualTitle = "OrangeHRM";
        System.out.println(expectedTitle);
        Assert.assertEquals(actualTitle, actualTitle);
    }
    @Test(priority = 4)
    public void clickOnAboutLink() {
        driver.findElement(By.xpath("//p[contains(text(),'Paul Collings')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
        driver.quit();
    }
}

