package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePages {
    protected final WebDriver driver;
    public BasePages(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitElementIsVisible (WebElement element) {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
