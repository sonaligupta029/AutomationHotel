package org.treebo.app.regression.tests;

import org.testng.annotations.Test;
import org.treebo.app.global.TestBaseSetup;

public class Booking extends TestBaseSetup {

//	@Test(groups = { "", "sanity" })
	public void pahLogoutBooking() throws Exception {

		String city = "Pune";

		org.treebo.app.pages.HomePage home = new org.treebo.app.pages.HomePage(driver);
		home.clickContinueBooking().clickCheckIn().clickCheckinDateAfterSwipe().clickCheckOutDateAfterSwipe()
				.clickDestination().clickClearall().enterDestination(city).clickDestination(city).clickRoomConfig()
				.clickAddAdult(0).clickAddKid(0).clickAddAnotherRoom().clickSaveButton().clickSearch().clickQuickBook()
				.enterGuestDetailIfExistInHDPage("Test", "9212110651", "treebohotelstest@gmail.com")
				.clickBookNowButton().clickPayAtHotelSection().clickPayAtHotelProceedButtonWithoutOtp()
				.clickExperienceRateModal().clickBackToHome();

		System.out.println("Waiting");
		Thread.sleep(1000);
		System.out.println("Done");

	}

//	@Test(groups = { "", "sanity" })
	public void pahLoinBooking() throws Exception {

		String city = "Bangalore";

		String email = commonData.getProperty("userNameGmail");
		String password = commonData.getProperty("passwordGmail");

		org.treebo.app.pages.HomePage home = new org.treebo.app.pages.HomePage(driver);
		home.clickContinueBooking().clickMenu().clickLoginButton().clickSignIn().enterEmail(email)
				.enterPassword(password).clickContinue().clickCheckIn().clickCheckinDateAfterSwipe()
				.clickCheckOutDateAfterSwipe().clickDestination().clickClearall().enterDestination(city)
				.clickDestination(city).clickRoomConfig().clickAddAdult(0).clickAddKid(0).clickAddAnotherRoom()
				.clickSaveButton().clickSearch().clickQuickBook().clickEditTravellerInfoButtonIfExist().clearName()
				.enterName("Test").clearPhoneNumber().enterPhoneNumber("9212110651").clearEmail()
				.enterEmail("treebohotelstest@gmail.com").clickBookNowButton().clickPayAtHotelSection()
				.clickPayAtHotelProceedButtonWithoutOtp().clickExperienceRateModal().clickBackToHome();

		System.out.println("Waiting");
		Thread.sleep(1000);
		System.out.println("Done");

	}

//	@Test(groups = { "", "sanity" })
	public void pahGSTBooking() throws Exception {

		String city = "Bangalore";
		String gstin = commonData.getProperty("gstInNumber");

		org.treebo.app.pages.HomePage home = new org.treebo.app.pages.HomePage(driver);
		home.clickContinueBooking().clickCheckIn().clickCheckinDateAfterSwipe().clickCheckOutDateAfterSwipe()
				.clickDestination().clickClearall().enterDestination(city).clickDestination(city).clickRoomConfig()
				.clickAddAdult(0).clickAddKid(0).clickAddAnotherRoom().clickSaveButton().clickSearch().clickQuickBook()
				.clickEditTravellerInfoButtonIfExist().clearName().enterName("Test").clearPhoneNumber()
				.enterPhoneNumber("9212110651").clearEmail().enterEmail("gaurav.kinra@treebohotels.com")
				.clickGstCheckbox().enterGSTIdentificationNumber(gstin).enterGSTCompanyName("treebo")
				.enterGSTCompanyAddress("AMR").clickBookNowButton().clickPayAtHotelSection()
				.clickPayAtHotelProceedButtonWithoutOtp().clickExperienceRateModal().clickBackToHome();

	}

}
