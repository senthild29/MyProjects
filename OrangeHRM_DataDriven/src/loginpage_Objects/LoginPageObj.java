package loginpage_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObj {
	
	@FindBy(name = "username")
	public static WebElement UserName;
	
	@FindBy(name = "password")
	public static WebElement Password;
	
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement SubmitBtn;
	
	

}
