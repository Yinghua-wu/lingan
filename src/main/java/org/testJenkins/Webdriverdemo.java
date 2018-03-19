package org.testJenkins;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.URL;

public class Webdriverdemo {
	public WebDriver driver;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;
	@Parameters("browser")
	@BeforeTest
	public void launchapp(String browser) throws MalformedURLException {
			//指定hub节点url，也可以指定node节点url
			String Node = "http://192.168.40.73:4444/wd/hub";
			//添加测试浏览器类型
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			driver = new RemoteWebDriver(new URL(Node), cap);
	}

	@Test
	public void calculatepercent() {
			driver.get("https://www.baidu.com");
			String title = driver.getTitle();
			System.out.println(title);
	}

	@AfterTest
	public void closeBrowser() {
			driver.quit();
	}
}