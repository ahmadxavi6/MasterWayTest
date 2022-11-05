package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class adminPage {
	WebDriver driver;

	public String name;
	public String email;
	public String number;

	public String age;



	
	public adminPage(WebDriver driver) {
		this.driver = driver;
		this.name = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div/h6[1]")).getText();
		this.email = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div/h6[2]")).getText();
		this.number = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div/h6[3]")).getText();
		
	
		this.age = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div/h6[4]")).getText();
		
	}

}
