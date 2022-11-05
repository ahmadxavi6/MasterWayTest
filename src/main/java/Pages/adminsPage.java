package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class adminsPage {
	WebDriver driver;
	public WebElement table;
	WebElement ID;
	WebElement name;
	WebElement email;
	WebElement age;
	WebElement number;
	WebElement submitBtn;
	WebElement more;
	WebElement delete;
	public adminsPage(WebDriver driver) {
		this.driver = driver;
		this.ID = driver.findElement(By.name("ID"));
		this.name = driver.findElement(By.name("fName"));
		this.email = driver.findElement(By.name("email"));
		this.age = driver.findElement(By.name("phoneNumber"));
		this.number = driver.findElement(By.name("age"));
		this.submitBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div[1]/form/div[6]/button"));
		this.table = driver.findElement(By.id("table-to-xls"));
		
	
	}
	public void addAdmin(String ID,String name , String email, String age,String number) {
		this.ID.sendKeys(ID);
		this.name.sendKeys(name);
		this.email.sendKeys(email);
		this.age.sendKeys(age);
		this.number.sendKeys(number);
		this.submitBtn.click();
	}
	public void more(int x) {
		this.more = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody["+x+"]/tr/td[7]/div/a/button"));
		this.more.click();
		
	}
	public void delete(int x) {
		this.delete = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody["+x+"]/tr/td[7]/div/button[1]"));
		this.delete.click();
		
	}
	

}
