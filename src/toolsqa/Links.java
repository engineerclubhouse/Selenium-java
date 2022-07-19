package toolsqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {
	static WebDriver driver;

	public static WebElement getcssselector(String str) {
		return driver.findElement(By.cssSelector(str));
	}

	public static void verifyfield(WebElement e, String str) {
		if (e.getText().contains(str)) {
			System.out.println("Correct value");
		} else {
			System.out.println("WebElement text" + e.getText() + "---" + "Actual text" + str);
		}

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "G:\\testing\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("https://demoqa.com/");

		WebElement elements = getcssselector(".category-cards .card.mt-4.top-card:nth-child(1)");
		elements.click();

		WebElement linkcontainer = getcssselector(
				".accordion .element-group:nth-child(1) .menu-list .btn.btn-light:nth-child(6)");

		Thread.sleep(1000);
		linkcontainer.click();
		
		String mainWindow = driver.getWindowHandle();
		
		WebElement homewindow =  getcssselector("#simpleLink");
		WebElement homenewwindow =  getcssselector("#dynamicLink");
		WebElement createdlink =  getcssselector("#created");
		WebElement forbiddenlink =  getcssselector("#forbidden");
		homewindow.click();
		Thread.sleep(1000);
		driver.switchTo().window(mainWindow);
		homenewwindow.click();
		Thread.sleep(1000);
		driver.switchTo().window(mainWindow);
		
		createdlink.click();
		Thread.sleep(1000);
		WebElement output= getcssselector("#linkResponse");
		String log = output.getText();
		if(log.contains("201") && log.contains("Created")) {
			System.out.print("hey");
		}
		
		forbiddenlink.click();
		Thread.sleep(1000);
		output= getcssselector("#linkResponse");
		log = output.getText();
		if(log.contains("201") && log.contains("Forbidden")) {
			System.out.print("hey");
		}
	}

}
