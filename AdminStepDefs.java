package hotel;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class AdminStepDefs {
    WebDriver driver;

    @Given("user is on admin login page")
    public void user_is_on_admin_login_page() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://automationintesting.online/admin");
    }

    @When("user clicks login button without entering username and password")
    public void user_clicks_login_button_without_entering_credentials() {
        driver.findElement(By.id("doLogin")).click();
    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedMessage) {
        String actualMessage = driver.findElement(By.cssSelector(".alert-danger")).getText();
        System.out.println("Actual message: " + actualMessage);
        assertTrue(actualMessage.contains(expectedMessage));
        driver.quit(); }
    }


