package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class budgetsPage {
	WebDriver driver;
	WebElement Name;
	WebElement Description;
	WebElement Date;
	WebElement Cost;
	Select Type;
	public WebElement table;
	WebElement submitBtn;
	WebElement more;
	WebElement update;
	WebElement delete;
	

	
	public budgetsPage(WebDriver driver) {
		this.driver = driver;
		this.Name = driver.findElement(By.name("Name"));
		this.Description = driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div[1]/form/div[2]/input"));
		this.Date = driver.findElement(By.name("date"));
		this.Cost = driver.findElement(By.name("cost"));
		this.Type = new Select( driver.findElement(By.name("type")));
		this.submitBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div[1]/form/div[6]/button"));
		this.table = driver.findElement(By.id("table-to-xls"));
	}
	public void addbudget(String name , String descr , String date, String cost,String type ) {
		this.Name.sendKeys(name);
		this.Description.sendKeys(descr);
		this.Date.sendKeys(date);
		this.Cost.sendKeys(cost);
		this.Type.selectByValue(type);
		this.submitBtn.click();
	}
	

	public void delete(int x) {
		this.delete = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody["+x+"]/tr/td[7]/div/button[1]"));
		this.delete.click();
	}
	
	public void clickUpdate(int x) {
		this.update = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody["+x+"]/tr/td[7]/div/button[2]"));
		this.update.click();
	}
	public void update(String name ,String descr ,String date,String cost ,String type) {
		this.Name.clear();
		this.Name.sendKeys(name);
		this.Description.clear();
		this.Description.sendKeys(descr);
		this.Date.clear();
		this.Date.sendKeys(date);
		this.Cost.clear();
		this.Cost.sendKeys(cost);
		this.Type.selectByValue(type);
		this.submitBtn.click();
	}
	
	

	
	
	
}