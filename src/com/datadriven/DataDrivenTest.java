package com.datadriven;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uttility.test.Testutil;

public class DataDrivenTest {
	
	WebDriver driver;
	
	@BeforeMethod
	
	public void setUp() {
		
System.setProperty("webdriver.chrome.driver","C:\\C\\admin\\eclipse\\eclipse-java-2021-06-R-win32-x86_64\\chromedriver(2).exe");
			
		
		 driver= new ChromeDriver();
		
			driver.manage().window().maximize();
		   
			driver.manage().deleteAllCookies();
			
			driver.get("https://nxtgenaiacademy.com/demo-site/");
			
	}
	
	@DataProvider
	
	public Iterator<Object[]> gettingTestdata() {
		
		ArrayList<Object[]> testdata=Testutil.readdataFromexcel();
		return testdata.iterator();
		
	}
	
	@Test(dataProvider="gettingTestdata")
	
	public void RegistrationPageTest(String firstname,String lastname, String address1,String address2,String city,String state,String emailaddress) throws InterruptedException {
		
driver.findElement(By.xpath("//input[@type='text']")).clear();
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(firstname);
		
		
		driver.findElement(By.xpath("//input[@id='vfb-7']")).clear();
	    driver.findElement(By.xpath("//input[@id='vfb-7']")).sendKeys(lastname);
		
		driver.findElement(By.xpath("//input[@id='vfb-13-address']")).clear();
		driver.findElement(By.xpath("//input[@id='vfb-13-address']")).sendKeys(address1);
		
		driver.findElement(By.xpath("//input[@id='vfb-13-address-2']")).clear();
		driver.findElement(By.xpath("//input[@id='vfb-13-address-2']")).sendKeys(address2);
		
		driver.findElement(By.xpath("//input[@id='vfb-13-zip']")).clear();
		driver.findElement(By.xpath("//input[@id='vfb-13-zip']")).sendKeys(city);
		
		Thread.sleep(2000);
		
		Select sel=new Select(driver.findElement(By.xpath("//select[@id='vfb-13-country']")));
		sel.selectByVisibleText(state);
		
		
		
		
		
		driver.findElement(By.xpath("//input[@type='email']")).clear();
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(emailaddress);
		
		
	}
	
	
	
	
	@AfterMethod
	
	public void tearDown() {
		
		driver.quit();
		
	}
	
	

}
