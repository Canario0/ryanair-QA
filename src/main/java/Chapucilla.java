import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.RyanairHome;

import java.security.Key;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class Chapucilla {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pablo.renero\\IdeaProjects\\ryanair-QA\\src\\test\\resources\\chromedriver.exe");
        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();
//        RyanairHome prueba = new RyanairHome(driver);
//
//        prueba.searchForOneWayFlight("Madrid", "Fuerteventura", 21, 10, 2018);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://www.ryanair.com/gb/en/booking/home/MAD/FUE/2019-05-04//1/0/0/0?Discount=0");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        List<WebElement> element = driver.findElements(By.xpath("//span[@translate=\"trips.flight_list_header.destination\"]"));
        System.out.println(element.size());
//        element = wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//input[@tabindex=\"0\" and @placeholder=\"Departure airport\"]")));
//        element.clear();
//        element.sendKeys("Madrid" + Keys.ENTER);
//        element = wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//input[@tabindex=\"0\" and @placeholder=\"Destination airport\"]")));
//        element.clear();
//        element.sendKeys("Fuerteventura" + Keys.ENTER);
//        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"dateInput0\" and @aria-label=\"Fly out: - DD\"]")));
//        element.clear();
//        element.sendKeys("05");
//        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"dateInput1\" and @aria-label=\"Fly out: - MM\"]")));
//        element.clear();
//        element.sendKeys("10");
//        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"dateInput2\" and @aria-label=\"Fly out: - YYYY\"]")));
//        element.clear();
//        element.sendKeys("2019");
//
//        driver.quit();
//        driver.manage().deleteAllCookies();
    }
}
