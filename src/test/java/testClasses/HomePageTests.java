package testClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests {
    WebDriver driver;
    HomePage homePage;
    @BeforeMethod
    public void setUp (){
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get("https://www.airbnb.com/");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void selectDateInSameMonth(){
        homePage.ClickOnCheckInDate();
        homePage.SelectCheckInDate();
        homePage.SelectCheckoutDateInTheSameMonths(1);
    }

    @Test(priority = 2)
    public void selectDateInOtherMonth(){
        homePage.ClickOnCheckInDate();
        homePage.SelectCheckInDate();
        homePage.SelectCheckoutDateInDifferentMonths(7);
    }

    @Test(priority = 3)
    public void SelectDateInOtherYears(){
        homePage.ClickOnCheckInDate();
        homePage.SelectCheckInDate();
        homePage.SelectCheckoutDateInDifferentYears(5);
    }
   @AfterTest
     public void tearDown(){
       driver.quit();
     }
}
