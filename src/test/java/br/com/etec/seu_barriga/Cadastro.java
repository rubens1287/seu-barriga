package br.com.etec.seu_barriga;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class Cadastro extends Base{
	
	
	@Test
	public void cadastrar() {
				
		driver.get("https://seubarriga.wcaquino.me/login");
		
		new WebDriverWait(driver,30).until(ExpectedConditions
				.elementToBeClickable(
						By.xpath("//a[contains(text(),'Novo usuário?')]")));
		
		driver.findElement(By.xpath("//a[contains(text(),'Novo usuário?')]")).click();
		
		new WebDriverWait(driver,30).until(ExpectedConditions
				.elementToBeClickable(
						By.id("nome")));
		
		Faker faker = new Faker();
		String email = faker.name().fullName().replace(" ", "")+"@teste.com";
		
		driver.findElement(By.id("nome")).sendKeys("Rubens Lobo");
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("senha")).sendKeys("1234");
		
		System.out.println("Email: " + email);
		
		
		
		
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		
		new WebDriverWait(driver, 30)
		.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("//div[@class='alert alert-success']"), "Usuário inserido com sucesso"));		
	}

}
 