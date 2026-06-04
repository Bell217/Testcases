package hotel;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginStepdefs {
    WebDriver driver;

    @Given("the user is on the SauceDemo login page")
    public void user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
    }

    @When("the user clicks the Login button without entering credentials")
    public void user_clicks_login_button_without_entering_credentials() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("the error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedMessage) {
        String actualMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        System.out.println("Actual message: " + actualMessage);
        assertTrue(actualMessage.contains(expectedMessage));
        driver.quit();
    }

}




