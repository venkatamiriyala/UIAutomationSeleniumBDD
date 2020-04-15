package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.runtime.junit.Assertions;
import utilities.Helper;
public class DressesPage {
    public WebDriver ldriver;
    Helper helper;

    // Constructer
    public DressesPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
        helper=new Helper(ldriver);   // WAIT from Utils
     }
    String dressName;
    By menuDress =By.linkText("DRESSES");
    By dressHeader =By.xpath("//*[@id='categories_block_left']/h2");
    By sumDrsSubMenu= By.xpath("//div[@class='block_content']//ul[@class='tree dynamized']//a[contains(text(),'Summer Dresses')]");
    By sumDrsPageHeader = By.xpath("//span[@class='cat-name']");
    By sumDrsBrdCrumb = By.xpath("//div[@class='breadcrumb clearfix']//a[contains(text(),'Dresses')]");
    By sumDrsSortBy = By.id("selectProductSort");
    By sumDrsSortPriceLow = By.xpath("//option[. = 'Price: Lowest first']");
    By sumDrs1 = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[1]/span[1]");
    By sumDrs2 = By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[1]/span[1]");
    By sumDrs3 = By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/div[1]/span[1]");
    By selDrs = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[2]/span");
    By selDrsName = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a");
    By selDrsPrice = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[1]/span[1]");
    By selDrsNameDetailsPage = By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1");
    By selDrsPriceDetailsPage = By.xpath("//*[@id=\"our_price_display\"]");
    By derColor = By.name("Blue");
    By addCart	= By.xpath("//*[@id=\"add_to_cart\"]/button/span");
    By selDrsNameVCart = By.xpath("//*[@id=\"layer_cart_product_title\"]");
    By selDrsColorVCart = By.xpath("//*[@id=\"layer_cart_product_attributes\"]");
    By prcdChkOut = By.xpath("//span[contains(.,\'Proceed to checkout\')]");
    By crtTitile = By.xpath("//*[@id=\"cart_title\"]");
    By crtDetails = By.xpath("//*[@id=\"order-detail-content\"]");
    
    public void clickDress() throws InterruptedException {
      //  waitHelper.WaitForElement((WebElement) menuDress, waitHelper.maxWait);
        Thread.sleep(3000);
        ldriver.findElement(menuDress).click();
    }

    public void dressHeader() throws InterruptedException {
        helper.verifyPageContent("DRESSES",dressHeader );
    }

    public void clickSumDress() throws InterruptedException {
        ldriver.findElement(sumDrsSubMenu).click();
    }

    public void verifySumDressHeader() throws InterruptedException {
        helper.verifyPageContent("SUMMER DRESSES", sumDrsPageHeader);
    }

    public void verifyMegaMenu() throws InterruptedException {
        helper.verifyPageContent("Dresses", sumDrsBrdCrumb);
        ldriver.findElement(sumDrsBrdCrumb).click();
        helper.verifyPageContent("DRESSES",dressHeader );
    }

    public void clickOnSortBy() throws InterruptedException {
    	WebElement dropdown = ldriver.findElement(sumDrsSortBy);
    	System.out.println(" Clicked on the dropdown");
    	Thread.sleep(2000);
    	dropdown.findElement(sumDrsSortPriceLow).click();
    }
    
    public void verifySortByPrice() throws InterruptedException {
      double P1= Double.valueOf(ldriver.findElement(sumDrs1).getText().replace("$",""));
	    double P2= Double.valueOf(ldriver.findElement(sumDrs2).getText().replace("$",""));
	    double P3= Double.valueOf(ldriver.findElement(sumDrs3).getText().replace("$",""));
	    System.out.println("Dress 1" +P1+ "\n"+P2 +"\n"+ P3);
	    if(P1>P2 || P1>P3)
	    	Assert.assertTrue(false);
	    else if( P2>P1 || P2>P3)
	    	Assert.assertTrue(false);
	    else 
	    	Assert.assertTrue(true);
	    }
    
    public void selectDreess() throws InterruptedException{
    	dressName=ldriver.findElement(selDrsName).getText();
    	System.out.println("Dress Name: "+dressName);
    	ldriver.findElement(selDrsName).click();
    	Thread.sleep(5000);
    	Assert.assertEquals(dressName,ldriver.findElement(selDrsNameDetailsPage).getText());
    }
  
    public void verifyAddToCart() throws InterruptedException{
        ldriver.findElement(derColor).click();
        ldriver.findElement(addCart).click();;
        Thread.sleep(5000);
      	Assert.assertEquals((ldriver.findElement(selDrsNameVCart).getText()), dressName);
      	Assert.assertEquals((ldriver.findElement(selDrsColorVCart).getText()),"Blue, S");
        ldriver.findElement(prcdChkOut).click();
    }
  
    public void verifyCartSummary()
    {
    	String cartDress = ldriver.findElement(crtTitile).getText();  
    	Assert.assertTrue(cartDress.contains("SHOPPING-CART SUMMARY"));
    
    	String cartDetails = ldriver.findElement(crtDetails).getText();
    	Assert.assertTrue(cartDetails.contains("Color : Blue"));
    }
    
}