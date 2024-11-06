import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class ComposeEmailSteps {

    WebDriver driver;

    @Given("the user is logged into their Gmail account")
    public void the_user_is_logged_into_their_gmail_account() {
        // Assuming user is already logged in for simplicity.
        driver = new ChromeDriver();
        driver.get("https://mail.google.com/");
    }

    @When("the user clicks on the compose button")
    public void the_user_clicks_on_the_compose_button() {
        WebElement composeButton = driver.findElement(By.cssSelector(".T-I.T-I-KE.L3"));
        composeButton.click();
    }

    @When("the user enters {string} in the {string} field")
    public void the_user_enters_in_the_field(String value, String field) {
        By locator = null;
        switch (field) {
            case "To":
                locator = By.name("to");
                break;
            case "Subject":
                locator = By.name("subjectbox");
                break;
            case "Body":
                locator = By.cssSelector(".editable[aria-label='Message Body']");
                break;
        }
        driver.findElement(locator).sendKeys(value);
    }

    @When("the user leaves the {string} field empty")
    public void the_user_leaves_the_field_empty(String field) {
        // No action needed as field will be left empty by default.
    }

    @When("the user clicks on the send button")
    public void the_user_clicks_on_the_send_button() {
        WebElement sendButton = driver.findElement(By.cssSelector(".T-I.J-J5-Ji.aoO.v7.T-I-atl.L3"));
        sendButton.click();
    }

    @Then("the email should be sent successfully")
    public void the_email_should_be_sent_successfully() {
        WebElement confirmationMessage = driver.findElement(By.cssSelector(".vh"));
        assertTrue("Email not sent successfully", confirmationMessage.isDisplayed());
    }

    @Then("a confirmation message should be displayed")
    public void a_confirmation_message_should_be_displayed() {
        WebElement confirmationMessage = driver.findElement(By.cssSelector(".vh"));
        assertTrue("Confirmation message not displayed", confirmationMessage.isDisplayed());
    }

    @Then("an error message should be displayed saying {string}")
    public void an_error_message_should_be_displayed_saying(String expectedErrorMessage) {
        WebElement errorMessage = driver.findElement(By.cssSelector(".Kj-JD-Jz"));
        assertEquals("Incorrect error message", expectedErrorMessage, errorMessage.getText());
    }
}
