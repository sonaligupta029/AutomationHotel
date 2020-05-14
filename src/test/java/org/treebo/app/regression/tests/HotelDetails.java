package org.treebo.app.regression.tests;

import org.treebo.api.search.pojo.ResponseSearch;
import org.treebo.api.search.pojo.Result;
import org.treebo.app.global.TestBaseSetup;
import org.treebo.app.pages.HomePage;
import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.treebo.app.pages.SRP;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class HotelDetails extends TestBaseSetup {

	@Test(groups = { "hd", "prod", "prodsanity", "sanity" })
	public void searchSoldOutHotel() throws Exception {
		String hotelName = "Treebo Trend Edge";

		HomePage home = new HomePage(driver);
		home.clickContinueBooking().clickDestination().enterDestination(hotelName).clickDestination(hotelName)
				.clickCheckIn().clickCheckinDate(3).clickCheckoutDate(4).clickRoomConfig().clickAddAdult(0)
				.clickAddAdult(0).clickAddAdult(0).clickSaveButton().clickSearch().waitTillSoldoutDisplayed()
				.assertHotelNameWithIndex(0, hotelName);

	}

	@Test(groups = { "hd", "prod", "prodsanity", "sanity" })
	public void searchAvailableHotel() throws Exception {

		HomePage home = new HomePage(driver);
		String hotelName = home.clickContinueBooking().clickDestination().enterDestination("Bangalore")
				.clickDestination("Bangalore").clickCheckIn().clickCheckinDate(3).clickCheckoutDate(4).clickSearch()
				.waitTillQuickbookDisplayed().getHotelNameWithIndex(0);
		SRP srp = new SRP(driver);
		srp.clickBackArrow();
		home.clickDestination().enterDestination(hotelName).clickDestination(hotelName).clickSearchHotel()
				.assertHotelName(hotelName).assertPricesDisplayed();

	}

	/**
	 * 1) Assert Price is displayed in HotelDetails page
	 * 
	 * 2) Assert Special Deal Banner is displayed in the HotelDetails page
	 * 
	 * 3) Assert free assured essentials are displayed
	 * 
	 * 4) Assert Free Assured Amenities displayed is greater then 1
	 * 
	 * 5) Get all the Free Assured Amenities Name list
	 * 
	 * 6) Assert Hotel Location Map is displayed
	 * 
	 * 7) Assert About Hotel Section is displayed
	 * 
	 * 8) Assert About Hotel Modal is displayed if user clicks on About Hotel
	 * Section in HotelDetails page
	 * 
	 * 9) Assert amenities section is displayed in the About Hotel Modal
	 * 
	 * 10)Assert Hotel Policies is displayed
	 * 
	 * 11) Assert Policies Modal is displayed after clicking on Policies Section
	 */

	@Test(groups = { "hd", "hdtest", "sanity","testinghdquickbook" }, enabled = true)
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

	@Test(groups = { "hd", "hdtest", "sanity" }, enabled = true)
	public void couponTest() throws Exception {
		String destination = "Bangalore";

		HomePage home = new HomePage(driver);
		home.clickContinueBooking().clickDestination().enterDestination(destination).clickDestination(destination)
				.clickCheckIn().clickCheckinDate(3).clickCheckoutDate(4).clickSearch().clickAvailableTreebo()
				.assertHotelLocationMapSectionDisplayed().assertPricesDisplayed().clickApplyRemoveCoupons()
				.clickCrossButtonIfCouponsAreNotThereElseClickCoupon().clickBookNowButton();

	}

	@Test(groups = { "hd", "hdtest", "sanity", "hdtesting" }, enabled = true)
	public void viewBiggerRoom() throws Exception {
		String hotel = "Treebo Trend Rosewood";

		HomePage home = new HomePage(driver);
		home.clickContinueBooking().clickCheckIn().clickCheckinDateAfterSwipe().clickCheckOutDateAfterSwipe()
				.clickDestination().enterDestination(hotel).clickDestination(hotel).clickSearchHotel()
				.assertViewOtherRoomsDisplayed().clickViewOtherRoom().clickViewBiggerRoomInModal().clickMapleRoom()
				.clickSaveRoomType().clickBookNowButton();
	}

	@Test(groups = { "hd", "hdtest", "sanity", "changeConfig" }, enabled = true)
	public void configChange() throws Exception {
		String destination = "Bangalore";

		HomePage home = new HomePage(driver);
		org.treebo.app.pages.HotelDetails hd = home.clickContinueBooking().clickDestination()
				.enterDestination(destination).clickDestination(destination).clickCheckIn().clickCheckinDate(3)
				.clickCheckoutDate(4).clickSearch().clickAvailableTreebo().waitTillPriceLoaded();
		double initialPrice = hd.getPriceFromBottomBar();
		double finalPrice = hd.clickRoomConfig().clickAddAnotherRoom().clickSaveButtonHotelDetails()
				.getPriceFromBottomBar();
		Assert.assertTrue(finalPrice > initialPrice, "Final price after adding room : " + finalPrice
				+ " is not greater that initial price : " + initialPrice);
		hd.clickRoomConfig().clickAddAnotherRoom().clickAddAdult(0).clickAddAdult(0).clickAddAdult(0).clickAddAdult(0)
				.clickAddAdult(0).clickSaveButtonHotelDetails().assertCheckAvailableDatesDisplayed();

	}

	@Test(groups = { "hd", "hdtest", "sanity", "negativeTest","testingcalender","hoteldetails1" }, enabled = true)
	public void negativeTestErrorMessage() throws Exception {
		String destination = "Bangalore";

		HomePage home = new HomePage(driver);
		home.clickContinueBooking().clickDestination().enterDestination(destination).clickDestination(destination)
				.clickCheckIn().clickCheckinDate(3).clickCheckoutDate(4).clickSearch().clickAvailableTreebo()
				.waitTillPriceLoaded().clickBookNowButtonError().clickBookNowButtonError()
				.assertNameErrorMessageDisplayed().assertMobileNumberErrorMessageDisplayed().enterName(" ")
				.enterPhoneNumber("1122334455").enterEmail("aaa.com").assertValidEmailErrorMessageDisplayed()
				.assertValidMobileNumberErrorMessageDisplayed().assertNameErrorMessageDisplayed()
				.clickBookNowButtonError().assertNameErrorMessageDisplayed();

	}

	public void test() {
		Response res = RestAssured.given().get(
				"https://www.treebo.com/api/web/v4/search/?amenity=&category=&checkin=2018-10-25&checkout=2018-10-26&city=Bangalore&distance_cap=false&landmark=&locality=&location_type=&nearby=false&radius=10&roomconfig=1-0&state=");
		System.out.println(res.asString());
		Gson gson = new Gson();
		ResponseSearch rs = gson.fromJson(res.asString(), ResponseSearch.class);
		System.out.println(rs.getStatus());
		ArrayList<Result> result = rs.getData().getResult();
		int[] ids = new int[result.size()];
		int i = 0;
		for (Result resu : result) {
			ids[i] = resu.getId();
			i++;
		}
		System.out.println(Arrays.toString(ids));
		Response res2 = RestAssured.given().get(
				"https://www.treebo.com/api/web/v6/pricing/hotels/?channel=website&checkin=2018-10-25&checkout=2018-10-26&hotel_id=21,691,148,9,8,686,790,584,16,918,805,574,7,444,649,2,26,234,159,644,756,922,408,840,84,22,923,711,151,809,933,580,718,661,716,770,332,645,15&roomconfig=1-0&sort=recommended&utm_source=direct");
		System.out.println(res2.asString());
	}

}
