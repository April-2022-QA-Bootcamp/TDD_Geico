package com.geico.qa.base;

import java.lang.reflect.Method;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.geico.qa.common.CommonFunctions;
import com.geico.qa.common.CommonWaits;
import com.geico.qa.objects.AboutYou;
import com.geico.qa.objects.HomeAddress;
import com.geico.qa.objects.HomePage;
import com.geico.qa.objects.HomeownerAboutYou;
import com.geico.qa.reporting.ExtentManager;
import com.geico.qa.reporting.ExtentTestManager;
import com.geico.qa.utils.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public Configuration configuration = Configuration.getInstance();
	
	WebDriver driver;
	WebDriverWait wait;
	CommonWaits waits;
	ExtentReports extent;
	
	protected CommonFunctions commons;
	protected HomePage homePage;
	protected AboutYou aboutYou;
	protected HomeAddress homeAddress;
	protected HomeownerAboutYou homeownerAboutYou;
	
	@BeforeSuite
	public void initiatingReport() {
		extent = ExtentManager.initiatingReport();
	}
	
	@BeforeMethod
	public void beforeEachTest(Method method) {
		String className = method.getDeclaringClass().getSimpleName();
		ExtentTestManager.creatingTest(method.getName());
		ExtentTestManager.getTest().assignCategory(className);
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser1) {
		driver = localDriver(browser1);
		driver.manage().window().maximize();
		driver.get(configuration.get("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.get("pageloadWait"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.get("implicitWait"))));
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(configuration.get("explicitWait"))));
		initClasses();
	}
	
	@AfterMethod
	public void afterEachTest(Method method, ITestResult result) {
		for(String group: result.getMethod().getGroups()) {
			ExtentTestManager.getTest().assignCategory(group);
		}
		if(result.getStatus() == ITestResult.SUCCESS) {
			ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
		}else if(result.getStatus() == ITestResult.SKIP) {
			ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed \n" + result.getThrowable());
			ExtentTestManager.getTest().addScreenCaptureFromPath(commons.getScreenshot(method.getName()));
		}
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
	
	@AfterSuite
	public void endReport() {
		extent.flush();
	}
}
