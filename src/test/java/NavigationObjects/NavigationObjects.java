/**
 * Created by Devin Penny on 1/5/17.
 */

package NavigationObjects;

import CommonComponents.CommonObjects;
import org.openqa.selenium.WebDriver;

public class NavigationObjects extends CommonObjects {

    WebDriver driver;

    public void NavigateToPage(){
        driver.get(testProperties.get("ApplicationURI"));
    }
}
