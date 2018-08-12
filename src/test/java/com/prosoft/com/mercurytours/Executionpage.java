package com.prosoft.com.mercurytours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Executionpage {
	public static WebDriver driver;
	// create objects to each page classes
	Loginpage lp = new Loginpage(driver);
	FindFlightpage fp = new FindFlightpage(driver);
	SelectFlightpage sfp = new SelectFlightpage(driver);
	SecureFlightpage ssp = new SecureFlightpage(driver);

	@BeforeClass
	public void launch() {
		System.setProperty("WebDriver.chrome.driver", "ChromeDriver.exe");
		driver = new ChromeDriver();
		// launch mercury tours site
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		// maximize browser
		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void login() {
		lp.fillusername("mercury");
		lp.fillpwd("mercury");
		lp.login();
	}

	@Test(priority = 1)
	public void findflight() throws InterruptedException {
		fp.clickradiobtn();
		fp.dep();
		Thread.sleep(2000);
		fp.arr();
		Thread.sleep(2000);
		fp.clickserviceclass();
		fp.clickcontinue();
	}

	@Test(priority = 2)
	public void selectflight() {
		sfp.clcikselectflight();
	}

	@Test(priority = 3)

	public void secureflight() {
		ssp.fillfirstname("sireesha");
		ssp.filllastname("k");
		ssp.credcardnum("1223455678888");
		ssp.clickoncheckbox();
		ssp.securepurchasebtn();

	}
	@AfterClass
	public void close() {
		driver.close();
	}
	}


