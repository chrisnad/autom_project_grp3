package org.autom.firstproject.pageobject.chris;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageDeriveDeCalendrier extends PageListeCalendriers{
	
	@FindBy(xpath="//*[@id][not(name()='iframe')]")
	private List<WebElement> allElementsWithIds;
	
	private WebElement inputField;
	
	private WebElement boutonEnregistrer;
	
	private WebElement boutonEnregistrerEtContinuer;
	
	private WebElement boutonAnnuler;
	
	private WebElement warningMessage;
	
	private WebElement infoMessage;

	private WebElement codeCheckBox;

    private String commonPrefix;


	public PageDeriveDeCalendrier(WebDriver driver) {
		super(driver);
	}
	
	public void nommeDeriveDeCalendrier(String nomCalendrier) {
		this.inputField.clear();
		this.inputField.sendKeys(nomCalendrier);
	}
	
	public void enregistrerDeriveDeCalendrier() {
		this.boutonEnregistrer.click();
	}
	
	public void enregistrerEtContinuer() {
		this.boutonEnregistrerEtContinuer.click();
	}
	
	public void clickSurAnnuler() {
		this.boutonAnnuler.click();
	}
	
	public WebElement infoMessage() {
		this.infoMessage = driver.findElement(By.xpath("//span[parent::div[@class='message_INFO']]"));
		return this.infoMessage;
	}
	
	public WebElement warningMessage() {
		this.warningMessage = driver.findElement(By.xpath("//span[parent::div[@class='message_WARNING']]"));
		return this.warningMessage;
	}
	
	public WebElement codeCheckBox() {
		this.codeCheckBox = driver.findElement(By.xpath("//*[@id='"+this.commonPrefix+"d5-real']"));
		return this.codeCheckBox;
	}
	
	public void initiatePageDeriveDeCalendrier(){
		
		this.commonPrefix = getLongestCommonPrefix(allElementsWithIds);
		
		this.inputField = driver.findElement(By.id(this.commonPrefix+"45"));
		
		this.boutonEnregistrer = driver.findElement(By.xpath("//*[@id='"+this.commonPrefix+"z7-box']/descendant::td[text()='Enregistrer']"));
		
		this.boutonEnregistrerEtContinuer = driver.findElement(By.xpath("//*[@id='"+this.commonPrefix+"_8-box']/descendant::td[text()='Enregistrer et continuer']"));
		
		this.boutonAnnuler = driver.findElement(By.xpath("//*[@id='"+this.commonPrefix+"08-box']/descendant::td[text()='Annuler']"));
	}

}
