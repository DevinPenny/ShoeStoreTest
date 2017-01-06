/**
 * Created by Devin Penny on 1/4/17.
 */
package PageObjects;

import CommonComponents.CommonFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageObjects extends CommonFunctions {

    WebDriver driver;

    public static final String ClickRemindEmail = "remind_email_submit";
    public static final String EnterEmailSelector = "remind_email_input";
    public static final String GetSuccessFailSelector = ".//*[@id='flash']/div";

    public PageObjects(WebDriver driver) {
        this.driver = driver;
    }


    public void ClickRemindEmail(){
        driver.findElement(By.id(ClickRemindEmail)).click();

    }

    public void EnterEmailAddress(String email) {
        driver.findElement(By.id(EnterEmailSelector)).sendKeys(email);
    }

    public void VerifyEmailConfirmation(String emailAddress) {
        Assert.assertTrue(driver.findElement(By.xpath(GetSuccessFailSelector))
                .getText()
                .equals("Thanks! We will notify you of our new shoes at this email: " + emailAddress + "@shoestoretesting.com"));
    }


    public void VerifyEmailFailure() {


        Assert.assertTrue(driver.findElement(By.xpath(GetSuccessFailSelector))
                .getText()
                .equals("Invalid email format. Ex. name@example.com"));
    }

    public void VerifyPageTitle() {

        Assert.assertTrue(driver.getTitle().equals("Shoe Store: Welcome to the Shoe Store"));
    }

    public void ClickMonthbyNumber(int month) {

        driver.findElement(By.xpath(".//*[@id='header_nav']/nav/ul/li[" + month +"]/a")).click();

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
            logger.severe("computer cant sleep, must be insomnia");
        }

    }

    public int GetShoeCount(){

        int shoeCount = driver.findElements(By.xpath(".//*[@id='shoe_list']/li")).size();
        return shoeCount;
    }

    public String GetshoeBlurb(int shoeNumber){

        String shoeBlurb = driver.findElement(By.xpath(".//*[@id='shoe_list']/li[" + shoeNumber +"]/div/table/tbody/tr[3]/td[2]")).getText();
        return shoeBlurb;
    }

    public boolean CheckshoeImage(int shoeNumber){

        WebElement shoeImage = driver.findElement(By.xpath(".//*[@id='shoe_list']/li[" + shoeNumber +"]/div/table/tbody/tr[6]/td/img"));
        return shoeImage.isDisplayed();
    }

    public String GetShoePrice(int shoeNumber){

        String shoePrice = driver.findElement(By.xpath(".//*[@id='shoe_list']/li[" + shoeNumber +"]/div/table/tbody/tr[4]/td[2]")).getText();
        return shoePrice;
    }

}