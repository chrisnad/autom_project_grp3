package org.autom.firstproject.pageobject.antoine;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CriteresPage {
	
	
//============================================================================================================================//
//=================================================== ELEMENTS DE LA PAGE ====================================================//
	
	private WebDriver driver;
	
	@FindBy(xpath="//*[contains(@id,'5-box')]/descendant::td[@class='z-button-cm']") private WebElement btCreation;
	
	
//============================================================================================================================//
//======================================================= CONSTRUCTEUR =======================================================//
	
	public CriteresPage(WebDriver driver) {
		super();
		this.driver = driver;
	}	
	
//============================================================================================================================//
//====================================================== LISTE METHODES ======================================================//
	
	// Méthode 01 : Cliquer sur "Créer" dans la page critères
	// Méthode 02 : Rechercher un critère
	// Méthode 03 : Modifier un critère
	// Méthode 04 : Supprimer un critère
	
//============================================================================================================================//
//========================================================= METHODES =========================================================//
	
	// Méthode 01 : Cliquer sur "Créer" dans la page critères
	public FormulaireCriteresPage cliquerCreerNouveauCritere() {
		btCreation.click();
		return PageFactory.initElements(driver, FormulaireCriteresPage.class);
	}
	
	
	// Méthode 02 : Rechercher un critère
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
	
	// Méthode 03 : Modifier un critère
		public void modifierCritere(String nomCritere, String nomFormulaireModif) {
			int numligne = rechercherCritere(nomCritere);
			//CriteresPage criteres = PageFactory.initElements(driver, CriteresPage.class);
			
			WebElement btModif = driver.findElement(By.xpath("//*[@class='z-rows']/tr["+numligne+"]/td[5]/descendant::img[@src='/libreplan/common/img/ico_editar1.png']"));
			btModif.click();
			FormulaireCriteresPage formulaire = PageFactory.initElements(driver, FormulaireCriteresPage.class);
			WebElement titrePage = driver.findElement(By.xpath("//*[contains(@id,'5-cnt')]"));
			String txtTitrePage = titrePage.getText();
			Assert.assertEquals("Vérification titre page", txtTitrePage, "Modifier Type de critère: "+nomCritere);
			formulaire.modifierNomFormulaireCriteres(nomFormulaireModif);
			formulaire.validerModificationNomFormulaire();
			txtTitrePage = titrePage.getText();
			Assert.assertEquals("Vérification titre page", txtTitrePage, "Modifier Type de critère: "+nomFormulaireModif);
			formulaire.modifierNomFormulaireCriteres(nomCritere);
			formulaire.validerModificationNomFormulaire();
			txtTitrePage = titrePage.getText();
			Assert.assertEquals("Vérification titre page", txtTitrePage, "Modifier Type de critère: "+nomCritere);
			formulaire.cancelFormulaire();
			
		}
		
	// Méthode 04 : Supprimer un critère - Nécessite potentiellement un refrech de la page avant exécution
	public void supprimerCritere(String nomCritere) throws InterruptedException {
		int numligne = rechercherCritere(nomCritere);
		WebElement btSuppr = driver.findElement(By.xpath("//*[@class='z-rows']/tr["+numligne+"]/td[5]/descendant::img[@src='/libreplan/common/img/ico_borrar1.png']"));
		btSuppr.click();
		WebElement btConfirmationSuppression = driver.findElement(By.xpath("//*[contains(@id,'4-box')]//tbody/tr[2]/td[2]"));
		btConfirmationSuppression.click(); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
