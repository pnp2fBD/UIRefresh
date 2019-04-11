package com.ssp.uirefresh_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.Log;
import com.ssp.utils.GenericUtils;
import com.ssp.utils.WaitUtils;

public class UIRef_ManageReceipts extends LoadableComponent<UIRef_ManageReceipts> {
	private static WebDriver driver;
	private ExtentTest extentedReport;
	private boolean isPageLoaded;

	@FindBy(css = "a[title='Add Receipt']")
	WebElement btnAddReceipts;

	@FindBy(css = "custom-input-box[blur-method='checkPolicyUniqueReference'] #referenceNumber")
	WebElement txtPolicy;

	@FindBy(css = "custom-input-box[blur-method='checkClaimUniqueReference'] #referenceNumber")
	WebElement txtClaim;

	@FindBy(css = "select[name='receiptType']")
	WebElement selReceiptType;

	@FindBy(css = "select[name='receiptMethod']")
	WebElement selReceiptMethod;

	@FindBy(css = "input[name=transactionDateStart]")
	WebElement txtEntryDate;

	@FindBy(css = "input[name=transactionDateFinish]")
	WebElement txtToDate;

	@FindBy(css = "a[title=Search]")
	WebElement btnSearch;

	@FindBy(css = "table[tt-params='receiptValues'] tbody[aria-relevant=all] tr td:nth-child(5)")
	List<WebElement> tblRowsAmt;

	@FindBy(css = "table[tt-params='receiptValues'] tbody[aria-relevant=all] tr td:nth-child(2)")
	List<WebElement> tblRowsRef;

	@FindBy(css = "a[title='Complete']")
	WebElement btnComplete;

	public UIRef_ManageReceipts(WebDriver driver, ExtentTest extentedReport) {
		this.driver = driver;
		this.extentedReport = extentedReport;
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void load() {
		WaitUtils.waitForPageLoad(driver);
		if (!isPageLoaded) {
			Assert.fail();
		}
	}

	@Override
	protected void isLoaded() throws Error {
		isPageLoaded = true;
		WaitUtils.waitForPageLoad(driver);
	}

	public UIRef_AddReceipt clickAddReceipt(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, btnAddReceipts, "Unable to click button add receipt");
			btnAddReceipts.click();
			Log.pass("Clicked the buttonn add receipt", driver, extentedReport, true);
			WaitUtils.uiRefwaitForSpinner(driver);
			return new UIRef_AddReceipt(driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking the Reinstate OK  : " + e);
		}
	}

	// selReceiptType
	public void selReceiptType(String inputVal, WebDriver driver, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, selReceiptType, "Unable to select receipt type");
			Select select = new Select(selReceiptType);
			select.selectByVisibleText(inputVal);
			Log.message("Selected receipt type is : " + inputVal, extentedReport);
		} catch (Exception e) {
			Log.fail("Unable to select receipt type on manage receipt page" + e.getMessage(), driver, extentedReport,
					true);
			throw new Exception("Unable to select receipt type on manage receipt" + e);
		}
	}

	// WebElement txtPolicy;
	public void enterPolicy(String inputVal, WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtPolicy);
			txtPolicy.sendKeys(inputVal);
			Log.message("Entered policy value is : " + inputVal, driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while entering the policy on manage receipt page " + e.getMessage(), driver, extentedReport,
					true);
			throw new Exception("Error while entering the policy value on manage receipt page " + e);
		}
	}

	// WebElement selReceiptMethod;
	public void selReceiptMethod(String inputVal, WebDriver driver, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, selReceiptMethod, "Unable to select receipt method");
			Select select = new Select(selReceiptMethod);
			select.selectByVisibleText(inputVal);
			Log.message("Selected receipt method is : " + inputVal, extentedReport);
		} catch (Exception e) {
			Log.fail("Unable to select receipt method on manage receipt page" + e.getMessage(), driver, extentedReport,
					true);
			throw new Exception("Unable to select receipt method on manage receipt" + e);
		}
	}

	// WebElement txtEntryDate;
	public void enterEntryDate(WebDriver driver, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtEntryDate);
			String strDate = GenericUtils.setDate("current", txtEntryDate, 0, 0);
			Log.message("Entered the entry date is : " + strDate, driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while entering the entry date on manage receipts page  " + e.getMessage(), driver,
					extentedReport, true);
			throw new Exception("Error while entering the entry date on manage receipts page : " + e);
		}
	}

	// WebElement txtToDate;
	public void enterToDate(WebDriver driver, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtToDate);
			String strDate = GenericUtils.setDate("current", txtToDate, 0, 0);
			Log.message("Entered the to date is : " + strDate, driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while entering the to date on manage receipts page  " + e.getMessage(), driver,
					extentedReport, true);
			throw new Exception("Error while entering the to date on manage receipts page : " + e);
		}
	}

	// WebElement btnSearch;
	public void clickBtnSearch(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnSearch);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btnSearch);
			Log.pass("Clicked the button search on manage receipt ", driver, extentedReport, true);
			WaitUtils.uiRefwaitForSpinner(driver);
		} catch (Exception e) {
			Log.fail("Error while clicking the button search on manage receipt " + e.getMessage(), driver,
					extentedReport, true);
			throw new Exception("Error while clicking the button search on manage receipt  : " + e);
		}
	}

	// List <WebElement> tblRows;
	public void verifyReceipt(String inputAmt, String inputRef, ExtentTest extentedReport, WebDriver driver)
			throws Exception {
		try {
			Boolean dataExists = false;
			String amount = "null";
			String reference = "null";
			WaitUtils.waitForListElement(driver, tblRowsAmt, 60);

			if (tblRowsAmt.size() > 0) {
				for (int i = 0; i < tblRowsAmt.size(); i++) {
					if (tblRowsAmt.get(i).getText().contains(inputAmt) && tblRowsRef.get(i).getText().equals(inputRef)) {
						dataExists = true;
						amount = tblRowsAmt.get(i).getText(); 
						reference = tblRowsRef.get(i).getText();
						Log.pass("Receipt amount exist with amount value as: " + tblRowsAmt.get(i).getText() + " with policy urn :"
							+ tblRowsRef.get(i).getText(), driver, extentedReport);
					}
				}
			}
			Log.softAssertThat(dataExists,
					"Receipt amount exist with amount value as: " + amount + " with policy urn :" + reference,
					"Receipt amount is not present on manage receipt", driver, extentedReport, true);
		} catch (Exception e) {
			Log.fail("Error while verifying the receipt amount on manage receipts " + e.getMessage(), driver,
					extentedReport, true);
		}
	}

	// btnComplete
	public void clickbtnComplete(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnComplete);
			btnComplete.click();
			Log.pass("Clicked the button complete on manage receipt ", driver, extentedReport, true);
			WaitUtils.uiRefwaitForSpinner(driver);
		} catch (Exception e) {
			Log.fail("Error while clicking the button complete on manage receipt " + e.getMessage(), driver,
					extentedReport, true);
			throw new Exception("Error while clicking the button complete on manage receipt  : " + e);
		}
	}

	// txtClaim
	public void enterClaim(String inputVal, WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtClaim);
			txtClaim.sendKeys(inputVal);
			Log.message("Entered claim no. is : " + inputVal, driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while entering the claim no. on manage receipt page " + e.getMessage(), driver,
					extentedReport, true);
			throw new Exception("Error while entering the claim no. on manage receipt page " + e);
		}
	}
}
