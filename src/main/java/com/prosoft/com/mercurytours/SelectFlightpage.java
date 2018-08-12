package com.prosoft.com.mercurytours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlightpage {
	public WebDriver driver;
	@FindBy(name="reserveFlights")
	public WebElement clickselectflight;
	public SelectFlightpage(WebDriver x)
	{
		this.driver=x;
		PageFactory.initElements(driver,this);
	}
	public void clcikselectflight()
	{
		clickselectflight.click();
	}

}
