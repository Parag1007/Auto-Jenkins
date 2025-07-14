package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.base.BaseTest;

public class TestUtil extends BaseTest {

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\DELL\\Desktop\\jun11\\Banking_automation\\src\\main\\java\\com\\testdata\\UserData.xlsx";
	public static File excelfile;
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static DataFormatter df;

	public TestUtil() throws FileNotFoundException {
 
	}
 
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	public static void scrollUp(WebElement scrollupObject) {
		JavascriptExecutor jsexcute = (JavascriptExecutor) driver;
		jsexcute.executeScript("arguments[0].scrollIntoView();", scrollupObject);
	}

	public static void scrollDown(WebDriver driver, int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixels + ")");
	}

	public static void scrollUp(WebDriver driver, int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-" + pixels + ")");
	}

	public static String handleAlert() {

		Alert alert = driver.switchTo().alert();
		String alerttext = alert.getText();
		alert.accept();

		return alerttext;

	}

	public static String[][] excelData(String sheetname) throws Exception {
		excelfile = new File(TESTDATA_SHEET_PATH);
		fis = new FileInputStream(excelfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetname);
		int numOfRows = sheet.getPhysicalNumberOfRows();
		int Colm = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[numOfRows - 1][Colm];
		for (int i = 0; i < numOfRows - 1; i++) {
			for (int j = 0; j < Colm; j++) {
				df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
				// System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
		}
		workbook.close();
		fis.close();
		return data;
	}

	public static void MouseClick() {

	}

	public static void pressTabButton() {

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).build().perform();
	}
	 
	 public static void selectByVisibleText(WebElement dropdownElement, String text) {
	        Select select = new Select(dropdownElement);
	        select.selectByVisibleText(text);
	    }

}
