package org.treebo.app.regression.tests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.openqa.selenium.html5.Location;
import org.testng.annotations.Test;
import org.treebo.app.global.TestBaseSetup;

public class HomePage extends TestBaseSetup {

	// @Test(groups = {"homepage", "sanity", })
	public void test() throws Exception {

		org.treebo.app.pages.HomePage home = new org.treebo.app.pages.HomePage(driver);
		home.clickContinueBooking().clickDestination().clickBangalore().clickSearch().clickQuickBook().getPlanType();
	}

	@Test(groups = { "homepage", "sanity","homepage1" })
	public void searchByLocality() throws Exception {

		String locality = "Koramangala, Bengaluru";
		org.treebo.app.pages.HomePage home = new org.treebo.app.pages.HomePage(driver);
		home.clickContinueBooking().clickDestination().enterDestination(locality).clickDestination(locality)
				.clickSearch().assertLocationFromHeader(locality);

	}

	@Test(groups = { "homepage", "sanity","homepage3" })
	public void searchByLocalityInDb() throws Exception {

		String locality = "Silk board";
		org.treebo.app.pages.HomePage home = new org.treebo.app.pages.HomePage(driver);
		home.clickContinueBooking().clickDestination().enterDestination(locality).clickLocality().clickSearch()
				.assertLocationFromHeader(locality);

	}

	@Test(groups = { "homepage", "sanity" })
	public void searchByLandmark() throws Exception {

		String landmark = "Bangalore Airport";
		org.treebo.app.pages.HomePage home = new org.treebo.app.pages.HomePage(driver);
		home.clickContinueBooking().clickDestination().enterDestination(landmark).clickLandmark().clickSearch()
				.assertLocationFromHeader(landmark);

	}

	@Test(groups = { "homepage", "sanity" })
	public void searchPopularCity() throws Exception {

		// String locality = "Bangalore Airport";
		org.treebo.app.pages.HomePage home = new org.treebo.app.pages.HomePage(driver);
		// home.clickViewAllCities();
		home.clickContinueBooking().clickPopularCity("Goa").assertLocationFromHeader("Goa");

	}

	@Test(groups = { "", "homepage", "sanity" })
	public void searchCityFromViewAllOtherCities() throws Exception {
		String city = "Ahmedabad";
		org.treebo.app.pages.HomePage home = new org.treebo.app.pages.HomePage(driver);
		home.clickContinueBooking().clickViewAllCities().clickCityFromViewAllOtherCities(city)
				.assertLocationFromHeader(city);

	}

	@Test(groups = { "", "homepage", "sanity" })
	public void searchCityFromViewAllPopularCities() throws Exception {
		String city = "Hyderabad";
		org.treebo.app.pages.HomePage home = new org.treebo.app.pages.HomePage(driver);
		home.clickContinueBooking().clickViewAllCities().clickCityFromViewAllPopularCities(city)
				.assertLocationFromHeader(city);

	}

	@Test(groups = { "homepage", "sanity","homepage2" })
	public void selectMultipleRooms() throws Exception {

		org.treebo.app.pages.HomePage home = new org.treebo.app.pages.HomePage(driver);
		home.clickContinueBooking().clickRoomConfig().clickAddAnotherRoom().clickRemoveRoom().clickAddAdult(0)
				.clickAddKid(0).clickAddAdult(0).clickSubtractAdult(0).clickAddAnotherRoom().clickAddAdult(1)
				.clickSaveButton().assertNumberOfAdults(4).assertNumberOfKids(1).assertNumberOfRooms(2)
				.clickRoomConfig().clickResetLink().clickSaveButton().assertNumberOfAdults(1).assertNumberOfKids(0)
				.assertNumberOfRooms(1);

	}

	@Test(groups = { "homepage" })
	public void nearMe() throws Exception {

		Runtime rt = Runtime.getRuntime();

		Process set_mock_app_process = rt.exec("adb shell appops set io.appium.settings android:mock_location allow");
		String set_mock_app_result = new BufferedReader(new InputStreamReader(set_mock_app_process.getInputStream()))
				.lines().collect(Collectors.joining(" "));
		System.out
				.println("adb shell appops set io.appium.settings android:mock_location allow: " + set_mock_app_result);
		driver.setLocation(new Location(12.9706670000, 77.6006940000, 0)); 

		String location = "Near Me";
		org.treebo.app.pages.HomePage home = new org.treebo.app.pages.HomePage(driver);
		home.clickContinueBooking().clickCheckIn().clickCheckinDateAfterSwipe().clickCheckOutDateAfterSwipe()
				.clickDestination().enterDestination(location).clickDestination(location).clickSearch()
				.waitTillQuickbookDisplayed().assertHotelNameWithIndex(0, "Treebo Edge");

	}

}
