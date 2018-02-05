package com.PageActions;

import org.openqa.selenium.WebDriver;

import com.pageobjects.AddEmployeeObjects;

public class Add_Empolyee {
WebDriver driver;
public void AddEmployee(){
	this.driver = driver;
}
 public void Login(){
	 AddEmployeeObjects obj=new AddEmployeeObjects();
	 obj.getUserName().sendKeys("sairam");
	 obj.getPassword().sendKeys("sairam");	
	}
}
