package org.testJenkins;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestGridHeadless {
	
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;

	/*@Test
	public void f() throws MalformedURLException {
			//System.setProperty("webdriver.firefox.bin", "E:\\Mozilla Firefox\\firefox.exe");
			String URL = "https://cn.bing.com";
			FirefoxBinary firefoxBinary = new FirefoxBinary();//实例化firefox二进制浏览器
			firefoxBinary.addCommandLineOptions("--headless");//设置firefox二进制浏览器headless模式
			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");//设置firefox driver路径
			FirefoxOptions firefoxOptions = new FirefoxOptions();//实例化firefox设置对象
			firefoxOptions.setBinary(firefoxBinary);
			WebDriver driver = new FirefoxDriver(firefoxOptions);
			
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			String Node = "http://172.17.0.1:4444/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), cap);
			
			driver.navigate().to(URL);
			String title = driver.getTitle();
	        System.out.println("title:"+title);
	        driver.quit();
	}*/

	/*@Test
	public void testChrome() throws MalformedURLException {
		 	System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
	        ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.addArguments("--headless");//设置为 headless 模式 （必须）
	        chromeOptions.addArguments("disable-gpu"); 
	        WebDriver driver = new ChromeDriver(chromeOptions);
	        
	        DesiredCapabilities cap = DesiredCapabilities.chrome();
	        cap.setBrowserName("chrome");
			String Node = "http://192.168.40.184:4444/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), cap);
			try {
				System.out.println("等着呢");
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String URL = "https://cn.bing.com";
	        driver.navigate().to(URL);
			
	        //driver.get("https://www.baidu.com");
	        String title = driver.getTitle();
	        System.out.println("x"+title);
	        driver.quit();
	}*/
	
	//@Test
//	public void testChrome() throws MalformedURLException {
	public static void main(String args[]){
		 	System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		 	ChromeOptions chromeOptions = new ChromeOptions();
	       // chromeOptions.addArguments("--headless");//设置为 headless 模式 （必须）
	        /*chromeOptions.addArguments("disable-gpu"); 
	        chromeOptions.addArguments("headless");*/
	        WebDriver driver = new ChromeDriver(chromeOptions);//chromeOptions
	        
	        DesiredCapabilities cap = DesiredCapabilities.chrome();
	        cap.setBrowserName("chrome");
			String Node = "http://192.168.40.73:4444/wd/hub";
			
/*			Proxy proxy = new Proxy();
			proxy.setHttpProxy("http://192.168.40.184:4444/wd/hub");
			cap.setCapability("proxy", proxy);
			driver = new ChromeDriver(cap);
*/			
			 //new ChromeDriver();
			try {
				System.out.println("x微软 Bing 搜索 - 国内版x微软 Bing 搜索 - 国内版-------等着呢");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//driver = new RemoteWebDriver(new URL(Node), cap);
			
			String URL = "https://cn.bing.com";
	        driver.navigate().to(URL);
			
	        //driver.get("https://www.baidu.com");
	        String title = driver.getTitle();
	        System.out.println("x"+title);
	        driver.quit();
	}
}