package org.treebo.app.pages;

import org.openqa.selenium.support.PageFactory;
import org.treebo.app.global.Libraries;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class Rewards extends Libraries {
	
	@AndroidFindBy()
	@iOSFindBy()
	private MobileElement signupForRewardsPoints_button;
	
	@AndroidFindBy()
	@iOSFindBy()
	private MobileElement close;
	
	private MobileDriver<MobileElement> driver;
	
	public void init() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public Rewards(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		init();
	}
	
	public Login clickSignUpForRewardPoints(){
		waitElementToBeClickable(signupForRewardsPoints_button);
		clickElement(signupForRewardsPoints_button, driver);
		return new Login(driver);
	}
	
	public HomePage clickClose(){
		waitElementToBeClickable(close);
		clickElement(close, driver);
		return new HomePage(driver);
	}

}
