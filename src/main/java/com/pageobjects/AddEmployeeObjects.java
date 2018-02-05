package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeeObjects {
 WebDriver driver; 
 WebDriverWait wait;
 
 public WebElement getUserName() {
	 return driver.findElement(By.name("username"));
	 
	 }
 public WebElement getPassword(){
	 return driver.findElement(By.id("pass"));
 }
}
