package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class changePassPage {
	WebDriver driver;

	WebElement pass1;
	WebElement pass2;
	WebElement changeBtn;

	


	
	public changePassPage(WebDriver driver) {
		this.driver = driver;
		this.pass1 = driver.findElement(By.id("password1"));
		this.pass2 = driver.findElement(By.id("password2"));
		this.changeBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/form/div[2]/button"));
		
		
		
	}
	public void change(String pass) {
		this.pass1.sendKeys(pass);
		this.pass2.sendKeys(pass);
		this.changeBtn.click();
	}

}
