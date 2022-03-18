package com.studennrol.testscripts;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.studenrol.constants.AutomationConstants;
import com.studenrol.pages.HomePage;
import com.studenrol.pages.StudNewRegistrPage;
import com.studenrol.testbase.TestBase;
import com.studenrol.utilities.ExcelUtility;

public class StudNewRegistrPageTest extends TestBase {

	HomePage objHomePg;
	StudNewRegistrPage  objStudNewRegistrPg;
	
	// Able to navigate to Student Registration Page
	@Test(priority=0)
	public void verifyStudNewRegitrPage() throws Exception
	{
		objHomePg = new HomePage();
		objHomePg.clickLoginBtn();
		//Create Student Registration Page object
		objStudNewRegistrPg = new StudNewRegistrPage();
		objStudNewRegistrPg.clickRegNewStdBtn();
		String enrollUrlActual=driver.getCurrentUrl();
		Thread.sleep(3000);		
		String enrollUrlExp=prop.getProperty("enrollUrl");		
		Assert.assertEquals(enrollUrlExp, enrollUrlActual);
	}	
	
	// Student Registration Page Heading
	@Test(priority=1)
	public void regNewStudPageTitlTxtVerify() throws Exception
	{
		//Create Student Registration Page object
		objStudNewRegistrPg = new StudNewRegistrPage();			
		String actualTitle = objStudNewRegistrPg.regNewStudPageTitlTxtVerify();
	    String expectedTitle = AutomationConstants.NEWSTUDREGISTRPAGETITLE;	    
		Thread.sleep(3000);	    
	    Assert.assertEquals(expectedTitle,actualTitle);
	} 
	
	// Navigate to Login Page
	@Test(priority=2)
	public void verifyLoginPage() throws Exception
	{
		objHomePg = new HomePage();
		objHomePg.clickLoginBtn();
		String loginUrlActual=driver.getCurrentUrl();
		Thread.sleep(3000);		
		String loginUrlExp=prop.getProperty("loginPgUrl");		
		Assert.assertEquals(loginUrlExp, loginUrlActual);
	}
	
	// Entering invalid data in the Student Registration Page
	@Test(priority=3)
	public void regNewStudPageDetailsWithInvaldData() throws Exception
	{
		//Create Student Registration Page object
		objStudNewRegistrPg = new StudNewRegistrPage();		
		objStudNewRegistrPg.clickRegNewStdBtn();
		Thread.sleep(3000);	  
		
		String name =ExcelUtility.getCellData(1, 0,1);  
		objStudNewRegistrPg.setInputNameField(name);
		Thread.sleep(3000);	  
		
		String email =ExcelUtility.getCellData(1, 1,1);   
		objStudNewRegistrPg.setInputEmailField(email);
		Thread.sleep(3000);	  
		
		String Password = ExcelUtility.getCellData(1, 2,1); 
		objStudNewRegistrPg.setInputPasswordField(Password);
		Thread.sleep(3000);
		Integer comparePhone = ExcelUtility.getIntCellData(1, 3,1);   	
    	String comparePhoneStr = String.valueOf(comparePhone);    	
    	objStudNewRegistrPg.setInputPhoneField(comparePhoneStr);    	
    	Thread.sleep(3000);			  
		
		String Address =ExcelUtility.getCellData(1, 4,1);   
		objStudNewRegistrPg.setInputAddressField(Address);
		Thread.sleep(3000);	  
		
		String District =ExcelUtility.getCellData(1,5,1); 
		objStudNewRegistrPg.setInputDistrictField(District);
		Thread.sleep(3000);	  
		
		String State = ExcelUtility.getCellData(1, 6,1); 
		objStudNewRegistrPg.setInputStateField(State);
		Thread.sleep(3000);
		
		//String Quali = ExcelUtility.getCellData(1, 7,1); 
		//objStudNewRegistrPg.setInputQualiDropdwnSelectedText(Quali);		
		objStudNewRegistrPg.setInputQualiDropdwnSelectedIndx(1);
		Thread.sleep(3000);	
	
		String comparePassoutStr = ExcelUtility.getCellData(1, 8,1);
		objStudNewRegistrPg.setInputPassoutField(comparePassoutStr);
    	Thread.sleep(3000);	
    	
    	String Skills = ExcelUtility.getCellData(1, 9,1);     	 
		objStudNewRegistrPg.setInputSkillsField(Skills);
		
		String EmpStat = ExcelUtility.getCellData(1, 10,1);    	
		objStudNewRegistrPg.setEmpStatusDropdwnSelectedText(EmpStat);        	
    	Thread.sleep(3000);	
		
    	String Techtraining = ExcelUtility.getCellData(1, 11,1); 
		objStudNewRegistrPg.setInputTechtrainingField(Techtraining);
		Thread.sleep(3000);	
		
		String Course = ExcelUtility.getCellData(1, 12,1);    	
		objStudNewRegistrPg.setcourseDropdwnSelectedText(Course);        	
    	Thread.sleep(3000);	
    	
    	String Imgpath= System.getProperty("user.dir") + "/src/main/resources/Screenshot.png";
    	objStudNewRegistrPg.setInputImageField(Imgpath);
    	Thread.sleep(3000);	
    	
    	objStudNewRegistrPg.clickregisterbutton();
    	Thread.sleep(3000);	     	
	}
	
