package org.autom.firstproject.pageobject.karim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// ============================================================================================================================//
	// =================================================== ELEMENTS DE LA PAGE
	// ====================================================//

	private WebDriver driver;

	@FindBy(id = "textfield")
	private WebElement champLogin;
	
	@FindBy(id = "textfield2")
	private WebElement champMdp;
	
	@FindBy(id = "button")
	private WebElement btLogin;

	// ============================================================================================================================//
	// ======================================================= CONSTRUCTEUR
	// =======================================================//

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// ============================================================================================================================//
	// ====================================================== LISTE METHODES
	// ======================================================//

	// Méthode 01 : Connexion à l'application

	// ============================================================================================================================//
	// ========================================================= METHODES
	// =========================================================//

	// Méthode 01 : Connexion à l'application
	public HomePage ConnexionLoginPage(String login, String mdp) {
		champLogin.clear();
		champLogin.sendKeys(login);
		champMdp.clear();
		champMdp.sendKeys(mdp);
		btLogin.click();
				
		return PageFactory.initElements(driver, HomePage.class);
	}

}
