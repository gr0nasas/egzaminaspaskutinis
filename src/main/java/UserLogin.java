import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserLogin {


    static String Link = "http://localhost:8080";

    static ChromeDriver browser;

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "src/main/ChromeWebDriver/chromedriver102.exe");


        OpenChrome();
        Login("bandymas", "bandymas", browser);
        CloseChrome();

    }

    public static boolean Login(String Username, String Password, WebDriver browser){


        WebElement UsernameField = browser.findElement(By.xpath("//input[@placeholder='Prisijungimo vardas']"));
        WebElement PasswordField = browser.findElement(By.xpath("//input[@placeholder='Slaptažodis']"));


        UsernameField.sendKeys(Username);
        PasswordField.sendKeys(Password);


        PasswordField.submit();



        boolean success;
        try {

            browser.findElement(By.xpath("//input[@value='skaičiuoti']"));
            success = true;
        } catch (NoSuchElementException e) {
            success = false;
        }
        System.out.println("ar prisijungimas pavyko: " + success);
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
