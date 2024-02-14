package com.featuredNews.pageObjects;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.featuredNews.factory.helperClass;
import com.featuredNews.pageObjects.Locators;
import com.featuredNews.utils.excelUtils;

public class featuredNewsPage extends BasePage {
	
	public featuredNewsPage(WebDriver driver) {
		super(driver);							//calling constructor of parent class "BasePage"
	}
	
	//locating and storing scroll to news element in "scrollNews"
	@FindBy(xpath="(//div[@class='ar_i_658c9e0a']//span[@id='CaptionElementView'])[1]")
	WebElement scrollNews;
	
	//locating and storing newsBlock element in "newsSection"
	@FindBy(xpath = "//*[@data-automation-id='CanvasControl' and @id='4f7e87d5-f184-4501-8008-0ee4b0a38fcf']")
	WebElement newsSection;
	
	//locating and storing list of featured news in "newsList"
	@FindBy(xpath = "//div[@role='listitem' and @class='e_a_37591358 q_a_37591358']")    
	List<WebElement> newsList;
	
	//locating and storing all featured news Tooltip in "toolTip"
	@FindBy(xpath = "//div[contains(@class,'newsItem__hero')]//a")
	List<WebElement> toolTips;
	
	//locating and storing all featured news links in "newsLink"
	@FindBy(id="news_text_title")
	List<WebElement> newsLink;
	
	//locating and storing all featured news title in "newsTitle"
	@FindBy(id="title_text")
	WebElement newsTitle;
	
	//locating and storing all featured news information in "newsText"
	@FindBy(xpath="//div[@data-sp-feature-tag='Rich Text Editor']")
	List<WebElement> newsText;
	
	//locating and storing portal name in "portalTitle"
	@FindBy(xpath="//a[@name='be.cognizant']")
	WebElement portalTitle;
	
	//locating and storing appsblock element in "apps"
	@FindBy(xpath="//div[@id='vpc_WebPart.QuickLinksWebPart.internal.89c5ffca-2ffb-4052-a723-e99c8c9a14ef']")
	WebElement apps; 
	
	//locating and storing apps and Tools title in "appsAndToolsTitle"
	@FindBy(xpath="//div[@id='vpc_WebPart.QuickLinksWebPart.internal.89c5ffca-2ffb-4052-a723-e99c8c9a14ef']//span[@id='CaptionElementView']")
	WebElement appsAndToolsTitle;
	
	@FindBy(xpath="//*[@id='5d7d4eec-cbe0-4c55-ae2e-f38d926d82a0']/div/div/div/p/span/strong")
	WebElement scrollApps;
	
	//locating and storing list of apps and tools in "appsList"
	@FindBy(xpath="((//*[@class='ControlZone--control'])[6]//div[@id='QuicklinksItemTitle'])")
	List<WebElement> appsList;
	
	String fileName=System.getProperty("user.dir")+"/src/test/resources/newsData.xlsx"; //storing the path of excel file in "fileName"
	
	Locators loc=new Locators(helperClass.getDriver());  				//creating an instance for locators 
	
	
	//verifying news block is displayed on home page or not
	public void checkNewsBlock() {
	try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scrollNews); 	//scrolling home page upto announcements title
		
