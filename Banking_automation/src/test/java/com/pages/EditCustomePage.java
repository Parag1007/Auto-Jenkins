package com.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseTest;

public class EditCustomePage extends BaseTest {

	public EditCustomePage( ) throws FileNotFoundException {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='cusid']")
	WebElement custname;
	@FindBy(xpath = "input[value='Submit']")
	WebElement sub_btn;
	@FindBy(xpath = "input[value='Reset']")
	WebElement rst_btn;
	@FindBy(xpath = "//label[@id='message14']")
	WebElement mesg;
	@FindBy(xpath = "//a[normalize-space()='Home']")
	WebElement Home;
	

	public void cust_name(String nm) {
		custname.clear();
		custname.sendKeys(nm);
	}

	public String errorMsg() {

		return mesg.getText();
	}
	public void RedirectHome() {
		
		Home.click();
	}

}