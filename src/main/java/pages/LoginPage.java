package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
//WebDriver driver;

    //public LoginPage(WebDriver driver) {
    //     this.driver = driver;
    // }
    By userNameField = By.id("defaultLoginFormUsername");
    By passwordField = By.id("defaultLoginFormPassword");
    By signInButton = By.id("sign-in-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUserName(String username) {
        driver.findElement(userNameField).clear();
        driver.findElement(userNameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }
}
