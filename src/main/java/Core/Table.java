package Core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Table {
	WebDriver driver;
	WebElement table;
	public Table(WebDriver driver, WebElement table) {
		this.driver = driver;
		this.table = table;
		// TODO Auto-generated constructor stub
	}
	
	public int getColumnsNumber() {
		List<WebElement> headers = this.getHeadersElements();
		for(int i=0;i<headers.size();i++) {
			
		}
		int headrs_num = headers.size();
		return headrs_num;
	}
	
	public List<WebElement> getHeadersElements(){
		List<WebElement> headers = table.findElements(By.xpath("//thead/tr/th"));
		return headers;
	}
	
	public List<WebElement> getRowsElements(){
		List<WebElement> rows = table.findElements(By.xpath("//tbody/tr"));
		return rows;
	}
	
	public int getRowNumber() {
		List<WebElement> rows = this.getRowsElements();
		int row_num = rows.size();
		return row_num;
	}
	
	public String getCellValue(int rowIndex, String columnHeader) {
		List<WebElement> headers = this.getHeadersElements();
		List<WebElement> rows = this.getRowsElements();
		for(int i=0;i<headers.size();i++) {
			if(headers.get(i).getText().equalsIgnoreCase(columnHeader)) {
				return rows.get(rowIndex).findElements(By.tagName("td")).get(i).getText();
			}
		}
		return "";
	}
	
	
}