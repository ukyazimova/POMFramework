package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Default Page -> Homepage
 * Initial page loaded after hit URL
 */
public class DefaultPage {
    WebDriver driver;


    public DefaultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By loginButton = By.id("nav-link-login");

    public void clickLoginButton() {
        driver.findElement(loginButton).click();

    }


}
