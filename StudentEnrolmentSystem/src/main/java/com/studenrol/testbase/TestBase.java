package com.studenrol.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase 
{

	//PARENT CLASS which contains INITIALIZE PROPERTIES, SETUP BROWSER, GET URL(), MAXIMIZE WINDOW, IMPLICITWAIT(), DELETE COOKIES...

	public static WebDriver driver;
	public static Properties prop;
	public static String driverPath =System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";

	//Creating a Constructor of the Class TestBase -public
	//1) This is the Function for READING Properties File
	public void TestBase()
	{

		//2) Creating OBJECT for PROPERTIES CLASS.
		prop = new Properties();

		//3) Create an OBJECT for INPUTSTREAM CLASS + Location of config.properties File
		//		Surround it with [TRY CATCH]
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");


			//4) LOAD PROPERTIES FILE using load() and PROPERTIES OBJECT
			prop.load(ip);
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}


	@BeforeTest
	public  void browserSetup() 
	{
		TestBase();
		//get browser value from config.properties file using prop obj &getProperty()
		String browserName= prop.getProperty("browser");

		if (browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver=new ChromeDriver();

		}

		else if (browserName.equals("firefox")) 
		{
			//gecko driver
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
		}


		//Driver Maximize, Implicite Time, delete cookies...
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		//Launch URL
		driver.get(prop.getProperty("url"));

	}

	@AfterTest
	public void quitBrowser() throws IOException 
	{
		driver.quit();
	}
}
