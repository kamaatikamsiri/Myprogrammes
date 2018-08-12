package com.prosoft.com.mercurytours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureFlightpage {
	public WebDriver driver;
	@FindBy(name="passFirst0")
	public WebElement firstname;
	@FindBy(name="passLast0")
	public WebElement lastname;
	@FindBy(name="creditnumber")
	public WebElement creditcardnum;
	@FindBy(name="ticketLess")
	public WebElement ticketlesscheckbox;
	@FindBy(name="buyFlights")
	public WebElement securepurchasebtn;
	public SecureFlightpage(WebDriver x)
	{
		this.driver=x;
		PageFactory.initElements(driver,this);
	}
	public void fillfirstname(String fname)
	{
		firstname.sendKeys(fname);
	}
	public void filllastname(String lname)
	{
		lastname.sendKeys(lname);
	}
	public void credcardnum(String num)
	{
		creditcardnum.sendKeys(num);
	}
	public void clickoncheckbox()
	{
		ticketlesscheckbox.click();
	}
	public void securepurchasebtn()
	{
		securepurchasebtn.click();
	}
	




}
