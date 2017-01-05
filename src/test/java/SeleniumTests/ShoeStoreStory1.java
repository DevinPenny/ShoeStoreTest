package SeleniumTests;

/**
 * Created by Devin Penny on 1/5/17.
 *
 *
 * Story 1: Monthly display of new releases
 *
 *    In order to view upcoming shoes being released every month As a user of the Shoe store
 *    I want to be able to visit a link for each month and see the shoes being released
 *
 *   Acceptance Criteria:
 *
 *      Month should display a small Blurb of each shoe
 *      Month should display an image each shoe being released
 *      Each shoe should have a suggested price pricing
 */

import CommonComponents.CommonFunctions;
import NavigationObjects.NavigationObjects;
import PageObjects.PageObjects;
import TestDataManagement.RandomDataGenerator;
import org.junit.Test;


public class ShoeStoreStory1 extends CommonFunctions {

    PageObjects MainPage = new PageObjects(driver);
    NavigationObjects navigation = new NavigationObjects();
    RandomDataGenerator random = new RandomDataGenerator();

    @Test
    public void VerifyEmailNotifications() {

        String monthLink = "january";

        logger.info("Maximize browser window for test reliability");
        driver.manage().window().maximize();

        logger.info("navigate to page for first test");
        navigation.NavigateToPage();
        //driver.get(testProperties.get("ApplicationURI"));

        logger.info("Verify page tittle to prove application page loaded");
        MainPage.VerifyPageTitle();


        logger.info("navigate to the month of" + monthLink);



        logger.info("verify the blurb for shoe");

        logger.info("verify the image of the shoe");

        logger.info("verify the pricing of the shoe");

    }
}
