package dtu.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.ws.rs.core.Response;
import dtu.example.record.Person;
import dtu.example.service.PersonService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersonServiceSteps {

    private Person result;
    private Response response;
    private final PersonService service = new PersonService();

    @Given("the person service is initialized with name {string} and address {string}")
    public void thePersonServiceIsInitializedWithNameAndAddress(String name, String address) {
        Person person = new Person(name, address);
        try (var resp = service.updatePerson(person)) {
            // Initialization done
        }
    }

    @When("I call GET on the person service")
    public void iCallGETOnThePersonService() {
        result = service.getPerson();
    }

    @When("I call POST on the person service with name {string} and address {string}")
    public void iCallPOSTOnThePersonServiceWithNameAndAddress(String name, String address) {
        Person person = new Person(name, address);
        try (var response = service.updatePerson(person))  {
            this.response = response;
        }
    }

    @Then("I get the person with name {string} and address {string}")
    public void iGetThePersonWithNameAndAddress(String name, String address) {
        assertNotNull(result);
        assertEquals(name, result.name());
        assertEquals(address, result.address());
    }

    @Then("I get a 400 Bad Request response")
    public void iGetA400BadRequestError() {
        assertNotNull(response);
        assertEquals(400, response.getStatus());
    }
}
