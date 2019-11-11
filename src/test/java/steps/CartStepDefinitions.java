package steps;

import cucumber.api.java.en.Then;
import pages.SearchPage;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CartStepDefinitions {

    SearchPage searchPage;

    @Then("The total number of the cart products is {string}")
    public void theTotalNumberOfTheCartProductsIs(String noOfProducts) {

        assertThat(searchPage.getTheNumberOfProductsFromTheCart())
                .isEqualTo(Integer.parseInt(noOfProducts));
    }
}
