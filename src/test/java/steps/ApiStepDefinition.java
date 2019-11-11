package steps;

import api.RestCalls;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ApiStepDefinition {

    @Steps
    RestCalls restCalls;
    Response response;

    @Given("I call the GET resource")
    public void iCallTheGETResource() {
       response = restCalls.getHTMLPage();
    }

    @Then("an html result is returned")
    public void anHtmlResultIsReturned() {
        assertThat(response.getBody()).isNotNull();
    }

    @And("the status code is {int}")
    public void theStatusCodeIs(int statusCode) {
        assertThat(response.getStatusCode()).isEqualTo(statusCode);
    }

    @And("the content type is {string}")
    public void theContentTypeIs(String expectedContentType) {
        assertThat(response.getContentType())
                .isEqualTo(expectedContentType);

    }
    @When("I call the GET products with query {string}")
    public void iCallTheGETProductsWithQuery(String queryParam) {
        response = restCalls.getProducts(queryParam);
    }

    @Then("a list of products is returned")
    public void aListOfProductsIsReturned() {
        assertThat(response.getBody().toString()).isNotEmpty();
        assertThat(response.getStatusCode()).isEqualTo(200);
    }
}
