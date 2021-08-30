package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountOfFrames {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * Assignment 4: ------------ http://leafground.com/pages/frame.html 1.Take the
		 * the screenshot of the click me button of first frame 2.Find the number of
		 * frames - find the Elements by tagname - iframe - Store it in a list - Get the
		 * size of the list. (This gives the count of the frames visible to the main
		 * page)
		 */
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");//Launch the URL https://www.ajio.com 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Screenshot
		WebElement firstframeclickme = driver.findElementByXPath("//div[@id='wrapframe']/iframe");
		driver.switchTo().frame(firstframeclickme);
		WebElement firstclick = driver.findElementByXPath("//button[@id='Click']");
		File src1=driver.getScreenshotAs(OutputType.FILE);
		File dst=new File("./snaps/frame1.png");
		FileUtils.copyFile(src1,dst);
		
		driver.switchTo().defaultContent();
		List<WebElement> frm = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of frames : "+frm.size());
	}

}
