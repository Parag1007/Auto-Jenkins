package com.banking.test;


import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.Homepage;
import com.pages.LoginPage;
import com.pages.NewCustomerPage;

public class HomepageTest extends BaseTest {

	LoginPage loginpage;
	Homepage homepage;
	NewCustomerPage newCustomerPage;
	String url = "homepage_url";
	public HomepageTest() throws FileNotFoundException {
		super();
	}  
	@BeforeClass
	public void setup() throws FileNotFoundException {
	//	initilzation();
		loginpage = new LoginPage();
		homepage = loginpage.login_with_credentials(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority = 1, enabled = true)
	public void verifyHomePagetitle_Test() {
		String title = homepage.verify_homepage_title();
		Assert.assertEquals(title, "Guru99 Bank Manager HomePage", "Home page title not match");
	}
	@Test(priority = 2, enabled = true)
	public void VerifyNewCustmerPage_Test() throws FileNotFoundException {
		homepage.click_On_new_CustomerPage();
		Assert.assertEquals(homepage.validateCustomerPage(), "Add New Customer", "Customer page not match");
	}
	@Test(priority = 3, enabled = true)
	public void VerifyEditCustmerPage_Test() throws FileNotFoundException {
		homepage.click_On_editCustomer();
		Assert.assertEquals(homepage.validatEditCustomerPage(), "Edit Customer Form",
				"Customer form heading not match");
	}
	@Test(priority = 4, enabled = false)
	public void VerifyDeletetCustmerPage_Test() throws FileNotFoundException {
		homepage.click_On_deleteCustomer();
		Assert.assertEquals(homepage.validateDeleteCustomerPage(), "Delete Customer Form",
				"Delete Customer page heading not match");
	}
	@Test(priority = 5, enabled = false)
	public void VerifyNewAccountPage_Test() throws FileNotFoundException {
		homepage.click_On_New_Account();
		Assert.assertEquals(homepage.validateNewAccountPage(), "Add new account form",
				"New Account page heading not match");
	}

	@Test(priority = 6, enabled = false)
	public void VerifyEditAccountPage_Test() throws FileNotFoundException {
		homepage.Click_On_edit_account();
		Assert.assertEquals(homepage.validateEditAccountPage(), "Edit Account Form",
				"Edit Account page heading not match");
	}

	@Test(priority = 7, enabled = false)
	public void VerifyDeleteAccountPage_Test() throws FileNotFoundException {
		homepage.Click_On_Delete_account();
		Assert.assertEquals(homepage.validateDeleteAccountPage(), "Delete Account Form",
				"Delete Account page heading not match");
	}

	@Test(priority = 8)
	public void VerifyWithdrawalPage_Test() throws FileNotFoundException {
		homepage.Click_On_Withdrwal();
		Assert.assertEquals(homepage.validateWithdrawalPage(), " Amount Withdrawal Form",
				" Amount Withdrwawal page heading not match");
	}

	@Test(priority = 9)
	public void VerifyFundTransferPage_Test() throws FileNotFoundException {
		homepage.Click_On_FundTransfer();
		Assert.assertEquals(homepage.validateFundTransferPage(), " Amount Withdrawal Form",
				" Amount Withdrwawal page heading not match");
	}

	@Test(priority = 10)
	public void VerifyChnagePassrPage_Test() throws FileNotFoundException {
		homepage.Click_On_changePwd();
		Assert.assertEquals(homepage.validateChangePassPage(), "Change Password",
				" Change password page heading not match");
	}

	@Test(priority = 11)
	public void VerifyBalEnquiryPage_Test() throws FileNotFoundException {
		homepage.click_On_bal_Inquiry();
		Assert.assertEquals(homepage.validateBalEnquiryPage(), "Balance Enquiry Form",
				"Balance Enquiry page heading not match");
	}

	@Test(priority = 12)
	public void VerifyMiniStatementPage_Test() throws FileNotFoundException {
		homepage.click_On_mini_statement();
		Assert.assertEquals(homepage.validateMiniStatementPage(), "Mini Statement Form",
				"Ministatement page heading not match");
	}

	@Test(priority = 13)
	public void VerifyCustomizeStatementPage_Test() throws FileNotFoundException {
		homepage.click_On_Customize_statement();
		Assert.assertEquals(homepage.validateCustomizeStatementPage(), "Customized Statement Form",
				"Customize statement page heading not match");
	}

	@Test(priority = 14)
	public void VerifyLogoutButton_test() throws FileNotFoundException {

		// homepage.click_On_Logout();
		Assert.assertEquals(homepage.click_On_Logout(), " ", "logout button not working..");

	}

	@AfterClass
	public void teardown() {

		driver.quit(); 
	}

}
