package businessScenarios;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;
import pageObjects.Chat;
import pageObjects.homePage;
import pageObjects.login;
import utilities.commonOps;
import utilities.utils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Sanity extends utils {

	// public static WebDriver driver;
	Random rnd = new Random();

	private static String mainWindowHandle;
	private static pageObjects.homePage home = new pageObjects.homePage(driver);
	private static pageObjects.login log = new pageObjects.login(driver);
	private static pageObjects.Chat chat = new pageObjects.Chat(driver);

	@BeforeClass
	public static void openBrowser() throws ParserConfigurationException, SAXException, IOException {
		initBrowser(getData("BrowserType"));
		mainWindowHandle = driver.getWindowHandle();
		initExtentReport();
		initElements();
		wait = new WebDriverWait(driver, Long.parseLong(getData("WaitTime")));

	}

	@After
	public void finalizingTest() throws ParserConfigurationException, SAXException, IOException {
		// recoveryTest(driver);
		finilizeExtentReportTest();
	}

	@AfterClass
	public static void closeBrowser() throws ParserConfigurationException, SAXException, IOException {
		finilizeExtentReport();
		// driver.quit();
	}

	@Test
	public void Test1_Enter_Item_Properties()
			throws InterruptedException, ParserConfigurationException, SAXException, IOException, AWTException {

		// 2. Enter item properties + 3. Press continue
		initTest(testName.getMethodName(), "This is Test Number 1 - Enter item properties");
		home.action(getData("Setting"), getData("Shape"), getData("Weight"));
	}

	@Test
	public void Test2_Enter_new_user_details()
			throws InterruptedException, ParserConfigurationException, SAXException, IOException, AWTException {
		initTest(testName.getMethodName(), "This is Test Number 2 - Enter user details");
		// 4. Enter new user details + 5. Press Continue
		log.action(getData("Email"), getData("Phone"), getData("FirstName"), getData("LastName"));
	}

	@Test
	public void Test3_Press_Continue() throws Exception {
		initTest(testName.getMethodName(), "This is Test Number 3 - Press Continue");
		// 7. Press Continue
		chat.clickContinue();
	}

	@Test
	public void Test4_Enter_Address() throws Exception {
		initTest(testName.getMethodName(), "This is Test Number 4 - Enter Address");
		// 8. Enter valid address (e.g. 32 Boylston St, Boston, MA 02116, USA)
		chat.enterAddress(getData("Address"));
	}

	@Test
	public void Test5_Press_Neigther() throws Exception {
		initTest(testName.getMethodName(), "This is Test Number 5 - Press	Neigther");
		// 8. Press Neigther
		chat.clickNeither();
	}

	@Test
	public void Test6_Select_pickup_time() throws Exception {
		initTest(testName.getMethodName(), "This is Test Number 6 - Select pickup time");
		// 10. Select pickup time
		chat.SelectPickUpTime();
	}

	@Test public void test7_Validate_pickup_message() throws Exception { 
		initTest(testName.getMethodName(), "This is Test Number 7 - Validate_pickup_message");
		//11. Validate pickup message
	  
	  chat.ValidatePickupMessage();
	  
	  }
	
	@Test public void test8_End_Order() throws Exception { 
		initTest(testName.getMethodName(), "This is Test Number 8 - End_Order");
	  
	  chat.endOrder();
	  }

	// Rule that Handles test name for logs
	@Rule
	public TestName testName = new TestName();

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		@Override
		protected void starting(final Description description) {
			String methodName = description.getMethodName();
			String className = description.getClassName();
			className = className.substring(className.lastIndexOf('.') + 1);
			System.err.println("Starting JUnit-test: " + className + " " + methodName);
		}
	};

	public static void initElements() {
		PageFactory.initElements(driver, log);
		PageFactory.initElements(driver, home);
		PageFactory.initElements(driver, chat);

	}

}
