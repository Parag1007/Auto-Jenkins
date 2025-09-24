package com.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseTest;
import com.util.TestUtil;

public class Homepage extends BaseTest {

	// Object Repository
	@FindBy(xpath = "//marquee[@behavior='alternate']")
	WebElement managerpage_Heading;

	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	WebElement new_cust_page;

	@FindBy(xpath = "//a[contains(text(),'Edit Customer')]")
	WebElement edit_customer;
	@FindBy(xpath = "//a[contains(@href,'DeleteCustomerInput.php')]")
	WebElement delete_customer;
	@FindBy(xpath = "//a[contains(text(),'New Account')]")
	WebElement new_account;
	@FindBy(xpath = "//a[contains(text(),'Edit Account')]")
	WebElement edit_account;
	@FindBy(xpath = "//a[contains(text(),'Delete Account')]")
	WebElement delete_account;
	@FindBy(xpath = "//a[contains(text(),'Deposit')]")
	WebElement deposit;
	@FindBy(xpath = "//a[normalize-space()='Withdrawal']")
	WebElement withdrwal;
	@FindBy(xpath = "//a[normalize-space()='Fund Transfer']")
	WebElement fund_transfer;
	@FindBy(xpath = "//a[contains(text(),'Change Password')]")
	WebElement chnage_pwd;
	@FindBy(xpath = "//a[contains(text(),'Balance Enquiry')]")
	WebElement bal_inquiry;
	@FindBy(xpath = "//a[contains(text(),'Mini Statement')]")
	WebElement mini_statement;
	@FindBy(xpath = "//a[contains(text(),'Customised Statement')]")
	WebElement customize_statement;
	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	WebElement logout;

	// validations Object repository

	@FindBy(xpath = "//p[@class='heading3']")
	WebElement NewCustomer_heading;
	@FindBy(xpath = "//p[contains(text(),'Edit Customer Form')]")
	WebElement edit_customer_heading;
	@FindBy(xpath = "//p[contains(text(),'Delete Customer Form')]")
	WebElement DeleteCustomerPage_Heading;
	@FindBy(xpath = "//p[contains(text(),'Add new account form')]")
	WebElement newaccountpage_Heading;
	@FindBy(xpath = "//p[contains(text(),'Edit Account Form')]")
	WebElement editaccountpage_Heading;
	@FindBy(xpath = "//p[contains(text(),'Delete Account Form')]")
	WebElement deleteaccountpage_Heading;
	@FindBy(xpath = "//p[contains(text(),'Amount Deposit Form')]")
	WebElement depositpage_Heading;
	@FindBy(xpath = "//p[contains(text(),'Amount Withdrawal Form')]")
	WebElement Withdrwalpage_Heading;
	@FindBy(xpath = "//p[contains(text(),'Fund transfer')]")
	WebElement fundtransferpage_heading;
	@FindBy(xpath = "//p[contains(text(),'Change Password')]")
	WebElement changepasspage_heading;
	@FindBy(xpath = "//p[contains(text(),'Balance Enquiry Form')]")
	WebElement balinquirypage_heading;
	@FindBy(xpath = "//p[contains(text(),'Mini Statement Form')]")
	WebElement minisatementpage_heading;
	@FindBy(xpath = "//p[contains(text(),'Customized Statement Form')]")
	WebElement customizesatementpage_heading;
	@FindBy(xpath = "")
	WebElement logoutpage_heading;

	// Actions
	public Homepage() throws FileNotFoundException {
		PageFactory.initElements(driver, this);
	}

	public String verify_homepage_title() {

		return driver.getTitle();
	}

	public boolean verifyManagerPage_heading() throws FileNotFoundException {
		return false;

	}

	public void click_On_new_CustomerPage() throws FileNotFoundException {
		new_cust_page.click();

	}

	public void click_On_editCustomer() throws FileNotFoundException {

		edit_customer.click();

	}

	public void click_On_deleteCustomer() throws FileNotFoundException {

		delete_customer.click();

	}

	public void click_On_New_Account() throws FileNotFoundException {

		new_account.click();

	}

	public void Click_On_edit_account() throws FileNotFoundException {

		edit_account.click();

	}

	public void Click_On_Delete_account() throws FileNotFoundException {

		delete_account.click();

	}

	public void click_On_Deposit() throws FileNotFoundException {

		deposit.click();

	}

	public void Click_On_Withdrwal() throws FileNotFoundException {
		driver.manage().window().minimize();
		TestUtil.scrollUp(withdrwal);
		withdrwal.click();

	}

	public void Click_On_FundTransfer() throws FileNotFoundException {
		TestUtil.scrollUp(fund_transfer);
		fund_transfer.click();

	}

	public void Click_On_changePwd() throws FileNotFoundException {
		TestUtil.scrollUp(chnage_pwd);
		chnage_pwd.click();

	}

	public void click_On_bal_Inquiry() throws FileNotFoundException {
		TestUtil.scrollUp(bal_inquiry);
		bal_inquiry.click();

	}

	public void click_On_mini_statement() throws FileNotFoundException {
		TestUtil.scrollUp(mini_statement);
		mini_statement.click();

	}

	public void click_On_Customize_statement() throws FileNotFoundException {

		TestUtil.scrollUp(customize_statement);
		customize_statement.click();

	}

	public String click_On_Logout() throws FileNotFoundException {
		TestUtil.scrollUp(logout);
		logout.click();

		return TestUtil.handleAlert();

	}

	// Page validation methods
	public String validateCustomerPage() {

		return NewCustomer_heading.getText();
	}

	public String validatEditCustomerPage() {

		return edit_customer_heading.getText();
	}

	public String validateDeleteCustomerPage() {

		return DeleteCustomerPage_Heading.getText();
	}

	public String validateNewAccountPage() {

		return newaccountpage_Heading.getText();
	}

	public String validateEditAccountPage() {

		return editaccountpage_Heading.getText();
	}

	public String validateDeleteAccountPage() {

		return deleteaccountpage_Heading.getText();
	}

	public String validateDepositPage() {

		return depositpage_Heading.getText();
	}

	public String validateWithdrawalPage() {

		return Withdrwalpage_Heading.getText();
	}

	public String validateFundTransferPage() {

		return fundtransferpage_heading.getText();
	}

	public String validateChangePassPage() {

		return changepasspage_heading.getText();
	}

	public String validateBalEnquiryPage() {

		return balinquirypage_heading.getText();
	}

	public String validateMiniStatementPage() {

		return minisatementpage_heading.getText();
	}

	public String validateCustomizeStatementPage() {

		return customizesatementpage_heading.getText();
	}

	public String validateLogoutButton() {

		return customizesatementpage_heading.getText();
	}

}
