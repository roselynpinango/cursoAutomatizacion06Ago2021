package paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSignIn;
	
	@FindBy(xpath="//header/div[2]/div[1]/div[1]/nav[1]/div[2]/a[1]")
	WebElement lnkContactUs;
	
	@FindBy(css="#search_query_top")
	WebElement txtBuscador;
	
	WebDriver driver;
	
	public PaginaInicio(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clicOnSignIn() {
		lnkSignIn.click();
	}
	
	public void clicOnContactUs() {
		lnkContactUs.click();
	}
	
	public void escribirPalabra(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void realizarBusqueda() {
		txtBuscador.sendKeys(Keys.ENTER);
	}
}
