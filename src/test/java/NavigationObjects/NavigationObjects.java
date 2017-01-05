/**
 * Created by Devin Penny on 1/5/17.
 */

package NavigationObjects;

import CommonComponents.CommonFunctions;
import org.openqa.selenium.WebDriver;

public class NavigationObjects extends CommonFunctions {

    WebDriver driver;

    public void NavigateToPage(){
        driver.get(testProperties.get("ApplicationURI"));
    }
}
