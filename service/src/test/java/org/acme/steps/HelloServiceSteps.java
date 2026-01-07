package org.acme.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.acme.HelloService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloServiceSteps {
    private String result;
    private final HelloService service = new HelloService();

    @When("I call the hello service")
    public void iCallTheHelloService() {
        result = service.hello();
    }

    @Then("I get the answer {string}")
    public void iGetTheAnswer(String answer) {
        assertEquals(answer, result);
    }
}
