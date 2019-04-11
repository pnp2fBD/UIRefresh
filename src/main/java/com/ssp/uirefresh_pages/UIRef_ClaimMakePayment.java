package com.ssp.uirefresh_pages;

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
import com.ssp.utils.WaitUtils;

public class UIRef_ClaimMakePayment extends LoadableComponent<UIRef_ClaimMakePayment> {
	private static WebDriver driver;
	private ExtentTest extentedReport;
	private boolean isPageLoaded;
	
	@FindBy(css = "#paymentDetails > a")
	WebElement lnkPayDtls;
	
	@FindBy(css = "#paymentBreakdown > a")
	WebElement lnkPayBrkdwn;
	
	@FindBy(css = "#invAmount")
	WebElement txtInvoiceAmt;
		
	@FindBy(css = "select[name=type]")
	WebElement selTypePayDtls;

	@FindBy(css = "a[title=Next]")
	WebElement btnNext;
	
	@FindBy(css = "a[ng-click^='paymentBreakdownVM.createBreakdown']")
	WebElement btnAddBreakdown;
		
	@FindBy(css = "select[name=circumstance]")
	WebElement selCicumstance;
	
	@FindBy(css = "select[name=type]")
	WebElement selTypePayBrkDwn;
	
	@FindBy(css = "select[name=category]")
	WebElement selCategory;
	
	@FindBy(css = "#amount")
	WebElement txtAmount;

	@FindBy(css = "select[name=estimateType]")	
	WebElement selEffectOnEstimate;
	
	@FindBy(css = "a[title=Add]")
	WebElement btnAdd;
					
	@FindBy(css = "#payment_tree_table > tbody > tr")
	WebElement tblPaymtBrkdown;
	
	@FindBy(css = "a[title=Save]")
	WebElement btnSave;		
	
	@FindBy(css = "p[ng-click*='Complete'] span[data-i18n*='complete_label']")
	WebElement lnkComplete;
	
	@FindBy(css = "div[ng-class*=AllocateRecoveries] p[ng-click*='AllocateRecoveries']")
	WebElement lnkAllocateRecoveries;

