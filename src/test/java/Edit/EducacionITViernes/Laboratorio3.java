package Edit.EducacionITViernes;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio3 {
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..\\EducacionITViernes\\Drivers\\chromedriver.exe";
	String imagePath = "..\\EducacionITViernes\\Evidencias\\";
	WebDriver driver;
	File screen;
	
	/*
	 * Método para configurar las propiedades del navegador y abrirlo en la página correspondiente
	 * */
	@BeforeSuite
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(screen, new File(imagePath + "01_PaginaPrincipal.png"));
	}
	
	/*
	 * Paso a Paso para registrar a un usuario
	 * */
	@Test(priority=0,description="CP01: Registro de Usuario")
	public void registrarUsuario() throws Exception {
		// Paso 1 - Ingresar el correo y hacer clic en Create an Account
		WebElement txtCorreo = driver.findElement(By.xpath("//input[@id='email_create']"));
		txtCorreo.sendKeys("correo9984@mailinator.com");
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(imagePath + "02_correo_ingresado.png"));
				
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
		
		//Assert.assertTrue(1 == 2);
				
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
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(imagePath + "03_formulario_completo.png"));
				
		WebElement btnRegister = driver.findElement(By.cssSelector("#submitAccount"));
		btnRegister.click();
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(imagePath + "04_resultado_obtenido.png"));
		
		// Ir a la base de datos y corroborar que el usuario se registro
		// SELECT COUNT(1) FROM usuario WHERE correo = 'correo@gmail.com';
		// Assert.assertTrue(count > 0);
		
		String expectedResult = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(driver.getCurrentUrl(), expectedResult);
	}
	
	/*
	 * Paso a Paso para buscar una palabra 
	 * */
	@Test(priority=2,description="CP03: Buscar Palabra")
	public void buscarPalabra() {
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("skirt");
		txtBuscador.sendKeys(Keys.ENTER);
	}
	
	/*
	 * Paso a Paso para ir a la sección Contact Us
	 * */
	@Test(priority=1,description="CP02: Ir a Contact Us")
	public void irAContactanos() {
		WebElement lnkContactUs = driver.findElement(By.linkText("Contact us"));
		lnkContactUs.click();
	}
	
	/*
	 * Cerrar todas las ventanas y registrar el final de la ejecución
	 * */
	@AfterSuite
	public void tearDown() {
		//driver.close();
		System.out.println("Finalizo la suite de pruebas");
	}
}
