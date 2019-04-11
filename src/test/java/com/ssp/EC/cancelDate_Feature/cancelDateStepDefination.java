package com.ssp.EC.cancelDate_Feature;

import java.util.Arrays;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.BaseCucumberTest;
import com.ssp.support.CucumberLog;
import com.ssp.support.Log;
import com.ssp.support.WebDriverFactory;
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
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class cancelDateStepDefination {
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

  public static ExtentTest getExtentedReport() {
    return extentedReport;
  }

  public static WebDriver getDriver() {
    return driver;
  }

  @Given("^User fetches the data of \"([^\"]*)\"$")
  public void user_fetches_the_data_of(String arg1) throws Exception {
    try {
      String className = "cancelDate_";
      testData = BaseCucumberTest.getTestData(className, arg1);
      String description = testData.get("Description");
      Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
      extentedReport = BaseCucumberTest.addTestInfo(arg1, description);
      Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
    } catch (Exception e) {
      CucumberLog.endTestCase(extentedReport);
    }
  }

  @Given("^Login to EC$")
  public void login_to_EC() throws Exception {
    try {
      String userName = testData.get("UserName");
      String password = testData.get("Password");
      String brandname = testData.get("Brand Name");
      String website = cancelDateRunner.webSite;
      driver = WebDriverFactory.get(browser);
      LoginPage loginPage = new LoginPage(driver, website, extentedReport).get();
      Log.pass("Engagement Centre Landing Page : " + website, driver, extentedReport, true);
      homePage = loginPage.loginToSSP(userName, password, false, extentedReport);
      Log.softAssertThat(homePage.verifyHomePage(), "Successfully logged into UXP Home Page",
          "Login failed", driver, extentedReport, true);
      Log.message("Logged in User id:" + userName + "& Password:" + password, driver,
          extentedReport);
      homePage.clickTakeCall(extentedReport);
      homePage.clickMyBrands(brandname, extentedReport);
      SearchPage searchPage = new SearchPage(driver, extentedReport).get();
      Log.softAssertThat(
          searchPage.uielement.verifyPageElements(Arrays.asList("txtPolicyNumber"), searchPage),
          "Search page is verified", "Search Page is not verified", driver, extentedReport, true);
    } catch (Exception e) {
      Log.exception(e, driver, extentedReport);
      CucumberLog.endTestCase(extentedReport);
      driver.quit();
    }
  }

  @Given("^Create a new policy$")
  public void create_a_new_policy() throws Exception {
    try {
      String Corecover = testData.get("Cover");
      SearchPage searchPage = new SearchPage(driver, extentedReport).get(); // Enter Customer
                                                                            // Details
      Log.softAssertThat(
          searchPage.uielement.verifyPageElements(Arrays.asList("txtPolicyNumber"), searchPage),
          "Search page is verified", "Search Page is not verified", driver, extentedReport, true);
      searchPage.clickCreateCustomer(true, extentedReport);
      HashMap<String, String> custDetails =
          searchPage.enterCustomerDetails(testData, true, extentedReport);

      // Confirm customer details and create customer
      custdashboardpage = searchPage.confirmCreateCustomer(true, extentedReport);
      Log.softAssertThat(
          custdashboardpage.verifyContactName(testData.get("Title") + " "
              + custDetails.get("First Name") + " " + custDetails.get("Last Name"), extentedReport,
              true),
          "Verified FirstName and LastName on Customer Dashboard page",
          "Not Verified Customer Name on Dashboard page", driver, extentedReport, true);

      // Create New Quote
      custdashboardpage.clickNewQuote(true, extentedReport);
      custdashboardpage.enterQuoteDetails(testData, true, extentedReport);
      NewQuotePage newquotepage = custdashboardpage.clickContinueQuote(true, extentedReport);
      Log.softAssertThat(newquotepage.verifyNewQuotePage(true, extentedReport),
          "Verified NewQuotePage ", "Not verified NewQuotePage", driver, extentedReport, true);
      newquotepage.enterPolicyDetails(testData, true, extentedReport);
      newquotepage.clickNextOne(extentedReport);
      newquotepage.enterCustomerDetails(testData, true, Corecover, extentedReport);
      newquotepage.clickNextTwo(extentedReport);
      newquotepage.clickView(extentedReport);
      newquotepage.clickAgree(extentedReport); // Get and Buy Quote
      newquotepage.clickGetQuote(extentedReport);
      newquotepage.clickBuy(extentedReport); // Select Payment
      newquotepage.selectPayment(testData, true, extentedReport);
      newquotepage.takePayment(extentedReport);
      Thread.sleep(20000);// To be deleted
      CardDetailsPage carddetailspage = newquotepage.selectVisacard(extentedReport);

      // Enter Card Details
      carddetailspage.enterCardNumber(testData, extentedReport, false);
      carddetailspage.selectExpiry(testData, extentedReport, false);
      carddetailspage.enterVerification(extentedReport, false);
      carddetailspage.enterName(testData, extentedReport, true);
      carddetailspage.clickbuy(extentedReport, true);
      Log.message("Entered Card Details and Navigated to Verificaion page", driver, extentedReport,
          true);
      Thread.sleep(10000);
      // Click continue button
      // newquotepage = carddetailspage.clickContinueButton(extentedReport);
      // Log.softAssertThat(newquotepage.verifyPaymentTrasaction(extentedReport),"Payment was
      // successful", "Payment was not successful", driver, extentedReport, true);

      custdashboardpage = newquotepage.confirmPayment(testData, extentedReport);
      Log.softAssertThat(
          custdashboardpage.uielement.verifyPageElements(Arrays.asList("lnkEditDetails"),
              custdashboardpage),
          "Navigated to Customer Dashboard page", "Not navigated to Customer Dashboard page",
          driver, extentedReport, true);

      // Check for the customerdashboard page tabs
      custdashboardpage.verify_ExpandCollapse_Custdashboard(extentedReport, true);

      // check for policy status
      HashMap<String, String> policyDetails = custdashboardpage.getPolicyURN(extentedReport);
      if (policyDetails.get("Status").toString().equalsIgnoreCase("Accepted")) {
        Log.message("New Business Policy Created Successfully in Accepted status", driver,
            extentedReport, true);
        policyDetails.get("PolicyNo");
      }
      // custdashboardpage.clickComplete(extentedReport);
      // Log.softAssertThat(homePage.verifyHomePage(),"Successfully navigated to Home Page after
      // clicking complete button in customer dashboard page"
      // , "Failed to navigate to Home Page after clicking complete button in customer dashboard
      // page",
      // driver, extentedReport, true);
    } catch (Exception e) {
      Log.exception(e, driver, extentedReport);
      CucumberLog.endTestCase(extentedReport);
      driver.quit();
    }
  }

  @When("^Cancel the policy using Cooling off option$")
  public void cancel_the_policy_using_Cooling_off_option() throws Exception {
    try {
      custdashboardpage.clickCancelPolicy(testData, true, extentedReport);
      // custdashboardpage.enterReason(testData.get("Cancellation Reason"), extentedReport);
      // custdashboardpage.enterPremiumType(testData, extentedReport);
      custdashboardpage.clickCalculate(true, extentedReport);
      custdashboardpage.clickConfirm(true, extentedReport);

      // Verifying that policy is cancelled
      // Log.softAssertThat(custdashboardpage.verifyCancellation(true, extentedReport),"Policy
      // cancelled successfully", "Policy is not cancelled", driver, extentedReport, true);

      // Verify correct Cancellation Date is appearing on Dashboard


    } catch (Exception e) {
      Log.exception(e, driver, extentedReport);
      CucumberLog.endTestCase(extentedReport);
      driver.quit();
    }
  }

  @Then("^Cancel Date should appear in correct format on Dashboard after cancelling the policy$")
  public void cancel_Date_should_appear_in_correct_format_on_Dashboard_after_cancelling_the_policy()
      throws Exception {
    // String cancelType=testData.get("Cancellation type");
    try {
      custdashboardpage.validateCancelDate(testData, extentedReport);
    } catch (Exception e) {
      Log.exception(e, driver, extentedReport);
      CucumberLog.endTestCase(extentedReport);
      driver.quit();
    }
  }

  @When("^Cancel the policy using Standard Cancellation option$")
  public void cancel_the_policy_using_Standard_Cancellation_option() throws Exception {
    try {
      custdashboardpage.clickCancelPolicy(testData, true, extentedReport);
      custdashboardpage.enterEffectiveDate(testData);
      custdashboardpage.enterReason(testData.get("Cancellation Reason"), extentedReport);
      custdashboardpage.enterPremiumType(testData, extentedReport);
      custdashboardpage.clickCalculate(true, extentedReport);
      custdashboardpage.clickConfirm(true, extentedReport);
      // Verifying that policy is cancelled
      // Log.softAssertThat(custdashboardpage.verifyCancellation(true, extentedReport),"Policy
      // cancelled successfully", "Policy is not cancelled", driver, extentedReport, true);

    } catch (Exception e) {
      Log.exception(e, driver, extentedReport);
      CucumberLog.endTestCase(extentedReport);
      driver.quit();
    }
  }

  @Then("^Reinstate the policy and validate the status is Active$")
  public void Reinstate_the_policy_and_validate_the_status_is_Active() throws Exception {
    try {
      custdashboardpage.clickReinstatePolicy(true, extentedReport);
      custdashboardpage.selectReinstateReason(testData, true, extentedReport);
      custdashboardpage.clickCalculateForReinstate(true, extentedReport);
      custdashboardpage.clickConfirmForReinstate(true, extentedReport);
      custdashboardpage.validatePolicyStatus(testData, extentedReport);
    } catch (Exception e) {
      Log.exception(e, driver, extentedReport);
      CucumberLog.endTestCase(extentedReport);
      driver.quit();
    }
  }

  @Then("^User should logout successfully$")
  public void User_should_logout_successfully() throws Exception {
    try {
      custdashboardpage.clickComplete(extentedReport);
      Log.softAssertThat(homePage.verifyHomePage(), "Successfully navigated to Home Page",
          "Failed to navigate to Home Page", driver, extentedReport, true);
      homePage.doLogout(extentedReport);
    } catch (Exception e) {
      Log.exception(e, driver, extentedReport);

    } finally {
      CucumberLog.endTestCase(extentedReport);
      driver.quit();
    }
  }



  /*
   * @Given("^Perform a MTA on the policy$") public void perform_a_MTA_on_the_policy() throws
   * Throwable { // Write code here that turns the phrase above into concrete actions // throw new
   * PendingException(); }
   */
}
