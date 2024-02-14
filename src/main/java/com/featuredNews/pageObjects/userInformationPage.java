package com.featuredNews.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class userInformationPage extends BasePage {
	
	//Constructor for userInformationPage class
	public userInformationPage(WebDriver driver) {
		super(driver);			//Call the constructor of the superclass(BasePage)
	}
	
	By accountIcon = By.xpath("//*[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']");           //locator for account Icon element
	By accountUsername = By.id("mectrl_currentAccount_primary");					//locator for account username element
	By accountUserEmail = By.id("mectrl_currentAccount_secondary");					//locator for account user email element
	By settingIcon = By.xpath("//div[@class=\"o365cs-base\"]/span");				//locator for setting icon
	
	//Clicking account manager icon in home page
	public void clickAccountIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));		//create a WebDriverWait object with timeout of 20 seconds
		wait.until(ExpectedConditions.visibilityOfElementLocated(settingIcon));		//wait until the setting icon is visible on home page
		driver.findElement(accountIcon).click();									//click on account manager icon
	}
	
	//Get the username from account manager information
    public String getAccountUsername() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));			//Set implicit wait for 1 minute to ensure the element is present
		return(driver.findElement(accountUsername).getText());						//Get the text of username  and return it
	}
    
    //Get the email from account manager information
    public String getAccountUserEmail() {
		return(driver.findElement(accountUserEmail ).getText());					//Get the text of account user email and return it
	}

}
