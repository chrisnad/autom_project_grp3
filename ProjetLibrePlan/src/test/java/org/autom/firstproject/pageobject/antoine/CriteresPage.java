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
	
	// M�thode 01 : Cliquer sur "Cr�er" dans la page crit�res
	// M�thode 02 : Rechercher un crit�re
	// M�thode 03 : Modifier un crit�re
	// M�thode 04 : Supprimer un crit�re
	
//============================================================================================================================//
//========================================================= METHODES =========================================================//
	
	// M�thode 01 : Cliquer sur "Cr�er" dans la page crit�res
	public FormulaireCriteresPage cliquerCreerNouveauCritere() {
		btCreation.click();
		return PageFactory.initElements(driver, FormulaireCriteresPage.class);
	}
	
	
	// M�thode 02 : Rechercher un crit�re
	public int rechercherCritere(String nomCritere) {
		int numeroDeLigne = -1;
		int ligneCourante = 0;
		String userName = "Non trouv�";
		
		// Recherche de la ligne contenant le crit�re recherch�
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
			System.out.println("ERROR : Impossible de trouver un r�sultat � la recherche.");
			Assert.fail();
		}
		
		System.out.println("Nom crit�re trouv� : "+userName);
		int numligne = numeroDeLigne +1;
		System.out.println("numligne : "+numligne);
		return numligne;	
	}
	
	// M�thode 03 : Modifier un crit�re
		public void modifierCritere(String nomCritere, String nomFormulaireModif) {
			int numligne = rechercherCritere(nomCritere);
			//CriteresPage criteres = PageFactory.initElements(driver, CriteresPage.class);
			
			WebElement btModif = driver.findElement(By.xpath("//*[@class='z-rows']/tr["+numligne+"]/td[5]/descendant::img[@src='/libreplan/common/img/ico_editar1.png']"));
			btModif.click();
			FormulaireCriteresPage formulaire = PageFactory.initElements(driver, FormulaireCriteresPage.class);
			WebElement titrePage = driver.findElement(By.xpath("//*[contains(@id,'5-cnt')]"));
			String txtTitrePage = titrePage.getText();
			Assert.assertEquals("V�rification titre page", txtTitrePage, "Modifier Type de crit�re: "+nomCritere);
			formulaire.modifierNomFormulaireCriteres(nomFormulaireModif);
			formulaire.validerModificationNomFormulaire();
			txtTitrePage = titrePage.getText();
			Assert.assertEquals("V�rification titre page", txtTitrePage, "Modifier Type de crit�re: "+nomFormulaireModif);
			formulaire.modifierNomFormulaireCriteres(nomCritere);
			formulaire.validerModificationNomFormulaire();
			txtTitrePage = titrePage.getText();
			Assert.assertEquals("V�rification titre page", txtTitrePage, "Modifier Type de crit�re: "+nomCritere);
			formulaire.cancelFormulaire();
			
		}
		
	// M�thode 04 : Supprimer un crit�re - N�cessite potentiellement un refrech de la page avant ex�cution
	public void supprimerCritere(String nomCritere) throws InterruptedException {
		int numligne = rechercherCritere(nomCritere);
		WebElement btSuppr = driver.findElement(By.xpath("//*[@class='z-rows']/tr["+numligne+"]/td[5]/descendant::img[@src='/libreplan/common/img/ico_borrar1.png']"));
		btSuppr.click();
		WebElement btConfirmationSuppression = driver.findElement(By.xpath("//*[contains(@id,'4-box')]//tbody/tr[2]/td[2]"));
		btConfirmationSuppression.click(); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
