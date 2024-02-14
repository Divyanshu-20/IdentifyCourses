package com.featuredNews.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends BasePage {
	
	//constructor
	public loginPage(WebDriver driver) {
		super(driver);						//calling constructor of parent class "BasePage"
	}
	
	//Locators for elements in the login page
	By textEmail = By.id("i0116");									//Locator for the username input field
	By nextButton = By.id("idSIButton9");							//Locator for Next button
	By textPassword = By.id("i0118");								//Locator for the password input field
	By signInButton = By.xpath("//input[@value='Sign in']");		//Locator for the Sign In button
	By checkBox = By.id("KmsiCheckboxField");						//Locator for "Stay Signed In" checkbox
	By portalTitleName = By.xpath("//*[text()='be.cognizant']");	//Locator for the Portal title
	
	//Set the username in username input field
	public void setUsername(String email) {

			driver.findElement(textEmail).sendKeys(email);
	}
	
	//Click on Next Button
	public void clickNext() {
			driver.findElement(nextButton).click();
	}
	
	//Set the password in Password input field
	public void setPassword(String password) {
			driver.findElement(textPassword).sendKeys(password);		
	}
	
	//Click on SignIn button
	public void clickSignin() {
			driver.findElement(signInButton).click();
	}
	
	//Below code is to Wait until stay signed in page is displayed and click on Yes Button
	public void staySignedIn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkBox));
		driver.findElement(nextButton).click();
	}
	
	//Get the title of be.cognizant Home page
	public String pageTittle() {
		return (driver.findElement(portalTitleName).getText());    //Get the title of portal and return it
	}
	

}
