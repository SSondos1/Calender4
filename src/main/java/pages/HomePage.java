package pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HomePage extends PageBase {
    //locators
    private By checkInBtn = By.cssSelector("[class=\"i16cvsa4 n1nty364 dir dir-ltr\"] [id = \"checkin_input\"]");

    //variables
    int ParseMonth;

    //Constractor
    public HomePage(WebDriver driver) {
        super(driver);
    }
    //action

    public void SelectDate() {
        expwait();
        click1(checkInBtn);
        expwait();

        new HomePage(driver);
    }

    public void CompareDate() {

        var rightRow = By.cssSelector("[class=\"cdfgcv7 rgl4t1u dir dir-ltr\"]");

        LocalDate localDate = LocalDate.now();
        String strDay = localDate.toString();
        System.out.println(strDay);

        String[] partsss = strDay.split("2023-");
        String striDay = partsss[1];

        var daaay = "[data-testid=\"" + striDay + "-daytext\"]";
        //System.out.println(daaay);
        var day = By.cssSelector("div[class=\"dg7nl1z dir dir-ltr\"] " + daaay);

        LocalDate localDate1 = LocalDate.now().plusDays(20);
        String strDay2 = localDate1.toString();
        System.out.println(strDay2);

        String[] partssss = strDay2.split("2023-");
        String striiDay = partssss[1];

        var daaayy = "[data-testid=\"" + striiDay + "-daytext\"]";
        //System.out.println(daaayy);
        expwait();
        var dayy = By.cssSelector("div[class=\"dg7nl1z dir dir-ltr\"] " + daaayy);
        expwait();

        click1(day);

        expwait();
        click1(rightRow);
        expwait();
        click1(dayy);

        new HomePage(driver);

    }
}