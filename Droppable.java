package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Droppable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");//Launch the URL 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		WebElement src=driver.findElementByXPath("//iframe[@class='demo-frame']");
		driver.switchTo().frame(src);
		WebElement src1 = driver.findElementById("draggable");
		WebElement src2 = driver.findElementById("droppable");
		Actions builder=new Actions(driver);
		builder.doubleClick(src1);
		builder.dragAndDrop(src1, src2).perform();
		
	}

}
