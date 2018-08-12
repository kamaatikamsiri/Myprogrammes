package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	@FindBy(name="identifier")
	public WebElement uid;
	@FindBy(xpath="//*[text()='Next']")
	public WebElement uidnext;
	//for invalid password we get error message
	@FindBy(xpath="(//*[contains(text(),find your Google Account')])[2]")
	public WebElement invaliduiderr;
	@FindBy(xpath="//*[contains(text(),Enter an email')]")
	public WebElement blankuiderr;
	public HomePage(WebDriver x)
	{
		this.driver=x;
		PageFactory.initElements(driver,this);
	}
	public void filluid(String u)
	{
		uid.sendKeys(u);
	}
	public void clicknext()
	{
		uidnext.click();
	}
		
	}


