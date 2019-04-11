package com.ssp.uirefresh_pages;

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
import com.ssp.utils.WaitUtils;

public class UIRef_AddReceipt extends LoadableComponent<UIRef_AddReceipt> {
	private static WebDriver driver;
	private ExtentTest extentedReport;
	private boolean isPageLoaded;

	@FindBy(css = "select[name=receiptType]")
	WebElement selReceiptType;

	@FindBy(css = "#policyUrn")
	WebElement txtPolicy;
	
	@FindBy(css = "custom-input-box[ng-model='receiptItemObject.policyContactName'] #policyContactName")
	WebElement txtContactName;
	
	@FindBy(css = "custom-input-box[ng-model='receiptItemObject.claimRecoveryUniqueReference'] #claimUniqueRef")
	WebElement txtClaim;	

	@FindBy(css = "custom-input-box[ng-model='otherValues.chequeAmount'] #itemAmount")
	WebElement txtChqAmount;
	
	@FindBy(css = "custom-input-box[ng-model='otherValues.cashAmount'] #itemAmount")
	WebElement txtCashAmount;	

	@FindBy(css = "select[name='paymentMethodType']")
	WebElement selMethod;

	@FindBy(css = "#number")
	WebElement txtNum;

	@FindBy(css = "a[title='Post']")
	WebElement btnPost;

	@FindBy(css = "a[title='Cancel'][ng-click^='cancelProcess']")
	WebElement btnCancel;
	
	@FindBy(css = "#accountingPeriod")
	WebElement txtAccountPeriod;	

	public UIRef_AddReceipt(WebDriver driver, ExtentTest extentedReport) {
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

	// WebElement selReceiptType;
	public void selReceiptType(String inputVal, WebDriver driver, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, selReceiptType, "Unable to select receipt type");
			Select select = new Select(selReceiptType);
			select.selectByVisibleText(inputVal);
			Log.message("Selected receipt type is : " + inputVal, extentedReport);
		} catch (Exception e) {
			Log.fail("Unable to select receipt type on add receipt page" + e.getMessage(), driver, extentedReport,
					true);
			throw new Exception("Unable to select receipt type " + e);
		}
	}
	// WebElement txtPolicy;
	public void enterPolicy(String inputVal, WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtPolicy);
			txtPolicy.clear();
			txtPolicy.sendKeys(inputVal);			
			txtPolicy.sendKeys(Keys.TAB);
			Thread.sleep(2000);
			Log.message("Entered policy urn is : " + inputVal, driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while entering the policy urn on add receipt page " + e.getMessage(), driver, extentedReport,
					true);
			throw new Exception("Error while entering the policy urn on add receipt page " + e);
		}
	}
	//WebElement txtContactName;
	public void verifyContactName(String inputVal,ExtentTest extentedReport, WebDriver driver) throws Exception {	
		try {			
			WaitUtils.waitForElement(driver, txtContactName);
			String actualName = txtContactName.getAttribute("value");
			Log.softAssertThat(actualName.equalsIgnoreCase(inputVal), "contact name verified as: " + actualName,
					"contact name verification failed as actual is: " + actualName + "however expected is: " + inputVal, driver, extentedReport, true);			
		} catch (Exception e) {
			Log.fail("Error while verifying the contact name on add receipts " + e.getMessage(), driver, extentedReport, true);
		}
	}
	// WebElement txtChqAmount;
	public void enterChqAmount(String inputVal, WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtChqAmount);
			txtChqAmount.sendKeys(inputVal);
			Log.message("Entered amount value is : " + inputVal, driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while entering amount value on add receipt page " + e.getMessage(), driver, extentedReport,
					true);
			throw new Exception("Error while entering the amount value on add receipt page " + e);
		}
	}
	//txtCashAmount
	public void enterCashAmount(String inputVal, WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtCashAmount);
			txtCashAmount.sendKeys(inputVal);
			Log.message("Entered cash amount value is : " + inputVal, driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while entering cash amount value on add receipt page " + e.getMessage(), driver, extentedReport,
					true);
			throw new Exception("Error while entering the cash amount value on add receipt page " + e);
		}
	}
	// WebElement selMethod;
	public void selMethod(String inputVal, WebDriver driver, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, selMethod, "Unable to select method");
			Select select = new Select(selMethod);
			select.selectByVisibleText(inputVal);
			Log.message("Selected method is : " + inputVal, extentedReport);
		} catch (Exception e) {
			Log.fail("Unable to select method on add receipt page " + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Unable to select on add receipt page " + e);
		}
	}
	// WebElement txtNum;
	public void enterTxtNum(String inputVal, WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtNum);
			txtNum.sendKeys(inputVal);
			Log.message("Entered number is : " + inputVal, driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while entering number value on add receipt page " + e.getMessage(), driver, extentedReport,
					true);
			throw new Exception("Error while entering the number value on add receipt page " + e);
		}
	}
	// WebElement btnPost;
	public void clickBtnPost(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnPost);
			btnPost.click();
			Log.pass("Clicked the button post on add receipt ", driver, extentedReport, true);
			Thread.sleep(2000);
			WaitUtils.uiRefwaitForSpinner(driver);
		} catch (Exception e) {
			Log.fail("Error while clicking the button post on add receipt " + e.getMessage(), driver, extentedReport,
					true);
			throw new Exception("Error while clicking the button post on add receipt  : " + e);
		}
	}
	// WebElement btnCancel;
	public void clickBtnCancel(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnCancel);
			btnCancel.click();
			Log.pass("Clicked the button cancel on add receipt ", driver, extentedReport, true);
			WaitUtils.uiRefwaitForSpinner(driver);
		} catch (Exception e) {
			Log.fail("Error while clicking the button cancel on add receipt " + e.getMessage(), driver, extentedReport,
					true);
			throw new Exception("Error while clicking the button cancel on add receipt  : " + e);
		}
	}
	//txtAccountPeriod
	public void verifyAccountPeriod(String inputVal, ExtentTest extentedReport, WebDriver driver) throws Exception {	
		try {			
			WaitUtils.waitForElement(driver, txtAccountPeriod);
			String actualAcctPeriod = txtAccountPeriod.getAttribute("value");
			Log.softAssertThat(actualAcctPeriod.equalsIgnoreCase(inputVal), "accounting period verified as: " + actualAcctPeriod,
					"accounting period verification failed as actual value is: " + actualAcctPeriod + "however expected is: " + inputVal, driver, extentedReport, true);			
		} catch (Exception e) {
			Log.fail("Error while verifying the accounting period on add receipts " + e.getMessage(), driver, extentedReport, true);
		}
	}
	//txtClaim
	public void enterClaim(String inputVal, WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtClaim);
			txtClaim.clear();
			txtClaim.sendKeys(inputVal);			
			txtClaim.sendKeys(Keys.TAB);
			Thread.sleep(2000);
			Log.message("Entered claim no. is : " + inputVal, driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while entering the claim no. on add receipt page " + e.getMessage(), driver, extentedReport,
					true);
			throw new Exception("Error while entering the claim no. on add receipt page " + e);
		}
	}

}
