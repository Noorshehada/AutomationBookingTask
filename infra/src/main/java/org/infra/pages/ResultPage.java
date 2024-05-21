package org.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.infra.BaseTest.driver;

public class ResultPage {


    public static void scrollToAndSelectApartmentCheckbox() throws Exception {
        JavascriptExecutor js;
        js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement labelForApartments = driver.findElement(By.xpath("//div[contains(text(), 'Apartments')]/ancestor::label"));
        WebElement checkbox = driver.findElement(By.xpath("//div[text()='Apartments']/ancestor::div[@data-testid='filters-group-label-container']"));

        // Scroll the checkbox into view
        js.executeScript("arguments[0].scrollIntoView(true);",  checkbox);
        WebElement checkboxContainer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), 'Apartments')]/ancestor::div[@data-testid='filters-group-label-container']")));

        Actions actions = new Actions(driver);
        // Move to element before clicking
        actions.moveToElement(checkboxContainer).pause(Duration.ofSeconds(1)).click().perform();
        Thread.sleep(5000);
    }

    public static void reviewTheApartments() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

        // Find the element by 'data-testid'
        WebElement logo = driver.findElement(By.cssSelector("a[data-testid='header-booking-logo']"));

        // Scroll the element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logo);

    }
}
