package oldway;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class oldScript {
    ChromeDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
        wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void login() {

        driver.get("http://training.skillo-bg.com");
        WebElement loginButton = driver.findElement(By.id("nav-link-login"));
        WebElement homeButton = driver.findElement(By.linkText("Home"));
        loginButton.click();

        WebElement usernameField = driver.findElement(By.id("defaultLoginFormUsername"));
        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        usernameField.click();
        usernameField.clear();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        usernameField.sendKeys("ukyazimova");
        passwordField.click();
        passwordField.clear();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        passwordField.sendKeys("Password1");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement sigInButton = driver.findElement(By.id("sign-in-button"));
        sigInButton.click();
        WebElement newPostButton = driver.findElement(By.id("nav-link-new-post"));
        Assert.assertTrue(newPostButton.isDisplayed());
        homeButton.click();

        WebElement profileButton = driver.findElement(By.xpath("//a[contains(text(),'Profile')]"));
        profileButton.click();
        WebElement usernameProfile = driver.findElement(By.xpath("//div[contains(@class,'profile-user')]//h2"));
        Assert.assertTrue(usernameProfile.isDisplayed());

    }
}