	// Entering valid data in the Student Registration Page
	@Test(priority=4)
	public void regNewStudPageDetailsWithValidData() throws Exception
	{
		//Create Student Registration Page object
		objStudNewRegistrPg = new StudNewRegistrPage();		
		//objStudNewRegistrPg.clickRegNewStdBtn();
		//Thread.sleep(3000);	  		

		String name =ExcelUtility.getCellData(2, 0,1);  
		objStudNewRegistrPg.setInputNameField(name);
		Thread.sleep(3000);	  
		
		String email =ExcelUtility.getCellData(2, 1,1);   
		objStudNewRegistrPg.setInputEmailField(email);
		Thread.sleep(3000);	  
		
		String Password = ExcelUtility.getCellData(2, 2,1); 
		objStudNewRegistrPg.setInputPasswordField(Password);
		Thread.sleep(3000);
		Integer comparePhone = ExcelUtility.getIntCellData(2, 3,1);   	
    	String comparePhoneStr = String.valueOf(comparePhone);    	
    	objStudNewRegistrPg.setInputPhoneField(comparePhoneStr);    	
    	Thread.sleep(3000);			  
		
		String Address =ExcelUtility.getCellData(2, 4,1);   
		objStudNewRegistrPg.setInputAddressField(Address);
		Thread.sleep(3000);	  
		
		String District =ExcelUtility.getCellData(2,5,1); 
		objStudNewRegistrPg.setInputDistrictField(District);
		Thread.sleep(3000);	  
				
		String State = ExcelUtility.getCellData(2, 6,1); 
		Thread.sleep(3000);
		objStudNewRegistrPg.setInputStateField(State);
		Thread.sleep(3000);
		
		//String Quali = ExcelUtility.getCellData(2, 7,1); 
		//objStudNewRegistrPg.setInputQualiDropdwnSelectedText(Quali);		
		objStudNewRegistrPg.setInputQualiDropdwnSelectedIndx(2);
		Thread.sleep(3000);	
	
		Integer comparePassout = ExcelUtility.getIntCellData(2, 8,1);   
    	String comparePassoutStr = String.valueOf(comparePassout);    	
		objStudNewRegistrPg.setInputPassoutField(comparePassoutStr);
    	Thread.sleep(3000);	
    	
    	String Skills = ExcelUtility.getCellData(2, 9,1);     	 
		objStudNewRegistrPg.setInputSkillsField(Skills);
		
		String EmpStat = ExcelUtility.getCellData(2, 10,1);    	
		objStudNewRegistrPg.setEmpStatusDropdwnSelectedText(EmpStat);        	
    	Thread.sleep(3000);	
		
    	String Techtraining = ExcelUtility.getCellData(2, 11,1); 
		objStudNewRegistrPg.setInputTechtrainingField(Techtraining);
		Thread.sleep(3000);	
		
		String Course = ExcelUtility.getCellData(2, 12,1);    	
		objStudNewRegistrPg.setcourseDropdwnSelectedText(Course);        	
    	Thread.sleep(3000);	
    	
    	String Imgpath= System.getProperty("user.dir") + "/src/main/resources/Screenshot.png";
    	objStudNewRegistrPg.setInputImageField(Imgpath);
    	Thread.sleep(3000);	
    	
    	objStudNewRegistrPg.clickregisterbutton();
    	Thread.sleep(3000);	     	
	}
		
    	
}

		
		
		
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

