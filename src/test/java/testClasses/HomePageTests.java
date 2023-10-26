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
        driver.get("https://www.airbnb.com/a/stays/United-States?&c=.pi0.pk1468961678_62676057731&localized_ghost=true&gclid=Cj0KCQjwhL6pBhDjARIsAGx8D5_Upnm-LAo9NwIioIYAzBWSgkWH5ZGt5YW7pn7bP9uQcvQ3rxpWLUQaArwxEALw_wcB&gclsrc=aw.ds");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void selectDateInSameMonth(){
    homePage.ClickOnCheckInDate();
    homePage.SelectCheckInDate();
    homePage.SelectCheckoutDateInTheSameMonths(3);

    }

    @Test(priority = 2)
    public void selectDateInOtherMonth(){
        homePage.ClickOnCheckInDate();
        homePage.SelectCheckInDate();
        homePage.SelectCheckoutDateInDifferentMonths(30);
    }
    @AfterTest
    public void tearDown() throws InterruptedException{
         Thread.sleep(2000);
        driver.quit();
    }
}
