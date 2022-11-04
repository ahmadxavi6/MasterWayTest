package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class workerPage {
	WebDriver driver;

	public String name;
	public String email;
	public String number;
	public String address;
	public String age;
	public String gender;
    public String license;


	
	public workerPage(WebDriver driver) {
		this.driver = driver;
		this.name = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div[1]/h6[1]")).getText();
		this.email = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div[1]/h6[2]")).getText();
		this.number = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div[1]/h6[3]")).getText();
		
		this.address = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div[1]/h6[6]")).getText();
		this.age = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div[1]/h6[8]")).getText();
		this.gender = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div[1]/h6[4]")).getText();
		this.license = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div[1]/h6[5]")).getText();
		
	}

}
