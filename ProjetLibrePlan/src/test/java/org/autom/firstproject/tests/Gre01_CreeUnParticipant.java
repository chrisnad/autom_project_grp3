package org.autom.firstproject.tests;

import static org.junit.Assert.assertEquals;

import org.autom.firstproject.pageobject.karim.CreationParticipant;
import org.autom.firstproject.pageobject.karim.LoginPage;
import org.autom.firstproject.pageobject.karim.MenuPage;
import org.autom.firstproject.pageobject.karim.PagePerso;
import org.autom.firstproject.pageobject.karim.RessourcesParticipants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Gre01_CreeUnParticipant {
	
	WebDriver driver;
	
	@Before
	public void Init() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://localhost:8180/libreplan/common/layout/login.zul");

		LoginPage page = PageFactory.initElements(driver, LoginPage.class);
		page.ConnexionLoginPage("admin", "admin");
				
		assertEquals("Accèder à LibrePlan", "http://localhost:8180/libreplan/planner/index.zul",
				driver.getCurrentUrl());
	}
	
	/*
	@Test
	public void accesCalendrier() {
		MenuPage calendrier = PageFactory.initElements(driver, MenuPage.class);
		calendrier.cliquerBtnCalendrier();
		assertEquals("Accèder au Menu Calendrier", "http://localhost:8180/libreplan/calendars/calendars.zul", driver.getCurrentUrl());
		
		RessourcesCalendrier cal = PageFactory.initElements(driver, RessourcesCalendrier.class);
		String liste = cal.accesCalendrier();
		assertEquals("Texte visible liste calendriers", "Liste de calendriers", liste);
	}*/
	
	@Test
	public void creerNouvelUtilisateur() {
		MenuPage participant = PageFactory.initElements(driver, MenuPage.class);
		participant.cliquerBtnParticipants();
		
		RessourcesParticipants part = PageFactory.initElements(driver, RessourcesParticipants.class);
		String listepart = part.listeParticipants();
		part.rechercheCriteresTableau("Surnom");
		assertEquals("Texte visible liste participants", "Liste des participants", listepart);
		
		part.cliquerBtnCreerParticipant();
				
		CreationParticipant part1 = PageFactory.initElements(driver, CreationParticipant.class);
		String textdefault = part1.ongletDonneesPerso();
		assertEquals("Texte onglet par défaut", "Données personnelles", textdefault);
		part1.creerParticipants("Toto", "TUTU", "Tata");
		
		RessourcesParticipants partToto = PageFactory.initElements(driver, RessourcesParticipants.class);
		String message = partToto.participantCree();
		assertEquals("Texte visible participant créé", "Participant enregistré", message);
		partToto.rechercherCritere("TUTU");
		partToto.cliquerBtnCreerParticipant();
		
		CreationParticipant part2 = PageFactory.initElements(driver, CreationParticipant.class);
		part2.creerParticipants2("Jean", "DU", "jdu", "jdu", "$jdumdp1", "jdu@test.fr");
		
		RessourcesParticipants partJean = PageFactory.initElements(driver, RessourcesParticipants.class);
		String message1 = partJean.participantCree();
		assertEquals("Texte visible participant créé", "Participant enregistré", message1);
		partJean.rechercherCritere("DU");
		partJean.champsDetail("jdu");
		partJean.clicPlusDOption();
		
		LoginPage page = PageFactory.initElements(driver, LoginPage.class);
		page.ConnexionLoginPage("jdu", "$jdumdp1");
		
		PagePerso partJeanDU = PageFactory.initElements(driver, PagePerso.class);
		String accueilPagePerso = partJeanDU.pagePerso();
		assertEquals("Vérifier texte page Accueil", "Mon tableau de bord", accueilPagePerso);
		String accueilPagePerso2 = partJeanDU.pagePerso2();
		assertEquals("Vérifier texte page Accueil", "utilisateur: jdu", accueilPagePerso2);
		
	}
	
	@After
	public void deconnect() {
		//driver.quit();
	}
	
}
