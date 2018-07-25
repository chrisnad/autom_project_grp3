package org.autom.firstproject.pageobject.karim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreationParticipant extends RessourcesParticipants {

	protected final WebDriver driver;
	
	public CreationParticipant(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath="//*[contains(@id, 'o6')]/child::input")
	private WebElement champsPrenom;
	
	@FindBy(xpath="//*[contains(@id, 'u6')]/child::input")
	private WebElement champsNom;
	
	@FindBy(xpath="//*[contains(@id, 'x6')]/child::input")
	private WebElement champsID;
	
	@FindBy(xpath="//*[contains(@id, '7f')]/descendant::td[@class='z-button-cm']")
	private WebElement btnEnregistrer;
	
	@FindBy(xpath="//div[contains(@id, '26-hm')]")
	private WebElement ongletDonneesPersonnelles;
	
	@FindBy(xpath="//span[contains(@id, 'kf')]/child::input[@type=\"radio\"]")
	private WebElement buttonRadio;
	
	@FindBy(xpath="//*[contains(@id, 'i8')]/child::input")
	private WebElement champsNomDUtilisateur;
	
	@FindBy(xpath="//*[contains(@id, 'l8')]/child::input")
	private WebElement champsMDP;
	
	@FindBy(xpath="//*[contains(@id, 'o8')]/child::input")
	private WebElement champsConfirmationMDP;
	
	@FindBy(xpath="//*[contains(@id, 'r8')]/child::input")
	private WebElement champsEmail;
	
	public RessourcesParticipants creerParticipants(String prenom, String nom, String id) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(champsPrenom));
		champsPrenom.clear();
		champsPrenom.sendKeys(prenom);
		champsNom.clear();
		champsNom.sendKeys(nom);
		champsID.clear();
		champsID.sendKeys(id);
		btnEnregistrer.click();
		return PageFactory.initElements(driver, RessourcesParticipants.class);
	}
	
	public String ongletDonneesPerso() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(champsPrenom));
		return this.ongletDonneesPersonnelles.getText();
	}
	
	public RessourcesParticipants creerParticipants2(String prenom, String nom, String id, String nomUt, String mdp, String email) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(champsPrenom));
		champsPrenom.clear();
		champsPrenom.sendKeys(prenom);
		champsNom.clear();
		champsNom.sendKeys(nom);
		champsID.clear();
		champsID.sendKeys(id);
		buttonRadio.click();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOf(champsNomDUtilisateur));
		champsNomDUtilisateur.clear();
		champsNomDUtilisateur.sendKeys(nomUt);
		champsMDP.clear();
		champsMDP.sendKeys(mdp);
		champsConfirmationMDP.clear();
		champsConfirmationMDP.sendKeys(mdp);
		champsEmail.clear();
		champsEmail.sendKeys(email);
		btnEnregistrer.click();
		return PageFactory.initElements(driver, RessourcesParticipants.class);
	}
	

}
