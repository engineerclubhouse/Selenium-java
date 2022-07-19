package toolsqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

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
		driver.navigate().to("https://demoqa.com/");

		WebElement element = getcssselector(".category-cards .card.mt-4.top-card:nth-child(1)");
		element.click();

		WebElement radioBoxContainer = getcssselector(
				".accordion .element-group:nth-child(1) .menu-list .btn.btn-light:nth-child(3)");

		Thread.sleep(1000);
		radioBoxContainer.click();

		WebElement radioyes = getcssselector(".custom-control.custom-radio.custom-control-inline:nth-child(2)");

		WebElement radioyeslabel = getcssselectorextend(radioyes, "input");
		WebElement radioyesname = getcssselectorextend(radioyes, "label");

		
		System.out.println(radioyeslabel.isEnabled());
		System.out.println(radioyeslabel.isSelected());
		System.out.println(radioyesname.isDisplayed());
		System.out.println(radioyesname.getText());
		radioyesname.click();
		
		WebElement outputtext =getcssselector(".text-success");
		System.out.println(radioyeslabel.isSelected());
		System.out.println(outputtext.getText());
		
		WebElement radioImpressive = getcssselector(".custom-control.custom-radio.custom-control-inline:nth-child(3)");

		WebElement radioImpressivelabel = getcssselectorextend(radioImpressive, "input");
		WebElement radioImpressivename = getcssselectorextend(radioImpressive, "label");

		System.out.println(radioImpressivelabel.isEnabled());
		System.out.println(radioImpressivelabel.isSelected());
		System.out.println(radioImpressivename.isDisplayed());
		System.out.println(radioImpressivename.getText());
		radioImpressivename.click();
		
		System.out.println(outputtext.getText());
		System.out.println(radioImpressivelabel.isSelected());
		
		
		WebElement radioNo = getcssselector(".custom-control.custom-radio.custom-control-inline:nth-child(4)");

		WebElement radioNolabel = getcssselectorextend(radioNo, "input");
		WebElement radioNoname = getcssselectorextend(radioNo, "label");

		System.out.println(radioNolabel.isEnabled());
		System.out.println(radioNolabel.isSelected());
		System.out.println(radioNoname.isDisplayed());
		System.out.println(radioNoname.getText());
		radioNoname.click();
		
		System.out.println(outputtext.getText());
		System.out.println(radioNolabel.isSelected());
	}

}
