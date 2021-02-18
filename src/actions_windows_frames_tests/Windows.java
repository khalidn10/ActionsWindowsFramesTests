package actions_windows_frames_tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Set property for location of chromedriver.exe file
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Khalid\\Documents\\Documents\\Courses\\Selenium\\Apps\\chromedriver_win32\\chromedriver.exe");
		
		// Create driver object for Chrome browser
		WebDriver driver = new ChromeDriver();
		
		// Load Asda website
		driver.get("https://www.asda.com/");
		
		// Click Asda Facebook icon (opens new tab) and print page title
		driver.findElement(By.cssSelector("i.icon-facebook")).click();
		System.out.println("Page title after opening Asda Facebook page: " + driver.getTitle());
		
		// Retrieve handles to both windows
		Set<String> windowHandles = driver.getWindowHandles();
		
		// Create instance of iterator to iterate window handles
		Iterator<String> windowIterator = windowHandles.iterator();
		
		// Iterate twice through window handles
		String parentWindowHandle = windowIterator.next();
		String childWindowHandle = windowIterator.next();
		
		// Switch to child tab and print page title
		driver.switchTo().window(childWindowHandle);
		System.out.println("Page title after switching to child tab: " + driver.getTitle());
		
		// Close the child tab
		driver.close();
		
		// Switch back to parent tab and print page title
		driver.switchTo().window(parentWindowHandle);
		System.out.println("Page title after switching back to parent tab: " + driver.getTitle());
		
	}
}
