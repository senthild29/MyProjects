package testCase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import common_Features.Launch_BrowserPage;
import loginpage_Objects.LogoutObj;

public class Logout_Website extends Launch_BrowserPage{
	
	public static Logger logfile = Logger.getLogger(Logout_Website.class);
	
	@Test
	public void Logout_Site() {
		PageFactory.initElements(driver, LogoutObj.class);
		
		logfile.info("Logging out from website");
		LogoutObj.LogoutMenu.click();
		LogoutObj.Logout.click();
			
	}

}
