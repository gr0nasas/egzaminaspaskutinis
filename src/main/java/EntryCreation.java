import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class EntryCreation {

    static String Link = "http://localhost:8080";

    static ChromeDriver browser;

    public static void main(String[] args) {

        // naudojamas driveris
        System.setProperty("webdriver.chrome.driver", "src/main/ChromeWebDriver/chromedriver102.exe");

        OpenChrome();
        UserLogin.Login("bandymas", "bandymas" ,browser);
        CreateNewEntry("22", "800", browser);
        CloseChrome();

    }

    public static boolean CreateNewEntry(String FirstNumber, String SecondNumber, WebDriver browser){

        WebElement FirstnumberField = browser.findElement(By.xpath("//input[@id='sk1']"));
        WebElement SecondNumberField = browser.findElement(By.xpath("//input[@id='sk2']"));

        FirstnumberField.clear();
        SecondNumberField.clear();

        FirstnumberField.sendKeys(FirstNumber);
        SecondNumberField.sendKeys(SecondNumber);

        SecondNumberField.submit();


        boolean success;
        try {

            browser.findElement(By.xpath("//input[@value='skaičiuoti']"));
            success = false;
        } catch (NoSuchElementException e) {
            success = true;
        }
        System.out.println("Was the entry creation successful: " + success);
        return success;


    }

    // atidartyti chrome
    public static void OpenChrome() {

        browser = new ChromeDriver();
        browser.get(Link);

    }
    // uzdaryti chrome
    public static void CloseChrome() {
        browser.close();
    }



}
