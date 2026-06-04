package hotel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class AccountStepDefs {

        WebDriver driver;
        WebDriverWait wait;

        @Given("User is on login page")
        public void open_login_page() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.get("https://www.saucedemo.com/");
        }

        @When("User enters username {string} and password {string}")
        public void enter_credentials(String username, String password) {

            WebElement userField = driver.findElement(By.id("user-name"));
            WebElement passField = driver.findElement(By.id("password"));

            userField.clear();
            passField.clear();

            if (username != null) {
                userField.sendKeys(username);
            }

            if (password != null) {
                passField.sendKeys(password);
            }
        }

        @When("User clicks Login button")
        public void click_login() {
            driver.findElement(By.id("login-button")).click();
        }

        @Then("User should see message {string}")
        public void verify_error_message(String expectedMessage) {

            WebElement error = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("h3[data-test='error']")
                    )
            );

            String actualMessage = error.getText();

            assertTrue(actualMessage.contains(expectedMessage));

            driver.quit();
        }
    }

