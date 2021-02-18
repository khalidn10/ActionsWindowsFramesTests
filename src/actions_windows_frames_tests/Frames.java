package actions_windows_frames_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Set property for location of chromedriver.exe file
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Khalid\\Documents\\Documents\\Courses\\Selenium\\Apps\\chromedriver_win32\\chromedriver.exe");
		
		// Create driver object for Chrome browser
		WebDriver driver = new ChromeDriver();
		
		// Load a website with frames and maximise window
		driver.get("https://jqueryui.com/droppable/");
		//driver.manage().window().maximize();//***
		
		// Print Droppable title
		System.out.println(driver.findElement(By.cssSelector("h1.entry-title")).getText());
		
		// Try to create instance of the small box in frame
		//WebElement smallBox = driver.findElement(By.cssSelector("div#draggable"));
		
		// Create an instance of the #BlackLivesMatter element
		WebElement blm = driver.findElement(By.cssSelector("div#banner-blm h2"));
		// Create instance of Actions class to allow driver to perform action methods
		Actions driverAction = new Actions(driver);
		//***
		driverAction.moveToElement(blm, blm.getSize().getWidth()/2+30, 0)	// #BlackLivesMatter element used as reference as it's in line with scrollbar
					.clickAndHold()											// Click and hold onto scrollbar
					.moveByOffset(0, 100)									// Move the scrollbar down so that frame is in view
					.release()												// Let go of scrollbar
					.build()
					.perform();								
		
		// Create an instance of the frame element
		WebElement droppableFrame = driver.findElement(By.cssSelector("iframe.demo-frame"));
		
		// Switch to frame using frame element 
		driver.switchTo().frame(droppableFrame);
		// Switch to frame using frame index - first need to check how many frames there are in webpage and then use index accordingly
		//System.out.println(driver.findElements(By.tagName("iframe")).size());
		//System.out.println(driver.findElements(By.tagName("frameset")).size());
		//driver.switchTo().frame(0);
		
		// Create instances of the small and big boxes in frame
		WebElement smallBox = driver.findElement(By.cssSelector("div#draggable"));
		WebElement bigBox = driver.findElement(By.cssSelector("div#droppable"));
		
		// Print text within small and big boxes in frame
		System.out.println(smallBox.getText());
		System.out.println(bigBox.getText());
		
		// Click on small and big boxes in frame
		//smallBox.click();//***
		//bigBox.click();
		
		// Check if Droppable title can be printed
		//System.out.println(driver.findElement(By.cssSelector("h1.entry-title")).getText());
		
		// Update the instance of Actions class to switched driver - drag and drop seems to work even without doing this
		//driverAction = new Actions(driver);
		
		// Drag and drop small box into big box
		driverAction.dragAndDrop(smallBox, bigBox).build().perform();
		//*** This step fails without doing one of the following beforehand:
		//*** 1. Maximising window, or 
		//*** 2. Manipulating scrollbar so that frame is in view, or
		//*** 3. Clicking on small box in frame
		
		// Switch back to webpage
		driver.switchTo().defaultContent();
		
		// Check if Droppable title can now be printed again
		System.out.println(driver.findElement(By.cssSelector("h1.entry-title")).getText());
		
		// Try to create another instance of the small box in frame again
		//WebElement smallBox2 = driver.findElement(By.cssSelector("div#draggable"));
		
	}

}
