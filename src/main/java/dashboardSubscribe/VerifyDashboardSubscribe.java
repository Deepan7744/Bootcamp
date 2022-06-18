package dashboardSubscribe;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyDashboardSubscribe {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		1) Launch the app
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
		
//		5) Click 'view All'
		Thread.sleep(7000);
		driver.findElement(By.xpath("//lightning-button[@class='slds-button slds-p-horizontal--small']/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']/input")).sendKeys("Dashboards");
        driver.findElement(By.xpath("//P[@class='slds-truncate']")).click();
        Thread.sleep(5000);
        
        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(20));
    	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search recent dashboards...']")));
    	WebElement serachTextbox = driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']"));
    	serachTextbox.sendKeys("Deepan");
    	serachTextbox.sendKeys(Keys.ENTER);	
    	Thread.sleep(10000);
    	
    	driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//span[text()='Subscribe']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//label[@class='daily slds-button slds-radio--button uiLabel']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral saveButton uiButton--default uiButton--brand uiButton']")).click();
    	

	}

}
