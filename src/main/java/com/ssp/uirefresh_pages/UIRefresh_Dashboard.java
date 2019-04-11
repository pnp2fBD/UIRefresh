/**
 * 
 */
package com.ssp.uirefresh_pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.Log;
import com.ssp.support.StopWatch;
import com.ssp.utils.WaitUtils;
import com.ssp.uxp_pages.CustDashboardPage;

import org.openqa.selenium.support.ui.LoadableComponent;

/**
 * @author jheelum.dutta
 *
 */
public class UIRefresh_Dashboard extends LoadableComponent<UIRefresh_Dashboard> {

	private final WebDriver driver;
	private ExtentTest extentedReport;
	private String sspURL;
	private boolean isPageLoaded;
	public String spinner = "div.spinning-on-load-bg-table-active";
	public final String ERROR_MSG_LOGIN = "We do not recognise your details. Please re-enter your credentials";

	@FindBy(css = "#split-main-container > div:nth-child(4) > div > div > div:nth-child(16) > div > div > div.face.front > i")
	// @FindBy(css = "#mCSB_16")
	WebElement btnRI;

	@FindBy(css = "#split-main-container > div:nth-child(4) > div > div > div:nth-child(8) > div > div > div.face.front > i")
	// @FindBy(css = "#mCSB_8_container")
	// #split-main-container i[class*='face_menu_icon contacts center-block']
	WebElement btncontact;

	@FindBy(css = "div[id*='mCSB_'] a[ng-href='#/contacts/ManageContacts']")
	WebElement hrefmanageContact;

	@FindBy(css = "div[id*='mCSB_'] a[ng-href='#/contacts/RemovePersonalData']")
	WebElement removePersonalData;

	// @FindBy(css = "#split-main-container > div:nth-child(4) > div > div >
	// div:nth-child(13) > div > div > div.face.front > i")
	// @FindBy(css = "#mCSB_13")
	@FindBy(css = "#split-main-container i[class*='face_menu_icon policy administration']")
	WebElement btnPolicyAdmin;

	@FindBy(css = "div[id*='mCSB_'] a[ng-href='#/trading/ManagePolicies']")
	WebElement hrefManagePolicies;

	@FindBy(css = "#split-main-container i[class*='face_menu_icon claims center-block']")
	WebElement btnClaims;

	@FindBy(css = "div[id*='mCSB_'] a[ng-href*='#/claims/ManageClaims']")
	WebElement hrefManageClaims;

	@FindBy(css = "a[class='dropdown-toggle loginfo ng-binding']")
	WebElement logout;

	@FindBy(css = "a[id='menu']")
	WebElement openleftMenu;

	@FindBy(css = "a[id='menu'][title='Close']")
	WebElement closeleftMenu;

	@FindBy(css = "a[title='Administration']")
	WebElement menuAdministration;

	@FindBy(css = "a[title='Manage ARN codes']")
	WebElement subMenuManageARN;

	@FindBy(css = "a[title=Receipts]")
	WebElement menuReceipts;

	@FindBy(css = "a[title='Manage Receipts']")
	WebElement subMenuManageReceipts;

	public UIRefresh_Dashboard(WebDriver driver, ExtentTest report) {
		this.driver = driver;
		this.extentedReport = report;
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		isPageLoaded = true;
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		if (!isPageLoaded) {
			Assert.fail();
		}
	}

	public void clickRIActivity(ExtentTest extentedReport) throws Exception {
		try {
			final long startTime = StopWatch.startTime();
			WaitUtils.waitForElement(driver, btnRI);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btnRI);
			// btnSignIn.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked RI activity on dashboard page ", driver, extentedReport);
			Log.event("Clicked RI activity on dashboard page", StopWatch.elapsedTime(startTime));
		} catch (Exception e) {
			Log.fail("Error while clicking RI activity :" + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking RI activity : " + e);
		}
	}

	public void clickOnContact(ExtentTest extentedReport) throws Exception {
		try {
			final long startTime = StopWatch.startTime();
			WaitUtils.waitForelementToBeClickable(driver, btncontact,
					"Unable to click the click contact on UIRefresh Dashboard");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btncontact);

			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Contact on dashboard page ", driver, extentedReport);
			Log.event("Clicked Contact activity on dashboard page", StopWatch.elapsedTime(startTime));

		} catch (Exception e) {
			Log.fail("Error while clicking Contact activity :" + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking Contact activity : " + e);
		}
	}

