package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraProject {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");// Launch the URL https://www.ajio.com
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement men = driver.findElement(By.xpath("//a[text()='Men']"));
		Actions action = new Actions(driver);
		action.moveToElement(men).perform();

		WebElement jacket = driver.findElementByXPath("//a[text()='Jackets']");
		jacket.click();

		WebElement count = driver.findElementByXPath("//div[@class='title-container']/span");
		String total = count.getText();
		String totalcount = total.replaceAll("[^0-9]", "");
		int tot = Integer.parseInt(totalcount);
		System.out.println("Total Count "+tot);

		WebElement Jackcheck = driver.findElementByXPath("//span[@class='categories-num']");// Jacket checkbox count
		String Jacketext = Jackcheck.getText();
		String Jacketcount = Jacketext.replaceAll("[^0-9]", "");
		int Jackcount = Integer.parseInt(Jacketcount);
		System.out.println("No of Jacket " + Jackcount);

		WebElement RainJacket = driver.findElementByXPath("(//span[@class='categories-num'])[2]");// Jacket checkbox
		String RainJacketext = RainJacket.getText();
		String RainJacketcount = RainJacketext.replaceAll("[^0-9]", "");
		int RainJackcount = Integer.parseInt(RainJacketcount);
		System.out.println("No of Rain Jacket " + RainJackcount);

		int sum=Jackcount+RainJackcount;
		if(sum==tot)
		{
			System.out.println("Both the values are same");
		}
		else
		{
			System.out.println("Both the values differs");
		}
		driver.findElementByXPath("//div[@class='brand-more']").click();
		driver.findElementByXPath("//div[@class='FilterDirectory-titleBar']/input").sendKeys("Duke");
		Thread.sleep(5000);
		driver.findElementByXPath("//label[contains(text(),'Duke')]").click();
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		
		//WebElement duke=driver.findElementByXPath("//div[@class='product-productMetaInfo']/h3");
		List<WebElement> dukelist = driver.findElementsByTagName("h3");
		int duke=dukelist.size();
		System.out.println("Total Duke brand products: "+duke);
		/*
		for (int i = 0; i < duke; i++) {
		String dukeL = dukelist.get(i).getText();
		System.out.println("Prducts name is: "+dukeL);
		}*/
		
		//better Discount 
		WebElement betterdisc=driver.findElementByXPath("//div[@class='sort-sortBy']");
		//driver.findElementByXPath("(//label[@class='sort-label '])[3]").click();
		Actions builder=new Actions(driver);
		builder.moveToElement(betterdisc).perform();
		
		driver.findElementByXPath("//input[@value='discount']/parent::label").click();
		String discount=driver.findElementByXPath("//span[@class='product-discountedPrice']").getText();
		System.out.println(discount);
		
		driver.findElementByXPath("//img[@class='img-responsive']").click();
		Set<String> winhandle=driver.getWindowHandles();
		List<String> winhandlelist=new ArrayList<String>(winhandle);
		driver.switchTo().window(winhandlelist.get(1));
		File src1=driver.getScreenshotAs(OutputType.FILE);
		File dst=new File("./snaps/Myntraduke.png");
		FileUtils.copyFile(src1,dst);
		System.out.println("Screenshot taken ");
		
		driver.findElementByXPath("//span[@class='myntraweb-sprite pdp-notWishlistedIcon sprites-notWishlisted pdp-flex pdp-center ']").click();
		//driver.findElementByLinkText("WISHLIST").click();
		Thread.sleep(5000);
		driver.switchTo().window(winhandlelist.get(0));
		driver.close();
		
	
		
		
		}
		
		
		
		

	}


