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



import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

import CommonComponents.CommonObjects;

public class ShoeStoreStory2Verbose extends CommonObjects {

    @Test
    public void VerifyEmailNotifications() {

        logger.info("Maximize browser window for test reliability");
        driver.manage().window().maximize();

        logger.info("navigate to page for first test");
        driver.get(testProperties.get("ApplicationURI"));

        logger.info("Verify page tittle to prove application page loaded");
        Assert.assertTrue(driver.getTitle().equals("Shoe Store: Welcome to the Shoe Store"));

        //String randomEmail = random.GetRandomString(7);
        String randomEmail = "1234";
        logger.info("created random email id for testing: " + randomEmail + "@website.com");

        logger.info("Enter and submit the email address in the shoe store notification form");
        driver.findElement(By.id("remind_email_input")).sendKeys("test@abc.com");

        //click remind email button
        logger.info("Click the submit query button");
        driver.findElement(By.id("remind_email_submit")).click();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        logger.info("Verify the user has been notified of successful email submission");

        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='flash']/div"))
                .getText()
                .equals("Thanks! We will notify you of our new shoes at this email: test@abc.com"));
    }
}