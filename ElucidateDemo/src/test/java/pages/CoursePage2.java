package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursePage2 {
	WebDriver driver = null;

	By pageTitle = By.xpath("//strong[contains(.,'FINDING THE TRUTH')]");
	By p2HeaderTxt = By.xpath("//em[contains(text(),'Press on a case to get started.')]");
	By p2Image1 = By.xpath("//div[contains(@id,'image-1')][@class='card__image']");
	By p2Image2 = By.xpath("//div[contains(@id,'image-2')][@class='card__image']");
	By makingCaseAgainstKevin = By.xpath("//span[contains(.,'Making a case against Kevin')]");
	By WhoToBlame = By.xpath("//span[contains(.,'Who is to blame?')]");

	public CoursePage2(WebDriver driver) {

		this.driver = driver;
	}

//get get page Header text
	public String getp2HeaderText() throws InterruptedException {
		Thread.sleep(1000);
		return driver.findElement(p2HeaderTxt).getText();
	}

//get image reference
	public String getp2Image1Txt() {
		return driver.findElement(p2Image1).getText();

	}

//click  makingCaseAgainstKevin
	public void makingCaseAgainstKevinClick() {
		driver.findElement(makingCaseAgainstKevin).click();

	}

//click  Who to blame
	public void WhoToBlameClick() {
		driver.findElement(WhoToBlame).click();

	}
	
}
