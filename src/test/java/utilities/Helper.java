package utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

    public WebDriver driver;

    // Global Wait variables
    public long minWait=30;
    public long maxWait=45;

    //constructor
    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    //Wait for Element Util
    public void WaitForElement(By selDrsNameDetailsPage, long timeOutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf((WebElement) selDrsNameDetailsPage));
    }

    public void verifyPageContent(String expected, By element) throws InterruptedException {
        Thread.sleep(3000);
        String actual= driver.findElement(element).getText();
        System.out.println("Captured ELEMENT TEXT is : " + actual);
        if(actual.contains(expected))
            Assert.assertTrue(true);
        else
            Assert.assertTrue(false);

    }

}