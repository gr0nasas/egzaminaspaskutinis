import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class EntryEdit {

    static String Link = "http://localhost:8080";

    static ChromeDriver browser;

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "src/main/ChromeWebDriver/chromedriver102.exe");

        OpenChrome();
        UserLogin.Login("bandymas", "bandymas" ,browser);
        EditEntry(false, "567", browser);
        CloseChrome();

    }

    public static boolean EditEntry(boolean SupossedToFail, String NumberChange, WebDriver browser){


        browser.findElement(By.xpath("//a[normalize-space()='Atliktos operacijos']")).click();


        browser.findElement(By.xpath("/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[2]/td[5]/a[1]")).click();


        if(SupossedToFail){

            WebElement FirstNumberField = browser.findElement(By.xpath("//input[@name='sk1']"));
            FirstNumberField.clear();
            FirstNumberField.submit();


        } else{

            WebElement FirstNumberField = browser.findElement(By.xpath("//input[@name='sk1']"));
            FirstNumberField.clear();
            FirstNumberField.sendKeys(NumberChange);
            FirstNumberField.submit();
        }



        boolean success;
        try {


            browser.findElement(By.xpath("//a[@type='button']"));
            success = true;
        } catch (NoSuchElementException e) {
            success = false;
        }
        System.out.println("ar redagavimas pavyko: " + success);
        return success;


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
