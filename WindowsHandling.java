package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/");//Launch the URL 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Switch to second browser
		driver.findElementByXPath("//button[text()='OK']").click();
		driver.findElementByXPath("//a[text()=' FLIGHTS ']").click();
		Set<String> winhandle=driver.getWindowHandles();
		List<String> winhandlelist=new ArrayList<String>(winhandle);
		driver.switchTo().window(winhandlelist.get(1));
		Thread.sleep(5000);
		//print email
		WebElement email = driver.findElementByXPath("//a[contains(text(),'@')]");
		String irctcemail = email.getText();
		System.out.println(irctcemail);
		//switch to home browser
		driver.switchTo().window(winhandlelist.get(0));
		driver.close();
		
		
	}

}
