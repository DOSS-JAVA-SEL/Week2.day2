package week2day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		String ttle = "View Lead | opentaps CRM";
		String company1 = "LeafTest (10193)";
		
		//1.Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		// 2	Enter the username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("DemoSalesManager");
		
		// 3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// 4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// 5	Click crm/sfa link
		 driver.findElement(By.linkText("CRM/SFA")).click();
		 
		// 6	Click Leads link
		 driver.findElement(By.xpath("//a[text()=\"Leads\"]")).click();
		 
		// 7	Click Find leads
		 driver.findElement(By.linkText("Find Leads")).click();
		 Thread.sleep(2000);
		 
		// 8	Enter first name
		 driver.findElement(By.xpath("(//input[@name=\"firstName\"])[3]")).sendKeys("Hari");
		 Thread.sleep(2000);
		// 9	Click Find leads button
		 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			Thread.sleep(2000);
			
		// 10 Click on first resulting lead
			driver.findElement(By.xpath("(//a[text()=\"Hari\"])[1]")).click();
			
		// 11 Verify title of the page
			// driver.findElement(By.xpath("//div[text()=\"View Lead\"]"));
			String title = driver.getTitle();
			System.out.println(title);
			if(title.equals(ttle)) {
				System.out.println("The title were verified");
			}
			else {
				System.out.println("The title were not verified");
			}
			
		// 12 Click Edit
			driver.findElement(By.xpath("//a[text()=\"Edit\"]")).click();
			
		// 13 Change the company name
			WebElement company = driver.findElement(By.xpath("//input[@id=\"updateLeadForm_companyName\"]"));
			company.clear();
		  company.sendKeys("LeafTest"); 
		  Thread.sleep(2000);
		  
		// 14 Click Update
		  driver.findElement(By.xpath("//input[@name=\"submitButton\"]")).click();
		  
		// 15 Confirm the changed name appears
		  WebElement confirm = driver.findElement(By.xpath("//span[@id=\"viewLead_companyName_sp\"]"));
		  String YY = confirm.getText();
		  System.out.println(YY);
		  if(YY.equals(company1)) {
			  System.out.println("Yes, the company name is altered");
			  		  }
		  else {
			  System.out.println("No, the company name is not altered");
		  }
		// 16 Close the browser (Do not log out)
		  driver.close();

	}

}
