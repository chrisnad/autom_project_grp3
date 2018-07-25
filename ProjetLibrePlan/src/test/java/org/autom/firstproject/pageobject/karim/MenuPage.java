package org.autom.firstproject.pageobject.karim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {
	
	protected WebDriver driver;
	
	//============================================================================================================================//
	//=================================================== ELEMENTS DE LA PAGE ====================================================//
	
	@FindBy(xpath="//*[@src=\"/libreplan/common/img/logo.png\"]")
	private WebElement logo;
	
	//Premier niveau de boutons
	@FindBy(id="")
	private WebElement btnCalendrier;
	
	@FindBy(xpath="//*[contains(@id, 'r-b')]")
	private WebElement btnRessources;
	
	@FindBy(id="")
	private WebElement btnCout;
	
	@FindBy(id="")
	private WebElement btnConfiguration;
	
	@FindBy(id="")
	private WebElement btnCommunications;
	
	@FindBy(id="")
	private WebElement btnRapports;
	
	@FindBy(id="")
	private WebElement btnZonePersonnelle;
	
	//Deuxième niveau de la page
	@FindBy(id="")
	private WebElement calendrierVueDeLaCompagnie;
	
	@FindBy(id="")
	private WebElement calendrierProjets;
	
	@FindBy(id="")
	private WebElement calendrierChangementDesRessources;
	
	@FindBy(id="")
	private WebElement calendrierRessourcesEnFile;
	
	@FindBy(id="")
	private WebElement calendrierCanevas;
	
	@FindBy(id="")
	private WebElement calendrierImporterUnProjet;
	
	@FindBy(xpath="//*[contains(@id, 't-a')]")
	private WebElement ressourcesParticipants;
	
	@FindBy(id="")
	private WebElement ressourcesMachines;
	
	@FindBy(id="")
	private WebElement ressourcesTravailleursVirtuels;
	
	@FindBy(xpath="//*[contains(@id, 'w-a')]")
	private WebElement ressourcesCalendriers;
	
	@FindBy(id="")
	private WebElement ressourcesJoursExceptionnelsDuCalendrier;
	
	@FindBy(id="")
	private WebElement ressourcesCritère;
	
	@FindBy(id="")
	private WebElement ressourcesTypesDAvancement;
	
	@FindBy(id="")
	private WebElement ressourcesLibelles;
	
	@FindBy(id="")
	private WebElement ressourcesMateriels;
	
	@FindBy(id="")
	private WebElement ressourcesUnitesDeMateriel;
	
	@FindBy(id="")
	private WebElement ressourcesFormulairesQualites;
	
	@FindBy(id="")
	private WebElement coutFeuilleDeTemps;
	
	@FindBy(id="")
	private WebElement coutCanevasDeFeuilleDeTemps;
	
	@FindBy(id="")
	private WebElement coutListeDesLignesDeLaFeuilleDeTemps;
	
	@FindBy(id="")
	private WebElement coutDepenses;
	
	@FindBy(id="")
	private WebElement coutCategoriesDeCout;
	
	@FindBy(id="")
	private WebElement coutTypesDHeures;
	
	@FindBy(id="")
	private WebElement configurationReglagesPrincipaux;
	
	@FindBy(id="")
	private WebElement configurationComptesUtilisateurs;
	
	@FindBy(id="")
	private WebElement configurationProfils;
	
	@FindBy(id="")
	private WebElement configurationPlanificationDuTravail;
	
	@FindBy(id="")
	private WebElement communicationsSocietes;
	
	@FindBy(id="")
	private WebElement communicationsEnvoyerAuxSousTraitants;
	
	@FindBy(id="")
	private WebElement communicationsRecuDesSousTraitants;
	
	@FindBy(id="")
	private WebElement communicationsEnvoyeAuxClients;
	
	@FindBy(id="")
	private WebElement communicationsRecuDesClients;
	
	@FindBy(id="")
	private WebElement rapportsHeuresTravailleesParRessource;
	
	@FindBy(id="")
	private WebElement rapportsTotalDesHeuresTravailleesParRessourceEtParMois;
	
	@FindBy(id="")
	private WebElement rapportsTravailEtAvancementParProjet;
	
	@FindBy(id="")
	private WebElement rapportsTravailEtAvancementParTache;
	
	@FindBy(id="")
	private WebElement rapportsHeuresEstimeesPlanifieesParTache;
	
	@FindBy(id="")
	private WebElement rapportsCoutsDuProjet;
	
	@FindBy(id="")
	private WebElement rapportsEtatPrevisionnelDeLaTacheDansLeProjet;
	
	@FindBy(id="")
	private WebElement rapportsBesoinsMaterielsAUneDateDonnee;
	
	@FindBy(id="")
	private WebElement rapportsEtatDuProjet;
	
	@FindBy(id="")
	private WebElement zonePersonnellePreferences;
	
	@FindBy(id="")
	private WebElement zonePersonnelleModifierLeMotDePasse;

	
	//============================================================================================================================//
	//======================================================= CONSTRUCTEUR =======================================================//
	
	public MenuPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	//============================================================================================================================//
	//====================================================== LISTE METHODES ======================================================//
	
	
	
	
	//============================================================================================================================//
	//========================================================= METHODES =========================================================//
	
	public RessourcesCalendrier cliquerBtnCalendrier() {
		Actions action = new Actions(driver);
		action.moveToElement(btnRessources).build().perform();
		
		WebDriverWait wait = new WebDriverWait (driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElements(ressourcesCalendriers));
		wait.until(ExpectedConditions.elementToBeClickable(ressourcesCalendriers));
		
		ressourcesCalendriers.click();
		return PageFactory.initElements(driver, RessourcesCalendrier.class);
	}
	
	public RessourcesParticipants cliquerBtnParticipants() {
		Actions action = new Actions(driver);
		action.moveToElement(btnRessources).build().perform();
		
		WebDriverWait wait = new WebDriverWait (driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElements(ressourcesParticipants));
		wait.until(ExpectedConditions.elementToBeClickable(ressourcesParticipants));
		
		ressourcesParticipants.click();
		return PageFactory.initElements(driver, RessourcesParticipants.class);
	}	
	
}
