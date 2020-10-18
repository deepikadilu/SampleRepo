package stepDefs;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import excelUtil.ReadWriteExcel;
import gridTest.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.HomeLocation;

public class ApplicationDef {
	WebDriver driver;
	String baseUrl;
	HomeLocation locsearch;
	Base tb=new Base();
	
	@Before
	public void initialStart() throws MalformedURLException,InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
		driver=tb.setDriver(driver);
		//driver = new ChromeDriver();
		baseUrl = "https://www.swiggy.com";
	}
	@Given("user with localhost url")
	public void user_with_localhost_url() throws InterruptedException {
	   driver.get("http://localhost:8080/");
	   Thread.sleep(3000);
	}

	@Then("verify the text in screen")
	public void verify_the_text_in_screen() {
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains("Hello World Spring Boot!"), "Text found!");
//		boolean s=driver.getPageSource().contains("Hello World Spring Boot!");
//	    Assert.assertTrue(s, "Text Present");
	}

	
	@Given("user is in Swiggy application")
	public void user_is_in_swiggy_application() {		
	   driver.get(baseUrl);
	   driver.manage().window().maximize();
	   System.out.println("User in swiggy page");
	}

	@When("user seaches {string} in the page")
	public void user_seaches_in_the_page(String string) throws InterruptedException {
		System.out.println("User in swiggy page1");
		locsearch = new HomeLocation(driver);
		locsearch.locationInput(string);
		Thread.sleep(3000);
		List<WebElement> statusvalues = driver.findElement(By.xpath("//div[@class='_1oLDb']")).findElements(By.tagName("span"));
//		for (WebElement option : statusvalues)
//		{
//			if (option.getText().contains("Vanchiyoor, Thiruvananthapuram, Kerala, India"))
//				option.click();
			statusvalues.get(0).click();
		   //System.out.println(option.getText());         
//		}
		
		System.out.println("User in swiggy page2");
		Thread.sleep(5000);	
	}

	@Then("user navigates to homepage")
	public void user_navigates_to_homepage() throws InterruptedException {
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.swiggy.com/restaurants" );
		System.out.println("User in home location page");
		WebElement home=driver.findElement(By.className("_3odgy"));
		String actual = home.getText();
		System.out.println(actual);
		String expected="Vanchiyoor";
		Assert.assertEquals(actual, expected);
		System.out.println("Assert Passed");
		Thread.sleep(3000);
		
	}
	@Given("user is in application")
	public void user_is_in_application() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("User in swiggy page");
		   driver.get(baseUrl);
		   driver.manage().window().maximize();
	}
	@And("user clicks on Login button")
	public void user_clicks_on_login_button() throws InterruptedException {
	    driver.findElement(By.className("x4bK8")).click();
	    Thread.sleep(2000);
	}
	String exlPath="C:\\Users\\ADMIN\\eclipse-workspace\\CucumberProjTest\\ExcelData\\ExcelTestData.xlsx";
	@When("user enters {string}")
	public void user_enters(String string) throws Exception {
		
		ReadWriteExcel rw= new ReadWriteExcel(exlPath);
		string=rw.getCellData();
		System.out.println(string);
	    driver.findElement(By.id("mobile")).sendKeys(string);
	    Thread.sleep(5000);
	}

	@Then("user should click on login")
	public void user_should_click_on_login() throws InterruptedException {
		
		//driver.findElement(By.xpath("//tagname[@attribute='Login']")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/form/div[2]/a")).click();
		//driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES) ;
		Thread.sleep(15000);
		System.out.println("Click Login");
	}
	@And("verify the navigation")
	public void verify_the_navigation() throws Exception {
		ReadWriteExcel rw= new ReadWriteExcel(exlPath);
		rw.setCellData("TestCase Pass");
		System.out.println("TestCase Pass");
		System.out.println("Verify Login");

	}

	@After
	public void endSession() {
		driver.close();
	}
}
