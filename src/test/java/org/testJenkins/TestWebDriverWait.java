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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.URL;

public class TestWebDriverWait {
	public WebDriver driver;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;

	@Parameters("browser")
	@BeforeTest
	public void launchapp(String browser) throws MalformedURLException {
		String URL = "https://www.bing.com";
		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(" Executing on FireFox");
			String Node = "http://192.168.40.73:4444/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");

			driver = new RemoteWebDriver(new URL(Node), cap);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Launch website
			driver.navigate().to(URL);
			driver.manage().window().maximize();
		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}

	@Test
	public void calculatepercent() {
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.id("sb_form_q")).sendKeys("Canon");
		//driver.findElement(By.id("sb_form_go")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,10);  
        wait.until(new ExpectedCondition<WebElement>(){  
            public WebElement apply(WebDriver d) {  
                return d.findElement(By.id("sb_form_go"));  
            }}).click();
		
		String title2 = driver.getTitle();
		System.out.println(title2);
		/*File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("screenshot\\screenshot.png"));
            System.out.println("screenshot Finish");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Can't save screenshot");
            e.printStackTrace();
        } */
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}