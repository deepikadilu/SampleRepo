package gridTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {
DesiredCapabilities cap;
String browser="chrome";
public static String hubAddress=" http://192.168.1.8:4444/wd/hub";

public WebDriver setDriver(WebDriver driver) throws InterruptedException,MalformedURLException{
	if(browser=="chrome") {
		//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
		cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);
	}
	
	driver=new RemoteWebDriver(new URL(hubAddress),cap);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	driver.manage().window().maximize();
	return driver;
}
}
