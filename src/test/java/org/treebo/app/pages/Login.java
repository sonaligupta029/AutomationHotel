package org.treebo.app.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.treebo.app.global.Libraries;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class Login extends Libraries {

	// @AndroidFindBy(uiAutomator = "new
	// UiSelector().className(\"android.widget.EditText\").text(\"Enter Mobile
	// no.\")")
	@AndroidFindBy(accessibility = "enter-phone-number-field")
	@iOSFindBy(accessibility = "enter-phone-number-field")
	private MobileElement mobileNumber_textbox;

	@AndroidFindBy(accessibility = "email-signin-button")
	@iOSFindBy(accessibility = "email-signin-button")
	private MobileElement signIn_link;

	@AndroidFindBy(accessibility = "enter-password-field")
	@iOSFindBy(accessibility = "yet")
	private MobileElement password_textbox;

	@AndroidFindBy(accessibility = "enter-email-address-field")
	@iOSFindBy(accessibility = "yet")
	private MobileElement email_textbox;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\")")
	private MobileElement viewPassword_icon;

	@AndroidFindBy(accessibility = "confirm-button")
	@iOSFindBy(accessibility = "yet")
	private MobileElement confirm_button;

	@AndroidFindBy(accessibility = "input-field-error-text")
	@iOSFindBy(accessibility = "yet")
	private MobileElement errorMessage;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Incorrect OTP verification code.\")")
	@iOSFindBy(accessibility = "yet")
	private MobileElement otpErrorMessage;

	@AndroidFindBy(accessibility = "yet")
	@iOSFindBy(accessibility = "yet")
	private MobileElement clearMobileNumber_icon;

	@AndroidFindBy(accessibility = "forgot-password-button")
	@iOSFindBy(accessibility = "yet")
	private MobileElement forgotPassword_link;

	@AndroidFindBy(accessibility = "continue-button")
	@iOSFindBy(accessibility = "yet")
	private MobileElement continue_button;

	@AndroidFindBy(accessibility = "send-email-button")
	@iOSFindBy(accessibility = "yet")
	private MobileElement sendEmail_button;

	@AndroidFindBy(accessibility = "yet")
	@iOSFindBy(accessibility = "yet")
	private MobileElement edit_link;

	@AndroidFindBy(accessibility = "yet")
	@iOSFindBy(accessibility = "yet")
	private MobileElement resend_link;

	@AndroidFindBy(accessibility = "yet")
	@iOSFindBy(accessibility = "yet")
	private MobileElement done_button;

	@AndroidFindBy(accessibility = "enter-otp-verify-field")
	@iOSFindBy(accessibility = "enter-otp-verify-field")
	private MobileElement otp_textbox;

	@AndroidFindBy(accessibility = "verify-button")
	@iOSFindBy(accessibility = "verify-button")
	private MobileElement verify_button;
	
	@AndroidFindBy(accessibility = "resend-button")
	@iOSFindBy(accessibility = "resend-button")
	private MobileElement resendOtp_link;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Edit\")")
	@iOSFindBy(accessibility = "yet")
	private MobileElement editMobile_link;
	
	@AndroidFindBy(uiAutomator = "icon-header-left")
	@iOSFindBy(accessibility = "icon-header-left")
	private MobileElement close_icon;
	
	

	private MobileDriver<MobileElement> driver;
	
	public void init() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public Login(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		init();
	}

	public Login enterMobileNumber(String mobileNumber) {
		waitElementToBeClickable(mobileNumber_textbox);
		sendkeysElement(mobileNumber_textbox, mobileNumber, driver);
		return this;
	}

	public Login clickSignIn() {
		waitElementToBeClickable(signIn_link);
		clickElement(signIn_link, driver);
		return this;
	}

	public Login enterPassword(String password) {
		waitElementToBeVisible(password_textbox, driver);
		sendkeysElement(password_textbox, password, driver);
		return this;
	}

	public Login clickViewPassword() {
		waitElementToBeClickable(viewPassword_icon);
		clickElement(viewPassword_icon, driver);
		return this;
	}

	public Login clickConfirm() {
		waitElementToBeClickable(confirm_button);
		clickElement(confirm_button, driver);
		return this;
	}

	public Login assertErrorMessageForValidMobileNumber() {
		waitElementToBeVisible(errorMessage, driver);
		Assert.assertTrue(errorMessage.isDisplayed(), "Error message for valid mobile number is not displayed");
		String expected = "Please enter a valid mobile number";
		String fetched = getTextFromElement(errorMessage, driver);
		Assert.assertTrue(fetched.equals(expected), "Expected text : " + expected + ". But fetched : " + fetched);
		return this;
	}

	public Login clickMobileNumber() {
		waitElementToBeClickable(mobileNumber_textbox);
		clickElement(mobileNumber_textbox, driver);
		return this;
	}

	public Login clickClearMobileNumber() {
		waitElementToBeClickable(clearMobileNumber_icon);
		clickElement(clearMobileNumber_icon, driver);
		return this;
	}

	public Login clickEmail() {
		waitElementToBeClickable(email_textbox);
		clickElement(email_textbox, driver);
		return this;
	}

	public Login clickPassword() {
		waitElementToBeClickable(password_textbox);
		clickElement(password_textbox, driver);
		return this;
	}

	public Login clickForgotPassword() {
		waitElementToBeClickable(forgotPassword_link);
		clickElement(forgotPassword_link, driver);
		return this;
	}

	public HomePage clickContinue() {
		waitElementToBeClickable(continue_button);
		clickElement(continue_button, driver);
		return new HomePage(driver);
	}

	public Login clickSendEmail() {
		waitElementToBeClickable(sendEmail_button);
		clickElement(sendEmail_button, driver);
		return this;
	}

	public Login clickEdit() {
		waitElementToBeClickable(edit_link);
		clickElement(edit_link, driver);
		return this;
	}

	public Login clickResend() {
		waitElementToBeClickable(resend_link);
		clickElement(resend_link, driver);
		return this;
	}

	public HomePage clickDone() {
		waitElementToBeClickable(done_button);
		clickElement(done_button, driver);
		return new HomePage(driver);
	}

	public Login enterOtp(String otp) {
		waitElementToBeClickable(otp_textbox);
		sendkeysElement(otp_textbox, otp, driver);
		return this;
	}

	public HomePage clickVerify() {
		clickVerifyInvalid();
		return new HomePage(driver);
	}

	public Login clickVerifyInvalid() {
		waitElementToBeClickable(verify_button);
		clickElement(verify_button, driver);
		return this;
	}

	public Login assertErrorMessageForInvalidOtp() {
		waitElementToBeVisible(otpErrorMessage, driver);
		Assert.assertTrue(otpErrorMessage.isDisplayed(), "Error message for invalid otp is not displayed");
		return this;
	}
	
	public Login clickResendOtp() {
		waitElementToBeClickable(resendOtp_link);
		clickElement(resendOtp_link, driver);
		return this;
	}
	
	public Login clickEditMobileNumber() {
		waitElementToBeClickable(editMobile_link);
		clickElement(editMobile_link, driver);
		return this;
	}
	
	public Login clickCloseIcon() {
		waitForSeconds(3000);
		waitElementToBeClickable(close_icon);
		clickElement(close_icon, driver);
		return this;
	}
	
	public Login clearMobileNumber() {
		waitElementToBeClickable(mobileNumber_textbox);
		clearElement(mobileNumber_textbox, driver);
		return this;
	}
	
	public Login enterEmail(String email) {
		waitElementToBeClickable(email_textbox);
		sendkeysElement(email_textbox, email, driver);
		return this;
	}
}
