package com.lingoda.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
// Just for illustration purpose
	
	public WebDriver driver = null;
	public WebDriver getDriver(){
		driver = new FirefoxDriver();
		return driver;
	}
}
