package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GMail_Inbox {

	WebDriver driver;

    public GMail_Inbox(WebDriver driver) {
        this.driver = driver;
    }

    public void composeGmail(String Gmailsubject, String Gmailbody) {
        driver.findElement(By.xpath("//div[text()='Compose']")).click();
        try { 
        	Thread.sleep(2000); 
        	}
        catch (InterruptedException e) 
        { 
        	e.printStackTrace(); 
        }
        driver.findElement(By.xpath("//input[@aria-label='To recipients']")).sendKeys("yakub@gmail.com");
        driver.findElement(By.name("subjectbox")).sendKeys(Gmailsubject);
        driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys(Gmailbody);
       
        try { 
        	Thread.sleep(2000);
        	}
        catch (Exception e) 
        { 
        	e.printStackTrace(); 
        }
    }

    public void clickonSendButton()
    {
    	 driver.findElement(By.xpath("//div[text()='Send']")).click();
    }
    public boolean verifyEmailDelivery() {
        return driver.getPageSource().contains("Message sent.");
    }
}
