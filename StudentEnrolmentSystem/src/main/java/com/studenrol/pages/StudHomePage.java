package com.studenrol.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.studenrol.testbase.TestBase;

public class StudHomePage  extends TestBase {
	
	@FindBy(xpath="//a[@routerlink='home']")
	WebElement homeLink;
	
	@FindBy(xpath="//a[@routerlink='courses']")
	WebElement courseLink;
	
	@FindBy(xpath="//h1[text()='Our Courses']")
	WebElement ourCourseText;
	
	@FindBy(xpath="//*[@id=\"courses\"]//div/button/a")        
	WebElement knowmorebutton;
	
	@FindBy(xpath="//*[@id=\"team\"]/div[2]/a/button")        
	WebElement showmorebutton;
	
	@FindBy(xpath="//*[@id=\"courses\"]//div[2]/div[2]/h3")        
	WebElement mernstack;      
	
	@FindBy(xpath="//*[@id=\"generic_price_table\"]//section//div/button/a")        
	WebElement enrollnowbtn;      
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	
	@FindBy(xpath="//a[text()='VIEW PROFILE']")
	WebElement viewprofile;
	
	@FindBy(xpath="//h1[text()='STUDENT DETAILS']")
	WebElement ourStudDetailsText;
	
	@FindBy(xpath="//h1[contains(text(),'WELCOME')]")
	WebElement studHomePageText;
			
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	public StudHomePage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage clickHomeLink()
	{		
		jse.executeScript("arguments[0].click()", homeLink);		
		return new HomePage();
	}
		
	public CoursePage clickCourseLink()
	{		
		jse.executeScript("arguments[0].click()", courseLink);		
		return new CoursePage();
	}
	
	public String coursePageTextVerify()
	{
		return ourCourseText.getText();
	}	
	
	public String studDetailTextVerify()
	{
		return ourStudDetailsText.getText();
	}	
	
	public HomePage clickLogoutLink()
	{
		jse.executeScript("arguments[0].click()", logout);		
		return new HomePage();
	}
	
	public StudDetailsPage clickViewProfile()
	{
		jse.executeScript("arguments[0].click()", viewprofile);		
		return new StudDetailsPage();
	}

	public String stuHomePageTextVerify()
	{
		return studHomePageText.getText();
	}
	
	public CoursePage clickknowmorebutton()
	{
		jse.executeScript("arguments[0].click()", knowmorebutton);		
		return new CoursePage();
	}
	
	public CoursePage clickShowmorebutton()
	{
		jse.executeScript("arguments[0].click()", showmorebutton);		
		return new CoursePage();
	}
	
	public String CourseNameTextVerify()
	{
		return mernstack.getText();
	}
	
	public CoursePage clickenrollnowbutton()
	{
		jse.executeScript("arguments[0].click()", enrollnowbtn);		
		return new CoursePage();
	}

	
}
