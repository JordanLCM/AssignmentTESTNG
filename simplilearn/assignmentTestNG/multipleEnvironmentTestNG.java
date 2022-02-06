package simplilearn.assignmentTestNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import simplilearn.assignmentTestNG.container.BaseContainer;
import simplilearn.assignmentTestNG.container.PagesData;

@Listeners(qc.utils.MyListeners.class)
public class multipleEnvironmentTestNG extends BaseContainer {
	PagesData PageData;
	
	@BeforeTest
	public void MultipleEnv() throws InterruptedException {
		Driver.get(PageData.URL);
		Thread.sleep(2000);
	}

	@Test
	public void SelectionOfBusDetails() throws InterruptedException {
		PageData = new PagesData(Driver);
		PageData.InputData();
		Thread.sleep(1000);
		PageData.CloseExtraBrowser();
		Thread.sleep(1000);
		PageData.ChooseTicket();
		PageData.TakeScreenShot01("Screenshot Report!");
	}

	@AfterSuite
	public void CloseBrowser() throws InterruptedException {
		Thread.sleep(2000);
		Driver.quit();
	}
}
