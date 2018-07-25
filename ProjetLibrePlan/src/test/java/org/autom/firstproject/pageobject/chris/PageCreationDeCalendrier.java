package org.autom.firstproject.pageobject.chris;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCreationDeCalendrier extends PageListeCalendriers{
	
	@FindBy(xpath="//*[@id][not(name()='iframe')]")
	private List<WebElement> allElementsWithIds;
	
	//@FindBy(xpath="//input[contains(@id,'45')]")
	private WebElement champNomCalendrier;
	
	//@FindBy(xpath="//*[contains(@id,'z7-box')]/descendant::td[contains(text(),'Enregistrer')]")
	private WebElement boutonEnregistrer;

    private String commonPrefix;


	public PageCreationDeCalendrier(WebDriver driver) {
		super(driver);
	}
	
	public void enregistrerCalendrier(String nomCalendrier) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfAllElements(this.champNomCalendrier), 
				ExpectedConditions.elementToBeClickable(this.champNomCalendrier)));
		
		this.champNomCalendrier.clear();
		this.champNomCalendrier.sendKeys(nomCalendrier);
		
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.and(ExpectedConditions.visibilityOfAllElements(this.boutonEnregistrer), 
				ExpectedConditions.elementToBeClickable(this.boutonEnregistrer)));
		this.boutonEnregistrer.click();
	}
	
	public void initiatePageCreationDeCalendrier(){
		
		this.commonPrefix = getLongestCommonPrefix(allElementsWithIds);
		
		this.champNomCalendrier = driver.findElement(By.id(this.commonPrefix+"45"));

		this.boutonEnregistrer = driver.findElement(By.xpath("//*[@id='"+this.commonPrefix+"z7-box']/descendant::td[contains(text(),'Enregistrer')]"));

	}

}
