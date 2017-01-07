/**
 * Created by Devin Penny on 1/4/17.
 */
package PageObjects;

import CommonComponents.CommonObjects;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageObjects extends CommonObjects {

    public static final String ClickRemindEmail = "remind_email_submit";
    public static final String EnterEmailSelector = "remind_email_input";
    public static final String GetSuccessFailSelector = ".//*[@id='flash']/div";

    public PageObjects(WebDriver driver){
        super(driver);
    }

    public PageObjects ClickRemindEmail(){
        driver.findElement(By.id(ClickRemindEmail)).click();
        return new PageObjects(driver);
    }

    public void EnterEmailAddress(String email) {
        driver.findElement(By.id(EnterEmailSelector)).sendKeys(email);
    }

    public PageObjects GetEmailConfirmation() {

        String confirmation = driver.findElement(By.xpath(GetSuccessFailSelector)).getText();

        return new PageObjects(driver);
    }


    public PageObjects VerifyEmailFailure() {

        Assert.assertTrue(driver.findElement(By.xpath(GetSuccessFailSelector))
                .getText()
                .equals("Invalid email format. Ex. name@example.com"));
        return new PageObjects(driver);
    }

    public PageObjects VerifyPageTitle() {

        Assert.assertTrue(driver.getTitle().equals("Shoe Store: Welcome to the Shoe Store"));

        return new PageObjects(driver);
    }

    public PageObjects ClickMonthByNumber(int month) {

        driver.findElement(By.xpath(".//*[@id='header_nav']/nav/ul/li[" + month +"]/a")).click();


        //wait for half a second before continuing with other steps
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException ie){
            logger.severe("computer cant sleep, must be insomnia");
        }

        return new PageObjects(driver);
    }

    public PageObjects GetShoeCount(){

        int shoeCount = driver.findElements(By.xpath(".//*[@id='shoe_list']/li")).size();
        return new PageObjects(driver);
    }

    public PageObjects GetShoeBlurb(int shoeNumber){

        String shoeBlurb = driver.findElement(By.xpath(".//*[@id='shoe_list']/li[" + shoeNumber +"]/div/table/tbody/tr[3]/td[2]")).getText();
        return new PageObjects(driver);
    }

    public PageObjects CheckShoeImage(int shoeNumber){

        WebElement shoeImage = driver.findElement(By.xpath(".//*[@id='shoe_list']/li[" + shoeNumber +"]/div/table/tbody/tr[6]/td/img"));
        return new PageObjects(driver);
    }

    public PageObjects GetShoePrice(int shoeNumber){

        String shoePrice = driver.findElement(By.xpath(".//*[@id='shoe_list']/li[" + shoeNumber +"]/div/table/tbody/tr[4]/td[2]")).getText();
        return new PageObjects(driver);
    }

}