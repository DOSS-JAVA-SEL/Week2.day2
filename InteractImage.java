package week2day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractImage {

	public static void main(String[] args) throws InterruptedException {
		//1.Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
		driver.get("http://leafground.com/pages/Image.html");
		Thread.sleep(2500);
		
		//2.click on image
		driver.findElement(By.xpath("//*[@id=\"text-2\"]/a/img")).click();
		Thread.sleep(5000);
		driver.navigate().to("http://leafground.com/pages/Image.html");
		Thread.sleep(2500);
		
		//3.Click broken or not
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/img")).click();
		if("//*[@id=\"contentblock\"]/section/div[2]/div/div/img".equals("http://leafground.com/pages/Image.html")) {
			System.out.println("The link is broken");
		}
			else {
				System.out.println("The link is not broken");
			}
		
		Thread.sleep(2500);
		
		//4.click usingmouse/keyboard
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div/div/img")).click();
		Thread.sleep(2500);
		
	}

}
