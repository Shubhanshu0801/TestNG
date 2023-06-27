package com.screenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClass extends BaseTest {
    @Test
    public void testGoogle() {
        driver.get("https://www.google.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(actualTitle, expectedTitle, "Title is mismatched");
        driver.quit();
    }
    @Test
    public void testFacebook() {
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='email']"))
                .sendKeys("Hyr Tutorials", Keys.ENTER);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebbok123";
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.quit();
    }
    @Test
    public void testOrangeHRM() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin1234");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']//ul//li//a//span[text()='Admin']"))
                .click();
        driver.quit();
    }
}
