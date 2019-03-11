package com.booking.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HotelsDetailPage {
	
	public void findCheapestRoom(WebDriver driver) {
		Select cheapestRoom = new Select(driver.findElement(By.cssSelector("table[class='hprt-table  hprt-table-long-language ']>tbody>tr:nth-of-type(1) > td[class='hprt-table-cell hprt-table-room-select  '] > div.hprt-block > label > select[class='hprt-nos-select']")));
	    
	    cheapestRoom.selectByIndex(1);
	    //Rooms are ordered by price such that cheapest room is always the first element.
	    
	    driver.findElement(By.cssSelector("#hprt-form > table > tbody > tr.hprt-table-cheapest-block.hprt-table-cheapest-block-fix.js-hprt-table-cheapest-block > td.hprt-table-cell.-last.droom_seperator.hprt-block--room-selected > div > div.hprt-reservation-cta > button")).click();
	    driver.findElement(By.id("bp_travel_purpose_business")).click();
	    driver.findElement(By.id("booker_title")).click();
	    
		
	}

}
