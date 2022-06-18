package createIndividualsWithoutMandatoryFields;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIndividualsWithoutMandatoryFields {

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
//			1) Launch the app
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions(); 
			options.addArguments("--disable-notifications");
			
			ChromeDriver driver = new ChromeDriver(options);
			driver.get("https://login.salesforce.com/");
			driver.manage().window().maximize();	
			
//		2) Login with the credentials
			driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
			driver.findElement(By.id("Login")).click();
			Thread.sleep(20000);
			
//			4) Click on menu button from the Left corner
			driver.findElement(By.xpath("(//div[@class='tooltipTrigger tooltip-trigger uiTooltip']/div)[2]")).click();
			
//			5) Click 'view All'
			Thread.sleep(7000);
			driver.findElement(By.xpath("//lightning-button[@class='slds-button slds-p-horizontal--small']/button")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']/input")).sendKeys("Individuals");
	        driver.findElement(By.xpath("//P[@class='slds-truncate']")).click();
	        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(20));
	        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Individuals'])[1]/following::lightning-icon[1]"))).click();
	        		
//	        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(20));
//	    	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search recent dashboards...']")));

	}

}
