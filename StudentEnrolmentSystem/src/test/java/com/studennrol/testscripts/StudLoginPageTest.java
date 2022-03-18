package com.studennrol.testscripts;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.studenrol.constants.AutomationConstants;
import com.studenrol.pages.StudHomePage;
import com.studenrol.pages.StudLoginPage;
import com.studenrol.testbase.TestBase;
import com.studenrol.utilities.ExcelUtility;

public class StudLoginPageTest  extends TestBase {
	
	StudLoginPage objStudLognPg;
	StudHomePage objStudHomePg;
		 
	// Able to navigate to Login Page
	@Test(priority=0)
	public void verifyLoginPage() throws Exception
	{
		objStudLognPg = new StudLoginPage();
		objStudLognPg.clickLoginBtn();
		String loginUrlActual=driver.getCurrentUrl();
		Thread.sleep(3000);		
		String loginUrlExp=prop.getProperty("loginPgUrl");
		Assert.assertEquals(loginUrlExp, loginUrlActual);
	}
	
	// Validate Invalid Credentials Error Msg after providing Invalid Email Id & Password
	@Test(priority=1)
    public void verifyInvalidCredential() throws Exception 
    {
	    //Create Student Login Page object
    	objStudLognPg = new StudLoginPage();
	   	
	    String username = ExcelUtility.getCellData(0, 0,0);
	    String password = ExcelUtility.getCellData(0, 1,0);
	    objStudLognPg.clearInputTxt();
	    objStudLognPg.setUserName(username);
	    objStudLognPg.setPassword(password);
	    objStudLognPg.roleDropdwnSelectText();
	    Thread.sleep(3000);		
	    objStudLognPg.signInClick();
	    Thread.sleep(3000);
	    
	    Alert al = driver.switchTo().alert();
	    String alertMessage= driver.switchTo().alert().getText();
	    String expectedAlertmsg = AutomationConstants.INVALIDCREDENTIAL;	  
	    Assert.assertEquals(alertMessage,expectedAlertmsg);
	    Thread.sleep(3000);		    
	    
	    al.accept();   
	    objStudHomePg = new StudHomePage();
	    Thread.sleep(3000);	
    }
	
	// Validate Invalid Password Error Msg after providing Valid Email Id with Invalid Password
	@Test(priority=2)
    public void verifyInvalidPassword() throws Exception 
    {
	    //Create Student Login Page object
    	objStudLognPg = new StudLoginPage();
	   	
	    String username = ExcelUtility.getCellData(1, 0,0);
	    String password = ExcelUtility.getCellData(1, 1,0);
	    objStudLognPg.clearInputTxt();
	    objStudLognPg.setUserName(username);
	    objStudLognPg.setPassword(password);
	    objStudLognPg.roleDropdwnSelectText();
	    Thread.sleep(3000);		
	    objStudLognPg.signInClick();
	    Thread.sleep(3000);
	    
	    Alert al = driver.switchTo().alert();
	    String alertMessage= driver.switchTo().alert().getText();
	    String expectedAlertmsg = AutomationConstants.INVALIDPASSWORD;	  
	    Assert.assertEquals(alertMessage,expectedAlertmsg);
	    Thread.sleep(3000);		    
	    
	    al.accept();   
	    objStudHomePg = new StudHomePage();
	    Thread.sleep(3000);	
    }
	
	// Validate Invalid Credentials Error Msg after providing Invalid Email Id with valid Passward
	@Test(priority=3)
    public void verifyInvalidUsername() throws Exception 
    {
	    //Create Student Login Page object
    	objStudLognPg = new StudLoginPage();
	   	
	    String username = ExcelUtility.getCellData(2, 0,0);
	    String password = ExcelUtility.getCellData(2, 1,0);
	    objStudLognPg.clearInputTxt();
	    objStudLognPg.setUserName(username);
	    objStudLognPg.setPassword(password);
	    objStudLognPg.roleDropdwnSelectText();
	    Thread.sleep(3000);		
	    objStudLognPg.signInClick();
	    Thread.sleep(3000);
	    
	    Alert al = driver.switchTo().alert();
	    String alertMessage= driver.switchTo().alert().getText();
	    String expectedAlertmsg = AutomationConstants.INVALIDCREDENTIAL;	  
	    Assert.assertEquals(alertMessage,expectedAlertmsg);
	    Thread.sleep(3000);		    
	    
	    al.accept();   
	    objStudHomePg = new StudHomePage();
	    Thread.sleep(3000);	
    }
	
	// Login Page verification using valid Credentials
    @Test(priority=4)
    public void verifyValidLogin() throws Exception 
    {
	    //Create Student Login Page object
    	objStudLognPg = new StudLoginPage();

    	String username = ExcelUtility.getCellData(3, 0,0);    	
	    String password = ExcelUtility.getCellData(3, 1,0);	   
	    objStudLognPg.clearInputTxt();
	    
	    objStudLognPg.setUserName(username);
	    objStudLognPg.setPassword(password);
	    objStudLognPg.roleDropdwnSelectText();
	    Thread.sleep(3000);		
	    objStudLognPg.signInClick();
	    Thread.sleep(3000);
	    Alert al = driver.switchTo().alert();
	    al.accept();   
	    objStudHomePg = new StudHomePage();
	    Thread.sleep(3000);	
    }
}
