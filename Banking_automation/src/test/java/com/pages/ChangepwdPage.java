package com.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseTest;
import com.util.TestUtil;

public class ChangepwdPage extends BaseTest {

	@FindBy(xpath = "//input[@name=\"oldpassword\"]")
	WebElement old_pass;
	@FindBy(xpath = "//input[@name=\"newpassword\"]")
	WebElement new_pass;
	@FindBy(xpath = "//input[@name=\"confirmpassword\"]")
	WebElement confirm_pass;
	@FindBy(xpath = "//label[@id=\"message20\"]")
	WebElement old_pass_msg;
	@FindBy(xpath = "//label[@id=\"message21\"]")
	WebElement new_pass_msg;
	@FindBy(xpath = "//label[@id=\"message22\"]")
	WebElement confirm_pass_msg;
	@FindBy(xpath = "//input[@value=\"Submit\"]")
	WebElement sub_btn;

	public ChangepwdPage() throws FileNotFoundException {

		PageFactory.initElements(driver, this);

	}

	public void validate_chng_pwd_form(String oldpass, String newpass, String confirmpass) {
		old_pass.clear();
		old_pass.sendKeys(oldpass);
		new_pass.sendKeys(newpass);
		confirm_pass.sendKeys(confirmpass);
		sub_btn.click();
	}

	public void validate_chng_pwd_formm(String oldpass, String newpass, String confirmpass) {
		old_pass.clear();
		old_pass.sendKeys(oldpass);
		TestUtil.pressTabButton();
		new_pass.sendKeys(newpass);
		confirm_pass.sendKeys(confirmpass);

		
		
	}
	public String old_pass_msg_verify() {
		
		return old_pass_msg.getText();
		
		
	}
	public String new_pass_msg_verify() {
		
		return old_pass_msg.getText();
		
		
	}
	public String confirm_pass_msg_verify() {
		
		return confirm_pass_msg.getText();
		
		
	}

}
