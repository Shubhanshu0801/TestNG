package com.dataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderExcelIntegration {
    WebDriver driver;
    @Test(dataProvider = "loginData", dataProviderClass = ExcelDataSupplier.class)
    public void login(String userName, String password) throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']//ul//li//a//span[text()='Admin']"))
                .click();
        driver.quit();
    }
}
