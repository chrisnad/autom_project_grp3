package org.autom.firstproject.pageobject.max;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PageProfil_Assert_Methode {
	
	protected final WebDriver driver;
	
	//============================================================================================================================//
	//======================================================= Assert_Equals =======================================================//
	@FindBy(xpath= "//*[contains(@id, '4-cave')]")
	private WebElement tableauForNameAction;

	@FindBy(xpath="//td[@class='z-button-cm'][contains(text(),'Créer')]") 
	private WebElement createButton;
	
	@FindBy(xpath="//span[@class='z-tab-text']") 
	private WebElement DatabaseProfilText;

	//@FindBy(xpath="//span[@class='z-label'][contains(text(),'Nom')]")
	@FindBy(xpath="//div/span[@class='z-label'][contains(text(),'Nom')][contains(@id,'95')]")
	private WebElement Textname;
	
	@FindBy(xpath="//div/input") 
	private WebElement NameForWrite;
	
	@FindBy(xpath="//Span[contains(text(),'Association avec les rôles')]") 
	private WebElement AssociateRole;
	
	@FindBy(xpath="//input[@autocomplete='off']") 
	private WebElement FieldRole;
	
	@FindBy(xpath="//td[@class='z-button-cm'][contains(text(),'Ajouter un rôle')]") 
	private WebElement AddRole;
	
	@FindBy(xpath="//div[@class='z-column-cnt'][contains(text(),'Nom du rôle')]") 
	private WebElement TextNameRole;
	
	@FindBy(xpath="//th/div[@class='z-column-cnt'][contains(text(),'Actions')][contains(@id,'5-cave')]")
	private WebElement TextAction;

	@FindBy(xpath="//td[@class='z-button-cm'][contains(text(),'Enregistrer')]") 
	private WebElement ButtonRegister;
	
	@FindBy(xpath="//td[contains(text(),'Sauver et continuer')]") 
	private WebElement ButtonSave;
	
	@FindBy(xpath="//td[contains(text(),'Annuler')]") 
	private WebElement ButtonCancel;
	
	@FindBy(xpath="//span[contains(text(),'Super utilisateur')]") 
	private WebElement SuperUser;
	
	@FindBy(xpath="//*[text()='Super utilisateur']/following::span[@class='icono z-button']") 
	private WebElement TrashImage;
	
	@FindBy(xpath="//tbody[contains(@id,'47')]")
	private WebElement TabAddRole;
	
	@FindBy(xpath="//div[@class = 'z-window-embedded-header'][contains(text(),'Profils Liste')]") 
	private WebElement profil;
	
	@FindBy(xpath="//span[@class='z-label'][contains(text(),'Profil \"Nom\" enregistré')]") 
	private WebElement InfoBubble;
	
	@FindBy(xpath="//*[contains(@id, 'p4')]") 
	private WebElement NewTabProfil;
	
	@FindBy(xpath="//td[contains(text(),'Modifier Profil: ')]")
	private WebElement ModifProfil;
	
	@FindBy(xpath="//td/i/input") 
	private WebElement WriteAssociateRole;
	
	@FindBy(xpath="//span[@class='z-label'][contains(text(),'Profil \"coucou\" enregistré')]") 
	private WebElement InfoBubbleFinal;
//============================================================================================================================//
//======================================================= CONSTRUCTEUR =======================================================//
	
	public PageProfil_Assert_Methode(WebDriver driver) {
		super();
		this.driver = driver;
	}	
	
//============================================================================================================================//
//====================================================== LISTE METHODES ======================================================//
	
	// Méthode 00 : Exemple
	
//============================================================================================================================//
//========================================================= METHODES =========================================================//
	
	public List<WebElement> tableau() {
		List<WebElement> list = tableauForNameAction.findElements(By.xpath("/div[@class='z-column-sort-img']/.."));
		return list;
	}
	
	public String recup_button() {
		return createButton.getText();
	}
	public String recup_Title() {
		return driver.findElement(By.xpath("//td[@class='z-caption-l']")).getText();
	}
	
	public String dataBaseProfil() {
		return DatabaseProfilText.getText();
	}
	
	public String Recup_TextName() {
		return Textname.getText();
	}
	
	public String writeInName() {
		return NameForWrite.getText();
	}
	
	public String FieldEmpty() {
		return FieldRole.getText();
	}
	
	public String AddNewRole() {
		return AddRole.getText();
	}
	
	public List<WebElement> tab_Name_Role() {
		List<WebElement> list = tableauForNameAction.findElements(By.xpath("/div[@class='z-column-sort-img']/.."));
		return list;
	}
	
	public String Recup_TextName_Role() {
		return TextNameRole.getText();
	}
	
	public String Recup_Text_Action() {
		return TextAction.getText();
	}
	
	public String Recup_Text_Register() {
		return ButtonRegister.getText();
	}
	
	public String Recup_Text_Save_Continue() {
		return ButtonSave.getText();
	}
	
	public String Recup_Text_Cancel() {
		return ButtonCancel.getText();
	}
	public String Recup_Text_Super_User() {
		return SuperUser.getText();
	}
	
	public Boolean Recup_Trash_Icon() {
		Boolean b = TrashImage.isEnabled();
		return b;
	}
	
	public String Recup_Text_Delete() {
		return TrashImage.getAttribute("title");
	}
	public List<WebElement> TabRoles() {
		List<WebElement> list = tableauForNameAction.findElements(By.xpath("//*[contains(@id,'g5')]/descendant::span[text()!='']"));
		return list;
	}
	public String VerifTitle() {
		return profil.getText();
	}
	
	public String Recup_Info_Bubble() {
		return InfoBubble.getText();
	}
	
	public List<WebElement> NewTabRoles() {
		List<WebElement> list = NewTabProfil.findElements(By.xpath("//*[contains(@id,'j4-cave')]/descendant::span[@class='z-label'][text()!='']"));
		return list;
	}
	
	public String Verif_Modif_Name() {
		return ModifProfil.getText();
	}
	public String Verif_Assoc_Role() {
		return WriteAssociateRole.getText();
	}
	
	public String Recup_Info_Bubble_Final() {
		return InfoBubbleFinal.getText();
	}
	// Maxime peut écrire ses méthodes ici !
	
}
