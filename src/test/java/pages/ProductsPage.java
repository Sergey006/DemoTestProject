package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.components.ProductItemComponent;
import pages.interfaces.ToCartTransition;
import model.Product;
import util.TestException;
import util.Utils;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductsPage extends BasePage implements ToCartTransition {

    @FindBy(className = "title")
    private WebElement title;
    @FindBy(css = ".inventory_item")
    private List<WebElement> productsList;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage addItemToCart(String name) throws TestException {
        ProductItemComponent item = getProductsItems().stream()
                .filter(product -> name.equals(product.getName()))
                .findFirst()
                .orElseThrow(() -> new TestException(String.format("Can't find item with name [%s]", name)));
        item.addToCart();
        return this;
    }

    public List<Product> getProducts() {
        return getProductsItems().stream()
                .map(item -> new Product(item.getName(), item.getDescription(), item.getPrice()))
                .collect(Collectors.toList());
    }

    public List<ProductItemComponent> getProductsItems() {
        return productsList.stream()
                .map(ProductItemComponent::new)
                .collect(Collectors.toList());
    }

    public ProductsPage checkPageTitle(String title) {
        assertThat(getPageTitle()).isEqualTo(title);
        return this;
    }

    private String getPageTitle() {
        return Utils.getText(title);
    }

}
