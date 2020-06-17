package testcases;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

public class UDFUtility extends BaseTest {

	public static WebDriver driver;
	// enter value into text box
public static WebDriverWait wait;
	// OPen Browser
	public static void OpenBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Driver//chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.setAcceptInsecureCerts(true);
		opt.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver = new ChromeDriver(opt);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	    driver.get(url);
	}

	public static void setText(String locatorValue, String value) throws InterruptedException {

		// By locatorname=locator;
		waitForElementVisible(locatorValue);
		  waitForElementClickable (locatorValue);
		 
		driver.findElement(By.xpath(locatorValue)).clear();
		  Thread.sleep(1000);
		driver.findElement(By.xpath(locatorValue)).sendKeys(value);
		Thread.sleep(1000);
	}
	
	public static void selectValueFromDropdown(String locatorValue, String value) throws InterruptedException {

		// By locatorname=locator;
		 Thread.sleep(1000);
		new Select(driver.findElement(By.xpath(locatorValue))).selectByValue(value);;
	}
	
	public static void selectTextFromDropdown(String locatorValue, String value) {

		// By locatorname=locator;
		new Select(driver.findElement(By.xpath(locatorValue))).selectByVisibleText(value);;
	}
	
	public static By byLocator(String locatorname) {

		return By.xpath(locatorname);
	}

	public static void click(String xpath) throws InterruptedException {
		waitForElementVisible(xpath);
		  waitForElementClickable (xpath);
		 
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static void rightClick(String xpath) throws InterruptedException {
		waitForElementVisible(xpath);
		  waitForElementClickable (xpath);
		  WebElement ele=driver.findElement(By.xpath(xpath));
		 Actions a=new Actions(driver);
		 a.contextClick(ele).build().perform();
		///driver.findElement(By.xpath(xpath)).click();
	}
	
	public static void waitForElementVisible(String xpath) throws InterruptedException
	{
			wait=new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));	
	}
	
	public static void waitForElementClickable(String xpath) throws InterruptedException
	{
			wait=new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	
	public static boolean isDisplayed(String xpath) {
		return driver.findElement(By.xpath(xpath)).isDisplayed();
	}
	
	public static HashMap<Integer, String> getPEItem()
	{
		HashMap<Integer,String> map=new HashMap<Integer,String>();
		
		map.put(1,"QD-MPS-FG");
		map.put(2,"QD-MPS-MAKE");
		map.put(3,"QD-MRP-MAKE");
		map.put(4,"QD-MRP-CH");
		map.put(5,"QD-MRP-BUY-CH");
		map.put(6,"QD-MPS-BUY-CH");
		map.put(7,"QD-MPS-BUY");
		map.put(8,"QD-MRP-BUY");
		map.put(9,"QD-MRP-TF-SC");
		map.put(10,"QD-MPS-TF-SC");
		map.put(11,"QD-MRP-TF-DC");
		map.put(12,"QD-MPS-TF-DC");
		map.put(13,"QD-MRP-MA-SC");
		map.put(14,"QD-MPS-MA-SC");
		map.put(15,"QD-MPS-RCCP-I");
		map.put(16,"QD-MPS-BUY-RCCP-I");
		map.put(17,"QD-MRP-RCCP-I");
		map.put(18,"QD-MRP-BUY-RCCP-I");
		map.put(19,"QD-MPS-MA-DC");
		map.put(20,"QD-MPS-BUY-MA-DC");
		map.put(21,"QD-MRP-MA-DC");
		map.put(22,"QD-MRP-BUY-MA-DC");
        map.put(23,"QD-MPS-BUY-MA-SC");
        map.put(24,"QD-MRP-BUY-MA-SC");
//		map.put(25,"Q-MRP-MAKE");
//		map.put(26,"Q-MRP-CH");
//		map.put(27,"-MRP-BUY-CH");
//		map.put(28,"P-MPS-BUY-CH");
//		map.put(29,"P-MPS-BUY");
//		map.put(30,"P-MRP-BUY");
//		map.put(31,"P-MRP-TF-SC");
//		map.put(32,"P-MPS-TF-SC");
//		map.put(33,"P-MRP-TF-DC");
//		map.put(34,"P-MPS-TF-DC");
//		map.put(35,"P-MRP-MA-SC");
//		map.put(36,"P-MPS-MA-SC");
//		map.put(37,"P-MPS-RCCP-I");
//		map.put(38,"P-MPS-BUY-RCCP-I");
//		map.put(39,"P-MRP-RCCP-I");
//		map.put(40,"P-MRP-BUY-RCCP-I");
//		map.put(41,"P-MPS-MA-DC");
//		map.put(40,"P-MPS-BUY-MA-DC");
//		map.put(43,"P-MRP-MA-DC");
//		map.put(44,"P-MRP-BUY-MA-DC");
//		map.put(45,"R-MPS-FG");
//		map.put(46,"R-MPS-MAKE");
//		map.put(47,"R-MRP-MAKE");
//		map.put(48,"R-MRP-CH");
//		map.put(49,"R-MRP-BUY-CH");
//		map.put(50,"R-MPS-BUY-CH");
//		map.put(51,"R-MPS-BUY");
//		map.put(52,"R-MRP-BUY");
//		map.put(53,"R-MRP-TF-SC");
//		map.put(54,"R-MPS-TF-SC");
//		map.put(55,"R-MRP-TF-DC");
//		map.put(56,"R-MPS-TF-DC");
//		map.put(57,"R-MRP-MA-SC");
//		map.put(58,"R-MPS-MA-SC");
//		map.put(59,"R-MPS-RCCP-I");
//		map.put(60,"R-MPS-BUY-RCCP-I");
//		map.put(61,"R-MRP-RCCP-I");
//		map.put(62,"R-MRP-BUY-RCCP-I");
//		map.put(63,"R-MPS-MA-DC");
//		map.put(64,"R-MPS-BUY-MA-DC");
//		map.put(65,"R-MRP-MA-DC");
//		map.put(66,"R-MRP-BUY-MA-DC");

		return map;
	}

	public static HashMap<Integer, String> getSourceItem()
	{
		HashMap<Integer,String> map=new HashMap<Integer,String>();
		
		map.put(1,"QA-MPS-FG:SerialTracked:1:M:1:QA-MPS-FG");
		map.put(2,"QA-MPS-MAKE:Serial:1:M:1:QA-MPS-MAKE");
		map.put(3,"QA-MRP-MAKE:Serial:1:M:2:QA-MRP-MAKE");
		map.put(4,"QA-MRP-CH:Serial Tracked:1:B:2:QA-MRP-CH");
		map.put(5,"QA-MRP-BUY-CH:Seral:1:B:2:QA-MRP-BUY-CH");
		map.put(6,"QA-MPS-BUY-CH:Serial:1:B:1:QA-MPS-BUY-CH");
		map.put(7,"QA-MPS-BUY:Batch Tracked:2:B:1:QA-MPS-BUY");
		map.put(8,"QA-MRP-BUY:Batch Tracked:2:B:2:QA-MRP-BUY");
		map.put(9,"QA-MRP-TF-SC:Serial Tr:1:B:2:QA-MRP-TF-SC");
		map.put(10,"QA-MPS-TF-SC:Serial Tr:1:B:1:QA-MPS-TF-SC");
		map.put(11,"QA-MRP-TF-DC-01:Serial T:1:B:2:QA-MRP-TF-DC");
		map.put(12,"QA-MPS-TF-DC-01:Serial T:1:B:1:QA-MPS-TF-DC");
		map.put(13,"QA-MRP-MA-SC:Batch:2:M:2:QA-MRP-MA-SC");
		map.put(14,"QA-MPS-MA-SC:Batch:2:M:1:QA-MPS-MA-SC");
		map.put(15,"QA-MPS-RCCP-I:None:0:M:1:QA-MPS-RCCP-I");
		map.put(16,"QA-MPS-BUY-RCCP-I:None:0:B:1:QA-MPS-BUY-RCCP-I");
		map.put(17,"QA-MRP-RCCP-I:None:0:M:2:QA-MRP-RCCP-I");
		map.put(18,"QA-MRP-BUY-RCCP-I:None:0:B:2:QA-MRP-BUY-RCCP-I");
		map.put(19,"QA-MPS-MA-DC-01:None Tracked:0:M:1:QA-MPS-MA-DC");
		map.put(20,"QA-MPS-BUY-MA-DC-01:None Tracked:0:B:1:QA-MPS-BUY-MA-DC");
		map.put(21,"QA-MRP-MA-DC-01:None Tracked:0:M:2:QA-MRP-MA-DC");
		map.put(22,"QA-MRP-BUY-MA-DC-01:None Tracked:0:B:2:QA-MRP-BUY-MA-DC");
		map.put(23,"QA-MRP-BUY-MA-SC:None Tracked:0:B:2:QA-MRP-BUY-MA-SC");
		map.put(24,"QA-MPS-BUY-MA-SC:None Tracked:0:B:1:QA-MPS-BUY-MA-SC");		
		map.put(25,"QB-MPS-FG:SerialTracked:1:M:1:QB-MPS-FG");
		map.put(26,"QB-MPS-MAKE:Serial:1:M:1:QB-MPS-MAKE");
		map.put(27,"QB-MRP-MAKE:Serial:1:M:2:QB-MRP-MAKE");
		map.put(28,"QB-MRP-CH:Serial Tracked:1:B:2:QB-MRP-CH");
		map.put(29,"QB-MRP-BUY-CH:Seral:1:B:2:QB-MRP-BUY-CH");
		map.put(30,"QB-MPS-BUY-CH:Serial:1:B:1:QB-MPS-BUY-CH");
		map.put(31,"QB-MPS-BUY:Batch Tracked:2:B:1:QB-MPS-BUY");
		map.put(32,"QB-MRP-BUY:Batch Tracked:2:B:2:QB-MRP-BUY");
		map.put(33,"QB-MRP-TF-SC:Serial Tr:1:B:2:QB-MRP-TF-SC");
		map.put(34,"QB-MPS-TF-SC:Serial Tr:1:B:1:QB-MPS-TF-SC");
		map.put(35,"QB-MRP-TF-DC-01:Serial T:1:B:2:QB-MRP-TF-DC");
		map.put(36,"QB-MPS-TF-DC-01:Serial T:1:B:1:QB-MPS-TF-DC");
		map.put(37,"QB-MRP-MA-SC:Batch:2:M:2:QB-MRP-MA-SC");
		map.put(38,"QB-MPS-MA-SC:Batch:2:M:1:QB-MPS-MA-SC");
		map.put(39,"QB-MPS-RCCP-I:None:0:M:1:QB-MPS-RCCP-I");
		map.put(40,"QB-MPS-BUY-RCCP-I:None:0:B:1:QB-MPS-BUY-RCCP-I");
		map.put(41,"QB-MRP-RCCP-I:None:0:M:2:QB-MRP-RCCP-I");
		map.put(42,"QB-MRP-BUY-RCCP-I:None:0:B:2:QB-MRP-BUY-RCCP-I");
		map.put(43,"QB-MPS-MA-DC-01:None Tracked:0:M:1:QB-MPS-MA-DC");
		map.put(44,"QB-MPS-BUY-MA-DC-01:None Tracked:0:B:1:QB-MPS-BUY-MA-DC");
		map.put(45,"QB-MRP-MA-DC-01:None Tracked:0:M:2:QB-MRP-MA-DC");
		map.put(46,"QB-MRP-BUY-MA-DC-01:None Tracked:0:B:2:QB-MRP-BUY-MA-DC");
		map.put(47,"QB-MRP-BUY-MA-SC:None Tracked:0:B:2:QB-MRP-BUY-MA-SC");
		map.put(48,"QB-MPS-BUY-MA-SC:None Tracked:0:B:1:QB-MPS-BUY-MA-SC");	
		
		return map;
	}

	public static HashMap<Integer, String> getResource()
	{
		HashMap<Integer,String> map=new HashMap<Integer,String>();
	
		map.put(1,"TEST-RC-01:test:M:2");	
		map.put(2,"TEST-RC1-M-R-I:test:M:2");	
		map.put(3,"TEST-RC2-M-R-I:test:L:1");	
		map.put(4,"TEST-RC3-M-R-I:test:O:3");	
		map.put(5,"TEST-RC1-MR-R-I:test:M:2");	
		map.put(6,"TEST-RC2-MR-R-I:test:L:1");	
		map.put(7,"TEST-RC3-MR-R-I:test:O:3");	
		
		return map;
	}
	
	public void checkTestCase(String Actual) {
		Assert.assertTrue(driver.getCurrentUrl().contains(Actual));
	}
	
	public void checkStatus(String Actual,String Expected) {
		Assert.assertEquals(Actual,Expected);
	}
}
