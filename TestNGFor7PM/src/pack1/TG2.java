package pack1;

//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import commonMethods.Base;

public class TG2 {
	
  Base cm;

  @BeforeMethod
  public void launchBrowser() {
	  cm = new Base();
	  cm.launchBrowser();
  }
  
  @AfterMethod
  public void closeBrowser() {
	   cm.closeBrowser();
  }
  
  @Test
  public void TestCase_4_selectStockCategories() throws Throwable {
	  
	  cm.launchERP();
	  cm.loginERP();
	  cm.AccessToStockItems();
	  cm.selectStockCategories();
	
  }
  
 

}
