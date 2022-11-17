package fr.soat.trainmeet.api.acceptance;

import fr.soat.trainmeet.api.meeting.infrastructure.JpaAccount;
import fr.soat.trainmeet.api.meeting.infrastructure.JpaAccountRepository;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.time.format.DateTimeFormatter;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@DirtiesContext
@CucumberContextConfiguration
@ActiveProfiles("AcceptanceTest")
public class MeetingSteps {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    @Autowired
    private JpaAccountRepository jpaAccountRepository;

    private String name;
    private String senderEmail;
    private String description;
    private String firstDate;
    private String lastDate;
    private String today;
    private String receiverEmail;

    @Given("a sender with email {string} that have account")
    public void aSenderWithEmailThatHaveAccount(String email) {
        jpaAccountRepository.save(JpaAccount.JpaAccountBuilder.builder().email(email).build());
        senderEmail = email;
    }

    @Given("a meeting with name {string}")
    public void aMeetingWithName(String name) {
        this.name = name;
        System.out.println(this.name);
    }

    @And("the description is {string}")
    public void theDescriptionIs(String description) {
        this.description = description;
    }

    @And("the meeting first potential date is {string}")
    public void theMeetingFirstPotentialDateIs(String firstDate) {
        this.firstDate = firstDate;
    }

    @And("the last potential date is {string}")
    public void theLastPotentialDateIs(String lastDate) {
        this.lastDate = lastDate;
    }

    @And("today is {string}")
    public void todayIs(String today) {
        this.today = today;
    }

    @And("a receiver with email {string} that have account")
    public void theReceiverWithEmailThatHaveAccount(String email) {
        jpaAccountRepository.save(JpaAccount.JpaAccountBuilder.builder().email(email).build());
        this.receiverEmail = email;
    }

    @When("the sender try to create meeting")
    public void theSenderTryToCreateMeeting() {
        // TODO : continue to implement the steps
    }

    @Then("the meeting should be created with properties")
    public void theMeetingShouldBeCreatedWithProperties(DataTable dataTable) {
    }
}
