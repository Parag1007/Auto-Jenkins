package com.banking.test;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.ChangepwdPage;
import com.pages.Homepage;
import com.pages.LoginPage;
import com.util.TestUtil;

public class ChangePwdTest extends BaseTest {

	LoginPage loginpage;
	Homepage homepage;
	ChangepwdPage chngpwd;
	String sheetname = "Change_pwd_data";

	public ChangePwdTest() throws FileNotFoundException {
		super();
	}

	@BeforeClass
	public void setup() throws FileNotFoundException {

		loginpage = new LoginPage();
		chngpwd = new ChangepwdPage();
		homepage = loginpage.login_with_credentials(prop.getProperty("username"), prop.getProperty("password"));
		homepage.Click_On_changePwd();

	}

	@Test(dataProvider = "formdata")
	public void validate_chng_pwd_test(String old, String newpwd, String confirm, String msg)
			throws InterruptedException {
		// 1 old pass incorrect
		chngpwd.validate_chng_pwd_form(old, newpwd, confirm);
		String actual = TestUtil.handleAlert();
		Assert.assertEquals(actual, msg);

		// 2
		chngpwd.validate_chng_pwd_formm(old, newpwd, confirm);
		String confirmsmg =chngpwd.confirm_pass_msg_verify();
		Assert.assertEquals(actual , msg);

	}

	@DataProvider
	public String[][] formdata() throws Exception {

		return TestUtil.excelData(sheetname);
	}

}
