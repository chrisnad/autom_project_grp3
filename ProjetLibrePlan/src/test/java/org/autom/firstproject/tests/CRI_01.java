package org.autom.firstproject.tests;

import org.autom.firstproject.pageobject.antoine.CriteresPage;
import org.autom.firstproject.pageobject.antoine.FormulaireCriteresPage;
import org.autom.firstproject.pageobject.antoine.LoginPage;
import org.autom.firstproject.pageobject.antoine.TEMPOmenu;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;


public class CRI_01 {
	
	WebDriver driver;
	
	/* Initialisation des variables */
	// Connexion � l'application
	String login = "admin";
	String mdp = "admin";
	// Cr�ation d'un nouveau formulaire
	String nomFormulaire = "Crit�re - Test bouton Annuler";
	String descriptionFormulaire = "Test du bouton d'annulation";
	// Modification du nom du formulaire
	String nomFormulaireModif = "Crit�re - Test Modification";
	
	@Before
	public void InitialisationiFrame() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\formation\\Desktop\\workspace\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8180/libreplan/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void administrationCriteresTest() throws InterruptedException {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		TEMPOmenu tempo = loginPage.ConnexionLoginPage(login, mdp);
		CriteresPage criteres = tempo.goCriteres();
		FormulaireCriteresPage formulaire = criteres.cliquerCreerNouveauCritere();
		formulaire.remplirFormulaireCriteres(nomFormulaire, descriptionFormulaire);
		formulaire.cancelFormulaire();
		// Cr�ation niveau crit�res
		nomFormulaire = "Crit�re - Test bouton Cr�ation";
		descriptionFormulaire = "Test du bouton de cr�ation";
		criteres.cliquerCreerNouveauCritere();
		formulaire.remplirFormulaireCriteres(nomFormulaire, descriptionFormulaire);
		formulaire.saveAndContinueFormulaire();
		formulaire.cancelFormulaire();
		// Recherche crit�re
		criteres.rechercherCritere(nomFormulaire);
		// Modification crit�re
		criteres.modifierCritere(nomFormulaire, nomFormulaireModif);
		// Suppression crit�re
		tempo.goCriteres();
		criteres.supprimerCritere(nomFormulaire);
		driver.quit();		
	}
	
	
	
	
	
	
	
	
}
