package steps.serenity;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pageObjects.RyanairHome;
import pageObjects.RyanairResults;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class RyanairStepsDefinitions {
    private RyanairHome ryanairHome;
    private RyanairResults ryanairResults;
    private String type;

    @Step("Given That I have enter to Ryanair page")
    public void i_have_enter_to_Ryanair_home_page() {
        ryanairHome.open();
        ryanairHome.waitLoad();
//        ryanairHome.waitFor(titleContains("Official Ryanair website | Book direct for the lowest fares | Ryanair.com"));
    }

    @Step("And from \"<origin>\" to \"<destination>\"")
    public void from_to(String origin, String destination) {
        ryanairHome.writeOriginAndDestination(origin, destination);
    }

    @Step("When I search for a \"<type>\" flight")
    public void i_search_for_a_flight(String type) {
        this.type = type;
        ryanairHome.chooseType(type);
    }

    @Step("And with dates: \"<date>\" and \"<dateReturn>\"")
    public void with_dates(String dateOut, String dateBack){
        try {
            Date date1 = DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH).parse(dateOut);
            Date today = new Date();
            Assert.assertTrue(date1.after(today));
            Calendar aux = Calendar.getInstance();
            aux.setTime(date1);
            ryanairHome.writeDateOut(aux);
            if(this.type.equals("return")) {
                Date date2 = DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH).parse(dateBack);
                Assert.assertTrue(date2.after(today));
                Assert.assertTrue(date2.after(date1));
                aux = Calendar.getInstance();
                aux.setTime(date2);
                ryanairHome.writeDateBack(aux);
            }
            ryanairResults = ryanairHome.submitSearch();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Step("I should get <num> rows")
    public void i_should_get_rows(int row){
        Assert.assertEquals(row, ryanairResults.resultsNum());
        ryanairResults.getDriver().quit();
    }
}
