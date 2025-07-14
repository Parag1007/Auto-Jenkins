package com.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseTest;
import com.util.TestUtil;

public class NewCustomerPage extends BaseTest {

	@FindBy(xpath = "//input[@name='name']")
	WebElement cust_name;
	@FindBy(xpath = "//input[@value='m']")
	WebElement male_gender;
	@FindBy(xpath = "//input[@value='f']")
	WebElement fmale_gender;
	@FindBy(xpath = "//*[@id=\"dob\"]")
	WebElement pick_birhdate;
	@FindBy(xpath = "//input[@id=\"dob\"]")
	WebElement add;
	@FindBy(xpath = "//input[@name='city']")
	WebElement City;
	@FindBy(xpath = "//input[@name='state']")
	WebElement State;
	@FindBy(xpath = "//input[@name='pinno']")
	WebElement Pin;
	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement mob_numb;
	@FindBy(xpath = "//input[@name='emailid']")
	WebElement Email;
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement pass;
	@FindBy(xpath = "//input[@name='sub']")
	WebElement submit_btn;
	@FindBy(xpath = "//input[@name='res']")
	WebElement reset_btn;

	public NewCustomerPage() throws FileNotFoundException {

		PageFactory.initElements(driver, this);

	}

	public void validateNewCustomerForm(String name, String address, String city, String state, String pin, String num,
			String email, String pwd) {

		cust_name.sendKeys(name);
		fmale_gender.click();
		// pick_birhdate.sendKeys();
		add.sendKeys(address);
		City.sendKeys(city);
		State.sendKeys(state);
		Pin.sendKeys(pin);
		mob_numb.sendKeys(num);
		Email.sendKeys(email);
		pass.sendKeys(pwd);
		submit_btn.click();
	}

	public void validaterForm_fields(String name, String address, String city, String state, String pin, String num,
			String email, String pwd) {

		cust_name.sendKeys(name);
		fmale_gender.click();
		add.sendKeys(address);
		City.sendKeys(city);
		State.sendKeys(state);
		Pin.sendKeys(pin);
		mob_numb.sendKeys(num);
		Email.sendKeys(email);
		pass.sendKeys(pwd);
		submit_btn.click();
		TestUtil.scrollUp(driver, 100);

	}

	 

}
