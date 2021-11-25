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

public class Test1_Add_Skills {
	
	WebDriver driver;
	
	//step1
	String TestURL,UserName,Password;
	String SkillName,SkillDescr;
	
	Map<String, HashMap<String, String>> Datatable = new HashMap<String, HashMap<String, String>>();
	
  @Test
  public void AddSkillsTest()throws Exception {
	  
	  
	  
		ExcelApiTest4 eat = new ExcelApiTest4();
		
		Datatable=eat.getDataTable("C://HTML Report//OrangeHRM6//TC01_EMPExport4.xlsx", "Sheet1");
		
		+
		
		


		//String TestURL=Datatable.get("TC01").get("UserName");
		
		System.out.println(Datatable.get("TC04").get("UserName"));
		System.out.println(Datatable.get("TC04").get("Password"));
		System.out.println(Datatable.get("TC04").get("SkillName"));
		System.out.println(Datatable.get("TC04").get("SkillDescr"));
		System.out.println(Datatable.get("TC04").get("TestURL"));
		
		TestURL=Datatable.get("TC04").get("TestURL");
		UserName=Datatable.get("TC04").get("UserName");		
		Password=Datatable.get("TC04").get("Password");
		SkillName=Datatable.get("TC04").get("SkillName");
		SkillDescr=Datatable.get("TC04").get("SkillDescr");
	 
	Test1_Add_Skills T1=new Test1_Add_Skills();
	  
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM(TestURL);  
	  T1.Login(UserName,Password); 
	  T1.AddSkills(SkillName,SkillDescr);
	
		
  }
  
  
  
  public void OpenChromeBrowser()throws Exception {
	  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
  }
  
 public void OpenOrangeHRM(String TestURL1 )throws Exception {
		
		driver.get(TestURL1);
	  
  }
  
  
 public void Login(String UserName1,String Password1)throws Exception {
		
		findElement(By.id("txtUsername")).sendKeys(UserName1);
		findElement(By.id("txtPassword")).sendKeys(Password1);
		findElement(By.id("btnLogin")).click();
	  
 }
 
 public void AddSkills(String SkillName1,String SkillDescr1)throws Exception {
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys(SkillName1);
		findElement(By.id("skill_description")).sendKeys(SkillDescr1);
		findElement(By.id("btnSave")).click();
 }  
  
 
 public void CloseBrowser()throws Exception {
	  
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
