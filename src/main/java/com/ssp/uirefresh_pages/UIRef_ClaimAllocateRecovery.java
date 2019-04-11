package com.ssp.uirefresh_pages;

import java.util.List;

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

public class UIRef_ClaimAllocateRecovery extends LoadableComponent<UIRef_ClaimAllocateRecovery> {
	private static WebDriver driver;
	private ExtentTest extentedReport;
	private boolean isPageLoaded;

	@FindBy(css = "table[id^=DataTables_Table_][dt-options=dtOptions] tbody tr:nth-child(1) td a[title='Allocate Recovery']")
	WebElement tblRowUnreconciledReceipt1;

	@FindBy(css = "a[title='Create']")
	WebElement btnCreate;

	@FindBy(css = "select[name=circumstance]")
	WebElement selCircumstance;

	@FindBy(css = "select[name=category]")
	WebElement selCategory;

	@FindBy(css = "#amount")
	WebElement txtAmount;

	@FindBy(css = "a[title=Save]")
	WebElement btnSave;

	@FindBy(css = "table[tt-params=allocateTableValues] tbody tr:nth-child(1) td:nth-child(1) a")
	WebElement tblExpandRow;

	@FindBy(css = "table[tt-params=allocateTableValues] tbody tr:nth-child(2) td:nth-child(9)")
	WebElement tblRow1;

	@FindBy(css = "div[role=alert] h5[id]")
	List<WebElement> txtErrMsgs;

	@FindBy(css = "a[title=Cancel]")
	WebElement btnCancel;

	@FindBy(css = "p[ng-click*='Complete'] span[data-i18n*='complete_label']")
	WebElement lnkComplete;

	public UIRef_ClaimAllocateRecovery(WebDriver driver, ExtentTest extentedReport) {
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

	// WebElement tblRowUnreconciledReceipt1;
	public void clickLinkforUnreconcilRcpt1(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForElement(driver, tblRowUnreconciledReceipt1);
			tblRowUnreconciledReceipt1.click();
			Log.pass("Clicked the link of unreconciled receipt in table row1 on claim allocate recovery ", driver,
					extentedReport, true);
			WaitUtils.uiRefwaitForSpinner(driver);
		} catch (Exception e) {
			Log.fail("Error while clicking link of unreconciled receipt in table row1 on claim allocate recovery : "
					+ e.getMessage(), driver, extentedReport, true);
			throw new Exception(
					"Error while clicking link of unreconciled receipt in table row1 on claim allocate recovery " + e);
		}
	}

