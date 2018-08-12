package keyworddriven;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Methods {

	public WebDriver driver = null;

	public String launch(String l, String d, String c) throws Exception {
		if (l.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(d);
		Thread.sleep(3000);
		return ("done");
	}

	public String fill(String l, String d, String c) throws Exception {
		driver.findElement(By.xpath(l)).sendKeys(d);
		Thread.sleep(3000);
		return ("done");
	}

	public String click(String l, String d, String c) throws Exception {
		driver.findElement(By.xpath(l)).click();
		Thread.sleep(3000);
		return ("done");
	}

	public String alert() {
		driver.switchTo().alert().accept();
		String x = driver.switchTo().alert().getText();
		return (x);
	}
	public String validatemobilenumber(String l,String d,String c) throws Exception
	{
		try
		{
			if(c.equalsIgnoreCase("valid")&&ExpectedConditions.alertIsPresent()!=null)
			{
				String x=this.alert();
				return("valid mobilenumber test passed");
			}
			else if(c.equalsIgnoreCase("invalid")&&ExpectedConditions.alertIsPresent()!=null)
			{
				String x=this.alert();
				return("invalid mobile number test passed");
			}
			else if(c.equalsIgnoreCase("blank")&&ExpectedConditions.alertIsPresent()!=null)
			{
				String x=this.alert();
				return("blank mobile number test passed");
			}
			else
			{
				String y=this.screenshot();
				return("mobilenumber test failed and screenshot is"+y);
			}
		}
		catch(Exception e)
		{
			String y=this.screenshot();
			return("mobile number is interrupted and screenshot is "+y);
		}
	}

	public String close(String l, String d, String c) throws Exception {
		driver.quit();
		Thread.sleep(3000);
		return ("done");
	}

	public String validatepassword(String l, String d, String c) throws Exception {
		try {
			if (c.equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[text()='Send SMS']")).isDisplayed()) {
				return ("valid password test passed");
			} else if (c.equalsIgnoreCase("invalid")
					&& driver.findElement(By.xpath("//*[text()='Forgot Password? Retreive it now']")).isDisplayed()) {
				return ("invalid password test passed");
			} else if (c.equalsIgnoreCase("blank") && ExpectedConditions.alertIsPresent() != null) {
				return ("blank password test passed");
				
			} else {
				String y = this.screenshot();
				return ("password test failed");
			}
		} catch (Exception e) {
			String y = this.screenshot();
			return ("password test interrupted");

		}
	}

	public String screenshot() throws Exception {
		Date dt = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String fname = df.format(dt);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(fname + ".png");
		FileUtils.copyFile(src, dest);
		return ("fname");

	}
}
