package com.PageActions;

import org.openqa.selenium.WebDriver;

import com.main.FrameworkActions;
import com.pageobjects.LoginpageObject;

public class LoginPage extends FrameworkActions{

	WebDriver driver;

	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	public String login(String username, String password) {
		LoginpageObject obj=new LoginpageObject(driver);
	send(obj.getLoginName(), username);
	send(obj.getPassword(),password);
	click(obj.getLoginButton());
	return obj.getLoginedName().getText();
	}




}
