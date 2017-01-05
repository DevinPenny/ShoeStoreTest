/**
 * Created by Devin Penny on 1/4/17.
 */
package SeleniumTests;

import CommonComponents.CommonFunctions;
import NavigationObjects.NavigationObjects;
import PageObjects.PageObjects;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;


public class ShoeStoreTest1 extends CommonFunctions {

    PageObjects MainPage = new PageObjects(driver);
    NavigationObjects navigation = new NavigationObjects();

    @Rule
    public TestWatcher listen = new TestWatcher() {

        @Override
        public void failed (Throwable t, Description description){
            logger.severe("Test Failed!");
            System.out.println(description.getClassName() + ", " + description.getMethodName());
            //report error to test management tool here, this could be a web service call to insert data into rally or quality center

        }
    };


    @Test
    public void FirstTestToExecute() {

        logger.info("Maximize browser window for test reliability");
        driver.manage().window().maximize();

        logger.info("navigate to page for first test");
        driver.get("https://rb-shoe-store.herokuapp.com/");
        //navigation.NavigateToPage();

        //enter email
        MainPage.EnterEmailAddress("test@nope.com");

        //click remind email button
        MainPage.ClickRemindEmail();

        //Verify the result
        Assert.assertTrue(MainPage.VerifyPageTitle().contains("Shoe Store: Welcome to the Shoe Store"));

    }


}