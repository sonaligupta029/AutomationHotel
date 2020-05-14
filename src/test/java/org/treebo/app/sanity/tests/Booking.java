package org.treebo.app.sanity.tests;

import org.testng.annotations.Test;
import org.treebo.app.global.TestBaseSetup;
import org.treebo.app.pages.HomePage;

public class Booking extends TestBaseSetup {
	
	@Test(groups = { "hd", "hdtest", "sanity" }, enabled = true)
	public void hdquickbook() throws Exception {
		String destination = "Bangalore";

		HomePage home = new HomePage(driver);
		home.clickContinueBooking().clickDestination().enterDestination(destination).clickDestination(destination)
				.clickCheckIn().clickCheckinDate(4).clickCheckoutDate(5).clickSearch().clickAvailableTreebo()
				.assertHotelLocationMapSectionDisplayed().assertPricesDisplayed().assertAboutHotelDisplayed()
				.clickAboutHotel().assertAboutHotelModalDisplayed().assertAmenititesSectionDisplayedInAboutHotelModal()
				.clickCloseIcon().assertPoliciesSectionDisplayed().clickPoliciesSection().assertPoliciesModalDisplayed()
				.clickCloseIcon();

	}


}
