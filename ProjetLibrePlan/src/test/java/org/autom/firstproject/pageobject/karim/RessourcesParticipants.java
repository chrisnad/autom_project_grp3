package org.autom.firstproject.pageobject.karim;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RessourcesParticipants extends MenuPage{
	
	
//============================================================================================================================//
//=================================================== ELEMENTS DE LA PAGE ====================================================//
	
	protected final WebDriver driver;
	
	@FindBy(xpath="//*[contains(@id, 'y5-box')]/descendant::td[@class='z-button-tm']")
	private WebElement btnCreer;
	
	@FindBy(xpath="//*[contains(@id, '4-cap')]")
	private WebElement texteListeParticipants;
	
	@FindBy(xpath="//*[@title=\"Choisir l'ensemble requis de critères et appuyer sur le bouton filtrer\"]")
	private WebElement champsFiltrePar;
	
	@FindBy(xpath="//*[contains(@id, 'q4')][@class='z-bandbox-btn']")
	private WebElement loupeChampsFiltrePar;
	
	@FindBy(xpath="//tr[@valign='top']/td/child::input[contains(@id, 'd5')]")
	private WebElement champsDetailsPersonnels;
	
	@FindBy(xpath="//tr/child::td[contains(@id, 'f5')][@align='left']")
	private WebElement btnPlusDOption;
	
	@FindBy(xpath="//*[contains(@id, 'i5')][@class='z-datebox-inp']")
	private WebElement champsPeriodeActiveDepuis;
	
	@FindBy(xpath="//*[contains(@id, 'k5')][@class='z-datebox-inp']")
	private WebElement champsPeriodeA;
	
	@FindBy(xpath="//select[contains(@id, 'm5')]")
	private WebElement menuDeroulantType;
	
	@FindBy(xpath="//select[contains(@id, 'm5')]/option[@selected='selected']")
	private WebElement menuDeroulantValeurParDefaut;
	
	@FindBy(xpath="//*[contains(@id, 'n5-box')]/descendant::td[@class='z-button-tm']")
	private WebElement btnFiltre;
	
	@FindBy(xpath="//tr[@align='left']/child::th[contains(@id, 's5')]")
	private WebElement colonneSurnom;
	
	@FindBy(xpath="//tr[@align='left']/child::th[contains(@id, 't5')]")
	private WebElement colonnePrenom;
	
	@FindBy(xpath="//tr[@align='left']/child::th[contains(@id, 'u5')]")
	private WebElement colonneID;
	
	@FindBy(xpath="//tr[@align='left']/child::th[contains(@id, 'v5')]")
	private WebElement colonneCode;
	
	@FindBy(xpath="//tr[@align='left']/child::th[contains(@id, 'w5')]")
	private WebElement colonneEnFile;
	
	@FindBy(xpath="//tr[@align='left']/child::th[contains(@id, 'x5')]")
	private WebElement colonneOperations;
	
	@FindBy(xpath="//*/img/following-sibling::span[contains(@id, 'g')]")
	private WebElement participantCreer;
		
	@FindBy(xpath="//*[@href='/libreplan/j_spring_security_logout']")
	private WebElement btnDeconnexion;
	
//============================================================================================================================//
//======================================================= CONSTRUCTEUR =======================================================//
	
	public RessourcesParticipants(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}	
	
//============================================================================================================================//
//====================================================== LISTE METHODES ======================================================//
	
	// Méthode 00 : Exemple
	
//============================================================================================================================//
//========================================================= METHODES =========================================================//
	
	public String listeParticipants() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(champsFiltrePar));
		wait.until(ExpectedConditions.visibilityOf(loupeChampsFiltrePar));
		wait.until(ExpectedConditions.visibilityOf(champsDetailsPersonnels));
		wait.until(ExpectedConditions.visibilityOf(btnPlusDOption));
		wait.until(ExpectedConditions.visibilityOf(btnFiltre));
		wait.until(ExpectedConditions.visibilityOf(colonneSurnom));
		wait.until(ExpectedConditions.visibilityOf(colonnePrenom));
		wait.until(ExpectedConditions.visibilityOf(colonneID));
		wait.until(ExpectedConditions.visibilityOf(colonneCode));
		wait.until(ExpectedConditions.visibilityOf(colonneEnFile));
		wait.until(ExpectedConditions.visibilityOf(colonneOperations));
		wait.until(ExpectedConditions.elementToBeClickable(btnCreer));
		return this.texteListeParticipants.getText();
	}
	
	public int rechercheCriteresTableau(String surnom) {
		int numeroDeLigne = -1;
		int ligneCourante = 0;
		String userName = "Non trouvé";
		
		// Recherche de la ligne contenant le critère recherché
		List<WebElement>tablignes = driver.findElements(By.xpath("//*[@class='z-columns']"));
		for (WebElement ligne : tablignes) {
			List<WebElement> cases = ligne.findElements(By.xpath("th"));
			System.out.println("Contenu case "+ligneCourante+" : "+cases.get(0).getText());
			if(surnom.equals(cases.get(0).getText())) {
				numeroDeLigne = ligneCourante;
				userName = cases.get(0).getText();
			}
			ligneCourante++;
		}
		
		if(numeroDeLigne == -1) {
			System.out.println("ERROR : Impossible de trouver un résultat à la recherche.");
			Assert.fail();
		}
		
		System.out.println("Nom critère trouvé : "+userName);
		int numligne = numeroDeLigne +1;
		System.out.println("numligne : "+numligne);
		return numligne;
		
	}
	
	public CreationParticipant cliquerBtnCreerParticipant() {
			
			WebDriverWait wait = new WebDriverWait(driver, 10);

			WebElement buttonCreer = wait.until(ExpectedConditions.elementToBeClickable(btnCreer));

			buttonCreer.click();
			
			return PageFactory.initElements(driver, CreationParticipant.class);
	}
	
	public String participantCree() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(participantCreer));
		return this.participantCreer.getText();
	}
	
	public int rechercherCritere(String nomCritere) {
		int numeroDeLigne = -1;
		int ligneCourante = 0;
		String userName = "Non trouvé";
		
		// Recherche de la ligne contenant le critère recherché
		List<WebElement>tablignes = driver.findElements(By.xpath("//*[@class='z-rows']/tr"));
		for (WebElement ligne : tablignes) {
			List<WebElement> cases = ligne.findElements(By.xpath("td"));
			System.out.println("Contenu case "+ligneCourante+" : "+cases.get(0).getText());
			if(nomCritere.equals(cases.get(0).getText())) {
				numeroDeLigne = ligneCourante;
				userName = cases.get(0).getText();
			}
			ligneCourante++;
		}
		
		if(numeroDeLigne == -1) {
			System.out.println("ERROR : Impossible de trouver un résultat à la recherche.");
			Assert.fail();
		}
		
		System.out.println("Nom critère trouvé : "+userName);
		int numligne = numeroDeLigne +1;
		System.out.println("numligne : "+numligne);
		return numligne;	
	}
	
	public void champsDetail(String nomUt){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(champsDetailsPersonnels));
		champsDetailsPersonnels.clear();
		champsDetailsPersonnels.sendKeys(nomUt);
		btnFiltre.click();				
	}
	
	public LoginPage clicPlusDOption() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(btnPlusDOption));
		btnPlusDOption.click();
		wait.until(ExpectedConditions.visibilityOf(champsPeriodeActiveDepuis));
		wait.until(ExpectedConditions.visibilityOf(champsPeriodeA));
		wait.until(ExpectedConditions.visibilityOf(menuDeroulantType));
		String a = menuDeroulantValeurParDefaut.getText();
		assertEquals("Vérifier valeur par défaut est Tous", "Tous", a);
		btnDeconnexion.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
}