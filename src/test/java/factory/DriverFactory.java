package factory;





import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import utils.configReader;

public class DriverFactory {
	protected static WebDriver driver;
	
	public static void initBrowser(String browserName) {

		if(browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(browserName.equals("firefox")) {
			driver=new FirefoxDriver();
		}
	}
 public static WebDriver getDriver() {
		return driver;
	}
 @BeforeTest
 public void setUp() {
		
		      Properties prop=configReader.initprop();
		      DriverFactory.initBrowser(prop.getProperty("browser"));
              driver=DriverFactory.getDriver();
			  driver.manage().deleteAllCookies();
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  driver.get(prop.getProperty("url"));
			 
		   }

}
