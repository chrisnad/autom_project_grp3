package org.autom.firstproject.pageobject.karim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RessourcesCalendrier {

	// ============================================================================================================================//
	// =================================================== ELEMENTS DE LA PAGE
	// ====================================================//

	protected final WebDriver driver;
	
	@FindBy(xpath="//*[contains(@id, 'j4-cap')]")
	private WebElement texteListeCalendriers;
	
	@FindBy(xpath="//*[contains(@id, 'q4-box')]")
	private WebElement btnCreer;
		
	// ============================================================================================================================//
	// ======================================================= CONSTRUCTEUR
	// =======================================================//

	public RessourcesCalendrier(WebDriver driver) {
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
	public String accesCalendrier() {
		return this.texteListeCalendriers.getText();
	}
	
}
