package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.components.CartItemComponent;
import util.TestException;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CartPage extends BasePage {

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;
    @FindBy(css = ".cart_item")
    private List<WebElement> cartItemsList;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage checkItemsQty(int expectedQty) {
        assertThat(cartItemsList).hasSize(expectedQty);
        return this;
    }

    public CartPage checkItemPresents(String name) throws TestException {
        getCartItems().stream()
                .filter(i -> name.equals(i.getName()))
                .findAny()
                .orElseThrow(() -> new TestException(String.format("Can't find item with name [%s]", name)));
        return this;
    }

    public List<CartItemComponent> getCartItems() {
        return cartItemsList.stream()
                .map(CartItemComponent::new)
                .collect(Collectors.toList());
    }
}
