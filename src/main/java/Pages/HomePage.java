package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	WebElement home;
	WebElement workers;
	WebElement vehicles;
	WebElement schedule;
	WebElement budget;
	WebElement admins;
	WebElement change;
	WebElement logout;

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.home = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/ul/li[1]"));
		this.workers = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/ul/li[2]"));
		this.vehicles = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/ul/li[3]"));
		this.schedule = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/ul/li[4]"));
		this.budget = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/ul/li[5]"));
		this.admins = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/ul/li[6]"));
		this.change = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/ul/li[8]"));
		this.logout = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/ul/li[9]/button"));

		
	}
	
	public void home() {
	this.home.click();
	}
	public void workers() {
		this.workers.click();
		}
	public void vehicles() {
		this.vehicles.click();
		}
	public void schedule() {
		this.schedule.click();
		}
	public void budget() {
		this.budget.click();
		}
	public void admins() {
		this.admins.click();
		}
	public void change() {
		this.change.click();
		}
	public void logout() {
		this.logout.click();
		}
}