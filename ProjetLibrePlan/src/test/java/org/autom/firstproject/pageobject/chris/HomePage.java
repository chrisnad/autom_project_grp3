package org.autom.firstproject.pageobject.chris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageRessources{
	
	@FindBy(xpath="//div[contains(@id,'Pl3-real')]")
	private WebElement tableauCalendrier;

	public HomePage(WebDriver driver) {
		super(driver);
	}

}
