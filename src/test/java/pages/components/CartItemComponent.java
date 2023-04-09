package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Utils;

public class CartItemComponent {
    private WebElement baseElement;
    private WebElement name;
    private WebElement description;
    private WebElement price;

    public CartItemComponent(WebElement baseElement) {
        this.baseElement = baseElement;
        initElements();
    }

    private void initElements() {
        name = baseElement.findElement(By.cssSelector(".inventory_item_name"));
        description = baseElement.findElement(By.cssSelector(".inventory_item_desc"));
        price = baseElement.findElement(By.cssSelector(".inventory_item_price"));
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
