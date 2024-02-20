package test_Cases;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import common_Functions.Launch_WebPage;
import page_Objects.AdminPageObjects;

public class Admin_Page extends Launch_WebPage{  
	
	String UserRole = null;
	String UserStatus = null;
	
	Logger log = Logger.getLogger(Admin_Page.class);
	
	public void Search_User() {		
		
		log.info("Navigating to Admin Page");
		AdminPageObjects.AdminHome.click();
		
		log.info("Searching User");
		AdminPageObjects.User.sendKeys("Admin");
		
		log.info("Clicking on search button");
		AdminPageObjects.SearchButton.click();
		
	}
	
	public void CheckSearchResults() {
		
		log.info("Getting User Status");
	//	UserRole = AdminPageObjects.UserRole.getText();
		UserStatus = AdminPageObjects.UserStatus.getText();
	}
	
	@Test
	public void VerifyResults() {
		PageFactory.initElements(driver, AdminPageObjects.class);
		
		Search_User();
		CheckSearchResults();
		Assert.assertEquals(UserStatus, "Enabled");
		log.info("Verified Actual and Expected Results of Admin Page");
		
	}

}
