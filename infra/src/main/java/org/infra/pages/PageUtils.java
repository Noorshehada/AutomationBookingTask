package org.infra.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtils {
    protected WebDriver driver;
    public PageUtils(WebDriver driver) {

        this.driver = driver;
    }
    /*
    public void clickOnLoginPopupIfExist() {

        if (isRecordVoiceIconPresent()) {
            recordVoiceIcon.click();
        } else {
            logger.error("Elements not available");
        }
    }

    public static void verifyElementVisibility(WebElement element, WebDriverWait wait) {
        try {

            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException timeoutException) {
            if (verifyRunningWithBS()) {
                try {
                    bsAssertion(false, "", "TimeoutException, " + element.toString() + " Element Not Exists", jse);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            throw timeoutException;
        }
    }

     */
}
