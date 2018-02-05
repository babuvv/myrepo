package com.main;

import org.apache.xmlbeans.impl.piccolo.xml.XMLInputReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.util.XLReder;


public class FramewokBase {
	//variable declaration
	WebDriver driver; 
	//xl reader  object used
	private XLReder reader;

	private String url; 

	public XLReder getReader() {
		return reader;
	}
	public void setReader(XLReder reader){
		this.reader=reader;
	}
	public WebDriver getDriver(){
		return driver;

	}
	public void setDriver(WebDriver driver){
		this.driver=driver;
	}

	public void instilized(String browser){
		if (driver == null&& browser.equalsIgnoreCase("firefox")){
			driver= new FirefoxDriver();
			setDriver(driver);

		}
		else if (driver == null&& browser.equalsIgnoreCase("chrome")){
			driver= new ChromeDriver();
			setDriver(driver);

		} 
		else if (driver == null && browser.equalsIgnoreCase("IE") ){	
			driver= new InternetExplorerDriver();
			setDriver(driver);
		}
	}
}

