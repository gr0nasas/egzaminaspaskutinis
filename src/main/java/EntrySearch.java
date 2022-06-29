import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class EntrySearch {

    static String Link = "http://localhost:8080";

    static ChromeDriver browser;

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "src/main/ChromeWebDriver/chromedriver102.exe");
        OpenChrome();
        UserLogin.Login("bandymas", "bandymas", browser);
        SearchEntry(true, browser);
        CloseChrome();

    }

    public static boolean SearchEntry(boolean SupossedtoFail, WebDriver browser) {


        EntryCreation.CreateNewEntry("899", "898", browser);


        browser.findElement(By.xpath("//a[normalize-space()='Atliktos operacijos']")).click();

        List<WebElement> Results;

        if (SupossedtoFail) {

            Results = browser.findElements(By.xpath("//td[contains(.,'IMGOINGTOFAIL')]"));

        } else {

            Results = browser.findElements(By.xpath("//td[contains(.,'1797')]"));
        }

        if (Results.size() > 0) {
            System.out.println("Found: " + Results.size());
            return true;
        } else {

            System.out.println("Found: " + Results.size());
            return false;
        }
    }

    // atidaryti chrome
    public static void OpenChrome() {

        browser = new ChromeDriver();
        browser.get(Link);

    }

    // uzdaryti chrome
    public static void CloseChrome() {
        browser.close();
    }


}
