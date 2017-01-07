/**
 * Created by Devin Penny on 1/4/17.
 * the purpose of this class is to define what tests you wish to execute, it is only necessary if you are not executing all tests
 */
package TestRunner;


import SeleniumTests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ShoeStoreStory1.class,ShoeStoreStory2.class, ShoeStoreStory2Negative.class})

public class TestRunner {}