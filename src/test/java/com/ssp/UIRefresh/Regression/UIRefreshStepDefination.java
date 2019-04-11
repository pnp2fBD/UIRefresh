package com.ssp.UIRefresh.Regression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.UIRefresh.GDPR_RTE_feature.gdprRTErunner;
import com.ssp.support.BaseCucumberTest;
import com.ssp.support.CucumberLog;
import com.ssp.support.Log;
import com.ssp.support.WebDriverFactory;
import com.ssp.uirefresh_pages.UIRef_AddReceipt;
import com.ssp.uirefresh_pages.UIRef_AddresSearchDialog;
import com.ssp.uirefresh_pages.UIRef_ClaimAllocateRecovery;
import com.ssp.uirefresh_pages.UIRef_ClaimApplyEstimates;
import com.ssp.uirefresh_pages.UIRef_ClaimCircumstance;
import com.ssp.uirefresh_pages.UIRef_ClaimComplete;
import com.ssp.uirefresh_pages.UIRef_ClaimInformation;
import com.ssp.uirefresh_pages.UIRef_ClaimMakePayment;
import com.ssp.uirefresh_pages.UIRef_ContactBanking;
//import com.ssp.uirefresh_pages.Date;
import com.ssp.uirefresh_pages.UIRef_ContactSearchDialog;
import com.ssp.uirefresh_pages.UIRef_CreateARNCode;
import com.ssp.uirefresh_pages.UIRef_CreateClaim;
import com.ssp.uirefresh_pages.UIRef_ManageARN;
import com.ssp.uirefresh_pages.UIRef_ManageClaims;
import com.ssp.uirefresh_pages.UIRef_ManageReceipts;
import com.ssp.uirefresh_pages.UIRef_PolicyAdjustBilling;
import com.ssp.uirefresh_pages.UIRef_PolicyBuisnessDetails;
import com.ssp.uirefresh_pages.UIRef_PolicyCancelDialog;
import com.ssp.uirefresh_pages.UIRef_PolicyComplete;
import com.ssp.uirefresh_pages.UIRef_PolicyCoreCovers;
import com.ssp.uirefresh_pages.UIRef_PolicyDocumentationDialog;
import com.ssp.uirefresh_pages.UIRef_PolicyEndorseDialog;
import com.ssp.uirefresh_pages.UIRef_PolicyTree;
import com.ssp.uirefresh_pages.UIRef_PropertyDetails;
import com.ssp.uirefresh_pages.UIRef_policyClaimsPriorInception;
import com.ssp.uirefresh_pages.UIRef_PolicyHeader;
import com.ssp.uirefresh_pages.UIRef_PolicyLapseDialog;
import com.ssp.uirefresh_pages.UIRef_PolicyManageBilling;
import com.ssp.uirefresh_pages.UIRef_PolicyReinstate;
import com.ssp.uirefresh_pages.UIRef_PolicyRenewal;
import com.ssp.uirefresh_pages.UIRef_PolicyReverseTransaction;
import com.ssp.uirefresh_pages.UIRef_PolicyReviewPremium;
import com.ssp.uirefresh_pages.UIRef_PolicyReviewReferrals;
import com.ssp.uirefresh_pages.UIRef_PolicySTAdialog;
import com.ssp.uirefresh_pages.UIRefresh_Dashboard;
import com.ssp.uirefresh_pages.UIRefresh_Login;
import com.ssp.uirefresh_pages.UIRefresh_Manage_contacts;
import com.ssp.uirefresh_pages.UIRef_PolicySearch;
import com.ssp.uirefresh_pages.UIRefresh_RemovePersonalData;
import com.ssp.uirefresh_pages.UIRefresh_ViewPersonalContact;
import com.ssp.uirefresh_pages.UIRefrsh_EditPersonalContact;
import com.ssp.utils.GenericUtils;
import com.ssp.utils.WaitUtils;
import com.ssp.uxp_pages.CustDashboardPage;
import com.ssp.uxp_pages.HomePage;
import com.ssp.uxp_pages.LoginPage;
import com.ssp.uxp_pages.SearchPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UIRefreshStepDefination {

	private static final String TransVal = null;
	private static WebDriver driver;
	HashMap<String, String> testData;
	String browser;
	static ExtentTest extentedReport;
	HomePage homePage;
	CustDashboardPage custdashboardpage;

	private String userLastName = null;
	private String userFirstName = null;
	private String contactURN = null;
	private String policyURN = null;
	private String claimURN = null;
	private String ARNcodeVal = null;
	private String contactName = null;
	HashMap<String, String> custDetails;

	UIRefresh_Login login;
	UIRefresh_Dashboard dashboard;
	UIRefresh_Manage_contacts manageContacts;
	UIRefresh_RemovePersonalData removePeronalData;
	UIRefrsh_EditPersonalContact EditPersonalContact;
	UIRefresh_ViewPersonalContact viewPersonalContact;

	UIRef_PolicySearch policySearch;
	UIRef_PolicyBuisnessDetails policyBuisnessDetails;
	UIRef_PolicyTree policyTree;
	UIRef_PolicyHeader policyHeader;
	UIRef_PropertyDetails propertyDetails;
	UIRef_PolicyCoreCovers policyCoreCovers;
	UIRef_PolicyReviewPremium policyReviewPremium;
	UIRef_PolicyManageBilling policyManageBilling;
	UIRef_PolicyComplete policyComplete;
	UIRef_PolicyDocumentationDialog policyDocumentation;
	UIRef_PolicyCancelDialog policyCancelDialog;
	UIRef_PolicyRenewal policyRenewal;
	UIRef_PolicyEndorseDialog policyEndorse;
	UIRef_PolicySTAdialog policySTA;
	UIRef_PolicyAdjustBilling policyAdjustBilling;
	UIRef_PolicyLapseDialog policyLapse;
	UIRef_ContactSearchDialog contactSearchDialog;
	UIRef_PolicyReinstate policyReinstate;
	UIRef_PolicyReverseTransaction policyReverseTrans;
	UIRef_policyClaimsPriorInception policyPriorClaim;
	UIRef_PolicyReviewReferrals policyReviewReferrals;
	UIRef_ManageARN manageARN;
	UIRef_CreateARNCode createARN;
	UIRef_AddresSearchDialog addressSearchDialog;
	UIRef_ContactBanking contactBanking;
	UIRef_ManageClaims manageClaims;
	UIRef_CreateClaim createClaim;
	UIRef_ClaimComplete claimComplete;
	UIRef_ClaimCircumstance claimCircumstance;
	UIRef_ClaimApplyEstimates claimApplyEstimates;
	UIRef_ManageReceipts manageReceipts;
	UIRef_AddReceipt addReceipts;
	UIRef_ClaimInformation claimInformation;
	UIRef_ClaimMakePayment claimMakePayment;
	UIRef_ClaimAllocateRecovery claimAllocateRecovery;

	public static ExtentTest getExtentedReport() {
		return extentedReport;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	@Given("^Fetch the UIRef data of \"([^\"]*)\"$")
	public void fetch_the_UIRef_data_of(String arg1) throws Throwable {
		try {
			browser = UIRefreshRunner.browser;
			String className = "uiref_";
			testData = BaseCucumberTest.getTestData(className, arg1);
			String description = testData.get("Description");
			Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
			extentedReport = BaseCucumberTest.addTestInfo(arg1, description);
			Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
		} catch (Exception e) {
			CucumberLog.endTestCase(extentedReport);
		}
	}

	@Given("^Login to EC and Create a new User$")
	public void login_to_EC_and_Create_a_new_User() throws Throwable {
		try {
			String userName = testData.get("UserName");
			String password = testData.get("Password");
			String brandname = testData.get("Brand Name");
			String website = UIRefreshRunner.website_EC;
			driver = WebDriverFactory.get(browser);
			LoginPage loginPage = new LoginPage(driver, website, extentedReport).get();
			Log.pass("Engagement Centre Landing Page : " + website, driver, extentedReport, true);
			homePage = loginPage.loginToSSP(userName, password, false, extentedReport);
			Log.softAssertThat(homePage.verifyHomePage(), "Successfully logged into UXP Home Page", "Login failed",
					driver, extentedReport, true);
			Log.message("Logged in User id:" + userName + "& Password:" + password, driver, extentedReport);
			homePage.clickTakeCall(extentedReport);
			homePage.clickMyBrands(brandname, extentedReport);
			SearchPage searchPage = new SearchPage(driver, extentedReport).get();
			Log.softAssertThat(searchPage.uielement.verifyPageElements(Arrays.asList("txtPolicyNumber"), searchPage),
					"Search page is verified", "Search Page is not verified", driver, extentedReport, true);

			// Enter Customer Details
			Log.softAssertThat(searchPage.uielement.verifyPageElements(Arrays.asList("txtPolicyNumber"), searchPage),
					"Search page is verified", "Search Page is not verified", driver, extentedReport, true);
			searchPage.clickCreateCustomer(true, extentedReport);
			custDetails = searchPage.enterCustomerDetails(testData, true, extentedReport);

			// Confirm customer details and create customer
			custdashboardpage = searchPage.confirmCreateCustomer(true, extentedReport);
			Log.softAssertThat(
					custdashboardpage.verifyContactName(testData.get("Title") + " " + custDetails.get("First Name")
							+ " " + custDetails.get("Last Name"), extentedReport, true),
					"Verified FirstName and LastName on Customer Dashboard page",
					"Not Verified Customer Name on Dashboard page", driver, extentedReport, true);
			userFirstName = custDetails.get("First Name");
			userLastName = custDetails.get("Last Name");
			custdashboardpage.clickComplete(extentedReport);
			homePage.doLogout(extentedReport);
			driver.quit();
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
			CucumberLog.endTestCase(extentedReport);
			driver.quit();
		}
	}

	@Given("^Login in UI Refresh$")
	public void login_in_UI_Refresh() throws Throwable {
		try {
			String website_UIRefresh = UIRefreshRunner.website_UIRefresh;
			String userName = testData.get("UserName");
			String password = testData.get("Password");
			driver = WebDriverFactory.get(browser);
			login = new UIRefresh_Login(driver, website_UIRefresh, extentedReport).get();
			Log.pass("UI Refresh Login Page : " + website_UIRefresh, driver, extentedReport, true);
			dashboard = login.loginToUIRefresh(userName, password, false, extentedReport);
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
			CucumberLog.endTestCase(extentedReport);
			driver.quit();
		}
	}

	@When("^Search the existing contact$")
	public void search_the_existing_contact() throws Throwable {
		// Get Contact URN from Last Name in variable contactURN
		dashboard.clickOnContact(extentedReport);
		manageContacts = dashboard.clickOnManageContact(extentedReport);
		manageContacts.enterName(userLastName);
		manageContacts.clickBtnSearch(extentedReport, driver);
		EditPersonalContact = manageContacts.clickBtnEdit(extentedReport, driver);
		contactURN = EditPersonalContact.getContactURN(extentedReport, driver);
		EditPersonalContact.clickBtnCompletetab(extentedReport, driver);
		manageContacts.clickBtnComplete(extentedReport, driver);
		// contactURN = "9";
		// now search the contact on Policy Search Screen with contactURN
		dashboard.clickOnPolicyAdmin(extentedReport);
		policySearch = dashboard.clickOnManagePolicies(extentedReport);
		policySearch.enterContactURN(contactURN, driver, extentedReport);
		policySearch.verifyContactName(userLastName, driver, extentedReport);
		policySearch.clickBtnSearch(extentedReport, driver);
	}

	@Then("^Create NB in UI Refresh$")
	public void create_NB_in_UI_Refresh() throws Throwable {

		policyBuisnessDetails = policySearch.clickcreatePolicyLnk(driver, extentedReport);
		String intermediaryID = testData.get("Intermediary");
		String agencyAgreement = testData.get("agencyAgreement");
		String productvalue = testData.get("Product");
		String schmevalue = testData.get("Scheme");
		policyBuisnessDetails.enterIntermediary(intermediaryID, driver, extentedReport);
		policyBuisnessDetails.enterAgencyAgreement(agencyAgreement, driver, extentedReport);
		policyBuisnessDetails.enterInceptionDate(driver, extentedReport);

		policyBuisnessDetails.enterProduct(productvalue, driver, extentedReport);
		policyBuisnessDetails.enterSchme(schmevalue, driver, extentedReport);
		// policyBuisnessDetails.enterAgencyAgreement(agencyAgreement,driver,extentedReport);
		policyBuisnessDetails.getPolicyURN(extentedReport, driver);
		policyTree = policyBuisnessDetails.clickOKbuisnessdetails(driver, extentedReport);
		// Operations on PolicyHeader
		policyHeader = policyTree.clickAddPolicyExtension(extentedReport, driver);
		String coverTypeVal = testData.get("Cover");
		String schemeVariantVal = testData.get("schemeVariant");
		String buildingsContinuousInsuranceVal = testData.get("BuildingInsurance");
		String contentsContinuousInsuranceVal = testData.get("ContentInsurance");
		// Operations on PolicyHeader
		policyHeader.enterCoverType(coverTypeVal, driver, extentedReport);
		policyHeader.enterschemeVariant(schemeVariantVal, driver, extentedReport);
		policyHeader.enterBuildingsInsurance(buildingsContinuousInsuranceVal, driver, extentedReport);
		policyHeader.enterContentsInsurance(contentsContinuousInsuranceVal, driver, extentedReport);
		policyHeader.ClickBtnPolicyHeader(driver, extentedReport);

		// Add Property
		String postcode = testData.get("Post Code");
		propertyDetails = policyTree.clickAddProperty(extentedReport, driver);
		propertyDetails.addressFormat("Lookup", driver, extentedReport);
		propertyDetails.selectAddressFromPostcode(postcode, driver, extentedReport);
		// Add Property Details
		String propertyTypeVal = testData.get("Property Type");
		String yearBuildVal = testData.get("YOB");
		String numberOfBedroomsVal = testData.get("No of Bedrooms");
		String constructWallVal = testData.get("ConstructWall");
		String constructRoofVal = testData.get("ConstructRoof");
		String ownershipTypeVal = testData.get("ownershipType");
		String occupiedDuringDayVal = testData.get("occupiedDuringDay");
		String soleOccupancyVal = testData.get("soleOccupancy");
		String occupiedDuringNightVal = testData.get("occupiedDuringNight");
		propertyDetails.propertyType(propertyTypeVal, driver, extentedReport);
		propertyDetails.yearBuild(yearBuildVal, driver, extentedReport);
		propertyDetails.numberOfBedrooms(numberOfBedroomsVal, driver, extentedReport);
		propertyDetails.constructWall(constructWallVal, driver, extentedReport);
		propertyDetails.constructRoof(constructRoofVal, driver, extentedReport);
		propertyDetails.ClicknextBtn(driver, extentedReport);
		propertyDetails.ownershipType(ownershipTypeVal, driver, extentedReport);
		propertyDetails.occupiedDuringDay(occupiedDuringDayVal, driver, extentedReport);
		propertyDetails.soleOccupancy(soleOccupancyVal, driver, extentedReport);
		propertyDetails.occupiedDuringNight(occupiedDuringNightVal, driver, extentedReport);
		propertyDetails.ClickSaveBtn(driver, extentedReport);

		// Add Core Covers
		String BuildingCover = testData.get("BuildingCover");
		String ContentCover = testData.get("ContentCover");
		String ADCover = testData.get("ADCover");
		String ExcessCover = testData.get("ExcessCover");
		policyCoreCovers = policyTree.clickAddCoreCovers(extentedReport, driver);

		policyCoreCovers.SelectBuildingNContentCovers(BuildingCover, ContentCover, driver, extentedReport);
		policyCoreCovers.SelectADCovers(ADCover, driver, extentedReport);
		policyCoreCovers.SelectExcessCovers(ExcessCover, driver, extentedReport);
		policyCoreCovers.ClickSaveBtnCoreCovers(driver, extentedReport);

		policyTree.ValidateCoreCoverRow(driver, extentedReport);
		// policyTree.ClickReviewPremium(driver, extentedReport);

		// Navigate to Review Premium
		policyReviewPremium = policyTree.ClickReviewPremium(driver, extentedReport);
		String TotalAmtPayableVal = testData.get("Premium TotalAmtPayable");
		policyReviewPremium.ValidateTotalAmtPayableNB(TotalAmtPayableVal, driver, extentedReport);

		// Navigate to Manage Billing
		policyManageBilling = policyTree.ClickManageBilling(driver, extentedReport);

		String paymentPlanVal = testData.get("Payment Plan");
		String paymentMethodVal = testData.get("Payment Method");

		// policyManageBilling.paymentPlan(paymentPlanVal, driver,
		// extentedReport);
		// policyManageBilling.paymentMethod(paymentMethodVal, driver,
		// extentedReport);
		if (paymentPlanVal.equalsIgnoreCase("Annual")) {
			policyManageBilling.SelectAnnualCard(paymentPlanVal, paymentMethodVal, driver, extentedReport);
		} else if (paymentPlanVal.equalsIgnoreCase("Monthly")) {
			policyManageBilling.SelectMonthlyDirectDebit(paymentPlanVal, paymentMethodVal, driver, extentedReport);
		}
		policyComplete = policyManageBilling.ClickOKbtnManageBilling(driver, extentedReport);

		// Navigate to Policy Complete
		policyComplete.ClickAccepted(driver, extentedReport);
		policyDocumentation = policyComplete.ClickOK(driver, extentedReport);
		policyDocumentation.ClickDocumentNBCancel0(driver, extentedReport);

		policyURN = policySearch.getpolicyNum(driver, extentedReport);
		policySearch.ValidateRow1data(driver, extentedReport);
	}

	@Then("^User should logout successfully from UI Refresh$")
	public void user_should_logout_successfully_from_UI_Refersh() throws Throwable {
		try {
			dashboard.logout(extentedReport);
			Log.message("Logged out from UI refresh");
			driver.quit();

		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
			CucumberLog.endTestCase(extentedReport);
			driver.quit();
		}
	}

	@When("^Search the existing contact Jason Smith$")
	public void search_the_existing_contact_Jason_Smith() throws Throwable {
		// Get Contact URN from Last Name in variable contactURN

		// contactURN = "9";
		// now search the contact on Policy Search Screen with contactURN
		dashboard.clickOnPolicyAdmin(extentedReport);
		policySearch = dashboard.clickOnManagePolicies(extentedReport);
		policySearch.clickcontactSearchIcon(extentedReport, driver);
		String contactNameVal = testData.get("Last Name") + " " + testData.get("First Name");
		policySearch.enterContactName(contactNameVal, extentedReport, driver);
		policySearch.clickModalSearchbtn(extentedReport, driver);
		policySearch.clickmodalRetreiveRow1(extentedReport, driver);

	}

	@Then("^Cancel the Policy with Cooling Off$")
	public void cancel_the_Policy_with_Cooling_Off() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		// stub to call cancel start
		// policyURN = "239";
		// dashboard.clickOnPolicyAdmin(extentedReport);
		// policySearch = dashboard.clickOnManagePolicies(extentedReport);
		// Stub to call cancel end

		policySearch.enterpolicyNum(policyURN, driver, extentedReport);
		policySearch.clickBtnSearch(extentedReport, driver);
		policyCancelDialog = policySearch.clickCancelCoolingOff(extentedReport, driver);
		String reasonVal = testData.get("Cancellation type");
		String actionVal = testData.get("Cancellation action");
		// policyCancelDialog.verifyCancelDialogLable(driver, extentedReport);
		policyCancelDialog.selectReasonType(reasonVal, driver, extentedReport);
		policyCancelDialog.selectAction(actionVal, driver, extentedReport);
		policyReviewPremium = policyCancelDialog.clickCancelDialogOK(extentedReport, driver);
		// Validate and Accept Cancellation
		String positionTypeVal = testData.get("Cancellation");
		policyReviewPremium.ValidatePolicyPosition(positionTypeVal, driver, extentedReport);
		String TotalAmtPayableVal = testData.get("Premium TotalAmtPayable");
		policyReviewPremium.ValidateTotalAmtPayableCNL(TotalAmtPayableVal, driver, extentedReport);

		// Navigate to Policy Complete
		policyComplete = policyReviewPremium.NavigateToComplete(driver, extentedReport);

		policyComplete.ClickCancelAccepted(driver, extentedReport);
		policyDocumentation = policyComplete.ClickOK(driver, extentedReport);

		policyDocumentation.ClickDocumentCloseCncl(driver, extentedReport);

		policySearch.ValidateRow1data(driver, extentedReport);
		// policySearch.ValidatePolicyPosition("CNL", driver, extentedReport);

	}

	@Then("^Cancel the Policy$")
	public void cancel_the_Policy() throws Throwable {
		// stub to call cancel start
		/*
		 * policyURN = "177"; dashboard.clickOnPolicyAdmin(extentedReport);
		 * policySearch = dashboard.clickOnManagePolicies(extentedReport);
		 */
		// Stub to call cancel end

		policySearch.enterpolicyNum(policyURN, driver, extentedReport);
		policySearch.clickBtnSearch(extentedReport, driver);
		policyCancelDialog = policySearch.clickCancel(extentedReport, driver);
		String reasonVal = testData.get("Cancellation type");
		String actionVal = testData.get("Cancellation action");
		String returnPremiumTypeVal = testData.get("Return Premium type");
		// policyCancelDialog.verifyCancelDialogLable(driver, extentedReport);
		policyCancelDialog.enterCancelEffectiveDate("future", "15", "0", driver, extentedReport);
		policyCancelDialog.selectreturnPremiumType(returnPremiumTypeVal, driver, extentedReport);
		policyCancelDialog.selectReasonType(reasonVal, driver, extentedReport);
		policyCancelDialog.selectAction(actionVal, driver, extentedReport);
		policyReviewPremium = policyCancelDialog.clickCancelDialogOK(extentedReport, driver);
		// Validate and Accept Cancellation
		String positionTypeVal = testData.get("Cancellation");
		policyReviewPremium.ValidatePolicyPosition(positionTypeVal, driver, extentedReport);
		String TotalAmtPayableVal = testData.get("Premium TotalAmtPayable");
		policyReviewPremium.ValidateTotalAmtPayableCNL(TotalAmtPayableVal, driver, extentedReport);

		// Navigate to Policy Complete
		policyComplete = policyReviewPremium.NavigateToComplete(driver, extentedReport);

		policyComplete.ClickCancelAccepted(driver, extentedReport);
		policyDocumentation = policyComplete.ClickOK(driver, extentedReport);
		// policyDocumentation.ClickDocumentClose(driver, extentedReport);

		// policySearch.ValidateRow1data(driver, extentedReport);
		// policySearch.ValidatePolicyPosition("CNL", driver, extentedReport);
	}

	@Then("^Invite Renewal for the Policy$")
	public void invite_Renewal_for_the_Policy() throws Throwable {

		// stub to call cancel start

		/*
		 * policyURN = "275"; dashboard.clickOnPolicyAdmin(extentedReport);
		 * policySearch = dashboard.clickOnManagePolicies(extentedReport);
		 * 
		 */ // Stub to call cancel end

		policySearch.enterpolicyNum(policyURN, driver, extentedReport);
		policySearch.clickBtnSearch(extentedReport, driver);
		policySearch.clickInviteRenewalLnk(extentedReport, driver);

		policyRenewal = new UIRef_PolicyRenewal(driver, extentedReport);
		policyRenewal.ClickRenewalContinueBtn(driver, extentedReport);
		policyRenewal.ClickRenewalContinueBtn(driver, extentedReport);
		policyReviewPremium = policyRenewal.NavigateToReviewPremium(driver, extentedReport);

		String positionTypeVal = testData.get("Renewal");
		policyReviewPremium.ValidatePolicyPosition(positionTypeVal, driver, extentedReport);
		String TotalAmtPayableVal = testData.get("RenewalPremium");

		policyComplete = policyReviewPremium.NavigateToComplete(driver, extentedReport);

		policyComplete.ClickAccepted(driver, extentedReport);
		policyComplete.ClickOK(driver, extentedReport);
		// policyComplete.ClickDocumentClose(driver, extentedReport);

		// policySearch.ValidateRow1data(driver, extentedReport);
		// policySearch.ValidatePolicyPosition("RNL", driver, extentedReport);
	}

	@Then("^Endorse the Policy with min cover$")
	public void endorse_the_Policy_with_min_cover() throws Throwable {
		// stub to call Endorse start

		/*
		 * policyURN = "349"; dashboard.clickOnPolicyAdmin(extentedReport);
		 * policySearch = dashboard.clickOnManagePolicies(extentedReport);
		 */

		// Stub to call Endorse end

		policySearch.enterpolicyNum(policyURN, driver, extentedReport);
		policySearch.clickBtnSearch(extentedReport, driver);
		policyEndorse = policySearch.clickEndorse(extentedReport, driver);
		String endorseVal = testData.get("Endorse");
		String endrorseTypeVal = testData.get("EndorseType");
		String endrorseReasonVal = testData.get("EndorseReason");
		// policyEndorse.verifyEndorseDialogLable(driver, extentedReport);
		policyEndorse.enterEndorseCancelEffectiveDate("future", "15", "0", driver, extentedReport);
		policyEndorse.selectEndorseType(endrorseTypeVal, driver, extentedReport);
		policyEndorse.enterReason(endrorseReasonVal, driver, extentedReport);
		policyTree = policyEndorse.clickEndorseDialogOK(extentedReport, driver);
		// policyReviewPremium =
		// policyEndorse.clickEndorseDialogOK(extentedReport, driver);

		policyTree.clickAddLegalExpenses(extentedReport, driver);
		policyTree.clickAddHomeEmergency(extentedReport, driver);

		// Navigate to Review Premium
		policyReviewPremium = policyTree.ClickReviewPremium(driver, extentedReport);
		String TotalAmtPayableVal = testData.get("Premium TotalAmtPayable");

		policyReviewPremium.ValidateTotalAmtPayableNB(TotalAmtPayableVal, driver, extentedReport);

		// Navigate to Manage Billing
		policyManageBilling = policyTree.ClickManageBilling(driver, extentedReport);

		String paymentPlanVal = testData.get("Payment Plan");

		String paymentMethodVal = testData.get("Payment Method");

		// policyManageBilling.paymentPlan(paymentPlanVal, driver,
		// extentedReport);
		// policyManageBilling.paymentMethod(paymentMethodVal, driver,
		// extentedReport);
		policyComplete = policyManageBilling.ClickOKbtnManageBilling(driver, extentedReport);

		// Navigate to Policy Complete
		policyComplete.ClickAccepted(driver, extentedReport);
		policyDocumentation = policyComplete.ClickOK(driver, extentedReport);
		policyDocumentation.ClickDocumentCloseCncl(driver, extentedReport);

		// policyURN = policySearch.getpolicyNum(driver, extentedReport);
		// policySearch.ValidateRow1data(driver, extentedReport);

		policySearch.ValidatePolicyPosition("MTA", driver, extentedReport);
	}

	@Then("^Perform STA with min cover$")
	public void perform_STA_with_min_cover() throws Throwable {
		// stub to call Endorse start

		/*
		 * policyURN = "349"; dashboard.clickOnPolicyAdmin(extentedReport);
		 * policySearch = dashboard.clickOnManagePolicies(extentedReport);
		 */

		// Stub to call Endorse end

		policySearch.enterpolicyNum(policyURN, driver, extentedReport);
		policySearch.clickBtnSearch(extentedReport, driver);
		policySTA = policySearch.clickShortTermAdjustment(extentedReport, driver);
		String endorseVal = testData.get("STA");
		String reasonVal = testData.get("STA Reason");
		String typeVal = testData.get("STA Type");
		// policyEndorse.verifyEndorseDialogLable(driver, extentedReport);
		policySTA.enterSTAFromDate("current", "0", "0", driver, extentedReport);
		policySTA.enterSTAToDate("current", "60", "0", driver, extentedReport);
		policySTA.selectType(typeVal, driver, extentedReport);
		policySTA.enterReason(reasonVal, driver, extentedReport);
		policySTA.clickstaOKBtn(extentedReport, driver);
		// policyReviewPremium =
		// policyEndorse.clickEndorseDialogOK(extentedReport, driver);

		policyTree.clickAddLegalExpenses(extentedReport, driver);
		policyTree.clickAddHomeEmergency(extentedReport, driver);

		// Navigate to Review Premium
		policyReviewPremium = policyTree.ClickReviewPremium(driver, extentedReport);
		String TotalAmtPayableVal = testData.get("Premium TotalAmtPayable");

		policyReviewPremium.ValidateTotalAmtPayableNB(TotalAmtPayableVal, driver, extentedReport);

		// Navigate to Manage Billing
		policyManageBilling = policyTree.ClickManageBilling(driver, extentedReport);

		policyComplete = policyManageBilling.ClickOKbtnManageBilling(driver, extentedReport);

		// Navigate to Policy Complete
		policyComplete.ClickAccepted(driver, extentedReport);
		policyDocumentation = policyComplete.ClickOK(driver, extentedReport);
		// policyDocumentation.ClickDocumentCancel2(driver, extentedReport);

		// policyURN = policySearch.getpolicyNum(driver, extentedReport);
		// policySearch.ValidateRow1data(driver, extentedReport);

		// policySearch.ValidatePolicyPosition("STA", driver, extentedReport);
	}

	@Then("^Perform Adjust Billing$")
	public void perform_Adjust_Billing() throws Throwable {
		policySearch.enterpolicyNum(policyURN, driver, extentedReport);
		policySearch.clickBtnSearch(extentedReport, driver);
		policyAdjustBilling = policySearch.clickAdjustBilling(extentedReport, driver);
		String endorseVal = testData.get("BillingAdjustment");
		String reasonVal = testData.get("BA Reason");
		String typeVal = testData.get("BA Type");
		// policyEndorse.verifyEndorseDialogLable(driver, extentedReport);

		policyAdjustBilling.selectType(typeVal, driver, extentedReport);
		policyAdjustBilling.enterReason(reasonVal, driver, extentedReport);
		policyManageBilling = policyAdjustBilling.clickstaOKBtn(extentedReport, driver);

		// Navigate to Manage Billing
		policyManageBilling = policyTree.ClickManageBilling(driver, extentedReport);

		String paymentPlanVal = testData.get("BA Payment Plan");
		String paymentMethodVal = testData.get("BA Payment Method");
		policyManageBilling.SelectMonthlyDirectDebit(paymentPlanVal, paymentMethodVal, driver, extentedReport);

		/*
		 * policyManageBilling.paymentPlan(paymentPlanVal, driver,
		 * extentedReport); policyManageBilling.SelectAnnualCard(paymentPlanVal,
		 * paymentMethodVal, driver, extentedReport);
		 */

		policyComplete = policyManageBilling.ClickOKbtnManageBilling(driver, extentedReport);

		// Navigate to Policy Complete
		policyComplete.ClickAccepted(driver, extentedReport);
		policyDocumentation = policyComplete.ClickOK(driver, extentedReport);
		// policyDocumentation.ClickDocumentCancel2(driver, extentedReport);

		// policyURN = policySearch.getpolicyNum(driver, extentedReport);
		// policySearch.ValidateRow1data(driver, extentedReport);

		// policySearch.ValidatePolicyPosition("MTA", driver, extentedReport);

	}

	@Then("^Create Quote in UI Refresh$")
	public void create_Quote_in_UI_Refresh() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		policyBuisnessDetails = policySearch.clickcreatePolicyLnk(driver, extentedReport);
		String intermediaryID = testData.get("Intermediary");
		String agencyAgreement = testData.get("agencyAgreement");
		String productvalue = testData.get("Product");
		String schmevalue = testData.get("Scheme");
		policyBuisnessDetails.enterIntermediary(intermediaryID, driver, extentedReport);
		policyBuisnessDetails.enterAgencyAgreement(agencyAgreement, driver, extentedReport);
		policyBuisnessDetails.enterInceptionDate(driver, extentedReport);

		policyBuisnessDetails.enterProduct(productvalue, driver, extentedReport);
		policyBuisnessDetails.enterSchme(schmevalue, driver, extentedReport);
		// policyBuisnessDetails.enterAgencyAgreement(agencyAgreement,driver,extentedReport);
		policyBuisnessDetails.getPolicyURN(extentedReport, driver);
		policyTree = policyBuisnessDetails.clickOKbuisnessdetails(driver, extentedReport);
		// Operations on PolicyHeader
		policyHeader = policyTree.clickAddPolicyExtension(extentedReport, driver);
		String coverTypeVal = testData.get("Cover");
		String schemeVariantVal = testData.get("schemeVariant");
		String buildingsContinuousInsuranceVal = testData.get("BuildingInsurance");
		String contentsContinuousInsuranceVal = testData.get("ContentInsurance");
		// Operations on PolicyHeader
		policyHeader.enterCoverType(coverTypeVal, driver, extentedReport);
		policyHeader.enterschemeVariant(schemeVariantVal, driver, extentedReport);
		policyHeader.enterBuildingsInsurance(buildingsContinuousInsuranceVal, driver, extentedReport);
		policyHeader.enterContentsInsurance(contentsContinuousInsuranceVal, driver, extentedReport);
		policyHeader.ClickBtnPolicyHeader(driver, extentedReport);

		// Add Property
		String postcode = testData.get("Post Code");
		propertyDetails = policyTree.clickAddProperty(extentedReport, driver);
		propertyDetails.addressFormat("Lookup", driver, extentedReport);
		propertyDetails.selectAddressFromPostcode(postcode, driver, extentedReport);
		// Add Property Details
		String propertyTypeVal = testData.get("Property Type");
		String yearBuildVal = testData.get("YOB");
		String numberOfBedroomsVal = testData.get("No of Bedrooms");
		String constructWallVal = testData.get("ConstructWall");
		String constructRoofVal = testData.get("ConstructRoof");
		String ownershipTypeVal = testData.get("ownershipType");
		String occupiedDuringDayVal = testData.get("occupiedDuringDay");
		String soleOccupancyVal = testData.get("soleOccupancy");
		String occupiedDuringNightVal = testData.get("occupiedDuringNight");
		propertyDetails.propertyType(propertyTypeVal, driver, extentedReport);
		propertyDetails.yearBuild(yearBuildVal, driver, extentedReport);
		propertyDetails.numberOfBedrooms(numberOfBedroomsVal, driver, extentedReport);
		propertyDetails.constructWall(constructWallVal, driver, extentedReport);
		propertyDetails.constructRoof(constructRoofVal, driver, extentedReport);
		propertyDetails.ClicknextBtn(driver, extentedReport);
		propertyDetails.ownershipType(ownershipTypeVal, driver, extentedReport);
		propertyDetails.occupiedDuringDay(occupiedDuringDayVal, driver, extentedReport);
		propertyDetails.soleOccupancy(soleOccupancyVal, driver, extentedReport);
		propertyDetails.occupiedDuringNight(occupiedDuringNightVal, driver, extentedReport);
		propertyDetails.ClickSaveBtn(driver, extentedReport);

		// Add Core Covers
		String BuildingCover = testData.get("BuildingCover");
		String ContentCover = testData.get("ContentCover");
		String ADCover = testData.get("ADCover");
		String ExcessCover = testData.get("ExcessCover");
		policyCoreCovers = policyTree.clickAddCoreCovers(extentedReport, driver);

		policyCoreCovers.SelectBuildingNContentCovers(BuildingCover, ContentCover, driver, extentedReport);
		policyCoreCovers.SelectADCovers(ADCover, driver, extentedReport);
		policyCoreCovers.SelectExcessCovers(ExcessCover, driver, extentedReport);
		policyCoreCovers.ClickSaveBtnCoreCovers(driver, extentedReport);

		policyTree.ValidateCoreCoverRow(driver, extentedReport);
		policyTree.ClickReviewPremium(driver, extentedReport);

		// Navigate to Review Premium
		policyReviewPremium = policyTree.ClickReviewPremium(driver, extentedReport);
		String TotalAmtPayableVal = testData.get("Premium TotalAmtPayable");
		policyReviewPremium.ValidateTotalAmtPayableNB(TotalAmtPayableVal, driver, extentedReport);

		// Navigate to Manage Billing
		policyManageBilling = policyTree.ClickManageBilling(driver, extentedReport);

		String paymentPlanVal = testData.get("Payment Plan");
		String paymentMethodVal = testData.get("Payment Method");

		// policyManageBilling.paymentPlan(paymentPlanVal, driver,
		// extentedReport);
		// policyManageBilling.paymentMethod(paymentMethodVal, driver,
		// extentedReport);
		policyManageBilling.SelectAnnualCard(paymentPlanVal, paymentMethodVal, driver, extentedReport);
		policyComplete = policyManageBilling.ClickOKbtnManageBilling(driver, extentedReport);

		// Navigate to Policy Complete and accept Quote
		policyComplete.ClickQuoted(driver, extentedReport);
		policyDocumentation = policyComplete.ClickOK(driver, extentedReport);
		policyDocumentation.ClickDocumentCancel2(driver, extentedReport);

		policyURN = policySearch.getpolicyNum(driver, extentedReport);
		policySearch.ValidateRow1data(driver, extentedReport);

	}

	@Then("^Lapse an existing Quote$")
	public void lapse_an_existing_Quote() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		policySearch.enterpolicyNum(policyURN, driver, extentedReport);
		policySearch.clickBtnSearch(extentedReport, driver);
		policyLapse = policySearch.clickLapse(extentedReport, driver);
		String reasonVal = testData.get("Lapse Reason");
		String actionVal = testData.get("Lapse Action");
		policyLapse.selectAction(actionVal, driver, extentedReport);
		policyLapse.selectReason(reasonVal, driver, extentedReport);
		policyLapse.clickOKbtn(extentedReport, driver);

		policyURN = policySearch.getpolicyNum(driver, extentedReport);
		policySearch.ValidateRow1data(driver, extentedReport);
	}

	@Then("^Create NB with Joint PolicyHolder$")
	public void Create_NB_with_Joint_PolicyHolder() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		policyBuisnessDetails = policySearch.clickcreatePolicyLnk(driver, extentedReport);

		contactSearchDialog = policyBuisnessDetails.ClickpolicyHolderSearchIcon(driver, extentedReport);

		String contactNameVal = testData.get("Last Name") + " " + testData.get("First Name");
		contactSearchDialog.enterContactName(contactNameVal, extentedReport, driver);
		contactSearchDialog.clickModalSearchbtn(extentedReport, driver);
		contactSearchDialog.clickmodalRetreiveRow1(extentedReport, driver);

		policyBuisnessDetails.ValidateJointPolicyHolder(testData.get("Last Name"), driver, extentedReport);

		String intermediaryID = testData.get("Intermediary");
		String agencyAgreement = testData.get("agencyAgreement");
		String productvalue = testData.get("Product");
		String schmevalue = testData.get("Scheme");
		policyBuisnessDetails.enterIntermediary(intermediaryID, driver, extentedReport);
		policyBuisnessDetails.enterAgencyAgreement(agencyAgreement, driver, extentedReport);
		policyBuisnessDetails.enterInceptionDate(driver, extentedReport);
		policyBuisnessDetails.enterProduct(productvalue, driver, extentedReport);
		policyBuisnessDetails.enterSchme(schmevalue, driver, extentedReport);
		policyBuisnessDetails.getPolicyURN(extentedReport, driver);
		policyTree = policyBuisnessDetails.clickOKbuisnessdetails(driver, extentedReport);
		// Operations on PolicyHeader
		policyHeader = policyTree.clickAddPolicyExtension(extentedReport, driver);
		String coverTypeVal = testData.get("Cover");
		String schemeVariantVal = testData.get("schemeVariant");
		String buildingsContinuousInsuranceVal = testData.get("BuildingInsurance");
		String contentsContinuousInsuranceVal = testData.get("ContentInsurance");
		// Operations on PolicyHeader
		policyHeader.enterCoverType(coverTypeVal, driver, extentedReport);
		policyHeader.enterschemeVariant(schemeVariantVal, driver, extentedReport);
		policyHeader.enterBuildingsInsurance(buildingsContinuousInsuranceVal, driver, extentedReport);
		policyHeader.enterContentsInsurance(contentsContinuousInsuranceVal, driver, extentedReport);
		policyHeader.ClickBtnPolicyHeader(driver, extentedReport);

		// Add Property
		String postcode = testData.get("Post Code");
		propertyDetails = policyTree.clickAddProperty(extentedReport, driver);
		propertyDetails.addressFormat("Lookup", driver, extentedReport);
		propertyDetails.selectAddressFromPostcode(postcode, driver, extentedReport);
		// Add Property Details
		String propertyTypeVal = testData.get("Property Type");
		String yearBuildVal = testData.get("YOB");
		String numberOfBedroomsVal = testData.get("No of Bedrooms");
		String constructWallVal = testData.get("ConstructWall");
		String constructRoofVal = testData.get("ConstructRoof");
		String ownershipTypeVal = testData.get("ownershipType");
		String occupiedDuringDayVal = testData.get("occupiedDuringDay");
		String soleOccupancyVal = testData.get("soleOccupancy");
		String occupiedDuringNightVal = testData.get("occupiedDuringNight");
		propertyDetails.propertyType(propertyTypeVal, driver, extentedReport);
		propertyDetails.yearBuild(yearBuildVal, driver, extentedReport);
		propertyDetails.numberOfBedrooms(numberOfBedroomsVal, driver, extentedReport);
		propertyDetails.constructWall(constructWallVal, driver, extentedReport);
		propertyDetails.constructRoof(constructRoofVal, driver, extentedReport);
		propertyDetails.ClicknextBtn(driver, extentedReport);
		propertyDetails.ownershipType(ownershipTypeVal, driver, extentedReport);
		propertyDetails.occupiedDuringDay(occupiedDuringDayVal, driver, extentedReport);
		propertyDetails.soleOccupancy(soleOccupancyVal, driver, extentedReport);
		propertyDetails.occupiedDuringNight(occupiedDuringNightVal, driver, extentedReport);
		propertyDetails.ClickSaveBtn(driver, extentedReport);

		// Add Core Covers
		String BuildingCover = testData.get("BuildingCover");
		String ContentCover = testData.get("ContentCover");
		String ADCover = testData.get("ADCover");
		String ExcessCover = testData.get("ExcessCover");
		policyCoreCovers = policyTree.clickAddCoreCovers(extentedReport, driver);

		policyCoreCovers.SelectBuildingNContentCovers(BuildingCover, ContentCover, driver, extentedReport);
		policyCoreCovers.SelectADCovers(ADCover, driver, extentedReport);
		policyCoreCovers.SelectExcessCovers(ExcessCover, driver, extentedReport);
		policyCoreCovers.ClickSaveBtnCoreCovers(driver, extentedReport);

		policyTree.ValidateCoreCoverRow(driver, extentedReport);
		policyTree.ClickReviewPremium(driver, extentedReport);

		// Navigate to Review Premium
		policyReviewPremium = policyTree.ClickReviewPremium(driver, extentedReport);
		String TotalAmtPayableVal = testData.get("Premium TotalAmtPayable");
		policyReviewPremium.ValidateTotalAmtPayableNB(TotalAmtPayableVal, driver, extentedReport);

		// Navigate to Manage Billing
		policyManageBilling = policyTree.ClickManageBilling(driver, extentedReport);

		String paymentPlanVal = testData.get("Payment Plan");
		String paymentMethodVal = testData.get("Payment Method");

		// policyManageBilling.paymentPlan(paymentPlanVal, driver,
		// extentedReport);
		// policyManageBilling.paymentMethod(paymentMethodVal, driver,
		// extentedReport);
		policyManageBilling.SelectAnnualCard(paymentPlanVal, paymentMethodVal, driver, extentedReport);
		policyComplete = policyManageBilling.ClickOKbtnManageBilling(driver, extentedReport);

		// Navigate to Policy Complete and accept Quote
		policyComplete.ClickQuoted(driver, extentedReport);
		policyDocumentation = policyComplete.ClickOK(driver, extentedReport);
		policyDocumentation.ClickDocumentCancel2(driver, extentedReport);

		policyURN = policySearch.getpolicyNum(driver, extentedReport);
		// policySearch.ValidateRow1data(driver, extentedReport);
		policySearch.ValidatePolicyPosition("NB", driver, extentedReport);
	}

	@Then("^Reinstate the Cancelled Policy$")
	public void reinstate_the_Cancelled_Policy() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		policySearch.enterpolicyNum(policyURN, driver, extentedReport);
		policySearch.clickBtnSearch(extentedReport, driver);
		policyReinstate = policySearch.clickReinstate(extentedReport, driver);
		String ReinstateFromDate = testData.get("ReinstateFromDate");
		ArrayList aList = new ArrayList(Arrays.asList(ReinstateFromDate.split(",")));
		String fromDateVal = aList.get(0).toString();
		String dayInt = aList.get(1).toString();
		String yearInt = aList.get(2).toString();
		policyReinstate.enterFromDate(fromDateVal, dayInt, yearInt, driver, extentedReport);
		String typeVal = testData.get("ReinstateType");
		policyReinstate.selectType(typeVal, driver, extentedReport);
		String reasonVal = testData.get("ReinstateReason");
		policyReinstate.enterReason(reasonVal, driver, extentedReport);
		policyReviewPremium = policyReinstate.clickOKBtn(extentedReport, driver);
		// policyReviewPremium.ValidatePolicyPosition(positionTypeVal, driver,
		// extentedReport);
		// String TotalAmtPayableVal = testData.get("Premium TotalAmtPayable");
		// policyReviewPremium.ValidateTotalAmtPayableCNL(TotalAmtPayableVal,
		// driver, extentedReport);
		// Navigate to Policy Complete
		policyComplete = policyReviewPremium.NavigateToComplete(driver, extentedReport);
		// policyDocumentation.ClickDocumentClose(driver, extentedReport);
		// policySearch.ValidatePolicyPosition("RST", driver, extentedReport);
	}

	@Then("^Perform Reverse Transaction$")
	public void perform_Reverse_Transaction() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		policySearch.enterpolicyNum(policyURN, driver, extentedReport);
		policySearch.clickBtnSearch(extentedReport, driver);
		policyReverseTrans = policySearch.clickReverseTransaction(extentedReport, driver);
		String typeVal = testData.get("ReverseTranType");
		String reasonVal = testData.get("ReverseTranReason");
		policyReverseTrans.selectType(typeVal, driver, extentedReport);
		policyReverseTrans.enterReason(reasonVal, driver, extentedReport);
		policyReverseTrans.clickOKBtn(policyURN, extentedReport, driver);

	}

	@Then("^Create Quote with prior claim$")
	public void create_Quote_with_prior_claim() throws Throwable {
		policyBuisnessDetails = policySearch.clickcreatePolicyLnk(driver, extentedReport);
		String intermediaryID = testData.get("Intermediary");
		String agencyAgreement = testData.get("agencyAgreement");
		String productvalue = testData.get("Product");
		String schmevalue = testData.get("Scheme");
		policyBuisnessDetails.enterIntermediary(intermediaryID, driver, extentedReport);
		policyBuisnessDetails.enterAgencyAgreement(agencyAgreement, driver, extentedReport);
		policyBuisnessDetails.enterInceptionDate(driver, extentedReport);

		policyBuisnessDetails.enterProduct(productvalue, driver, extentedReport);
		policyBuisnessDetails.enterSchme(schmevalue, driver, extentedReport);
		// policyBuisnessDetails.enterAgencyAgreement(agencyAgreement,driver,extentedReport);
		policyBuisnessDetails.getPolicyURN(extentedReport, driver);
		policyTree = policyBuisnessDetails.clickOKbuisnessdetails(driver, extentedReport);
		// Operations on PolicyHeader
		policyHeader = policyTree.clickAddPolicyExtension(extentedReport, driver);
		String coverTypeVal = testData.get("Cover");
		String schemeVariantVal = testData.get("schemeVariant");
		String buildingsContinuousInsuranceVal = testData.get("BuildingInsurance");
		String contentsContinuousInsuranceVal = testData.get("ContentInsurance");
		// Operations on PolicyHeader
		policyHeader.enterCoverType(coverTypeVal, driver, extentedReport);
		policyHeader.enterschemeVariant(schemeVariantVal, driver, extentedReport);
		policyHeader.enterBuildingsInsurance(buildingsContinuousInsuranceVal, driver, extentedReport);
		policyHeader.enterContentsInsurance(contentsContinuousInsuranceVal, driver, extentedReport);

		policyPriorClaim = policyHeader.ClickLnkClaimsPriorToInception(driver, extentedReport);
		policyPriorClaim.ClickAddMain(driver, extentedReport);

		String valueOfClaimVal = testData.get("ValueOfClaim");
		String statusOfClaimVal = testData.get("StatusOfClaim");
		String atRiskAddressVal = testData.get("AtRiskAddress");
		String coverSectionVal = testData.get("CoverSection");
		String typeOfClaimVal = testData.get("TypeOfClaim");
		String dateOfClaimVal = testData.get("DateOfClaim");
		policyPriorClaim.enterValueOfClaim(valueOfClaimVal, driver, extentedReport);
		policyPriorClaim.enterStatusOfClaim(statusOfClaimVal, driver, extentedReport);
		policyPriorClaim.enterAtRiskAddress(atRiskAddressVal, driver, extentedReport);
		policyPriorClaim.enterCoverSection(coverSectionVal, driver, extentedReport);
		policyPriorClaim.entertypeOfClaim(typeOfClaimVal, driver, extentedReport);

		ArrayList aList = new ArrayList(Arrays.asList(dateOfClaimVal.split(",")));
		String fromDateVal = aList.get(0).toString();
		String dayInt = aList.get(1).toString();
		String yearInt = aList.get(2).toString();
		policyPriorClaim.enterDateOfClaim(fromDateVal, dayInt, yearInt, driver, extentedReport);
		policyPriorClaim.ClickAddClaimbtn(driver, extentedReport);
		policyPriorClaim.ClickAlertContinuebtn(driver, extentedReport);
		policyPriorClaim.Clickrow1(driver, extentedReport);
		policyPriorClaim.ClickSavebtn(driver, extentedReport);

		// policyHeader.ClickBtnPolicyHeader(driver, extentedReport);

		// Add Property
		String postcode = testData.get("Post Code");
		propertyDetails = policyTree.clickAddProperty(extentedReport, driver);
		propertyDetails.addressFormat("Lookup", driver, extentedReport);
		propertyDetails.selectAddressFromPostcode(postcode, driver, extentedReport);
		// Add Property Details
		String propertyTypeVal = testData.get("Property Type");
		String yearBuildVal = testData.get("YOB");
		String numberOfBedroomsVal = testData.get("No of Bedrooms");
		String constructWallVal = testData.get("ConstructWall");
		String constructRoofVal = testData.get("ConstructRoof");
		String ownershipTypeVal = testData.get("ownershipType");
		String occupiedDuringDayVal = testData.get("occupiedDuringDay");
		String soleOccupancyVal = testData.get("soleOccupancy");
		String occupiedDuringNightVal = testData.get("occupiedDuringNight");
		propertyDetails.propertyType(propertyTypeVal, driver, extentedReport);
		propertyDetails.yearBuild(yearBuildVal, driver, extentedReport);
		propertyDetails.numberOfBedrooms(numberOfBedroomsVal, driver, extentedReport);
		propertyDetails.constructWall(constructWallVal, driver, extentedReport);
		propertyDetails.constructRoof(constructRoofVal, driver, extentedReport);
		propertyDetails.ClicknextBtn(driver, extentedReport);
		propertyDetails.ownershipType(ownershipTypeVal, driver, extentedReport);
		propertyDetails.occupiedDuringDay(occupiedDuringDayVal, driver, extentedReport);
		propertyDetails.soleOccupancy(soleOccupancyVal, driver, extentedReport);
		propertyDetails.occupiedDuringNight(occupiedDuringNightVal, driver, extentedReport);
		propertyDetails.ClickSaveBtn(driver, extentedReport);

		// Add Core Covers
		String BuildingCover = testData.get("BuildingCover");
		String ContentCover = testData.get("ContentCover");
		String ADCover = testData.get("ADCover");
		String ExcessCover = testData.get("ExcessCover");
		policyCoreCovers = policyTree.clickAddCoreCovers(extentedReport, driver);

		policyCoreCovers.SelectBuildingNContentCovers(BuildingCover, ContentCover, driver, extentedReport);
		policyCoreCovers.SelectADCovers(ADCover, driver, extentedReport);
		policyCoreCovers.SelectExcessCovers(ExcessCover, driver, extentedReport);
		policyCoreCovers.ClickSaveBtnCoreCovers(driver, extentedReport);

		policyTree.ValidateCoreCoverRow(driver, extentedReport);

		// Navigate to Review Premium
		policyReviewPremium = policyTree.ClickReviewPremium(driver, extentedReport);
		policyPriorClaim.ClickAlertContinuebtn(driver, extentedReport);

		String TotalAmtPayableVal = testData.get("Premium TotalAmtPayable");
		policyReviewPremium.ValidateTotalAmtPayableNB(TotalAmtPayableVal, driver, extentedReport);

		policyReviewReferrals = policyReviewPremium.NavigateToReviewReferral(driver, extentedReport);
		// policyReviewReferrals.ClickAlertContinuebtn(driver, extentedReport);

		// Navigate to Manage Billing
		policyManageBilling = policyTree.ClickManageBilling(driver, extentedReport);

		String paymentPlanVal = testData.get("Payment Plan");
		String paymentMethodVal = testData.get("Payment Method");

		// policyManageBilling.paymentPlan(paymentPlanVal, driver,
		// extentedReport);
		// policyManageBilling.paymentMethod(paymentMethodVal, driver,
		// extentedReport);
		policyManageBilling.SelectAnnualCard(paymentPlanVal, paymentMethodVal, driver, extentedReport);
		policyComplete = policyManageBilling.ClickOKbtnManageBilling(driver, extentedReport);

		// Navigate to Policy Complete
		policyComplete.ClickIR(driver, extentedReport);
		policyDocumentation = policyComplete.ClickOK(driver, extentedReport);

		policyURN = policySearch.getpolicyNum(driver, extentedReport);

		policySearch.ValidatePolicyPosition("NB", driver, extentedReport);
	}

	@Given("^Generate ARN Code$")
	public void generate_ARN_Code() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// policyURN = "728";
		dashboard.clickOpenleftMenu(driver, extentedReport);
		dashboard.NavtoAdministrationMenu(driver, extentedReport);
		manageARN = dashboard.NavtoManageARN(driver, extentedReport);
		dashboard.clickCloseleftMenu(driver, extentedReport);
		createARN = manageARN.clickCreateARN(extentedReport, driver);
		ARNcodeVal = createARN.getARNcode(driver, extentedReport);
		String underwriterVal = testData.get("ARN underwriter");
		String TransVal = testData.get("ARN Transaction");
		String selSourceVal = testData.get("ARN Source");
		contactSearchDialog = createARN.clickUWsearchIcon(underwriterVal, driver, extentedReport);
		contactSearchDialog.enterContactName(underwriterVal, extentedReport, driver);
		contactSearchDialog.clickModalSearchbtn(extentedReport, driver);
		contactSearchDialog.clickmodalRetreiveRow1(extentedReport, driver);
		createARN.selectTransaction(TransVal, driver, extentedReport);
		createARN.enterPolicyURN(policyURN, driver, extentedReport);
		createARN.selectSource(selSourceVal, driver, extentedReport);
		createARN.clickBtnNext(driver, extentedReport);
		createARN.clickreferralApprove(driver, extentedReport);
		createARN.clickBtnSave(driver, extentedReport);
		manageARN.clickbtnComplete(extentedReport, driver);
	}

	@Then("^Accept the policy with referrals reason$")
	public void accept_the_policy_with_referrals_reason() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		/*
		 * policyURN = "728"; ARNcodeVal = "166";
		 */

		dashboard.clickOnPolicyAdmin(extentedReport);
		policySearch = dashboard.clickOnManagePolicies(extentedReport);
		policySearch.enterpolicyNum(policyURN, driver, extentedReport);
		policySearch.clickBtnSearch(extentedReport, driver);
		policyBuisnessDetails = policySearch.clickEditPolicyLnk(driver, extentedReport);
		policyBuisnessDetails.clickOKbuisnessdetails(driver, extentedReport);
		policyReviewReferrals = policyBuisnessDetails.NavigateToReviewReferral(driver, extentedReport);
		policyReviewReferrals.enterAuthorizationNum(ARNcodeVal, driver, extentedReport);
		policyReviewReferrals.ClickbtnAuthorise(driver, extentedReport);
		boolean ARNVal = policyReviewReferrals.validateARNStatus(driver, extentedReport);

		ARNVal = false;

		policyComplete = policyReviewReferrals.NavigateToComplete(driver, extentedReport);
		if (ARNVal) {
			policyComplete.ClickAccepted(driver, extentedReport);
			policyDocumentation = policyComplete.ClickOK(driver, extentedReport);
			policyURN = policySearch.getpolicyNum(driver, extentedReport);
			policySearch.ValidatePolicyPosition("NB", driver, extentedReport);
		} else {
			policyComplete.ClickIR(driver, extentedReport);
			policyDocumentation = policyComplete.ClickOK(driver, extentedReport);
			policyURN = policySearch.getpolicyNum(driver, extentedReport);
			policySearch.ValidatePolicyPosition("NB", driver, extentedReport);
		}
	}

	@When("^Search existing contact in Contact Search$")
	public void search_existing_contact_in_Contact_Search() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dashboard.clickOnContact(extentedReport);
		manageContacts = dashboard.clickOnManageContact(extentedReport);
		String userLastName = testData.get("Last Name") + " " + testData.get("First Name");
		manageContacts.enterName(userLastName);
		manageContacts.clickBtnSearch(extentedReport, driver);

	}

	@When("^Update the contact$")
	public void update_the_contact() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		EditPersonalContact = manageContacts.clickBtnEdit(extentedReport, driver);
		EditPersonalContact.click_on_general_Detils(extentedReport, driver);
		String txtGenderVal = testData.get("Gender");
		EditPersonalContact.selectGender(txtGenderVal, driver, extentedReport);
		String contactDOB = testData.get("Date of Birth");
		/*
		 * ArrayList aList= new ArrayList(Arrays.asList(contactDOB.split(",")));
		 * String fromDateVal = aList.get(0).toString(); String dayInt =
		 * aList.get(1).toString(); String yearInt = aList.get(2).toString();
		 */
		EditPersonalContact.enterDOB(contactDOB, driver, extentedReport);
		EditPersonalContact.clickBtnGenDtlSave(extentedReport, driver);
		contactURN = EditPersonalContact.getContactURN(extentedReport, driver);
		// Add Bank Details
		contactBanking = EditPersonalContact.clicklnkBanking(extentedReport, driver);
		String contactName = testData.get("Last Name") + " " + testData.get("First Name");
		String country = testData.get("Country");
		String currency = testData.get("Currency");
		String acctType = testData.get("Account Type");
		String sortCode = testData.get("Sort Code");
		String bankAcct = testData.get("Bank Account");
		String cardNum = testData.get("Card Number");
		String cardExp = testData.get("Expiry");
		String cardType = testData.get("Card Type");
		Boolean bankExits = contactBanking.verifyBankAccts(extentedReport, driver);
		if (!bankExits) {
			// Add Bank Details
			contactBanking = EditPersonalContact.clicklnkBanking(extentedReport, driver);
			contactBanking.clickLnkBankAccounts(extentedReport, driver);
			contactBanking.clickBtnAddBankAccount(extentedReport, driver);

			contactBanking.selectBankCountry(country, driver, extentedReport);
			contactBanking.selectBankCurrency(currency, driver, extentedReport);
			contactBanking.enterBankAcctName(contactName, driver, extentedReport);
			contactBanking.enterbankAcctNum(bankAcct, driver, extentedReport);
			contactBanking.enterBankCode(sortCode, driver, extentedReport);
			contactBanking.selectBankAcctType(acctType, driver, extentedReport);
			contactBanking.clickBtnBankAdd(extentedReport, driver);
			contactBanking.verifyBankAccts(extentedReport, driver);
		}
		contactBanking.clickLnkCreditCards(extentedReport, driver);
		Boolean cardExits = contactBanking.verifyCards(extentedReport, driver);
		if (!cardExits) {
			// Add Card Details
			contactBanking.clickBtnAddCardDetails(extentedReport, driver);
			contactBanking.selectCardCounty(country, driver, extentedReport);
			contactBanking.enterCardHolder(contactName, driver, extentedReport);
			contactBanking.enterCardNumber(cardNum, driver, extentedReport);
			contactBanking.selectCardType(cardType, driver, extentedReport);
			contactBanking.enterCardExpiry(cardExp, driver, extentedReport);
			contactBanking.clickBtnCardAdd(extentedReport, driver);
			contactBanking.verifyCards(extentedReport, driver);
		}
		EditPersonalContact.clickBtnCompletetab(extentedReport, driver);
		manageContacts.clickBtnComplete(extentedReport, driver);
	}

	@Given("^Create a new contact in UI Refresh$")
	public void create_a_new_User_in_UI_Refresh() throws Throwable {
		dashboard.clickOnContact(extentedReport);
		manageContacts = dashboard.clickOnManageContact(extentedReport);
		EditPersonalContact = manageContacts.clickCreatePersonalContact(extentedReport, driver);
		contactName = testData.get("First Name") + GenericUtils.getRandomCharacters("alpha", 5) + " "
				+ testData.get("Last Name") + GenericUtils.getRandomCharacters("alpha", 4);
		String gender = testData.get("Gender");
		String contactDOB = testData.get("Date of Birth");
		String postcode = testData.get("Post Code");
		EditPersonalContact.enterContactName(contactName, driver, extentedReport);
		EditPersonalContact.enterContactAlias(contactName, driver, extentedReport);
		EditPersonalContact.selectAddressFormat("Lookup", driver, extentedReport);
		addressSearchDialog = EditPersonalContact.clickAddressIcon(extentedReport, driver);
		addressSearchDialog.enterPostCode(postcode, extentedReport, driver);
		addressSearchDialog.clickBtnPostcodeSearch(extentedReport, driver);
		addressSearchDialog.clickLnkaddress1RetriveIcon(extentedReport, driver);
		EditPersonalContact.verifyAddDescription(postcode, extentedReport, driver);
		EditPersonalContact.clickBtnNextNameAddress(extentedReport, driver);
		EditPersonalContact.selectGender(gender, driver, extentedReport);
		EditPersonalContact.enterDOB(contactDOB, driver, extentedReport);
		EditPersonalContact.clickBtnGenDtlSave(extentedReport, driver);
		contactURN = EditPersonalContact.getContactURN(extentedReport, driver);
		// Add Bank Details
		contactBanking = EditPersonalContact.clicklnkBanking(extentedReport, driver);
		contactBanking.clickLnkBankAccounts(extentedReport, driver);
		contactBanking.clickBtnAddBankAccount(extentedReport, driver);
		String country = testData.get("Country");
		String currency = testData.get("Currency");
		String acctType = testData.get("Account Type");
		String sortCode = testData.get("Sort Code");
		String bankAcct = testData.get("Bank Account");
		String cardNum = testData.get("Card Number");
		String cardExp = testData.get("Expiry");
		String cardType = testData.get("Card Type");
		contactBanking.selectBankCountry(country, driver, extentedReport);
		contactBanking.selectBankCurrency(currency, driver, extentedReport);
		contactBanking.enterBankAcctName(contactName, driver, extentedReport);
		contactBanking.enterbankAcctNum(bankAcct, driver, extentedReport);
		contactBanking.enterBankCode(sortCode, driver, extentedReport);
		contactBanking.selectBankAcctType(acctType, driver, extentedReport);
		contactBanking.clickBtnBankAdd(extentedReport, driver);
		contactBanking.verifyBankAccts(extentedReport, driver);
		// Add Card Details
		contactBanking.clickLnkCreditCards(extentedReport, driver);
		contactBanking.clickBtnAddCardDetails(extentedReport, driver);
		contactBanking.selectCardCounty(country, driver, extentedReport);
		contactBanking.enterCardHolder(contactName, driver, extentedReport);
		contactBanking.enterCardNumber(cardNum, driver, extentedReport);
		contactBanking.selectCardType(cardType, driver, extentedReport);
		contactBanking.enterCardExpiry(cardExp, driver, extentedReport);
		contactBanking.clickBtnCardAdd(extentedReport, driver);
		contactBanking.verifyCards(extentedReport, driver);
		EditPersonalContact.clickBtnCompletetab(extentedReport, driver);
		manageContacts.clickBtnComplete(extentedReport, driver);

		dashboard.clickOnPolicyAdmin(extentedReport);
		policySearch = dashboard.clickOnManagePolicies(extentedReport);
		policySearch.enterContactURN(contactURN, driver, extentedReport);
		policySearch.verifyContactName(contactName, driver, extentedReport);
		policySearch.clickBtnSearch(extentedReport, driver);
	}

	@Then("^Create Notified claim for policy$")
	public void create_notified_claim_for_policy() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		policyURN = policySearch.getpolicyNum(driver, extentedReport);
		policySearch.clickBtnPolSearchComplete(extentedReport, driver);

		// contactURN = "9";
		// policyURN = "58";
		dashboard.clickClaims(driver, extentedReport);
		manageClaims = dashboard.clickManageClaims(driver, extentedReport);
		manageClaims.enterContact(contactURN, driver, extentedReport);
		manageClaims.enterpolicyNum(policyURN, driver, extentedReport);
		manageClaims.clickBtnSearch(extentedReport, driver);
		createClaim = manageClaims.clickBtnCreateClaim(extentedReport, driver);
		claimURN = createClaim.getClaimURN(extentedReport, driver);
		String claimDOL = testData.get("DOL");
		String claimTOL = testData.get("TOL");
		String claimHandler = testData.get("Claim Handler");
		String claimNarration = testData.get("Narrative");
		String claimDesc = testData.get("Claim Description");
		String claimType = testData.get("Claim Type");
		String claimCOL = testData.get("Cause of Loss");

		ArrayList aList = new ArrayList(Arrays.asList(claimDOL.split(",")));
		String fromDateVal = aList.get(0).toString();
		String dayInt = aList.get(1).toString();
		String yearInt = aList.get(2).toString();

		createClaim.enterClaimDOL(fromDateVal, dayInt, yearInt, driver, extentedReport);
		createClaim.enterClaimTOL(claimTOL, driver, extentedReport);
		createClaim.enterClaimHander(claimHandler, driver, extentedReport);
		createClaim.ClickBtnNotificationNext(extentedReport, driver);
		createClaim.enterNarrative(claimNarration, driver, extentedReport);
		createClaim.enterClaimDescription(claimDesc, driver, extentedReport);
		createClaim.selectClaimType(claimType, driver, extentedReport);
		createClaim.selectCauseofLoss(claimCOL, driver, extentedReport);
		createClaim.ClickBtnNarrativeOK(extentedReport, driver);
		createClaim.ClickBtnDebtOK(extentedReport, driver);
		claimComplete = createClaim.ClickLnkComplete(extentedReport, driver);
		claimComplete.clickRdNotified(driver, extentedReport);
		claimComplete.ClickBtnOK(extentedReport, driver);
		manageClaims.enterClaimNum(claimURN, driver, extentedReport);
		manageClaims.clickBtnSearch(extentedReport, driver);
		manageClaims.verifyClaimStatus("Notified", extentedReport, driver);
	}

	@Then("^Create open claim$")
	public void create_open_claim() throws Throwable {
		if (policySearch != null) {
			policyURN = policySearch.getpolicyNum(driver, extentedReport);
			policySearch.clickBtnPolSearchComplete(extentedReport, driver);
		}
		// contactURN = "9";
		//policyURN = "309";
		dashboard.clickClaims(driver, extentedReport);
		manageClaims = dashboard.clickManageClaims(driver, extentedReport);
		manageClaims.enterContact(contactURN, driver, extentedReport);
		manageClaims.enterpolicyNum(policyURN, driver, extentedReport);
		manageClaims.clickBtnSearch(extentedReport, driver);
		createClaim = manageClaims.clickBtnCreateClaim(extentedReport, driver);
		claimURN = createClaim.getClaimURN(extentedReport, driver);
		String claimDOL = testData.get("DOL");
		String claimTOL = testData.get("TOL");
		String claimHandler = testData.get("Claim Handler");
		String claimNarration = testData.get("Narrative");
		String claimDesc = testData.get("Claim Description");
		String claimType = testData.get("Claim Type");
		String claimCOL = testData.get("Cause of Loss");

		ArrayList aList = new ArrayList(Arrays.asList(claimDOL.split(",")));
		String fromDateVal = aList.get(0).toString();
		String dayInt = aList.get(1).toString();
		String yearInt = aList.get(2).toString();

		createClaim.enterClaimDOL(fromDateVal, dayInt, yearInt, driver, extentedReport);
		createClaim.enterClaimTOL(claimTOL, driver, extentedReport);
		createClaim.enterClaimHander(claimHandler, driver, extentedReport);
		createClaim.ClickBtnNotificationNext(extentedReport, driver);
		createClaim.enterNarrative(claimNarration, driver, extentedReport);
		createClaim.enterClaimDescription(claimDesc, driver, extentedReport);
		createClaim.selectClaimType(claimType, driver, extentedReport);
		createClaim.selectCauseofLoss(claimCOL, driver, extentedReport);
		createClaim.ClickBtnNarrativeOK(extentedReport, driver);
		createClaim.ClickBtnDebtOK(extentedReport, driver);

		claimCircumstance = createClaim.clickLinkCreateCircumstance(extentedReport, driver);

		// Create Content Generic Circumstance
		claimCircumstance.clickCntCreateGenericClaim(extentedReport, driver);
		String totalOutstand = testData.get("Total Outstanding");
		String totalRec = testData.get("Total Recovered");
		String totalPaid = testData.get("Total Paid");
		claimCircumstance.selectClaimType(claimCOL, driver, extentedReport);
		claimCircumstance.enterTotalOutstand(totalOutstand, driver, extentedReport);
		claimCircumstance.enterTotalPaid(totalPaid, driver, extentedReport);
		claimCircumstance.enterTotalRecovered(totalRec, driver, extentedReport);
		claimCircumstance.clickBtnSave(extentedReport, driver);
		// Create Building Generic Circumstance
		claimCircumstance.clickBldCreateGenericClaim(extentedReport, driver);
		claimCircumstance.selectClaimType(claimCOL, driver, extentedReport);
		claimCircumstance.enterTotalOutstand(totalOutstand, driver, extentedReport);
		claimCircumstance.enterTotalPaid(totalPaid, driver, extentedReport);
		claimCircumstance.enterTotalRecovered(totalRec, driver, extentedReport);
		claimCircumstance.clickBtnSave(extentedReport, driver);
		// Apply Estimatesjun
		claimApplyEstimates = claimCircumstance.clicklnkApplyEstimates(extentedReport, driver);
		claimApplyEstimates.clickAddPaymentCategory(extentedReport, driver);
		claimApplyEstimates.enterPaymentRevReserve(totalPaid, driver, extentedReport);
		claimApplyEstimates.clickAddRecoveryCategory(extentedReport, driver);
		claimApplyEstimates.enterRecoveryRevReserve(totalRec, driver, extentedReport);
		claimInformation = claimApplyEstimates.clickBtnOK(extentedReport, driver);
		/*
		 * // Verify claim information
		 * claimInformation.verifyTblRowsFinancials(extentedReport, driver);
		 * claimInformation.clickTabMovement(driver, extentedReport);
		 * claimInformation.verifyTblRowsMovements(extentedReport, driver);
		 * claimMakePayment = claimInformation.clickLinkMakePayments(driver,
		 * extentedReport); // Make Payment String invoiceAmount =
		 * testData.get("Total Paid"); String payDtlsType =
		 * testData.get("ClaimPayDetailsType");
		 * claimMakePayment.selectTypePayDtls(payDtlsType, driver,
		 * extentedReport); claimMakePayment.enterInvoiceAmt(invoiceAmount,
		 * driver, extentedReport);
		 * claimMakePayment.clickBtnNext(extentedReport, driver); String
		 * payBreakType = testData.get("ClaimPayBreakTypes"); String payBreakAmt
		 * = testData.get("ClaimPayBreakAmount"); String payBreakCategory =
		 * testData.get("ClaimPayBreakCategory"); String payBreakEOE =
		 * testData.get("ClaimPayBreakEffectOnEst"); ArrayList payBreakList =
		 * new ArrayList(Arrays.asList(payBreakType.split(","))); ArrayList
		 * payBreakAmount = new
		 * ArrayList(Arrays.asList(payBreakAmt.split(",")));
		 * 
		 * for (int i = 0; i < payBreakList.size(); i++) {
		 * System.out.println("payBreakList elements are " + i + " " +
		 * payBreakList.get(i));
		 * System.out.println("payBreakAmount elements are " + i + " " +
		 * payBreakAmount.get(i)); System.out.println("payBreakCategory : " +
		 * payBreakCategory); System.out.println("payBreakEOE : " +
		 * payBreakEOE); claimMakePayment.clickBtnAddBreakdown(extentedReport,
		 * driver); claimMakePayment.selTypePayBrkDwn((String)
		 * payBreakList.get(i), driver, extentedReport);
		 * claimMakePayment.selCategory(payBreakCategory, driver,
		 * extentedReport); claimMakePayment.enterAmtPayDtls((String)
		 * payBreakAmount.get(i), driver, extentedReport);
		 * claimMakePayment.selEffectOnEstimate(payBreakEOE, driver,
		 * extentedReport); claimMakePayment.clickBtnAdd(extentedReport,
		 * driver); } claimMakePayment.clickBtnSave(extentedReport, driver);
		 */
		// complete claim in open state
		claimComplete = claimApplyEstimates.clicklnkComplete(extentedReport, driver);
		claimComplete.clickRdOpen(driver, extentedReport);
		claimComplete.ClickBtnOK(extentedReport, driver);
		manageClaims.enterClaimNum(claimURN, driver, extentedReport);
		manageClaims.clickBtnSearch(extentedReport, driver);
		manageClaims.verifyClaimStatus("Open", extentedReport, driver);
	}

	@Then("^Create claim and finalised it in close status$")
	public void create_claim_and_finalise_it_in_close_status() throws Throwable {
		if (policySearch != null) {
			policyURN = policySearch.getpolicyNum(driver, extentedReport);
			policySearch.clickBtnPolSearchComplete(extentedReport, driver);
		}
		// contactURN = "9";
		// policyURN = "219";
		dashboard.clickClaims(driver, extentedReport);
		manageClaims = dashboard.clickManageClaims(driver, extentedReport);
		manageClaims.enterContact(contactURN, driver, extentedReport);
		manageClaims.enterpolicyNum(policyURN, driver, extentedReport);
		manageClaims.clickBtnSearch(extentedReport, driver);
		createClaim = manageClaims.clickBtnCreateClaim(extentedReport, driver);
		claimURN = createClaim.getClaimURN(extentedReport, driver);
		String claimDOL = testData.get("DOL");
		String claimTOL = testData.get("TOL");
		String claimHandler = testData.get("Claim Handler");
		String claimNarration = testData.get("Narrative");
		String claimDesc = testData.get("Claim Description");
		String claimType = testData.get("Claim Type");
		String claimCOL = testData.get("Cause of Loss");

		ArrayList aList = new ArrayList(Arrays.asList(claimDOL.split(",")));
		String fromDateVal = aList.get(0).toString();
		String dayInt = aList.get(1).toString();
		String yearInt = aList.get(2).toString();

		createClaim.enterClaimDOL(fromDateVal, dayInt, yearInt, driver, extentedReport);
		createClaim.enterClaimTOL(claimTOL, driver, extentedReport);
		createClaim.enterClaimHander(claimHandler, driver, extentedReport);
		createClaim.ClickBtnNotificationNext(extentedReport, driver);
		createClaim.enterNarrative(claimNarration, driver, extentedReport);
		createClaim.enterClaimDescription(claimDesc, driver, extentedReport);
		createClaim.selectClaimType(claimType, driver, extentedReport);
		createClaim.selectCauseofLoss(claimCOL, driver, extentedReport);
		createClaim.ClickBtnNarrativeOK(extentedReport, driver);
		createClaim.ClickBtnDebtOK(extentedReport, driver);

		claimCircumstance = createClaim.clickLinkCreateCircumstance(extentedReport, driver);

		// Create Content Generic Circumstance
		claimCircumstance.clickCntCreateGenericClaim(extentedReport, driver);
		String totalOutstand = testData.get("Total Outstanding");
		String totalRec = testData.get("Total Recovered");
		String totalPaid = testData.get("Total Paid");
		claimCircumstance.selectClaimType(claimCOL, driver, extentedReport);
		claimCircumstance.enterTotalOutstand(totalOutstand, driver, extentedReport);
		claimCircumstance.enterTotalPaid(totalPaid, driver, extentedReport);
		claimCircumstance.enterTotalRecovered(totalRec, driver, extentedReport);
		claimCircumstance.clickBtnSave(extentedReport, driver);
		// Create Building Generic Circumstance
		claimCircumstance.clickBldCreateGenericClaim(extentedReport, driver);
		claimCircumstance.selectClaimType(claimCOL, driver, extentedReport);
		claimCircumstance.enterTotalOutstand(totalOutstand, driver, extentedReport);
		claimCircumstance.enterTotalPaid(totalPaid, driver, extentedReport);
		claimCircumstance.enterTotalRecovered(totalRec, driver, extentedReport);
		claimCircumstance.clickBtnSave(extentedReport, driver);
		// Apply Estimates
		claimApplyEstimates = claimCircumstance.clicklnkApplyEstimates(extentedReport, driver);
		claimApplyEstimates.clickAddPaymentCategory(extentedReport, driver);
		claimApplyEstimates.enterPaymentRevReserve(totalOutstand, driver, extentedReport);
		claimApplyEstimates.clickAddRecoveryCategory(extentedReport, driver);
		claimApplyEstimates.enterRecoveryRevReserve(totalRec, driver, extentedReport);
		claimInformation = claimApplyEstimates.clickBtnOK(extentedReport, driver);
		// Verify claim information
		claimInformation.verifyTblRowsFinancials(extentedReport, driver);
		claimInformation.clickTabMovement(driver, extentedReport);
		claimInformation.verifyTblRowsMovements(extentedReport, driver);
		claimMakePayment = claimInformation.clickLinkMakePayments(driver, extentedReport);
		// Make Payment
		String invoiceAmount = testData.get("ClaimInvoiceAmt");
		String payDtlsType = testData.get("ClaimPayDetailsType");
		claimMakePayment.selectTypePayDtls(payDtlsType, driver, extentedReport);
		claimMakePayment.enterInvoiceAmt(invoiceAmount, driver, extentedReport);
		claimMakePayment.clickBtnNext(extentedReport, driver);
		String payBreakType = testData.get("ClaimPayBreakTypes");
		String payBreakAmt = testData.get("ClaimPayBreakAmount");
		String payBreakCategory = testData.get("ClaimPayBreakCategory");
		String payBreakEOE = testData.get("ClaimPayBreakEffectOnEst");
		ArrayList payBreakList = new ArrayList(Arrays.asList(payBreakType.split(",")));
		ArrayList payBreakAmount = new ArrayList(Arrays.asList(payBreakAmt.split(",")));

		for (int i = 0; i < payBreakList.size(); i++) {
			System.out.println("payBreakList elements are " + i + " " + payBreakList.get(i));
			System.out.println("payBreakAmount elements are " + i + " " + payBreakAmount.get(i));
			System.out.println("payBreakCategory : " + payBreakCategory);
			System.out.println("payBreakEOE : " + payBreakEOE);
			claimMakePayment.clickBtnAddBreakdown(extentedReport, driver);
			claimMakePayment.selTypePayBrkDwn((String) payBreakList.get(i), driver, extentedReport);
			claimMakePayment.selCategory(payBreakCategory, driver, extentedReport);
			claimMakePayment.enterAmtPayDtls((String) payBreakAmount.get(i), driver, extentedReport);
			claimMakePayment.selEffectOnEstimate(payBreakEOE, driver, extentedReport);
			claimMakePayment.clickBtnAdd(extentedReport, driver);
		}
		claimMakePayment.clickBtnSave(extentedReport, driver);
		// complete claim as finalised notified
		claimComplete = claimMakePayment.clicklnkComplete(extentedReport, driver);
		claimComplete.clickRdFinalisedClaim(driver, extentedReport);
		claimComplete.ClickBtnOK(extentedReport, driver);
		manageClaims.enterClaimNum(claimURN, driver, extentedReport);
		manageClaims.clickBtnSearch(extentedReport, driver);
		manageClaims.verifyClaimStatus("Closed", extentedReport, driver);
	}

	@Given("^Create receipt$")
	public void create_receipt() throws Throwable {
		// Add Receipt of Policy
		// Required parameter from previous steps are
		// policyURN i.e.
		// policyURN = "273";
		// contactName i.e. contactName = "Smith Jason";
		// receipt amount in variable chqAmount
		// claimURN = "487";
		dashboard.clickOpenleftMenu(driver, extentedReport);
		dashboard.NavtoReceiptsMenu(driver, extentedReport);
		manageReceipts = dashboard.NavtoManageReceipts(driver, extentedReport);
		dashboard.clickCloseleftMenu(driver, extentedReport);
		addReceipts = manageReceipts.clickAddReceipt(extentedReport, driver);
		String receiptType = testData.get("ReceiptType");
		String method = testData.get("ReceiptMethod");
		String amount = testData.get("ReceiptAmount");
		String number = String.valueOf(GenericUtils.getRandomNumberBetween(100001, 99999));
		addReceipts.selReceiptType(receiptType, driver, extentedReport);
		if (receiptType.equalsIgnoreCase("Policy"))
			addReceipts.enterPolicy(policyURN, driver, extentedReport);
		else if (receiptType.equalsIgnoreCase("Claims"))
			addReceipts.enterClaim(claimURN, driver, extentedReport);
		addReceipts.verifyContactName(contactName, extentedReport, driver);
		String accountPeriod = GenericUtils.getCurrentDate("YYYY/MM", driver);
		addReceipts.verifyAccountPeriod(accountPeriod.replaceAll("\\s+", " "), extentedReport, driver);
		addReceipts.selMethod(method, driver, extentedReport);
		if (method.equalsIgnoreCase("Cash"))
			addReceipts.enterCashAmount(amount, driver, extentedReport);
		else if (receiptType.equalsIgnoreCase("Cheque")) {
			addReceipts.enterChqAmount(amount, driver, extentedReport);
			addReceipts.enterTxtNum(number, driver, extentedReport);
		}
		addReceipts.clickBtnPost(extentedReport, driver);
		addReceipts.clickBtnCancel(extentedReport, driver);
		manageReceipts.selReceiptType(receiptType, driver, extentedReport);
		String inputRef = null;
		if (receiptType.equalsIgnoreCase("Policy")) {
			manageReceipts.enterPolicy(policyURN, driver, extentedReport);
			inputRef = policyURN;
		} else if (receiptType.equalsIgnoreCase("Claims")) {
			manageReceipts.enterClaim(claimURN, driver, extentedReport);
			inputRef = claimURN;
		}
		manageReceipts.selReceiptMethod(method, driver, extentedReport);
		manageReceipts.enterEntryDate(driver, extentedReport);
		manageReceipts.enterToDate(driver, extentedReport);
		manageReceipts.clickBtnSearch(extentedReport, driver);
		manageReceipts.verifyReceipt(amount, inputRef, extentedReport, driver);
		manageReceipts.clickbtnComplete(extentedReport, driver);
		// Add receipt for policy ended
	}

	@Given("^Edit claim and reconcile allocate recovery receipt$")
	public void edit_claim_and_reconcile_allocate_recovery_receipt() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// claimURN = "500";
		dashboard.clickClaims(driver, extentedReport);
		manageClaims = dashboard.clickManageClaims(driver, extentedReport);
		manageClaims.enterClaimNum(claimURN, driver, extentedReport);
		manageClaims.clickBtnSearch(extentedReport, driver);
		createClaim = manageClaims.clicktblRow1Edit(extentedReport, driver);

		claimMakePayment = createClaim.clickLinkMakePayments(extentedReport, driver);
		// Make Payment
		String invoiceAmount = testData.get("ClaimInvoiceAmt");
		String payDtlsType = testData.get("ClaimPayDetailsType");
		claimMakePayment.selectTypePayDtls(payDtlsType, driver, extentedReport);
		claimMakePayment.enterInvoiceAmt(invoiceAmount, driver, extentedReport);
		claimMakePayment.clickBtnNext(extentedReport, driver);
		String payBreakType = testData.get("ClaimPayBreakTypes");
		String payBreakAmt = testData.get("ClaimPayBreakAmount");
		String payBreakCategory = testData.get("ClaimPayBreakCategory");
		String payBreakEOE = testData.get("ClaimPayBreakEffectOnEst");
		ArrayList payBreakList = new ArrayList(Arrays.asList(payBreakType.split(",")));
		ArrayList payBreakAmount = new ArrayList(Arrays.asList(payBreakAmt.split(",")));

		for (int i = 0; i < payBreakList.size(); i++) {
			System.out.println("payBreakList elements are " + i + " " + payBreakList.get(i));
			System.out.println("payBreakAmount elements are " + i + " " + payBreakAmount.get(i));
			System.out.println("payBreakCategory : " + payBreakCategory);
			System.out.println("payBreakEOE : " + payBreakEOE);
			claimMakePayment.clickBtnAddBreakdown(extentedReport, driver);
			claimMakePayment.selTypePayBrkDwn((String) payBreakList.get(i), driver, extentedReport);
			claimMakePayment.selCategory(payBreakCategory, driver, extentedReport);
			claimMakePayment.enterAmtPayDtls((String) payBreakAmount.get(i), driver, extentedReport);
			claimMakePayment.selEffectOnEstimate(payBreakEOE, driver, extentedReport);
			claimMakePayment.clickBtnAdd(extentedReport, driver);
		}
		claimMakePayment.clickBtnSave(extentedReport, driver);

		// Allocate Recovery
		claimAllocateRecovery = claimMakePayment.clickLnkAllocateRecoveries(extentedReport, driver);
		claimAllocateRecovery.clickLinkforUnreconcilRcpt1(extentedReport, driver);
		claimAllocateRecovery.clickBtnCreate(extentedReport, driver);
		String circum = testData.get("AllocateRecoveryCircumstance");
		claimAllocateRecovery.selCicumstance(circum, driver, extentedReport);
		claimAllocateRecovery.selCategory(payBreakCategory, driver, extentedReport);
		String rcptAmt = testData.get("ReceiptAmount");
		claimAllocateRecovery.enterAmount(rcptAmt, driver, extentedReport);
		claimAllocateRecovery.clickBtnSave(extentedReport, driver);

		claimAllocateRecovery.clickLinkTblExpandRow(extentedReport, driver);
		claimAllocateRecovery.verifyTblRowAllocRecovery(extentedReport, driver);
		claimAllocateRecovery.clickBtnSave(extentedReport, driver);
		claimAllocateRecovery.verifyErrMsgs(extentedReport, driver);
		claimAllocateRecovery.clickBtnCancel(extentedReport, driver);

		claimComplete = claimAllocateRecovery.clicklnkComplete(extentedReport, driver);
		claimComplete.clickRdFinalisedClaim(driver, extentedReport);
		claimComplete.ClickBtnOK(extentedReport, driver);
		manageClaims.enterClaimNum(claimURN, driver, extentedReport);
		manageClaims.clickBtnSearch(extentedReport, driver);
		manageClaims.verifyClaimStatus("Closed", extentedReport, driver);
	}
}
