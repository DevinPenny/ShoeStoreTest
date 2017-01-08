package SeleniumTests;

/**
 * Created by Devin Penny on 1/4/17.
 *
 *
 *  Story 2: Submit email for reminder - Negative test with invalid email address
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
import PageObjects.PageObjects;
import TestDataManagement.RandomDataGenerator;
import org.junit.Assert;
import org.junit.Test;

public class ShoeStoreStory2Negative extends CommonObjects {

    @Test
    public void VerifyEmailNotificationsFailure() {

        PageObjects MainPage = new PageObjects(driver);
        RandomDataGenerator random = new RandomDataGenerator();

        logger.info("Verify page tittle to prove application page loaded");
        MainPage.VerifyPageTitle();

        String randomEmail = random.GetRandomString(7);
        logger.info("created random email id for testing: " + randomEmail + "@website.com");

        logger.info("Enter and submit the email address in the shoe store notification form");
        MainPage.EnterEmailAddress(randomEmail);

        //click remind email button
        logger.info("Click the submit query button");
        MainPage.ClickRemindEmail();

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
            System.out.println("computer cant sleep, must be insomnia");
        }

        logger.info("Verify the user has been notified of an error with the email submission");
        String emailFailure = MainPage.VerifyEmailFailure();

        Assert.assertTrue(emailFailure.equals("Invalid email format. Ex. name@example.com"));

    }
}