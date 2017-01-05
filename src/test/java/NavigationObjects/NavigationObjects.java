/**
 * Created by Devin Penny on 1/5/17.
 */

package NavigationObjects;

import CommonComponents.CommonFunctions;

public class NavigationObjects extends CommonFunctions {

    public void NavigateToPage(){
        driver.get(testProperties.get("ApplicationURI"));
    }
}
