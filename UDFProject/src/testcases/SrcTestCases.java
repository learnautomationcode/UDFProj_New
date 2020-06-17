package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(res.listeners.class)
public class SrcTestCases extends UDFUtility {

	public static Properties prop = new Properties();;

	@BeforeMethod
	public void init() throws IOException {
		
		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir") + "/data.properties"));

		prop.load(fis);
		
		//OpenBrowser(prop.getProperty("url"));	
	}
//	@AfterMethod
//	public void TearDown()
//	{
//		
//	}
	
		
    @Test(priority=1)
	public void LoginSE() throws InterruptedException
	{
		OpenBrowser (prop.getProperty("url"));
		
		selectValueFromDropdown (prop.getProperty("company_xpath"), prop.getProperty("sourcecompany"));
		
		setText (prop.getProperty("username_xpath"), prop.getProperty("username"));
		
		setText (prop.getProperty("password_xpath"), prop.getProperty("password"));
		
		click (prop.getProperty ("loginclick"));
		
		try
		{	
			if(isDisplayed(prop.getProperty("cross_xpath")))
			{
			click(prop.getProperty("cross_xpath"));
			}
		}
		catch(Exception e)
		{
			System.out.println("No cross button");
		}
		waitForElementVisible(prop.getProperty("message_xpath"));
	}

	//  Create Item Master Data in Planning Engine
	//@Test(priority=2)
	public void addItemPE() throws IOException, InterruptedException 
	{
		click(prop.getProperty("inventory_xpath"));
		
		click(prop.getProperty("itemmasterdata_xpath"));
		
		click(prop.getProperty("addmode_xpath"));
		// SoftAssert a = null;
	    for(int i=1;i<=UDFUtility.getPEItem().size();i++)
		{
	    	
	    	setText (prop.getProperty("itempe_xpath"), UDFUtility.getPEItem().get(i));

	    // driver.findElement(By.xpath(prop.getProperty("itempe_xpath"))).sendKeys(UDFUtility.getPEItem().get(i));
	
	  // 	String text=driver.findElement(By.xpath(prop.getProperty("itempe_xpath"))).getAttribute("value");
	    	
		  click (prop.getProperty("add_xpath"));
		  
		//  a=new SoftAssert();
		  //a.assertEquals(text, UDFUtility.getPEItem().get(i))
		}
	    //a.assertAll();
	    Assert.assertTrue(true);
	}

//  Create Item Master Data in Source Engine
	//@Test(priority=2)
	public void addItemSE() throws IOException, InterruptedException 
	{
		click(prop.getProperty("inventory_xpath"));
		
		click(prop.getProperty("itemmasterdata_xpath"));

		click(prop.getProperty("addmode_xpath"));
		
		for(int i=1;i<=UDFUtility.getSourceItem().size();i++)
		{
	      Thread.sleep(2000);
		  setText (prop.getProperty("itemse_xpath"), UDFUtility.getSourceItem().get(i).split(":")[0]);
			 
		 // setText (prop.getProperty("description_xpath"), UDFUtility.getSourceItem().get(i).split(":")[1]);
	
		//  click (prop.getProperty("foreignname_xpath"));
		
		  selectValueFromDropdown (prop.getProperty("manageitemby_xpath"), UDFUtility.getSourceItem().get(i).split(":")[2]);
	
		  click (prop.getProperty("inventorydata_xpath"));
		
		  click (prop.getProperty("manageinvbywhse_xpath"));
		
		  click (prop.getProperty("planningdata_xpath"));
		  
		  Thread.sleep(700);
		  selectValueFromDropdown (prop.getProperty("procurementmethod_xpath"), UDFUtility.getSourceItem().get(i).split(":")[3]);
		
		  Thread.sleep(700);
		  selectValueFromDropdown (prop.getProperty("optiproplanningtype_xpath"), UDFUtility.getSourceItem().get(i).split(":")[4]);
		
		  waitForElementClickable(prop.getProperty("dtf_xpath"));
		  selectValueFromDropdown (prop.getProperty("dtf_xpath"), prop.getProperty("dtfvalue"));

		  selectValueFromDropdown (prop.getProperty("ptf_xpath"), prop.getProperty("ptfvalue"));

		  selectValueFromDropdown (prop.getProperty("rtf_xpath"), prop.getProperty("rtfvalue"));
		
		  
		  waitForElementClickable(prop.getProperty("plannintitem_xpath"));
		 
		  click (prop.getProperty("plannintitem_xpath"));
		
		  waitForElementVisible(prop.getProperty("find_xpath"));
			 
		  waitForElementClickable(prop.getProperty("find_xpath"));
		 
		  setText (prop.getProperty("find_xpath"), UDFUtility.getSourceItem().get(i).split(":")[5]);
		  
		  
		  waitForElementClickable(prop.getProperty("choose_xpath"));
		  
		  click (prop.getProperty("choose_xpath"));
		
		 // Thread.sleep(4000);
		  waitForElementVisible(prop.getProperty("add_xpath"));
		  waitForElementClickable(prop.getProperty("add_xpath"));
		  click (prop.getProperty("add_xpath"));
		  Thread.sleep(3000);
		  waitForElementClickable(prop.getProperty("general_xpath"));
			 
		  click (prop.getProperty("general_xpath"));
		  Thread.sleep(700);
		  waitForElementClickable(prop.getProperty("itemse_xpath"));
			
		  click (prop.getProperty("itemse_xpath"));
		 }
		 Assert.assertTrue(true);
	}

