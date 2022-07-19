package toolsqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Textbox {
	
	static WebDriver driver;
	
	public static WebElement getcssselector(String str) {
		return driver.findElement(By.cssSelector(str));
	}
	
	public static void verifyfield(WebElement e,String str){
		if(e.getText().contains(str)) {
			System.out.println("Correct value");
		}else {
			System.out.println("WebElement text" + e.getText() + "---" + "Actual text" + str);
		}
		
	}
	
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "G:\\testing\\selenium\\chromedriver.exe");
		driver = new  ChromeDriver();
		driver.manage().window().maximize();
//		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.get("https://demoqa.com/");
		
		WebElement elements= getcssselector(".category-cards .card.mt-4.top-card:nth-child(1)");
		elements.click();
		
		WebElement textcontainer = getcssselector(".accordion .element-group:nth-child(1) .menu-list .btn.btn-light:nth-child(1)");
		
		Thread.sleep(1000);
		textcontainer.click();
		
		WebElement fullName = getcssselector(".text-field-container .mt-2.row:nth-child(1) .mr-sm-2.form-control");
		WebElement email = getcssselector(".text-field-container .mt-2.row:nth-child(2) .mr-sm-2.form-control");
		WebElement currentAddress = getcssselector(".text-field-container .mt-2.row:nth-child(3) .form-control");
		WebElement permanentAddress = getcssselector(".text-field-container .mt-2.row:nth-child(4) .form-control");
		WebElement submitButton = getcssselector(".text-field-container .mt-2.row:nth-child(5) .btn.btn-primary");
	
		fullName.sendKeys("Nikunj Shivhare");
		email.sendKeys("Nikunj@Shivhare.com");
		currentAddress.sendKeys("Nikunj Shivhare");
		permanentAddress.sendKeys("Nikunj Shivhare");
		submitButton.click();
		
		js.executeScript("arguments[0].scrollIntoView();", fullName); // scroll to the fullname element
//		js.executeScript("window.scrollBy(0,1000)"); // scroll by 1000 pixel.
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		WebElement fullNamevalue = getcssselector(".border.col-md-12.col-sm-12 .mb-1:nth-child(1)");
		WebElement emailvalue = getcssselector(".border.col-md-12.col-sm-12 .mb-1:nth-child(2)");
		WebElement currentAddressvalue = getcssselector(".border.col-md-12.col-sm-12 .mb-1:nth-child(3)");
		WebElement permanentAddressvalue = getcssselector(".border.col-md-12.col-sm-12 .mb-1:nth-child(4)");
		
		verifyfield(fullNamevalue, "Nikunj Shivhare");
		verifyfield(emailvalue, "Nikunj@Shivhare.com");
		verifyfield(currentAddressvalue, "Nikunj Shivhare");
		verifyfield(permanentAddressvalue, "Nikunj Shivhare");
	
		Thread.sleep(2000);
		driver.close();
	}

}
