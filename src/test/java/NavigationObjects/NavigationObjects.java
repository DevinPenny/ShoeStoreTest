/**
 * Created by Devin Penny on 1/5/17.
 */

package NavigationObjects;

import CommonComponents.CommonComponents;
import org.openqa.selenium.WebDriver;

public class NavigationObjects extends CommonComponents.CommonComponents {

    WebDriver driver;

    public void NavigateToPage(){
        driver.get(testProperties.get("ApplicationURI"));
    }
}
