package common_Features;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Launch_BrowserPage {
	
	static FileInputStream file;
	static Properties prop;
	public static WebDriver driver;
	
	public static String driverlocation;
	public static String url;
	
	public static Logger logfile = Logger.getLogger(Launch_BrowserPage.class);
	
	@BeforeSuite
	public void LoadSysetmProperties() throws IOException {
		
		PropertyConfigurator.configure("log4jProper.properties");
		
		logfile.info("Reading Properties File");
		file = new FileInputStream("Config_File.properties");
		prop=new Properties();
		prop.load(file);
		
		logfile.info("Getting System Properties");
		 driverlocation = prop.getProperty("DriverLocation");
		 url = prop.getProperty("SiteURL");
		 
		Open_Brow();
	}
	
	public void Open_Brow() {
		System.setProperty("webdriver.chrome.driver", driverlocation);
		
		logfile.info("Opening Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		logfile.info("Navigating to OrangeHRM Website");
		driver.navigate().to(url);
	}

	@AfterSuite
	public void Close_Brow() {
		logfile.info("Closing Browser");
		driver.quit();
	}

}
