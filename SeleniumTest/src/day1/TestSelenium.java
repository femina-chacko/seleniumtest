// ++++++++++++
// CODE SAMPLE
// ++++++++++++
// This is a test automation script. This script will open Chrome browser, 
// navigate to tanzil.net, get the page title and output the title 
// in the eclipse console. Finally it will close the Chrome browser.

package day1;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/feminachacko/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.calculator.net/carbohydrate-calculator.html");
		System.out.println(driver.getTitle());
		driver.quit();
	}
}