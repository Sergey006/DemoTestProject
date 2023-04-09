package pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.interfaces.ToCartTransition;
import util.Utils;

public class ProductDetailsPage extends BasePage implements ToCartTransition {
    @FindBy(css = ".inventory_details_name")
    private WebElement name;
    @FindBy(css = ".inventory_details_desc")
    private WebElement description;
    @FindBy(css = ".inventory_details_price")
    private WebElement price;
    @FindBy(xpath = "//button[text()='Add to cart']")
    private WebElement addToCartButton;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        addToCartButton.click();
    }

    private String getName() {
        return Utils.getText(name);
    }

    private String getDescription() {
        return Utils.getText(description);
    }

    private String getPrice() {
        return Utils.getText(price);
    }

}
