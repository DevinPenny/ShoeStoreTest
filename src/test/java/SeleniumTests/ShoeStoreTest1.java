/**
 * Created by Devin Penny on 1/4/17.
 */
package SeleniumTests;

import CommonComponents.CommonFunctions;
import PageObjects.PageObjects;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;


public class ShoeStoreTest1 extends CommonFunctions {

    PageObjects MainPage = new PageObjects(driver);

    @Rule
    public TestWatcher listen = new TestWatcher() {

        @Override
        public void failed (Throwable t, Description description){
            System.out.println("Test Failed!");
            System.out.println(description.getClassName() + ", " + description.getMethodName());
            //report error to test management tool here, this could be a web service call to insert data into rally or quality center

        }
    };


    @Test
    public void FirstTestToExecute() {


        logger.info("navigate to page for first test");
        MainPage.NavigateToPage();

        //Verify the result
        Assert.assertTrue(MainPage.GetTextFromPage().contains("Some Message"));

    }


}