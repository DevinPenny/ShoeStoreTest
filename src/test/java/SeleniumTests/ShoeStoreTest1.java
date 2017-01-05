/**
 * Created by Devin Penny on 1/4/17.
 */
package SeleniumTests;

import CommonComponents.CommonFunctions;
import NavigationObjects.NavigationObjects;
import PageObjects.PageObjects;
import TestDataManagement.RandomDataGenerator;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class ShoeStoreTest1 extends CommonFunctions {

    PageObjects MainPage = new PageObjects(driver);
    NavigationObjects navigation = new NavigationObjects();
    RandomDataGenerator random = new RandomDataGenerator();

    /*
    @Rule
    public TestWatcher listen = new TestWatcher() {

        @Override
        public void failed (Throwable t, Description description){
            //report error to test management tool here, this could be a web service call to insert data into rally or quality center
            logger.severe("Test Failed!");
            logger.severe(description.getClassName() + ", " + description.getMethodName());
        }
    };
*/

    @Test
    public void VerifyPageAccess() {

        logger.info("Maximize browser window for test reliability");
        driver.manage().window().maximize();

        logger.info("navigate to page for first test");
        driver.get("https://rb-shoe-store.herokuapp.com/");
        //navigation.NavigateToPage();

        //Verify the result
        MainPage.VerifyPageTitle();
    }


    @Test
    public void VerifyEmailSubmission() {

        logger.info("create random email address for test");
        String randomEmail = random.GetRandomString(7);
        logger.info("random email id is: " + randomEmail + "@website.com");

        logger.info("Enter and submit an email address to be reminded about shoes");
        //enter email
        MainPage.EnterEmailAddress(randomEmail + "@shoestoretesting.com");

        //click remind email button
        MainPage.ClickRemindEmail();
    }
}