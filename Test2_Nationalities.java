package Day_025_ExcelUtil_Apache_POI;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;

public class Test2_Nationalities {
	
	
	WebDriver driver;
	
	//Step2 - Global Variable
	String TestURL;
	String UserName,Password;
	String NationalityText;
	
	Map<String, HashMap<String, String>> Datatable = new HashMap<String, HashMap<String, String>>();
	
  @Test
  public void Login_Test() throws Exception{
	  
	  
	  ExcelApiTest4 eat = new ExcelApiTest4();
		
		Datatable=eat.getDataTable("C://HTML Report//OrangeHRM6//TC01_EMPExport4.xlsx", "Sheet1");
		
		System.out.println(Datatable.get("TC01").get("UserName"));
		System.out.println(Datatable.get("TC01").get("Password"));
		System.out.println(Datatable.get("TC01").get("TestURL"));
		System.out.println(Datatable.get("TC01").get("Nationality"));

		
		TestURL=Datatable.get("TC01").get("TestURL");
		UserName=Datatable.get("TC01").get("UserName");		
		Password=Datatable.get("TC01").get("Password");
		NationalityText=Datatable.get("TC01").get("Nationality");
	
	  
	  Test2_Nationalities T1=new Test2_Nationalities();
	  
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM(TestURL);     //step3
	  T1.Login(UserName,Password);   //step3
	  T1.AddNationalities(NationalityText);  //step3
	  T1.CloseBrowser();	

  }
  
  
  
  public void OpenChromeBrowser() throws Exception{
	  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
 public void OpenOrangeHRM(String TestURL) throws Exception{
	  
		driver.get(TestURL);
  }
  
 public void Login(String UserName,String Password) throws Exception{
	  
		
		findElement(By.id("txtUsername")).sendKeys(UserName);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
		
 }
 
 public void AddNationalities(String NationalityText) throws Exception{
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys(NationalityText);
		findElement(By.id("btnSave")).click();
	 
 }
 
 public void CloseBrowser() throws Exception{
	  
	 driver.quit();
 }
  
  
  public  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
 
  
  
  
  
}
