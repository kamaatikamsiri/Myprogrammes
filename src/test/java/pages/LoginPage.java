package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	@FindBy(name="password")
	public WebElement pwd;
	@FindBy(xpath="//*[@id='passwordNext']")
	public WebElement pwdnext;
	//for blank password
	@FindBy(xpath="//*[text()='Enter a password']")
	public WebElement blankpwderr;
	//for invalid password
	@FindBy(xpath="//*[contains(text(),'Wrong password')]")
	public WebElement invalidpwderr;
	public LoginPage(WebDriver x)
	{
		this.driver=x;
		PageFactory.initElements(driver,this);
	}
	public void fillpwd(String p)
	{
		pwd.sendKeys(p);
	}
	public void clickpwdnext()
	{
		pwdnext.click();
	}
	}
	


