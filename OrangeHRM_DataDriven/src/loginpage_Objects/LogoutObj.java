package loginpage_Objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutObj {
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li")
	public static WebElement LogoutMenu;
	
	@FindBy(xpath = "//a[@href='/web/index.php/auth/logout']")
	public static WebElement Logout;

}
