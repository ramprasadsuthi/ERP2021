package pack1;

//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import commonMethods.Base;

public class TG1 {
	
  Base cm;

  @BeforeTest
  public void createTestData() {
	  System.out.println("Here we can write the code for creating TestData");
  }
  
  @AfterTest
  public void cleanUpTestData() {
	  System.out.println("Here we can write the code for Cleaning up the TestData");
  }
  
  @BeforeMethod
  public void launchBrowser() {
	  cm = new Base();
	  cm.launchBrowser();
  }
  
  @AfterMethod
  public void closeBrowser() {
	   cm.closeBrowser();
  }
  
  @Test (priority = 3, groups = "Login")
  public void TestCase_1_Login() {
	  
	  cm.launchERP();
	  cm.loginERP();
	
  }
  
  @Test (priority = 2, groups = "StockItems")
  public void TestCase_2_AccessStockItemsPage() {
	  
	  cm.launchERP();
	  cm.loginERP();
	  cm.AccessToStockItems();
	  
  }
  
  @Test (priority = 1, groups = "StockItems")
  public void TestCase_3_AddStockItem() {
	  
	  cm.launchERP();
	  cm.loginERP();
	  cm.AccessToStockItems();
	  cm.AccessToAddStockItemPage();
	  cm.AddStockItem();
	
  }
  

}
