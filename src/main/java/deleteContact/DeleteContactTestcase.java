package deleteContact;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteContactTestcase {

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
		Thread.sleep(5000);
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
    	Thread.sleep(10000);

//	10) Get the text of Contact name and store it

//	11) Click on the dropdown icon available in the unique contact and select Delete
    	
    	driver.findElement(By.xpath("(//div[contains(@class,'forceVirtualActionMarker forceVirtualAction')])[3]")).click();
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("(//li[@class='uiMenuItem']/a)[2]")).click();
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")).click();
//	12) Verify whether the Contact is Deleted
	}

}
