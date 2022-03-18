package com.studennrol.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.studenrol.pages.StudDetailsPage;
import com.studenrol.pages.StudHomePage;
import com.studenrol.pages.StudLoginPage;
import com.studenrol.testbase.TestBase;
import com.studenrol.utilities.ExcelUtility;

public class StudDetailsPageTest  extends TestBase {

	StudLoginPage objStudLognPg;
	StudHomePage objStudHomePg;	
	StudDetailsPage objStdDetPg;
		
	// Validate Student Home Page url after successful Log in
    @Test(priority=1)
    public void verifyStudDetailsPageAftrLogin() throws Exception 
    {
    	objStudHomePg = new StudHomePage();
    	String studDetailsPageUrlActual = driver.getCurrentUrl();
    	String studDetailsPageUrlExp = prop.getProperty("studDetailsUrl");
    	Assert.assertEquals(studDetailsPageUrlActual, studDetailsPageUrlExp);	
	    Thread.sleep(3000);
    }
        
    // Able to navigate to Update Student Page
    @Test(priority=2)
    public void UpdateBtnClick() throws Exception 
    {	    
    	objStdDetPg = new StudDetailsPage();
    	objStdDetPg.clickUpdateLink();
    	Thread.sleep(3000);	
    	String studUpdatePageUrlActual = driver.getCurrentUrl();
    	String studUpdatePageUrlExp = prop.getProperty("studDetailUpdateUrl");
    	Assert.assertEquals(studUpdatePageUrlActual, studUpdatePageUrlExp);
    	Thread.sleep(3000);	
    }
           
    // Validate Student details which provided while registering
    @Test(priority=3)
    public void validateExistingDataFrmUpdateStdPge() throws Exception 
    {	    
    	objStdDetPg = new StudDetailsPage();
    	
    	String compareName = ExcelUtility.getCellData(1, 0,2);    	
    	String existngName = objStdDetPg.getInputNameField();  
    	Thread.sleep(3000);	
    	Assert.assertEquals(compareName, existngName);    	
    	
    	String compareEmail = ExcelUtility.getCellData(1, 1,2);    	
    	String existngemail = objStdDetPg.getInputEmailField();   
    	Thread.sleep(3000);	
    	Assert.assertEquals(compareEmail, existngemail);    	
    	
    	Integer comparePhone = ExcelUtility.getIntCellData(1, 2,2);   	
    	String comparePhoneStr = String.valueOf(comparePhone);    	
    	String existngPhone =  objStdDetPg.getInputPhoneField();  
    	Thread.sleep(3000);	
    	Assert.assertEquals(comparePhoneStr, existngPhone);
    	    	
    	String compareAddress = ExcelUtility.getCellData(1, 3,2);    	
    	String existngAddress = objStdDetPg.getInputAddressField();
    	Thread.sleep(3000);	
    	Assert.assertEquals(compareAddress, existngAddress);
    	    	
    	String compareDistrict = ExcelUtility.getCellData(1, 4,2);    	
    	String existngDistrict = objStdDetPg.getInputDistrictField(); 
    	Thread.sleep(3000);	
    	Assert.assertEquals(compareDistrict, existngDistrict);
    	    	
    	String compareState = ExcelUtility.getCellData(1, 5,2);    	
    	String existngState = objStdDetPg.getInputStateField();  
    	Thread.sleep(3000);	
    	Assert.assertEquals(compareState, existngState);
    	    	
    	String compareQuali = ExcelUtility.getCellData(1, 6,2);    	
    	String existngQuali = objStdDetPg.getInputinputQualiField();  
    	Thread.sleep(3000);	
    	Assert.assertEquals(compareQuali, existngQuali);
    	    	
    	Integer comparePassout = ExcelUtility.getIntCellData(1, 7,2);   
    	String comparePassoutStr = String.valueOf(comparePassout);    	
    	String existngPassout = objStdDetPg.getInputPassoutField(); 
    	Thread.sleep(3000);	
    	Assert.assertEquals(comparePassoutStr, existngPassout);
    	    	
    	String compareSkills = ExcelUtility.getCellData(1, 8,2);     	 
    	String existngSkills = objStdDetPg.getInputSkillsField();
    	Thread.sleep(3000);	
    	Assert.assertEquals(compareSkills, existngSkills);
    	    	
    	String compareEmpStat = ExcelUtility.getCellData(1, 9,2);    	
    	String existngEmpStat = objStdDetPg.getEmpStatusDropdwnSelectedText(); 
    	Thread.sleep(3000);	
    	Assert.assertEquals(compareEmpStat, existngEmpStat);
    	    	
    	String compareTechTraing = ExcelUtility.getCellData(1, 10,2);    	
    	String existngTechTraing = objStdDetPg.getInputTechtrainingField(); 
    	Thread.sleep(3000);	
    	Assert.assertEquals(compareTechTraing, existngTechTraing);	  
    	Thread.sleep(3000);	
    }       
    
