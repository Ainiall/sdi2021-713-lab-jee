package com.uniovi.tests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.uniovi.tests.pageobjects.PO_HomeView;
import com.uniovi.tests.pageobjects.PO_LoginView;
import com.uniovi.tests.pageobjects.PO_PrivateView;
import com.uniovi.tests.pageobjects.PO_Properties;
import com.uniovi.tests.pageobjects.PO_RegisterView;
import com.uniovi.tests.pageobjects.PO_View;
import com.uniovi.tests.util.SeleniumUtils;

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
	PO_RegisterView.fillForm(driver, "12345678B", "Jose", "Perez",
		"1234567", "77777");
	// Comprobamos el error de passwords distintas.
	PO_RegisterView.checkKey(driver,
		"Error.signup.passwordConfirm.coincidence",
		PO_Properties.getSPANISH());
    }

    // PR07. Loguearse con éxito desde el Rol de Usuario, 99999990A, 123456
    @Test
    public void PR07() {
	// Vamos al formulario de inicio de sesión
	PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
	// Rellenamos el formulario.
	PO_LoginView.fillForm(driver, "99999990A", "123456");
	// Comprobamos que entramos en la pagina privada de Alumno
	PO_View.checkElement(driver, "text", "Notas del usuario");
    }

    // PR08. Loguearse con éxito desde el Rol de Profesor, 99999993D, 123456
    @Test
    public void PR08() {
	// Vamos al formulario de inicio de sesión
	PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
	// Rellenamos el formulario.
	PO_LoginView.fillForm(driver, "99999993D", "123456");
	// Comprobamos que entramos en la pagina privada de Profesor
	PO_View.checkElement(driver, "text", "Gestión de notas");
    }

    // PR09. Loguearse con éxito desde el Rol de Administrador, 99999993D,
    // 123456
    @Test
    public void PR09() {
	// Vamos al formulario de inicio de sesión
	PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
	// Rellenamos el formulario.
	PO_LoginView.fillForm(driver, "99999988F", "123456");
	// Comprobamos que entramos en la pagina privada de Administrador
	PO_View.checkElement(driver, "text", "Gestión de notas");
    }

    // PR010. Loguearse sin éxito desde el Rol de Alumno, 99999990A, 123456
    @Test(expected = org.openqa.selenium.TimeoutException.class)
    public void PR10() {
	// Vamos al formulario de inicio de sesión
	PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
	// Rellenamos el formulario
	PO_LoginView.fillForm(driver, "99999990A", "12345678");
	// Comprobamos que no entramos en la pagina privada de Alumno
	PO_View.checkElement(driver, "text", "Notas del usuario");
    }

    // PR011. Loguearse con éxito desde el Rol de Alumno, 99999990A, 123456
    // Desconectarse con exito
    @Test(expected = org.openqa.selenium.TimeoutException.class)
    public void PR11() {
	// Vamos al formulario de inicio de sesión
	PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
	// Rellenamos el formulario.
	PO_LoginView.fillForm(driver, "99999990A", "123456");
	// Comprobamos que entramos en la pagina privada de Alumno
	PO_View.checkElement(driver, "text", "Notas del usuario");
	// Pulsamos sobre desconectar
	PO_HomeView.clickOption(driver, "logout", "class", "btn btn-primary");
	// Vemos la página principal
	PO_HomeView.checkWelcome(driver, PO_Properties.getSPANISH());
    }

    // PR12. Loguearse, comprobar que se visualizan 4 filas de notas y
    // desconectarse usan do el rol de estudiante.
    @Test
    public void PR12() {
	// login
	PO_PrivateView.login(driver, "99999990A", "123456",
		"Notas del usuario");
	// Contamos el número de filas de notas
	List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver,
		"free", "//tbody/tr", PO_View.getTimeout());
	assertTrue(elementos.size() == 4);
	// Ahora nos desconectamos
	PO_PrivateView.logout(driver, "Identifícate");
    }

    // PR13. Loguearse como estudiante y ver los detalles de la nota con
    // Descripcion= NotaA2.//P13. Ver la lista de Notas.
    @Test
    public void PR13() {
	// login
	PO_PrivateView.login(driver, "99999990A", "123456",
		"Notas del usuario");
	SeleniumUtils.esperarSegundos(driver, 1);
	// Contamos las notas
	By enlace = By.xpath(
		"//td[contains(text(), 'Nota A2')]/following-sibling::*[2]");
	driver.findElement(enlace).click();
	SeleniumUtils.esperarSegundos(driver, 1);
	// Esperamos por la ventana de detalle
	PO_View.checkElement(driver, "text", "Detalles de la nota");
	SeleniumUtils.esperarSegundos(driver, 1);
	// Ahora nos desconectamos
	PO_PrivateView.logout(driver, "Identifícate");
    }

    // P14. Loguearse como profesor y Agregar Nota A2.//P14. Esta prueba podría
    // encapsularse mejor...
    @Test
    public void PR14() {
	// login
	PO_PrivateView.login(driver, "99999993D", "123456",
		"99999993D");
	// Pinchamos en la opción de menu de Notas: //li[contains(@id,
	// 'marks-menu')]/a
	List<WebElement> elementos = PO_View.checkElement(driver, "free",
		"//li[contains(@id, 'marks-menu')]/a");
	elementos.get(0).click();

	// Esperamos a que aparezca la opción de añadir nota:
	// //a[contains(@href,
	// 'mark/add')]
	elementos = PO_View.checkElement(driver, "free",
		"//a[contains(@href, 'mark/add')]");
	// Pinchamos en agregar Nota.
	elementos.get(0).click();
	
	// Ahora vamos a rellenar la nota. //option[contains(@value, '4')]
	PO_PrivateView.fillFormAddMark(driver, 3, "Nota Nueva 1", "8");
	
	// pagination
	PO_PrivateView.pagination(driver, elementos);
	
	
	// Comprobamos que aparece la nota en la pagina
	elementos = PO_View.checkElement(driver, "text", "Nota Nueva 1");
	// Ahora nos desconectamos
	PO_PrivateView.logout(driver, "Identifícate");
    }

    // PRN. Loguearse como profesor, vamos a la ultima página y Eliminamos la
    // Nota Nueva 1.//PRN. Ver la lista de Notas.
    @Test
    public void PR15() {
	// Vamos al formulario de logueo.
	PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
	// Rellenamos el formulario
	PO_LoginView.fillForm(driver, "99999993D", "123456");
	// Comprobamos que entramos en la pagina privada del Profesor
	PO_View.checkElement(driver, "text", "99999993D");
	
	// Pinchamos en la opción de menu de Notas: //li[contains(@id,
	// 'marks-menu')]/a
	List<WebElement> elementos = PO_View.checkElement(driver, "free",
		"//li[contains(@id, 'marks-menu')]/a");
	elementos.get(0).click();
	// Pinchamos en la opción de lista de notas.
	elementos = PO_View.checkElement(driver, "free",
		"//a[contains(@href, 'mark/list')]");
	elementos.get(0).click();
	
	//pagination 
	PO_PrivateView.pagination(driver, elementos);
	
	// Esperamos a que aparezca la Nueva nota en la ultima pagina y
	// Pinchamos en el enlace de borrado de la Nota "Nota Nueva 1"
	// td[contains(text(),'Nota Nueva
	// 1')]/following-sibling::*/a[contains(text(), 'mark/delete')]"
	elementos = PO_View.checkElement(driver, "free",
		"//td[contains(text(), 'Nota Nueva 1')]/following-sibling::*/a[contains(@href, 'mark/delete')]");
	elementos.get(0).click();
	// pagination 
	PO_PrivateView.pagination(driver, elementos);
	// Y esperamosa que NO aparezca la ultima "Nueva Nota 1"
	SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "Nota Nueva 1",
		PO_View.getTimeout());
	// Ahora nos desconectamos
	PO_PrivateView.logout(driver, "Identifícate");

    }

}