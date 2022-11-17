package fr.soat.trainmeet.api.acceptance;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@DirtiesContext
@CucumberContextConfiguration
@ActiveProfiles("AcceptanceTest")
public class MeetingSteps {
    @Given("a meeting with name {string}")
    public void aMeetingWithName(String name) {
    }

    @And("the description is {string}")
    public void theDescriptionIs(String description) {
    }

    @And("the meeting first potential date is {string}")
    public void theMeetingFirstPotentialDateIs(String firstDate) {
    }

    @And("the last potential date is {string}")
    public void theLastPotentialDateIs(String lastDate) {
    }

    @And("today is {string}")
    public void todayIs(String today) {
    }

    @When("the meeting is organized")
    public void theMeetingIsOrganized() {
    }

    @Then("the meeting is created with properties")
    public void theMeetingIsCreatedWithProperties() {
    }
}
