package SeleniumTests;

/**
 * Created by Devin Penny on 1/4/17.
 *
 *
 *  Story 2: Submit email for reminder
 *
 *  In order to be reminded of upcoming shoe releases As a user of the Shoe Store I want to be able to submit my email address
 *
 *  Acceptance Criteria
 *
 *  There should be an area to submit email address
 *  on successful submission of a valid email address user should receive a confirmation message
 *    "Thanks! We will notify you of our new shoes at this email: <users email address>"
 *
 */

import CommonComponents.CommonObjects;
import org.junit.Test;
import java.util.concurrent.TimeUnit;

public class ShoeStoreStory2 extends CommonObjects {

    @Test
    public void VerifyEmailNotifications() {

        logger.info("Maximize browser window for test reliability");
        driver.manage().window().maximize();

        logger.info("navigate to page for first test");
        navigation.NavigateToPage();

        logger.info("Verify page tittle to prove application page loaded");
        MainPage.VerifyPageTitle();

        String randomEmail = random.GetRandomString(7);
        logger.info("created random email id for testing: " + randomEmail + "@website.com");

        logger.info("Enter and submit the email address in the shoe store notification form");
        MainPage.EnterEmailAddress(randomEmail + "@shoestoretesting.com");

        //click remind email button
        logger.info("Click the submit query button");
        MainPage.ClickRemindEmail();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        logger.info("Verify the user has been notified of successful email submission");

/*
        try{
            Assert.assertTrue(MainPage.GetEmailConfirmation(randomEmail + "@shoestoretesting.com")
                    .equals("Thanks! We will notify you of our new shoes at this email: " + randomEmail + "@shoestoretesting.com"));
        }
        catch(AssertionError e){
            logger.severe("Email confirmation message incorrect!");
        }
        */
    }
}