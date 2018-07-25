package org.autom.firstproject.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.autom.firstproject.pageobject.chris.LoginPage;
import org.autom.firstproject.pageobject.chris.PageCopieDeCalendrier;
import org.autom.firstproject.pageobject.chris.PageCreationDeCalendrier;
import org.autom.firstproject.pageobject.chris.PageDeriveDeCalendrier;
import org.autom.firstproject.pageobject.chris.PageListeCalendriers;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class Cal01_CreeUnCalendriers {
	
	private String dbDriver = "org.postgresql.Driver";
	private String connexionstring = "jdbc:postgresql://localhost:5432/libreplan";
	private String login = "postgres";
	private String password = "admin";
	
	private WebDriver driver;
	private PageCreationDeCalendrier pageCreationDeCalendrier;
	private PageDeriveDeCalendrier pageDeriveDeCalendrier;
	private PageListeCalendriers pageListeCalendriers;
	private PageCopieDeCalendrier pageCopieDeCalendrier;
	
	private String nomCalendrier = "Calendrier - Test 1";
	private String nomCalendrier2 = "Calendrier - Test 2";
	private String nomDeriveCalendrier = "Calendrier - Test Calendrier Dérivé";
	
	
	
	public IDataSet lireFichierXMLDansUnDataset(String cheminSurLeDisque) throws MalformedURLException, DataSetException {
		return new FlatXmlDataSetBuilder().build(new File(cheminSurLeDisque));
	}
	
	public static void DeleteRow(String table, Connection connection)
	{
		try 
		{	
			PreparedStatement st = connection.prepareStatement("DELETE from "+table);
			st.executeUpdate(); 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@Before
	public void initialisationIFrame() throws ClassNotFoundException, SQLException, Exception {
		IDatabaseTester databaseTester = new JdbcDatabaseTester(dbDriver,connexionstring,login,password);
		IDatabaseConnection connection = databaseTester.getConnection();
		IDataSet dataSet = connection.createDataSet();
		FlatXmlDataSet.write(dataSet, new FileOutputStream("etat_initial.xml"));
		connection.close();
		
//		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//		driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().fullscreen();
		driver.get("http://localhost:8180/libreplan/common/layout/login.zul");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.ConnexionLoginPage("admin", "admin");
		pageCreationDeCalendrier = PageFactory.initElements(driver, PageCreationDeCalendrier.class);
		pageDeriveDeCalendrier = PageFactory.initElements(driver, PageDeriveDeCalendrier.class);
		pageListeCalendriers = PageFactory.initElements(driver, PageListeCalendriers.class);
		pageCopieDeCalendrier = PageFactory.initElements(driver, PageCopieDeCalendrier.class);
	}

	@After
	public void fermetureDuNavigateur() throws ClassNotFoundException, Exception{
		/*
		IDatabaseTester databaseTester = new JdbcDatabaseTester(dbDriver,connexionstring,login,password);
		IDatabaseConnection connection = databaseTester.getConnection();
		IDataSet dataSet = connection.createDataSet();
		FlatXmlDataSet.write(dataSet, new FileOutputStream("etat_final.xml"));
		String[] tables = dataSet.getTableNames();
		connection.close();
		
		Connection conn = DriverManager.getConnection(connexionstring, login, password);
		for (String table : tables) {
			DeleteRow(table, conn);
		}
		conn.close();
		
		IDatabaseTester lastDatabaseTester = new JdbcDatabaseTester(dbDriver,connexionstring,login,password);
		IDatabaseConnection connection2 = lastDatabaseTester.getConnection();
		IDataSet dataSet2 = connection2.createDataSet();
		FlatXmlDataSet.write(dataSet2, new FileOutputStream("etat_final2.xml"));
		connection2.close();
		*/
		
//		IDatabaseConnection connection = new JdbcDatabaseTester(dbDriver, connexionstring, login, password).getConnection();
//		IDataSet dataSet = connection.createDataSet();
//		String[] tables = dataSet.getTableNames();
//		List<String> list = new ArrayList<String>(Arrays.asList(tables));
//		list.remove("work_report_type");
//		list.remove("user_table");
//		list.remove("type_of_work_hours");
//		list.remove("profile_table");
//		tables = list.toArray(new String[0]);
//		IDataSet finalDataSet = connection.createDataSet(tables);
//		FlatXmlDataSet.write(finalDataSet, new FileOutputStream("etat_final.xml"));
//		
//	    IDataSet initialDataSet = lireFichierXMLDansUnDataset("etat_initial.xml");
//	    
//		DatabaseOperation.CLEAN_INSERT.execute(connection, initialDataSet);
		
		pageListeCalendriers.supprimerCalendrier(nomCalendrier2);
		pageListeCalendriers.initiatePageListeCalendriers();
		pageListeCalendriers.supprimerCalendrier(nomDeriveCalendrier);
		pageListeCalendriers.initiatePageListeCalendriers();
		pageListeCalendriers.supprimerCalendrier(nomCalendrier);
		//this.driver.quit();
	}
	
	@Test
	public void testListeCalendriersPage() {
		pageCreationDeCalendrier.cliquerRessourcesCalendriers();
		pageCreationDeCalendrier.initiatePageListeCalendriers();
		
		List<WebElement> list = pageCreationDeCalendrier.contenuTableauListeCalendriers();
		String[] listeAttendue = {"Nom","Hérité de la date", "Héritages à jour", "Opérations"};
		
		int count = 0;
		for(WebElement i : list) {
			assertEquals(true, listeAttendue[count].equals(i.getText()));
			count++;
		}
		pageCreationDeCalendrier.cliquerBoutonCreation();
		
		pageCreationDeCalendrier.initiatePageCreationDeCalendrier();
		pageCreationDeCalendrier.enregistrerCalendrier(nomCalendrier);	
		
		pageCreationDeCalendrier.deriveDeCalendrier(nomCalendrier);
		
		pageDeriveDeCalendrier.initiatePageDeriveDeCalendrier();
		pageDeriveDeCalendrier.nommeDeriveDeCalendrier(nomCalendrier);
		pageDeriveDeCalendrier.enregistrerEtContinuer();

		assertEquals("testing the warning message", nomCalendrier + " existe déjà", pageDeriveDeCalendrier.warningMessage().getText());
		
		pageDeriveDeCalendrier.nommeDeriveDeCalendrier(nomDeriveCalendrier);
		
		assertEquals("code box is checked", true, pageDeriveDeCalendrier.codeCheckBox().isSelected());
		
		pageDeriveDeCalendrier.enregistrerEtContinuer();
				
		assertEquals("testing the info message", "Calendrier de base \""+nomDeriveCalendrier+"\" enregistré", pageDeriveDeCalendrier.infoMessage().getText());
		
		pageDeriveDeCalendrier.clickSurAnnuler();
		
		pageListeCalendriers.initiatePageListeCalendriers();
		
		boolean calendarDerivative = false;
		for (WebElement calendrierDerive : pageListeCalendriers.listeCalendriersDerivees(nomCalendrier)) {
			if (calendrierDerive.getText().equals(this.nomDeriveCalendrier)) {
				calendarDerivative = true;
				break;
			}
		}
		assertEquals("testing creation of derivative calendar", true, calendarDerivative);
		
		assertTrue("testing minimization of calendar tree", pageListeCalendriers.cliquerMinimiserCalendrier(nomCalendrier));
		
		pageListeCalendriers.copieDeCalendrier(nomCalendrier);
		
		pageCopieDeCalendrier.initiatePageCopieDeCalendrier();
		assertEquals("testing titre", "Créer Calendrier: " + nomCalendrier, pageCopieDeCalendrier.titre().getText());
		assertEquals("testing type", "Calendrier source", pageCopieDeCalendrier.type());
		
		pageCopieDeCalendrier.enregistrerEtContinuer();
		assertEquals("testing the warning message", nomCalendrier + " existe déjà", pageCopieDeCalendrier.warningMessage().getText());
		
		pageCopieDeCalendrier.nommeCopieDeCalendrier(nomCalendrier2);
		pageCopieDeCalendrier.enregistrerCopieDeCalendrier();
		
		pageListeCalendriers.initiatePageListeCalendriers();
		assertEquals("testing the info message", "Calendrier de base \""+nomCalendrier2+"\" enregistré", pageListeCalendriers.infoMessage().getText());
		boolean calendarDerivative2 = false;
		if (pageListeCalendriers.listeCalendriersDerivees(nomCalendrier2).size() == 0 ||
				pageListeCalendriers.listeCalendriersDerivees(nomCalendrier).size() == 1) {
			calendarDerivative2 = true;
		}
		assertEquals("testing creation of calendar2", true, calendarDerivative2);
	}
}