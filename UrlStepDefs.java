package hotel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class UrlStepDefs {
    WebDriver driver;

    @Given("user opens the homepage")
    public void openHome() {
        driver = new ChromeDriver();
        driver.get("https://automationintesting.online/");
    }

    @Then("url should contain {string}")
    public void checkUrl(String expected) {
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains(expected));
        driver.quit();
    }
}
