package com.uniovi.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.tests.pageobjects.PO_HomeView;
import com.uniovi.tests.pageobjects.PO_PrivateView;
import com.uniovi.tests.pageobjects.PO_Properties;
import com.uniovi.tests.pageobjects.PO_RegisterView;
import com.uniovi.tests.pageobjects.PO_TeacherView;
import com.uniovi.tests.pageobjects.PO_View;
import com.uniovi.tests.util.SeleniumUtils;

//Ordenamos las pruebas por el nombre del método
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotaneitorComplementariosTests {

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

    // PR01. Registro de profesores con datos válido
    @Test
    public void PR01() {
	// login
	PO_PrivateView.login(driver, "99999988F", "123456", "99999988F");
	// acceso al menu de profesores
	PO_TeacherView.register(driver, "53522658W", "Ángela", "López", "Informática");

    }

    // PR02. Registro de profesores con datos inválidos
    @Test
    public void PR02() {
	// login
	PO_PrivateView.login(driver, "99999988F", "123456", "99999988F");
	// acceso al menu de profesores
	PO_TeacherView.register(driver, "12345678A", " ", "López", " ");
	PO_View.checkElement(driver, "text", "Este campo no puede ser vacio.");
	// IMPORTANTE! properties dentro de la carpeta test
	PO_RegisterView.checkKey(driver, "Error.empty", PO_Properties.getSPANISH());
	
	SeleniumUtils.esperarSegundos(driver, 5);
    }

    // PR03. Verificar que solo los usuarios autorizados pueden dar de alta un
    // profesor.
    @Test
    public void PR03() {
	// login como alumno
	PO_PrivateView.login(driver, "99999990A", "123456",
		"Notas del usuario");

	// acceso invalido url
	driver.navigate().to("http://localhost:8090/teacher/add");
	SeleniumUtils.textoPresentePagina(driver,"HTTP Status 403 – Forbidden");
	SeleniumUtils.esperarSegundos(driver, 5);
    }
}
