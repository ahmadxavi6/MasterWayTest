package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class workersPage {
	WebDriver driver;
	WebElement ID;
	WebElement name;
	WebElement email;
	WebElement number;
	WebElement address;
	WebElement age;
	Select gender;
	Select license;
	WebElement submitBtn;
	WebElement more;
	WebElement update;
	WebElement delete;

	
	public workersPage(WebDriver driver) {
		this.driver = driver;
		this.ID = driver.findElement(By.name("ID"));
		this.name = driver.findElement(By.name("fName"));
		this.email = driver.findElement(By.name("email"));
		this.number = driver.findElement(By.name("phoneNumber"));
		this.address = driver.findElement(By.name("address"));
		this.age = driver.findElement(By.name("age"));
		this.gender =  new Select(driver.findElement(By.name("gender")));
		this.license =  new Select(driver.findElement(By.name("licen")));
		this.submitBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div[1]/form/div[9]/button"));
		
		

		
	}
	public void addWorker(String ID , String name , String email , String number, String address,String age ,String gender ,String license) {
		this.ID.clear();
		this.ID.sendKeys(ID);
		this.name.clear();
		this.name.sendKeys(name);
		this.email.clear();
		this.email.sendKeys(email);
		this.number.clear();
		this.number.sendKeys(number);
		this.address.clear();
		this.address.sendKeys(address);
		this.age.clear();
		this.age.sendKeys(age);
this.gender.selectByValue("None");	
		this.gender.selectByValue(gender);
		this.license.selectByValue("None");	
		this.license.selectByValue(license);
	
		this.submitBtn.click();
	}
	public void more(int x) {
	this.more =driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody["+x+"]/tr/td[7]/div/a/button"));
	this.more.click();
	
	
	}
	public void delete(int x) {
		this.delete = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody["+x+"]/tr/td[7]/div/button[1]"));
		this.delete.click();
	}
	public void clickUpdate(int x) {
		this.update = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody["+x+"]/tr/td[7]/div/button[2]"));
		this.update.click();
	}
	public void update( String name ,String gender , String lices) {
		
		this.name.clear();
		this.name.sendKeys(name);
		this.gender.selectByValue("None");	
		this.gender.selectByValue(gender);
		this.license.selectByValue("None");	
		this.license.selectByValue(lices);
		this.submitBtn.click();
		
	}
	
	
	
}