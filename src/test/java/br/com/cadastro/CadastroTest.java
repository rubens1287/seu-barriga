package br.com.cadastro;

import java.awt.RenderingHints.Key;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import br.com.core.Base;
import br.com.pages.Cadastro;
import br.com.pages.Login;

public class CadastroTest extends Base{
	
	
	@Test
	public void cadastrarUsuarioComEmailExistente() throws InterruptedException {	
		driver.get("https://seubarriga.wcaquino.me/login");
		new Login(driver).criarNovoUsuario();
		new Cadastro(driver).cadastrarUsuario();
		new Cadastro(driver).validaMensagem();
	}

}
 