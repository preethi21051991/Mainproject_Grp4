package com.studenrol.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.studenrol.testbase.TestBase;

public class HomePage extends TestBase 
{

	@FindBy(xpath="//a[@routerlink='home']")
	WebElement homeLink;

	@FindBy(xpath="//a[@routerlink='courses']")
	WebElement courseLink;
	
	@FindBy(xpath="//a[@routerlink='/login/studentlogin']")
	WebElement loginBtn;

	@FindBy(xpath="//a[text()='Go through our courses']")
	WebElement goThruCourseBtn;
	
	@FindBy(xpath="//h1[text()='Our Courses']")
	WebElement ourCourseText;
	
	@FindBy(xpath="//h1[text()='Login']")
	WebElement loginText;

	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	public HomePage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public String homePageUrlVerify()
	{
		return driver.getCurrentUrl();
	}

	public HomePage clickHomeLink()
	{
		jse.executeScript("arguments[0].click()", homeLink);
		//homeLink.click();
		return new HomePage();
	}
	
	public CoursePage clickCourseLink()
	{
		jse.executeScript("arguments[0].click()", courseLink);
		//courseLink.click();
		return new CoursePage();
	}
	
	public StudLoginPage clickLoginBtn()
	{
		jse.executeScript("arguments[0].click()", loginBtn);
		//loginBtn.click();
		return new StudLoginPage();
	}
		
	public CoursePage clickGoThruCourse()
	{
		jse.executeScript("arguments[0].click()", goThruCourseBtn);
		//goThruCourseBtn.click();
		return new CoursePage();
	}
	
	public String coursePageTextVerify()
	{
		return ourCourseText.getText();
	}
	
	public String loginPageTextVerify()
	{
		return loginText.getText();
	}
}