	public UIRef_ClaimMakePayment(WebDriver driver, ExtentTest extentedReport) {
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
	//WebElement lnkPayDtls;
	public void clickPaymentDetails(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForElement(driver, lnkPayDtls);
			lnkPayDtls.click();
			Log.pass("Clicked the link payment details on claim make payments page", driver, extentedReport,true);
			WaitUtils.uiRefwaitForSpinner(driver);
		} catch (Exception e) {
			Log.fail("Error while clicking the link payment details on claim make payments page " + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking the link payment details on claim make payments page " + e);
		}
	}	
	//WebElement lnkPayBrkdwn;
	public void clickPaymentBreakdown(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForElement(driver, lnkPayBrkdwn);
			lnkPayBrkdwn.click();
			Log.pass("Clicked the link payment breakdown on claim make payments page", driver, extentedReport,true);
			WaitUtils.uiRefwaitForSpinner(driver);
		} catch (Exception e) {
			Log.fail("Error while clicking the link payment breakdown on claim make payments page " + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking the link payment breakdown on claim make payments page " + e);
		}
	}	
	//WebElement txtInvoiceAmt;
	public void enterInvoiceAmt(String endorseReasonVal,WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtInvoiceAmt);
			txtInvoiceAmt.sendKeys(endorseReasonVal);
			Log.message("Entered payment details invoice amount is : " + endorseReasonVal, driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while the entering the payment details invoice amount  " + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while entering the payment details invoice amount " + e);
		}
	}		
	
	// WebElement selTypePayDtls;
	public void selectTypePayDtls(String inputVal, WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, selTypePayDtls);
			Select select = new Select(selTypePayDtls);
			select.selectByVisibleText(inputVal);
			Log.message("selected payment details type is : " + inputVal, driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while selection of payment detail type on create claim page " + e.getMessage(), driver,
					extentedReport, true);
			throw new Exception("Error while the selection of payment detail type on create claim page " + e);
		}
	}

	//WebElement btnNext;
	public void clickBtnNext(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnNext);
			btnNext.click();
			Log.pass("Clicked the button next on claim make payment page ", driver, extentedReport,true);
			WaitUtils.uiRefwaitForSpinner(driver);
		} catch (Exception e) {
			Log.fail("Error while clicking button next on claim make payment page " + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking button next on claim make payment page " + e);
		}
	}	
	
	//WebElement btnAddBreakdown;
	public void clickBtnAddBreakdown(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnAddBreakdown);
			btnAddBreakdown.click();
			Log.pass("Clicked the button add breakdown on claim make payment page ", driver, extentedReport,true);
		} catch (Exception e) {
			Log.fail("Error while clicking button add breakdown on claim make payment page " + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking button add breakdown on claim make payment page " + e);
		}
	}
	
	
	//WebElement selCicumstance;
	public void selectCicumstance(String inputVal, WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, selCicumstance);
			Select select = new Select(selCicumstance);
			select.selectByVisibleText(inputVal);
			Log.message("selected payment breakdown circumstance is : " + inputVal, driver, extentedReport);			
		} catch (Exception e) {
			Log.fail("Error while the selection of payment breakdown circumstance  " + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while the selection of payment breakdown circumstance " + e);
		}
	}	
	//WebElement selTypePayBrkDwn;
	public void selTypePayBrkDwn(String inputVal, WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, selTypePayBrkDwn);
			Select select = new Select(selTypePayBrkDwn);
			select.selectByVisibleText(inputVal);
			Log.message("selected payment breakdown type is : " + inputVal, driver, extentedReport);			
		} catch (Exception e) {
			Log.fail("Error while the selection of payment breakdown type  " + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while the selection of payment breakdown type " + e);
		}
	}		
	//WebElement selCategory;
	public void selCategory(String inputVal, WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, selCategory);
			Select select = new Select(selCategory);
			select.selectByVisibleText(inputVal);
			Log.message("selected payment breakdown category is : " + inputVal, driver, extentedReport);			
		} catch (Exception e) {
			Log.fail("Error while the selection of payment breakdown category  " + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while the selection of payment breakdown category " + e);
		}
	}	
	//WebElement txtAmount;
	public void enterAmtPayDtls(String endorseReasonVal,WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtAmount);
			txtAmount.clear();
			txtAmount.sendKeys(endorseReasonVal);
			Log.message("Entered payment breakdown amount is : " + endorseReasonVal, driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while the entering the payment breakdown amount  " + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while entering the payment breakdown amount " + e);
		}
	}
		
	//WebElement selEffectOnEstimate;
	public void selEffectOnEstimate(String inputVal, WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, selEffectOnEstimate);
			Select select = new Select(selEffectOnEstimate);
			select.selectByVisibleText(inputVal);
			Log.message("selected payment breakdown effect on estimate is : " + inputVal, driver, extentedReport);			
		} catch (Exception e) {
			Log.fail("Error while the selection of payment breakdown effect on estimate is  " + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while the selection of payment breakdown effect on estimate " + e);
		}
	}	
	
	
	//WebElement btnAdd;
	public void clickBtnAdd(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnAdd);
			btnAdd.click();
			Log.pass("Clicked the button add on claim make payment page ", driver, extentedReport,true);
			WaitUtils.uiRefwaitForSpinner(driver);
		} catch (Exception e) {
			Log.fail("Error while clicking button add on claim make payment page " + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking button add on claim make payment page " + e);
		}
	}	
	//WebElement tblPaymtBrkdown;
	
	
	//WebElement btnSave;
	public void clickBtnSave(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnSave);
			btnSave.click();
			Log.pass("Clicked the button save on claim make payment page ", driver, extentedReport,true);
			WaitUtils.uiRefwaitForSpinner(driver);
		} catch (Exception e) {
			Log.fail("Error while clicking button save on claim make payment page " + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking button save on claim make payment page " + e);
		}
	}
	
	public UIRef_ClaimComplete clicklnkComplete(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForElement(driver, lnkComplete);
			lnkComplete.click();
			Log.pass("Clicked the link claim Complete ", driver, extentedReport,true);
			WaitUtils.uiRefwaitForSpinner(driver);
			return new UIRef_ClaimComplete(driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while clicking the link claim complete " + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking the link claim complete " + e);
		}
	}
//	/lnkAllocateRecoveries
	public UIRef_ClaimAllocateRecovery clickLnkAllocateRecoveries(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForElement(driver, lnkAllocateRecoveries);
			lnkAllocateRecoveries.click();
			Log.pass("Clicked the Link claim Allocate Recoveries ", driver, extentedReport,true);
			WaitUtils.uiRefwaitForSpinner(driver);
			return new UIRef_ClaimAllocateRecovery(driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while clicking the link claim Allocate Recoveries " + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking the link claim Allocate Recoveries " + e);
		}
	}
	

}
