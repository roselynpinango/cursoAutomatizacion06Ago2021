package pruebas;

import java.io.File;

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

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio3_E2 {
	String url = "http://automationpractice.com";
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
	
	@Test
	public void login() {
		// Hacer clic en el hipervínculo Sign In
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.clicOnSignIn();
		
		// Ingresar las credenciales y hacer clic en el boton
		PaginaLogin login = new PaginaLogin(driver);
		login.completarCredenciales("correo01@gmail.com", "12345678");
		login.clicOnEnter();
	}
	
	@Test
	public void contactUs() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.clicOnContactUs();
	}
	
	@Test
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabra("python");
		inicio.realizarBusqueda();
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
