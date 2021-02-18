package actions_windows_frames_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Set property for location of chromedriver.exe file
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Khalid\\Documents\\Documents\\Courses\\Selenium\\Apps\\chromedriver_win32\\chromedriver.exe");
		
		// Create driver object for Chrome browser
		WebDriver driver = new ChromeDriver();
		
		// Load amazon.com website and maximise window
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		// Create instances for "Hello, Sign in" element and searchbox
		WebElement helloSignInElement = driver.findElement(By.cssSelector("a#nav-link-accountList"));
		WebElement searchBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
		
		// Create instance of Actions class to allow driver to perform action methods
		Actions driverAction = new Actions(driver);
		
		// Move mouse to "Hello, Sign in" element to display mouseover drop-down list
		driverAction.moveToElement(helloSignInElement).build().perform();
		// Click on searchbox, enter "laptop" in capitals, select the text and right-click
		driverAction.click(searchBox).keyDown(Keys.SHIFT).sendKeys("laptop").doubleClick().contextClick().build().perform();
		
	}

}
