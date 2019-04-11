package com.ssp.uxp.WJ_Test;

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
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WJStepsDefinition {
  WebDriver driver;
  HashMap<String, String> testData;
  String browser = "chrome_windows";
  ExtentTest extentedReport;
  YourDetailsPage wjYourDetailsPage;
  YourQuotePage wjYourQuotePage;
  SummaryPageDetails wjSummaryPage;
  PaymentOptionsPage wjPaymentOptionsPage;
  PaymentConfirmationPage wjPaymentConfirmationPage;
  PaymentCompletePage wjPaymentCompletePage;

  @Given("^User fetches the data of \"([^\"]*)\"$")
  public void user_fetches_the_data_of(String arg1) throws Throwable {
    try {
      testData = BaseCucumberTest.getTestData("WJ", arg1);
      String description = testData.get("Description");
      Log.testCaseInfo(description + "<small><b><i>[" + browser + "]</b></i></small>");
      extentedReport = BaseCucumberTest.addTestInfo(arg1, description);
    } catch (Exception e) {
      Log.exception(e, driver, extentedReport);
      CucumberLog.endTestCase(extentedReport);
      driver.quit();
    }
  }

  @Given("^Logs in to WJ$")
  public void logs_in_to_WJ() throws Throwable {
    try {
      String website = WJTestRunner.webSite;
      driver = WebDriverFactory.get(browser);
      wjYourDetailsPage = new YourDetailsPage(driver, website, extentedReport).get();
    } catch (Exception e) {
      Log.exception(e, driver, extentedReport);
      CucumberLog.endTestCase(extentedReport);
      driver.quit();
    }
  }

  @When("^User enters the data to create a policy$")
  public void user_enters_the_data_to_create_a_policy() throws Throwable {
    try {
      wjYourQuotePage = wjYourDetailsPage.runFlowOfYourDetailsPage(testData);
      wjSummaryPage = wjYourQuotePage.runFlowOfYourQuotePage(testData);
      wjPaymentOptionsPage = wjSummaryPage.runFlowOfSummaryPage();
      wjPaymentConfirmationPage = wjPaymentOptionsPage.runFlowOfPaymentOptionsPage(testData);
      if (testData.get("Payment Method").equalsIgnoreCase("Annual"))
        wjPaymentCompletePage =
            wjPaymentConfirmationPage.runFlowOfAnnualPaymentConfirmationPage(testData);
      else
        wjPaymentCompletePage = wjPaymentConfirmationPage.runFlowOfMonthlyPaymentConfirmationPage();
    } catch (Exception e) {
      Log.exception(e, driver, extentedReport);
      CucumberLog.endTestCase(extentedReport);
      driver.quit();
    }
  }

  @Then("^Policy is created successfully$")
  public void policy_is_created_successfully() throws Throwable {
    try {
      wjPaymentCompletePage.runFlowOfPaymentCompletePage();
      CucumberLog.endTestCase(extentedReport);
      driver.quit();
    } catch (Exception e) {
      Log.exception(e, driver, extentedReport);
      CucumberLog.endTestCase(extentedReport);
      driver.quit();
    }
  }
}
