package com.prosoft.com.mercurytours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FindFlightpage {
	public  WebDriver driver;
	@FindBy(name="tripType")
	public WebElement clickradiobtn;
	@FindBy(name="fromPort")
	public WebElement dep;
	@FindBy(name="toPort")
	public WebElement arr;
	@FindBy(name="servClass")
	public WebElement serviceclass ;
	@FindBy(name="findFlights")
	public WebElement clickfndflights;
	public FindFlightpage(WebDriver x)
	{
		this.driver=x;
		PageFactory.initElements(driver,this);
	}
	public void clickradiobtn()
	{
		clickradiobtn.click();
	}
	public void dep()
	{
		Select s=new Select(dep);
		s.selectByVisibleText("Sydney");
	}
	public void arr()
	{
		Select s=new Select(arr);
		s.selectByVisibleText("London");
		
	}
	public void clickserviceclass()
	{
		serviceclass.click();
	}
	public void clickcontinue()
	{
		clickfndflights.click();
	}
	
	




}
