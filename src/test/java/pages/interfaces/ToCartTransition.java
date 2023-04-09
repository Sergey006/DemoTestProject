package pages.interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

public interface ToCartTransition {

    default CartPage goToCartPage(WebDriver driver) {
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        return new CartPage(driver);
    }
}
