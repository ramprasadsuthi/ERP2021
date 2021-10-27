package commonMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Base {
	
	public static WebDriver driver;
	
	 public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
	 }
	 
	 public void launchERP() {
		driver.get("http://projects.qedgetech.com/webapp/login.php");
	 }
	 
	 public void loginERP() {
		 
		    driver.findElement(By.xpath("//input[@id='username']")).clear();
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@id='password']")).clear();
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("master");
			driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String homepage = driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
			Assert.assertEquals(homepage, "Dashboard");
			
	 }
	 
	 public void AccessToStockItems() {
			
		 driver.findElement(By.xpath("//a[contains(text(),'Stock Items ')]")).click();
		 String actualResult = driver.findElement(By.xpath("//span[@id='ewPageCaption']")).getText();
		 
		 if(actualResult.equals("Stock Items")) {
			 System.out.println("Stock Items page opened..");
		 }
		 else {
			 System.out.println("Stock Items page not found..");
		 }
	
	 }
	 
	 public void AccessToAddStockItemPage() {
		 
		 driver.findElement(By.xpath("(//span[@data-caption='Add'])[1]")).click();
	 }
	 
	 public void selectStockCategories() throws Throwable {
			
		    WebElement stockItems = driver.findElement(By.xpath("//a[contains(text(),\"Stock Items \")]"));
			
			Actions actions=new Actions(driver);
			actions.moveToElement(stockItems).build().perform();
			
			WebElement stockCat = driver.findElement(By.xpath("//li[@id='mmi_a_stock_categories']/following::a[@href='a_stock_categorieslist.php']"));
			actions.moveToElement(stockCat).build().perform();
			
			stockCat.click();
		}
	 
	 public void AddStockItem() {
		 
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			Select category = new Select(driver.findElement(By.id("x_Category")));
			category.selectByVisibleText("Pencil");
			Select supplierNumber = new Select(driver.findElement(By.id("x_Supplier_Number")));
			supplierNumber.selectByVisibleText("sony");
			WebElement stockName = driver.findElement(By.xpath("//input[@id='x_Stock_Name']"));
			stockName.sendKeys("Dell Keyboard");
			Select uom = new Select(driver.findElement(By.id("x_Unit_Of_Measurement")));
			uom.selectByVisibleText("Units");
			WebElement purchasePrice = driver.findElement(By.xpath("//input[@id='x_Purchasing_Price']"));
			purchasePrice.sendKeys("100000");
			WebElement sellingPrice = driver.findElement(By.xpath("//input[@id='x_Selling_Price']"));
			sellingPrice.sendKeys("125000");
			WebElement notes = driver.findElement(By.xpath("//input[@id='x_Notes']"));
			notes.sendKeys("Dell Keyboard");
			WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
			submit.click();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			String alertWindow = driver.getWindowHandle();	
			driver.switchTo().window(alertWindow);
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			WebElement confirm = driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']"));
			confirm.click();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	 }	
	 
	 public void selectUOM() throws Throwable {
			
		    WebElement stockItems = driver.findElement(By.xpath("//a[contains(text(),\"Stock Items \")]"));
			
			Actions actions=new Actions(driver);
			actions.moveToElement(stockItems).build().perform();
			
			WebElement uom = driver.findElement(By.xpath("//li[@id='mi_a_unit_of_measurement']/a[@href='a_unit_of_measurementlist.php']"));
			actions.moveToElement(uom).build().perform();
			
			uom.click();
		}
	 
	 public void closeBrowser()  {
			    driver.close();
	 }

}
