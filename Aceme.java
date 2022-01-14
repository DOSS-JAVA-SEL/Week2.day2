package week2day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Aceme {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("http://leaftaps.com/opentaps/control/login");
		
		
		//1. Load url "https://acme-test.uipath.com/login"
		driver.get("https://acme-test.uipath.com/login");
		
		//2. Enter email as "kumar.testleaf@gmail.com"
            WebElement email = driver.findElement(By.id("email"));
            email.sendKeys("kumar.testleaf@gmail.com");
            Thread.sleep(2000);
		//3. Enter Password as "leaf@12"
            driver.findElement(By.id("password")).sendKeys("leaf@12");
            Thread.sleep(2000);
		//4. Click login button
            driver.findElement(By.xpath("//button[contains(text(),\"Login\")]")).click();
            Thread.sleep(2000);
            
		//5. Get the title of the page and print
            String title = driver.getTitle();
            System.out.println(title);
            Thread.sleep(5000);
	//	6. Click on Log Out
            driver.findElement(By.xpath("//a[text()=\"Log Out\"]")).click();
            Thread.sleep(2000);
		//7. Close the browser (use -driver.close())
          driver.close();

	

	
		Thread.sleep(3000);
	}

}
