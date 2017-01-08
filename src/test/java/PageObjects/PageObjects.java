/**
 * Created by Devin Penny on 1/4/17.
 */
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageObjects {

    WebDriver driver;

    //selectors for page objects that do not have to be in the method
    By enterEmailSelector = By.id("remind_email_input");
    By clickRemindEmail = By.id("remind_email_submit");
    By getSuccessSelector = By.xpath(".//*[@id='flash']/div");
    By getFailSelector = By.cssSelector(".flash.alert_danger");


    By getShoeCount = By.xpath(".//*[@id='shoe_list']/li");

    public PageObjects(WebDriver driver){
         this.driver = driver;
    }

    public void ClickRemindEmail(){
        driver.findElement(clickRemindEmail).click();

        //wait for half a second before continuing with other steps
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException ie){
            System.out.println("computer cant sleep, must be insomnia");
        }
    }

    public void EnterEmailAddress(String email) {
        driver.findElement(enterEmailSelector).sendKeys(email);
    }

    public String GetEmailConfirmation() {
        String confirmation = driver.findElement(getSuccessSelector).getText();
        return confirmation;
    }

    public String VerifyEmailFailure() {

        String emailFailure = driver.findElement(getFailSelector).getText();
        return emailFailure;
    }

    public String VerifyPageTitle() {

        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public void ClickMonthByNumber(int month) {

        By clickMonthByNumber = By.xpath(".//*[@id='header_nav']/nav/ul/li[" + month +"]/a");
        driver.findElement(clickMonthByNumber).click();

        //wait for half a second before continuing with other steps
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException ie){
            System.out.println("computer cant sleep, must be insomnia");
        }
    }

    public int GetShoeCount(){

        int shoeCount = driver.findElements(getShoeCount).size();
        return shoeCount;
    }

    public String GetShoeBlurb(int shoeNumber){

        By getShoeBlurb = By.xpath(".//*[@id='shoe_list']/li[" + shoeNumber +"]/div/table/tbody/tr[3]/td[2]");
        String shoeBlurb = driver.findElement(getShoeBlurb).getText();
        return shoeBlurb;
    }

    public WebElement CheckShoeImage(int shoeNumber){

        By checkShoeImage = By.xpath(".//*[@id='shoe_list']/li[" + shoeNumber +"]/div/table/tbody/tr[6]/td/img");
        WebElement shoeImage = driver.findElement(checkShoeImage);
        return shoeImage;
    }

    public String GetShoePrice(int shoeNumber){

        By getShoePrice = By.xpath(".//*[@id='shoe_list']/li[" + shoeNumber +"]/div/table/tbody/tr[4]/td[2]");
        String shoePrice = driver.findElement(getShoePrice).getText();
        return shoePrice;
    }

}