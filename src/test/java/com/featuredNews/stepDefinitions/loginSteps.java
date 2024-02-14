package com.featuredNews.stepDefinitions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.featuredNews.factory.helperClass;
import com.featuredNews.pageObjects.BasePage;
import com.featuredNews.pageObjects.loginPage;
import com.featuredNews.pageObjects.userInformationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {
    
	WebDriver driver;
	String userEmail= helperClass.getProperties().getProperty("username");
	String userPassword= helperClass.getProperties().getProperty("password");
	String name=helperClass.getProperties().getProperty("accountName");
	
	String actualUsername;
	String actualUserid;
	loginPage lp;
	userInformationPage up = new userInformationPage(helperClass.getDriver());
	
	@Given("User navigate to be.cognizant portal")
	public void User_navigate_to_be_cognizant_portal() {    
		lp = new loginPage(helperClass.getDriver());			//Initializing login page object using webdriver obtained from BaseClass
	}
	
	@When("User enters the valid Username and click on Next button")
	public void user_enters_the_valid_username_and_click_on_next_button() {
		try {
				    
			lp.setUsername(helperClass.decode(userEmail));
			lp.clickNext();
			
		}
		catch(Exception e) {
			
		}
	    
	}

	@When("User enters the valid Password and Click on the signin button")
	public void user_enters_the_valid_password_and_click_on_the_signin_button() {
		try {
			lp.setPassword(helperClass.decode(userPassword));
			lp.clickSignin();
			
		}
		catch(Exception e) {
			
		}
	}
	
	@When("User enters the authentication code")
	public void User_enters_the_authentication_code() {
		try {
			lp.staySignedIn();			
		}
		catch(Exception e){
			
		}
	}
	
	
	@Then("User should be redirected to be cognizant page")
	public void User_should_be_redirected_to_be_cognizant_page() {
		try {
			String portalName= lp.pageTittle();
		    Assert.assertEquals("be.cognizant", portalName);
		    System.out.println("------Successfully Navigated to Be.cognizant Portal------");
		}
		catch(Exception e){
			
		}

	}


	@When("User click on Account manager icon")
	public void User_click_on_Account_manager_icon() throws InterruptedException {
		up.clickAccountIcon();
	    
	}

	@When("Capture the user information from Account manager frame")
	public void capture_the_user_information_from_account_manager_frame() {
		actualUsername=up.getAccountUsername(); 
	    actualUserid= up.getAccountUserEmail();
	    
	    //Displaying user information in console
		System.out.println("User Information: ");
		System.out.println("Username: "+actualUsername);
		System.out.println("Userid: "+actualUserid);
		
	}
	
	
	// verifying the user information
	@Then("Verify the user information with username and userid")
	public void Verify_the_user_information_with_username_and_userid () {
		try {
			Assert.assertEquals(actualUsername,name);
			Assert.assertEquals(actualUserid,helperClass.decode(userEmail));
			System.out.println("The user information is valid");
		}
		catch(Exception e) {
			System.out.println("The user information is invalid");
		}
		
	}
	
}
