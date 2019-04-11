package com.ssp.uirefresh_pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.Log;
import com.ssp.utils.WaitUtils;

public class UIRef_ClaimInformation extends LoadableComponent<UIRef_ClaimInformation> {
	private static WebDriver driver;
	private ExtentTest extentedReport;
	private boolean isPageLoaded;

	@FindBy(css = "#nameDetails > a")
	WebElement lnkFinancials;
		
	@FindBy(css = "table[id^=DataTables_Table_][dt-options='financialsVM.dtOptions'] tbody tr")
	List <WebElement> tblRowsFinancials;
					
	@FindBy(css = "a[title='Next'][ng-click*='Movements']")
	WebElement btnNextFin;
		
	@FindBy(css = "#generalDetails > a")
	WebElement lnkMovement;
	
	@FindBy(css = "select[name='circumstance']")
	WebElement selCircumstanceMov;
	
	@FindBy(css = "table[id^=DataTables_Table_][dt-options='movementsVM.dtOptions'] tbody tr")
	List<WebElement> tblRowsMovements;
	
	@FindBy(css = "a[title='OK']")
	WebElement btnOKMov;
	
	@FindBy(css = "a[title='Previous']")
	WebElement btnPrevMov;		

	@FindBy(css = "div[ng-class*=MakePayment] p[ng-click*='MakePayment']")
	WebElement lnkMakePayments;
	
	public UIRef_ClaimInformation(WebDriver driver, ExtentTest extentedReport) {
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
	
	//WebElement lnkFinancials;
	public void clickTabFinancials(WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, lnkFinancials);
			lnkFinancials.click();
			Log.message("Clicked the tab Financials ", driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while clicking the tab Financials on claim information page" + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking the tab Financials on claim information page " + e);
		}
	}	
	//List <WebElement> tblRowsFinancials;	
	public Boolean verifyTblRowsFinancials(ExtentTest extentedReport, WebDriver driver) throws Exception {
		Boolean rowExist = false; 
		try {
			WaitUtils.uiRefwaitForSpinner(driver);
		    WaitUtils.waitForListElement(driver, tblRowsFinancials, 40);
			if(tblRowsFinancials.size() > 0 && !tblRowsFinancials.get(0).getText().isEmpty()){
				rowExist = true;
			}			
			Log.softAssertThat(rowExist, "Financials rows already exist : " + tblRowsFinancials.get(0).getText(),
					"Finacials rows does not exist", driver, extentedReport, true);				
		} catch (Exception e) {			
			Log.fail("Error while verifying the financials rows " + e.getMessage(), driver, extentedReport, true);
		}
		return rowExist;						
	}	
	//WebElement btnNextFin;
	public void clickBtnNextFin(WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnNextFin);
			btnNextFin.click();
			Log.message("Clicked the button next on tab Financials ", driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while clicking the button next on tab Financials on claim information page" + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking the button next on tab Financials on claim information page " + e);
		}
	}
	
	//WebElement lnkMovement;
	public void clickTabMovement(WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, lnkMovement);
			lnkMovement.click();
			Log.message("Clicked the tab Movement on claim information page ", driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while clicking the tab Movements on claim information page" + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking the tab Movements on claim information page " + e);
		}
	}
	
	//WebElement selCircumstanceMov;	
	
	//WebElement tblRowsMovements;
	public Boolean verifyTblRowsMovements(ExtentTest extentedReport, WebDriver driver) throws Exception {
		Boolean rowExist = false; 
		try {
			WaitUtils.uiRefwaitForSpinner(driver);
		    WaitUtils.waitForListElement(driver, tblRowsMovements, 40);
			if(tblRowsMovements.size() > 0 && !tblRowsMovements.get(0).getText().isEmpty()){
				rowExist = true;
			}			
			Log.softAssertThat(rowExist, "Movements rows already exist : " + tblRowsMovements.get(0).getText(),
					"Movements rows does not exist", driver, extentedReport, true);				
		} catch (Exception e) {			
			Log.fail("Error while verifying the Movements rows " + e.getMessage(), driver, extentedReport, true);
		}
		return rowExist;						
	}	
	//WebElement btnOKMov;	
	public void clickBtnOKMov(WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnOKMov);
			btnOKMov.click();
			Log.message("Clicked the button OK for tab Movement on claim information page ", driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while clicking button OK for tab Movement on claim information page" + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while button OK for tab Movement on claim information page " + e);
		}
	}	
	//WebElement btnPrevMov;
	public void clickBtnPrevMov(WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnPrevMov);
			btnPrevMov.click();
			Log.message("Clicked the button Previous for tab Movement on claim information page ", driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while clicking button Previous for tab Movement on claim information page" + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while button Previous for tab Movement on claim information page " + e);
		}
	}
	//lnkMakePayments
	public UIRef_ClaimMakePayment clickLinkMakePayments(WebDriver driver, ExtentTest report) throws Exception {
		try {
			WaitUtils.waitForElement(driver, lnkMakePayments);
			lnkMakePayments.click();
			Log.message("Clicked the link make payments on claim information page ", driver, extentedReport);
			return new UIRef_ClaimMakePayment(driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while clicking the link make payments on claim information page" + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking the link make payments on claim information page " + e);
		}
	}
}
