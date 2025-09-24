package com.base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.util.TestUtil;

public class BaseTest {

	public static WebDriver driver;
    public	static Properties prop;
    public static String browser;

	public BaseTest() throws FileNotFoundException {
		prop = new Properties();
		FileReader fi = new FileReader(
				"C:\\Users\\DELL\\Desktop\\jun11\\Banking_automation\\src\\main\\java\\com\\config\\confi.properties");
		try {
			prop.load(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@BeforeClass 
	public static void initilzation() throws FileNotFoundException {

		String browsername = prop.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		driver.navigate().to(prop.getProperty("loginurl"));
	}
	@AfterClass
	public void tearDown() {
			driver.quit();
		System.out.println("Browser get closed.....");
	}

}
