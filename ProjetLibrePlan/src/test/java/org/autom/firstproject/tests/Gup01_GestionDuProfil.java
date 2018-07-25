package org.autom.firstproject.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import org.autom.firstproject.pageobject.max.LoginPage;
import org.autom.firstproject.pageobject.max.PageCreateFormQuality;
import org.autom.firstproject.pageobject.max.PageProfil;
import org.autom.firstproject.pageobject.max.PageProfil_Assert_Methode;
import org.autom.firstproject.pageobject.max.PageRessources;


public class Gup01_GestionDuProfil {
	
	WebDriver driver;
	
	/* Variables */
	String login = "admin";
	String mdp = "admin";
	
	@Before
	public void InitialisationiFrame() {
		System.setProperty("webdriver.gecko.driver",  "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8180/libreplan/planner/index.zul");
		driver.manage().window();
	}
	
	/*@Test
	public void ConnexionLoginPageTest() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.ConnexionLoginPage(login, mdp);
	}*/
	
	@Ignore // Test 7
	public void ClickForm() throws InterruptedException {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.ConnexionLoginPage(login, mdp);
		PageRessources pageRessources = PageFactory.initElements(driver, PageRessources.class);
		
		String str = pageRessources.putMouseandClick();
		assertEquals("utilisateur admin trouv�","Formulaires qualit� Liste", str);
		
		str = pageRessources.verifName();
		System.out.println("str n 1" +str);
		assertEquals("utilisateur admin trouv�", "Nom", str);
		
		str = pageRessources.verifDescription();
		assertEquals("utilisateur admin trouv�", "Description", str);
		
		str = pageRessources.verifOperation();
		assertEquals("utilisateur admin trouv�", "Op�rations", str);
		
		Boolean b  = pageRessources.verifForm();
		assertEquals("utilisateur admin trouv�", true, b);
		
		b = pageRessources.verifButton();
		assertEquals("utilisateur admin trouv�", true, b);
		
		b = pageRessources.verifButtonCreate();
		assertEquals("utilisateur admin trouv�", true, b);
	}
	@Ignore // Test 7
	public void ClickCreate() throws InterruptedException {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.ConnexionLoginPage(login, mdp);
		PageRessources pageRessources = PageFactory.initElements(driver, PageRessources.class);
		pageRessources.putMouseandClick();
		PageCreateFormQuality Pcfq = PageFactory.initElements(driver, PageCreateFormQuality.class);
		Pcfq.ClickCreate();
		
		String verif[] = {"Nom","Description", "Type de formulaire qualit�","Avancement du rapport"};
		
		List<WebElement> list = Pcfq.tableau();
		
		int j = 0;
		for(WebElement i : list) {
			assertEquals(true, verif[j].equals(i.getText()));
			j++;
		}
		Boolean b = Pcfq.check_CheckBox();
		 assertEquals("utilisadmin trouv�", false	, b);
		 
		 b = Pcfq.check_enregistered();
		 assertEquals("utilisate                 ur admin trouv�", true, b);
		 b = Pcfq.check_save();
		 assertEquals("utilisfzefzeur admin trouv�", true, b);
		 b = Pcfq.check_cancel();
		 assertEquals("utilisfzefzeur admin trouv�", true, b);
	}
	
