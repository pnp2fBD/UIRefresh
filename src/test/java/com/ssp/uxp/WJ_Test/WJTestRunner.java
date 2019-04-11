package com.ssp.uxp.WJ_Test;

import java.io.IOException;
import org.junit.runner.RunWith;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.ssp.support.BaseCucumberTest;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/html/", "json:target/json/cc.json"},
    features = "src/test/java/resources", tags="@WJSmoke", monochrome = true,glue="com.ssp.uxp.WJ_Test")

public class WJTestRunner extends AbstractTestNGCucumberTests {

  BaseCucumberTest cucumberTest = new BaseCucumberTest();
  public static String webSite;

  @BeforeSuite
  public void runBeforeMethod() {
    cucumberTest.beforeSuite();
  }

  @BeforeMethod
  public void init(ITestContext context) throws IOException {
    webSite = System.getProperty("webSite_WJ") != null ? System.getProperty("webSite_WJ")
        : context.getCurrentXmlTest().getParameter("webSite_WJ");
    System.out.println("Website Name-: " + context.getCurrentXmlTest().getParameter("webSite_WJ"));
  }

  @AfterSuite
  public void runAfterMethod() {
    cucumberTest.afterSuite();
  }
}
