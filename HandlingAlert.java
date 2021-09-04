package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Alert.html");//Launch the URL https://www.ajio.com 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Simple Alert
		driver.findElementByXPath("//button[text()='Alert Box']").click();
		Alert alert=driver.switchTo().alert();	
		alert.accept();
		//Confirm Alert
		driver.findElementByXPath("//button[text()='Confirm Box']").click();
		alert.dismiss();
		WebElement d=driver.findElementByXPath("//p[text()='You pressed Cancel!']");
		String text=d.getText();
		
		//System.out.println(text);
		if(text.contains("OK")) 
				{
			System.out.println("Clicked OK");
		}
		else
		{
			System.out.println("Clicked Cancel");
		}
		//Prompt Alert
		driver.findElementByXPath("//button[text()='Prompt Box']").click();
		alert.sendKeys("INSTITUTE");
		alert.accept();
		System.out.println(driver.findElementByXPath("//p[@id='result1']").getText());
		
		//Line Break
		driver.findElementByXPath("//button[text()='Line Breaks?']").click();
		alert.accept();
	
	}

}
