package org.testJenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class TestHeadless {
	@Test
	public void testJ() {
		System.out.println("headless start");
		System.setProperty("webdriver.firefox.bin", "E:\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary();//实例化firefox二进制浏览器
		firefoxBinary.addCommandLineOptions("--headless");//设置firefox二进制浏览器headless模式
		System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");//设置firefox driver路径
		FirefoxOptions firefoxOptions = new FirefoxOptions();//实例化firefox设置对象
		firefoxOptions.setBinary(firefoxBinary);
		FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
		try {
			driver.navigate().to("https://www.baidu.com");
			//driver.findElement(By.id("first")).sendKeys("789");
			//driver.findElement(By.id("last")).sendKeys("123");
			//driver.findElement(By.id("button")).click();
		//	WebElement element = driver.findElement(By.id("all"));
		//	String result = element.getAttribute("value");
			//System.out.println(" The Result is " + result);
			System.out.println("headless_test"+driver.getTitle());
			/*driver.get("http://www.google.com");
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			WebElement queryBox = driver.findElement(By.name("q"));
			queryBox.sendKeys("headless firefox");
			WebElement searchBtn = driver.findElement(By.name("btnK"));
			searchBtn.click();
			WebElement iresDiv = driver.findElement(By.id("ires"));
			iresDiv.findElements(By.tagName("a")).get(0).click();
			System.out.println(driver.getPageSource());*/
		} finally {
			driver.quit();
		}
	}
	
	/*@Test
	public void testChrome() {
		 System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
	        ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.addArguments("--headless");//设置为 headless 模式 （必须）
	        WebDriver driver = new ChromeDriver(chromeOptions);
	        driver.get("https://www.baidu.com");
	        String title = driver.getTitle();
	        System.out.println("x"+title);
	        driver.quit();
	}*/
}
