package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailboxPage {
	public WebDriver driver;
	@FindBy(xpath="//*[text()='COMPOSE']")
	public WebElement comp;
	public MailboxPage(WebDriver x)
	{
		this.driver=x;
		PageFactory.initElements(driver,this );
	}

}
