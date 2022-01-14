package week2day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
	 String z = "Duplicate Lead";
		
		//	1	Launch the browser
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
		 
		//6	Click Leads link
		 driver.findElement(By.xpath("//a[text()=\"Leads\"]")).click();
		 
	//	7	Click Find leads
		 driver.findElement(By.linkText("Find Leads")).click();
		 Thread.sleep(2000);
		 
	//	8	Click on Email
		driver.findElement(By.linkText("Email")).click();
		
	//	9	Enter Email
		driver.findElement(By.name("emailAddress")).sendKeys("hari@testleaf.com");
		 Thread.sleep(2000);
		 
	//	10	Click find leads button
		 driver.findElement(By.xpath("(//td[@class=\"x-btn-right\"])[7]")).click();
		Thread.sleep(2000);
		
	//	11	Capture name of First Resulting lead
		WebElement name = driver.findElement(By.xpath("(//a[text()=\"Hari\"])[1]"));
		  String x=name.getText();
		  
		 System.out.println(x);
		
		 
		
	//	12	Click First Resulting lead
		 name.click();
		 
	//	13	Click Duplicate Lead
		 driver.findElement(By.linkText("Duplicate Lead")).click();
		 
	//	14	Verify the title as 'Duplicate Lead'
		 WebElement verify = driver.findElement(By.xpath("(//div[text()=\"Duplicate Lead\"])"));
		 String y = verify.getText();
		 if(y.equals(z)) {
			 System.out.println("Yes ,Its verified that the title is Duplicate Lead");
		 }
		 else {
			 System.out.println("No, Its not with title is Duplicate Lead");
		 }
		 
	//	15	Click Create Lead
		 driver.findElement(By.xpath("//input[@name=\"submitButton\"]")).click();
		 Thread.sleep(2000);
		 
	//	16	Confirm the duplicated lead name is same as captured name
		WebElement fake = driver.findElement(By.xpath("//span[@id=\"viewLead_firstName_sp\"]"));
		 String fake1 = fake.getText();
		 System.out.println(fake1);
		 if(fake1.equals(x)) {
			 System.out.println("Yes, the duplicated lead name is same as captured name");
			 		 }
		 else {
			 System.out.println("No,the duplicated lead name is not same as captured name ");
		 }
			 
	//	17	Close the browser (Do not log out)
		 driver.close();

	}

}