    // Update non-mandatory(Status) Student details 
    @Test(priority=4)
    public void updateNonMandatoryStudDetails() throws Exception 
    {	    
    	objStdDetPg = new StudDetailsPage();  
    	objStdDetPg.clearNonMandatoryInputTxt();
    	Thread.sleep(3000);	
    	objStdDetPg.clickUpdateBtn();    	
    	Thread.sleep(3000);	
    	
	    String homePageUrlActual=driver.getCurrentUrl();
		String homePageUrlExp=prop.getProperty("url");		
		Assert.assertEquals(homePageUrlExp, homePageUrlActual);	    
	    Thread.sleep(3000);		    
    }   
             
   // Validate non-mandatory(Status) Student details after update
    @Test(priority=5)
    public void validateNonMandtryStudDetAftrUpdate() throws Exception 
    {	    
    	objStdDetPg = new StudDetailsPage();   
    	objStudHomePg.clickViewProfile();   
    	Thread.sleep(3000);	 
    	objStdDetPg.clickUpdateLink();   
    	Thread.sleep(3000);	
    	
    	/*String emailActual = objStdDetPg.getInputEmailField();   
    	String emailExp= "";
    	Assert.assertEquals(emailActual, emailExp);
    	Thread.sleep(3000);	
    	
    	String phoneActual = objStdDetPg.getInputPhoneField();   
    	String phoneExp= "";
    	Assert.assertEquals(phoneActual, phoneExp);
    	Thread.sleep(3000);	*/
    	 
    	String empStatActual = objStdDetPg.getEmpStatusDropdwnSelectedText();
    	String empStatExp = "Select";
    	Assert.assertEquals(empStatActual, empStatExp);	    
	    Thread.sleep(3000);	
    } 
      
    // Update all mandatory Student details 
    @Test(priority=6)
    public void UpdateStudData() throws Exception 
    {	    
    	objStdDetPg = new StudDetailsPage();      	
    	objStdDetPg.clearNonMandatoryInputTxt();    	
    	objStdDetPg.clearMandatoryInputTxt();  
    	Thread.sleep(3000);	
    	    	
    	String compareName = ExcelUtility.getCellData(2, 0,2);    	
    	objStdDetPg.setInputNameField(compareName);    	
    	Thread.sleep(3000);    	
    
    	String compareEmail = ExcelUtility.getCellData(2, 1,2);    	
    	objStdDetPg.setInputEmailField(compareEmail);    	
    	Thread.sleep(3000);	
    	
    	Integer comparePhone = ExcelUtility.getIntCellData(2, 2,2);   	
    	String comparePhoneStr = String.valueOf(comparePhone);    	
    	objStdDetPg.setInputPhoneField(comparePhoneStr);    	
    	Thread.sleep(3000);	
    	
    	String compareAddress = ExcelUtility.getCellData(2, 3,2);    	
    	objStdDetPg.setInputAddressField(compareAddress);
    	Thread.sleep(3000);	
    	
    	String compareDistrict = ExcelUtility.getCellData(2, 4,2);    	
    	objStdDetPg.setInputDistrictField(compareDistrict);
    	Thread.sleep(3000);	
    	
    	String compareState = ExcelUtility.getCellData(2, 5,2);   
    	objStdDetPg.setInputStateField(compareState);
    	Thread.sleep(3000);	
    	
    	String compareQuali = ExcelUtility.getCellData(2, 6,2);    	
    	objStdDetPg.setInputinputQualiField(compareQuali);
    	Thread.sleep(3000);	
    	
    	Integer comparePassout = ExcelUtility.getIntCellData(2, 7,2);   
    	String comparePassoutStr = String.valueOf(comparePassout);    	
    	objStdDetPg.setInputPassoutField(comparePassoutStr);
    	Thread.sleep(3000);	
    	
    	String compareSkills = ExcelUtility.getCellData(2, 8,2);     	 
    	objStdDetPg.setInputSkillsField(compareSkills); 
    	Thread.sleep(3000);	
    	
    	String compareEmpStat = ExcelUtility.getCellData(2, 9,2);    	
    	objStdDetPg.setEmpStatusDropdwnSelectedText(compareEmpStat);        	
    	Thread.sleep(3000);	
    	
    	String compareTechTraing = ExcelUtility.getCellData(2, 10,2);    	
    	objStdDetPg.setInputTechtrainingField(compareTechTraing);
    	
    	Thread.sleep(3000);	    	
    	objStdDetPg.clickUpdateBtn();
    	Thread.sleep(3000);
    	
	    String homePageUrlActual=driver.getCurrentUrl();	    
		String homePageUrlExp=prop.getProperty("url");			
		Assert.assertEquals(homePageUrlExp, homePageUrlActual);	    
	    Thread.sleep(3000);	
    } 
    
