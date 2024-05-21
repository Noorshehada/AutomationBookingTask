package org.infra.pages;

import org.infra.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.security.PublicKey;
import java.time.Duration;

import static org.infra.BaseTest.driver;


public class HomePage {
    public static WebDriverWait wait;
    public static long TIMEOUT = 120;

    public HomePage(WebDriver driver) {
        super();
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public static void openHomePage() {
        BaseTest.setupBrowser();
    }// end of function


    /*public void testPopupHandling() {
        try {
            // Wait for the popup to be potentially visible
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'Sign in, save money')]")));

            // If popup is visible, assert true and then close it
            if (popup.isDisplayed()) {
                Assert.assertTrue(popup.isDisplayed(), "Popup is displayed");
                System.out.println("Popup is displayed. Closing the popup.");

                // Assuming the close button can be identified uniquely
                WebElement closeButton = driver.findElement(By.xpath("//button[contains(@aria-label, 'Close')]"));
                closeButton.click();
            }
        } catch (Exception e) {
            // If popup is not found within the wait time, assert false
            Assert.assertFalse(true, "Popup is not displayed");
            System.out.println("No popup displayed, proceeding with the test.");
        }
    }

     */
    public static void closeTheLoginPopupIfExist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            // Wait explicitly for the popup text element to be visible
            WebElement popupText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Genius')]")));
            System.out.println("Popup with 'Login option' is displayed. Closing popup.");

            // Click the close button, waiting explicitly for it to be clickable
            WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[aria-label='Dismiss sign-in info.']")));
            closeButton.click();
        } catch (TimeoutException e) {
            System.out.println("No popup displayed, or 'Sign in or register' text not found in the popup. Continuing with the test.");
        }
    }



    //This function to select the destination as Istanbul
    public static void fillDestinationField(){
        WebElement destinationContainer = driver.findElement(By.cssSelector("input[placeholder='Where are you going?']"));
        destinationContainer.click();
        destinationContainer.sendKeys("Istanbul ");
    }

    //This function to select the required date range starting from current date to 10 days
    public static void fillDateRangeField(){
        WebElement datesCalendar = driver.findElement(By.cssSelector("[data-testid='searchbox-dates-container']"));
        datesCalendar.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement calendar = driver.findElement(By.cssSelector("[aria-controls='calendar-searchboxdatepicker']"));
        calendar.click();
        WebElement startDate = driver.findElement(By.xpath("//span[@data-date='2024-06-01' and @aria-label='1 June 2024']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(startDate).click().perform();
        WebElement endDate = driver.findElement(By.xpath("//span[@data-date='2024-06-10' and @aria-label='10 June 2024']"));

        actions.moveToElement(endDate).click().perform();
        datesCalendar.click();
    }


    public static void fillNumberOfPeople(){
        WebElement numberField = driver.findElement(By.cssSelector("[data-testid='occupancy-config']"));
        String text = numberField.getText();
        Assert.assertTrue(text.contains("2 adults"), "Text does not contain '2 adults'");
    }

    public static void clickOnSearchBtn() {
        WebElement searchButton = driver.findElement(By.xpath("//button[.//span[text()='Search']]"));
        searchButton.click();  // Perform the click on the search button

    }
}
