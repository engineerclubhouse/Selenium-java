package toolsqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brokenimg {
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
		
		String url = "https://demoqa.com/";
		driver.get(url);

		WebElement elements = getcssselector(".category-cards .card.mt-4.top-card:nth-child(1)");
		elements.click();

		WebElement linkcontainer = getcssselector(
				".accordion .element-group:nth-child(1) .menu-list .btn.btn-light:nth-child(7)");

		Thread.sleep(1000);
		linkcontainer.click();
		
		WebElement validimg = getcssselector(
				".container.playgound-body .col-12.mt-4.col-md-6 img:nth-child(2)");
		WebElement brokenimg = getcssselector(
				".container.playgound-body .col-12.mt-4.col-md-6 img:nth-child(6)");
		WebElement validlink = getcssselector(
				".container.playgound-body .col-12.mt-4.col-md-6 a:nth-child(10)");
		WebElement brokenlink = getcssselector(
				".container.playgound-body .col-12.mt-4.col-md-6 a:nth-child(14)");
		
		if(Integer.valueOf(validimg.getAttribute("naturalWidth")) > 0) {
			System.out.println("validimg");
		}else {
			System.out.println("invalid");
		}
		
		if(Integer.valueOf(brokenimg.getAttribute("naturalWidth")) > 0) {
			System.out.println("validimg");
		}else {
			System.out.println("invalid");
		}
		
		validlink.click();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		brokenlink.click();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
	}

}
