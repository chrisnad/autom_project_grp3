package org.autom.firstproject.tests;

import org.autom.firstproject.pageobject.chris.LoginPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;


public class testDeConnexion {
	
	WebDriver driver;
	
	/* Variables */
	String login = "admin";
	String mdp = "admin";
	
	@Before
	public void InitialisationiFrame() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8180/libreplan/common/layout/login.zul");
		driver.manage().window().maximize();
	}
	
	@Test
	public void ConnexionLoginPageTest() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.ConnexionLoginPage(login, mdp);
	}
	
}
