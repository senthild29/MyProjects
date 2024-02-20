package test_Cases;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import common_Functions.Launch_WebPage;
import page_Objects.DashboardPage;
import page_Objects.LoginPage;

public class Dashboard_Page extends Launch_WebPage{
	
	String ActualResult=null;
	
	Logger log = Logger.getLogger(Dashboard_Page.class);
	
	public void LoginSite() {
		
		PageFactory.initElements(driver, LoginPage.class);
		
		log.info("Entering Credentials");
		LoginPage.Username.sendKeys(prop.getProperty("Username"));
		LoginPage.Password.sendKeys(prop.getProperty("Password"));
		
		log.info("Clicking on Submit Button");
		LoginPage.LoginButton.click();
		}
	
	
	public void CheckEmployeesLeaveRequest() {
		log.info("Checking Employee Leave Request");
		PageFactory.initElements(driver, DashboardPage.class);		
		 ActualResult = DashboardPage.EmpLeave.getText();
		}
	
	@Test
	public void VerifyEmployeesLeaveRequest() {
		LoginSite();
		CheckEmployeesLeaveRequest();		
	assertEquals(ActualResult, "No Employees are on Leave Today");
		log.info("Verified Actual and Expected Result of Dashboard Page");
	}

}
