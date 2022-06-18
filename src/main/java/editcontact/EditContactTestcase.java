package editcontact;

import java.awt.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditContactTestcase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
//	2) Login with the credentials
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(20000);
		
//		4) Click on menu button from the Left corner
		driver.findElement(By.xpath("(//div[@class='tooltipTrigger tooltip-trigger uiTooltip']/div)[2]")).click();
		Thread.sleep(10000);
//		5) Click 'view All'
		
		driver.findElement(By.xpath("//lightning-button[@class='slds-button slds-p-horizontal--small']/button")).click();
		Thread.sleep(5000);
//		6) Click on contacts under 'All Items'"
		
		
        driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']/input")).sendKeys("contacts");
        driver.findElement(By.xpath("//P[@class='slds-truncate']")).click();
        Thread.sleep(5000);
      //7) Get the size of contacts available and print the list
    	WebElement contactsTable = driver.findElement(By.xpath("//table[@role='grid']/tbody"));
    	java.util.List<WebElement> rows = contactsTable.findElements(By.tagName("tr"));
//    	List<WebElement> rows = contactsTable.findElements(By.tagName("tr"));	
    	System.out.println("*size of contacts**"+rows.size());	
    	for(WebElement a :rows)
    		System.out.println("Contacts--->"+a.getText());
    	Thread.sleep(10000);
    	//8) search for the contact using unique name
    	WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(20));
//    	WebDriverWait wait2 = new WebDriverWait(driver,20);
    	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search this list...']")));
    	WebElement serachTextbox = driver.findElement(By.xpath("//input[@placeholder='Search this list...']"));
    	serachTextbox.sendKeys("Naveen Elumalai");
    	serachTextbox.sendKeys(Keys.ENTER);	
    	Thread.sleep(5000);
//		9) Click on the dropdown icon available in the unique contact and select edit
    	driver.findElement(By.xpath("(//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger'])[2]//span[1]")).click();
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("(//li[@class='uiMenuItem'])[1]/a")).click();
    	Thread.sleep(5000);
    	
//		10) Edit Title as Test
    	driver.findElement(By.xpath("//label[text()='Title']/following-sibling::div/input")).sendKeys("Test_Deepan");
//		11) select your birthday in the birthday field
    	driver.findElement(By.xpath("//label[text()='Birthdate']/following-sibling::div/input")).sendKeys("1/17/1993");
//		12) edit Lead Source as Purchased list
//    	Thread.sleep(3000);
//    	driver.findElement(By.xpath("//label[text()='Lead Source']/following-sibling::div/lightning-base-combobox")).click();
    	WebElement leadsourcedropdown = driver.findElement(By.xpath("//label[text()='Lead Source']/following::button[1]"));
    	wait2.until(ExpectedConditions.visibilityOf(leadsourcedropdown));
    	driver.executeScript("arguments[0].click();", leadsourcedropdown);
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("//span[text()='Purchased List']")).click();
//		13) Edit Phone number with personal number
    	driver.findElement(By.xpath("//label[text()='Phone']/following-sibling::div/input")).sendKeys("9199941399");
//		14) Click Save and Verify and Print Phone number
    	driver.findElement(By.xpath("//button[text()='Save']")).click();
    	

	}

}
