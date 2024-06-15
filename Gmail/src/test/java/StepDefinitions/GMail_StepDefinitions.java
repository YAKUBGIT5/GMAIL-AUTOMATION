package StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import WebPages.*;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GMail_StepDefinitions {

	WebDriver driver;
	Gmail_Login GLogin;
    GMail_Inbox GInbox;

    @Before
    public void setUp() {
    
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        GLogin = new Gmail_Login(driver);
        GInbox = new GMail_Inbox(driver);
        
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    
	@Given("I am logged into Gmail")
	public void i_am_logged_into_gmail() {
	    
		GLogin.Gmail_Credentials("yakub@gmail.com", "Yakub123$");
	}

	@When("I compose a new email with subject {string} and body {string}")
	public void i_compose_a_new_email_with_subject_and_body(String string, String string2) {
	    
		GInbox.composeGmail("Hello", "How are you Dear");
	}

	@When("I send the email")
	public void i_send_the_email() {
	   
		GInbox.clickonSendButton();
	}

	@Then("the email should be sent successfully")
	public void the_email_should_be_sent_successfully() {
	  
		GInbox.verifyEmailDelivery();
	}
}
