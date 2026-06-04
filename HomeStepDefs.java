package hotel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;


public class HomeStepDefs {
    WebDriver driver;

    @Given("the user opens the homepage")
    public void openHome() {
        driver = new ChromeDriver();
        driver.get("https://automationintesting.online/");
    }

    @Then("the page title contains {string}")
    public void checkTitle(String text) {
        System.out.println("TITLE: " + driver.getTitle());
        Assert.assertTrue(Objects.requireNonNull(driver.getTitle()).contains(text));
        driver.quit();
    }
}
