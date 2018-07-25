package org.autom.firstproject.tests;

import static org.junit.Assert.assertEquals;

import org.autom.firstproject.pageobject.chris.HomePage;
import org.autom.firstproject.pageobject.chris.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;


public class testMainPage {
	
	WebDriver driver;
	
	@Before
	public void initialisationIFrame() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8180/libreplan/common/layout/login.zul");
		driver.manage().window().maximize();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.ConnexionLoginPage("admin", "admin");
	}
	
	@After
	public void fermetureDuNavigateur() {
		this.driver.quit();
	}
	
	@Test
	public void testHomePage() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.cliquerLibrePlanLogo();
		
		String url = driver.getCurrentUrl();
		assertEquals("http://localhost:8180/libreplan/", url);
	}
	
}
