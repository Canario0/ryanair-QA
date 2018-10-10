package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.rmi.Remote;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

//@DefaultUrl("https://www.ryanair.com/gb/en/")
@DefaultUrl("https://www.google.es")
public class RyanairHome extends PageObject {

    @FindBy(xpath = "//div[@data-ref=\"cookies-policy-icon\"]")
    private WebElementFacade closeCookies;

    //    @FindBy(xpath = "//input[@type=\"radio\" and @value=\"return\"]")
    @FindBy(xpath = "//div[@class=\"flight-search-type-option return\"]")
    private WebElementFacade freturn;

    //    @FindBy(xpath = "//input[@type=\"radio\" and @value=\"one-way\"]")
    @FindBy(xpath = "//div[@class=\"flight-search-type-option one-way\"]")
    private WebElementFacade foneway;

    @FindBy(xpath = "//input[@tabindex=\"0\" and @placeholder=\"Departure airport\"]")
    private WebElementFacade origin;

    @FindBy(xpath = "//input[@tabindex=\"0\" and @placeholder=\"Destination airport\"]")
    private WebElementFacade destination;

    @FindBy(xpath = "//input[@name=\"dateInput0\" and @aria-label=\"Fly out: - DD\"]")
    private WebElementFacade dayOut;

    @FindBy(xpath = "//input[@name=\"dateInput1\" and @aria-label=\"Fly out: - MM\"]")
    private WebElementFacade monthOut;

    @FindBy(xpath = "//input[@name=\"dateInput2\" and @aria-label=\"Fly out: - YYYY\"]")
    private WebElementFacade yearOut;

    @FindBy(xpath = "//input[@name=\"dateInput0\" and @aria-label=\"Fly back: - DD\"]")
    private WebElementFacade dayBack;

    @FindBy(xpath = "//input[@name=\"dateInput1\" and @aria-label=\"Fly back: - MM\"]")
    private WebElementFacade monthBack;

    @FindBy(xpath = "//input[@name=\"dateInput2\" and @aria-label=\"Fly back: - YYYY\"]")
    private WebElementFacade yearBack;

    @FindBy(xpath = "//button[@ng-keypress=\"searchFlights()\"]")
    private WebElementFacade submit;


    public RyanairHome(WebDriver driver) {
        super(driver);
//        maximize(driver);
//        openPage();
    }

    private void maximize(WebDriver driver) {
        driver.manage().window().maximize();
    }


    public void writeOriginAndDestination(String origin, String destination) {
        write(this.origin, origin);
        write(this.destination, destination);
    }

    public void openPage(){
        this.setImplicitTimeout(15, SECONDS);
        this.open();
        waitLoad();
    }

    public void waitLoad() {
        this.getDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    private void write(WebElementFacade element, String data) {
        element.waitUntilClickable();
        element.clear();
        element.typeAndTab(data);
    }

    public void chooseType(String type) {
        if (closeCookies.isCurrentlyVisible())
            closeCookies.click();
        if (type.equals("oneway")) {
            foneway.waitUntilClickable();
            foneway.click();
        } else {
            freturn.waitUntilClickable();
            freturn.click();
        }
    }

    public void writeDateOut(Calendar dateOut) {
        write(yearOut, (dateOut.get(Calendar.YEAR)) + "");
        write(monthOut, (dateOut.get(Calendar.MONTH) + 1) + "");
        write(dayOut, (dateOut.get(Calendar.DAY_OF_MONTH)) + "");
    }

    public void writeDateBack(Calendar dateBack) {
        write(yearBack, (dateBack.get(Calendar.YEAR)) + "");
        write(monthBack, (dateBack.get(Calendar.MONTH) + 1) + "");
        write(dayBack, (dateBack.get(Calendar.DAY_OF_MONTH)) + "");
    }

    public RyanairResults submitSearch() {
        submit.click();
        this.waitFor(titleContains("Ryanair Rooms"));
        for (String it : this.getDriver().getWindowHandles()) {
            this.getDriver().switchTo().window(it);
            if (this.getDriver().getTitle().equals("Ryanair")) {
                break;
            }
        }
        return new RyanairResults(this.getDriver());
    }

}
