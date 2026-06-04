package hotel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewsStepDefs {

        WebDriver driver;
        WebDriverWait wait;

        @Given("I open UltimateQA automation page")
        public void openPage() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://ultimateqa.com/automation/");

            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        @When("I go to Newsletter section")
        public void goToNewsletter() {

            WebElement newsletter = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//*[contains(text(),'Newsletter')]")
                    )
            );

            newsletter.click();
        }

        @Then("newsletter text should be visible")
        public void checkNewsletterText() {

            String pageText = driver.getPageSource();

            assert pageText != null;
            Assert.assertTrue(
                    pageText.contains("Newsletter")
            );

            driver.quit();
        }
    }

