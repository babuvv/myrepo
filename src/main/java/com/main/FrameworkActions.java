package com.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameworkActions extends FramewokBase {

	//WebDriver driver;
	//launch the application
	public void getURL(String url){
		//driver.get(url);
		getDriver().get(url);
	}

	public void click(WebElement element){
		element.click();		
	}

	public void send(WebElement element,String data) {
		element.sendKeys(data);
	}


}
