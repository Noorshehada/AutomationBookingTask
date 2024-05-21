package org.infra;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.infra.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public static WebDriver driver;


    //public static org.openqa.selenium.JavascriptExecutor jse;

    // This function to set up the Chrome browser
    public static void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.booking.com/");
        driver.manage().window().maximize();
    }

    }
