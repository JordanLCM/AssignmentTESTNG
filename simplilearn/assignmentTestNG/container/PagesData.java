package simplilearn.assignmentTestNG.container;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagesData extends BaseContainer {

	public PagesData(WebDriver Driver) {
		PageFactory.initElements(Driver, this);
	}

	@FindBy(xpath = "//a[@data-id='transMode'][normalize-space()='Buses']	")
	public WebElement Bus;
	@FindBy(xpath = "//input[@placeholder='From: address or city']")
	public WebElement FromPlace;
	@FindBy(xpath = "//input[@placeholder='To: address or city']")
	public WebElement ToPlace;
	@FindBy(xpath = "//input[@placeholder='Departure']")
	public WebElement DepartureDate;
	@FindBy(xpath = "//div[contains(text(),'20')]")
	public WebElement DatePick;
	@FindBy(xpath = "//span[@data-id='header-date']")
	public WebElement DateMonth;
	@FindBy(xpath = "//h6[normalize-space()='Search']")
	public WebElement SearchButton;

	public static String URL = "https://www.wanderu.com/en-us/";
	public static String Month = "February 2022";
	public static String Day = "20";

	public void InputData() throws InterruptedException {
		Bus.click();
		Thread.sleep(2000);
		FromPlace.click();
		FromPlace.sendKeys("Las Vegas, NV, USA");
		Thread.sleep(1000);
		ToPlace.click();
		ToPlace.sendKeys("Los Angeles, CA, USA");
		Thread.sleep(1000);
		DepartureDate.click();
		Thread.sleep(1000);
		while (true) {
			String TextDate = DateMonth.getText();
			if (TextDate.equals(Month)) {
				DatePick.click();
				break;
			} else {
				System.out.println("Failed!");
				break;
			}
		}
		Thread.sleep(1000);
		SearchButton.click();
	}

	public void CloseExtraBrowser() {
		String ParentWindow = Driver.getWindowHandle();
		Set<String> windowHandles = Driver.getWindowHandles();
		Iterator<String> iter = windowHandles.iterator();
		while (iter.hasNext()) {
			String wHandle = iter.next();
			Driver.switchTo().window(wHandle);
			System.out.println(wHandle);
		}
	}

	@FindBy(xpath = "//div[17]//div[1]//div[4]//a[1]//div[1]//span[1]//img[1]")
	public WebElement BusType;
	@FindBy(xpath = "//div[13]//div[1]//div[3]//div[1]//div[1]//div[1]")
	public WebElement FromTime;
	@FindBy(xpath = "//div[contains(text(),'2:30 PM')]")
	public WebElement ToTime;
	@FindBy(xpath = "//div[13]//div[1]//button[1]")
	public WebElement SelectButton;

	public static String BusTypeName = "FlixBus";
	public static String FromTimeType = "9:45 AM";
	public static String ToTimeType = "2:30 PM";

	public void ChooseTicket() throws InterruptedException {
		SelectButton.click();
		Thread.sleep(5000);
	}

	public void TakeScreenShot01(String FileName) {
		File ScreenShot01 = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(ScreenShot01,
					new File("C:/Users/Jordan Liu/eclipse-workspace/qc-maven-project001/Screenshots/" + FileName +""));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