	public UIRefresh_Manage_contacts clickOnManageContact(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, hrefmanageContact);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", hrefmanageContact);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Manage Contact on dashboard page ", driver, extentedReport);
			return new UIRefresh_Manage_contacts(driver, extentedReport).get();
		} catch (Exception e) {
			Log.fail("Error while clicking Manage Contact activity :" + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking Manage Contact activity : " + e);
		}
	}

	public UIRefresh_Manage_contacts validateContactlink(boolean screenShot, ExtentTest extentedReport)
			throws Exception {
		WaitUtils.waitForSpinner(driver);
		try {
			btncontact.isEnabled();
			Log.message("Contact button is enabled", driver, extentedReport, screenShot);
			return new UIRefresh_Manage_contacts(driver, extentedReport).get();
		} catch (Exception e) {
			Log.fail("Error while validating contact link as contact button is not enabled :" + e.getMessage(), driver,
					extentedReport, true);
			throw new Exception("Contact button is not enabled" + e);
		}
	}

	public UIRefresh_RemovePersonalData clickonRemovePersonalData(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, removePersonalData);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", removePersonalData);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Remove Personal Data link on dashboard page ", driver, extentedReport);
			return new UIRefresh_RemovePersonalData(driver, extentedReport).get();
		} catch (Exception e) {
			Log.fail("Error while clicking Manage Contact activity :" + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking Manage Contact activity : " + e);
		}
	}

	public void logout(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, logout);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", logout);
			WaitUtils.waitForSpinner(driver);
			Log.message("UI Refresh Logout successful", driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while clicking on logout button :" + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking on logout button: " + e);
		}
	}

	public void clickOnPolicyAdmin(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, btnPolicyAdmin,
					"Unable to click the Policy Administartion on UI Refresh Dashboard");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("window.scrollBy(0,250)", "");
			executor.executeScript("arguments[0].click();", btnPolicyAdmin);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked the Policy Administration workflow on UI Refresh dashboard page ", driver,
					extentedReport);
		} catch (Exception e) {
			Log.fail("Error while clicking on policy administration workflow on UI Refresh dashboard homepage :"
					+ e.getMessage(), driver, extentedReport, true);
			throw new Exception(
					"Error while clicking on Policy Administration workflow on UI Refresh dashboard homepage : " + e);
		}
	}

	public UIRef_PolicySearch clickOnManagePolicies(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, hrefManagePolicies);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", hrefManagePolicies);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked the Manage Policies Link on dashboard page ", driver, extentedReport);
			return new UIRef_PolicySearch(driver, extentedReport).get();
		} catch (Exception e) {
			Log.fail("Error while clicking the manage policies link :" + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while clicking the Manage Policies Link : " + e);
		}
	}

	public void clickOpenleftMenu(WebDriver driver, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, openleftMenu, "Unable to open left Menu");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", openleftMenu);
			WaitUtils.uiRefwaitForSpinner(driver);
			Log.message("Opened the left Menu of UI Refresh Dashboard", driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while opening of left Menu bar on UI Refresh Dashboard :" + e.getMessage(), driver,
					extentedReport, true);
			throw new Exception("Error while opening of left Menu on UI Refresh Dashboard : " + e);
		}
	}

	public void clickCloseleftMenu(WebDriver driver, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, closeleftMenu, "Unable to close left Menu");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", closeleftMenu);
			WaitUtils.uiRefwaitForSpinner(driver);
			Log.message("closed the left Menu of UI Refresh Dashboard", driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while closing of left Menu bar on UI Refresh Dashboard :" + e.getMessage(), driver,
					extentedReport, true);
			throw new Exception("Error while closing of left Menu on UI Refresh Dashboard : " + e);
		}
	}

	public void NavtoAdministrationMenu(WebDriver driver, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, menuAdministration,
					"Unable to navigate to menu Administration");
			Actions actions = new Actions(driver);
			actions.moveToElement(menuAdministration).build().perform();
			Log.message("Navigated to Menu - Administration ", driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while navigation to Administration menu :" + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while navigation to Administration menu: " + e);
		}
	}

	public UIRef_ManageARN NavtoManageARN(WebDriver driver, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, subMenuManageARN,
					"Unable to navigate to sub-menu Manage ARN");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", subMenuManageARN);
			WaitUtils.uiRefwaitForSpinner(driver);
			Log.message("Navigation of sub-menu -> Manage ARN ", driver, extentedReport);
			return new UIRef_ManageARN(driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while navigation to Manage ARN sub-menu :" + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while navigation to Manage ARN sub-menu: " + e);
		}
	}

	// Receipts
	// WebElement menuReceipts;
	public void NavtoReceiptsMenu(WebDriver driver, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, menuReceipts, "Unable to navigate to menu Receipts");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("window.scrollBy(0,200)", "");
			Actions actions = new Actions(driver);
			actions.moveToElement(menuReceipts).build().perform();
			Log.message("Navigated to menu - Receipts ", driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while navigate to side menu - Receipts :  " + e.getMessage(), driver, extentedReport, true);
			throw new Exception("Error while navigate to side menu - Receipts" + e);
		}
	}

	// WebElement subMenuManageReceipts;
	public UIRef_ManageReceipts NavtoManageReceipts(WebDriver driver, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, subMenuManageReceipts,
					"Unable to navigate to sub-menu Manage Receipts");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", subMenuManageReceipts);
			WaitUtils.uiRefwaitForSpinner(driver);
			Log.message("Navigated to sub-menu - Manage Receipts ", driver, extentedReport);
			return new UIRef_ManageReceipts(driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while navigate to sub-menu - Manage Receipts " + e.getMessage(), driver, extentedReport,
					true);
			throw new Exception("Error while navigate to sub-menu - Manage Receipts " + e);
		}
	}

	// Claims - btnClaims
	public void clickClaims(WebDriver driver, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForelementToBeClickable(driver, btnClaims,
					"Unable to click the Claims on UI Refresh Dashboard");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click()", btnClaims);
			WaitUtils.uiRefwaitForSpinner(driver);
			Log.message("Clicked the Claims workflow on UI Refresh dashboard page ", driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while clicking on Claims workflow on UI Refresh dashboard page :  " + e.getMessage(),
					driver, extentedReport, true);
			throw new Exception("Error while clicking on Claims workflow on UI Refresh dashboard page : " + e);
		}
	}

	public UIRef_ManageClaims clickManageClaims(WebDriver driver, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, hrefManageClaims);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click()", hrefManageClaims);
			WaitUtils.uiRefwaitForSpinner(driver);
			Log.message("Clicked the Manage Claims Link on dashboard page on UI Refresh dashboard page : ", driver,
					extentedReport);
			return new UIRef_ManageClaims(driver, extentedReport);
		} catch (Exception e) {
			Log.fail("Error while clicking the Manage Claims Link on UI Refresh dashboard page :" + e.getMessage(),
					driver, extentedReport, true);
			throw new Exception("Error while clicking the Manage Claims Link on UI Refresh dashboard page :" + e);
		}
	}

}
