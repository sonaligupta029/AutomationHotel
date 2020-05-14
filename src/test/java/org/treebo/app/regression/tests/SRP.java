package org.treebo.app.regression.tests;

import org.testng.annotations.Test;
import org.treebo.app.global.TestBaseSetup;
import org.treebo.app.pages.HomePage;

public class SRP extends TestBaseSetup {
	String destination1 = "Bangalore";
	String destination2 = "Mumbai";

	@Test(groups = { "srp", "sanity" })
	public void searchFromSRP() throws Exception {

		HomePage home = new HomePage(driver);
		home.clickContinueBooking().clickDestination().enterDestination(destination1).clickDestination(destination1)
				.clickSearch().assertLocationFromHeader(destination1).clickLocationHeader().clickDestination()
				.clearDestination().enterDestination(destination2).clickDestination(destination2)
				.assertLocationFromHeader(destination2);

	}

	// @Test(groups = { "srp", "sanity"})
	public void filters() throws Exception {

		HomePage home = new HomePage(driver);
		home.clickContinueBooking().clickPopularCity("Mumbai").assertPriceFilters();

	}

	@Test(groups = { "srp", "sanity" })
	public void sortByPrice() throws Exception {

		HomePage home = new HomePage(driver);
		home.clickContinueBooking().clickDestination().enterDestination("Bangalore").clickDestination("Bangalore")
				.clickCheckIn().clickCheckinDate(3).clickCheckoutDate(4).clickSearch().clickSortButton()
				.clickPriceLowToHigh().assertHotelSortedByPrice();

	}

	@Test(groups = { "srp", "sanity" })
	public void soldOutAtBottom() throws Exception {

		HomePage home = new HomePage(driver);
		home.clickContinueBooking().clickDestination().enterDestination("Bangalore").clickDestination("Bangalore")
				.clickCheckIn().clickCheckinDate(3).clickCheckoutDate(4).clickSearch().assertSoldOutAtBottom();
	}

	//@Test(groups = { "srp", "sanity" })
	public void homeStayFilter() throws Exception {

		HomePage home = new HomePage(driver);
		home.clickContinueBooking().clickDestination().enterDestination("Coorg").clickDestination("Coorg")
				.clickCheckIn().clickCheckinDate(3).clickCheckoutDate(4).clickSearch().clickHomestayFilter()
				.assertHomeStaysDisplayed();
	}
	
	//@Test(groups = { "srp", "sanity" })
	public void hotelFilter() throws Exception {

		HomePage home = new HomePage(driver);
		home.clickContinueBooking().clickDestination().enterDestination("Coorg").clickDestination("Coorg")
				.clickCheckIn().clickCheckinDate(3).clickCheckoutDate(4).clickSearch().clickHotelFilter()
				.assertHotelDisplayed();
	}

}