    // Validate all mandatory Student details which was updated
    @Test(priority=7)
    public void validateMandtryStudDetAftrUpdate() throws Exception 
    {	    
    	objStdDetPg = new StudDetailsPage();   
    	objStudHomePg.clickViewProfile();   
    	Thread.sleep(3000);	 
    	objStdDetPg.clickUpdateLink();   
    	Thread.sleep(3000);	
    	
    	String compareName = ExcelUtility.getCellData(2, 0,2);    	
    	String NameActual = objStdDetPg.getInputNameField();   
    	Assert.assertEquals(compareName, NameActual);	   
    	Thread.sleep(3000);	
    	
    	String compareEmail = ExcelUtility.getCellData(2, 1,2);    	
    	String EmailActual = objStdDetPg.getInputEmailField();   
    	Assert.assertEquals(compareEmail, EmailActual);	   
    	Thread.sleep(3000);	
    	
    	Integer comparePhone = ExcelUtility.getIntCellData(2, 2,2);   	
    	String comparePhoneStr = String.valueOf(comparePhone);   
    	String phoneActual = objStdDetPg.getInputPhoneField(); 
    	Assert.assertEquals(phoneActual, comparePhoneStr);	   	
    	Thread.sleep(3000);	
    	
    	String compareAddress = ExcelUtility.getCellData(2, 3,2);    	
    	String addressActual = objStdDetPg.getInputAddressField();   
    	Assert.assertEquals(compareAddress, addressActual);	   
    	Thread.sleep(3000);	
    	
    	String compareDistrict = ExcelUtility.getCellData(2, 4,2);    	
    	String districtActual = objStdDetPg.getInputDistrictField();   
    	Assert.assertEquals(compareDistrict, districtActual);	
    	Thread.sleep(3000);	
    	
    	String compareState = ExcelUtility.getCellData(2, 5,2);   
    	String stateActual = objStdDetPg.getInputStateField();   
    	Assert.assertEquals(compareState, stateActual);	
    	Thread.sleep(3000);	
    	
    	String compareQuali = ExcelUtility.getCellData(2, 6,2);    	
    	String qualiActual = objStdDetPg.getInputinputQualiField();   
    	Assert.assertEquals(compareQuali, qualiActual);	
    	Thread.sleep(3000);	
    	
    	Integer comparePassout = ExcelUtility.getIntCellData(2, 7,2);  
    	String comparePassoutStr = String.valueOf(comparePassout);    
    	String passoutActual = objStdDetPg.getInputPassoutField();   
    	Assert.assertEquals(comparePassoutStr, passoutActual);	
    	Thread.sleep(3000);	
    	
    	String compareSkills = ExcelUtility.getCellData(2, 8,2);     	 
    	String skillActual = objStdDetPg.getInputSkillsField();   
    	Assert.assertEquals(compareSkills, skillActual);	
    	Thread.sleep(3000);	
    	
    	String compareEmpStat = ExcelUtility.getCellData(2, 9,2);    	
    	String empStatActual = objStdDetPg.getEmpStatusDropdwnSelectedText();   
    	Assert.assertEquals(compareEmpStat, empStatActual);	   	
    	Thread.sleep(3000);	
    	
    	String compareTechTraing = ExcelUtility.getCellData(2, 10,2);    	
    	String techTrainingActual = objStdDetPg.getInputTechtrainingField();   
    	Assert.assertEquals(compareTechTraing, techTrainingActual);	
    	Thread.sleep(3000);	
    }
    	      	  
