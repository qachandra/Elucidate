package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CoursePage1 {
	WebDriver driver = null;

	By pageTitle = By.xpath("//strong[contains(.,'FINDING THE TRUTH')]");
	By startBtn = By.id("pa_5c9126fe3b767_p15577f075e9-button__text");
	By statBtn2 = By.xpath("//span[contains(.,'START')]");
	By p1Image1 = By.id("pa_5c9126fe3b767_p1553447461d-image");

	public CoursePage1(WebDriver driver) {

		this.driver = driver;
	}

	// get page header text
	public String getPageTitleText() throws InterruptedException {
		Thread.sleep(1000);
		return driver.findElement(pageTitle).getText();
	}

	// Click START button
	public void clickStartBtn() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(startBtn).click();
	}

	// get START Button text
	public String getStartBtntext() {
		return driver.findElement(statBtn2).getText();

	}
	
	// get START Button text
		public String getImage1Text() {
			return driver.findElement(p1Image1).getText();

		}
	

}
