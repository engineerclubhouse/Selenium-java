package toolsqa;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	static WebDriver driver;
	
	public static WebElement getcssselector(String str) {
		return driver.findElement(By.cssSelector(str));
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "G:\\\\testing\\\\selenium\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.get("https://demoqa.com/");
		
		WebElement element = getcssselector(".category-cards .card.mt-4.top-card:nth-child(1)");
		element.click();
		
		WebElement checkBoxContainer = getcssselector(".accordion .element-group:nth-child(1) .menu-list .btn.btn-light:nth-child(2)");
		
		Thread.sleep(1000);
		checkBoxContainer.click();
		
		WebElement home = getcssselector(".react-checkbox-tree.rct-icons-fa4 > ol > li.rct-node.rct-node-parent > .rct-text > .rct-collapse.rct-collapse-btn");
		WebElement homeCheckbox = getcssselector(".react-checkbox-tree.rct-icons-fa4 > ol > li.rct-node.rct-node-parent > .rct-text > [for=\"tree-node-home\"]");
		WebElement homeCheckboxLabel = homeCheckbox.findElement(By.cssSelector("input"));
		
		Thread.sleep(1000);
		try {
			WebElement desktop = getcssselector(".react-checkbox-tree.rct-icons-fa4 > ol > .rct-node.rct-node-parent li:nth-of-type(1) .rct-text");
			WebElement documents = getcssselector(".react-checkbox-tree.rct-icons-fa4 > ol > .rct-node.rct-node-parent li:nth-of-type(2) .rct-text");
			WebElement downloads = getcssselector(".react-checkbox-tree.rct-icons-fa4 > ol > .rct-node.rct-node-parent li:nth-of-type(3) .rct-text");
			System.out.println(desktop.isDisplayed());
			System.out.println(documents.isDisplayed());
			System.out.println(downloads.isDisplayed());
		}catch(Exception e) {
			
		}finally{
			System.out.println("falseasdasd");
		}
		home.click();
		
		System.out.println(homeCheckboxLabel.isSelected());
		System.out.println(homeCheckboxLabel.getAttribute("type"));
		
		homeCheckbox.click();
		Thread.sleep(1000);
		System.out.println(homeCheckboxLabel.isSelected());
		
		WebElement desktop = getcssselector(".react-checkbox-tree.rct-icons-fa4 > ol > .rct-node.rct-node-parent li:nth-of-type(1) .rct-text");
		WebElement documents = getcssselector(".react-checkbox-tree.rct-icons-fa4 > ol > .rct-node.rct-node-parent li:nth-of-type(2) .rct-text");
		WebElement downloads = getcssselector(".react-checkbox-tree.rct-icons-fa4 > ol > .rct-node.rct-node-parent li:nth-of-type(3) .rct-text");
		
		System.out.println(desktop.isDisplayed());
		System.out.println(documents.isDisplayed());
		System.out.println(downloads.isDisplayed());
		
		WebElement desktoplabel = getcssselector(".react-checkbox-tree.rct-icons-fa4 > ol > .rct-node.rct-node-parent li:nth-of-type(1) [for=\"tree-node-desktop\"] input");
		WebElement documentslabel = getcssselector(".react-checkbox-tree.rct-icons-fa4 > ol > .rct-node.rct-node-parent li:nth-of-type(2) [for=\"tree-node-documents\"] input");
		WebElement downloadslabel = getcssselector(".react-checkbox-tree.rct-icons-fa4 > ol > .rct-node.rct-node-parent li:nth-of-type(3) [for=\"tree-node-downloads\"] input");
		
		WebElement output = getcssselector(".display-result.mt-4");
		
		System.out.println(output.getText().contains("downloads"));
		getcssselector(".react-checkbox-tree.rct-icons-fa4 > ol > .rct-node.rct-node-parent li:nth-of-type(3) [for=\"tree-node-downloads\"]").click();
		System.out.println(desktoplabel.isSelected());
		System.out.println(documentslabel.isSelected());
		System.out.println(downloadslabel.isSelected());
		System.out.println(output.getText().contains("downloads"));
		
		WebElement documentsbtn = getcssselector(".react-checkbox-tree.rct-icons-fa4 > ol > .rct-node.rct-node-parent li:nth-of-type(2) button");
		documentsbtn.click();
		
		WebElement office = getcssselector(".react-checkbox-tree.rct-icons-fa4 > ol > .rct-node.rct-node-parent li:nth-of-type(2) .rct-node.rct-node-parent:nth-of-type(2)");
		WebElement officebtn= office.findElement(By.cssSelector(".rct-collapse"));
		WebElement officecheckbox= office.findElement(By.cssSelector("input"));
		WebElement officelabel = office.findElement(By.cssSelector(".rct-title"));
		
		System.out.println("office "+ officecheckbox.isSelected());
		System.out.println("office "+ office.isDisplayed());
		System.out.println("office "+ officelabel.getText());
		
		officebtn.click();
		
		WebElement general = getcssselector(".react-checkbox-tree.rct-icons-fa4 > ol > .rct-node.rct-node-parent li:nth-of-type(2) .rct-node.rct-node-parent:nth-of-type(2) .rct-node.rct-node-leaf:nth-child(4)");
		
		System.out.println(general.getText());
		System.out.println(general.findElement(By.cssSelector("input")).isSelected());
		Thread.sleep(2000);
		
		driver.close();
	}

}
