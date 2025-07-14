package com.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseTest;
import com.util.TestUtil;

public class NewAccountPage extends BaseTest {

	@FindBy(xpath = "//input[@name='cusid']")
	WebElement cid;
//	@FindBy(xpath = "//input[@name='selaccount']")
//	WebElement click_dropdown;
	@FindBy(xpath = "//select[@name='selaccount']")
	WebElement click_dropdown;
	@FindBy(xpath = "//input[@name='inideposit']")
	WebElement initial_deposit;
	@FindBy(xpath = "//input[@name='button2']")
	WebElement sub_btn;
	@FindBy(xpath = "//input[@name='reset']")
	WebElement reset_btn;

	public NewAccountPage() throws FileNotFoundException {
		PageFactory.initElements(driver, this);
	}

	public void validate_New_Account_form(String id, String init_ammount) {
		cid.clear();
		cid.sendKeys(id);
		/// TestUtil.pressTabButton();
//		WebElement dropdown = driver.findElement(By.xpath("//input[@name='selaccount']"));
//		dropdown.click();
//	    TestUtil.selectByVisibleText(dropdown, "2");
		initial_deposit.clear();
		initial_deposit.sendKeys(init_ammount);
		sub_btn.click();

	}

}
