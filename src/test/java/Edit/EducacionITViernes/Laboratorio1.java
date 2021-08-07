package Edit.EducacionITViernes;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio1 {
	/*
	 * Método de prueba para acceder a Selenium.Dev desde Chrome
	 * */
	@Test 
	public void accederDesdeChrome() {
		// Paso 1: Definir dónde está el ChromeDriver.exe
		System.setProperty("webdriver.chrome.driver", "..\\EducacionITViernes\\Drivers\\chromedriver.exe");
		
		// Paso 2: Indicar qué navegador voy a controlar
		WebDriver driver = new ChromeDriver();
		
		// Paso 3: Abrir el navegador Chrome en la página Selenium.Dev
		driver.get("https://www.selenium.dev/");
		
		// Paso 4: Cerrar el navegador
		driver.close();
	}
	
	/*
	 * Método de prueba para acceder a Selenium.Dev desde Firefox
	 * */
	@Test
	public void accederDesdeFirefox() {
		// Paso 1: Definir dónde está el GeckoDriver.exe
		System.setProperty("webdriver.gecko.driver", "..\\EducacionITViernes\\Drivers\\geckodriver.exe");
				
		// Paso 2: Indicar qué navegador voy a controlar
		WebDriver driver = new FirefoxDriver();
				
		// Paso 3: Abrir el navegador Firefox en la página Selenium.Dev
		driver.get("https://www.selenium.dev/");
		
		// Paso 4: Cerrar el navegador
		driver.close();
	}
	
	/*
	 * Método de prueba para hacer una búsqueda en la página Selenium.dev desde Chrome
	 * Previo a maximizar la página, borrar cookies
	 * */
	@Test
	public void buscarPalabra() {
		System.setProperty("webdriver.chrome.driver", "..\\EducacionITViernes\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		
		// Maximiza el navegador
		driver.manage().window().maximize();
		
		// Borra las cookies
		driver.manage().deleteAllCookies();
		
		// Ubica el elemento - Campo de Texto para Búsqueda
		WebElement txtBuscador = driver.findElement(By.id("gsc-i-id1"));
		
		// Escribe en el campo de texto la palabra indicada como parámetro
		txtBuscador.sendKeys("Java");
		
		// Simular que se presiona la tecla ENTER del teclado
		txtBuscador.sendKeys(Keys.ENTER);
	}
}
