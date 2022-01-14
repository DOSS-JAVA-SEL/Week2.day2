package week2day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Buttons {

	public static void main(String[] args) throws InterruptedException {
		//1.Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
		driver.get("http://leafground.com/pages/Button.html");
		Thread.sleep(2500);
				
		//2.Click button to travel home page
		driver.findElement(By.xpath("//button[text()=\"Go to Home Page\"]")).click();
		Thread.sleep(2500);
		driver.navigate().to("http://leafground.com/pages/Button.html");
		Thread.sleep(5000);
		
		//3.Find position of button (x,y)
		WebElement posi = driver.findElement(By.xpath("//button[text()=\"Get Position\"]"));
		Point locate = posi.getLocation();
		System.out.println("The position of button"+" "+locate);
		Thread.sleep(2500);
				
		//4.Find button color
		WebElement color = driver.findElement(By.id("color"));
		String rgb = color.getCssValue("background-color");
		System.out.println("The Button color"+" "+rgb);
		Thread.sleep(2500);
		
		//5.Find the height and weight
		Dimension para = driver.findElement(By.xpath("//button[@id=\"size\"]")).getSize();
		System.out.println("The height and weight are"+" "+para);
		Thread.sleep(2500);
		
		
	}

}
