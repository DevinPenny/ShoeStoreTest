/**
 * Created by Devin Penny on 1/4/17.
 */
package CommonComponents;

import NavigationObjects.NavigationObjects;
import PageObjects.PageObjects;
import TestDataManagement.PropertiesManager;
import TestDataManagement.RandomDataGenerator;
import com.relevantcodes.extentreports.ExtentReports;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.*;


public class CommonObjects {

    protected WebDriver driver;
    public PageObjects MainPage;
    public NavigationObjects navigation;
    public RandomDataGenerator random;

    public Logger logger = Logger.getLogger(CommonObjects.class.getName());
    public Handler fileHandler;
    public Formatter formatter;
    public ExtentReports extent;

    public String LogFilePath = "..\\TestReporting\\ShoeStoreTest.log";
    public HashMap<String,String> testProperties;
    PropertiesManager getProperties;


    //use method overriding to provide control over how failures are handled
    @Rule
    public TestWatcher listen = new TestWatcher() {
        @Override
        public void failed(Throwable t, Description description) {
            logger.severe("Test: " + description.getClassName() + " Failed to execute When attempting method " + description.getMethodName());
            logger.severe("Stacktrace: " + t );
            //report error to test management tool here, this could be a web service call to rally or quality center or simply write to a test execution report

        }
    };

    //this is where common objects are created so that all tests can use them
    @Before
    public void WebDriverSetup() {

        //get the properties from the properties file, the return is a hash map of all properties
        try {
            getProperties = new TestDataManagement.PropertiesManager();
            testProperties = getProperties.GetPropertiesData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //set up file handler for the logger object
        try {
            fileHandler = new FileHandler(LogFilePath);
        }catch (IOException e){
            logger.severe("Caught fileHandler IOException: " + e);
        }

        //set up the formatter for writing to the log file
        try {
            formatter = new SimpleFormatter();
        }catch (Exception e){
            logger.severe("Caught formatter Exception: " + e);
        }

        //configure the logger to use file handler and formatter
        fileHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);

        //set up the test reporter using extent reports
        try {
            ExtentReports extent = new ExtentReports(testProperties.get("ExtentReportPath"), true);

        }catch (Exception e) {
            logger.severe("problem with extent reports");
        }

        //instantiate the web driver based on the the TestBrowser value in the properties file
        try {
            switch (testProperties.get("TestBrowser")){
                case "firefox":
                    logger.info("executing tests with Firefox browser");
                    System.setProperty("webdriver.gecko.driver","geckodriver_macos/geckodriver");
                    DesiredCapabilities ffCap =DesiredCapabilities.firefox();
                    ffCap.setCapability("marionette",true);
                    driver = new FirefoxDriver(ffCap);
                    break;
                case "chrome":
                    logger.info("executing tests with chrome browser");
                    System.setProperty("webdriver.chrome.driver", "chromedriver_macos/chromedriver");
                    DesiredCapabilities chromeCap =DesiredCapabilities.chrome();
                    chromeCap.setCapability("marionette",true);
                    driver = new ChromeDriver();
                    break;
                //currently IE has not been fully configured so do not use it at this time
                case "internetExplorer": driver = new InternetExplorerDriver();
                    break;
            }
        } catch(Exception e) {
            logger.severe("Error Loading driver for: " + testProperties.get("TestBrowser") + " exception:" + e);
        }

        //maximize browser window for test reliability
        driver.manage().window().maximize();
        //navigate to the page for testing
        driver.get(testProperties.get("ApplicationURI"));

        logger.info("Test preparations complete!");
    }

    //when all tests have been completed close the instance of web driver
    @After
    public void WebDriverShutDown(){

        driver.close();
        driver.quit();
        logger.info("Test Clean up complete");
    }
}