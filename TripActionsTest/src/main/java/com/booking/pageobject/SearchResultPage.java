package com.booking.pageobject;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
	
	public void filterHotels(WebDriver driver) {
		
		driver.findElement(By.cssSelector(".filteroptions > a[data-id='ht_id-204']")).click();
	}
	
	public void pickRandomOf(int n, WebDriver driver) throws InterruptedException {
		
		//Random picking from top n result
	    final int randomNum = new Random().nextInt(n-1) + 1; // generate random number between 1-n
	    
	    Thread.sleep(5000);
	    //wait.until(ExpectedConditions.elementToBeClickable(seeAvailability));
	   // ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+seeAvailability.getLocation().y+")");
	   // ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+seeAvailability.getLocation().x+")");
	   // seeAvailability.click();
	    
	    //Challenge 1: After clicking on the hotel checkbox, it takes a few seconds to render the page again. A progress spinner
	    //spinner 
	    
	    driver.findElement(By.cssSelector("div[id='hotellist_inner']>div:nth-of-type("+ randomNum +") > div[class ^= 'sr_item_content'] > div[class ^= 'sr_rooms_table_block'] > div.room_details > table[class ^= 'featuredRooms']  > tbody")).click();
	    //Xpath will look cleaner but takes more time.
	   
		
	}

}
