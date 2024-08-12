package day1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class TestWebPageTitle {

	@Test
	void test() {
        String metricUnitsTab = "Metric Units";
        String expectedTitle = "Carbohydrate Calculator";
		
		System.setProperty("webdriver.chrome.driver", "/Users/feminachacko/Downloads/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.calculator.net/carbohydrate-calculator.html");
		System.out.println(driver.getTitle());
		
		Assertions.assertEquals(driver.getTitle(), expectedTitle);
		
		System.out.println(metricUnitsTab);
		
		driver.quit();
	}

}
