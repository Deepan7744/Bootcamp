package createcontact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTestcase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
//  1) Launch the app
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
//	2) Login with the credentials
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		
//	3) Click Login
		driver.findElement(By.id("Login")).click();
		
        Thread.sleep(25000);
		 

//	4) Click on Global Actions SVG icon
        driver.findElement(By.xpath("//a[contains(@class,'globalCreateTrigger slds-button slds-button_icon slds-button_icon slds-button_icon-container')]/div")).click();

       driver.findElement(By.xpath("//span[text()='New Contact']")).click();
       
       Thread.sleep(7000);
       
       driver.findElement(By.xpath("//span[text()='Salutation']/following::a[1]")).click();
		
//	6) Pick Salutation as 'Mr.
       driver.findElement(By.xpath("//a[text()='Mr.']")).click();
       
//	7) Enter First Name as 'Naveen'
       driver.findElement(By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input']")).sendKeys("Naveen");
       
//	8) Enter Last Name as 'Elumalai'
       driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")).sendKeys("Elumalai");
//	9) Enter email as 'naveen@test.com'
       driver.findElement(By.xpath("//span[text()='Email']/following::input[4]")).sendKeys("naveen@test.com");
       Thread.sleep(5000);
//	10) Create a New Account for Account Name
       driver.findElement(By.xpath("//input[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']")).click();
       Thread.sleep(5000);
       driver.findElement(By.xpath("//div[@class='createNew itemContainer slds-lookup__item-action--label slds-text-link--reset slds-grid slds-grid--vertical-align-center slds-truncate forceSearchInputLookupDesktopActionItem lookup__footer']")).click();
       Thread.sleep(5000);
//	11) Enter account name as 'Credits' and save
       
       driver.findElement(By.xpath("(//span[text()='Account Name'])[2]/following::input[1]")).sendKeys("CreditsDuplicate2");
       driver.findElement(By.xpath("//button[@data-aura-class='uiButton--default uiButton--brand uiButton forceActionButton']/span")).click();
       Thread.sleep(5000);
  //	12) Click and save
       
        driver.findElement(By.xpath("//button[@class='slds-button slds-button--brand cuf-publisherShareButton uiButton']/span")).click();
        Thread.sleep(5000);	
//	13) Verify contact using Unique name and print the name
        String header = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']/a")).getAttribute("title");
        if (header.contains("Elumalai")) {
		System.out.println("contact created");	
		}
        else {
			System.out.println("contacts not created");
		}
	}

}
