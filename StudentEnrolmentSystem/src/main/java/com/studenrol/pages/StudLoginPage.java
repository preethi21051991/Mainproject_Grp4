package com.studenrol.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.studenrol.testbase.TestBase;

public class StudLoginPage extends TestBase {
	
	   @FindBy(xpath="//a[@routerlink='/login/studentlogin']")
	   WebElement loginBtn;
		
	   @FindBy(name="email")
	   WebElement emailId;
	   
	   @FindBy(name="password")
	   WebElement password;    
	   
	   @FindBy(name="sign-in")
	   WebElement signin;
	   
	   @FindBy(xpath="//*[@id='home']//a[(text()='VIEW PROFILE')]")
	   WebElement viewProfiletxt;
	    
	   @FindBy(xpath="//select[@name='role']")
	   WebElement roleDropdown;
	   
	   JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		public StudLoginPage()
		{		
			PageFactory.initElements(driver, this);
		}
		
		public LoginPage clickLoginBtn()
		{
			
			jse.executeScript("arguments[0].click()", loginBtn);
			//loginBtn.click();
			return new LoginPage();
		}
		
		public void setUserName(String strUserName)
		{
			emailId.sendKeys(strUserName);     
		}
		
		public void setPassword(String strPassword)
		{
		    password.sendKeys(strPassword);
		}
		
		public void signInClick()
		{
			jse.executeScript("arguments[0].click()", signin);
			//signin.click();		
		}	

		public String homePageViewProflTxtVerify()
		{
			return viewProfiletxt.getText();
		}
		
		
		public void roleDropdwnSelectText()
		{
			Select roldropdown  = new Select(roleDropdown);
			roldropdown.selectByVisibleText("Student");
		}
		
		public void clearInputTxt()
		{
			emailId.clear();
			password.clear();
		}
}