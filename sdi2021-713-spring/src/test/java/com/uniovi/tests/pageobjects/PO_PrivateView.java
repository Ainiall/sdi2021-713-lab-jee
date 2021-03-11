package com.uniovi.tests.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uniovi.tests.util.SeleniumUtils;

public class PO_PrivateView extends PO_NavView {
    static public void fillFormAddMark(WebDriver driver, int userOrder,
	    String descriptionp, String scorep) {
	// Esperamos 5 segundos a que carge el DOM porque en algunos equipos
	// falla
	SeleniumUtils.esperarSegundos(driver, 5);
	// Seleccionamos el alumno userOrder
	new Select(driver.findElement(By.id("user"))).selectByIndex(userOrder);
	// Rellenemos el campo dedescripción
	WebElement description = driver.findElement(By.name("description"));
	description.clear();
	description.sendKeys(descriptionp);
	WebElement score = driver.findElement(By.name("score"));
	score.click();
	score.clear();
	score.sendKeys(scorep);
	By boton = By.className("btn");
	driver.findElement(boton).click();

    }

    // login
    static public void login(WebDriver driver, String dni, String pass,
	    String text) {
	// Vamos al formulario de logueo.
	PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
	// Rellenamos el formulario
	PO_LoginView.fillForm(driver, dni, pass);
	// Comprobamos que entramos en la pagina privada del Profesor
	PO_View.checkElement(driver, "text", text);
    }

    // logout
    static public void logout(WebDriver driver, String text) {
	// Ahora nos desconectamos
	PO_PrivateView.clickOption(driver, "logout", "text", text);
    }

    // pagination
    static public void pagination(WebDriver driver,
	    List<WebElement> elementos) {
	if (elementos != null) {
	    // Esperamos a que se muestren los enlaces de paginacion la lista de
	    // notas
	    elementos = PO_View.checkElement(driver, "free",
		    "//a[contains(@class,'page-link')]");
	    // Nos vamos a la última página
	    elementos.get(elementos.size() - 1).click();
	}else {
	    throw new IllegalStateException();
	}

    }

}
