package com.testcase;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProfilePage;

public class ProfilePageTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	

	public ProfilePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		profilePage = new ProfilePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}


	

	@Test(priority = 1)
	public void click_profilePage() {
		profilePage.clickProfilePage();
		log.info("Clicked on profile Page..");
	}

	@Test(priority = 2)
	public void verifyProfile() {
		profilePage.verifyProfilePage();
		log.info("Verify Profile Page");
	}

	@Test(priority = 3)
	public void click_uploadPhoto() throws AWTException, InterruptedException, IOException {
		profilePage.click_photoUpload();
		log.info("Click on Upload Photo");
		Thread.sleep(2000);
		

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Closing Browser....");
	}

}
