package org.autom.firstproject.pageobject.chris;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageListeCalendriers extends PageRessources{
	
	@FindBy(xpath="//*[@id][not(name()='iframe')]")
	private List<WebElement> allElementsWithIds;
	
	private WebElement tableauListeCalendriers;
	
	private WebElement boutonCreation;
	
	private WebElement infoMessage;
	
	private List<WebElement> deriveesDeCalendrier;
	
	@FindBy(xpath="//*[@class='z-messagebox-btn z-button']/table")
	private WebElement boutonValider;
	
	private String commonPrefix;
	
//	@FindBy(xpath="//span[contains(@id,'Po8')][contains(text(),'Calendrier - Test 1')]/following::span[@title='Supprimer'][@class='icono z-button']")
//	private WebElement calendrierASupprimer;

	public PageListeCalendriers(WebDriver driver) {
		super(driver);
	}
	
	public List<WebElement> contenuTableauListeCalendriers(){
		List<WebElement> list = tableauListeCalendriers.findElements(By.xpath("./descendant::div[contains(@id,'4-cave')]"));
		return list;
	}
	
	public void cliquerBoutonCreation() {
		boutonCreation.click();
	}
	
	public List<WebElement> listeCalendriersDerivees(String nomCalendrier){
		this.deriveesDeCalendrier = driver.findElements(By.xpath("//*[text()='"+nomCalendrier+"']/following::span[preceding-sibling::*[position() = 2]][@class='z-label']"));
		return this.deriveesDeCalendrier;
	}
	
	public void copieDeCalendrier(String nomCalendrier) {
		String xpression = "//*[text()='"+nomCalendrier+"']/following::span[@title='Créer une copie'][1]/descendant::td[@class='z-button-cm']";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement boutonCopie = driver.findElement(By.xpath(xpression));
		boutonCopie.click();
	}
	
	public void deriveDeCalendrier(String nomCalendrier) {
		String xpression = "//*[text()='"+nomCalendrier+"']/following::span[@title='Créer une dérive'][1]/descendant::td[@class='z-button-cm']";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement boutonDerive = driver.findElement(By.xpath(xpression));
		boutonDerive.click();
	}
	
	public void supprimerCalendrier(String nomCalendrier) {
		String xpression = "//*[text()='"+nomCalendrier+"']/following::span[@title='Supprimer'][1]/descendant::td[@class='z-button-cm']";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement calendrierASupprimer = driver.findElement(By.xpath(xpression));
		calendrierASupprimer.click();
		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		wait3.until(ExpectedConditions.and(ExpectedConditions.visibilityOfAllElements(boutonValider), 
				ExpectedConditions.elementToBeClickable(boutonValider)));
		boutonValider.click();
	}
	
	public WebElement infoMessage() {
		this.infoMessage = driver.findElement(By.xpath("//span[parent::div[@class='message_INFO'][last()]]"));
		return this.infoMessage;
	}
	
	public boolean cliquerMinimiserCalendrier(String nomCalendrier) {
		String xpression = "//span[text()='"+nomCalendrier+"']/preceding-sibling::span[contains(@class,'z-dottree-ico')]";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement boutonMinimizer = driver.findElement(By.xpath(xpression));
		boutonMinimizer.click();
		
		return boutonMinimizer.getAttribute("class").endsWith("-close");
	}
	
	public void initiatePageListeCalendriers(){
		
		this.commonPrefix = getLongestCommonPrefix(allElementsWithIds);
		
		this.tableauListeCalendriers = driver.findElement(By.xpath("//*[@id='"+this.commonPrefix+"k4-head']/table"));

		this.boutonCreation = driver.findElement(By.xpath("//*[@id='"+this.commonPrefix+"q4-box']/descendant::td[@class='z-button-cm']"));
	}
	
}