package com.studenrol.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.studenrol.testbase.TestBase;

public class StudNewRegistrPage extends TestBase  {

	@FindBy(xpath="//a[@routerlink='/login/studentlogin']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@routerlink='/enroll']")
	WebElement regNewStudBtn;
	
	@FindBy(xpath="//*[@id='home']//h1[(text()=' JOIN US')]")
	WebElement regNewStudTitlTxt;
	
	@FindBy(name="name")
	WebElement regNewStudName;
	
	@FindBy(xpath="//*[@name='name']")
	WebElement inputName;
	
	@FindBy(xpath="//*[@name='email']")
	WebElement inputEmail;
	
	@FindBy(xpath="//*[@name='password']")
	WebElement inputPassword;
	
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
	
	@FindBy(xpath="//*[@name='course']")
	WebElement inputcourse;
	
	@FindBy(xpath="//*[@name='coursefee']")
	WebElement courseFee;
	
	@FindBy(xpath="//*[@name='image']")
	WebElement image;
	
    @FindBy(xpath="*//div/div[19]/button")
	WebElement registerbutton;
	
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	public StudNewRegistrPage()
	{		
		PageFactory.initElements(driver, this);
	}
	
	public StudNewRegistrPage clickRegNewStdBtn()
	{
		jse.executeScript("arguments[0].click()", regNewStudBtn);		
		return new StudNewRegistrPage();
	}
	
	public String regNewStudPageTitlTxtVerify()
	{
		return regNewStudTitlTxt.getText();
	}
	public void setInputNameField(String name)
	{		
		inputName.clear();
		inputName.sendKeys(name);			
	}
	
	public void setInputEmailField(String email)
	{		
		inputEmail.clear();
		inputEmail.sendKeys(email);		
	}
	
	public void setInputPhoneField(String phone)
	{		
		inputPhone.clear();
		inputPhone.sendKeys(phone);		
	}
	public void setInputPasswordField(String password)
	{		
		inputPassword.clear();
		inputPassword.sendKeys(password);	
	}
	
	public void setInputAddressField(String address)
	{		
		inputAddress.clear();
		inputAddress.sendKeys(address);		
	}
	
	public void setInputDistrictField(String district)
	{		
		inputDistrict.clear();
		inputDistrict.sendKeys(district);		
	}
	
	public void setInputStateField(String state)
	{		
		inputState.clear();
		inputState.sendKeys(state);		
	}
		
	public void setInputQualiDropdwnSelectedText(String quali)
	{
		Select roldropdown  = new Select(inputQuali);
		roldropdown.selectByVisibleText(quali);
	}
	
	public void setInputQualiDropdwnSelectedIndx(int quali)
	{
		Select roldropdown  = new Select(inputQuali);
		roldropdown.selectByIndex(quali);
	}	
	
	public void setInputPassoutField(String passoutyr)
	{		
		inputPassout.clear();
		inputPassout.sendKeys(passoutyr);		
	}
	
	public void setInputSkillsField(String skills)
	{		
		inputSkills.clear();
		inputSkills.sendKeys(skills);		
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
	
	public void setcourseDropdwnSelectedText(String course)
	{
		Select roldropdown  = new Select(inputcourse);
		roldropdown.selectByVisibleText(course);
	}
	
	public void setCourseDropdwnSelectedIndx(int inpCour)
	{
		Select roldropdown  = new Select(inputcourse);
		roldropdown.selectByIndex(inpCour);
	}
	
	public void clickregisterbutton()
	{
		registerbutton.click();
	}
	
	public void setInputImageField(String img)
	{		
		image.clear();
		image.sendKeys(img);		
	}
			
	
}	
	


