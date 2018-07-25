package org.autom.firstproject.pageobject.max;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PageCreateFormQuality {
	

//============================================================================================================================//
//=================================================== ELEMENTS DE LA PAGE ====================================================//
	
	protected final WebDriver driver;
	
	@FindBy(xpath= "//span[@class='create-button global-action z-button']")
	private WebElement buttonCreate;

	@FindBy(xpath="//*[contains(@id,'c5-real')]")
	private WebElement tableau;
	
	@FindBy(xpath="//*[contains(@id,'f6-box')]")
	private WebElement tableauButton;
	
	@FindBy(xpath="//input[contains(@id,'k5')]")
	private WebElement writeInName;
	
	@FindBy(xpath="//textarea[@class='z-textbox']")
	private WebElement writeInDescription;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement checkbox_click;
	
	@FindBy(xpath="//td[@class='z-button-cm'][contains(text(),'Nouvel élément du formulaire qualité')]")
	private WebElement newElementform;
	
	@FindBy(xpath="//input[contains(@id,'86')]")
	private WebElement ListElementName;
	
	@FindBy(xpath="//input[contains(@id,'a6')]")
	private WebElement pourcent;
	
	@FindBy(xpath="//input[@type='text'][@style='width:95%;'][@value='']")
	private WebElement ListElementName2;
	
	@FindBy(xpath="//input[@class='z-decimalbox'][@size='11']")
	private WebElement pourcent2;
	
	@FindBy(xpath="//span[contains(text(),'Formulaire Test 2')]") //rename Test 1
	private WebElement FormTest;
	
	@FindBy(xpath="//select")
	private WebElement forElement;
	
	@FindBy(xpath="//option[contains(text(),'par élément')]")
	private WebElement optionElement;
//============================================================================================================================//
//======================================================= Assert_Equals =======================================================//
	@FindBy(xpath="//*[contains(@id,'c5-real')]/descendant::input[@type='checkbox']") 
	private WebElement CheckBox;
	
	@FindBy(xpath="//td[@class='z-button-cm'][contains(text(),'Enregistrer')]") 
	private WebElement ButtonEnregister;
	
	@FindBy(xpath="//td[@class='z-button-cm'][contains(text(),'Sauver et continuer')]") 
	private WebElement Buttonsave;
	
	@FindBy(xpath="//td[@class='z-button-cm'][contains(text(),'Annuler')]") 
	private WebElement ButtonCancel;
	
	@FindBy(xpath="//td/input") 
	private WebElement Form;
	
	@FindBy(xpath="//td/span[@class='z-button']") 
	private WebElement Button;
	
//============================================================================================================================//
//======================================================= CONSTRUCTEUR =======================================================//
	
	public PageCreateFormQuality(WebDriver driver) {
		super();
		this.driver = driver;
	}	
	
//============================================================================================================================//
//====================================================== LISTE METHODES ======================================================//
	
	// Méthode 00 : Exemple
	
//============================================================================================================================//
//========================================================= METHODES =========================================================//
	
	// Méthode 00 : Exemple
	public void ClickCreate() throws InterruptedException {
		buttonCreate.click();
	}
	public List<WebElement> tableau() {
		List<WebElement> list = tableau.findElements(By.xpath("./descendant::span[@class='z-label']"));
		return list;
	}
	public void writeName () {
		writeInName.sendKeys("Formulaire Test 1");
	}
	
	public void writeDescription() {
			writeInDescription.sendKeys("Formulaire Test 1");
	}
	
	public void clickOnCheckBox() {
		checkbox_click.click();
	}
	public void clickOnNewForm() {
		newElementform.click();
	}
	
	public void writeListName () {
		ListElementName.sendKeys("Formulaire Test 1");
	}
	public void writeListpercent() {
		pourcent.sendKeys("20");
	}
	public void writeDescription2() {
		ListElementName2.sendKeys("Formulaire Test 2");
	}
	public void writeListpercent2() {
		pourcent2.sendKeys("100");
	}
	public void clickSave() {
		Buttonsave.click();
	}
	public void clickCancel() {
		ButtonCancel.click();
	}
	
	public void clickForm() {
		FormTest.click();
	}
	
	public void clickenreg() {
		ButtonEnregister.click();
	}
	public void clickForElement() {
		forElement.click();
		optionElement.click();
	}
	// ASSERT \\
	public Boolean check_CheckBox() {
		Boolean b = CheckBox.isSelected();
		return b;
	}
	public List<WebElement> tableau_Button() {
		List<WebElement> list = tableau.findElements(By.xpath("./descendant::span[@class='z-label']"));
		return list;
	}
	
	
	
	// ASSERT \\
	
	public Boolean check_enregistered() {
		Boolean b;
		if (ButtonEnregister.getText() != null)
			b = true;
		else
			b = false;
		return b;
	}
	public Boolean check_save() {
		Boolean b;
		if (Buttonsave.getText() != null)
			b = true;
		else
			b = false;
		return b;
	}
	public Boolean check_cancel() {
		Boolean b;
		if (ButtonCancel.getText() != null)
			b = true;
		else
			b = false;
		return b;
	}
}
