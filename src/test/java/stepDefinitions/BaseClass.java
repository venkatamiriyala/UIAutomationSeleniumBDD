package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.DressesPage;
import pageObjects.RegistrationPage;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;  //initiate a global driver
    public RegistrationPage rp;   // create an object for the  pagefactory to use those methods
    public DressesPage dp;   // create an object for the pagefactory to use those methods
    public static Logger logger;   // Initiate LOGGER
    public Properties configProp;

    // Creating a unique string for email purpose
    public static String randomString() {
        String randomString1= RandomStringUtils.randomAlphanumeric(6);
        return (randomString1);
    }
}

