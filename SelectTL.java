package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectTL {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/selectable.html");//Launch the URL 
		//driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		WebElement Item1=driver.findElementByXPath("//li[text()='Item 1']");
		WebElement Item5=driver.findElementByXPath("//li[text()='Item 5']");
		Actions builder=new Actions(driver);
		builder.clickAndHold(Item1).moveToElement(Item5).release().perform();
		driver.switchTo().defaultContent();
		
		
		
	}

}
