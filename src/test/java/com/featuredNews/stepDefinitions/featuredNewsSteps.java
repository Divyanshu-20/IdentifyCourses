package com.featuredNews.stepDefinitions;

import com.featuredNews.factory.helperClass;
import com.featuredNews.pageObjects.featuredNewsPage;
import com.featuredNews.pageObjects.loginPage;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class featuredNewsSteps {
	
	String userEmail= helperClass.getProperties().getProperty("username");         //getting username retrieved from properties file using BaseClass
	String userPassword= helperClass.getProperties().getProperty("password");		 //getting password retrieved from properties file using BaseClass
	loginPage lp;
	
	featuredNewsPage ns=new featuredNewsPage(helperClass.getDriver());          //Initializing "featuredNewsPage" page object
	
	@Given("User navigate to be.cognizant page")
	public void User_navigate_to_be_cognizant_portal() {
	    
		lp = new loginPage(helperClass.getDriver());					//Initializing login page object using webDriver obtained from BaseClass
		
	}
	
	@Given("Featured news section should be displayed on Be.cognizant homepage")
	public void featured_news_section_should_be_displayed_on_be_cognizant_homepage() {
			ns.checkNewsBlock();			//Calling a method from "featuredNewsPage" class to check if the featured news block is displayed.
			
	}

	@When("Print count of total number of featured news displayed on Be.cognizant homepage")
	public void print_count_of_total_number_of_featured_news_displayed_on_be_cognizant_homepage() {
			ns.displayCount();			   //Calling a method from "featuredNewsPage" class to display count of featured news
		
	}

	@When("Print the news title of all featured news displayed on Be.cognizant homepage")
	public void print_the_news_title_of_all_featured_news_displayed_on_be_cognizant_homepage() throws IOException {
		ns.displayNewsHeading();		  //Calling a method from "featuredNewsPage" class to display featured news titles
	}

	@Then("Verify tooltip with respective news title for each featured news of be.cognizant homepage.")
	public void verify_tooltip_with_respective_news_title_for_each_featured_news_of_be_cognizant_homepage() {
		ns.verifyTooltip();				 //Calling a method from "featuredNewsPage" class to verify tooltips for each featured news
	}
	
	
	@When("Print the information inside each News")
	public void print_the_information_inside_each_news() throws IOException, InterruptedException {
		ns.getNewsInformation();		//Calling a method from "featuredNewsPage" class to fetch information from each news
	}
		
	@Then("Verify the apps under Apps and Tools are displayed on Be.cognizant homepage.")
	public void verify_the_apps_under_apps_and_tools_are_displayed_on_be_cognizant_homepage() {
		boolean appsDisplay = ns.checkApps();			//Calling a method to check if apps under "Apps and Tools" are displayed
		try {
		    Assert.assertEquals(appsDisplay,true);
		    System.out.println("------Apps and Tools displayed------");
		}
		catch(Exception e) {
				System.out.println("Apps and Tools not displayed");
		}
			System.out.println("\n");
	}

	@When("print all Apps under Apps and Tools Header of Homepage")
	public void print_all_apps_under_apps_and_tools_header_of_homepage() throws IOException {
		ns.displayAllApps();			 //Calling a method from "featuredNewsPage" class to display all apps
	}

}