	// WebElement btnCreate;
	public void clickBtnCreate(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnCreate);
			btnCreate.click();
			Log.pass("Clicked the button create on claim allocate recovery ", driver, extentedReport, true);
			WaitUtils.uiRefwaitForSpinner(driver);
		} catch (Exception e) {
			Log.fail("Error while clicking button create on claim allocate recovery : " + e.getMessage(), driver,
					extentedReport, true);
			throw new Exception("Error while clicking button create on claim allocate recovery " + e);
		}
	}

	// WebElement selCircumstance;
	public void selCicumstance(String inputVal, WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, selCircumstance);
			Select select = new Select(selCircumstance);
			select.selectByVisibleText(inputVal);
			Log.message("selected circumstance is : " + inputVal, driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while the selection of circumstance on claim allocate recovery" + e.getMessage(), driver,
					extentedReport, true);
			throw new Exception("Error while the selection of of circumstance on claim allocate recovery " + e);
		}
	}

	// WebElement selCategory;
	public void selCategory(String inputVal, WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, selCategory);
			Select select = new Select(selCategory);
			select.selectByVisibleText(inputVal);
			Log.message("selected category is : " + inputVal, driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while the selection of category on claim allocate recovery" + e.getMessage(), driver,
					extentedReport, true);
			throw new Exception("Error while the selection of of category on claim allocate recovery " + e);
		}
	}

	// WebElement txtAmount;
	public void enterAmount(String endorseReasonVal, WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtAmount);
			txtAmount.clear();
			txtAmount.sendKeys(endorseReasonVal);
			Log.message("Entered payment amount on claim allocate recovery : " + endorseReasonVal, driver,
					extentedReport);
		} catch (Exception e) {
			Log.fail("Error while the entering the amount on claim allocate recovery " + e.getMessage(), driver,
					extentedReport, true);
			throw new Exception("Error while entering the amount on claim allocate recovery" + e);
		}
	}

	// WebElement btnSave;
	public void clickBtnSave(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnSave);
			btnSave.click();
			Log.pass("Clicked the button save on claim allocate recovery ", driver, extentedReport, true);
			WaitUtils.uiRefwaitForSpinner(driver);
		} catch (Exception e) {
			Log.fail("Error while clicking button save on claim allocate recovery : " + e.getMessage(), driver,
					extentedReport, true);
			throw new Exception("Error while clicking button save on claim allocate recovery " + e);
		}
	}

	// WebElement tblExpandRow;
	public void clickLinkTblExpandRow(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForElement(driver, tblExpandRow);
			tblExpandRow.click();
			Log.pass("Clicked the link ExpandRow in table row1 on claim allocate recovery ", driver, extentedReport,
					true);
			WaitUtils.uiRefwaitForSpinner(driver);
		} catch (Exception e) {
			Log.fail("Error while clicking link tblExpandRow in table row1 on claim allocate recovery : "
					+ e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking link ExpandRow in table row1 on claim allocate recovery " + e);
		}
	}

	// WebElement tblRow1;
	public Boolean verifyTblRowAllocRecovery(ExtentTest extentedReport, WebDriver driver) throws Exception {
		Boolean rowExist = false;
		try {
			WaitUtils.uiRefwaitForSpinner(driver);
			WaitUtils.waitForElement(driver, tblRow1);
			if (tblRow1.getText().isEmpty()) {
				rowExist = true;
			}
			Log.softAssertThat(rowExist, "Allocate Recovery row added : " + tblRow1.getText(),
					"Allocate Recovery row does not exist", driver, extentedReport, true);
		} catch (Exception e) {
			Log.fail("Error while verifying the Allocate Recovery row " + e.getMessage(), driver, extentedReport, true);
		}
		return rowExist;
	}

	// List<WebElement> txtErrMsgs;
	public Boolean verifyErrMsgs(ExtentTest extentedReport, WebDriver driver) throws Exception {
		Boolean rowExist = false;
		try {
			WaitUtils.uiRefwaitForSpinner(driver);
			WaitUtils.waitForListElement(driver, txtErrMsgs, 40);
			for (int i = 0; i < txtErrMsgs.size(); i++) {
				if (txtErrMsgs.get(i).getText().isEmpty())
					rowExist = true;
			}
			Log.softAssertThat(rowExist,
					"Allocate recovery page has started working update the script " + txtErrMsgs.get(0).getText(),
					"Allocate recovery page is throwing error message on save of receipt - Known Bug 29082" + txtErrMsgs.get(0).getText(), driver,
					extentedReport, true);

		} catch (Exception e) {
			Log.fail("Error while verifying the allocate recovery page error message " + e.getMessage(), driver,
					extentedReport, true);
		}
		return rowExist;
	}

	// btnCancel
	public void clickBtnCancel(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnCancel);
			btnCancel.click();
			Log.pass("Clicked the button cancel on claim allocate recovery ", driver, extentedReport, true);
			WaitUtils.uiRefwaitForSpinner(driver);
		} catch (Exception e) {
			Log.fail("Error while clicking button cancel on claim allocate recovery : " + e.getMessage(), driver,
					extentedReport, true);
			throw new Exception("Error while clicking button cancel on claim allocate recovery " + e);
		}
	}

	// lnkComplete
	public UIRef_ClaimComplete clicklnkComplete(ExtentTest extentedReport, WebDriver driver) throws Exception {
		try {
			WaitUtils.waitForElement(driver, lnkComplete);
			lnkComplete.click();
			Log.pass("Clicked the link claim Complete ", driver, extentedReport, true);
			WaitUtils.uiRefwaitForSpinner(driver);
			return new UIRef_ClaimComplete(driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while clicking the link claim complete " + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking the link claim complete " + e);
		}
	}
}
