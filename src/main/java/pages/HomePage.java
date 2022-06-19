package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    //WebDriver driver;

   /* public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }*/

    // Locators using PageFactory
    @FindBy(id = "nav-link-new-post")
    WebElement newPostButton;

    @FindBy(xpath = "//*[contains(@class,'sign-out')]")
    WebElement logoutButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Interaction Methods

    // Assertion Methods
    public boolean isNewPostButtonDisplayed() {
        return newPostButton.isDisplayed();
    }

    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isDisplayed();
    }
}
