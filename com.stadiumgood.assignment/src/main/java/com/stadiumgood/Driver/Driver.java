//package com.stadiumgood.Driver;
//
//import java.util.ArrayList;
//import java.util.Hashtable;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.Test;
//
//import java.beans.EventHandler;
//
//
//import com.stadiumgood.UtilClasses.ReadPropertyFile;
//
//public class Driver {
//
//	public static WebDriver driver;
//	public static Logger log;
//	
//	
//	
//	@SuppressWarnings("static-access")
//	public Driver() {
//		log=log.getLogger("LOg_ Logger");
//		PropertyConfigurator.configure("log4j.properties");
//		log=Logger.getLogger(this.getClass());
//		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
//	}
//	//neet
//	public static void initialize() {
//		log.info("framework initilized");
//		String browser = ReadPropertyFile.get("Browser");
//		System.out.println("browser name="+browser);
//		try {
//			if (browser.equalsIgnoreCase("chrome")) {
//				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
//				//ChromeOptions options = new ChromeOptions();
//				//options.addArguments("--incognito");
//				//DesiredCapabilities capabilities = new DesiredCapabilities();
//				//capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//				//ChromeOptions chromeOptions = new ChromeOptions();
//				//chromeOptions.addArguments("--no-sandbox");
//				driver = new ChromeDriver();
//				//log.info("chrome driver launched");
//				
//			} else if (browser.equalsIgnoreCase("firefox")) {
//				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources//geckodriver.exe");
//				FirefoxOptions FFoptions = new FirefoxOptions();
//				FFoptions.addArguments("--incognito");
//				driver = new FirefoxDriver(FFoptions);
//			}
//		} catch (Exception e) {
//			System.out.println("Broweser did not invoke");
//		}
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Integer.parseInt(ReadPropertyFile.get("WaitTime")), TimeUnit.SECONDS);
//		driver.get(ReadPropertyFile.get("url"));
//		driver.manage().deleteAllCookies();
//	}
//
//	public void wrapUp() {
//		Driver.driver.close();
//	}
//
//	public static void quit() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}
//	
//	
//
//}