    // Updating back to same as initial data during registration
    @Test(priority=8)
    public void UpdateStudDataBackToNormal() throws Exception 
    {	    
    	objStdDetPg = new StudDetailsPage();       	
    	objStdDetPg.clearNonMandatoryInputTxt();    	
    	objStdDetPg.clearMandatoryInputTxt();  
    	Thread.sleep(3000);	   
    	
    	String compareName = ExcelUtility.getCellData(1, 0,2);    	
    	objStdDetPg.setInputNameField(compareName);       	   
    	Thread.sleep(3000);	
    	
    	String compareEmail = ExcelUtility.getCellData(1, 1,2);    	
    	objStdDetPg.setInputEmailField(compareEmail);     	
    	Thread.sleep(3000);	
    	
    	Integer comparePhone = ExcelUtility.getIntCellData(1, 2,2);   	
    	String comparePhoneStr = String.valueOf(comparePhone);    	
    	objStdDetPg.setInputPhoneField(comparePhoneStr);    	
    	Thread.sleep(3000);	
    	
    	String compareAddress = ExcelUtility.getCellData(1, 3,2);    	
    	objStdDetPg.setInputAddressField(compareAddress);
    	Thread.sleep(3000);	
    	
    	String compareDistrict = ExcelUtility.getCellData(1, 4,2);    	
    	objStdDetPg.setInputDistrictField(compareDistrict);
    	Thread.sleep(3000);	
    	
    	String compareState = ExcelUtility.getCellData(1, 5,2);   
    	objStdDetPg.setInputStateField(compareState);
    	Thread.sleep(3000);	
    	
    	String compareQuali = ExcelUtility.getCellData(1, 6,2);    	
    	objStdDetPg.setInputinputQualiField(compareQuali);
    	Thread.sleep(3000);	
    	
    	Integer comparePassout = ExcelUtility.getIntCellData(1, 7,2);   
    	String comparePassoutStr = String.valueOf(comparePassout);    	
    	objStdDetPg.setInputPassoutField(comparePassoutStr);
    	Thread.sleep(3000);	
    	
    	String compareSkills = ExcelUtility.getCellData(1, 8,2);     	 
    	objStdDetPg.setInputSkillsField(compareSkills); 
    	Thread.sleep(3000);	
    	
    	String compareEmpStat = ExcelUtility.getCellData(1, 9,2);    	
    	objStdDetPg.setEmpStatusDropdwnSelectedText(compareEmpStat);        	
    	Thread.sleep(3000);	
    	
    	String compareTechTraing = ExcelUtility.getCellData(1, 10,2);    	
    	objStdDetPg.setInputTechtrainingField(compareTechTraing);
    	
    	Thread.sleep(3000);	    	
    	objStdDetPg.clickUpdateBtn();
    	Thread.sleep(3000);
    	
	    String homePageUrlActual=driver.getCurrentUrl();	    
		String homePageUrlExp=prop.getProperty("url");			
		Assert.assertEquals(homePageUrlExp, homePageUrlActual);	    
	    Thread.sleep(3000);	
    } 
    
    // Logged-out from Student Home Page
    @Test(priority=9)
    public void LogedOut() throws Exception 
    {	  
	    objStudHomePg.clickLogoutLink();

	    String loginUrlActual=driver.getCurrentUrl();
		Thread.sleep(3000);		
		String loginUrlExp=prop.getProperty("loginPgUrl");
		Assert.assertEquals(loginUrlExp, loginUrlActual);
	
	    Thread.sleep(3000);	
    }     
    
}
