package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(name = "username")
	public static WebElement Username;
	
	@FindBy(name = "password")
	public static WebElement Password;
	
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement LoginButton;
}
