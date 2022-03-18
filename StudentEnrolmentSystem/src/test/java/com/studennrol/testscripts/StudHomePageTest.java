package com.studennrol.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.studenrol.constants.AutomationConstants;
import com.studenrol.pages.HomePage;
import com.studenrol.pages.StudHomePage;
import com.studenrol.pages.StudLoginPage;
import com.studenrol.testbase.TestBase;
import com.studenrol.utilities.ExcelUtility;

public class StudHomePageTest  extends TestBase {

	StudLoginPage objStudLognPg;
	StudHomePage objStudHomePg;
	HomePage objHomePg;

	// Verify Home Page After Successful Log in
    @Test(priority=0)
    public void verifyHomePageAftrLogin() throws Exception 
    {	    
	    objStudHomePg = new StudHomePage();	   
	    String actualStudHomePageheading = objStudHomePg.stuHomePageTextVerify();	   
	    String username = ExcelUtility.getCellData(1, 0,2);	 
	    Thread.sleep(3000);	
	    String expectedStudHomePageheading = AutomationConstants.STUDENTHOMEPAGEHEADING + ' ' + username.trim();	  
	    Thread.sleep(3000);	
	    Assert.assertEquals(actualStudHomePageheading,expectedStudHomePageheading);	 	  	
    }
		
    // Verify Courses Page after successful log in
    @Test(priority=1)
    public void verifyCoursePageAftrLogin() throws Exception 
    {	    
	    objStudHomePg = new StudHomePage();
	    objStudHomePg.clickCourseLink();
	    Thread.sleep(3000);
	    String actualCourseheading = objStudHomePg.coursePageTextVerify();
	    String expectedCourseheading = AutomationConstants.COURSEPAGEHEADING;	
	    Thread.sleep(3000);
	    Assert.assertEquals(actualCourseheading,expectedCourseheading);	  		   
    }
    
    // Verify selected Course Page
    @Test(priority=2)
    public void verifyCourseName() throws Exception 
    {	
    	String actualCourseheading = objStudHomePg.CourseNameTextVerify();
    	Thread.sleep(3000);	
	    String expectedCourseheading = AutomationConstants.COURSENAME;	  
	    Assert.assertEquals(actualCourseheading,expectedCourseheading); 	    
    }
    
   // Verify Know More Button from the selected Course Page
    @Test(priority=3)
    public void KnowMorebtn() throws Exception 
    {	    
    	objStudHomePg = new StudHomePage();
    	objStudHomePg.clickknowmorebutton();	
    	Thread.sleep(3000);	
    	String homePageUrlActual=driver.getCurrentUrl();
		String homePageUrlExp=prop.getProperty("coursePgUrl");		
		Assert.assertEquals(homePageUrlExp, homePageUrlActual);	   	
    }
    
    // Able to click enroll button for the selected course
    @Test(priority=4)
    public void CourseEnrollnowbtn() throws Exception 
    {	    
    	objStudHomePg = new StudHomePage();
    	objStudHomePg.clickenrollnowbutton();	
    	Thread.sleep(3000);	
    	String homePageUrlActual=driver.getCurrentUrl();
		String homePageUrlExp=prop.getProperty("enrollUrl");		
		Assert.assertEquals(homePageUrlExp, homePageUrlActual);	   	
    }
    
    // Able to navigate to Logged in Home Page
    @Test(priority=5)
    public void returnToHomePage() throws Exception 
    {	    
	    objStudHomePg = new StudHomePage();
	    objStudHomePg.clickHomeLink();
	    Thread.sleep(3000);	
	    String homePageUrlActual=driver.getCurrentUrl();
		String homePageUrlExp=prop.getProperty("url");		
		Assert.assertEquals(homePageUrlExp, homePageUrlActual);   
    }
    
    // Verify Show More Button click navigate to Courses Page
    @Test(priority=6)
    public void showMoreCoursebtnFrmHomePge() throws Exception 
    {	    
    	objStudHomePg = new StudHomePage();
    	objStudHomePg.clickShowmorebutton();	
    	Thread.sleep(3000);	
    	String homePageUrlActual=driver.getCurrentUrl();
		String homePageUrlExp=prop.getProperty("coursesPgUrl");		
		Assert.assertEquals(homePageUrlExp, homePageUrlActual);	   	
    }
    
    // Validate the Student Details Heading after selecting the View Profile
    @Test(priority=7)
    public void verifyStudentDetailsPageAftrLogin() throws Exception 
    {	    
	    objStudHomePg = new StudHomePage();
	    objStudHomePg.clickHomeLink();
	    Thread.sleep(3000);	
	    objStudHomePg.clickViewProfile();
	    Thread.sleep(3000);	
	    String actualStudDetailsheading = objStudHomePg.studDetailTextVerify();
	    String expectedStudDetailsheading = AutomationConstants.STUDENTDETAILSPAGEHEADING;	  
	    Assert.assertEquals(actualStudDetailsheading,expectedStudDetailsheading);   
    }
   

}
