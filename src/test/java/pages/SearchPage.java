package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SearchPage extends PageObject {

    @FindBy(className = "search-box-input")
    private WebElement searchInput;

    @FindBy(className = "product-card")
    private WebElement productList;

    @FindBy(className = "search-now")
    private WebElement searchButton;

    private String addToCartSelector = "//button[@class = 'btn btn-default btn-add-to-cart'][%s]";
    private String messageAlert = "//div[@class = 'alertify-notifier ajs-top ajs-right]/div";
    private String cartProductsSelector = "//div[contains(@class, 'user-cart')]/span";
    private String searchingResultHeader = "//h3[contains(text(), 'Rezultatele cautarii pentru:')]";

    public SearchPage openPage(String pageUrl) {
        getDriver().get(pageUrl);
        getDriver().manage().window().maximize();
        return this;
    }

    public SearchPage searchBy(String searchParameter) {
        typeInto(searchInput, searchParameter);
        return this;
    }

    public void clickSearch() {
        clickOn(searchButton);
        waitFor(ExpectedConditions.visibilityOf(find(By.xpath(searchingResultHeader))));
    }

    public boolean getSearchResult() {
        return findAll(By.className("product-card")).size() > 0;
    }

    public SearchPage addProductToCart() {
        moveTo(By.className("product-card"));
        clickOn(find(By.xpath(String.format(addToCartSelector, 1))));
        return this;
    }

    public Boolean successMessageIsReturned(String message) {
        waitFor((WebElementFacade) find(By.xpath(messageAlert)));

        return find(By.xpath(messageAlert)).getText().contains(message);
    }

    public int getTheNumberOfProductsFromTheCart() {
        return Integer.parseInt(find(By.xpath(cartProductsSelector)).getText());
    }
}
