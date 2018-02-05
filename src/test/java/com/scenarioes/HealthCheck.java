package com.scenarioes;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.PageActions.LoginPage;
import com.main.FramewokBase;
import com.main.FrameworkActions;
import com.util.XLReder;

public class HealthCheck {
	WebDriver driver;
	FramewokBase fb;

	@BeforeClass
	public void before() throws Exception{
		fb=new FramewokBase();
		fb.instilized("firefox");
		driver = fb.getDriver();
		FrameworkActions fa=new FrameworkActions();
		fa.setDriver(driver);
		XLReder reader = new XLReder("C:\\Users\\Welcome\\Desktop\\TestData.xlsx", "Sheet1");
		fb.setReader(reader);
		fa.getURL(reader.readdata(2, "url"));
	}
	@AfterClass
	public void tearDown() throws IOException{
		fb.getReader().closeWorkBook();
		driver.close();
		driver.quit();
	}


	@Test
	public void LoginTest(){
		LoginPage pg=new LoginPage(driver);
		String user = pg.login(fb.getReader().readdata(2, "Username"),fb.getReader().readdata(2, "password"));
		System.out.println("-------------------->"+user);
		fb.getReader().setData(2, 3, user);
	}

}
