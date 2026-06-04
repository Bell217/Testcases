package hotel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CasesStepDefs {
    WebDriver driver;
    WebDriverWait wait;



        @Given("User opens Ultimate homepage")
        public void user_opens_ultimate_homepage() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get("https://ultimateqa.com/");
        }

        @When("User navigates to Case Studies")
        public void user_navigates_to_case_studies() {
            driver.get("https://ultimateqa.com/case-studies/");
        }

        @Then("User should see Test Automation text")
        public void user_should_see_test_automation_text() {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//*[contains(text(),'Test Automation')]")
                    )
            );

            Assert.assertTrue(
                    driver.findElement(
                            By.xpath("//*[contains(text(),'Test Automation')]")
                    ).isDisplayed()
            );
        }
    }

