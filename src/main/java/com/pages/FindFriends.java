package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class FindFriends extends BaseClass {

	@FindBy(xpath = "//span[contains(text(),'Friends')]")
	WebElement findFriends;

	@FindBy(xpath = "//span[contains(text(),'Friend requests')]")
	WebElement friendRequests;

	@FindBy(xpath = "(//span[contains(text(),'Suggestions')])[1]")
	WebElement suggestions;

	@FindBy(xpath = "//span[contains(text(),'Birthdays')]")
	WebElement birthdays;

	@FindBy(xpath = "(//span[contains(text(),'Custom Lists')])[1]")
	WebElement customLists;

	@FindBy(xpath = "(//span[contains(text(),'Add Friend')])[1]")
	WebElement addFriend;

	@FindBy(xpath = "(//span[contains(text(),'Confirm')])[9]")
	WebElement confirmFriend;

	public FindFriends() {
		PageFactory.initElements(driver, this);
	}

	public FindFriends clickFindFriends() {
		findFriends.click();
		return new FindFriends();
	}

	public String verifyFindFriendsTitle() {
		return driver.getTitle();
	}

	public void clickonSuggestions() {
		suggestions.click();
	}

	public void clickonBithdays() {
		birthdays.click();
	}

	public void clickonCustomLists() {
		customLists.click();
	}

	public FindFriends clickAddFriend() {
		// addFriend.isEnabled();
		findFriends.click();
		addFriend.click();
		return new FindFriends();
	}

	public FindFriends clickOnConfirmFriend() {
		// addFriend.isEnabled();
		findFriends.click();
		confirmFriend.click();
		return new FindFriends();
	}

}
