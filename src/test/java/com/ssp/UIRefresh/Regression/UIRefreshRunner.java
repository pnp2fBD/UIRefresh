package com.ssp.UIRefresh.Regression;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ssp.UIRefresh.GDPR_RTE_feature.gdprStepDefination;
import com.ssp.support.BaseCucumberTest;
import com.ssp.support.CucumberLog;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/html/", "json:target/json/cc.json",
		"html:target/cucumber-html-report",
		"rerun:target/cucumber-failed-scenarios.txt" }, 
		features = "src/test/java/resources",
		glue = "com.ssp.UIRefresh.Regression",
		tags = {"@uirefreshSmoke"} , 
		monochrome = true, 
		dryRun = false
		)

public class UIRefreshRunner extends AbstractTestNGCucumberTests {

	BaseCucumberTest cucumberTest = new BaseCucumberTest();
	public static String website_EC, website_UIRefresh, browser; 

	@BeforeSuite
	public void runBeforeMethod() {
		cucumberTest.beforeSuite();
	}

	@BeforeMethod
	public void init(ITestContext context) throws IOException {
		website_EC = System.getProperty("website_EC") != null ? System.getProperty("website_EC")
				: context.getCurrentXmlTest().getParameter("website_EC");
		System.out.println("Website EC URL : " + context.getCurrentXmlTest().getParameter("website_EC"));
		website_UIRefresh = System.getProperty("website_UIRefresh") != null ? System.getProperty("website_UIRefresh")
				: context.getCurrentXmlTest().getParameter("website_UIRefresh");
		System.out.println(
				"Website UI Refresh Link -: " + context.getCurrentXmlTest().getParameter("website_UIRefresh"));
		browser = System.getProperty("browserName") != null ? System.getProperty("browserName")
				: context.getCurrentXmlTest().getParameter("browserName");
		System.out.println(
				"browser: " + context.getCurrentXmlTest().getParameter("browserName"));
	}

	@After
	public void runAfterTest() {
		WebDriver driver = UIRefreshStepDefination.getDriver();
		if (driver != null)
			driver.quit();
		CucumberLog.endTestCase(UIRefreshStepDefination.getExtentedReport());
	}

	@AfterSuite
	public void runAfterMethod() {
		cucumberTest.afterSuite();
	}

}
