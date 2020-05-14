package org.treebo.app.regression.tests;

import org.testng.annotations.Test;
import org.treebo.app.global.TestBaseSetup;

public class Confirmation extends TestBaseSetup {

	//@Test(groups = { "confirmation", "sanity" }, enabled = true)
	public void testConfirmation() throws Exception {

		org.treebo.app.pages.HomePage home = new org.treebo.app.pages.HomePage(driver);
		home.clickSearchWithoutDestination().enterDestination("Bengaluru").clickDestination("Bengaluru")
				.clickRoomConfig().clickAddAdult(0).clickAddKid(0).clickAddAnotherRoom().clickSaveButton()
				// .clickCheckIn()
				// .swipeDown()
				// .clickDate(3).clickDate(4)
				.clickSearch().clickQuickBook().clickAddGuestDetails().enterName("test").enterPhoneNumber("9854675213")
				.enterEmail("test@test.com").clickContinueToCheckoutButton().assertPrepaidPaymentSectionDisplayed()
				.assertPayAtHotelSectionDisplayed().clickPayAtHotelSection().clickPayAtHotelProceedButtonWithoutOtp()
				.clickExperienceRateModal().printTrb().assertNumberOfNights(1).assertGuestConfig(3, 1).assertNumberOfRooms(2);

	}

}
