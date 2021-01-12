import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonExercise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
     
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebElement TV=driver.findElement(By.xpath("//span[contains(text(),'Televisions')]"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(TV));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		TV.click();
		Thread.sleep(4000);
		WebElement SamsungTV=driver.findElement(By.xpath("(//ul//li//a[contains(text(),'Samsung')])"));
		WebDriverWait wait2 = new WebDriverWait(driver,30);
		wait2.until(ExpectedConditions.elementToBeClickable(SamsungTV));
		SamsungTV.click();
		WebElement Model=driver.findElement(By.xpath("//img[@alt=\"Samsung 80 cm (32 inches) Wondertainment Series HD Ready LED Smart TV UA32TE40AAKXXL (Titan Gray) (2020 model)\"]"));
		WebDriverWait wait3 = new WebDriverWait(driver,30);
		wait3.until(ExpectedConditions.elementToBeClickable(Model));
		JavascriptExecutor js1=(JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);///Deliberate sleep
		Model.click();
		String parent=driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1=s.iterator();
		while(I1.hasNext()) {
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			System.out.println(driver.switchTo().window(child_window).getTitle());
		}
		}
		WebElement checkbox=driver.findElement(By.id("mbb-offeringID-2"));
		ScrollAndClick(checkbox,driver);
		checkbox.click();
		WebElement Quantity=driver.findElement(By.id("quantity"));
		Select select=new Select(Quantity);
		select.selectByVisibleText("2");
		Thread.sleep(3000);//Deliberate sleep
		WebElement AddtoCart=driver.findElement(By.id("add-to-cart-button"));
		ScrollAndClick(AddtoCart,driver);
		AddtoCart.click();	
		Thread.sleep(3000);///Deliberate sleep
		driver.quit();
	}
	public static void ScrollAndClick(WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}

}
