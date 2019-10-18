package cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SearchPage;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SearchSteps {

    private SearchPage searchPage;

    @Given("I open the application {string}")
    public void iOpenTheApplication(String pageUrl) {
        searchPage.openPage(pageUrl);
    }

    @When("I search by {string}")
    public void iSearchBy(String searchParameter) {
        searchPage.searchBy(searchParameter);
    }

    @Then("I get a list of {string} products")
    public void iGetAListOfProducts(String productType) {
        assertThat(searchPage.getSearchResult()).isFalse();
    }

}
