/**
 * Created by Devin Penny on 1/4/17.
 */
package PageObjects;

import CommonComponents.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PageObjects extends CommonFunctions {

    WebDriver driver;

    public static final String ClickButtonSelector = "SomeSelector";
    public static final String EnterTextInFieldSelector = "SomeSelector";
    public static final String GetTextFromPageSelector = "SomeSelector";

    public PageObjects(WebDriver driver) {
        this.driver = driver;
    }


    public void ClickButton(){
        driver.findElement(By.id(ClickButtonSelector)).click();

    }

    public void EnterTextInField() {
        driver.findElement(By.id(EnterTextInFieldSelector)).sendKeys("SomeText");
    }

    public String GetTextFromPage() {

        return driver.findElement(By.id(GetTextFromPageSelector)).getText();

    }

    public void NavigateToPage(){
        //String testPath = testProperties.get("ApplicationURI");
        driver.get("https://rb-shoe-store.herokuapp.com/");
        //driver.get(testPath);
    }
}