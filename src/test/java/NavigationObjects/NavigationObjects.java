/**
 * Created by Devin Penny on 1/5/17.
 */

package NavigationObjects;

import CommonComponents.CommonObjects;
import org.openqa.selenium.WebDriver;


public class NavigationObjects {

    WebDriver driver;

    public NavigationObjects(WebDriver driver){
        //super(driver);
        this.driver = driver;
    }

    public NavigationObjects NavigateToPage(){
       // driver.get(testProperties.get("ApplicationURI"));
        return new NavigationObjects(driver);
    }
}
