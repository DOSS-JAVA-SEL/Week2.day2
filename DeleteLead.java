package week2day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {

		String yy="No records to display";
		
		//1	Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//2	Enter the username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("DemoSalesManager");
		 
		//3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//5	Click crm/sfa link
		 driver.findElement(By.linkText("CRM/SFA")).click();
		 
	//	6	Click Leads link
		 driver.findElement(By.xpath("//a[text()=\"Leads\"]")).click();
		 
	//	7	Click Find leads
		 driver.findElement(By.linkText("Find Leads")).click();
		 
	//	8	Click on Phone
		 driver.findElement(By.linkText("Phone")).click();
		 
	//	9	Enter phone number
		WebElement clr = driver.findElement(By.xpath("//input[@name=\"phoneCountryCode\"]"));
		clr.clear();
		 clr.sendKeys("91");
		 
		 driver.findElement(By.xpath("//input[@name=\"phoneAreaCode\"]")).sendKeys("042");
		 driver.findElement(By.xpath("//input[@name=\"phoneNumber\"]")).sendKeys("45789654");
		 Thread.sleep(2000);
		 
	//	10	Click find leads button
		 driver.findElement(By.xpath("//button[@class=\"x-btn-text\"]")).click();
		 Thread.sleep(2000);
		 
	//	11	Capture lead ID of First Resulting lead
		WebElement rec = driver.findElement(By.xpath("//div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"]/a[@class=\"linktext\"]"));
		rec.getAttribute("10157");
		String id = rec.getText();
		System.out.println(id);
		 Thread.sleep(2000);
			 	
		 
	//	12	Click First Resulting lead
		 rec.click();	
		 
	//	13	Click Delete
	    driver.findElement(By.linkText("Delete")).click();
		 
	//	14	Click Find leads
		driver.findElement(By.xpath("//ul[@class=\"shortcuts\"]/li[3]")).click();
		
		 
	//	15	Enter captured lead ID
		 driver.findElement(By.linkText("Phone")).click();
		 driver.findElement(By.xpath("//input[@name=\"phoneCountryCode\"]")).sendKeys("91");
		 driver.findElement(By.xpath("//input[@name=\"phoneAreaCode\"]")).sendKeys("042");
		 driver.findElement(By.xpath("//input[@name=\"phoneNumber\"]")).sendKeys("45789654");
		
		 Thread.sleep(2000);
		
	//	16	Click find leads button
		 driver.findElement(By.xpath("(//button[@class=\"x-btn-text\"])[7]")).click();
		 
		 
		 Thread.sleep(5000);
		
		
	//	17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		WebElement check = driver.findElement(By.xpath("//div[text()=\"No records to display\"]"));
		String xx= check.getText();
		System.out.println(xx);
				 Thread.sleep(5000);
				 if(xx.equals(yy)){
					 System.out.println("Yes, its found no record to display");
				 }
				 else {
					 System.out.println("No, its not found no record to display");
				 }
	//	18	Close the browser (Do not log out)
		driver.close();

	}

}
