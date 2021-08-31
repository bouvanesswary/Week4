package week4.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailWebTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");//Launch the URL https://www.ajio.com 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement from=driver.findElementById("txtStationFrom");
		from.sendKeys("chennai");
		from.sendKeys(Keys.TAB);
		from.sendKeys(Keys.TAB);
				
		WebElement to=driver.findElementById("txtStationTo");
		to.sendKeys("mumbai");
		to.sendKeys(Keys.TAB);
		Thread.sleep(2000);		
		driver.findElementById("chkSelectDateOnly").click();
		
		//get row list
		Thread.sleep(2000);
		WebElement erailtable=driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']/tbody");
		List<WebElement> erailist=erailtable.findElements(By.id("tr"));
		System.out.println("Erail Table Count "+erailist.size());
		
		// print second column
		
		
	}

}
