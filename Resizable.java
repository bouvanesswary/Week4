package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");//Launch the URL 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		WebElement frame=driver.findElementByXPath("//iframe[@class='demo-frame']");
		driver.switchTo().frame(frame);
		WebElement resize=driver.findElementByXPath("//div[@id='resizable']/div[3]");
		Actions builder=new Actions(driver);
		builder.clickAndHold(resize).moveByOffset(97, 38).perform();
		
		
	}

}