		boolean news=newsSection.isDisplayed();
		Assert.assertTrue(news);
	    System.out.println("------NEWS BLOCK DISPLAYED------");
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	//printing count of each featured news in console and excel sheet
	public void displayCount(){
		int newsCount=newsList.size();
		String sizeOfNews=Integer.toString(newsCount);          		//converting integer to String
		System.out.println("\nNumber of featured news displayed on Be.cognizant homepage: "+newsCount);		//displaying count of news
		try {
			excelUtils.setCellData(fileName,"Sheet1",1,0,sizeOfNews);
		}
		catch(Exception e){
			//Handle any IO exceptions
		}

	}
	
	
	//printing titles of each featured news in console and excel sheet
	public void displayNewsHeading() throws IOException {
		
		loc.Explicit("//div[@role='listitem' and @class='e_a_37591358 q_a_37591358']");// using explicit wait by calling locators class
		System.out.println("\nNews Headings are:");
		for(int i=0;i<newsList.size();i++) {

			String headings=newsList.get(i).getText();
			System.out.println("News Heading-"+(i+1));
			System.out.println(headings);									//printing news titles in console
				
			excelUtils.setCellData(fileName,"Sheet1",i+1,1,headings);		//sending news title to excel file

		}
		System.out.println();
	}
	
	
	//verifying each featured news title with tooltip 
	public void verifyTooltip() {		
	    for(int i=0;i<toolTips.size();i++)
	    {	    	
	    	String headline=toolTips.get(i).getText();       		 //storing title of news in "headline"
			String tooltip=toolTips.get(i).getAttribute("title");	 //storing toolTip of news in "tooltip"
	
	    	try {
	    	    Assert.assertEquals(headline,tooltip);           	 //validating title with toolTip for each featured news
	    		System.out.println("News"+(i+1)+" Headline and Tooltip is matched");
	    	}
	    	catch(Exception e) {
	    		System.out.println("News"+(i+1)+" Headline and Tooltip is not matched");
	    	}
	    }
	    System.out.println();
		
	}
	
	
	//printing each featured news content in console, text file and taking screenshots
	public void getNewsInformation() throws IOException, InterruptedException {
		String content="";
		for(int i=0;i<newsList.size();i++) {
			 String info;
			 newsLink.get(i).click();                                //clicking on each news
			 Thread.sleep(8000);
			
			 String actualNewsTitle=newsTitle .getText();       	 //getting title of each news after clicking on each news
			 String newsTooltip=newsTitle.getAttribute("title");     //getting toolTip of each news after clicking on each news
	         
			 System.out.println("____________________________________________________________________________________________________");

			 Assert.assertEquals(actualNewsTitle, newsTooltip);		//validating title of news with toolTip
			 System.out.println("------Page Header Matches With ToolTip------");
			 
			 System.out.println(actualNewsTitle);					//printing news title in console
			 
			 Thread.sleep(8000);
			 if(newsText.size()==1)
			 {
			 	System.out.println(newsText.get(0).getText()+"\n");
			 	info=newsText.get(0).getText();
				content=content+info;							//adding information of each news into content
				
			 }
			 	else
			 {
			 	for(int j=0;j<newsText.size();j++)
			 	{
			 		System.out.println(newsText.get(j).getText()+"\n");
			 		info=newsText.get(j).getText();
					content=content+info;							//adding information of each news into content	
			 	}
			 
			 }
			 
			//Taking screenshot for each news in "Year-Month-Date-Hours-Minutes-Seconds" format
			 Date d = new Date();
		     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");         //Each screenshot will be taken as this format "Year-Month-Date-Hours-Minutes-Seconds"
			 TakesScreenshot ts=(TakesScreenshot)driver;
	    	 File src=ts.getScreenshotAs(OutputType.FILE);
	         File trg=new File("C:\\Users\\2303771\\eclipse-workspace\\featuredNews_Project\\screenshots\\"+sdf.format(d)+".png");
	         FileUtils.copyFile(src,trg);
			 
	         
	       //Writing news information in text File	
	         FileWriter file = new FileWriter("C:\\Users\\2303771\\eclipse-workspace\\featuredNews_Project\\src\\test\\resources\\newsTextFile.txt");  //create a filewriter object
			 file.write(content);								//Write content to the file
			 file.close();										//close the FileWriter

			 
			//clicking on be.cognizant and verifying it is navigated to be.cognizant page or not
			portalTitle.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			String portalName= portalTitle.getText();;
			Assert.assertEquals("be.cognizant", portalName);
			System.out.println("------Successfully Navigated to Be.cognizant home page------");
			System.out.println("____________________________________________________________________________________________________");
		   		
		   	driver.navigate().refresh();   //refreshing home page
		 
			}
		
	}
	
	
	//Method to verify apps and tools block is displayed or not in home page
	public boolean checkApps() {
		boolean appsAndToolsBlock=false;
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", scrollApps);
		try {
			appsAndToolsBlock=apps.isDisplayed();}
		catch(Exception e){
			
		}
		return appsAndToolsBlock;
		
	}

	
	//printing all apps names under apps and tools section in console and excel sheet
	public void displayAllApps() throws IOException {
		
		//Scrolling the home page till around cognizant element to display all apps
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", scrollApps);
        
        String appsHeading=appsAndToolsTitle.getText();         //Get apps Title and store it in "appsHeading"
	    System.out.println(appsHeading); 
	    int row=1;
		for(WebElement appsTitles : appsList) {			 
			 String appsName=appsTitles .getAttribute("title");
			 System.out.println(appsName);
			 excelUtils.setCellData(fileName,"Sheet1",row,2,appsName);
		     row++;			
		 }

	}
}


