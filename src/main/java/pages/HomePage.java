package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class HomePage extends PageBase {
    //locators
    private final By checkInBtn = By.cssSelector("div [class=\"i1nr4t79 dir dir-ltr\"] [data-testid=\"checkin\"]");
    private final By rightRow = By.cssSelector("[class=\"cdfgcv7 rgl4t1u dir dir-ltr\"]");
    //variables
    //Constractor
    public HomePage(WebDriver driver) {
        super(driver);
    }
    //action
    public void ClickOnCheckInDate() {
        expwait();
        click1(checkInBtn);
        expwait();
        new HomePage(driver);
    }
    public void SelectCheckInDate() {
        LocalDate localDate = LocalDate.now();
        String strDay = localDate.toString();
        String[] partsss = strDay.split("-");
        String striDay = partsss[1];
        String striDay3 = partsss[2];
        var currentDay = "[data-testid=\"" + striDay + "-" + striDay3 + "-daytext\"]";
        var checkInDay = By.cssSelector("div[class=\"dg7nl1z dir dir-ltr\"]" + " " + currentDay);
        expwait();
        click1(checkInDay);
        new HomePage(driver);
    }
    public void SelectCheckoutDateInTheSameMonths(int Days) {
        expwait();
        LocalDate localDate1 = LocalDate.now().plusDays(Days);
        String strDay2 = localDate1.toString();
        String[] partssss = strDay2.split("-");
        String striiDay = partssss[1];
        String striiDay3 = partssss[2];
        expwait();
        var checkOutDay = "[data-testid=\"" + striiDay + "-" + striiDay3 + "-daytext\"]";
        var checkOutDayBtn = By.cssSelector("div[class=\"dg7nl1z dir dir-ltr\"]" + " " + checkOutDay);
        expwait();
        click1(checkOutDayBtn);
        new HomePage(driver);
    }

    public void SelectCheckoutDateInDifferentMonths (int Days) {
        expwait();
        LocalDate localDate1 = LocalDate.now().plusDays(Days);
        String strDay2 = localDate1.toString();
        String[] partssss = strDay2.split("-");
        String striiDay = partssss[1];
        String striiDay3 = partssss[2];
        expwait();
        var checkOutDay = "[data-testid=\"" + striiDay + "-" + striiDay3 + "-daytext\"]";
        var checkOutDayBtn = By.cssSelector("div[class=\"dg7nl1z dir dir-ltr\"]" + " " + checkOutDay);
        expwait();
        LocalDate localDate = LocalDate.now();
        String currentMonthStr = localDate.getMonth().toString().toLowerCase();
        String checkOutMonthStr = localDate1.getMonth().toString().toLowerCase();
        int currentMonthInt = switch (currentMonthStr) {
            case "january" -> 1;
            case "february" -> 2;
            case "march" -> 3;
            case "april" -> 4;
            case "may" -> 5;
            case "june" -> 6;
            case "july" -> 7;
            case "august" -> 8;
            case "september" -> 9;
            case "october" -> 10;
            case "november" -> 11;
            case "december" -> 12;
            default -> 0;
        };

        int checkOutMonthInt = switch (checkOutMonthStr) {
            case "january" -> 1;
            case "february" -> 2;
            case "march" -> 3;
            case "april" -> 4;
            case "may" -> 5;
            case "june" -> 6;
            case "july" -> 7;
            case "august" -> 8;
            case "september" -> 9;
            case "october" -> 10;
            case "november" -> 11;
            case "december" -> 12;
            default -> 0;
        };

        for (int i = currentMonthInt;i <checkOutMonthInt ; i++){
            click1(rightRow);
        }
        expwait();
        click1(checkOutDayBtn);
        new HomePage(driver);
    }

}
