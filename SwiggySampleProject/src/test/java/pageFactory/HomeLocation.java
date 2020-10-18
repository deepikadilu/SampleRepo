package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeLocation {
	WebDriver driver;
	public HomeLocation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="location")
	WebElement loc;
	
	public void locationInput(String homeloc) {
		loc.click();
		loc.sendKeys(homeloc);
		
	}
}
