package pageObjects;

import java.awt.AWTException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;
import static org.junit.Assert.fail;
import com.relevantcodes.extentreports.LogStatus;

import utilities.extentReportManager;
import utilities.utils;

//import utilities.utils;

public class homePage extends utils {
	// WebDriverWait wait = new WebDriverWait(driver,20);
	public homePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//div[@data-automation='solitaire']/span")
	public WebElement solitaire;

	@FindBy(how = How.XPATH, using = "//div[@data-automation='bridal-set']/span")
	public WebElement bridalset;

	@FindBy(how = How.XPATH, using = "//div[@data-automation='3-stone']/span")
	public WebElement stone3;

	@FindBy(how = How.XPATH, using = "//div[@data-automation='halo']/span")
	public WebElement halo;

	@FindBy(how = How.XPATH, using = "//div[@data-automation='loose']/span")
	public WebElement loose;

	@FindBy(how = How.XPATH, using = "//div[@data-automation='other']/span")
	public WebElement otherSetting;

	@FindBy(how = How.XPATH, using = "//div[@data-automation='round']/span")
	public WebElement round;

	@FindBy(how = How.XPATH, using = "//div[@data-automation='princess']/span")
	public WebElement princess;

	@FindBy(how = How.XPATH, using = "//div[@data-automation='cushion']/span")
	public WebElement cushion;

	@FindBy(how = How.XPATH, using = "//div[@data-automation='marquise']/span")
	public WebElement marquise;

	@FindBy(how = How.XPATH, using = "//div[@data-automation='emerald']/span")
	public WebElement emerald;

	@FindBy(how = How.XPATH, using = "//div[@data-automation='other']/span")
	public WebElement otherShape;

	@FindBy(how = How.ID, using = "input-carat-weight")
	public WebElement weightItem;

	@FindBy(how = How.CSS, using = "button[type='submit']")
	public WebElement submit;

	public void action(String setting, String shape, String weight)
			throws InterruptedException, ParserConfigurationException, SAXException, IOException, AWTException {
		// solitaire.click();
		itemSetting(setting);
		itemShape(shape);
		itemweight(weight);
		 submitClick();
	}

	public void itemSetting(String setting)
			throws ParserConfigurationException, SAXException, IOException, AWTException {
		try {
			switch (setting.toLowerCase()) {
			case "solitaire":
				solitaire.click();
				break;
			case "bridalset":
				bridalset.click();
				break;
			case "stone3":
				stone3.click();
				break;
			case "halo":
				halo.click();
				break;
			case "loose":
				loose.click();
				break;
			case "other":
				otherSetting.click();
				break;
			default:
				test.log(LogStatus.FAIL, setting + " : Wrong Selection");
				fail("Problem with setting Tab, See Report for more Details");
				break;
			}
			test.log(LogStatus.PASS, setting + " Was Selected Successfully");
		} catch (Exception exp) {
			test.log(LogStatus.FAIL, "Problem with setting Tab, Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with setting Tab, See Report for more Details");
		}
	}

	public void itemShape(String shape) throws ParserConfigurationException, SAXException, IOException, AWTException {
		try {
			switch (shape.toLowerCase()) {
			case "round":
				round.click();
				break;
			case "princess":
				princess.click();
				break;
			case "cushion":
				cushion.click();
				break;
			case "marquise":
				marquise.click();
				break;
			case "emerald":
				emerald.click();
				break;
			case "othershape":
				otherShape.click();
				break;
			default:
				test.log(LogStatus.FAIL, shape + " : Wrong Selection");
				fail("Problem with shape Tab, See Report for more Details");
				break;
			}
			test.log(LogStatus.PASS, shape + " Was Selected Successfully");
		} catch (Exception exp) {
			test.log(LogStatus.FAIL, "Problem with shape Tab, Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with shape Tab, See Report for more Details");
		}
	}

	public void itemweight(String weight) throws ParserConfigurationException, SAXException, IOException, AWTException {
		try {
			weightItem.sendKeys(weight);
			weightItem.sendKeys(Keys.ENTER);
			test.log(LogStatus.PASS, weight + " Was Selected Successfully");
		} catch (

		Exception exp) {
			test.log(LogStatus.FAIL, "Problem with Filling weight, Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with weight, See Report for more Details");
		}
	}

	public void submitClick() throws ParserConfigurationException, SAXException, IOException, AWTException {
		try {
			submit.click();
			test.log(LogStatus.PASS, " submitClick Was submit Successfully");
		} catch (

		Exception exp) {
			test.log(LogStatus.FAIL, "Problem with submit Tab, Error Message: " + exp.getMessage()
					+ test.addScreenCapture(extentReportManager.CaptureScreen(timeStamp)));
			fail("Problem with submit Tab, See Report for more Details");
		}
	}

}
