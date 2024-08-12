package day1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class TestMetricUnitCalculation {
	public static WebDriver driver = new ChromeDriver();
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/feminachacko/Downloads/chromedriver");
		
		
		driver.get("https://www.calculator.net/carbohydrate-calculator.html");
		System.out.println(driver.getTitle());
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDefaultCalculation() {
        String metricUnitsTab = "//a[text()='Metric Units']";
        String expectedResultHeader = "Result";
        String dailyCalorieIntake = "//td[text()='Weight Maintenance']/../td[contains(text(),'Calories')]";
        String expectedCalorieIntake = "2,207 Calories";

		driver.findElement(By.xpath(metricUnitsTab)).click(); 
		driver.findElement(By.name("x")).click();
		
		String actualResultHeader = driver.findElement(By.className("h2result")).getText();
		Assertions.assertEquals(actualResultHeader, expectedResultHeader);
		
		Boolean isGoalColumnDisplayed = driver.findElement(By.xpath("//td[text()='Goal']")).isDisplayed();
		Assertions.assertEquals(isGoalColumnDisplayed, true);
		
		Boolean isDailyCalorieColumnDisplayed = driver.findElement(By.xpath("//td[text()='Daily Calorie Allowance']")).isDisplayed();
		Assertions.assertEquals(isDailyCalorieColumnDisplayed, true);
		
		Boolean isFourtyPercentageColumnDisplayed = driver.findElement(By.xpath("//td[text()='40%*']")).isDisplayed();
		Assertions.assertEquals(isFourtyPercentageColumnDisplayed, true);
		
		Boolean isFiftyFivePercentageColumnDisplayed = driver.findElement(By.xpath("//td[text()='55%*']")).isDisplayed();
		Assertions.assertEquals(isFiftyFivePercentageColumnDisplayed, true);
		
		Boolean isSixtyFivePercentageColumnDisplayed = driver.findElement(By.xpath("//td[text()='65%*']")).isDisplayed();
		Assertions.assertEquals(isSixtyFivePercentageColumnDisplayed, true);
		
		Boolean isSeventyFivePercentageColumnDisplayed = driver.findElement(By.xpath("//td[text()='75%*']")).isDisplayed();
		Assertions.assertEquals(isSeventyFivePercentageColumnDisplayed, true);
		
		String actualCalorieIntake = driver.findElement(By.xpath(dailyCalorieIntake)).getText();
		Assertions.assertEquals(expectedCalorieIntake, actualCalorieIntake);


	}
	@Test
	void testFemaleAgeThirty() {
		String femaleRadioButton = "//label[text()='female']";
        String expectedCalorieIntake = "1,944 Calories";
        String dailyCalorieIntake = "//td[text()='Weight Maintenance']/../td[contains(text(),'Calories')]";
		
		driver.findElement(By.xpath(femaleRadioButton)).click(); 
		
		WebElement ageField = driver.findElement(By.id("cage"));
		
		ageField.clear();
		ageField.sendKeys("30");
		
		driver.findElement(By.name("x")).click();
		
		String actualCalorieIntake = driver.findElement(By.xpath(dailyCalorieIntake)).getText();
		Assertions.assertEquals(expectedCalorieIntake, actualCalorieIntake);
		
	}

}
