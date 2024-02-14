package com.featuredNews.factory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.Properties;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
 
public class helperClass {
 
static WebDriver driver;
static Properties p;
 
	public  static WebDriver initializeBrowser() throws IOException
	{
		//code to initialize the browser
		if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(getProperties().getProperty("browser").toLowerCase()) 
			{
			case "chrome":
		        driver=new ChromeDriver();					 // Creating a new instance of ChromeDriver
		        break;
		    case "edge":
		    	driver=new EdgeDriver();					 // Creating a new instance of EdgeDriver
		        break;
		    case "firefox":
		    	driver=new FirefoxDriver();                  // Creating a new instance of FirefoxDriver
		    	break;
		    default:
		        System.out.println("No matching browser");
		        driver=null;
			}
		}
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 return driver;					   //returning the driver
	}
	
	
	public static WebDriver getDriver() {
		return driver;                    //returning the driver
	}
 
    public static Properties getProperties() 
    {	
    	try {
    		
    		//creating a FileReader object to read config file
    		FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");      //path of config.properties file
    		p=new Properties();			  //Creating an object for Properties
    		p.load(file);				  //Loading the properties from configuration file
    	}
    	catch(Exception e) {
		    //catch the exception that occur during file reading and loading properties
    	}
    	return p;                        //returning the properties object containing the loaded properties
    }
    
    public static String decode(String s) {
    	byte[] actualByte = Base64.getDecoder().decode(s);	//decoding the encoded string
		String actualString = new String(actualByte);		
		return actualString;								//returning the actual string after decoding
    }
}