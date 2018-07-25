package org.autom.firstproject.pageobject.max;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class PageRessources {
	

//============================================================================================================================//
//=================================================== ELEMENTS DE LA PAGE ====================================================//
	
	protected final WebDriver driver;
	
	@FindBy(xpath= "//*[contains(@id,'r-b')]")
	private WebElement buttonRessources;

	@FindBy(xpath="//*[contains(@id,'20-a')]") 
	private WebElement test;
	
//============================================================================================================================//
//======================================================= Assert_Equals =======================================================//
	@FindBy(xpath="//*[contains(@id,'20-a')]") 
	private WebElement Title;
	
	@FindBy(xpath="//div/div[@class='z-column-sort-img']") 
	private WebElement Name;
	
	@FindBy(xpath="//*[@class='z-column']/div[@class='z-column-cnt']") 
	private WebElement Description;
	
	@FindBy(xpath="//*[@style='width:120px;']/div/div") 
	private WebElement Operation;
	
	@FindBy(xpath="//td/input") 
	private WebElement Form;
	
	@FindBy(xpath="//td/span[@class='z-button']") 
	private WebElement Button;
	
//============================================================================================================================//
//======================================================= CONSTRUCTEUR =======================================================//
	
	public PageRessources(WebDriver driver) {
		super();
		this.driver = driver;
	}	
	
//============================================================================================================================//
//====================================================== LISTE METHODES ======================================================//
	
	// Méthode 00 : Exemple
	
//============================================================================================================================//
//========================================================= METHODES =========================================================//
	
	// Méthode 00 : Exemple
	public String putMouseandClick() throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(buttonRessources).moveToElement(test).build().perform();
		test.click();
		String str = driver.findElement(By.xpath("//*[contains(@id,'4-cap')]")).getText();
		return str;
	}
	public String verifName() {
		String str =  driver.findElement(By.xpath("//div/div[@class='z-column-sort-img']/..")).getText();
		System.out.println("str n 1 p " +str);
		return str;
	}
	public String verifDescription() {
		return driver.findElement(By.xpath("//*[@class='z-column']/div[@class='z-column-cnt']")).getText();
	}
	public String verifOperation() {
		return driver.findElement(By.xpath("//*[@style='width:120px;']/div/div/..")).getText();
	}
	public Boolean  verifForm() {
		return driver.findElement(By.xpath("//td/input")).isEnabled();
	}
	public Boolean verifButton() {
		return driver.findElement(By.xpath("//td/span[@class='z-button']")).isEnabled();
	}
	public Boolean verifButtonCreate() {
		return driver.findElement(By.xpath("//span[@class='create-button global-action z-button']")).isEnabled();
	}

	
		// Maxime peut écrire ses méthodes ici !
	
	
	
}