	//@Test(priority=2)
	public void addISE_copy() throws IOException, InterruptedException 
	{
		click(prop.getProperty("inventory_xpath"));
		
		click(prop.getProperty("itemmasterdata_xpath"));
		
		click(prop.getProperty("addmode_xpath"));	
		
		for(int i=1;i<=UDFUtility.getSourceItem().size();i++)
		{
		  setText (prop.getProperty("itemse_xpath"), UDFUtility.getSourceItem().get(i).split(":")[0]);
		 
		  selectValueFromDropdown (prop.getProperty("manageitemby_xpath"), UDFUtility.getSourceItem().get(i).split(":")[2]);
	
		  click (prop.getProperty("inventorydata_xpath"));
		
		  click (prop.getProperty("manageinvbywhse_xpath"));
		
		  click (prop.getProperty("planningdata_xpath"));
		  
		  selectValueFromDropdown (prop.getProperty("procurementmethod_xpath"), UDFUtility.getSourceItem().get(i).split(":")[3]);
		
		  selectValueFromDropdown (prop.getProperty("optiproplanningtype_xpath"), UDFUtility.getSourceItem().get(i).split(":")[4]);
		
		  selectValueFromDropdown (prop.getProperty("dtf_xpath"), prop.getProperty("dtfvalue"));

		  selectValueFromDropdown (prop.getProperty("ptf_xpath"), prop.getProperty("ptfvalue"));

		  selectValueFromDropdown (prop.getProperty("rtf_xpath"), prop.getProperty("rtfvalue"));
		
		  click (prop.getProperty("plannintitem_xpath"));
		
		  setText (prop.getProperty("find_xpath"), UDFUtility.getSourceItem().get(i).split(":")[5]);
		 
		  click (prop.getProperty("choose_xpath"));
		
		  click (prop.getProperty("add_xpath"));
		  
		  click (prop.getProperty("general_xpath"));
		  
		  click (prop.getProperty("resadd_xpath"));
		 }
		 Assert.assertTrue(true);
	}

