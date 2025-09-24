package com.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseTest;

public class LoginPage extends BaseTest {

	// private WebDriver driver;
//	BankingUtility utl;

	// OR
	@FindBy(xpath = "//input[@name=\"uid\"]")
	WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//input[@value='LOGIN']")
	WebElement login_btn;
	@FindBy(xpath = "//input[@value='RESET']")
	WebElement reset_btn;
	@FindBy(xpath = "/html/body/form/table/tbody/tr[3]/td[2]/input[1]")
	WebElement Loginpage_title;

	// initilization page objects
	public LoginPage() throws FileNotFoundException {
		PageFactory.initElements(driver, this);
	}

//Actions

	public String vlidateloginpagetitle() {

		return driver.getTitle();
	}

	public Homepage login_with_credentials(String user, String psw) throws FileNotFoundException {
		username.clear();
		username.sendKeys(user);
		password.clear();
		password.sendKeys(psw);
		login_btn.click();

		return new Homepage();
	}

	public void validate_reset_button(String user, String psw) throws FileNotFoundException {
		username.sendKeys(user);
		password.sendKeys(psw);
		reset_btn.click();

	}

}
