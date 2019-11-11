package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class SearchPage extends PageObject {


    public void openApplication(String myAppUrl){
        //open browser on this url
        getDriver().get(myAppUrl);
        getDriver().manage().window().maximize();
    }

    public Boolean isLogoLoaded(){
        return isElementVisible(By.xpath("//span[@class='span-logo']/a/img"));
    }

    public void searchBy(String product) {
        typeInto(find(By.className("search-box-input")), product);
        clickOn(find(By.className("search-now")));
    }

    public SearchPage addProductToCart() {
        moveTo(By.className("product-card"));
        clickOn(find(By.xpath(String.format("//button[@class = 'btn btn-default btn-add-to-cart'][%s]", 1))));
        return this;
    }

    public int getTheNumberOfProductsFromTheCart() {
        return Integer.parseInt(find(By.xpath("//div[contains(@class, 'user-cart')]/span")).getText());
    }
}
