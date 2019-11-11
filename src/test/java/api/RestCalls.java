package api;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class RestCalls {

    @Step
    public Response getHTMLPage() {
        return SerenityRest
                .given()
                .get("https://www.fishingmall.ro/ro");
    }

    @Step
    public Response getProducts(String queryParam) {
        return SerenityRest.
                given()
                .log()
                .all()
                .queryParam("query", queryParam)
                .get("https://www.fishingmall.ro/ro/products");
    }
}
