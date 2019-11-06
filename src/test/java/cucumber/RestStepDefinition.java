package cucumber;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import api.RestSteps;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RestStepDefinition {

    @Steps
    RestSteps restSteps;
    Response response;

    @When("I call the GET products with query {string}")
    public void iCallTheGETProductsWithQuery(String queryParam) {
        response = restSteps.getProducts(queryParam);
    }

    @Then("a list of products is returned")
    public void aListOfProductsIsReturned() {
        assertThat(response.getBody().toString()).isNotEmpty();
        assertThat(response.getStatusCode()).isEqualTo(200);
    }
}
