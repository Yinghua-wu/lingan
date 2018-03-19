package org.testJenkins;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class TestHtmlUnit {
	HtmlUnitDriver driver;
	
	@BeforeTest
	public void testBefore() {
		driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_52);
		//driver = new HtmlUnitDriver(BrowserVersion.CHROME);
		
		driver.setJavascriptEnabled(true);//关闭JS操作,不能关
		
		//driver.navigate().to("http://springmvc-wfproject5.openshift.axies.org/springmvc/");
		driver.navigate().to("http://127.0.0.1:8081//springmvc");
	}

	@Test
	public void testContent() {
		// 测试新增页面返回button
		driver.findElement(By.linkText("Add User Info")).click();
		driver.findElement(By.linkText("Go Back")).click();

		// 测试新增数据
		driver.findElement(By.linkText("Add User Info")).click();
		driver.findElement(By.id("username")).sendKeys("testHtmlUnit");
		driver.findElement(By.id("password")).sendKeys("testHtmlUnit1");
		driver.findElement(By.id("nickname")).sendKeys("testHtmlUnit2");
		driver.findElement(By.id("email")).sendKeys("testHtmlUnit3");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// 放置一个隐式等待，等待10秒后再抛出
		WebElement input = driver.findElement(By.xpath("//input[@value='Submit']"));
		input.submit();

		// 测试修改数据
		/*driver.findElements(By.linkText("Change")).get(0).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("ChangeHtmlunit");
		driver.findElement(By.id("nickname")).clear();
		driver.findElement(By.id("nickname")).sendKeys("ChangeHtmlunit2");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("ChangeHtmlunit3");
		WebElement input2 = driver.findElement(By.xpath("//input[@value='Submit']"));
		input2.submit();*/

		// 测试删除数据
		//driver.findElements(By.linkText("Delete")).get(0).click();

	}

	@AfterTest
	public void testAfter() {
		System.out.println("testFirefoxFinsh");
		//System.out.println("testChromeFinsh");
		driver.quit();
	}
	/*@Test
	public void f() {
		HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_52);
		//HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
		
		driver.setJavascriptEnabled(true);//关闭JS操作,不能关
		
		driver.navigate().to("http://springmvc-wfproject5.openshift.axies.org/springmvc/");
		
		driver.findElement(By.id("first")).sendKeys("345");
		driver.findElement(By.id("last")).sendKeys("1678");
		driver.findElement(By.id("button")).click();
		WebElement element = driver.findElement(By.id("all"));
		String result = element.getAttribute("value");
		System.out.println(" The Result is " + result);
		
		driver.quit();// 关闭浏览器

	}*/

	/*可用
	@Test
	public void f() {
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setCssEnabled(false);
		HtmlPage page;
		try {
			page = webClient.getPage("http://www.baidu.com/");
			String str = page.getTitleText();
			System.out.println(str);
			// 关闭webclient
			webClient.close();
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
