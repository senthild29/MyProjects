package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPageObjects {

	@FindBy(xpath = "//a[@href='/web/index.php/admin/viewAdminModule']")
	public static WebElement AdminHome;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
	public static WebElement User;
	
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement SearchButton;
	
	@FindBy(xpath = "//*[text()='Enabled']")
	 public static WebElement UserStatus;
}
