package com.featuredNews.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//This class serves as a base page for other page classes
public class BasePage {

	 WebDriver driver;
	    
	 //Constructor to initialize BasePage with WebDriver
	 public BasePage(WebDriver driver)
	 {
		this.driver=driver;
		PageFactory.initElements(driver,this);         //Initializing elements using PageFactory
	 }
	   	   
}





