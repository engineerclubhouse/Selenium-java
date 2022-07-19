package toolsqa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class Dynamicbtn {
	
	static WebDriver driver;

	public static WebElement getcssselector(String str) {
		return driver.findElement(By.cssSelector(str));
	}

	public static WebElement getcssselectorextend(WebElement ele, String str) {
		return ele.findElement(By.cssSelector(str));
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "G:\\testing\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;

		driver.get("https://demoqa.com/");
		WebElement element = getcssselector(".category-cards .card.mt-4.top-card:nth-child(1)");
		element.click();
		
		js.executeScript("window.scrollBy(0,1000);");
		
		WebElement dynamicbtnContainer = getcssselector(
				".accordion .element-group:nth-child(1) .menu-list .btn.btn-light:nth-child(9)");

		Thread.sleep(1000);
		dynamicbtnContainer.click();
		
		WebElement enableafter5 = getcssselector(".mt-4.btn.btn-primary:nth-child(2)");
		WebElement colourchange = getcssselector(".mt-4.btn.btn-primary:nth-child(4)");
		
		List<WebElement> visiableafter5 = driver.findElements(By.cssSelector(".mt-4.btn.btn-primary:nth-child(6)"));
		
		System.out.println(enableafter5.isEnabled());
		System.out.println(visiableafter5.size());
		System.out.println(Color.fromString(colourchange.getCssValue("color")) );
		
		Thread.sleep(5000);
		visiableafter5 = driver.findElements(By.cssSelector(".mt-4.btn.btn-primary:nth-child(6)"));
		System.out.println(enableafter5.isEnabled());
		System.out.println(visiableafter5.size());
		System.out.println(Color.fromString(colourchange.getCssValue("color")) );
		
	}

}
