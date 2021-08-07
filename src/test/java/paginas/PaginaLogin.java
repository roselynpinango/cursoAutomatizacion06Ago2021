package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement btnEnter;
	
	WebDriver driver;
	
	public PaginaLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void completarCredenciales(String correo, String password) {
		txtEmail.sendKeys(correo);
		txtPassword.sendKeys(password);
	}
	
	public void clicOnEnter() {
		btnEnter.click();
	}
}
