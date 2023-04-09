package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Utils;

public class ProductItemComponent {

    private WebElement baseElement;
    private WebElement name;
    private WebElement description;
    private WebElement price;
    private WebElement addToCartButton;

    public ProductItemComponent(WebElement baseElement) {
        this.baseElement = baseElement;
        initElements();
    }

    private void initElements() {
        name = baseElement.findElement(By.cssSelector(".inventory_item_name"));
        description = baseElement.findElement(By.cssSelector(".inventory_item_desc"));
        price = baseElement.findElement(By.cssSelector(".inventory_item_price"));
        addToCartButton = baseElement.findElement(By.xpath(".//button[text()='Add to cart']"));
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public String getName() {
        return Utils.getText(name);
    }

    public String getDescription() {
        return Utils.getText(description);
    }

    public String getPrice() {
        return Utils.getText(price);
    }
}
