package cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SearchPage;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SearchStepsDefinition {

    private SearchPage searchPage;

    @Given("I open the application {string}")
    public void iOpenTheApplication(String pageUrl) {
        searchPage.openPage(pageUrl);
    }

    @When("I search by {string}")
    public void iSearchBy(String searchParameter) {
        searchPage
                .searchBy(searchParameter)
                .clickSearch();
    }

    @Then("I get a list of products")
    public void iGetAListOfProducts() {
        assertThat(searchPage.getSearchResult()).isTrue();
    }

    @Then("a success message is displayed {string}")
    public void aSuccessMessageIsDisplayed(String message) {
        assertThat(searchPage.successMessageIsReturned(message)).isTrue();
    }

    @And("The total number of the cart products is {string}")
    public void theTotalNumberOfTheCartProductsIs(String noOfProducts) {
       assertThat(searchPage.getTheNumberOfProductsFromTheCart())
               .isEqualTo(Integer.parseInt(noOfProducts));
    }

    @When("I add the first product to cart")
    public void iAddTheFirstProductToCart() {
        searchPage.addProductToCart();
    }
}
