package com.uniovi.tests;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.tests.pageobjects.PO_HomeView;
import com.uniovi.tests.pageobjects.PO_Properties;
import com.uniovi.tests.pageobjects.PO_RegisterView;
import com.uniovi.tests.pageobjects.PO_View;

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

    // PR01. Acceder a la página principal
    @Test
    public void PR01() {
	PO_HomeView.checkWelcome(driver, PO_Properties.getSPANISH());
    }

    // PR02. Opción de navegación. Pinchar en el enlace Registro en la página
    // home
    @Test
    public void PR02() {
	PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
    }

    // PR03. Opción den avegación. Pinchar en el enlace Identificate en la
    // páginahome
    @Test
    public void PR03() {
	PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
    }

    // PR04. Opción denavegación. Cambio de idioma de Español a Ingles y vuelta
    // a Español
    @Test
    public void PR04() {
	PO_HomeView.checkChangeIdiom(driver, "btnSpanish", "btnEnglish",
		PO_Properties.getSPANISH(), PO_Properties.getENGLISH());
	// SeleniumUtils.esperarSegundos(driver, 2);
    }

    // PR05. Prueba del formulario de registro. registro condatos correctos
    @Test
    public void PR05() {
	// Vamos al formulario de registro
	PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
	// Rellenamos el formulario.
	PO_RegisterView.fillForm(driver, "77777778A", "Josefo", "Perez",
		"77777", "77777");
	// Comprobamos que entramos en la sección privada
	PO_View.checkElement(driver, "text", "Notas del usuario");
    }

    // PR06. Prueba del formulario de registro. DNI repetido en la BD, Nombre
    // corto, .... pagination pagination-centered, Error.signup.dni.length
    @Test
    public void PR06() {
	// Vamos al formulario de registro
	PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
	// Rellenamos el formulario.
	PO_RegisterView.fillForm(driver, "99999990A", "Josefo", "Perez",
		"77777", "77777");
	PO_View.getP();
	// Comprobamos el error de DNI repetido.
	PO_RegisterView.checkKey(driver, "Error.signup.dni.duplicate",
		PO_Properties.getSPANISH());
	// Rellenamos el formulario.
	PO_RegisterView.fillForm(driver, "99999990B", "Jose", "Perez", "77777",
		"77777");
	// Comprobamos el error de Nombre corto.
	PO_RegisterView.checkKey(driver, "Error.signup.name.length",
		PO_Properties.getSPANISH());

	// Rellenamos el formulario.
	PO_RegisterView.fillForm(driver, "1234", "Josefo", "Perez", "77777",
		"77777");
	// Comprobamos el error de DNI corto
	PO_RegisterView.checkKey(driver, "Error.signup.dni.length",
		PO_Properties.getSPANISH());

	// Rellenamos el formulario.
	PO_RegisterView.fillForm(driver, "99999990B", "Jose", "Per", "77777",
		"77777");
	// Comprobamos el error de Apellido corto.
	PO_RegisterView.checkKey(driver, "Error.signup.lastName.length",
		PO_Properties.getSPANISH());
	
	// Rellenamos el formulario.
	PO_RegisterView.fillForm(driver, "12345678B", "Jose", "Perez", "123",
		"77777");
	// Comprobamos el error de Password corta.
	PO_RegisterView.checkKey(driver, "Error.signup.password.length",
		PO_Properties.getSPANISH());
	
	// Rellenamos el formulario.
	PO_RegisterView.fillForm(driver, "12345678B", "Jose", "Perez", "1234567",
		"77777");
	// Comprobamos el error de passwords distintas.
	PO_RegisterView.checkKey(driver, "Error.signup.passwordConfirm.coincidence",
		PO_Properties.getSPANISH());
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