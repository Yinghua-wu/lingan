package org.testJenkins;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSpringmvc {
	WebDriver driver;

	@BeforeTest
	public void testBefore() throws MalformedURLException {
		//firefox
		System.out.println("springmvc start");
		//System.setProperty("webdriver.firefox.bin", "E:\\Mozilla Firefox\\firefox.exe");
		//System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
		
		
		String PROXY = "192.168.30.100:8090";
        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
        proxy.setHttpProxy(PROXY)
             .setFtpProxy(PROXY)
             .setSslProxy(PROXY);
 

        
       
		
		
		
		String Node = "http://192.168.40.73:4444/wd/hub";
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		//cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        //cap.setCapability("ignoreProtectedModeSettings", true);
        cap.setCapability(CapabilityType.PROXY, proxy);
		//cap.setBrowserName("firefox");
		driver = new RemoteWebDriver(new URL(Node), cap);
		
		
		
	
		
		//driver = new FirefoxDriver();
		
		//Chrome
		//System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		/*System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();*/
		// 连接url
	////	driver.navigate().to("http://localhost:8081/springmvc/user/list");
		driver.navigate().to("http://192.168.40.73:8081/springmvc/");
		//driver.navigate().to("https://www.baidu.com");
	}

	@Test
	public void testContent() {
		String title = driver.getTitle();
		//System.out.println(title+TestSpring.in);
		// 测试新增页面返回button
		driver.findElement(By.linkText("Add User Info")).click();
		driver.findElement(By.linkText("Go Back")).click();

		// 测试新增数据
		driver.findElement(By.linkText("Add User Info")).click();
		driver.findElement(By.id("username")).sendKeys("testAdd");
		driver.findElement(By.id("password")).sendKeys("testAdd1");
		driver.findElement(By.id("nickname")).sendKeys("testAdd2");
		driver.findElement(By.id("email")).sendKeys("testAdd3");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// 放置一个隐式等待，等待10秒后再抛出
		WebElement input = driver.findElement(By.xpath("//input[@value='Submit']"));
		input.submit();

		// 测试修改数据
		driver.findElements(By.linkText("Change")).get(0).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("testChange");
		driver.findElement(By.id("nickname")).clear();
		driver.findElement(By.id("nickname")).sendKeys("testChange2");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("testChange3");
		WebElement input2 = driver.findElement(By.xpath("//input[@value='Submit']"));
		input2.submit();

		// 测试删除数据
		driver.findElements(By.linkText("Delete")).get(0).click();

	}

	@AfterTest
	public void testAfter() {
		driver.close();
		System.out.println("springmvc_testFinsh");
		
	}
}
