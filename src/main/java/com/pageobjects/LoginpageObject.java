package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginpageObject {

	WebDriver driver;	

	//constructor ----class and method name should be same
	public LoginpageObject(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getLoginName(){
	return driver.findElement(By.name("txtUserName"));
	}
	public WebElement getPassword(){
	return  driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/input"));
		
	}
	public WebElement getLoginButton(){
	return driver.findElement(By.name("Submit"));
	}
	
	public WebElement getLoginedName(){
		return driver.findElement(By.xpath(".//*[@id='option-menu']/li[1]"));
	}
}
