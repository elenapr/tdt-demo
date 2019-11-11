package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import pages.SearchPage;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SearchStepDefinitions {

    SearchPage searchPage;

    @Before("@ui")
    public void openApp() {
        searchPage.openApplication("https://www.fishingmall.ro/ro/");
    }

    @Given("I open the {string} application")
    public void iOpenTheApplication(String appUrl) {
        searchPage.openApplication(appUrl);
    }

    @Then("the application is successfully opened")
    public void theApplicationIsSuccessfullyOpened() {

        assertThat(searchPage.isLogoLoaded()).isFalse();
    }

    @When("I search by {string}")
    public void iSearchBy(String product) {
        searchPage.searchBy(product);

        Serenity.setSessionVariable("productName").to(product);
    }

    @Then("A list of products is returned")
    public void aListOfProductsIsReturned() {
        String product = Serenity.sessionVariableCalled("productName");
        assertThat(product).isEqualTo("lanseta");
    }

    @When("I add the first product to cart")
    public void iAddTheFirstProductToCart() {
        searchPage.addProductToCart();
    }
}
