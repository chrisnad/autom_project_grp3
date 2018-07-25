package org.autom.firstproject.pageobject.chris;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCopieDeCalendrier extends PageListeCalendriers{
	
	@FindBy(xpath="//*[@id][not(name()='iframe')]")
	private List<WebElement> allElementsWithIds;
	
	private WebElement titre;
	
	private WebElement inputField;
	
	private WebElement type;
	
	private WebElement boutonEnregistrerEtContinuer;
	
	private WebElement boutonEnregistrer;
	
	private WebElement warningMessage;
	
    private String commonPrefix;


	public PageCopieDeCalendrier(WebDriver driver) {
		super(driver);
	}
	
	public void nommeCopieDeCalendrier(String nomCalendrier) {
		this.inputField.clear();
		this.inputField.sendKeys(nomCalendrier);
	}
	
	public WebElement titre() {
		return this.titre;
	}
	
	public void enregistrerEtContinuer() {
		this.boutonEnregistrerEtContinuer.click();
	}
	
	public void enregistrerCopieDeCalendrier() {
		this.boutonEnregistrer.click();
	}
	
	public WebElement warningMessage() {
		this.warningMessage = driver.findElement(By.xpath("//span[parent::div[@class='message_WARNING']]"));
		return this.warningMessage;
	}
	
	public String type() {
		return this.type.getText();
	}
	
	public void initiatePageCopieDeCalendrier(){
		
		this.commonPrefix = getLongestCommonPrefix(allElementsWithIds);
		
		this.inputField = driver.findElement(By.id(this.commonPrefix+"45"));
		
		this.titre = driver.findElement(By.id(this.commonPrefix+"s4-cnt"));
		
		this.type = driver.findElement(By.id(this.commonPrefix+"85"));
		
		this.boutonEnregistrer = driver.findElement(By.xpath("//*[@id='"+this.commonPrefix+"z7-box']/descendant::td[text()='Enregistrer']"));
		
		this.boutonEnregistrerEtContinuer = driver.findElement(By.xpath("//*[@id='"+this.commonPrefix+"_8-box']/descendant::td[text()='Enregistrer et continuer']"));
		
	}

}
