package hotel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ProductStepdefs {

        WebDriver driver;

        @Given("I open SauceDemo page")
        public void openPage() {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://www.saucedemo.com/");
        }

        @When("I login with valid credentials")
        public void login() {
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
        }

        @Then("products should be visible")
        public void productsVisible() {

            int items = driver.findElements(By.className("inventory_item")).size();

            Assert.assertTrue(items > 0);

            driver.quit();
        }
    }

