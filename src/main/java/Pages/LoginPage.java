package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	WebElement email;
	WebElement password;
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.email = driver.findElement(By.id("email"));
		this.password = driver.findElement(By.id("password"));
		this.loginBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/form/div[4]/button"));
	}
	
	public void login(String email , String pass) {
	this.email.sendKeys(email);
	this.password.sendKeys(pass);
	this.loginBtn.click();
	}
}