package com.booking.tripActionsTest;

import java.util.ArrayList;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import com.booking.pageobject.EnterDetailsPage;
import com.booking.pageobject.HotelsDetailPage;
import com.booking.pageobject.SearchPage;
import com.booking.pageobject.SearchResultPage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBookRoom {
	  private WebDriver driver;
	  private String baseUrl;
	  
	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
		  
	    driver = new ChromeDriver();
	    baseUrl = "https://www.booking.com/";
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	    
	  }

	  @Test
	  public void testCreateSimpleRoomBooking() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	    driver.get(baseUrl);
	    
	    SearchPage searchP = new SearchPage();
	    searchP.searchHotelWithLocAndDate("Los Angeles, California, USA", "2019-03-13", "2019-03-15", driver);
	    
	    //filter hotels
	    SearchResultPage srp = new SearchResultPage();
	    srp.filterHotels(driver);
	    
	    
	    //pick hotel
	    srp.pickRandomOf(3, driver);
	    
	    //Move to the next tab
	    
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    
	    //Select the cheapest hotel
	    HotelsDetailPage hdp = new HotelsDetailPage();
	    hdp.findCheapestRoom(driver);
	    
	    //Enter Guest information for booking
	    EnterDetailsPage edp = new EnterDetailsPage();
	    edp.enterGuestDetails("Ms.", "Bhavana", "Singh", "bhavanapbisht@gmail.com", driver);

	    
	    //Open Bug: Can not find the final button to click and go to checkout page. waiting does not help.
	    //The page apparently has a cover element that is preventing location of button.
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='modal-mask-closeBtn bp_rlu_footer_close']"))).click();
	    driver.findElement(By.cssSelector("#bookTmpl")).click();
	    
	    driver.findElement(By.cssSelector("#b_tt_holder_2 > button")).click();
	    //driver.findElement(By.xpath("//div[@id='b_tt_holder_2']/button")).click();
	    //xpath taking ~10 seconds

	  }
	  
		  

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    
		  driver.quit();
	    
	  }

	  
}
