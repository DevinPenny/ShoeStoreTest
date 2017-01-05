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
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;


public class ShoeStoreStory1 extends CommonFunctions {

    PageObjects MainPage = new PageObjects(driver);
    NavigationObjects navigation = new NavigationObjects();

    @Test
    public void VerifyMonthlyDisplay() {

        logger.info("Maximize browser window for test reliability");
        driver.manage().window().maximize();

        logger.info("navigate to page for first test");
        navigation.NavigateToPage();
        //driver.get(testProperties.get("ApplicationURI"));

        logger.info("Verify page tittle to prove application page loaded");
        MainPage.VerifyPageTitle();

        //this for loop needs to go into the page objects after it is working

        for(int month=1; month<12; month++){

            logger.info("navigate to month " + month);
            driver.findElement(By.xpath(".nav > li:nth-child(1) > a:nth-child(" + month + ")")).click();

            //determine number of shoes for the month, here are a few posible ways to do it

            List<WebElement> shoeCount = driver.findElements(By.xpath("[@id='shoe_list']//li"));

            WebElement table_element = driver.findElement(By.id("shoe_list"));
            //List<WebElement> shoeList =table_element.findElements(By.xpath("id('shoe_list')ul/tbody/tr"));
            List<WebElement> shoeList = table_element.findElements(By.cssSelector(".shoe_result"));


            Iterator<WebElement> itr = shoeList.iterator();
            while(itr.hasNext()) {
                int i = 1; i++;

                logger.info("verify the blurb for shoe");
                String shoeBlurb = driver.findElement(By.cssSelector(".shoe_result_value:nth-of-type(" + i + ").shoe_description")).getText();

                logger.info("verify the image of the shoe");
                //find the image and verify isPresent();

                logger.info("verify the pricing of the shoe");
                String shoePrice = driver.findElement(By.cssSelector(".shoe_result_value:nth-of-type(" + i + ").shoe_price")).getText();

            }
        }
    }
}
