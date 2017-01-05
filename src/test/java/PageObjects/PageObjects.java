/**
 * Created by Devin Penny on 1/4/17.
 */
package PageObjects;

import CommonComponents.CommonFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PageObjects extends CommonFunctions {

    WebDriver driver;

    public static final String ClickRemindEmail = "remind_email_submit";
    public static final String EnterEmailSelector = "remind_email_input";
    public static final String GetTextFromPageSelector = "SomeSelector";

    public PageObjects(WebDriver driver) {
        this.driver = driver;
    }


    public void ClickRemindEmail(){
        driver.findElement(By.id(ClickRemindEmail)).click();

    }

    public void EnterEmailAddress(String email) {
        driver.findElement(By.id(EnterEmailSelector)).sendKeys(email);
    }

    public String GetTextFromPage() {

        return driver.findElement(By.id(GetTextFromPageSelector)).getText();

    }
    public void VerifyPageTitle() {

        Assert.assertTrue(driver.getTitle().equals("Shoe Store: Welcome to the Shoe Store"));
    }
}