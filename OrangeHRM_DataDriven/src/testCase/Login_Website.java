package testCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common_Features.Launch_BrowserPage;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import loginpage_Objects.LoginPageObj;

public class Login_Website extends Launch_BrowserPage{
	
	public static Logger logfile = Logger.getLogger(Login_Website.class);
	
	String[][]  cellValues;
	String[][] GetCellValues;
	
	@DataProvider(name="SendData")
	public String[][] GetExcelData() throws BiffException, IOException {
	   GetCellValues = ReadExcel();
	       return GetCellValues;
	}
	
	
	public String[][] ReadExcel() throws BiffException, IOException {
		
		logfile.info("Getting test data from excel sheet");
		
		FileInputStream excelfile = new FileInputStream("F:\\Senthil\\Testing\\Tutorials\\Test Data\\DataValo.xls");
		
		Workbook workbook = Workbook.getWorkbook(excelfile);
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		int cols = sheet.getColumns();
		
		cellValues = new String [rows-1][cols];
		
		for(int i=1;i<rows;i++) {
			for (int j = 0; j <cols; j++) {
				cellValues[i-1][j] = sheet.getCell(j, i).getContents();
			}
			
		}
			return cellValues;
		
	}
	
	@Test(dataProvider = "SendData")
	public static void Login_Page(String Uname, String Pwd) throws InterruptedException {
		PageFactory.initElements(driver, LoginPageObj.class);
		
		logfile.info("Login to Website using Username and Password");
		LoginPageObj.UserName.sendKeys(Uname);		
		LoginPageObj.Password.sendKeys(Pwd);
		
		logfile.info("Clicking on submit button");
		LoginPageObj.SubmitBtn.submit();
		
		driver.navigate().refresh();
		Thread.sleep(1000);
		
	}
	
	
	
}
