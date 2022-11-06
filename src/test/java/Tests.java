

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
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
		outputHeaders.add("Manufacturer");
		outputHeaders.add("Model");
		outputHeaders.add("Year");
		outputHeaders.add("License");
		outputHeaders.add("Insurance");
	
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
		Thread.sleep(4000);
		takeScr.takeScreenShot("afterDelete.png");
		workers.clickUpdate(1);
		Thread.sleep(5000);
		workers.update( "eissa" , "Male" , "Taxi (D1)");
		Thread.sleep(4000);
		takeScr.takeScreenShot("afterUpdate.png");
		Table workerTable = new Table(driver,workers.table);
		int workersNum =  workerTable.getRowNumber();
		while(workersNum>0) {
			workers.delete(1);
			driver.switchTo().alert().accept();
			workersNum--;
			Thread.sleep(4000);
		}
		
		
		
}
	@Test
	public void vehicles() throws InterruptedException, IOException {
			Thread.sleep(4000);
			HomePage home = new HomePage(driver);
			home.vehicles();
			vehcilesPage vehciles = new vehcilesPage(driver);
			Thread.sleep(5000);
			takeScr.takeScreenShot("BeforeAddNewCar.png");
			vehciles.addVehicle("Toyata", "Coralla", "2007", "11112023",	"11102025");
			Thread.sleep(5000);
			takeScr.takeScreenShot("AfterAddNewCar.png");
			Table vehicleTable = new Table(driver,vehciles.table);
			Thread.sleep(4000);
			int lastCar = vehicleTable.getRowNumber();
			vehciles.more(lastCar);
			Thread.sleep(5000);
			vehiclePage vehicle = new vehiclePage(driver);
		    Assert.assertEquals(vehicle.man.contains("Toyata"), true);
		    Assert.assertEquals(vehicle.model.contains( "Coralla"), true);
		    Assert.assertEquals(vehicle.year.contains("2007"), true);
			Assert.assertEquals(vehicle.licen.contains("2023-11-11"), true);
			Assert.assertEquals(vehicle.insu.contains("2025-11-10"), true);
			home.vehicles();
			Thread.sleep(5000);
			vehciles = new vehcilesPage(driver);
			vehicleTable = new Table(driver,vehciles.table);
			lastCar = vehicleTable.getRowNumber();
			vehciles.clickUpdate(lastCar);
			Thread.sleep(4000);
			vehciles.update("Ferrari" , "Fr" , "2021","15122025" , "11032030");
			Thread.sleep(4000);
			takeScr.takeScreenShot("AfterUpdateTheNewCar.png");
			Thread.sleep(4000);
			vehciles.delete(lastCar);
			driver.switchTo().alert().accept();
			Thread.sleep(4000);
			takeScr.takeScreenShot("afterDeletTheAddedCar.png");
		for(int i =0 ;i<lastCar-1;i++) {
			ArrayList<String> currOutput = new ArrayList<String>();
			currOutput.add(vehicleTable.getCellValue(i, "Manufacturer"));
			currOutput.add(vehicleTable.getCellValue(i, "Model"));
			currOutput.add(vehicleTable.getCellValue(i, "Year"));
			currOutput.add(vehicleTable.getCellValue(i, "License"));
			currOutput.add(vehicleTable.getCellValue(i, "Insurance"));
			outputData.add(currOutput);
		}
		List<String[]> data = new ArrayList<String[]>();
		for(ArrayList<String> row: outputData) {
			String[] row_data = new String[row.size()];
			for(int i= 0;i<row.size();i++) {
				row_data[i] = row.get(i);
			}
			data.add(row_data);
		}
		String[] header = new String[outputHeaders.size()];
		for(int i= 0;i<outputHeaders.size();i++) {
			header[i] = outputHeaders.get(i);
		}
		WriteCsvFile.writeDataLineByLine("vehciles.csv", data, header);
		
			
			
	}
	@Test
	public void chagePassword() throws InterruptedException, IOException {
		Thread.sleep(4000);
		HomePage home = new HomePage(driver);
		home.change();
		changePassPage change = new changePassPage(driver);
		change.change("123");
		Thread.sleep(4000);
		home.logout();
		Thread.sleep(4000);
		LoginPage login = new LoginPage(driver);
		login.login("test@test.com","123");
		Thread.sleep(4000);
		home = new HomePage(driver);
		home.change();
		change = new changePassPage(driver);
		change.change("209349935");
	}
	@Test
	public void getAdmins() throws InterruptedException, IOException {
		ArrayList<String> outputHeaders = new ArrayList<String>();
		ArrayList<ArrayList<String>> outputData = new ArrayList<ArrayList<String>>();
		outputHeaders.add("ID");
		outputHeaders.add("Name");
		outputHeaders.add("Email");
		outputHeaders.add("Phone Number");
		outputHeaders.add("Age");
		Thread.sleep(4000);
		HomePage home = new HomePage(driver);
		home.admins();
		adminsPage admins = new adminsPage(driver);
		Table adminsTable = new Table(driver,admins.table);
		Thread.sleep(4000);
		 int adminNum = adminsTable.getRowNumber();
			
			for(int i =0 ;i<adminNum;i++) {
				ArrayList<String> currOutput = new ArrayList<String>();
				currOutput.add(adminsTable.getCellValue(i, "ID"));
				currOutput.add(adminsTable.getCellValue(i, "Name"));
				currOutput.add(adminsTable.getCellValue(i, "Email"));
				currOutput.add(adminsTable.getCellValue(i, "Phone Number"));
				currOutput.add(adminsTable.getCellValue(i, "Age"));
				outputData.add(currOutput);
			}
			List<String[]> data = new ArrayList<String[]>();
			for(ArrayList<String> row: outputData) {
				String[] row_data = new String[row.size()];
				for(int i= 0;i<row.size();i++) {
					row_data[i] = row.get(i);
				}
				data.add(row_data);
			}
			String[] header = new String[outputHeaders.size()];
			for(int i= 0;i<outputHeaders.size();i++) {
				header[i] = outputHeaders.get(i);
			}
			WriteCsvFile.writeDataLineByLine("admins.csv", data, header);
			takeScr.takeScreenShot("BeforeAddNewAdmin.png");
			admins.addAdmin("123456789", "rasha", "rasha@techilc.com", "1234567890", "25");
			Thread.sleep(5000);
			takeScr.takeScreenShot("AfterAddNewAdmin.png");
			admins.more(adminNum+1);
			Thread.sleep(4000);
			adminPage admin = new adminPage(driver);
			 Assert.assertEquals(admin.name.contains("rasha"), true);
			  Assert.assertEquals(admin.email.contains( "rasha@techilc.com"), true);
			  Assert.assertEquals(admin.number.contains("1234567890"), true);
			  Assert.assertEquals(admin.age.contains("25"), true);
			  home.admins();
			Thread.sleep(5000);
			admins = new adminsPage(driver);
			adminsTable = new Table(driver,admins.table);
			adminNum = adminsTable.getRowNumber();
			admins.delete(adminNum);
			driver.switchTo().alert().accept();
			Thread.sleep(4000);
			takeScr.takeScreenShot("AfterDeleteAdmin.png");
			
	}
	@Test
	public void budget() throws InterruptedException, IOException {
		ArrayList<String> outputHeaders = new ArrayList<String>();
		ArrayList<ArrayList<String>> outputData = new ArrayList<ArrayList<String>>();
		outputHeaders.add("Name");
		outputHeaders.add("Description");
		outputHeaders.add("Date");
		outputHeaders.add("Cost");
		outputHeaders.add("Type");
		Thread.sleep(4000);
		HomePage home = new HomePage(driver);
		home.budget();
		budgetsPage budgets = new budgetsPage(driver);
		Thread.sleep(5000);
		takeScr.takeScreenShot("BeforeAddNewBudget.png");
		budgets.addbudget("Automation", "course", "05112022", "0", "Income");
		Thread.sleep(5000);
		takeScr.takeScreenShot("AfterAddNewBudgets.png");
		Table budgetTable = new Table(driver,budgets.table);
		Thread.sleep(4000);
		int lastbudget = budgetTable.getRowNumber();
		budgets.clickUpdate(lastbudget);
		Thread.sleep(4000);
		budgets.update("gas" , "car gas" , "05122023","5000" , "Outcome");
		Thread.sleep(4000);
		takeScr.takeScreenShot("AfterUpdateTheNewBudget.png");
		Thread.sleep(4000);
		budgets.delete(lastbudget);
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
		takeScr.takeScreenShot("afterDeletTheAddedBudgetr.png");
	
			
			for(int i =0 ;i<lastbudget-1;i++) {
				ArrayList<String> currOutput = new ArrayList<String>();
				currOutput.add(budgetTable.getCellValue(i, "Name"));
				currOutput.add(budgetTable.getCellValue(i, "Description"));
				currOutput.add(budgetTable.getCellValue(i, "Date"));
				currOutput.add(budgetTable.getCellValue(i, "Cost"));
				currOutput.add(budgetTable.getCellValue(i, "Type"));
				outputData.add(currOutput);
			}
			List<String[]> data = new ArrayList<String[]>();
			for(ArrayList<String> row: outputData) {
				String[] row_data = new String[row.size()];
				for(int i= 0;i<row.size();i++) {
					row_data[i] = row.get(i);
				}
				data.add(row_data);
			}
			String[] header = new String[outputHeaders.size()];
			for(int i= 0;i<outputHeaders.size();i++) {
				header[i] = outputHeaders.get(i);
			}
			WriteCsvFile.writeDataLineByLine("budgets.csv", data, header);
		
		
		
	}
	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
}