	//@Test(priority=2)
    public void addResource() throws InterruptedException
    {
    	click (prop.getProperty("resources_xpath"));
    	
    	click (prop.getProperty("resourcemasterdata_xpath"));
    	
    	click(prop.getProperty("addmode_xpath"));	
    	
    	for(int i=1;i<=UDFUtility.getResource().size();i++)
		{
		  setText (prop.getProperty("resourceno_xpath"), UDFUtility.getResource().get(i).split(":")[0]);
		  
		  click(prop.getProperty("resdescription_xpath"));
		  
    	  setText (prop.getProperty("resdescription_xpath"), UDFUtility.getResource().get(i).split(":")[1]);
		  
		  selectValueFromDropdown (prop.getProperty("resourcetype_xpath"), UDFUtility.getResource().get(i).split(":")[2]);
		  
		 selectValueFromDropdown (prop.getProperty("optiproresourcetype_xpath"), UDFUtility.getResource().get(i).split(":")[3]);
		  
		 click (prop.getProperty("unitofmeasuretest_xpath"));
		  
		  setText (prop.getProperty("unitofmeasuretest_xpath"), prop.getProperty("unitofmeasurevalue"));
		  
    		
		  click (prop.getProperty("timeperresourceunits_xpath"));
			
	 setText (prop.getProperty("timeperresourceunits_xpath"), prop.getProperty("timeperresourcevalue"));
		  
	 click (prop.getProperty("resunitspertimeperiod"));
		
	 setText (prop.getProperty("resunitspertimeperiod"), prop.getProperty("resunitpertimevalue"));
		  
	    if(i!=1)
	    {
		  click(prop.getProperty("bottleneckresource_xpath"));	
	    }  
		  click(prop.getProperty("addresource_xpath"));	
		} 
    	Assert.assertTrue(true);
    }
	
    @Test(priority=2)
	public void addForecastDemandGroup() throws InterruptedException
	{
        click (prop.getProperty("optipromftg_xpath"));
    	
    	click (prop.getProperty("planningmodule_xpath"));
    	
    	click (prop.getProperty("forecastdemandgroup_xpath"));
    	
    	click(prop.getProperty("addmode_xpath"));	
    	
		setText (prop.getProperty("forecastgroupcode_xpath"), prop.getProperty("forecastdemandgroupcodevalue"));
		
		rightClick(prop.getProperty("fdgrightclickxpath"));
		
		click(prop.getProperty("fdgaddline"));
		
		click(prop.getProperty("forecastcode_xpath"));
		
		
		//driver.findElement(By.xpath("//input[@class='c0_U_E']")).sendKeys(Keys.TAB);
		
		//click (prop.getProperty("forecastcode_xpath"));
		
		click (prop.getProperty("forecastcodelookup_xpath"));
		
		setText (prop.getProperty("find_xpath"), prop.getProperty("forecastcodevalue"));
		 
		click (prop.getProperty("choose_xpath"));
		
		Thread.sleep(2000);
		click (prop.getProperty("forecastdemandadd_xpath"));
	}
	
	//@Test
	public void searchUser() throws InterruptedException {

		setText(prop.getProperty("username_xpath"), prop.getProperty("usernameforsearch"));

		setText(prop.getProperty("password_xpath"), prop.getProperty("password"));

		click(prop.getProperty("loginclick"));

		click(prop.getProperty("AdminMenu_xpath"));

		setText(prop.getProperty("Searchbox_xpath"), prop.getProperty("searchvalue"));

		click(prop.getProperty("Searchbtn_xpath"));

		checkStatus(prop.getProperty("searchvalue"),prop.getProperty("expectedgridval"));
	}

	// @Test
	public void checkBrokenLinks() throws InterruptedException, MalformedURLException, IOException {
		OpenBrowser(prop.getProperty("url"));

		setText(prop.getProperty("username_xpath"), prop.getProperty("username"));

		setText(prop.getProperty("password_xpath"), prop.getProperty("password"));

		click(prop.getProperty("loginclick"));

		// Thread.sleep(10000);

		// list of all links
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		Thread.sleep(20000);

		System.out.println("All links available: " + linkslist.size());

		// list of all active links
		List<WebElement> activelinks = new ArrayList<WebElement>();

		// iterate the link list: exclude all links which doesnot contain href
		for (int i = 0; i < linkslist.size(); i++) {
			Thread.sleep(500);
			System.out.println(linkslist.get(i).getAttribute("href"));
			if (linkslist.get(i).getAttribute("href") != null
					&& (!linkslist.get(i).getAttribute("href").contains("javascript"))) {

				activelinks.add(linkslist.get(i));
			}
		}

		// check the size of active links list
		System.out.println("active links count: " + activelinks.size());

		// check href url with HTTP connection api
		for (int j = 0; j < activelinks.size(); j++) {
			HttpURLConnection con = (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href"))
					.openConnection();

			con.connect();
			String msg = con.getResponseMessage();
			con.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href") + "---->" + msg);
		}
	}
}