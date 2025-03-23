package DriverFactory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import UtilsLib.ConfigReader;

public class DriverClass {
	
	public WebDriver driver;
	static Properties prop;
	
	public DriverClass() {
		ConfigReader conread = new ConfigReader();
		prop = conread.init_Properties();
	}
	
	public static String getbrowser() {
		return prop.getProperty("Browser");
		
	}
	
	public WebDriver getDriver() {
	
		String browsername = getbrowser();
		System.out.println(browsername);
		
		if(browsername.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browsername.equals("Edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
		
	}

}
