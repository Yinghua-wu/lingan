package org.testJenkins;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.URL;

public class TestGrid {
	public WebDriver driver;
	//public String URL, Node;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;

	//@Parameters("browser")
	@BeforeTest
	public void launchapp() throws MalformedURLException {
		//String URL = "http://springmvc-wfproject5.openshift.axies.org/springmvc/";
		//String Node = "http://192.168.40.73:4444/wd/hub";
		String browser="firefox";
		String Node = "http://192.168.40.73:4444/wd/hub";
		String URL = "http://www.baidu.com";//"http://tores3-test.router.default.svc.cluster.local/TORES/";
		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(" Executing on FireFox");
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.navigate().to(URL);
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.out.println(" Executing on CHROME");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.navigate().to(URL);
			driver.manage().window().maximize();
		}else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}

	@Test
	public void calculatepercent() {
		String title = driver.getTitle();
		System.out.println(title);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("screenshot\\screenshot.png"));
            System.out.println("screenshot Finish");
        } catch (IOException e) {
            System.out.println("Can't save screenshot");
            e.printStackTrace();
        } 
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}