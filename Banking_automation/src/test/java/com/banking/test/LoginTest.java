package com.banking.test;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.Homepage;
import com.pages.LoginPage;
import com.util.TestUtil;

public class LoginTest extends BaseTest {

	LoginPage loginpage;
	String SheetName = "login1";
	Homepage homepage;

	public LoginTest() throws FileNotFoundException {
		super();
	}

	@BeforeClass
	public void setup() throws FileNotFoundException {
		//initilzation();
		loginpage = new LoginPage();

	}

	@Test(priority = 1, enabled = true)
	public void login_page_title() {

		String title = loginpage.vlidateloginpagetitle();
		Assert.assertEquals(title, "Guru99 Bank Home Page");
	}

	@Test(enabled = true, priority = 2)
	public void loginValidCredentials_test() throws FileNotFoundException, InterruptedException {
		loginpage.login_with_credentials(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");

	}

	@Test(priority = 3, enabled = true)
	public void reset_button() throws FileNotFoundException {
		String uname = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		loginpage.validate_reset_button(uname, pwd);

	}

	@Test(enabled = true, dataProvider = "getLoginData")
	public void invalid_credentials_test(String un, String pwd) throws Exception {
		loginpage.login_with_credentials(un, pwd);
		boolean verifyManagerPage_heading = homepage.verifyManagerPage_heading();
		Assert.assertTrue(verifyManagerPage_heading, " Not displayed");

	}

	@DataProvider
	public String[][] getLoginData() throws Exception {
		return TestUtil.excelData(SheetName);

	}

	@AfterClass
	public void tearDown() {
		
	 driver.quit();
	/// tearDown();
	

	}

}
