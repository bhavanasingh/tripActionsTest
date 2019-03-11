package com.booking.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	
	public void searchHotelWithLocAndDate(String loc, String fromDate, String toDate, WebDriver driver) {
		
		//dismiss pop-up
	    WebDriverWait wait = new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[data-command='noop']"))).click();
	    
	    
	    driver.findElement(By.id("ss")).sendKeys(loc);
	    
	    //Select Los Angeles from drop down
	    driver.findElement(By.cssSelector("ul[aria-label='List of suggested destinations '] li[data-label='" + loc + "']")).click();
	    
	    //Enter dates
	    driver.findElement(By.cssSelector("td[data-date='" + fromDate + "']")).click();
	    driver.findElement(By.cssSelector("td[data-date='" + toDate + "']")).click();
	    driver.findElement(By.cssSelector("button[type='submit']")).click();
	    
	}

}
