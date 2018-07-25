package org.autom.firstproject.pageobject.antoine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FormulaireCriteresPage {
	
	
//============================================================================================================================//
//=================================================== ELEMENTS DE LA PAGE ====================================================//
	
	private WebDriver driver;
	
	@FindBy(xpath="//*[contains(@id,'e5')][@class='z-textbox']") private WebElement champNom;
	//@FindBy(xpath="") private WebElement boxType; // Vérifier la manière de sélectionner le contenu
	@FindBy(xpath="//*[contains(@id,'t5')][@class='z-textbox']") private WebElement champDescription;
	
	@FindBy(xpath="//*[contains(@id,'6-box')]/descendant::td[@class='z-button-cm'][contains(text(),'Enregistrer')]") private WebElement btSave;
	@FindBy(xpath="//*[contains(@id,'6-box')]/descendant::td[@class='z-button-cm'][contains(text(),'Sauver et continuer')]") private WebElement btSaveAndContinue;
	@FindBy(xpath="//*[contains(@id,'6-box')]/descendant::td[@class='z-button-cm'][contains(text(),'Annuler')]") private WebElement btCancel;

	//WebElement toto = driver.findElement(By.xpath("//*[contains(@id,'e5')][@class='z-textbox']"));
	

	
	
	
//============================================================================================================================//
//======================================================= CONSTRUCTEUR =======================================================//
	
	public FormulaireCriteresPage(WebDriver driver) {
		super();
		this.driver = driver;
	}	
	
//============================================================================================================================//
//====================================================== LISTE METHODES ======================================================//
	
	// Méthode 01 : Remplissage du formulaire
	// Méthode 02 : Sauver le formulaire
	// Méthode 03 : Sauver le formulaire et continuer à le remplir
	// Méthode 04 : Annuler le formulaire
	// Méthode 05 : Modifier le nom du formulaire
	// Méthode 06 : Valider modification du nom du formulaire
	
	
//============================================================================================================================//
//========================================================= METHODES =========================================================//
	
	// Méthode 01 : Remplissage du formulaire
	public void remplirFormulaireCriteres(String nom, String description) {
		champNom.sendKeys(nom);
		champDescription.sendKeys(description);
	}
	
	// Méthode 02 : Sauver le formulaire
	public void saveFormulaire() {
		btSave.click();
	}
	
	// Méthode 03 : Sauver le formulaire et continuer à le remplir
	public void saveAndContinueFormulaire() {
		btSaveAndContinue.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"message_INFO\"]")));
		String txtConfirmation = messageConfirmation.getText();
		System.out.println("FAIRE UN ASSERT SUR : "+txtConfirmation);
	}
	
	// Méthode 04 : Annuler le formulaire
	public void cancelFormulaire() {
		btCancel.click();
	}
	
	// Méthode 05 : Modifier le nom du formulaire
	public void modifierNomFormulaireCriteres(String nom) {
		champNom.clear();
		champNom.sendKeys(nom);
	}
	
	// Méthode 06 : Valider modification du nom du formulaire
	public void validerModificationNomFormulaire() {
		btSaveAndContinue.click();
	}
}
