package org.testJenkins;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestNoMaven {
	
	public static void main(String[] args) throws MalformedURLException {
		f();
	}
	
	public static void f() throws MalformedURLException{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		driver = new ChromeDriver();
		/*String Node = "http://192.168.40.184:4444/wd/hub";
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		driver = new RemoteWebDriver(new URL(Node), cap);*/

		String URL = "https://cn.bing.com";
		driver.navigate().to(URL);
		String title = driver.getTitle();
		System.out.println("x" + title);
		driver.quit();
	}
}
