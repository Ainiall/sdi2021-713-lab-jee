package com.uniovi.tests;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.runners.MethodSorters;

//Ordenamos las pruebas por el nombre del método
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotaneitorTests {

    // En Windows (Debe ser la versión 65.0.1 y desactivar las actualizaciones
    // automáticas)):
    static String Geckdriver024 = "D:\\APUNTES\\SDI\\LABORATORIO\\PL-SDI-Material-P5\\\\geckodriver024win64.exe";
    static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
    // EnMACOSX (Debe ser la versión 65.0.1 y desactivar las actualizaciones
    // automáticas):
    // static String PathFirefox65=
    // "/Applications/Firefox.app/Contents/MacOS/firefox-bin";
    // static String Geckdriver024= "/Users/delacal/selenium/geckodriver024mac";

    // Común a Windows y a MACOSX
    static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
    static String URL = "http://localhost:8090";

    public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
	System.setProperty("webdriver.firefox.bin", PathFirefox);
	System.setProperty("webdriver.gecko.driver", Geckdriver);
	WebDriver driver = new FirefoxDriver();
	return driver;
    }

    // Antes de cada prueba se navega al URL home de la aplicación
    @Before
    public void setUp() {
	driver.navigate().to(URL);
    }

    // Después de cada prueba se borran las cookies del navegador
    @After
    public void tearDown() {
	driver.manage().deleteAllCookies();
    }

    // Antes de la primera prueba
    @BeforeClass
    static public void begin() {
    }

    // Al finalizar la última prueba
    @AfterClass
    static public void end() {
	// Cerramos el navegador al finalizar las pruebas
	driver.quit();
    }

    @Test
    public void test() {
	// fail("Not yet implemented");
    }

    @Test
    public void PR01() {
    }

    @Test
    public void PR02() {
    }

    @Test
    public void PR03() {
    }

    @Test
    public void PR04() {
    }
    
    @Test
    public void PR05() {
    }
    @Test
    public void PR06() {
    }
    @Test
    public void PR07() {
    }
    @Test
    public void PR08() {
    }
    @Test
    public void PR09() {
    }
    @Test
    public void PR10() {
    }
    @Test
    public void PR11() {
    }
    @Test
    public void PR12() {
    }
    @Test
    public void PR13() {
    }
    @Test
    public void PR14() {
    }
    @Test
    public void PR15() {
    }
    
    
}