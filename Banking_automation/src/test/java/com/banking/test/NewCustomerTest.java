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
import com.pages.NewCustomerPage;
import com.util.TestUtil;

public class NewCustomerTest extends BaseTest {

	LoginPage loginpage;
	Homepage homepage;
	NewCustomerPage newcustomerpage;
	String url = "custom_page_url"; 
	String sheetname = "new_Customer_form_data";
 
	public NewCustomerTest() throws FileNotFoundException {
		super();
	}

	@BeforeClass
	public void setup() throws FileNotFoundException, InterruptedException {

		//initilzation();
		loginpage = new LoginPage();
		newcustomerpage = new NewCustomerPage();
		homepage = loginpage.login_with_credentials(prop.getProperty("username"), prop.getProperty("password"));
		homepage.click_On_new_CustomerPage();
	}

	@Test
	public void Validate_addCustomer_Form_Test() throws InterruptedException {
		Thread.sleep(3000);
		newcustomerpage.validateNewCustomerForm("nnnn", "nnn", "bbbb", "bbb", "422004", "9422982240", "kakad@gmail.com",
				"parag234");
		String alertmsg = TestUtil.handleAlert();
		Assert.assertEquals(alertmsg, "please fill all fields");

	}

 	@Test(dataProvider = "formdata")
	public void validateformfield_test(String nm, String add, String city, String state, String pin, String mob,
			String email, String pass) throws InterruptedException {
 
	}

	@DataProvider
	public String[][] formdata() throws Exception {
		return TestUtil.excelData(sheetname);

	}
 
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
