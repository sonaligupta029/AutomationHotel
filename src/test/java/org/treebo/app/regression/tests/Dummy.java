package org.treebo.app.regression.tests;

import org.testng.annotations.Test;
import org.treebo.app.global.TestBaseSetup;
import org.treebo.app.pages.HomePage;

public class Dummy extends TestBaseSetup {

	//@Test(priority = 1, groups = { "dummy" })
	public void firstTestCase() throws Exception {

		System.out.println("in 1st test case");
		HomePage home = new HomePage(driver);
		// new
		// HomePage(driver).clickSearchWithoutDestination().clickBangalore().clickSearchWithoutDestination();
		home.clickContinueBooking().clickDestination().clickClearall().enterDestination("Bangalore")
				.clickDestination("Bangalore").clickSearch();
		Thread.sleep(4000);

	}

	//@Test(priority = 2, groups = {"dummy"} , enabled = true)
	public void SecondTestCase() throws Exception {
		System.out.println("in 2st test case");
		new HomePage(driver).clickContinueBooking().clickSearchWithoutDestination();
		Thread.sleep(4000);

	}

}
