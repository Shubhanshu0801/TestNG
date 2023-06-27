package com.screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    public static WebDriver driver;
    public static String screenshotSubFolderName;
    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    @AfterMethod
    public void screenshotCapture(ITestResult result) {
        //result.getStatus() returns int value
        if(result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(result.getTestContext().getName() + "-" + result.getMethod().getMethodName());
        }
    }
    public void captureScreenshot(String fileName) {
        if(screenshotSubFolderName == null) {
            LocalDateTime myDateTime = LocalDateTime.now();
            DateTimeFormatter myFormatDateTime = DateTimeFormatter.ofPattern("dd-mm-yyyy hh-mm-ss");
            screenshotSubFolderName = myDateTime.format(myFormatDateTime);
        }
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./Screenshots/"+ screenshotSubFolderName + "/" + fileName + ".png");
        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot taken successfully");
    }
}
