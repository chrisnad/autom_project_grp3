package org.autom.firstproject.pageobject.antoine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TEMPOmenu {
	
	
//============================================================================================================================//
//=================================================== ELEMENTS DE LA PAGE ====================================================//
	
	private WebDriver driver;
	
	@FindBy(xpath="//*[contains(@id,'r-b')]") private WebElement btRessources;
	@FindBy(xpath="//*[contains(@id,'y-a')]") private WebElement btCriteres;

	//@FindBy(xpath="//*[@id][not(name()='iframe')]") private List<WebElement> allElementsWithIds;

//============================================================================================================================//
//======================================================= CONSTRUCTEUR =======================================================//
	
	public TEMPOmenu(WebDriver driver) {
		super();
		this.driver = driver;
	}	
	
//============================================================================================================================//
//====================================================== LISTE METHODES ======================================================//
	
	// Méthode 01 : Aller à la page Critères
	
//============================================================================================================================//
//========================================================= METHODES =========================================================//
	
	
	public String prefixe() {
		String idvar = driver.findElement(By.xpath("//div[1]")).getAttribute("id").substring(0, 4);	
		System.out.println("idvar : "+idvar);
	return idvar;
	}
	
	
	
	// Méthode 01 : Aller à la page Critères
	public CriteresPage goCriteres() {
		//System.out.println("test");
		Actions actions = new Actions(driver);
		actions.moveToElement(btRessources)
			.moveToElement(btCriteres).build().perform();
	btCriteres.click();
		return PageFactory.initElements(driver, CriteresPage.class);
	}
	
	
	
	
}
