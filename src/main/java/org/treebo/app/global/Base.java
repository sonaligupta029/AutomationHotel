package org.treebo.app.global;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public class Base {
	
	public static MobileDriver<MobileElement> driver;
	/**
	 * The platform of execution, i.e either ios or android
	 */
	public static final String platform = "android";

	/**
	 * Number of times to retry for stale element exception before actually
	 * throwing the exception
	 */
	public static final int retryCount = 5;

	/**
	 * Time in seconds for explicit wait
	 */
	public static final int explicitWaitTime = 20;
	
	
	/**
	 * According to the execution type as local or device farm
	 */
	public static final boolean isDeviceFarm = false;

}
