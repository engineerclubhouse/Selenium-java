package toolsqa;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Buttons {

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
		driver =new ChromeDriver();
		Actions action = new Actions(driver);
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/");
		
		WebElement element = getcssselector(".category-cards .card.mt-4.top-card:nth-child(1)");
		element.click();

		WebElement buttonBoxContainer = getcssselector(
				".accordion .element-group:nth-child(1) .menu-list .btn.btn-light:nth-child(5)");

		Thread.sleep(1000);
		buttonBoxContainer.click();
		WebElement doubleclick = getcssselector(".container.playgound-body .row .col-12.mt-4.col-md-6 div:nth-child(2) div:nth-child(1) .btn.btn-primary");
		WebElement rightclick = getcssselector(".container.playgound-body .row .col-12.mt-4.col-md-6 div:nth-child(2) div:nth-child(2) .btn.btn-primary");
		WebElement singleclick = getcssselector(".container.playgound-body .row .col-12.mt-4.col-md-6 div:nth-child(2) div:nth-child(3) .btn.btn-primary");
		
		java.util.List<WebElement> doubleclickelement= driver.findElements(By.cssSelector("#doubleClickMessage"));
		java.util.List<WebElement> rightclickelement= driver.findElements(By.cssSelector("#rightClickMessage"));
		java.util.List<WebElement> singleclickelement= driver.findElements(By.cssSelector("#dynamicClickMessage"));
		
		System.out.println(doubleclickelement.size());
		action.doubleClick(doubleclick).build().perform();
		doubleclickelement= driver.findElements(By.cssSelector("#doubleClickMessage"));
		System.out.println(doubleclickelement.size());
		
		Thread.sleep(1000);
		System.out.println(rightclickelement.size());
		action.contextClick(rightclick).build().perform();
		rightclickelement= driver.findElements(By.cssSelector("#rightClickMessage"));
		System.out.println(rightclickelement.size());
		
	
		Thread.sleep(1000);
		System.out.println(singleclickelement.size());
		action.click(singleclick).build().perform();
		singleclickelement= driver.findElements(By.cssSelector("#dynamicClickMessage"));
		System.out.println(singleclickelement.size());
	}

}
