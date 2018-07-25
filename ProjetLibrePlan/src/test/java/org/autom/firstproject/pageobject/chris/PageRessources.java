package org.autom.firstproject.pageobject.chris;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageRessources {
	
	
//============================================================================================================================//
//=================================================== ELEMENTS DE LA PAGE ====================================================//
	
	protected final WebDriver driver;
	
	@FindBy(xpath="//img[@src='/libreplan/common/img/logo.png']") 
	private WebElement librePlanLogo;
	
	@FindBy(xpath="//button[contains(@id,'r-b')]") 
	private WebElement buttonRessources;
	
	@FindBy(xpath="//a[contains(@id,'w-a')]")
	private WebElement lienCalendriers;
	
	@FindBy(xpath="//*[@id]")
	private List<WebElement> allElementsWithIds;
	
//============================================================================================================================//
//======================================================= CONSTRUCTEUR =======================================================//
	
	public PageRessources(WebDriver driver) {
		super();
		this.driver = driver;
	}	
	
//============================================================================================================================//
//====================================================== LISTE METHODES ======================================================//
	
	// Méthode 00 : Exemple
	
	private static String[] getAllIds(List<WebElement> listOfElementsWithIds) {
		ArrayList<String> listOfIds = new ArrayList<String>();
		for (WebElement element : listOfElementsWithIds.subList(0, 100)) {
		//for (WebElement element : listOfElementsWithIds) {
			listOfIds.add(element.getAttribute("id"));
	    }
		String[] listOfAllIds = new String[listOfIds.size()];
		listOfAllIds = listOfIds.toArray(listOfAllIds);

		return listOfAllIds;
	}

	private static boolean allCharactersAreSame(String[] strings, int pos) {
	    String first = strings[0];
	    for (String curString : strings) {
	        if (curString.length() <= pos 
	                || curString.charAt(pos) != first.charAt(pos)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static String getLongestCommonPrefix(List<WebElement> listOfElementsWithIds) {
		String[] strings = getAllIds(listOfElementsWithIds);
	    int commonPrefixLength = 0;
	    while (allCharactersAreSame(strings, commonPrefixLength)) {
	        commonPrefixLength++;
	    }
	    return strings[0].substring(0, commonPrefixLength);
	}
	
//============================================================================================================================//
//========================================================= METHODES =========================================================//
	
	// Méthode 00 : Exemple
	
	public HomePage cliquerLibrePlanLogo() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfAllElements(librePlanLogo), 
				ExpectedConditions.elementToBeClickable(librePlanLogo)));
		
		librePlanLogo.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public PageListeCalendriers cliquerRessourcesCalendriers() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(buttonRessources)
			.moveToElement(lienCalendriers).build().perform();
		
		lienCalendriers.click();
		return PageFactory.initElements(driver, PageListeCalendriers.class);
	}
	
	// Maxime peut écrire ses méthodes ici !
	
	
	
}
