package hotel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class OnesieStepDefs {

        WebDriver driver;
        WebDriverWait wait;

        @Given("the user opens the SauceDemo website")
        public void openSite() {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.get("https://www.saucedemo.com/");
        }

        @When("the user logs in with visual_user credentials")
        public void login() {
            driver.findElement(By.id("user-name")).sendKeys("visual_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
        }


        @When("the user opens the {string} product")
        public void openProduct(String productName) {

            By productLocator = By.xpath(
                    "//div[text()='" + productName + "']/ancestor::a"
            );

            wait.until(ExpectedConditions.elementToBeClickable(productLocator)).click();
        }

        @When("the user adds the product to the cart")
        public void addToCart() {
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button[id^='add-to-cart']")
            )).click();
        }

        @When("the user opens the cart")
        public void openCart() {
            driver.findElement(By.className("shopping_cart_link")).click();
        }

        @Then("the cart should contain the {string} product")
        public void verifyCart(String expectedProduct) {

            String actualProduct = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.className("inventory_item_name")
                    )
            ).getText();

            assertEquals(expectedProduct, actualProduct);

            driver.quit();
        }
    }

