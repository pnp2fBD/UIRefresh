package com.ssp.UIRefresh.GDPR_RTE_feature;

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
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/html/",
		"json:target/json/cc.json" }, features = "src/test/java/resources", tags = "@gdprRTE", monochrome = true, dryRun = false, glue = "com.ssp.UIRefresh.GDPR_RTE_feature")

public class gdprRTErunner extends AbstractTestNGCucumberTests {

	BaseCucumberTest cucumberTest = new BaseCucumberTest();
	public static String webSite, website_UIRefresh;

	@BeforeSuite
	public void runBeforeMethod() {
		cucumberTest.beforeSuite();
	}

	@BeforeMethod
	public void init(ITestContext context) throws IOException {
		webSite = System.getProperty("webSite") != null ? System.getProperty("webSite")
				: context.getCurrentXmlTest().getParameter("webSite");
		System.out.println("Website Name-: " + context.getCurrentXmlTest().getParameter("webSite"));

		website_UIRefresh = System.getProperty("website_UIRefresh") != null ? System.getProperty("website_UIRefresh")
				: context.getCurrentXmlTest().getParameter("website_UIRefresh");
		System.out.println(
				"Website UI Refresh  Link -: " + context.getCurrentXmlTest().getParameter("website_UIRefresh"));

	}

	@After
	public void runAfterTest() {
		WebDriver driver = gdprStepDefination.getDriver();
		if (driver != null)
			driver.quit();
		CucumberLog.endTestCase(gdprStepDefination.getExtentedReport());
	}
	
	/*@AfterMethod(alwaysRun = true)
	public void runAfterTest() {
		WebDriver driver = gdprStepDefination.getDriver();
		if (driver != null)
			driver.quit();
		CucumberLog.endTestCase(gdprStepDefination.getExtentedReport());
	}*/

	@AfterSuite
	public void runAfterMethod() {
		cucumberTest.afterSuite();
	}
}
