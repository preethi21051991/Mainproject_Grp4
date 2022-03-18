package com.studennrol.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studenrol.pages.HomePage;
import com.studenrol.testbase.TestBase;

public class HomePageTest extends TestBase
{
	HomePage objHomePg;

	// Verify Student Enrollment System Home Page
	@Test(priority=0)
	public void verifyHomePage() throws Exception
	{
		//Create Login Page object
		objHomePg = new HomePage();
		objHomePg.clickHomeLink();
		String homePageTitleActual=driver.getTitle();
		Thread.sleep(3000);
		String homePageTitleExp="Student Enrollment System";
		
		Assert.assertEquals(homePageTitleExp, homePageTitleActual);
	}

	// Verify Student Enrollment System Login Page
	@Test(priority=1)
	public void verifyLoginPage() throws Exception
	{
		objHomePg = new HomePage();
		objHomePg.clickLoginBtn();
		String loginUrlActual=driver.getCurrentUrl();
		Thread.sleep(3000);
		//driver.navigate().back();
		String loginUrlExp=prop.getProperty("loginPgUrl");
		
		Assert.assertEquals(loginUrlExp, loginUrlActual);
	} 	


}

