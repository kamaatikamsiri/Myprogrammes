package com.prosoft.com.mercurytours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	public WebDriver driver;
	@FindBy(name="userName")
	public WebElement username;
	@FindBy(name="password")
	public WebElement pwd;
	@FindBy(name="login")
	public WebElement login;
	public Loginpage(WebDriver x)
	{
		this.driver=x;
		PageFactory.initElements(driver,this);
	}
	public void fillusername(String uname)
	{
		username.sendKeys(uname);
	}
	public void fillpwd(String paswd)
	{
		pwd.sendKeys(paswd);
	}
	public void login()
	{
		login.click();
	}
	}
	


