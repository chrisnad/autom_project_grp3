package org.autom.firstproject.pageobject.karim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagePerso extends MenuPage {
	// ============================================================================================================================//
		// =================================================== ELEMENTS DE LA PAGE
		// ====================================================//

		@FindBy(xpath = "//div[contains(text(), 'Mon tableau de bord')]")
		private WebElement champsPagePerso;
		
		@FindBy(xpath = "//td[contains(text(), 'utilisateur:')]")
		private WebElement userName;

		// ============================================================================================================================//
		// ======================================================= CONSTRUCTEUR
		// =======================================================//

		public PagePerso(WebDriver driver) {
			super(driver);
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
		public String pagePerso() {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(champsPagePerso));
			return this.champsPagePerso.getText();
		}
		
		public String pagePerso2() {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(userName));
			return this.userName.getText();
		}
		
}



