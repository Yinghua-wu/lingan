package org.testJenkins;

import java.io.File;  
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;  
import org.openqa.selenium.TakesScreenshot;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
  
public class TestScreenshot {  
    public static void main(String[] args) throws MalformedURLException {  
    	/*System.setProperty("webdriver.firefox.bin", "E:\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe"); */
    	
    	System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
    	String Node = "http://127.0.0.1:4444/wd/hub";
		String URL = "http://localhost:8081/tlcss_b2b/";
		
			System.out.println(" Executing on FireFox");
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("chrome");
			 
        WebDriver driver =new RemoteWebDriver(new URL(Node), cap);
        
        driver.get("http://localhost:8081/tlcss_b2b/"); 
        
        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(3500, 3400)); 
        
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        try {
            FileUtils.copyFile(scrFile, new File("screenshot\\screenshot.png"));
            System.out.println("screenshot Finish");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Can't save screenshot");
            e.printStackTrace();
        } 
        System.out.println(System.getProperty("file.separator")+System.getProperty("file.separator"));
        /*File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //讲截取的图片以文件的形式返回  
        try {  
            org.apache.commons.io.FileUtils.copyFile(srcFile, new File("driver\\screenshot.png"));  //使用copyFile()方法保存获取到的截图文件
            System.out.println("screenshot Finish");
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } */ 
        driver.quit();  
    }  
}  