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
	// Connexion à l'application
	String login = "admin";
	String mdp = "admin";
	// Création d'un nouveau formulaire
	String nomFormulaire = "Critère - Test bouton Annuler";
	String descriptionFormulaire = "Test du bouton d'annulation";
	// Modification du nom du formulaire
	String nomFormulaireModif = "Critère - Test Modification";
	
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
		// Création niveau critères
		nomFormulaire = "Critère - Test bouton Création";
		descriptionFormulaire = "Test du bouton de création";
		criteres.cliquerCreerNouveauCritere();
		formulaire.remplirFormulaireCriteres(nomFormulaire, descriptionFormulaire);
		formulaire.saveAndContinueFormulaire();
		formulaire.cancelFormulaire();
		// Recherche critère
		criteres.rechercherCritere(nomFormulaire);
		// Modification critère
		criteres.modifierCritere(nomFormulaire, nomFormulaireModif);
		// Suppression critère
		tempo.goCriteres();
		criteres.supprimerCritere(nomFormulaire);
		driver.quit();		
	}
	
	
	
	
	
	
	
	
}
