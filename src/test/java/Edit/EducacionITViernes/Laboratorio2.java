package Edit.EducacionITViernes;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio2 {
	@Test
	public void registrarUsuario() {
		String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		String driverPath = "..\\EducacionITViernes\\Drivers\\chromedriver.exe";
		
		// Configuracion Inicial
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		// Abrir y maximizar en la página a utilizar
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		// Paso 1 - Ingresar el correo y hacer clic en Create an Account
		WebElement txtCorreo = driver.findElement(By.xpath("//input[@id='email_create']"));
		txtCorreo.sendKeys("correo9996@mailinator.com");
		
		WebElement btnCreate = driver.findElement(By.xpath("//*[@id='SubmitCreate']"));
		btnCreate.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#id_gender1")));
		
		// Paso 2 - Llenar el formulario y hacer clic en el boton Register
		WebElement radMr = driver.findElement(By.cssSelector("#id_gender1"));
		radMr.click();
		
		WebElement txtNombre = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
		txtNombre.sendKeys("Carlos");
		
		WebElement txtApellido = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
		txtApellido.sendKeys("Gonzalez");
		
		WebElement txtPassword = driver.findElement(By.id("passwd"));
		txtPassword.sendKeys("1q2w3e4r5t6y");
		
		Select day = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		day.selectByValue("18");
		
		Select month = new Select(driver.findElement(By.id("months")));
		month.selectByValue("3");
		
		Select year = new Select(driver.findElement(By.id("years")));
		year.selectByValue("1990");
		
		WebElement chkNewsletter = driver.findElement(By.name("newsletter"));
		chkNewsletter.click();
		
		WebElement chkOffers = driver.findElement(By.xpath("//input[@id='optin']"));
		chkOffers.click();
		
		WebElement txtCompany = driver.findElement(By.cssSelector("#company"));
		txtCompany.sendKeys("ABC C.A.");
		
		WebElement txtAddress = driver.findElement(By.id("address1"));
		txtAddress.sendKeys("miCalle 1234 2B");
		
		WebElement txtAddress2 = driver.findElement(By.xpath("//input[@id='address2']"));
		txtAddress2.sendKeys("Microcentro");
		
		WebElement txtCity = driver.findElement(By.name("city"));
		txtCity.sendKeys("Capital Federal");
		
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText("Florida");
		
		WebElement txtZipCode = driver.findElement(By.cssSelector("#postcode"));
		txtZipCode.sendKeys("12345");
		
		Select country = new Select(driver.findElement(By.id("id_country")));
		country.selectByValue("21");
		
		WebElement taAdditionalInfo = driver.findElement(By.tagName("textarea"));
		taAdditionalInfo.sendKeys("PRUEBA - Información Adicional sobre el registro");
		
		WebElement txtHome = driver.findElement(By.id("phone"));
		txtHome.sendKeys("12345678");
		
		WebElement txtMobile = driver.findElement(By.name("phone_mobile"));
		txtMobile.sendKeys("987654321");
		
		WebElement txtAlias = driver.findElement(By.xpath("//input[@id='alias']"));
		txtAlias.clear();
		txtAlias.sendKeys("aliasUsuario");
		
		WebElement btnRegister = driver.findElement(By.cssSelector("#submitAccount"));
		btnRegister.click();
		
		// Paso 3 - Verificación y Validación de Resultado Esperado
		String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
		String actualUrl = driver.getCurrentUrl();
		
		if (actualUrl.contentEquals(expectedUrl)) {
			System.out.println("Se creó el usuario");
			driver.close();
		} else {
			System.out.println("ERROR - No se creó el usuario");
		}
	}
}
