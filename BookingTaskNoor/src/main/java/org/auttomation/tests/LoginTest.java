package org.auttomation.tests;

import org.infra.BaseTest;
import org.infra.pages.HomePage;
import org.infra.pages.ResultPage;
import org.testng.annotations.Test;

public class LoginTest {

    @Test (priority = 1)
    public void setTheRequiredBookingDetails()  {
        BaseTest.setupBrowser();
        HomePage.closeTheLoginPopupIfExist();
        HomePage.fillDestinationField();
        HomePage.fillDateRangeField();
        HomePage.fillNumberOfPeople();
        HomePage.clickOnSearchBtn();
    }

    @Test (priority = 2)
    public void filterTheResultByApartment() throws Exception{
        ResultPage.scrollToAndSelectSpecificCheckbox();
        ResultPage.reviewTheApartments();
    }

}
