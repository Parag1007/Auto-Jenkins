package com.banking.test;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.Homepage;
import com.pages.LoginPage;
import com.pages.NewAccountPage;
import com.util.TestUtil;

public class NewAccountTest extends BaseTest {

	LoginPage loginpage;
	Homepage homepage;
	NewAccountPage newacpage;
	String sheetname = "new_ac_form_data";

	public NewAccountTest() throws FileNotFoundException {
		super();
	}

	@BeforeClass
	public void envSetup() throws FileNotFoundException {
		// initilzation();
		loginpage = new LoginPage();
		newacpage = new NewAccountPage();
		homepage = loginpage.login_with_credentials(prop.getProperty("username"), prop.getProperty("password"));
		homepage.click_On_New_Account();
	}

	@Test(dataProvider = "formdata")
	public void verify_New_Accountform_Test(String id, String init_deposite) {
		newacpage.validate_New_Account_form(id, init_deposite);
		String actual = TestUtil.handleAlert();
		System.out.println(actual);
		Assert.assertEquals(actual, init_deposite);
	}

	@DataProvider
	public String[][] formdata() throws Exception {

		return TestUtil.excelData(sheetname);
	}

	@AfterClass
	public void tearown() {

		driver.quit();
	}
}
