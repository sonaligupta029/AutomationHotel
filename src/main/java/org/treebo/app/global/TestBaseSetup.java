package org.treebo.app.global;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.condition.And;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.treebo.app.global.Base;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBaseSetup extends Base {

	public DesiredCapabilities capabilities;
	
	public static Properties commonData;

	public void setCapabilities() {
		capabilities = new DesiredCapabilities();
		if (Base.platform.equals("ios")) {
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
			capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
			capabilities.setCapability("app", "/Users/sonaliGupta/Downloads/starscream2.app");
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		} else {
			System.out.println("Android automation");
			if (!isDeviceFarm) {
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android SDK build for x86");
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				//String location = System.getProperty("user.dir")+"/universal.apk";
				//		+ "/src/main/java/com/treebo/mobileautomation/apk/treebo-prod.apk";
				//location = "/Users/amitakhyabhuyan/Downloads/release.apk";
				//String location = "/Users/amitakhyabhuyan/Downloads/treebo.apk";
				//System.out.println(location);
				
				//capabilities.setCapability(MobileCapabilityType.APP, location);
				// capabilities.setCapability(MobileCapabilityType.APP,
				// "/Users/amitakhyabhuyan/Downloads/treebo-prod.apk");
				capabilities.setCapability("debug", false);
			}
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
			capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
			System.out.println("All the capabilities are set");
		}

	}

	@BeforeSuite(alwaysRun = true)
	public void initTest() {
		try {
			// MobileDriver<MobileElement> driver;
			// driver = (MobileDriver<MobileElement>)
			// DriverManager.getInstance().getDriver();
			// WebDriver driver = DriverManager.getInstance().getDriver();

			System.out.println("before method start");
			// System.out.println("Test case name : " + method.getName());
			
			try {
				commonData = new Properties();
				System.out.println("properties created");
				//FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/common.properties");
				//commonData.load(fi);
				commonData.load(TestBaseSetup.class.getResourceAsStream("/common.properties"));

				System.out.println("properties loaded");
			} catch (Exception e) {
				e.printStackTrace();
				Assert.assertTrue(false, "Error occured loading properties file.");
			}

			System.out.println("before method end");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false, "Error in setting up driver");
		}
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() throws MalformedURLException, InterruptedException {
		setCapabilities();
		if (Base.platform.equals("ios")) {
			driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			Duration d = Duration.ofSeconds(1);
			driver.runAppInBackground(d);
		} else {
			try {
				System.out.println("Setting up android driver");
				// 127 is used by ADF
				driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				//driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				//driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				System.out.println("Android driver is initialised");
			} catch (Exception e) {
				System.out.println("0.0.0.0 failed");
				e.printStackTrace();
				try {
					//driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
					driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				} catch (Exception ex) {
					System.out.println("localhost failed");
					ex.printStackTrace();
				}
			}
			
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Implicit wait time is set.");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) throws IOException {
		if (!(result.getThrowable() == null)) {
			// Putting the complete stack trace of Exception in a String
			StringWriter errors = new StringWriter();
			result.getThrowable().printStackTrace(new PrintWriter(errors));
			String trace = errors.toString();
			System.out.println(trace);
		}
		//driver.close();
		//driver.quit();

		System.out.println("Test completed is: " + result.getName() + " Status : " + result.isSuccess());

	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		driver.quit();
	}

}
