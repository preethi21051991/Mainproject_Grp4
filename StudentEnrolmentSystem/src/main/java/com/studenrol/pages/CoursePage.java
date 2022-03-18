package com.studenrol.pages;

import org.openqa.selenium.support.PageFactory;

import com.studenrol.testbase.TestBase;

public class CoursePage extends TestBase {
	
	
	     public CoursePage()
	{
		
		PageFactory.initElements(driver, this);
	}

}
