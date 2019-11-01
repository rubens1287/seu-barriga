/**
 * 
 */
package br.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author rslo
 *
 */
public class Login {
	
	private WebDriver driver;
	private By lnkNovoUsuario = By.xpath("//a[contains(text(),'Novo usuário?')]");
	
	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	public void criarNovoUsuario() {
		new WebDriverWait(driver,30).until(ExpectedConditions
				.elementToBeClickable(lnkNovoUsuario));
		driver.findElement(lnkNovoUsuario).click();
	}

}
