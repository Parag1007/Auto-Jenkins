package com.banking.test;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.EditCustomePage;
import com.pages.Homepage;
import com.pages.LoginPage;
import com.util.TestUtil;

public class EditCustomerTest extends BaseTest {

	LoginPage loginpage;
	EditCustomePage editcustomerpage;
	Homepage homepage;
	String sheetName = "edit_cust_data";

	public EditCustomerTest() throws FileNotFoundException {
		super(); 
	}
	@BeforeClass
	public void setup() throws Exception {

		//initilzation();
		loginpage = new LoginPage();
		editcustomerpage = new EditCustomePage();
		homepage = loginpage.login_with_credentials(prop.getProperty("username"), prop.getProperty("password"));
		homepage.click_On_editCustomer();

	}

	@Test(dataProvider = "editformValidationData", priority = 1)
	public void validateEditCustomerForm_field_Test(String notregistered, String expect) throws InterruptedException {
		editcustomerpage.cust_name(notregistered);
		TestUtil.pressTabButton();
		System.out.println(expect);
		Assert.assertEquals(editcustomerpage.errorMsg(), expect);
	}
	@DataProvider
	public String[][] editformValidationData() throws Exception {
		return TestUtil.excelData(sheetName);

	}
	 
	@Test(priority = 2)
	public void redirectHome_Test() {
		editcustomerpage.RedirectHome();
		Assert.assertEquals(homepage.verify_homepage_title(), "Guru99 Bank Manager HomePage");
	}
 
	@AfterClass 
	public void teaDown() {
	 	driver.quit(); 
	 	 
	}

}
