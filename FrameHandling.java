package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");//Launch the URL https://www.ajio.com 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement frame=driver.findElementByXPath("//div[@id='iframecontainer']//iframe");
		driver.switchTo().frame(frame);
		driver.findElementByXPath("//button[text()='Try it']").click();
		driver.switchTo().alert().accept();
		WebElement d=driver.findElementByXPath("//p[text()='You pressed OK!']");
		String r=d.getText();
		System.out.println(r);
		if(r.contains("OK"))
		{
			System.out.println("Clicked OK");
		}
		else
		{
			System.out.println("Clicked Cancel");
		}
	}

}
