package tests;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.MailboxPage;

public class GlucodeMethods {
	public WebDriver driver;
	public Scenario s;
	public Properties prop;
	public HomePage hp;
	public LoginPage lp;
	public MailboxPage mp;
	@Before
	public void method1(Scenario x) throws Exception
	{
		//use scenario object for current scenario
		this.s=x;
		//load properties file from current scenario
		prop=new Properties();
		//get data from properties file
		FileInputStream fis=new FileInputStream("E:\\seleniumprogrammes\\gmailcucumbet"
				                               + "\\src\\test\\resources\\gmailresources\\"
				                               +" properties1.properties");
		prop.load(fis);
		//open browser for current scenario
		System.setProperty("webdriver.chrome.driver","prop.getproperty(cdpath)");
		driver=new ChromeDriver();
		//create page objects for current scenario
		hp=new HomePage(driver);
		lp=new LoginPage(driver);
		mp=new MailboxPage(driver);
		
	}
	 @Given ("^launch gmail site$")
	public void method2() throws Exception
	{
		 driver.get(prop.getProperty("url"));
		 Thread.sleep(5000);
	}
	 @Then ("^Title is \"(.*)\" value$")
	 public void method3(String x)
	 {
		 String t=driver.getTitle();
		 if(t.equals(x))
		 {
			 s.write("Title test was passed");
		 }
		 else
		 {
			 TakesScreenshot ts=(TakesScreenshot)driver;
			 byte[] src=ts.getScreenshotAs(OutputType.BYTES);
			 s.embed(src, "Title test failed");
		 }
	 }
	 @ And ("^close site$")
	 public void method4()
	 {
		 driver.close();
	 }
	 @When ("^enter userid with \"(.*)\"value$")
	 public void method5(String u) throws Exception
	 {
		 hp.filluid(u);
		 Thread.sleep(3000);
	 }
	 @And ("^click next button$")
	 public void method6() throws Exception 
	 {
		 hp.clicknext();
		 Thread.sleep(2000);
	 }
	 @Then ("^validate userid with \"(.*)\" value$")
	 public void method7(String uc)
	 {
		 if(uc.equalsIgnoreCase("valid")&&lp.pwd.isDisplayed())
		 {
			 s.write("valid uid test passed");
		 }
		 else if(uc.equalsIgnoreCase("invalid")&&hp.invaliduiderr.isDisplayed())
		 {
			 s.write("invalid uid test passed");
		 }
		 else if(uc.equalsIgnoreCase("blank")&&hp.blankuiderr.isDisplayed())
		 {
			 s.write("blank uid test passed");
		 }
		 else
		 {
			 TakesScreenshot ts=(TakesScreenshot)driver;
			 byte[] src=ts.getScreenshotAs(OutputType.BYTES);
			 s.embed(src, "Title test failed");
		 }
		 }
	 @And ("^enter password with \"(.*)\" value$")
	 public void method8(String p)
	 {
		 lp.fillpwd(p);
	 }
	 @And ("^click password next button$")
	 
 public void method9()
		 {
			 lp.clickpwdnext();
		 }
	  @Then ("^validate passwor with \"(.*)\" criteria$")
	  public void method10(String pc)
	  {
		  if(pc.equalsIgnoreCase("valid")&&mp.comp.isDisplayed())
		  {
			  s.write("valid pwd test passed");
		  }
		  else if(pc.equalsIgnoreCase("invalid")&&lp.invalidpwderr.isDisplayed())
		  {
			  s.write("invalid pwd test passed");
		  }
		  else if(pc.equalsIgnoreCase("blank")&&lp.blankpwderr.isDisplayed())
		  {
			  s.write("blank pwd test passed");
		  }
		  else
		  {
			  TakesScreenshot ts=(TakesScreenshot)driver;
				 byte[] src=ts.getScreenshotAs(OutputType.BYTES);
				 s.embed(src, "Title test failed");
		  }
		 
		 
	 }
		 
	 }
