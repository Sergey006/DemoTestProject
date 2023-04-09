package util;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;

public class Utils {

    public static String getText(WebElement element) {
        String elementText = element.getText();
        String innerText = element.getAttribute("innerText");
        String value = element.getAttribute("value");
        if (isNotNullOrEmpty(value)) {
            return value;
        } else if (isNotNullOrEmpty(innerText)) {
            return innerText;
        } else if (isNotNullOrEmpty(elementText)) {
            return elementText;
        } else {
            Assertions.fail("текст элемента не определён");
            return null;
        }
    }

    private static boolean isNotNullOrEmpty(String value) {
        return value != null && !value.isEmpty();
    }

}
