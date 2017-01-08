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

import CommonComponents.CommonObjects;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;


public class ShoeStoreStory1Sandbox extends CommonObjects {

    @Test
    public void VerifyMonthlyDisplay() {

        boolean monthPass = true;

        ExtentReports extent = new ExtentReports(testProperties.get("ExtentReportPath"), true);
        ExtentTest extentTest = extent.startTest("Verify shoe list");

        logger.info("Maximize browser window for test reliability");
        driver.manage().window().maximize();

        logger.info("navigate to page for first test");
        driver.get(testProperties.get("ApplicationURI"));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        extentTest.log(LogStatus.PASS, "Log into test page");

        //this for loop needs to go into the page objects after it is working
        for(int intMonth=1; intMonth<14; intMonth++){

            //get month label
            String month = driver.findElement(By.xpath(".//*[@id='header_nav']/nav/ul/li[" + intMonth +"]/a")).getText();
            logger.info("navigate to month " + month);

            //navigate to month
            driver.findElement(By.xpath(".//*[@id='header_nav']/nav/ul/li[" + intMonth +"]/a")).click();

            try{
                Thread.sleep(500);
            }
            catch(InterruptedException ie){
                logger.severe("computer has insomnia and can not sleep");
            }

            //determine number of shoes for the month, here are a few possible ways to do it
            int shoeCount = driver.findElements(By.xpath(".//*[@id='shoe_list']/li")).size();

            logger.info("Shoe count: " + shoeCount);


            for(int i=1; i<shoeCount+1; i++) {

                logger.info("verify the blurb for shoe" + i + " of " + shoeCount);
                String shoeBlurb = driver.findElement(By.xpath(".//*[@id='shoe_list']/li[" + i + "]/div/table/tbody/tr[3]/td[2]")).getText();
                logger.info(shoeBlurb);

                try{
                    Assert.assertFalse(shoeBlurb.isEmpty());
                    extentTest.log(LogStatus.PASS, "month " + month + " verify the blurb for shoe " + i + " of " + shoeCount);

                }
                catch(AssertionError e){
                    logger.severe("Shoe listing " + shoeCount + "is missing description!" );
                    extentTest.log(LogStatus.FAIL, "month " + month + " issue with the blurb for shoe " + i + " of " + shoeCount);
                    monthPass = false;
                }

                logger.info("verify the image of the shoe" + i + " of " + shoeCount);
                WebElement shoeImage = driver.findElement(By.xpath(".//*[@id='shoe_list']/li[" + i + "]/div/table/tbody/tr[6]/td/img"));

                try{
                    Assert.assertTrue(shoeImage.isDisplayed());
                    extentTest.log(LogStatus.PASS, "month " + month + " verify the image of the shoe " + i + " of " + shoeCount);
                }
                catch(AssertionError e){
                    logger.severe("Shoe listing" + shoeCount + " is missing image!");
                    extentTest.log(LogStatus.FAIL, "month " + month + " issue with the image of the shoe " + i + " of " + shoeCount);
                    monthPass = false;
                }

                logger.info("verify the pricing of the shoe" + i + " of " + shoeCount);
                String shoePrice = driver.findElement(By.xpath(".//*[@id='shoe_list']/li[" + i + "]/div/table/tbody/tr[4]/td[2]")).getText();
                logger.info(shoePrice);

                try{
                    Assert.assertFalse(shoePrice.isEmpty());
                    extentTest.log(LogStatus.PASS, "month " + month + " verify the pricing of the shoe " + i + " of " + shoeCount);
                }
                catch(AssertionError e){
                    logger.severe("month " + month + " Shoe listing " + shoeCount + "is missing price!");
                    extentTest.log(LogStatus.FAIL, "month " + month + " issue with the pricing of the shoe " + i + " of " + shoeCount);
                    monthPass = false;
                }

                extent.endTest(extentTest);

            }

            extent.flush();

        }
        Assert.assertTrue(monthPass);

    }
}
