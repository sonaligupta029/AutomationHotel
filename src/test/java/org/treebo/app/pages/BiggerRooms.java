package org.treebo.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.treebo.app.global.Libraries;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BiggerRooms extends Libraries {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"View bigger rooms\")")
	private MobileElement viewBiggerRoom_linkModal;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Premium Room\")")
	private MobileElement mahogany_text;
	
	@AndroidFindBy(accessibility = "change-room-type-button")
	private MobileElement roomType_radio;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"SAVE\")")
	private MobileElement saveRoomType;
	

	@Override
	public void init() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public BiggerRooms (MobileDriver<MobileElement> driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		init();
	}
	
	public BiggerRooms clickViewBiggerRoomInModal() {
		swipeVerticallyDownTillElementDisplayed(driver, viewBiggerRoom_linkModal, 4);
		waitElementToBeClickable(viewBiggerRoom_linkModal);
		clickElement(viewBiggerRoom_linkModal, driver);
		return this;
	}
	
	public BiggerRooms clickMapleRoom() {
		swipeVerticallyDownTillElementDisplayed(driver, mahogany_text, 3);
		swipeVerticallyDown(driver);
		waitElementToBeClickable(mahogany_text);
		swipeVerticallyDownTillElementDisplayed(driver, roomType_radio, 1);
		clickElement(roomType_radio, driver);
		return this;
	}
	
	public HotelDetails clickSaveRoomType() {
		waitElementToBeClickable(saveRoomType);
		clickElement(saveRoomType, driver);
		return new HotelDetails(driver);
	}

}
