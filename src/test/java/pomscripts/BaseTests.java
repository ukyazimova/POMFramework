package pomscripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.DefaultPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class BaseTests {

    ChromeDriver driver;
    WebDriverWait wait;
    DefaultPage defaultPage;
    LoginPage loginPage;
    HomePage homePage;
    BasePage basePage;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        defaultPage = new DefaultPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        basePage = new BasePage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginTest() throws InterruptedException {

        driver.get("http://training.skillo-bg.com");
        defaultPage.clickLoginButton();
        loginPage.enterUserName("ukyazimova");
        loginPage.enterPassword("Password1");
        loginPage.clickSignIn();
        Assert.assertTrue(homePage.isNewPostButtonDisplayed());
        Assert.assertTrue(homePage.isLogoutButtonDisplayed());


        Thread.sleep(100);

    }
}
