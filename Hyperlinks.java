package week2day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hyperlinks {

	public static void main(String[] args) throws InterruptedException {
		//1.Launch the browser
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
				driver.get("http://leafground.com/pages/Link.html");
				Thread.sleep(2500);
				
		//2.Go to Home Page
				driver.findElement(By.linkText("Go to Home Page")).click();
				Thread.sleep(2500);
				driver.navigate().back();
				Thread.sleep(5000);
				
		//3.Go to Button.html without clicking
				WebElement site = driver.findElement(By.linkText("Find where am supposed to go without clicking me?"));
				String abc = site.getAttribute("href");
				System.out.println("The site going in without clicking is:"+" "+abc);
				Thread.sleep(2500);
				driver.navigate().to("http://leafground.com/pages/Link.html");
				Thread.sleep(5000);
				
		//4.Verify broken or not
				 driver.findElement(By.linkText("Verify am I broken?")).click();
				 Thread.sleep(2500);
				 String title = driver.getTitle();
				 System.out.println("The title is:"+" "+title);
				 if(title.equals("HTTP Status 404 – Not Found")) {
					 System.out.println("Yes, the link is broken");
					 driver.navigate().back();
					Thread.sleep(2500);
				 }
			 else {
					 System.out.println("No, the link is not broken");
				 }
				
				
		//5.interact with same link name
				 driver.findElement(By.linkText("Go to Home Page")).click();
					Thread.sleep(2500);
					driver.navigate().back();
					Thread.sleep(5000);
				
	}
}


