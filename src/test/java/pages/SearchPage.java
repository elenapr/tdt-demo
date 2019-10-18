package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchPage extends PageObject {

    @FindBy(className = "search-box-input")
    private WebElement searchInput;

    @FindBy(className = "product-card")
    private WebElement productList;

    public SearchPage openPage(String pageUrl) {
        getDriver().get(pageUrl);
        return this;
    }

    public SearchPage searchBy(String searchParameter) {
        typeInto(searchInput, searchParameter);
        return this;
    }

    public boolean getSearchResult() {
        return findAll(By.className("product-card")).size() > 0;
    }
}
