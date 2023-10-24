package pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.Month;
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

        Month compairMonthsStr1 = localDate.getMonth();
        System.out.println(compairMonthsStr1);






        var daaay = "[data-testid=\"" + striDay + "-daytext\"]";
        //System.out.println(daaay);
        var day = By.cssSelector("div[class=\"dg7nl1z dir dir-ltr\"] " + daaay);

        expwait();
        click1(day);
        expwait();

        LocalDate localDate1 = LocalDate.now().plusDays(20);
        String strDay2 = localDate1.toString();

        String[] partssss = strDay2.split("2023-");
        String striiDay = partssss[1];

        Month compairMonthsStr2 = localDate1.getMonth();
        System.out.println(compairMonthsStr2);


        var daaayy = "[data-testid=\"" + striiDay + "-daytext\"]";
        expwait();
        var dayy = By.cssSelector("div[class=\"dg7nl1z dir dir-ltr\"] " + daaayy);




        int c = switch (compairMonthsStr1) {
            case JANUARY -> 1;
            case FEBRUARY -> 2;
            case MARCH -> 3;
            case APRIL -> 4;
            case MAY -> 5;
            case JUNE -> 6;
            case JULY -> 7;
            case AUGUST -> 8;
            case SEPTEMBER -> 9;
            case OCTOBER -> 10;
            case NOVEMBER -> 11;
            case DECEMBER -> 12;
        };

        int f = switch (compairMonthsStr2) {
            case JANUARY -> 1;
            case FEBRUARY -> 2;
            case MARCH -> 3;
            case APRIL -> 4;
            case MAY -> 5;
            case JUNE -> 6;
            case JULY -> 7;
            case AUGUST -> 8;
            case SEPTEMBER -> 9;
            case OCTOBER -> 10;
            case NOVEMBER -> 11;
            case DECEMBER -> 12;
        };

        System.out.println(c);
        System.out.println(f);


        if ( c == f) {
            expwait();
            click1(dayy);
            expwait();

        } else if (c < f) {


            for (int i = c; i < f; i++) {

                expwait();
                click1(rightRow);
                expwait();
            }

        }
        expwait();
        click1(dayy);
        expwait();

        new HomePage(driver);

    }
}