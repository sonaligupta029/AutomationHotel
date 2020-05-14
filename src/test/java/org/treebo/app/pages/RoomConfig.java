package org.treebo.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.treebo.app.global.Libraries;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RoomConfig extends Libraries {
	
	@AndroidFindBy(accessibility = "remove-room-button")
	private MobileElement removeRoom_link;

	@AndroidFindBy(accessibility = "add-adult-count-button")
	private List<MobileElement> addAdult_list;

	@AndroidFindBy(accessibility = "subtract-adult-count-button")
	private List<MobileElement> subtractAdult_list;

	@AndroidFindBy(accessibility = "add-kid-count-button")
	private List<MobileElement> addKid_list;

	@AndroidFindBy(accessibility = "subtract-kid-count-button")
	private List<MobileElement> subtractKid_list;

	@AndroidFindBy(accessibility = "add-room-button")
	private MobileElement addRoom_button;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Reset\")")
	private MobileElement reset_link;

	@AndroidFindBy(accessibility = "save-button")
	private MobileElement save_button;
	
	public void init() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public RoomConfig(MobileDriver<MobileElement> driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		init();
	}
	
	public RoomConfig clickRemoveRoom() {
		swipeVerticallyDownTillElementDisplayed(driver, removeRoom_link, 1);
		waitElementToBeClickable(removeRoom_link);
		clickElement(removeRoom_link, driver);
		return this;
	}

	public RoomConfig clickAddAdult(int index) {
		try {
			waitForSeconds(1000);
			waitElementToBeClickable(addAdult_list.get(index));
		} catch (IndexOutOfBoundsException e) {
			swipeVerticallyDown(driver);
			index = 0;
		}
		waitElementToBeClickable(addAdult_list.get(index));
		clickElement(addAdult_list.get(index), driver);
		return this;
	}

	public RoomConfig clickSubtractAdult(int index) {
		try {
			waitElementToBeClickable(subtractAdult_list.get(index));
		} catch (IndexOutOfBoundsException e) {
			swipeVerticallyDown(driver);
			index = 0;
		}
		waitElementToBeClickable(subtractAdult_list.get(index));
		clickElement(subtractAdult_list.get(index), driver);
		return this;
	}

	public RoomConfig clickAddKid(int index) {
		try {
			waitElementToBeClickable(addKid_list.get(index));
		} catch (IndexOutOfBoundsException e) {
			swipeVerticallyDown(driver);
			index = 0;
		}
		waitElementToBeClickable(addKid_list.get(index));
		clickElement(addKid_list.get(index), driver);
		return this;
	}

	public RoomConfig clickSubtractKid(int index) {
		try {
			waitElementToBeClickable(subtractKid_list.get(index));
		} catch (IndexOutOfBoundsException e) {
			swipeVerticallyDown(driver);
			index = 0;
		}
		waitElementToBeClickable(subtractKid_list.get(index));
		clickElement(subtractKid_list.get(index), driver);
		return this;
	}

	public RoomConfig clickAddAnotherRoom() {
		waitElementToBeClickable(addRoom_button);
		clickElement(addRoom_button, driver);
		return this;
	}

	public RoomConfig clickResetLink() {
		waitElementToBeClickable(reset_link);
		clickElement(reset_link, driver);
		return this;
	}

	public HomePage clickSaveButton() {
		waitElementToBeClickable(save_button);
		clickElement(save_button, driver);
		return new HomePage(driver);
	}
	
	public HotelDetails clickSaveButtonHotelDetails() {
		waitElementToBeClickable(save_button);
		clickElement(save_button, driver);
		waitForSeconds(1500);
		return new HotelDetails(driver);
	}

}
