package fitpeoPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RevenueCalculator extends FitpeoHomepage


{
    public void revCalculator() throws Exception
    {
    	Thread.sleep(2000);
    	driver.findElement(By.xpath(pro.getProperty("RevenueCal"))).click();
    	
//    	------------------ Scrolling Down The Page ----------------------
    	
    	jse = (JavascriptExecutor)driver;
    	Thread.sleep(2000);
    	jse.executeScript("window.scrollBy(0 , 400)");
    	
//      ------------------- Handling Slider -----------------------------
    	
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//input[@aria-orientation = 'horizontal']//parent::span//ancestor::span[2]//following::div[1]//input")).sendKeys(Keys.CONTROL + "a"); // Select all text
    	driver.findElement(By.xpath("//input[@aria-orientation = 'horizontal']//parent::span//ancestor::span[2]//following::div[1]//input")).sendKeys(Keys.DELETE);       // Clear the selected text
    	driver.findElement(By.xpath("//input[@aria-orientation = 'horizontal']//parent::span//ancestor::span[2]//following::div[1]//input")).sendKeys("820");             // Enter the new value
    	
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//input[@aria-orientation = 'horizontal']//parent::span//ancestor::span[2]//following::div[1]//input")).sendKeys(Keys.CONTROL + "a");
    	driver.findElement(By.xpath("//input[@aria-orientation = 'horizontal']//parent::span//ancestor::span[2]//following::div[1]//input")).sendKeys(Keys.DELETE);       
    	driver.findElement(By.xpath("//input[@aria-orientation = 'horizontal']//parent::span//ancestor::span[2]//following::div[1]//input")).sendKeys("560");  
    	
        //----------Validate Slider Value: when the value 560 is entered in the text field, the slider's position is updated to reflect the value 560 ------------  
    	
    	WebElement slider = driver.findElement(By.xpath(pro.getProperty("progressBar")));
    	String sliderValue = slider.getAttribute("value");
    	
    	WebElement textField = driver.findElement(By.xpath(pro.getProperty("textField")));
    	String textfieldValue = textField.getAttribute("value");
    	
    	Assert.assertEquals(textfieldValue, sliderValue);
    	System.out.println("when the value 560 is entered in the text field, the slider's position is updated to reflect the value 560 : Verified Successfully");
    	
    	//---------------------------------------------------------------------------------------------------------------------------------------------------------
    	
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//input[@aria-orientation = 'horizontal']//parent::span//ancestor::span[2]//following::div[1]//input")).sendKeys(Keys.CONTROL + "a");
    	driver.findElement(By.xpath("//input[@aria-orientation = 'horizontal']//parent::span//ancestor::span[2]//following::div[1]//input")).sendKeys(Keys.DELETE);
    	driver.findElement(By.xpath("//input[@aria-orientation = 'horizontal']//parent::span//ancestor::span[2]//following::div[1]//input")).sendKeys("820");
    	
//    	------------------- Select the CPT Codes -------------------------
    	Thread.sleep(2000);
    	jse.executeScript("window.scrollBy(0 , 500)");
    	
    	Thread.sleep(2000);
    	driver.findElement(By.xpath(pro.getProperty("checkbox1"))).click();
    	
    	Thread.sleep(2000);
    	driver.findElement(By.xpath(pro.getProperty("checkbox2"))).click();
    	
    	Thread.sleep(2000);
    	jse.executeScript("window.scrollBy(0 , 350)");
    	
    	Thread.sleep(2000);
    	driver.findElement(By.xpath(pro.getProperty("checkbox3"))).click();
    	
    	Thread.sleep(2000);
    	jse.executeScript("window.scrollBy(0 , 750)");
    	
    	Thread.sleep(2000);
    	driver.findElement(By.xpath(pro.getProperty("checkbox4"))).click();
//    	--------------------------------------------------------------------
    	
        //------ Validate Total Recurring Reimbursement: Verify that the header displaying Total Recurring Reimbursement for all Patients Per Month: shows the value $110700.-------------
    	
    	String expe = "$110700";
    	String act = driver.findElement(By.xpath("//p[contains(text(),'Total Recurring Reimbursement for all Patients Per Month:')]/p")).getText();
    	System.out.println(act);
    	Assert.assertEquals(expe, act);
    	System.out.println("Total Recurring Reimbursement for all Patients Per Month verified Successfully");
    	
    	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    	
    	Thread.sleep(3000);
    	driver.quit();
    }
}
