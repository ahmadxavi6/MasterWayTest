

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import Core.*;



import Pages.*;







public class Tests {
	WebDriver driver;
	TakeScreenShot takeScr;

	int x =1;

	ArrayList<String> outputHeaders = new ArrayList<String>();
	ArrayList<ArrayList<String>> outputData = new ArrayList<ArrayList<String>>();
	@BeforeSuite
	public void beforeSuite() throws InterruptedException, FileNotFoundException, IOException {
//		driver = OpenBrowsers.openchromeWithOptions();
		driver = OpenBrowsers.openBrowser("chrome");
		takeScr = new TakeScreenShot(driver);
	
		driver.manage().window().maximize();
		Thread.sleep(500);
		driver.get("https://vigorous-meninsky-e72496.netlify.app/");
		FileReader readFile=new FileReader("cred.properities");
		Properties prop= new Properties();
		prop.load(readFile);
		String email = prop.getProperty("email");
		String password = prop.getProperty("password");
		
	
		LoginPage login = new LoginPage(driver);
		login.login(email,password);
	
		
	}

	@DataProvider
	public static Object[][] getData() throws Exception{

		List<String[]> lines = ReadCsvFile.readAllLines("workers.csv");
		lines.remove(0);
		Object[][] data = new Object[lines.size()][lines.get(0).length];
		int index = 0;
		for(String[] line : lines) {
			data[index] = line;
			index++;
		}
		return data;
	}
	@Test(dataProvider = "getData")
	public void addWorkers(String ID , String name , String email , String number , String address,String age ,String gender , String license) throws IOException, InterruptedException {
Thread.sleep(4000);
		HomePage home = new HomePage(driver);
	home.workers();
	workersPage workers = new workersPage(driver);
	
	workers.addWorker(ID, name, email, number, address, age, gender, license);
	Thread.sleep(5000);
    workers.more(x);
    Thread.sleep(5000);
    workerPage worker = new workerPage(driver);

    Thread.sleep(1000);
    Assert.assertEquals(worker.name.contains(name), true);
    Assert.assertEquals(worker.email.contains(email), true);
    Assert.assertEquals(worker.number.contains(number), true);
    Assert.assertEquals(worker.address.contains(address), true);
    Assert.assertEquals(worker.gender.contains(gender), true);
    Assert.assertEquals(worker.license.contains(license), true);
    Assert.assertEquals(worker.age.contains(age), true);
    System.out.println("All Equals");

    x++;

	
	}
	@Test
public void updateAndDeleteTest() throws InterruptedException, IOException {
		Thread.sleep(4000);
		HomePage home = new HomePage(driver);
		home.workers();
		
		workersPage workers = new workersPage(driver);
		Thread.sleep(1000);
		takeScr.takeScreenShot("BeforeDeleteAndUpdate.png");
		workers.delete(1);
		driver.switchTo().alert().accept();
	
		Thread.sleep(1000);
		takeScr.takeScreenShot("afterDelete.png");
		workers.clickUpdate(1);
		Thread.sleep(5000);
		workers.update( "eissa" , "Male" , "Taxi (D1)");
		Thread.sleep(4000);
		takeScr.takeScreenShot("afterUpdate.png");
		
		
		
}
	
//	@AfterSuite
//	public void afterSuite() {
//		driver.quit();
//		List<String[]> data = new ArrayList<String[]>();
//		for(ArrayList<String> row: outputData) {
//			String[] row_data = new String[row.size()];
//			for(int i= 0;i<row.size();i++) {
//				row_data[i] = row.get(i);
//			}
//			data.add(row_data);
//		}
//		String[] headers = new String[outputHeaders.size()];
//		for(int i= 0;i<outputHeaders.size();i++) {
//			headers[i] = outputHeaders.get(i);
//		}
//		WriteCsvFile.writeDataLineByLine("output.csv", data, headers);
//		
//	}
}