/**
 * 
 */
package com.ssp.uirefresh_pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentTest;
import com.ssp.support.Log;
import com.ssp.support.StopWatch;
import com.ssp.utils.WaitUtils;
import com.ssp.uxp_pages.HomePage;
import org.openqa.selenium.support.ui.LoadableComponent;

/**
 * @author jheelum.dutta
 *
 */
public class UIRefresh_Login extends LoadableComponent<UIRefresh_Login> {

  private final WebDriver driver;
  private ExtentTest extentedReport;
  private String sspURL;
  private boolean isPageLoaded;
  public String spinner = "div.spinning-on-load-bg-table-active";
  public final String ERROR_MSG_LOGIN =
      "We do not recognise your details. Please re-enter your credentials";
  /**********************************************************************************************
   ********************************* WebElements of UIRefresh Login Page **********************************
   **********************************************************************************************/

  @FindBy(css = "#Username")
  WebElement txtUserName;

  @FindBy(css = "#Password")
  WebElement txtPassWord;

  @FindBy(css = "#userLogin > div.text-center > button")
  WebElement btnLogIn;

  public UIRefresh_Login(WebDriver driver, String url, ExtentTest report) {

    this.driver = driver;
    this.extentedReport = report;
    sspURL = url;
    PageFactory.initElements(driver, this);
  }

  /**
   * 
   * Constructor class for Login page Here we initializing the driver for page factory objects. For
   * ajax element waiting time has added while initialization
   * 
   * @param driver : Webdriver
   */
  public UIRefresh_Login(WebDriver driver, ExtentTest report) {

    this.driver = driver;
    this.extentedReport = report;
    PageFactory.initElements(driver, this);
  }

  @Override
  protected void load() {
    isPageLoaded = true;
    driver.get(sspURL);
    WaitUtils.waitForPageLoad(driver);
    // WaitUtils.waitForElement(driver, txtUserName);
  }

  @Override
  protected void isLoaded() throws Error {
    WaitUtils.waitForPageLoad(driver);
    if (!isPageLoaded) {
      Assert.fail();
    }

    /*
     * if (isPageLoaded && !driver.getTitle().contains("Login")) {
     * Log.fail("SSP Login Page did not open up. Site might be down.", driver,extentedReport); }
     */
  }

  public UIRefresh_Dashboard loginToUIRefresh(String username, String password, boolean screenShot,
      ExtentTest extentedReport) throws Exception {
    try {

      if (sspURL != null)
        Log.event("Launched UI Refresh site:: " + sspURL);
      Log.event("Login to the UI Refresh");
      enterUserName(username, extentedReport);
      enterPassword(password, extentedReport);
      // rmbrUsername.click();
      clickBtnLogIn(extentedReport);
      WaitUtils.waitForSpinner(driver);
      WaitUtils.waitForPageLoad(driver);
      if (isPageLoaded && driver.getTitle().toLowerCase().contains("login")) {
        throw new Exception("Invalid Login Details");
      }
      return new UIRefresh_Dashboard(driver, extentedReport).get();
    } catch (Exception e) {
      throw new Exception("Error while login to application : " + e);
    }
  }

  public void enterUserName(String userName, ExtentTest extentedReport) throws Exception {
    try {
      WaitUtils.waitForElement(driver, txtUserName);
      txtUserName.clear();
      txtUserName.sendKeys(userName);
      Log.message("Entered the UserName : " + userName, driver, extentedReport);
    } catch (Exception e) {
      throw new Exception("Error while entering Username : " + e);
    }
  }

  /**
   * To Enter password
   * 
   * @param pwd
   * @param extentedReport
   * @throws Exception
   * 
   */
  public void enterPassword(String pwd, ExtentTest extentedReport) throws Exception {
    try {
      WaitUtils.waitForElement(driver, txtPassWord);
      txtPassWord.clear();
      txtPassWord.sendKeys(pwd);
      Log.message("Entered the Password: " + pwd, driver, extentedReport);
    } catch (Exception e) {
      throw new Exception("Error while entering password : " + e);
    }
  }

  public void clickBtnLogIn(ExtentTest extentedReport) throws Exception {
    try {
      final long startTime = StopWatch.startTime();
      WaitUtils.waitForElement(driver, btnLogIn);
      JavascriptExecutor executor = (JavascriptExecutor) driver;
      executor.executeScript("arguments[0].click();", btnLogIn);
      // btnSignIn.click();
      WaitUtils.uiRefwaitForSpinner(driver);
      Log.message("Clicked LogIn button on login page ", driver, extentedReport);
      Log.event("Clicked LogIn button on login page", StopWatch.elapsedTime(startTime));
    } catch (Exception e) {
      // throw new Exception("Error while clicking LogIn button : " + e);
      Log.fail("Error while clicking LogIn button : " + e, driver, extentedReport, true);	
      Log.exception(e, driver, extentedReport);
    }
  }

}
