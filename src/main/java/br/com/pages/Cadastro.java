package br.com.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;


public class Cadastro {
	
	private WebDriver driver;
	private By txtNome =  By.id("nome");
	private By txtEmail = By.id("email");
	private By txtSenha = By.id("senha");
	private By btnCadastrar = By.xpath("//input[@class='btn btn-primary']");
	private By lblMensagem = By.xpath("//div[@class='alert alert-danger']");
		
	public Cadastro(WebDriver driver) {
		this.driver = driver;
	}
	
	public void cadastrarUsuario() throws InterruptedException {
		
		new WebDriverWait(driver,30).until(ExpectedConditions
				.elementToBeClickable(txtNome));
		
		Faker faker = new Faker();
		String email = faker.name().username().replace(" ", "")+"@gft.com";
		
		driver.findElement(txtNome).sendKeys("Rubens Lobo");		
		driver.findElement(txtEmail).sendKeys("rubens@gft.com");
		Thread.sleep(1000);
		driver.findElement(txtSenha).sendKeys("1234");
		System.out.println("Email: " + email);
		WebElement button = driver.findElement(btnCadastrar);	
	
		Actions actions= new Actions(driver);
		actions.sendKeys(button, Keys.ENTER).build().perform();
		
	}
	
	public void validaMensagem() {
		new WebDriverWait(driver, 10)
		.until(ExpectedConditions.presenceOfElementLocated(lblMensagem));	
		
		Assert.assertEquals("Endereço de email já utilizado", driver.findElement(lblMensagem).getText());
	}

}
