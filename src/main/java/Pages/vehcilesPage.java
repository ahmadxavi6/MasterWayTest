package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class vehcilesPage {
	WebDriver driver;
	WebElement man;
	WebElement model;
	WebElement year;
	WebElement licnese;
	WebElement insurance;
	public WebElement table;
	WebElement submitBtn;
	WebElement more;
	WebElement update;
	WebElement delete;

	
	public vehcilesPage(WebDriver driver) {
		this.driver = driver;
		this.man = driver.findElement(By.name("man"));
		this.model = driver.findElement(By.name("model"));
		this.year = driver.findElement(By.name("year"));
		this.licnese = driver.findElement(By.name("lice"));
		this.insurance = driver.findElement(By.name("insu"));
		this.submitBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div[1]/form/div[6]/button"));
		this.table = driver.findElement(By.id("table-to-xls"));
	}
	public void addVehicle(String man , String model , String year, String licnese,String insurance ) {
		this.man.sendKeys(man);
		this.model.sendKeys(model);
		this.year.sendKeys(year);
		this.licnese.sendKeys(licnese);
		this.insurance.sendKeys(insurance);
		this.submitBtn.click();
	}

	public void delete(int x) {
		this.delete = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody["+x+"]/tr/td[8]/div/button[1]"));
		this.delete.click();
	}

	public void clickUpdate(int x) {
		this.update = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody["+x+"]/tr/td[8]/div/button[2]"));
		this.update.click();
	}
	public void update(String man ,String model ,String year,String licnese ,String insurance) {
		this.man.clear();
		this.man.sendKeys(man);
		this.model.clear();
		this.model.sendKeys(model);
		this.year.clear();
		this.year.sendKeys(year);
		this.licnese.sendKeys(licnese);
		this.insurance.sendKeys(insurance);
		this.submitBtn.click();
	}
	public void more(int x) {
		
		this.more = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody["+x+"]/tr/td[8]/div/a/button"));
		this.more.click();
		
	}

	
	
	
}