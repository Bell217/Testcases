package hotel;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartStepDefs {

        WebDriver driver;

        @Given("I am logged into SauceDemo")
        public void login() {

            driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/");

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
        }

        @When("I add first product to cart")
        public void addToCart() {

            driver.findElements(By.cssSelector("button.btn_inventory"))
                    .getFirst()
                    .click();
        }

        @Then("cart badge should show {string}")
        public void checkCart(String expected) {

            String badge = driver.findElement(By.className("shopping_cart_badge")).getText();

            Assert.assertEquals(expected, badge);

            driver.quit();
        }
    }

