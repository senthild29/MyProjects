package common_Functions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import okio.Timeout;
import sun.util.logging.resources.logging;

public class Launch_WebPage {
	
	public static FileInputStream fileinput;
	public static Properties prop;
	public static WebDriver driver;
	
	static Logger log = Logger.getLogger(Launch_WebPage.class);
	
	public void ReadPropertiesFile() throws IOException {
		PropertyConfigurator.configure("log4jpro.properties");
		fileinput = new FileInputStream("ConfigFile.properties");
		prop =new Properties();		
		prop.load(fileinput);
	}
	
	@BeforeSuite
	public void Open_Brow() throws IOException {
		
		
		
		ReadPropertiesFile();
		
				
		String driverLoc = prop.getProperty("DriverLocation");
		String browser = prop.getProperty("Browser");
		String url = prop.getProperty("SiteURL");
		
		log.info("Launching Browser");	
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverLoc);
			driver = new ChromeDriver();
			driver.navigate().to(url);
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", driverLoc);
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void Close_Brow() {
		log.info("Closing Browser");	
		driver.quit();
	}

}
