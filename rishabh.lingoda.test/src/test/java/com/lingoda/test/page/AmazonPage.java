
package com.lingoda.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lingoda.test.Base;

public class AmazonPage extends Base {

	public WebDriver driver;
	public AmazonPage(WebDriver driver){
		this.driver = driver;		
	}
	public By searchBox = By.id("twotabsearchtextbox");
	public WebElement getFName(){
		return driver.findElement(searchBox);
	}
	public By searchButton = By.xpath(".//*[normalize-space(text()) and normalize-space(.)='Los'])[1]/following::input[1]");
	public WebElement getLName(){
		return driver.findElement(searchButton);
	}
	
	
	
}
