package pruebas;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio4_E1 {
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
	
	@Test(dataProvider="Datos Login")
	public void login(String correo, String contrasenia) {
		// Hacer clic en el hipervínculo Sign In
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.clicOnSignIn();
		
		// Ingresar las credenciales y hacer clic en el boton
		PaginaLogin login = new PaginaLogin(driver);
		login.completarCredenciales(correo, contrasenia);
		login.clicOnEnter();
	}
	
	@DataProvider(name="Datos en Java")
	public Object[][] construirDatosEntrada() {
		Object[][] datos = new Object[3][2];
		
		datos[0][0] = "maria@gmail.com";
		datos[0][1] = "1q2w3e4r";
		
		datos[1][0] = "juan@gmail.com";
		datos[1][1] = "0p9o8i7u";
		
		datos[2][0] = "jorge@gmail.com";
		datos[2][1] = "4r5t6y7u";
		
		return datos;
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatosEntrada() throws Exception {
		String ruta = "..\\EducacionITViernes\\Datos\\datosLab4_E2.xlsx";
		String hoja = "Hoja1";
		
		return DatosExcel.leerExcel(ruta, hoja);
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
