package org.autom.firstproject.pageobject.max;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class PageProfil {
	

//============================================================================================================================//
//=================================================== ELEMENTS DE LA PAGE ====================================================//
	
	protected final WebDriver driver;
	
	@FindBy(xpath= "//button[contains(@id, '1-b')][contains(text(),'Configuration')]")
	private WebElement buttonProfil;

	@FindBy(xpath="//a[@href='/libreplan/profiles/profiles.zul']") 
	private WebElement profil;
	
	@FindBy(xpath="//td[@class='z-button-cm'][contains(text(),'Créer')]") 
	private WebElement buttonCreate;
//============================================================================================================================//
//======================================================= Assert_Equals =======================================================//
	@FindBy(xpath="//div/input")
	private WebElement Textname;
	
	@FindBy(xpath="//td/i/input") 
	private WebElement AssociateRole;
	
	@FindBy(xpath="//td[@class='z-button-cm'][contains(text(),'Ajouter un rôle')]") 
	private WebElement AddRoles;
	
	@FindBy(xpath="//*[text()='Super utilisateur']/following::span[@class='icono z-button']") 
	private WebElement IconBin;
	
	@FindBy(xpath="//td[@class='z-button-cm'][contains(text(),'Enregistrer')]") 
	private WebElement ButtonRegister;
	
	@FindBy(xpath="//*[text()='Nom']/following::span[@class='icono z-button'][1]") 
	private WebElement ButtonModif;
	
	@FindBy(xpath="//span[contains(text(),'Nom')]")
	private WebElement ModifName;

	@FindBy(xpath="//div/span[@title='Supprimer']")
	private WebElement EraseAll;
	
	@FindBy(xpath="//span[@title='Supprimer']")
	private WebElement reset;
	
	@FindBy(xpath="//td[@class='z-button-cm'][contains(text(),'OK')]")
	private WebElement reset_button;
//============================================================================================================================//
//======================================================= CONSTRUCTEUR =======================================================//
	
	public PageProfil(WebDriver driver) {
		super();
		this.driver = driver;
	}	
	
//============================================================================================================================//
//====================================================== LISTE METHODES ======================================================//
	
	// Méthode 00 : Exemple
	
//============================================================================================================================//
//========================================================= METHODES =========================================================//
	int i = 0;
	int j = 0;
	
	// Méthode 00 : Exemple
	public String putMouseandClick() throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(buttonProfil).moveToElement(profil).build().perform();
		profil.click();
		String str = driver.findElement(By.xpath("//div[@class='z-window-embedded-header']")).getText();
		return str;
	}
	public void clickCreateButton() {
		buttonCreate.click();
	}
	public void writeName() {
		AssociateRole.clear();
		if (i == 0)
			Textname.sendKeys("Nom");
		AssociateRole.sendKeys("Super utilisateur");
		AddRoles.click();
	}
	public void mouseOverBin() {
		Actions builder = new Actions(driver);
		builder.moveToElement(IconBin).build().perform();
		//IconBin.click();
	}
	public void AddmultProfile() {
		if (i == 3)
			i = 0;
		if (i == 0) {
			AssociateRole.clear();
			AssociateRole.sendKeys("Profils");
			AddRoles.click();
		}
		if (i == 1) {
			AssociateRole.clear();
			AssociateRole.sendKeys("Canevas");
			AddRoles.click();
		}
		if (i == 2) {
			AssociateRole.clear();
			AssociateRole.sendKeys("Critère");
			AddRoles.click();
		}
		i++;
	}
	public void clickEraseAll() {
		EraseAll.click();
	}
	public void clickRegisterButton() {
		ButtonRegister.click();
	}
	public void clickModifButton() {
		ButtonModif.click();
	}
	public void rename() {
		Textname.clear();
		Textname.sendKeys("coucou");
	}
	public void click_Reset() {
		reset.click();
		reset_button.click();
	}
	
		// Maxime peut écrire ses méthodes ici !
	
	
	
}
