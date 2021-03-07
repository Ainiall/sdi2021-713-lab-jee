package com.uniovi.tests.pageobjects;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.*;
import com.uniovi.tests.util.SeleniumUtils;

// Cuelga de PO_View y será de la que hereden el resto de PO
public class PO_NavView extends PO_View {
    /**
     * Clicka una de las opciones principales(a href) y comprueba que se vaya a
     * la vista con el elemento de tipo type con el textoDestino
     * 
     * @paramdriver: apuntando al navegador abierto actualmente.
     * @paramtextOption: Texto de lao pción principal.
     * @paramcriterio: "id" or "class" or "text" or "@attribute" or "free". Si
     *                 el valor de criterio es free es una expresion xpath
     *                 completa.
     * @paramtextoDestino: texto correspondiente a la búsqueda de la página
     *                     destino.
     */
    public static void clickOption(WebDriver driver, String textOption,
	    String criterio, String textoDestino) {
	// Clickamos en la opción de registro y esperamos a que se cargue el
	// enlace de Registro.
	List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver,
		"@href", textOption, getTimeout());
	// Tiene que haber un sólo elemento.
	assertTrue(elementos.size() == 1);
	// Ahora lo clickamos
	elementos.get(0).click();
	// Esperamos a que sea visible un elemento concreto
	elementos = SeleniumUtils.EsperaCargaPagina(driver, criterio,
		textoDestino, getTimeout());
	// Tiene que haber un sólo elemento.
	assertTrue(elementos.size() == 1);
    }

    /***
     * Selecciona el enlace de idioma correspondiente al texto textLanguage *
     * 
     * @paramdriver: apuntando al navegador abierto actualmente.*
     * @paramtextLanguage: el texto que aparece en el enlace de idioma("English"
     *                     o "Spanish")
     */
    public static void changeIdiom(WebDriver driver, String textLanguage) {
	// clickamos la opción Idioma.
	List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver,
		"id", "btnLanguage", getTimeout());
	elementos.get(0).click();
	// Esperamos a que aparezca el menú de opciones.
	elementos = SeleniumUtils.EsperaCargaPagina(driver, "id",
		"languageDropdownMenuButton", getTimeout());
	// SeleniumUtils.esperarSegundos(driver, 2);
	// Clickamos la opción Inglés partiendo de la opciónEspañol
	elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", textLanguage,
		getTimeout());
	elementos.get(0).click();
    }
}