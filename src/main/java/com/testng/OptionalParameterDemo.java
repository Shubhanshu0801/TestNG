package com.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class OptionalParameterDemo {
    WebDriver driver;
    @Parameters("browserName")
    @BeforeTest
    public void setup(@Optional("chrome") String browser) {
        switch(browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("browser is invalid");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void launchGoogle() {
        driver.get("https://www.google.com");
    }
    @Test
    public void launchFacebook() {
        driver.get("https://www.facebook.com");
    }
}
