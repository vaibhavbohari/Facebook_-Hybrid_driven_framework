package com.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;

import com.pages.FindFriends;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.Menu;
import com.pages.Messenger;
import com.pages.Notifications;
import com.pages.ProfilePage;

public class HomePageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	FindFriends findFriends;
	Menu menu;
	Messenger messenger;
	Notifications notifications;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		profilePage = new ProfilePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("************Login the Application**********************");
		log.info("Open Home Page");
	}

	@Test(priority = 1)
	public void HomePageTitleTest() throws InterruptedException {
		log.info("Opening Home Page");
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Facebook");
		Thread.sleep(2000);
		log.info("Title Verified Successfully.....");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}

	@Test(priority = 3)
	public void verifyClickOnFriends() throws InterruptedException {

		findFriends = homePage.clickOnFriends();
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void verifyHomePage() throws InterruptedException {

		homePage = homePage.click_home();
		Thread.sleep(3000);
	}

	@Test(priority = 5)
	public void verifyClickOnLogout() throws InterruptedException {
		loginPage = homePage.checkOnLogout();
		Thread.sleep(2000);
	}

	@Test(priority = 6)
	public void verifyMenuLinkTest() {
		menu = homePage.clickOnMenuLink();
	}

	@Test(priority = 7)
	public void verifyMessengerLinkTest() {
		messenger = homePage.clickOnMessengerLink();
	}

	@Test(priority = 8)
	public void verifyNotificationsLinkTest() {
		notifications = homePage.clickOnNotificationsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
