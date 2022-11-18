package fr.soat.trainmeet.api.acceptance;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.soat.trainmeet.api.meeting.infrastructure.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@DirtiesContext
@CucumberContextConfiguration
@ActiveProfiles("AcceptanceTest")
public class MeetingSteps {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    @LocalServerPort
    private int port;
    private Response response;

    private static final String API_MEETING = "/meeting";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    @Autowired
    private JpaAccountRepository jpaAccountRepository;

    @Autowired
    private JpaMeetingRepository jpaMeetingRepository;

    private String name;
    private String senderEmail;
    private String description;
    private String firstDate;
    private String lastDate;
    private String today;
    private String receiverEmail;

    @Before
    public void before() {
        RestAssured.port = port;
        RestAssured.basePath = API_MEETING;
    }

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
    public void theSenderTryToCreateMeeting() throws JsonProcessingException {
        var meetingJson = new MeetingJson(name, description, firstDate, lastDate, senderEmail, receiverEmail);
        String body = OBJECT_MAPPER.writeValueAsString(meetingJson);
        response = given()
                .log()
                .all()
                .header("Content-Type", ContentType.JSON)
                .body(body)
                .when()
                .post();
    }

    @Then("the meeting should be created")
    public void theMeetingShouldBeCreatedWithProperties() {
        Long savedMeetingId = response.then().extract().as(Long.class);
        JpaMeeting jpaMeeting = jpaMeetingRepository.findById(savedMeetingId).orElse(null);
        JpaMeeting expectedJpaMeeting = JpaMeeting.JpaMeetingBuilder.builder()
                .id(savedMeetingId)
                .isConfirmed(false)
                .firstPotentialDate(LocalDate.parse(firstDate, DATE_TIME_FORMATTER))
                .lastPotentialDate(LocalDate.parse(lastDate, DATE_TIME_FORMATTER))
                .build();

        assertThat(jpaMeeting).usingRecursiveComparison()
                .ignoringFields("sender", "receiver")
                .isEqualTo(expectedJpaMeeting);

        assert jpaMeeting != null;
        assert jpaMeeting.getSender() != null;
        assert jpaMeeting.getReceiver() != null;

        assertThat(jpaMeeting.getSender().getEmail()).isEqualTo(senderEmail);
        assertThat(jpaMeeting.getReceiver().getEmail()).isEqualTo(receiverEmail);
    }
}
