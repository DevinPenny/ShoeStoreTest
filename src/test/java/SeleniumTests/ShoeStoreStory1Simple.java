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
import PageObjects.PageObjects;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class ShoeStoreStory1Simple extends CommonObjects {

    @Test
    public void VerifyMonthlyDisplay() {

        PageObjects MainPage = new PageObjects(driver);

        logger.info("Verify page tittle to prove application page loaded");
        MainPage.VerifyPageTitle();

        for(int month=1; month<12; month++){

            logger.info("navigate to month " + month);
            MainPage.ClickMonthByNumber(month);

            //count the number of shoes for the selected month
            int shoeCount = MainPage.GetShoeCount();
            logger.info("shoe count is ");

            for(int i=1; i<shoeCount+1; i++) {

                //verify that the shoe listing has a description
                logger.info("verify the blurb for shoe " + i + " of " + shoeCount);
                String shoeBlurb = MainPage.GetShoeBlurb(i);

                try{
                    Assert.assertFalse(shoeBlurb.isEmpty());
                }
                catch(AssertionError e){
                    logger.severe("Shoe listing " + shoeCount + "is missing description!" );
                }

                //find the image and verify isDisplayed() this may not be the best way;
                logger.info("verify the image of the shoe " + i + " of " + shoeCount);
                WebElement shoeImage = MainPage.CheckShoeImage(i);

                try{
                    Assert.assertTrue(shoeImage.isDisplayed());
                }
                catch(AssertionError e){
                    logger.severe("Shoe listing" + shoeCount + " is missing image!");
                }

                //verify that the shoe listing has a price listed
                logger.info("verify the pricing of the shoe " + i + " of " + shoeCount);
                String shoePrice = MainPage.GetShoePrice(i);

                try{
                    Assert.assertFalse(shoePrice.isEmpty());
                }
                catch(AssertionError e){
                    logger.severe("Shoe listing " + shoeCount + "is missing price!");
                }
            }
        }
    }
}
