package org.treebo.app.global;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

@SuppressWarnings("deprecation")
public abstract class Libraries extends Base {

	public abstract void init();

	/**
	 * It is used to retry clicking on a web element ignoring stale element
	 * exception for 3 times. It also tries to click by actions class and scrolling
	 * to the element by javascript executor if webdriver exception is encountered.
	 * 
	 * @param element The mobile element upon whom the click action needs to be
	 *                performed.
	 * @param driver  Instance of mobile driver.
	 */
	public void clickElement(MobileElement element, MobileDriver<MobileElement> driver) {
		int i = 0;
		while (i < retryCount) {
			try {
				waitForSeconds(500);
				element.click();
				return;
			} catch (StaleElementReferenceException e) {
				i++;
				waitForSeconds(1000);
				init();
				if (i == retryCount) {
					System.out.println("Attempted : " + i + " time, but not successfull. So throwing exception");
					throw e;
				}
			} catch (WebDriverException e) {
				waitForSeconds(1000);
				try {
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					return;
				} catch (WebDriverException ex) {
					i++;
					if (i == retryCount) {
						System.out.println("Attempted : " + i + " time, but not successfull. So throwing exception");
						throw ex;
					}
				}
			}
		}
	}

	/**
	 * To wait for a certain short period.
	 * 
	 * @param timeInMilliSeconds Duration to wait in milliseconds.
	 */
	public void waitForSeconds(int timeInMilliSeconds) {
		try {
			Thread.sleep(timeInMilliSeconds);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * It is used to retry clearing a web element ignoring stale element exception
	 * for 3 times.
	 * 
	 * @param element The mobile element upon whom the clear action needs to be
	 *                performed.
	 * @param driver  Instance of mobile driver
	 */
	public void clearElement(MobileElement element, MobileDriver<MobileElement> driver) {
		int i = 0;
		while (i < retryCount) {
			try {
				element.clear();
				waitForSeconds(500);
				element.clear();
				return;
			} catch (StaleElementReferenceException e) {
				i++;
				waitForSeconds(1000);
				init();
				if (i == retryCount) {
					throw e;
				}
			}
		}
	}

	/**
	 * It is used to retry send keys on a web element ignoring stale element
	 * exception for 3 times.
	 * 
	 * @param element  The mobile element upon whom the send keys action needs to be
	 *                 performed.
	 * @param sendkeys The string that needs to be typed
	 * @param driver   Instance of mobile driver
	 */
	public void sendkeysElement(MobileElement element, String sendkeys, MobileDriver<MobileElement> driver) {
		int i = 0;
		while (i < retryCount) {
			try {
				element.sendKeys(sendkeys);
				return;
			} catch (StaleElementReferenceException e) {
				i++;
				waitForSeconds(1000);
				init();
				if (i == retryCount) {
					throw e;
				}
			}
		}
	}

	/**
	 * 
	 * @param element Mobile element for which we need to check the presence
	 * @param driver  Instance of the driver upon where the mobile element needs to
	 *                be checked
	 * @return <code>true</code> if the element is Displayed in. <code>false</code>
	 *         otherwise
	 */
	public boolean isElementPresent(MobileElement element, MobileDriver<MobileElement> driver) {
		int i = 0;
		while (i < retryCount) {
			try {
				element.isDisplayed();
				return true;
			} catch (StaleElementReferenceException e) {
				i++;
				waitForSeconds(1000);
				waitElementToBeVisible(element, driver);
				System.out.println("Waited for 1 sec before trying again");
				init();
				if (i == retryCount) {
					System.out.println("Tried for " + i + " time, but unsuccessful, hence throwing exception");
					throw e;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param elements List of mobile elements for which we need to check the
	 *                 presence
	 * @param driver   Instance of the driver upon where the list of mobile elements
	 *                 needs to be checked
	 * @return <code>true</code> if the size of the list of mobile elements is
	 *         greater than 0 <code>false</code> otherwise
	 */
	public boolean isElementPresent(List<MobileElement> elements, MobileDriver<MobileElement> driver) {
		int i = 0;
		while (i < retryCount) {
			try {
				if (elements.size() > 0) {
					return true;
				}
			} catch (StaleElementReferenceException e) {
				i++;
				waitForSeconds(1000);
				System.out.println("Waited for 1 sec before trying again");
				init();
				if (i == retryCount) {
					System.out.println("Tried for " + i + " time, but unsuccessful, hence throwing exception");
					throw e;
				}
			}
		}
		return false;
	}

	/**
	 * Used to generate a random alpha numeric String of a given length.
	 * 
	 * @param length Length of the String
	 * @return A random alpha numeric String with the given length.
	 */
	@SuppressWarnings("deprecation")
	public String getRandomAlphanumericString(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	/**
	 * Used to generate a random number between the specified range
	 * 
	 * @param min Minimum value of the random number
	 * @param max Maximum value of the random number
	 * @return A random number in the given range
	 */
	public int getRandomNumberInRange(int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

	/**
	 * Used to generate a random number for a given length.
	 * 
	 * @param length Number of digits of the number generated
	 * @return A numeric String of the given length
	 */
	@SuppressWarnings("deprecation")
	public String getRandomNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	/**
	 * To check if a number lies between its maximum and minimum bound
	 * 
	 * @param number The number which should lie between the max and min value
	 * @param max    The maximum value of the number
	 * @param min    The minimum value of the number
	 * @return <code>true</code> if the number lies between the max and minimum
	 *         value <code>false</code> otherwise
	 */
	public boolean isNumberBetweenSpecifiedRange(int number, int max, int min) {
		if (number >= min) {
			if (number <= max) {
				return true;
			}
		}
		return false;
	}

	/**
	 * To check if a number lies between its maximum and minimum bound
	 * 
	 * @param number The number which should lie between the max and min value
	 * @param max    The maximum value of the number
	 * @param min    The minimum value of the number
	 * @return <code>true</code> if the number lies between the max and minimum
	 *         value <code>false</code> otherwise
	 */
	public boolean isNumberBetweenSpecifiedRange(double number, double max, double min) {
		if (number >= min) {
			if (number <= max) {
				return true;
			}
		}
		return false;
	}

	/**
	 * It is used to retry waiting for an element to be click able on a web element
	 * ignoring stale element exception for 3 times.
	 * 
	 * @param element The mobile element which needs to be click able
	 */
	public void waitElementToBeClickable(MobileElement element) {
		int i = 0;
		while (i < retryCount) {
			try {
				// System.out.println("driver object" + driver);
				WebDriverWait wait = new WebDriverWait(driver, explicitWaitTime);
				waitElementToBeVisible(element, driver);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				return;
			} catch (StaleElementReferenceException e) {
				i++;
				waitForSeconds(1000);
				init();
				if (i == retryCount) {
					System.out.println("Attempted : " + i + " time, but not successfull. So throwing exception");
					throw e;
				}
			} catch (WebDriverException e) {
				i++;
				waitForSeconds(1000);
				if (i == retryCount) {
					System.out.println("Attempted : " + i + " time, but not successfull. So throwing exception");
					throw e;
				}
			} catch (IndexOutOfBoundsException e) {
				i++;
				waitForSeconds(1000);
				if (i == retryCount) {
					System.out.println("Attempted : " + i + " time, but not successfull. So throwing exception");
					throw e;
				}
			}
		}
	}

	/**
	 * It is used to retry waiting for an element to be visible on a mobile element
	 * ignoring stale element exception for 3 times.
	 * 
	 * @param element The mobile element which needs to be visible
	 * @param driver  Instance of mobile driver
	 */
	public void waitElementToBeVisible(WebElement element, MobileDriver<MobileElement> driver) {
		WebDriverWait wait = new WebDriverWait(driver, explicitWaitTime);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
		wait.until(ExpectedConditions.visibilityOf(element));
		return;
	}


	/**
	 * It is used to retry fetching text from a web element ignoring stale element
	 * exception for 3 times.
	 * 
	 * @param element The web element from which text needs to be fetched
	 * @param driver  the instance of mobile driver
	 * @return The text of the web element
	 */
	public String getTextFromElement(MobileElement element, MobileDriver<MobileElement> driver) {
		int i = 0;
		while (i < retryCount) {
			try {
				String text = element.getText();
				return text;
			} catch (StaleElementReferenceException e) {
				i++;
				waitForSeconds(1000);
				init();
				if (i == retryCount) {
					System.out.println("Attempted : " + i + " time, but not successfull. So throwing exception");
					throw e;
				}
			}
		}
		return null;
	}

	/**
	 * It is used to retry fetching attribute value from a mobile element ignoring
	 * stale element exception for 3 times.
	 * 
	 * @param element   The mobile element from which text needs to be fetched
	 * @param attribute The attribute whose value needs to be fetched
	 * @param driver    the instance of mobile driver
	 * @return The value of the attribute of the given mobile element.
	 */
	public String getAttributeFromElement(MobileElement element, String attribute, MobileDriver<MobileElement> driver) {
		int i = 0;
		String text = null;
		while (i < retryCount) {
			try {
				text = element.getAttribute(attribute);
				return text;
			} catch (StaleElementReferenceException e) {
				i++;
				waitForSeconds(1000);
				init();
				if (i == retryCount) {
					System.out.println("Attempted : " + i + " time, but not successfull. So throwing exception");
					throw e;
				}
			}
		}
		return text;
	}

	/**
	 * It is used to retry send keys on a mobile element ignoring stale element
	 * exception for 3 times.
	 * 
	 * @param element              The mobile element upon whom the send keys action
	 *                             needs to be performed.
	 * @param sendkeys             The string that needs to be typed
	 * 
	 * @param timeBetweenCharacter time to wait between typing character
	 * @param driver               the instance of mobile driver;
	 */
	public void sendkeysElementByCharacter(MobileElement element, String sendkeys, int timeBetweenCharacter,
			MobileDriver<MobileElement> driver) {
		int i = 0;
		while (i < retryCount) {
			try {
				for (int j = 0; j < sendkeys.length(); j++) {
					String str = Character.toString(sendkeys.charAt(j));
					TouchAction action = new TouchAction(driver);
					action.tap(element).perform();
					element.sendKeys(str);
					waitForSeconds(timeBetweenCharacter);
				}
				return;
			} catch (StaleElementReferenceException e) {
				i++;
				waitForSeconds(1000);
				init();
				if (i == retryCount) {
					throw e;
				}
			}
		}
	}

	public void pressEnter(MobileDriver<MobileElement> driver) {
		if (driver instanceof AndroidDriver)
			((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.ENTER);
		else
			throw new UnsupportedOperationException("IOS does not allow keycodes.\nClick on submit element.");
	}

	public void swipeVerticallyDown(MobileDriver<MobileElement> driver) {

		Dimension dim = driver.manage().window().getSize();
		// System.out.println("Dimension x : " +dim.width);
		// System.out.println("Dimension y : " +dim.height);
		int x_intial = (int) ((int) (dim.width) * (0.66));
		int y_initial = (int) ((int) (dim.height) * (0.75));
		int y_final = (int) ((int) (dim.height) * (0.13));
		TouchAction action = new TouchAction(driver);
		// action.tap(point(x_intial,y_initial)).waitAction(waitOptions(Duration.ofSeconds(1))).moveTo(point(x_intial,y_final)).release().perform();
		action.press(x_intial, y_initial).waitAction(Duration.ofSeconds(1)).moveTo(x_intial, y_final).release()
				.perform();

	}

	public void swipeFastVerticallyDown(MobileDriver<MobileElement> driver) {

		Dimension dim = driver.manage().window().getSize();
		int x_intial = (int) ((int) (dim.width) * (0.66));
		int y_initial = (int) ((int) (dim.height) * (0.75));
		int y_final = (int) ((int) (dim.height) * (0.13));
		TouchAction action = new TouchAction(driver);
		// action.tap(point(x_intial,y_initial)).waitAction(waitOptions(Duration.ofMillis(150))).moveTo(point(x_intial,y_final)).release().perform();
		action.press(x_intial, y_initial).waitAction(Duration.ofMillis(150)).moveTo(x_intial, y_final).release()
				.perform();
		waitForSeconds(1500);
	}

	public void swipeVerticallyDownTillElementDisplayed(MobileDriver<MobileElement> driver, MobileElement element,
			int maxScrollTime) {
		try {
			if (isElementPresent(element, driver)) {
				return;
			}
		} catch (NoSuchElementException e) {
		}

		int scrollTime = 1;
		while (maxScrollTime > scrollTime) {
			scrollTime++;
			swipeVerticallyDown(driver);
			waitForSeconds(500);
			try {
				if (isElementPresent(element, driver)) {
					return;
				}
			} catch (NoSuchElementException e) {
			}
		}
		throw new NoSuchElementException(
				"Element could not be found even after scrolling for : " + scrollTime + " times.");
	}

	public void swipeFastVerticallyDownTillElementDisplayed(MobileDriver<MobileElement> driver, MobileElement element,
			int maxScrollTime) {
		try {
			if (isElementPresent(element, driver)) {
				return;
			}
		} catch (NoSuchElementException e) {
		}

		int scrollTime = 1;
		while (maxScrollTime > scrollTime) {
			scrollTime++;
			swipeFastVerticallyDown(driver);
			waitForSeconds(500);
			try {
				if (isElementPresent(element, driver)) {
					return;
				}
			} catch (NoSuchElementException e) {
			}
		}
		throw new NoSuchElementException(
				"Element could not be found even after scrolling for : " + scrollTime + " times.");
	}

	public void swipeHorizontallyRightToElement(MobileDriver<MobileElement> driver, MobileElement myElement, double a,
			double b, boolean moveLeft) {
		try {
			Dimension dim = driver.manage().window().getSize();
			int x = (int) (dim.width * a);
			System.out.println(x);
			int y = (int) (dim.height * b);
			System.out.println(y);
			if (moveLeft) {
				x = -x;
			}
			System.out.println("after modification " + x);
			TouchAction action = new TouchAction(driver);
			// action.tap(TapOptions.tapOptions().withElement(ElementOption.element(myElement))).waitAction(waitOptions(Duration.ofSeconds(1))).moveTo(point(x,0)).release().perform();
			action.press(myElement).moveTo(x, 0).release().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void swipeVerticallyUp(MobileDriver<MobileElement> driver) {

		Dimension dim = driver.manage().window().getSize();
		// System.out.println("Dimension x : " +dim.width);
		// System.out.println("Dimension y : " +dim.height);
		int x_intial = (int) ((int) (dim.width) * (0.66));
		int y_initial = (int) ((int) (dim.height) * (0.13));
		int y_final = (int) ((int) (dim.height) * (0.75));
		TouchAction action = new TouchAction(driver);
		// action.tap(point(x_intial,y_initial)).waitAction(waitOptions(Duration.ofSeconds(1))).moveTo(point(x_intial,y_final)).release().perform();
		action.press(x_intial, y_initial).waitAction(Duration.ofSeconds(1)).moveTo(x_intial, y_final).release()
				.perform();

	}

	public static void swipeElementToLeft(MobileDriver<MobileElement> driver, MobileElement elementToScroll) {
		Dimension window = driver.manage().window().getSize();
		int x_initial = (int) ((int) (window.width) * (0.90));
		int x_final = (int) ((int) (window.width) * (0.10));
		// Dimension dim = element.getSize();
		Point p = elementToScroll.getCenter();
		// int x_intial = (int) ((int) (dim.width) * (1));
		// int y_initial = (int) ((int) (dim.height) * (1));
		// int x = p.getX();
		int y = p.getY();
		TouchAction action = new TouchAction(driver);
		// action.tap(point(x_initial,y)).waitAction(waitOptions(Duration.ofSeconds(1))).moveTo(point(x_final,y)).release().perform();
		action.press(x_initial, y).waitAction(Duration.ofSeconds(1)).moveTo(x_final, y).release().perform();
	}

	public void swipeElementToLeftTillDisplayed(MobileDriver<MobileElement> driver, MobileElement elementToScroll,
			MobileElement elementToBeVisible, int maxScrollTime) {
		try {
			if (elementToBeVisible.isDisplayed()) {
				return;
			}
		} catch (NoSuchElementException e) {
		}

		int scrollTime = 1;
		while (maxScrollTime > scrollTime) {
			scrollTime++;
			swipeElementToLeft(driver, elementToScroll);
			waitForSeconds(500);
			try {
				if (elementToBeVisible.isDisplayed()) {
					return;
				}
			} catch (NoSuchElementException e) {
			}
		}
		throw new NoSuchElementException(
				"Element could not be found even after scrolling for : " + scrollTime + " times horizontally");

	}

	public Point getCenterOfElement(MobileElement element, MobileDriver<MobileElement> driver) {
		int i = 0;
		while (i < retryCount) {
			try {
				Point pt = element.getCenter();
				return pt;
			} catch (StaleElementReferenceException e) {
				i++;
				waitForSeconds(1000);
				System.out.println("Waited for 1 sec before trying again");
				init();
				if (i == retryCount) {
					System.out.println("Tried for " + i + " time, but unsuccessful, hence throwing exception");
					throw e;
				}
			}
		}
		return null;
	}

	public Dimension getSizeOfElement(MobileElement element, MobileDriver<MobileElement> driver) {
		int i = 0;
		while (i < retryCount) {
			try {
				Dimension dim = element.getSize();
				return dim;
			} catch (StaleElementReferenceException e) {
				i++;
				waitForSeconds(1000);
				System.out.println("Waited for 1 sec before trying again");
				init();
				if (i == retryCount) {
					System.out.println("Tried for " + i + " time, but unsuccessful, hence throwing exception");
					throw e;
				}
			}
		}
		return null;
	}

	public Point getLocationOfElement(MobileElement element, MobileDriver<MobileElement> driver) {
		int i = 0;
		while (i < retryCount) {
			try {
				Point pt = element.getLocation();
				return pt;
			} catch (StaleElementReferenceException e) {
				i++;
				waitForSeconds(1000);
				System.out.println("Waited for 1 sec before trying again");
				init();
				if (i == retryCount) {
					System.out.println("Tried for " + i + " time, but unsuccessful, hence throwing exception");
					throw e;
				}
			}
		}
		return null;
	}

}
