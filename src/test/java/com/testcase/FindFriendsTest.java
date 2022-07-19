package com.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.FindFriends;
import com.pages.HomePage;
import com.pages.LoginPage;

public class FindFriendsTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	FindFriends findFriends;

	public FindFriendsTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		findFriends = new FindFriends();

		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		findFriends.clickFindFriends();

	}

	@Test(priority = 1)
	public void verifyFindFriendsTitleTest() {
		String findFriendsTitle = findFriends.verifyFindFriendsTitle();
		Assert.assertEquals(findFriendsTitle, "Facebook", "Home Page is Incorrect");
	}

	@Test(priority = 2)
	public void verifyFriendRequestLink() {
		findFriends.clickFindFriends();
	}

	@Test(priority = 3)
	public void verifySuggestionsLink() {
		findFriends.clickonSuggestions();
	}

	@Test(priority = 4)
	public void verifyBirthdaysLink() {
		findFriends.clickonBithdays();
	}

	@Test(priority = 5)
	public void verifyCustomsLink() {
		findFriends.clickonCustomLists();
		log.info("verifyCustomsLink....");
	}

	@Test(priority = 6)
	public void add_friend() throws InterruptedException {
		findFriends.clickAddFriend();
		log.info("Click on Add Friend....");
		log.info("add Friend....");
		Thread.sleep(3000);
	}

	@Test(priority = 7)
	public void confirm_friend() throws InterruptedException {
		findFriends.clickOnConfirmFriend();
		log.info("Click on Confirm Friend....");
		Thread.sleep(3000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Closing Browser....");
	}
}
