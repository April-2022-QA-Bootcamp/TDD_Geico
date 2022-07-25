package com.geico.qa.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.geico.qa.common.Commons;
import com.geico.qa.objects.AboutYou;
import com.geico.qa.objects.HomePage;
import com.geico.qa.utils.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public Configuration configuration = new Configuration(null);
	
	WebDriver driver;
	
	protected Commons commons;
	protected HomePage homePage;
	protected AboutYou aboutYou;
	
	@BeforeMethod
	public void setUp() {
		driver = localDriver("chrome");
		driver.manage().window().maximize();
		driver.get(configuration.getConfiguration("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("pageloadWait"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("implicitWait"))));
		initClasses();
	}
	
	private WebDriver localDriver(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		return driver;
	}
	
	private void initClasses() {
		commons = new Commons();
		homePage = new HomePage(driver, commons);
		aboutYou = new AboutYou(driver, commons);
	}
	
	protected WebDriver getDriver() {
		return driver;
	}
	
	@AfterMethod
	public void terminate() {
		driver.quit();
	}
}
