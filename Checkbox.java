package week2day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {

	public static void main(String[] args) throws InterruptedException {
		//1.Launch the browser
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
				driver.get("http://leafground.com/pages/checkbox.html");
				Thread.sleep(2500);
		//2.select the language tknown
				driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
				Thread.sleep(2500);
		//3.confirm selection is checked
				WebElement select = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/input"));
				boolean lect = select.isSelected();
				System.out.println("The selection is checked"+" "+lect);
				Thread.sleep(2500);
		//4.Deselect the checked
				driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div[2]/input")).click();
				Thread.sleep(2500);
				
		//5.select all
				driver.findElement(By.xpath("//div[text()=\"Option 1\"]/input")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[text()=\"Option 2\"]/input")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div[3]/input")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div[4]/input")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div[5]/input")).click();
				Thread.sleep(3000);
		
		
		

	}

}