	@Ignore	// Test 7
	public void CreateForm() throws InterruptedException {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.ConnexionLoginPage(login, mdp);
		PageRessources pageRessources = PageFactory.initElements(driver, PageRessources.class);
		pageRessources.putMouseandClick();
		PageCreateFormQuality Pcfq = PageFactory.initElements(driver, PageCreateFormQuality.class);
		Pcfq.ClickCreate();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Pcfq.writeName();
		Pcfq.writeDescription();
		Pcfq.clickOnCheckBox();
		Pcfq.clickOnNewForm();
		Pcfq.writeListName();
		Pcfq.writeListpercent();
		Pcfq.clickOnNewForm();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Pcfq.writeDescription2();
		Pcfq.writeListpercent2();
		//Pcfq.clickForElement();	
		Pcfq.clickSave();
		//Pcfq.clickCancel();
		//Pcfq.clickForm();
	}
	@Test // Test 8
	public void PageProfilEnter() throws InterruptedException {
		int i = 0;
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.ConnexionLoginPage(login, mdp);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		PageProfil pageProfil = PageFactory.initElements(driver, PageProfil.class);
		String str = pageProfil.putMouseandClick();
		assertEquals("utilisateur admin trouv�","Profils Liste", str);
		PageProfil_Assert_Methode pageProfilAssert =  PageFactory.initElements(driver, PageProfil_Assert_Methode.class);
		
		// ASSERT \\
		List<WebElement> list = pageProfilAssert.tableau();
		String verif[] = {"Nom","Action"};
		int j = 0;
		for(WebElement l : list) {
			assertEquals(true, verif[j].equals(l.getText()));
			j++;
		}
		String buttonCreate = pageProfilAssert.recup_button();
		assertEquals("utilisateur admin trouv�", "Cr�er", buttonCreate);
		// Fin ASSERT \\
		
		pageProfil.clickCreateButton();
		
		// ASSERT \\
		str = pageProfilAssert.recup_Title();
		assertEquals("utilisateur admin trouv�","Cr�er Profil", str);
		str = pageProfilAssert.dataBaseProfil();
		assertEquals("utilisateur admin trouv�","Donn�es de profil", str);
		str = pageProfilAssert.Recup_TextName();
		assertEquals("utilisateur admin trouv�","Nom", str);
		str = pageProfilAssert.writeInName();
		assertEquals("utilisateur admin trouv�","", str);
		str = pageProfilAssert.FieldEmpty();
		assertEquals("utilisateur admin trouv�","", str);
		str = pageProfilAssert.AddNewRole();
		assertEquals("utilisateur admin trouv�","Ajouter un r�le", str);
		str = pageProfilAssert.Recup_TextName_Role();
		assertEquals("utilisateur admin trouv�","Nom du r�le", str);
		str = pageProfilAssert.Recup_Text_Action();
		assertEquals("utilisateur admin trouv�","Actions", str);
		str = pageProfilAssert.Recup_Text_Register();
		assertEquals("utilisateur admin trouv�","Enregistrer", str);
		str = pageProfilAssert.Recup_Text_Save_Continue();
		assertEquals("utilisateur admin trouv�","Sauver et continuer", str);
		str = pageProfilAssert.Recup_Text_Cancel();
		assertEquals("utilisateur admin trouv�","Annuler", str);
		// Fin ASSERT \\



		pageProfil.writeName();
		
		// ASSERT \\
		str = pageProfilAssert.Recup_Text_Super_User();
		assertEquals("utilisateur admin trouv�","Super utilisateur", str);
		Boolean b = pageProfilAssert.Recup_Trash_Icon();
		 assertEquals("utilisfzefzeur admin trouv�", true, b);
		 // FIN ASSERT \\
		 
		
		pageProfil.mouseOverBin();
		
		// ASSERT \\
		str = pageProfilAssert.Recup_Text_Delete();
		assertEquals("utilisateur admin trouv�","Supprimer", str);
		// FIN ASSERT \\

		
		while (i <= 3) {
			pageProfil.AddmultProfile();
			i++;
		}
		
		// ASSERT \\
		List<WebElement> listRole = pageProfilAssert.TabRoles();
		String verifRole[] = {"Canevas", "Profils", "Crit�re", "Super utilisateur"};
		j = 0;
		for(WebElement l : listRole) {
			assertEquals(true, verifRole[j].equals(l.getText()));
			j++;
		}
		// Fin ASSERT \\
		
		pageProfil.clickEraseAll();
		
		// ASSERT \\
		List<WebElement> listRoleAfterErased = pageProfilAssert.TabRoles();
		String verifRoleAfterErased[] = {"Profils", "Crit�re", "Super utilisateur"};
		j = 0;
		for(WebElement l : listRoleAfterErased) {
			assertEquals(true, verifRoleAfterErased[j].equals(l.getText()));
			j++;
		}
		// Fin ASSERT \\
		
		while (i >= 2) {
			pageProfil.clickEraseAll();
			i--;
		}
		
		// ASSERT \\
		List<WebElement> listRoleAfterErasedAll = pageProfilAssert.TabRoles();
		String verifRoleAfterErasedAll[] = {"Profils", "Canevas", "Crit�re", "Super utilisateur"};
		j = 0;
		for(WebElement l : listRoleAfterErasedAll) {
			assertEquals(false, verifRoleAfterErasedAll[j].equals(l.getText()));
			j++;
		}
		// Fin ASSERT \\
		
		pageProfil.clickRegisterButton();
		
		// ASSERT \\
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		str = pageProfilAssert.VerifTitle();
		assertEquals("utilisateur admin trouv�","Profils Liste", str);
		str = pageProfilAssert.Recup_Info_Bubble();
		assertEquals("utilisateur admin trouv�","Profil \"Nom\" enregistr�", str);
		List<WebElement> listRoleAfterNewProfil = pageProfilAssert.NewTabRoles();
		String verifRoleAfterNewProfil[] = {"Hots", "Nom", "Outsourcing Manager", "Project Manager", "Reports Responsible"};
		j = 0;
		for(WebElement l : listRoleAfterNewProfil) {
			assertEquals(true, verifRoleAfterNewProfil[j].equals(l.getText()));
			j++;
		}
		// Fin ASSERT \\
		
		pageProfil.clickModifButton();

		// ASSERT \\
		str = pageProfilAssert.Verif_Modif_Name();
		assertEquals("utilisateur admin trouv�","Modifier Profil: Nom", str);
		str = pageProfilAssert.Verif_Assoc_Role();
		assertEquals("utilisateur admin trouv�","", str);
		// Fin ASSERT \\
		
		while (i <= 3) {
			pageProfil.AddmultProfile();
			i++;
		}
		pageProfil.writeName();
		
		//ASSERT \\
		listRoleAfterErased = pageProfilAssert.TabRoles();
		//List<WebElement> verifLastProfil[] = {"Profils", "Canevas", "Crit�re", "Super utilisateur"};
		j = 0;
		for(WebElement l : list) {
			assertEquals(true, verif[j].equals(l.getText()));
			j++;
		}
		// Fin ASSERT \\
		
		pageProfil.rename();
		pageProfil.clickRegisterButton();
		
		str = pageProfilAssert.VerifTitle();
		assertEquals("utilisateur admin trouv�","Profils Liste", str);
		str = pageProfilAssert.Recup_Info_Bubble_Final();
		assertEquals("utilisateur admin trouv�","Profil \"coucou\" enregistr�", str);
		List<WebElement> listRoleAfterNewProfils = pageProfilAssert.NewTabRoles();
		String verifRoleAfterNewProfils[] = {"coucou", "Hots", "Outsourcing Manager", "Project Manager", "Reports Responsible"};
		j = 0;
		for(WebElement l : listRoleAfterNewProfils) {
			assertEquals(true, verifRoleAfterNewProfils[j].equals(l.getText()));
			j++;
		}
		pageProfil.click_Reset();
	}
}
