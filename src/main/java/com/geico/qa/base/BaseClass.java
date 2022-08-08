package com.geico.qa.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.geico.qa.common.CommonFunctions;
import com.geico.qa.common.CommonWaits;
import com.geico.qa.objects.AboutYou;
import com.geico.qa.objects.HomeAddress;
import com.geico.qa.objects.HomePage;
import com.geico.qa.objects.HomeownerAboutYou;
import com.geico.qa.utils.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public Configuration configuration = new Configuration(null);
	
	WebDriver driver;
	WebDriverWait wait;
	
	protected CommonFunctions commons;
	CommonWaits waits;
	protected HomePage homePage;
	protected AboutYou aboutYou;
	protected HomeAddress homeAddress;
	protected HomeownerAboutYou homeownerAboutYou;
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser1) {
		driver = localDriver(browser1);
		driver.manage().window().maximize();
		driver.get(configuration.getConfiguration("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("pageloadWait"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("implicitWait"))));
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("explicitWait"))));
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
		}else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	private void initClasses() {
		waits = new CommonWaits(wait);
		commons = new CommonFunctions(driver, waits);
		homePage = new HomePage(driver, commons);
		aboutYou = new AboutYou(driver, commons);
		homeAddress = new HomeAddress(driver, commons);
		homeownerAboutYou = new HomeownerAboutYou(driver, commons);
		
	}
	
	protected WebDriver getDriver() {
		return driver;
	}
	
	@AfterMethod
	public void terminate() {
		driver.quit();
	}
}
