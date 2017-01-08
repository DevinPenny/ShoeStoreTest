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
import org.junit.Assert;
import org.junit.Test;

public class ShoeStoreStory1 extends CommonObjects {

    @Test
    public void VerifyMonthlyDisplay() {

        logger.info("Maximize browser window for test reliability");
        driver.manage().window().maximize();

        logger.info("navigate to page for first test");
        navigation.NavigateToPage();

        logger.info("Verify page tittle to prove application page loaded");
        MainPage.VerifyPageTitle();

        for(int month=1; month<12; month++){

            logger.info("navigate to month " + month);
            MainPage.ClickMonthByNumber(month);

            //fix this to get the proper shoe count
            //count the number of shoes for the selected month

            int shoeCount = 2;
            //MainPage = MainPage.GetShoeCount();
            logger.info("shoe count is ");



            for(int i=1; i<shoeCount+1; i++) {

                logger.info("verify the blurb for shoe " + i + " of " + shoeCount);
                MainPage = MainPage.GetShoeBlurb(i);


                //put the asserts into a try catch or something so the test continues when there is a failure
                Assert.assertFalse(MainPage.GetShoeBlurb(i).toString().isEmpty());

                //find the image and verify isDisplayed() this may not be the best way;
                logger.info("verify the image of the shoe " + i + " of " + shoeCount);
                MainPage = MainPage.CheckShoeImage(i);

                //Assert.assertTrue(imagePresent);

                logger.info("verify the pricing of the shoe " + i + " of " + shoeCount);
                MainPage = MainPage.GetShoePrice(i);
                //logger.info(shoePrice);
                //Assert.assertFalse(shoePrice.isEmpty());
            }
        }
    }
}
