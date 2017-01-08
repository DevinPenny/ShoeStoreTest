/**
 * Created by Devin Penny on 1/4/17.
 */
package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageObjects {

    WebDriver driver;

    public String ClickRemindEmail = "remind_email_submit";
    public String EnterEmailSelector = "remind_email_input";
    public String GetSuccessFailSelector = ".//*[@id='flash']/div";


    public PageObjects(WebDriver driver){
         this.driver = driver;
    }

    public void ClickRemindEmail(){
        driver.findElement(By.id(ClickRemindEmail)).click();
    }

    public void EnterEmailAddress(String email) {
        driver.findElement(By.id(EnterEmailSelector)).sendKeys(email);
    }

    public String GetEmailConfirmation() {

        String confirmation = driver.findElement(By.xpath(GetSuccessFailSelector)).getText();
        System.out.println(confirmation);
        return confirmation;
    }


    public void VerifyEmailFailure() {

        Assert.assertTrue(driver.findElement(By.xpath(GetSuccessFailSelector))
                .getText()
                .equals("Invalid email format. Ex. name@example.com"));

    }

    public String VerifyPageTitle() {

       String pageTitle = driver.getTitle();

        return pageTitle;
    }

    public void ClickMonthByNumber(int month) {

        driver.findElement(By.xpath(".//*[@id='header_nav']/nav/ul/li[" + month +"]/a")).click();


        //wait for half a second before continuing with other steps
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException ie){
            System.out.println("computer cant sleep, must be insomnia");
        }


    }

    public int GetShoeCount(){

        int shoeCount = driver.findElements(By.xpath(".//*[@id='shoe_list']/li")).size();
        return shoeCount;
    }

    public String GetShoeBlurb(int shoeNumber){

        String shoeBlurb = driver.findElement(By.xpath(".//*[@id='shoe_list']/li[" + shoeNumber +"]/div/table/tbody/tr[3]/td[2]")).getText();
        return shoeBlurb;
    }

    public WebElement CheckShoeImage(int shoeNumber){

        WebElement shoeImage = driver.findElement(By.xpath(".//*[@id='shoe_list']/li[" + shoeNumber +"]/div/table/tbody/tr[6]/td/img"));
        return shoeImage;
    }

    public String GetShoePrice(int shoeNumber){

        String shoePrice = driver.findElement(By.xpath(".//*[@id='shoe_list']/li[" + shoeNumber +"]/div/table/tbody/tr[4]/td[2]")).getText();
        return shoePrice;
    }

}