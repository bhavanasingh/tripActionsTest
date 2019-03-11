package com.booking.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EnterDetailsPage {
	
	public void enterGuestDetails(String title, String fName, String lName, String email, WebDriver driver) {
		
		new Select(driver.findElement(By.id("booker_title"))).selectByVisibleText(title);
	    
	    enterTextById("firstname", fName, driver);
	    enterTextById("lastname", lName, driver);
	    enterTextById("email", email, driver);
	    enterTextById("email_confirm", email, driver);
	    
	    driver.findElement(By.id("notstayer_false")).click();
	    
		
	}
	
	private void enterTextById(String id, String inputText, WebDriver driver) {
		  
		  try {
			  driver.findElement(By.id(id)).sendKeys(inputText);
			  
		  } catch (Exception e) {
			  System.out.println(e.getMessage());
		  }
		  
		  
	  }
	  

}
