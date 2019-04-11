package com.ssp.UIRefresh.GDPR_RTE_feature;

import java.util.Arrays;
import java.util.HashMap;
import org.apache.bcel.generic.Select;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.EC.cancelDate_Feature.cancelDateRunner;
import com.ssp.support.BaseCucumberTest;
import com.ssp.support.CucumberLog;
import com.ssp.support.Log;
import com.ssp.support.WebDriverFactory;
import com.ssp.uirefresh_pages.UIRefresh_Dashboard;
import com.ssp.uirefresh_pages.UIRefresh_Login;
import com.ssp.uirefresh_pages.UIRefresh_Manage_contacts;
import com.ssp.uirefresh_pages.UIRefresh_RemovePersonalData;
import com.ssp.uirefresh_pages.UIRefresh_ViewPersonalContact;
import com.ssp.uirefresh_pages.UIRefrsh_EditPersonalContact;
import com.ssp.uxp.WJ_Test.WJTestRunner;
import com.ssp.uxp_WJpages.PaymentCompletePage;
import com.ssp.uxp_WJpages.PaymentConfirmationPage;
import com.ssp.uxp_WJpages.PaymentOptionsPage;
import com.ssp.uxp_WJpages.SummaryPageDetails;
import com.ssp.uxp_WJpages.YourDetailsPage;
import com.ssp.uxp_WJpages.YourQuotePage;
import com.ssp.uxp_pages.CardDetailsPage;
import com.ssp.uxp_pages.CustDashboardPage;
import com.ssp.uxp_pages.HomePage;
import com.ssp.uxp_pages.LoginPage;
import com.ssp.uxp_pages.NewQuotePage;
import com.ssp.uxp_pages.SearchPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class gdprStepDefination {
  private static WebDriver driver;
  HashMap<String, String> testData;
  String browser = "chrome_windows";
  static ExtentTest extentedReport;
  YourDetailsPage wjYourDetailsPage;
  YourQuotePage wjYourQuotePage;
  SummaryPageDetails wjSummaryPage;
  PaymentOptionsPage wjPaymentOptionsPage;
  PaymentConfirmationPage wjPaymentConfirmationPage;
  PaymentCompletePage wjPaymentCompletePage;
  CustDashboardPage custdashboardpage;
  HomePage homePage;
	UIRefresh_Dashboard dashboard;
	UIRefresh_Manage_contacts manageContacts;
	UIRefresh_RemovePersonalData removePeronalData;
	UIRefresh_Login login;
	UIRefrsh_EditPersonalContact EditPersonalContact;
	UIRefresh_ViewPersonalContact viewPersonalContact;
	private String userLastName=null,userFirstName=null,userEmail=null;
	private String policyURN=null;
	private String URNContact=null;
	HashMap<String, String> custDetails;

	public static ExtentTest getExtentedReport() {
    return extentedReport;
  }

	public static WebDriver getDriver() {
    return driver;
  }

	@Given("^Fetch the data of \"([^\"]*)\"$")
	public void fetch_the_data_of(String arg1) throws Exception {
		try {
			String className = "gdprRTE_";
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
	public void login_to_EC_and_Create_a_new_User() throws Exception {
		try {
			String userName = testData.get("UserName");
			String password = testData.get("Password");
			String brandname = testData.get("Brand Name");
			String website = gdprRTErunner.webSite;
			driver = WebDriverFactory.get(browser);
			LoginPage loginPage = new LoginPage(driver, website, extentedReport).get();
			Log.pass("Engagement Centre Landing Page : " + website, driver, extentedReport, true);
			homePage = loginPage.loginToSSP(userName, password, false, extentedReport);
			Log.softAssertThat(homePage.verifyHomePage(), "Successfully logged into UXP Home Page", "Login failed",	driver, extentedReport, true);
			Log.message("Logged in User id:" + userName + "& Password:" + password, driver, extentedReport);
			homePage.clickTakeCall(extentedReport);
			homePage.clickMyBrands(brandname, extentedReport);
			SearchPage searchPage = new SearchPage(driver, extentedReport).get();
			Log.softAssertThat(searchPage.uielement.verifyPageElements(Arrays.asList("txtPolicyNumber"), searchPage), "Search page is verified", "Search Page is not verified", driver, extentedReport, true);
			
			// Enter Customer Details 
		    Log.softAssertThat(searchPage.uielement.verifyPageElements(Arrays.asList("txtPolicyNumber"), searchPage), "Search page is verified", "Search Page is not verified", driver, extentedReport,true);
		    searchPage.clickCreateCustomer(true, extentedReport); 
		    custDetails = searchPage.enterCustomerDetails(testData, true, extentedReport);
		   
		    // Confirm customer details and create customer 
		    custdashboardpage =  searchPage.confirmCreateCustomer(true, extentedReport); 
		    Log.softAssertThat(custdashboardpage.verifyContactName(testData.get("Title") + " " + custDetails.get("First Name") + " " + custDetails.get("Last Name"), extentedReport, true),"Verified FirstName and LastName on Customer Dashboard page","Not Verified Customer Name on Dashboard page", driver, extentedReport, true);
		    userFirstName=custDetails.get("First Name");
		    userLastName=custDetails.get("Last Name");
		    custdashboardpage.clickComplete(extentedReport);
		    homePage.doLogout(extentedReport);
		    driver.quit();
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
			CucumberLog.endTestCase(extentedReport);
			driver.quit();
		}
	}
	
	@Given("^Login to EC and Create a new policy on the user$")
	public void login_to_EC_and_create_a_new_policy_on_the_user() throws Exception {
		try {
			String userName = testData.get("UserName");
			String password = testData.get("Password");
			String brandname = testData.get("Brand Name");
			String website = gdprRTErunner.webSite;
			String Corecover = testData.get("Cover");
			driver = WebDriverFactory.get(browser);
			LoginPage loginPage = new LoginPage(driver, website, extentedReport).get();
			Log.pass("Engagement Centre Landing Page : " + website, driver, extentedReport, true);
			homePage = loginPage.loginToSSP(userName, password, false, extentedReport);
			Log.softAssertThat(homePage.verifyHomePage(), "Successfully logged into UXP Home Page", "Login failed",	driver, extentedReport, true);
			Log.message("Logged in User id:" + userName + "& Password:" + password, driver, extentedReport);
			homePage.clickTakeCall(extentedReport);
			homePage.clickMyBrands(brandname, extentedReport);
			SearchPage searchPage = new SearchPage(driver, extentedReport).get();
			Log.softAssertThat(searchPage.uielement.verifyPageElements(Arrays.asList("txtPolicyNumber"), searchPage), "Search page is verified", "Search Page is not verified", driver, extentedReport, true);
			
			// Enter Customer Details 
		    Log.softAssertThat(searchPage.uielement.verifyPageElements(Arrays.asList("txtPolicyNumber"), searchPage), "Search page is verified", "Search Page is not verified", driver, extentedReport,true);
		    searchPage.clickCreateCustomer(true, extentedReport); 
		    custDetails = searchPage.enterCustomerDetails(testData, true, extentedReport);
		   
		    // Confirm customer details and create customer 
		    custdashboardpage =  searchPage.confirmCreateCustomer(true, extentedReport); 
		    Log.softAssertThat(custdashboardpage.verifyContactName(testData.get("Title") + " " + custDetails.get("First Name") + " " + custDetails.get("Last Name"), extentedReport, true),"Verified FirstName and LastName on Customer Dashboard page","Not Verified Customer Name on Dashboard page", driver, extentedReport, true);
		    userFirstName=custDetails.get("First Name");
		    userLastName=custDetails.get("Last Name");
		    // Create New Quote 
		    custdashboardpage.clickNewQuote(true, extentedReport);
		    custdashboardpage.enterQuoteDetails(testData, true, extentedReport); 
		    NewQuotePage newquotepage = custdashboardpage.clickContinueQuote(true, extentedReport);
		    Log.softAssertThat(newquotepage.verifyNewQuotePage(true, extentedReport),"Verified NewQuotePage ", "Not verified NewQuotePage", driver, extentedReport, true);
		    newquotepage.enterPolicyDetails(testData, true, extentedReport);
		    newquotepage.clickNextOne(extentedReport); 
		    newquotepage.enterCustomerDetails(testData, true, Corecover, extentedReport); 
		    newquotepage.clickNextTwo(extentedReport);
		    newquotepage.clickView(extentedReport); 
		    newquotepage.clickAgree(extentedReport); // Get and Buy Quote 
		    newquotepage.clickGetQuote(extentedReport);
		    newquotepage.clickBuy(extentedReport); //Select Payment 
		    newquotepage.selectPayment(testData, true, extentedReport);
		    newquotepage.takePayment(extentedReport); Thread.sleep(20000);//To be deleted 
		    CardDetailsPage carddetailspage = newquotepage.selectVisacard(extentedReport);
		    
		    // Enter Card Details
		    carddetailspage.enterCardNumber(testData, extentedReport, false);
		    carddetailspage.selectExpiry(testData, extentedReport, false);
		    carddetailspage.enterVerification(extentedReport, false);
		    carddetailspage.enterName(testData,extentedReport, true); 
		    carddetailspage.clickbuy(extentedReport, true);
		    Log.message("Entered Card Details and Navigated to Verificaion page", driver, extentedReport,true);
		    Thread.sleep(10000);
		    custdashboardpage = newquotepage.confirmPayment(testData, extentedReport); 
		    Log.softAssertThat(custdashboardpage.uielement.verifyPageElements(Arrays.asList("lnkEditDetails"),custdashboardpage), "Navigated to Customer Dashboard page","Not navigated to Customer Dashboard page", driver, extentedReport, true);
		    
		    // Check for the customerdashboard page tabs
		    custdashboardpage.verify_ExpandCollapse_Custdashboard(extentedReport, true);
		    
		    // check for policy status 
		    HashMap<String, String> policyDetails = custdashboardpage.getPolicyURN(extentedReport); 
		    if (policyDetails.get("Status").toString().equalsIgnoreCase("Accepted")) 
		    {
		        Log.message("New Business Policy Created Successfully in Accepted status", driver,extentedReport, true); policyDetails.get("PolicyNo");
		    }
		    policyURN=policyDetails.get("PolicyNo");
		    custdashboardpage.clickComplete(extentedReport);
		    homePage.doLogout(extentedReport);
		    driver.quit();
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
			CucumberLog.endTestCase(extentedReport);
			driver.quit();
		}
	}
	
	@Given("^Login to EC and Create a new Quote on the user$")
	public void login_to_EC_and_create_a_new_Quote_on_the_user() throws Exception {
		try {
			String userName = testData.get("UserName");
			String password = testData.get("Password");
			String brandname = testData.get("Brand Name");
			String website = gdprRTErunner.webSite;
			String Corecover = testData.get("Cover");
			driver = WebDriverFactory.get(browser);
			LoginPage loginPage = new LoginPage(driver, website, extentedReport).get();
			Log.pass("Engagement Centre Landing Page : " + website, driver, extentedReport, true);
			homePage = loginPage.loginToSSP(userName, password, false, extentedReport);
			Log.softAssertThat(homePage.verifyHomePage(), "Successfully logged into UXP Home Page", "Login failed",	driver, extentedReport, true);
			Log.message("Logged in User id:" + userName + "& Password:" + password, driver, extentedReport);
			homePage.clickTakeCall(extentedReport);
			homePage.clickMyBrands(brandname, extentedReport);
			SearchPage searchPage = new SearchPage(driver, extentedReport).get();
			Log.softAssertThat(searchPage.uielement.verifyPageElements(Arrays.asList("txtPolicyNumber"), searchPage), "Search page is verified", "Search Page is not verified", driver, extentedReport, true);
			
			// Enter Customer Details 
		    Log.softAssertThat(searchPage.uielement.verifyPageElements(Arrays.asList("txtPolicyNumber"), searchPage), "Search page is verified", "Search Page is not verified", driver, extentedReport,true);
		    searchPage.clickCreateCustomer(true, extentedReport); 
		    custDetails = searchPage.enterCustomerDetails(testData, true, extentedReport);
		   
		    // Confirm customer details and create customer 
		    custdashboardpage =  searchPage.confirmCreateCustomer(true, extentedReport); 
		    Log.softAssertThat(custdashboardpage.verifyContactName(testData.get("Title") + " " + custDetails.get("First Name") + " " + custDetails.get("Last Name"), extentedReport, true),"Verified FirstName and LastName on Customer Dashboard page","Not Verified Customer Name on Dashboard page", driver, extentedReport, true);
		    userFirstName=custDetails.get("First Name");
		    userLastName=custDetails.get("Last Name");
		    userEmail=custDetails.get("Email");
		    
		    // Create New Quote 
		    custdashboardpage.clickNewQuote(true, extentedReport);
		    custdashboardpage.enterQuoteDetails(testData, true, extentedReport); 
		    NewQuotePage newquotepage = custdashboardpage.clickContinueQuote(true, extentedReport);
		    Log.softAssertThat(newquotepage.verifyNewQuotePage(true, extentedReport),"Verified NewQuotePage ", "Not verified NewQuotePage", driver, extentedReport, true);
		    newquotepage.enterPolicyDetails(testData, true, extentedReport);
		    newquotepage.clickNextOne(extentedReport); 
		    newquotepage.enterCustomerDetails(testData, true, Corecover, extentedReport); 
		    newquotepage.clickNextTwo(extentedReport);
		    newquotepage.clickView(extentedReport); 
		    newquotepage.clickAgree(extentedReport); // Get and Buy Quote 
		    newquotepage.clickGetQuote(extentedReport);
		    custdashboardpage = newquotepage.clicksave(extentedReport); 
		    newquotepage.clickQuoteSave("NB",userEmail,extentedReport);
		    Log.softAssertThat(custdashboardpage.uielement.verifyPageElements(Arrays.asList("lnkEditDetails"),custdashboardpage), "Navigated to Customer Dashboard page","Not navigated to Customer Dashboard page", driver, extentedReport, true);
		    
		    // Check for the customerdashboard page tabs
		    custdashboardpage.verify_ExpandCollapse_Custdashboard(extentedReport, true);
		    
		    // check for policy status 
		    HashMap<String, String> policyDetails = custdashboardpage.getPolicyURN(extentedReport); 
		    if (policyDetails.get("Status").toString().equalsIgnoreCase("Quoted")) 
		    {
		        Log.message("New Business Policy Created Successfully in Quoted status", driver,extentedReport, true); 
		        policyDetails.get("PolicyNo");
		    }
		    policyURN=policyDetails.get("PolicyNo");
		    custdashboardpage.clickComplete(extentedReport);
		    homePage.doLogout(extentedReport);
		    driver.quit();
		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
			CucumberLog.endTestCase(extentedReport);
			driver.quit();
		}
	}
	@Given("^Login in UI Refersh$")
	public void login_in_UI_Refersh() throws Exception {
		try
		{
			String website_UIRefresh=gdprRTErunner.website_UIRefresh;
			String userName = testData.get("UserName");
			String password = testData.get("Password");
			driver = WebDriverFactory.get(browser);
			login = new UIRefresh_Login(driver, website_UIRefresh, extentedReport).get();
	        Log.pass("UI Refresh Login Page : " + website_UIRefresh, driver, extentedReport, true);
	        dashboard = login.loginToUIRefresh(userName, password, false, extentedReport);
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
			CucumberLog.endTestCase(extentedReport);
			driver.quit();
		}
	}

	@When("^Search the contact and enter the all the details on Remove Personal Data screen and remove the new contact$")
	public void search_the_contact_and_enter_the_all_the_details_on_Remove_Personal_Data_screen_and_remove_the_new_contact()throws Exception {
		try
		{	String YES = "Yes";
			String NO = "No";
			dashboard.clickOnContact(extentedReport);
			manageContacts=dashboard.clickOnManageContact(extentedReport);
			manageContacts.enterName(userLastName);
			manageContacts.clickBtnSearch(extentedReport,driver);
			EditPersonalContact=manageContacts.clickBtnEdit(extentedReport, driver);
			URNContact=EditPersonalContact.getContactURN(extentedReport, driver);
			EditPersonalContact.clickBtnCompletetab(extentedReport, driver);
			manageContacts.clickBtnComplete(extentedReport, driver);
			dashboard.clickOnContact(extentedReport);
			removePeronalData=dashboard.clickonRemovePersonalData(extentedReport);
			removePeronalData.enterURN(extentedReport,driver,URNContact);
			removePeronalData.enterfirstName(extentedReport,driver,userFirstName);
			removePeronalData.enterlastName(extentedReport,driver,userLastName);
			removePeronalData.enterpostalCode(testData,extentedReport, driver);
			removePeronalData.clickRemovecontact(extentedReport, driver);
			if (testData.get("ContactStatus")!="")
			{ 
				if (testData.get("PermanentlyRemoveData").equals(YES))
				{
					removePeronalData.permanentlyRemoveData(extentedReport, driver);
				}
				else if (testData.get("PermanentlyRemoveData").equals(NO))
				{
					removePeronalData.doNotRemoveData(extentedReport, driver);
				}
				removePeronalData.clickCompleteButton(extentedReport, driver);	
			}
			
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
			CucumberLog.endTestCase(extentedReport);
			driver.quit();
		}
	}
	
	@When("^Search the contact and Enter all the details other than URN and click on Remove Personal Data button$")
	public void search_the_contact_and_Enter_all_the_details_other_than_URN_and_click_on_Remove_Personal_Data_button()throws Exception {
		try
		{
			removePeronalData=dashboard.clickonRemovePersonalData(extentedReport);
			removePeronalData.enterfirstName(extentedReport,driver,userFirstName);
			removePeronalData.enterlastName(extentedReport,driver,userLastName);
			removePeronalData.enterpostalCode(testData,extentedReport, driver);
			removePeronalData.clickRemovecontact(extentedReport, driver);
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
			CucumberLog.endTestCase(extentedReport);
			driver.quit();
		}
	}
	
	@When("^Search the contact and Enter all the details other than First Name and click on Remove Personal Data button$")
	public void search_the_contact_and_Enter_all_the_details_other_than_First_Name_and_click_on_Remove_Personal_Data_button()throws Exception {
		try
		{
			dashboard.clickOnContact(extentedReport);
			manageContacts=dashboard.clickOnManageContact(extentedReport);
			manageContacts.enterName(userLastName);
			manageContacts.clickBtnSearch(extentedReport,driver);
			EditPersonalContact=manageContacts.clickBtnEdit(extentedReport, driver);
			URNContact=EditPersonalContact.getContactURN(extentedReport, driver);
			EditPersonalContact.clickBtnCompletetab(extentedReport, driver);
			manageContacts.clickBtnComplete(extentedReport, driver);
			dashboard.clickOnContact(extentedReport);
			removePeronalData=dashboard.clickonRemovePersonalData(extentedReport);
			removePeronalData.enterURN(extentedReport,driver,URNContact);
			removePeronalData.enterlastName(extentedReport,driver,userLastName);
			removePeronalData.enterpostalCode(testData,extentedReport, driver);
			removePeronalData.clickRemovecontact(extentedReport, driver);
			
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
			CucumberLog.endTestCase(extentedReport);
			driver.quit();
		}
	}

	@When("^Search the contact and Enter all the details other than Surname and click on Remove Personal Data button$")
	public void search_the_contact_and_Enter_all_the_details_other_than_Surname_and_click_on_Remove_Personal_Data_button()throws Exception {
		try
		{
			dashboard.clickOnContact(extentedReport);
			manageContacts=dashboard.clickOnManageContact(extentedReport);
			manageContacts.enterName(userLastName);
			manageContacts.clickBtnSearch(extentedReport,driver);
			EditPersonalContact=manageContacts.clickBtnEdit(extentedReport, driver);
			URNContact=EditPersonalContact.getContactURN(extentedReport, driver);
			EditPersonalContact.clickBtnCompletetab(extentedReport, driver);
			manageContacts.clickBtnComplete(extentedReport, driver);
			dashboard.clickOnContact(extentedReport);
			removePeronalData=dashboard.clickonRemovePersonalData(extentedReport);
			removePeronalData.enterURN(extentedReport,driver,URNContact);
			removePeronalData.enterfirstName(extentedReport,driver,userFirstName);
			removePeronalData.enterpostalCode(testData,extentedReport, driver);
			removePeronalData.clickRemovecontact(extentedReport, driver);
			
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
			CucumberLog.endTestCase(extentedReport);
			driver.quit();
		}
	}
	
	@When("^Search the contact and Enter all the details other than Postal Code and click on Remove Personal Data button$")
	public void search_the_contact_and_Enter_all_the_details_other_than_Postal_Code_and_click_on_Remove_Personal_Data_button()throws Exception {
		try
		{
			dashboard.clickOnContact(extentedReport);
			manageContacts=dashboard.clickOnManageContact(extentedReport);
			manageContacts.enterName(userLastName);
			manageContacts.clickBtnSearch(extentedReport,driver);
			EditPersonalContact=manageContacts.clickBtnEdit(extentedReport, driver);
			URNContact=EditPersonalContact.getContactURN(extentedReport, driver);
			EditPersonalContact.clickBtnCompletetab(extentedReport, driver);
			manageContacts.clickBtnComplete(extentedReport, driver);
			dashboard.clickOnContact(extentedReport);
			removePeronalData=dashboard.clickonRemovePersonalData(extentedReport);
			removePeronalData.enterURN(extentedReport,driver,URNContact);
			removePeronalData.enterfirstName(extentedReport,driver,userFirstName);
			removePeronalData.enterlastName(extentedReport,driver,userLastName);
			removePeronalData.clickRemovecontact(extentedReport, driver);
			
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
			CucumberLog.endTestCase(extentedReport);
			driver.quit();
		}
	}



	@Then("^The user should get terminated with GDPR RTE reason$")
	public void the_user_should_get_terminated_with_GDPR_RTE_reason() throws Exception {
		try
		{
			dashboard.clickOnContact(extentedReport);
			dashboard.clickOnManageContact(extentedReport);
			manageContacts.enterURN(URNContact);
			manageContacts.clickonFilters(extentedReport, driver);
			manageContacts.selectStatus(testData,extentedReport, driver);
			manageContacts.clickBtnSearch(extentedReport, driver);
			viewPersonalContact=manageContacts.viewContact(extentedReport, driver);
			viewPersonalContact.clickongeneralDetails(extentedReport, driver);
			viewPersonalContact.verifyContactStatus(testData, extentedReport, driver);
			viewPersonalContact.verifyContactReason(testData, extentedReport, driver);
			viewPersonalContact.clickonHome(extentedReport, driver);
			
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
			CucumberLog.endTestCase(extentedReport);
			driver.quit();
		}
	}
	
	@Then("^Verify that user should not get terminated with GDPR RTE reason$")
	public void verify_that_user_should_not_get_terminated_with_GDPR_RTE_reason() throws Exception {
		try
		{
			dashboard.clickOnContact(extentedReport);
			dashboard.clickOnManageContact(extentedReport);
			manageContacts.enterURN(URNContact);
			manageContacts.clickonFilters(extentedReport, driver);
			manageContacts.selectStatus(testData,extentedReport, driver);
			manageContacts.clickBtnSearch(extentedReport, driver);
			viewPersonalContact=manageContacts.viewContact(extentedReport, driver);
			viewPersonalContact.clickongeneralDetails(extentedReport, driver);
			viewPersonalContact.verifyContactStatus(testData, extentedReport, driver);
			viewPersonalContact.verifyContactReason(testData, extentedReport, driver);
			viewPersonalContact.clickonHome(extentedReport, driver);
			
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
			CucumberLog.endTestCase(extentedReport);
			driver.quit();
		}
	}
	
	@Then("^Verify contact status cannot be changed from Terminated to Active$")
	public void verify_contact_status_cannot_be_changed_from_Terminated_to_Active() throws Exception {
		try
		{
			dashboard.clickOnContact(extentedReport);
			dashboard.clickOnManageContact(extentedReport);
			manageContacts.enterURN(URNContact);
			manageContacts.clickonFilters(extentedReport, driver);
			manageContacts.selectStatus(testData,extentedReport, driver);
			manageContacts.clickBtnSearch(extentedReport, driver);
			manageContacts.verifyEditContactlink(extentedReport, driver);
			manageContacts.clickBtnComplete(extentedReport, driver);
			//viewPersonalContact.clickonHome(extentedReport, driver);
			
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
			CucumberLog.endTestCase(extentedReport);
			driver.quit();
		}
	}
	
	
	@Then("^Error message should appear while Removal of Personal Data of a contact which has a live or quoted policy$")
	public void error_message_should_appear_while_Removal_of_Personal_Data_of_a_contact_which_has_a_live_or_quoted_policy() throws Exception {
		try
		{
			String removalError=removePeronalData.errorMessageVerification(testData, extentedReport, driver, policyURN);
			System.out.println("The error message appearing is: "+removalError);
			removePeronalData.verifyMandatorymessages(extentedReport,driver,removalError,true);
			
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
			CucumberLog.endTestCase(extentedReport);
			driver.quit();
		}
	}
	
	@Then("^Verify that Removal Personal Data screen is refreshed and all the customer detail fields are blank$")
	public void verify_that_Removal_Personal_Data_screen_is_refreshed_and_all_the_customer_detail_fields_are_blank() throws Exception {
		try
		{
			removePeronalData.permanentlyRemoveData(extentedReport, driver);
			removePeronalData.verifyBlankFields(extentedReport,driver);
			removePeronalData.clickCompleteButton(extentedReport, driver);	
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
			CucumberLog.endTestCase(extentedReport);
			driver.quit();
		}
	}
	
	
	
	@Then("^User should logout successfully from UI Refersh$")
	public void user_should_logout_successfully_from_UI_Refersh() throws Exception {
		try
		{
			dashboard.logout(extentedReport);
			Log.message("Logged out from UI refresh");
			driver.quit();
					
		}
		catch (Exception e) {
			Log.exception(e, driver, extentedReport);
			CucumberLog.endTestCase(extentedReport);
			driver.quit();
		}
	}


}
