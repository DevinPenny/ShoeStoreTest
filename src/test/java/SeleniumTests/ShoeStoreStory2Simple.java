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
import PageObjects.PageObjects;
import TestDataManagement.RandomDataGenerator;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.junit.Test;

public class ShoeStoreStory2Simple extends CommonObjects {


    @Test
    public void VerifyEmailNotifications() {

        PageObjects MainPage = new PageObjects(driver);
        RandomDataGenerator random = new RandomDataGenerator();

        extent.startTest("Verify email notifications");

        logger.info("Verify page tittle to prove application page loaded");
        MainPage.VerifyPageTitle();

        //extentTest.log(LogStatus.PASS, "Log into test page succesful");

        String randomEmail = random.GetRandomString(7);
        logger.info("created random email id for testing: " + randomEmail + "@website.com");

        logger.info("Enter and submit the email address in the shoe store notification form");
        MainPage.EnterEmailAddress(randomEmail + "@shoestoretesting.com");

        //click remind email button
        logger.info("Click the submit query button");
        MainPage.ClickRemindEmail();

        try{
            Thread.sleep(500);
        }
        catch(InterruptedException ie){
            System.out.println("computer cant sleep, must be insomnia");
        }

        logger.info("Verify the user has been notified of successful email submission");
        String emailConfirmation = MainPage.GetEmailConfirmation();

        try{

            Assert.assertTrue(emailConfirmation.equalsIgnoreCase("Thanks! We will notify you of our new shoes at this email: " + randomEmail + "1234@shoestoretesting.com"));
            extentTest.log(LogStatus.PASS, "Email confirmation found");
        }
        catch(AssertionError e){
            logger.severe("Email confirmation message incorrect!");
            extentTest.log(LogStatus.FAIL, "Email confirmation message incorrect!");
        }
        extent.endTest(extentTest);

    }
}