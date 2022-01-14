package week2day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		
		//settingup chromebrowser and driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Getting the url
		driver.get("https://www.facebook.com/");
		
		//Maximising the screen
		driver.manage().window().maximize();
		
		//intro. implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//click on create new button
		WebElement create = driver.findElement(By.xpath("//a[text()='Create New Account']"));
				create.click();
				
		// Enter the first name
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Ranojidoss");
		
		// Enter the last name
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Doss");
		
		//Enter the mobile number
		driver.findElement(By.xpath("//input[@type=\"text\" and @name=\"reg_email__\"]")).sendKeys("1235678");
		
		//Enterthe password
		driver.findElement(By.xpath("//input[@autocomplete=\"new-password\" ]")).sendKeys("159357");
		
		// Handle all the three drop downs
		WebElement day = driver.findElement(By.xpath(("//select[@id=\"day\"]")));
		Select nos = new Select(day);
		nos.selectByValue("1");
		
		WebElement month = driver.findElement(By.xpath("//select[@id=\"month\"]"));
		Select string = new Select(month);
		string.selectByVisibleText("Feb");
		
		WebElement year = driver.findElement(By.id("year"));
		Select nos1 = new Select(year);
		nos1.selectByValue("2022");
		
		//Select the radio button "male"
		driver.findElement(By.xpath("//label[text()=\"Male\"]")).click();
		
		Thread.sleep(5000);
		
		driver.close();

	
		

	}

}
