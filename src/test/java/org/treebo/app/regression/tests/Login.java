package org.treebo.app.regression.tests;

import org.testng.annotations.Test;
import org.treebo.app.global.TestBaseSetup;
import org.treebo.app.pages.HomePage;

public class Login extends TestBaseSetup {

	@Test(groups = { "", "sanity" })
	public void otpLogin() throws Exception {

		HomePage home = new HomePage(driver);
		home.clickContinueBooking().clickMenu().clickLoginButton().enterMobileNumber("1122").clickConfirm()
				.clickConfirm()
				// .assertErrorMessageForValidMobileNumber()
				.clearMobileNumber().enterMobileNumber("9212110651").clickConfirm().enterOtp("123456")
				.clickVerifyInvalid().assertErrorMessageForInvalidOtp().clickResendOtp().clickEditMobileNumber();

	}

	@Test(groups = { "", "sanity" })
	public void emailLogin() throws Exception {
		System.out.println("Email login test case");

		String email = commonData.getProperty("userNameGmail");
		String password = commonData.getProperty("passwordGmail");
		System.out.println("After properties loaded in email login");

		HomePage home = new HomePage(driver);
		home.clickContinueBooking().clickMenu().clickLoginButton().clickSignIn().clickEmail().clickPassword()
				.enterEmail(email).enterPassword(password).clickContinue();
		home = new org.treebo.app.pages.HomePage(driver);
		home.clickMenu().assertLogoutButtonPresent();

	}

	@Test(groups = { "login", "sanity" })
	public void forgotpassword() throws Exception {

		String email = commonData.getProperty("userNameGmail");

		HomePage home = new HomePage(driver);
		home.clickContinueBooking().clickMenu().clickLoginButton().clickSignIn().clickEmail().clickPassword().clickForgotPassword()
				.enterEmail(email).clickSendEmail();

	}

}
