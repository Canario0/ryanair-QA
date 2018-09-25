package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class RyanairResults extends PageObject {
    @FindAll({@FindBy(css = "div.details")})
    private List<WebElementFacade> avibleFlight;

    public RyanairResults(WebDriver driver) {
        super(driver);

    }

    public int resultsNum() {
         return avibleFlight.size();
    }

}
