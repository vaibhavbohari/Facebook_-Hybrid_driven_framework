package com.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;
import com.pages.SignUpPage;

public class SignUpPageTest extends BaseClass {

	SignUpPage signUpPage;
	LoginPage loginPage;

	public SignUpPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		signUpPage = new SignUpPage();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void signUpPageTitleTest() {
		String title = signUpPage.validateSignUpPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}

	@Test(priority = 2)
	public void SignUpTest() {
		loginPage = signUpPage.signUp(prop.getProperty("firstname"), prop.getProperty("lastname"),
				prop.getProperty("email"), prop.getProperty("verifyEmail"), prop.getProperty("password"),
				prop.getProperty("birthDay"), prop.getProperty("birthMonth"), prop.getProperty("birthYear"),
				prop.getProperty("gender"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
