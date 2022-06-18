package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createaccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("email")).sendKeys("deepanlikes@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Adhi@123");
		driver.findElement(By.id("loginbutton")).click();
		driver.findElement(By.partialLinkText("Forgotten password?")).click();
	
		
	}

}
