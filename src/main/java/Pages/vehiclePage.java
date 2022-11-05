package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class vehiclePage {
	//*[@id="root"]/div[3]/div/div[2]/div/h6[1]

	WebDriver driver;

	public String man;
	public String model;
	public String year;
	public String licen;
	public String insu;



	
	public vehiclePage(WebDriver driver) {
		this.driver = driver;
		this.man = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div/h6[1]")).getText();
		this.model = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div/h6[2]")).getText();
		this.year = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div/h6[3]")).getText();
		this.licen = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div/h6[4]")).getText();
		this.insu = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div/h6[5]")).getText();
	
		
	}

}
