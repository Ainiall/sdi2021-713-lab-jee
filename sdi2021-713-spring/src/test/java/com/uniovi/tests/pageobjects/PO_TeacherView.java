package com.uniovi.tests.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_TeacherView extends PO_NavView {
    static public void fillForm(WebDriver driver, String dnip, String namep,
	    String lastnamep, String categoryp) {

	WebElement dni = driver.findElement(By.name("DNI"));
	dni.click();
	dni.clear();
	dni.sendKeys(dnip);

	WebElement name = driver.findElement(By.name("name"));
	name.click();
	name.clear();
	name.sendKeys(namep);

	WebElement lastname = driver.findElement(By.name("surname"));
	lastname.click();
	lastname.clear();
	lastname.sendKeys(lastnamep);
	
	WebElement category = driver.findElement(By.name("category"));
	category.click();
	category.clear();
	category.sendKeys(categoryp);

	// Pulsar el boton de Alta.
	By boton = By.className("btn");
	driver.findElement(boton).click();
    }
    
    static public void register(WebDriver driver, String dni, String name, String surname, String category) {
	// comprobar que sale la opcion del menu de profesores
	List<WebElement> elementos = PO_View.checkElement(driver, "free",
		"//li[contains(@id, 'teachers-menu')]/a");
	elementos.get(0).click();
	elementos = PO_View.checkElement(driver, "free",
		"//a[contains(@href, 'teacher/add')]");
	elementos.get(0).click();
	// rellenar formulario
	fillForm(driver, dni, name, surname, category);
    }
}
