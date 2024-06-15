package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Gmail_Login {

	WebDriver driver;

    public Gmail_Login(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.gmail.com");
    }
    
    public void Gmail_Credentials(String Gemail, String Gpassword) {
      
    	WebElement SignIn = driver.findElement(By.linkText("Sign in"));
    	SignIn.click();
    	
    	WebElement email = driver.findElement(By.id("identifierId"));
        email.sendKeys(Gemail);
        
        WebElement NextBtn =   driver.findElement(By.xpath("//span[text()='Next']"));
        
        NextBtn.click();
        // Wait for transition then continue to password field
        try { 
        	Thread.sleep(2000);
        	} 
        catch (Exception e) 
        { 
        	e.printStackTrace(); 
        	
        }
        WebElement password = driver.findElement(By.name("Passwd"));
        password.sendKeys(Gpassword);
        NextBtn.click();
        // Wait for login to complete
        try 
        { 
        	Thread.sleep(5000); 
        	} 
        catch (Exception e) 
        { 
        	e.printStackTrace(); 
        }
    }
    
	
}
