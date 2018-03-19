package org.testJenkins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSpring {
	WebDriver driver;
	public static int in=1;
	@BeforeTest
	public void testBefore() {
		System.out.println("spring start");
		//firefox
		/*System.setProperty("webdriver.firefox.bin", "E:\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
		driver = new FirefoxDriver();*/
		
		//Chrome
		//System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		// 连接url
		//driver.navigate().to("http://springmvc-wfproject5.openshift.axies.org/springmvc/");
		driver.navigate().to("http://127.0.0.1:8081//springmvc");
	}

	@Test
	public void testContent() {
		in++;
		// 测试新增页面返回button
		/*driver.findElement(By.linkText("Add User Info")).click();
		driver.findElement(By.linkText("Go Back")).click();

		// 测试新增数据
		driver.findElement(By.linkText("Add User Info")).click();
		driver.findElement(By.id("username")).sendKeys("testAdd");
		driver.findElement(By.id("password")).sendKeys("testAdd1");
		driver.findElement(By.id("nickname")).sendKeys("testAdd2");
		driver.findElement(By.id("email")).sendKeys("testAdd3");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// 放置一个隐式等待，等待10秒后再抛出
		WebElement input = driver.findElement(By.xpath("//input[@value='Submit']"));
		input.submit();*/

		// 测试修改数据
		/*driver.findElements(By.linkText("Change")).get(0).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("testClear");
		driver.findElement(By.id("nickname")).clear();
		driver.findElement(By.id("nickname")).sendKeys("testClear2");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("testClear3");
		WebElement input2 = driver.findElement(By.xpath("//input[@value='Submit']"));
		input2.submit();*/
		driver.findElements(By.linkText("Change")).get(0).click();
		java.util.List<WebElement> inputAll = driver.findElements(By.tagName("input"));
		for(int i=0;i<inputAll.size();i++){
			if(i==1||i==0||i==5){
				System.out.println(inputAll.get(i).getText());
				continue;
			}else{
				System.out.println(inputAll.get(i).getText());
            inputAll.get(i).clear();
			}
		}
		
		//driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("testChangex");
		//driver.findElement(By.id("nickname")).clear();
		driver.findElement(By.id("nickname")).sendKeys("testChange2x");
		//driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("testChange3x");
		WebElement input2 = driver.findElement(By.xpath("//input[@value='Submit']"));
		input2.submit();

		// 测试删除数据
		//driver.findElements(By.linkText("Delete")).get(0).click();

	}
	@Test
	public void test2() {
		System.out.println("test2_------testFinsh----"+in);
		driver.quit();
	}
	@AfterTest
	public void testAfter() {
		System.out.println("testspring_testFinsh");
		driver.quit();
	}
}
