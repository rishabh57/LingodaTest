package com.lingoda.test.regression;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LingodaTest {
	 private WebDriver driver;

	  private String baseUrl;
	  
	  // Change the geckoDriverLocation according to your machine
	  private String geckoDriverLocation="/Users/rishabh/Documents/Workspace2019/Lingoda/rishabh.lingoda.test/drivers/geckodriver/geckodriver";

@BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	   System.setProperty("webdriver.gecko.driver",geckoDriverLocation);

	    driver = new FirefoxDriver();
	    baseUrl = "https://www.amazon.de/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

@Test (priority=1)
   public void openAmazon() throws Exception {
	    driver.get(baseUrl);
	    driver.manage().window().maximize();
	    
	  }
	  
@Test(priority=2)
	  
   public void searchBatman() throws Exception {
	    driver.findElement(By.id("twotabsearchtextbox")).click();
	    driver.findElement(By.id("twotabsearchtextbox")).clear();
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Batman Comics");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Los'])[1]/following::input[1]")).click();
	  }
	  
	  
	  
	    
@Test(priority=3)
	  
	public void checkNumber() throws Exception {
	  String text1=  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Amazon Assistant'])[1]/following::span[2]")).getText();
	  System.out.println(text1);
	  boolean isFound = text1.contains("20.000");
	  
	  Assert.assertEquals(isFound, true);
	  
	  
}
	  
	  // storing and comparing values of Title and Price

@Test(priority=4)

     public void checkTitleAndPrice() throws Exception {
  

	    String outTitle = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Internationaler Versand verfügbar'])[1]/following::span[6]")).getText();
	    String outPrice = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Taschenbuch'])[2]/following::span[4]")).getText();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Taschenbuch'])[2]/following::span[4]")).click();
	    String inTitle = driver.findElement(By.id("productTitle")).getText();
	    String inPrice = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Taschenbuch'])[3]/following::span[2]")).getText();
	    Assert.assertEquals(inTitle, outTitle);
	    Assert.assertEquals(inPrice, outPrice);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Taschenbuch'])[3]/following::span[2]")).click();
	  
	  }

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();

	  }
}
