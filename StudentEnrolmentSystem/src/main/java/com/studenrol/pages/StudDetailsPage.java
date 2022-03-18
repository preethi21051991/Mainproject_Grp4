package com.studenrol.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.studenrol.testbase.TestBase;

public class StudDetailsPage extends TestBase {

	@FindBy(xpath="//div[@class='btn update']/a/span[text()='Update']")
	WebElement update;
	
	@FindBy(xpath="//*[@name='name']")
	WebElement inputName;
	
	@FindBy(xpath="//*[@name='email']")
	WebElement inputEmail;
	
	@FindBy(xpath="//*[@name='phone']")
	WebElement inputPhone;
	
	@FindBy(xpath="//*[@name='address']")
	WebElement inputAddress;
	
	@FindBy(xpath="//*[@name='district']")
	WebElement inputDistrict;
		
	@FindBy(xpath="//*[@name='state']")
	WebElement inputState;
	
	@FindBy(xpath="//*[@name='qualification']")
	WebElement inputQuali;
	
	@FindBy(xpath="//*[@name='passout']")
	WebElement inputPassout;
	
	@FindBy(xpath="//*[@name='skills']")
	WebElement inputSkills;
	
	@FindBy(xpath="//select[@name='employmentStatus']")
	WebElement inputEmpStatus;
	
	@FindBy(xpath="//*[@name='techtraining']")
	WebElement inputTechtraining;
	
	@FindBy(xpath="//div//div/div[12]/button")
	WebElement updateBtn;
		
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	public StudDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage clickUpdateLink()
	{		
		jse.executeScript("arguments[0].click()", update);	
		return new HomePage();
	}
	
	public void setInputNameField(String name)
	{				
		inputName.clear();
		inputName.sendKeys(name);
	}
	
	public String getInputNameField()
	{
	   return inputName.getAttribute("value");	
	}
	
	public void setInputEmailField(String email)
	{
		inputEmail.clear();
		inputEmail.sendKeys(email);		
	}
	
	public String getInputEmailField()
	{
	   return inputEmail.getAttribute("value");	
	}
	
	public void setInputPhoneField(String phone)
	{
		inputPhone.clear();
		inputPhone.sendKeys(phone);		
	}
	
	public String getInputPhoneField()
	{		
	   return inputPhone.getAttribute("value");	
	}
	
	public void setInputAddressField(String address)
	{
		inputAddress.clear();
		inputAddress.sendKeys(address);		
	}
	
	public String getInputAddressField()
	{
	   return inputAddress.getAttribute("value");	
	}
	
	public void setInputDistrictField(String district)
	{
		inputDistrict.clear();
		inputDistrict.sendKeys(district);		
	}
	
	public String getInputDistrictField()
	{
	   return inputDistrict.getAttribute("value");	
	}
	
	public void setInputStateField(String state)
	{
		inputState.clear();
		inputState.sendKeys(state);		
	}
	
	public String getInputStateField()
	{
	   return inputState.getAttribute("value");	
	}
	
	public void setInputinputQualiField(String qualiftn)
	{
		inputQuali.clear();
		inputQuali.sendKeys(qualiftn);		
	}
	
	public String getInputinputQualiField()
	{
	   return inputQuali.getAttribute("value");	
	}
	
	public void setInputPassoutField(String passoutyr)
	{
		inputPassout.clear();
		inputPassout.sendKeys(passoutyr);		
	}
	
	public String getInputPassoutField()
	{
	   return inputPassout.getAttribute("value");	
	}
	
	public void setInputSkillsField(String skills)
	{
		inputSkills.clear();
		inputSkills.sendKeys(skills);		
	}
	
	public String getInputSkillsField()
	{
	   return inputSkills.getAttribute("value");	
	}
	
	public String getEmpStatusDropdwnSelectedText()
	{		
		Select dropdownSelectObject = new Select(inputEmpStatus);
		WebElement selectedItem = dropdownSelectObject.getFirstSelectedOption();
		String selectedValue = selectedItem.getText();
		return selectedValue;
	}
	
	public void setEmpStatusDropdwnSelectedText(String empStat)
	{
		Select roldropdown  = new Select(inputEmpStatus);
		roldropdown.selectByVisibleText(empStat);
	}
	
	public void setEmpStatusDropdwnSelectedIndx(int empStat)
	{
		Select roldropdown  = new Select(inputEmpStatus);
		roldropdown.selectByIndex(empStat);
	}
		
	public void setInputTechtrainingField(String techTraining)
	{
		inputTechtraining.clear();
		inputTechtraining.sendKeys(techTraining);		
	}
	
	public String getInputTechtrainingField()
	{
	   return inputTechtraining.getAttribute("value");	
	}
	
	public void clearNonMandatoryInputTxt()
	{
		//inputEmail.clear();	
		//inputPhone.clear();
		setEmpStatusDropdwnSelectedIndx(0);
	}
	
	public void clearMandatoryInputTxt()
	{		
		inputName.clear();
		inputEmail.clear();	
		inputPhone.clear();
		inputAddress.clear();	
		inputDistrict.clear();	
		inputState.clear();	
		inputQuali.clear();	
		inputPassout.clear();	
		inputSkills.clear();	
		inputTechtraining.clear();		
	}
		
	public HomePage clickUpdateBtn()
	{			
		jse.executeScript("arguments[0].click()", updateBtn);
		
		return new HomePage();
	}
}
