package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.utilities.TestUtil;
import com.utilities.WebEventListener;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public static Logger log = Logger.getLogger(BaseClass.class);

	public BaseClass() {
		prop = new Properties();
		FileInputStream ip = null;
		try {
			ip = new FileInputStream(
					"C:\\Users\\VAIBHAV\\eclipse-workspace\\Facebook_Framework\\src\\main\\java\\com\\config\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\VAIBHAV\\QAAutomation\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Lunching Chrome Browser....");
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\VAIBHAV\\eclipse-workspace\\Facebook_Automation\\driver\\geckodriver.exe");

			driver = new FirefoxDriver();
			log.info("Lunching Firefox Browser....");
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		log.info("Maximizing Browser....");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TImeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		log.info("Opening Application URL....");

	}

}
