package com.ssp.EC.cancelDate_Feature;

import java.io.IOException;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.ssp.support.BaseCucumberTest;
import com.ssp.support.CucumberLog;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/html/", "json:target/json/cc.json"},
    features = "src/test/java/resources", tags = "@cancelDate", monochrome = true, dryRun = false,
    glue = "com.ssp.EC.cancelDate_Feature")

public class cancelDateRunner extends AbstractTestNGCucumberTests {

  BaseCucumberTest cucumberTest = new BaseCucumberTest();
  public static String webSite;

  @BeforeSuite
  public void runBeforeMethod() {
    cucumberTest.beforeSuite();
  }

  @BeforeMethod
  public void init(ITestContext context) throws IOException {
    webSite = System.getProperty("webSite") != null ? System.getProperty("webSite")
        : context.getCurrentXmlTest().getParameter("webSite");
    System.out.println("Website Name-: " + context.getCurrentXmlTest().getParameter("webSite"));
  }

  @AfterMethod
  public void runAfterTest() {
    WebDriver driver = cancelDateStepDefination.getDriver();
    if (driver != null)
      driver.quit();
    CucumberLog.endTestCase(cancelDateStepDefination.getExtentedReport());
  }

  @AfterSuite
  public void runAfterMethod() {
    cucumberTest.afterSuite();
  }
}
