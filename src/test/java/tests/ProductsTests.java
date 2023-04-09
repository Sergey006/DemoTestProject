package tests;

import data.Logins;
import data.Passwords;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductsPage;
import model.Product;
import util.TestException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Products tests")
public class ProductsTests extends BaseTest {

    @BeforeEach
    public void login() {
        new LoginPage(driver).login(Logins.STANDARD_USER, Passwords.VALID_PASSWORD);
    }

    @Test
    @DisplayName("Products quantity check")
    public void checkProductsQuantity() {
        List<Product> productList = new ProductsPage(driver).getProducts();
        assertThat(productList).hasSize(6);
    }

    @Test
    @DisplayName("Add to cart from products list")
    public void addToCart() throws TestException {
        //given
        final String productName = "Sauce Labs Fleece Jacket";
        // when
        new ProductsPage(driver)
                .addItemToCart(productName)
                // then
                .goToCartPage(driver)
                .checkItemsQty(1)
                .checkItemPresents(productName);
    }
}
