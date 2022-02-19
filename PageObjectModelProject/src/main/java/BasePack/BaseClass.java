package BasePack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import UtilitiesPack.TestUtil;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;

	public BaseClass() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("./Configuration/PageObjectConfig.properties");
		prop.load(fis);
		
	}

	public static void initialization() {
		String browserName = prop.getProperty("Browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./Drivers//msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); 
		driver.get(prop.getProperty("url"));
		

	}
}
