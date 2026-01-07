package org.acme;

import io.cucumber.core.snippets.SnippetType;
import io.quarkiverse.cucumber.CucumberOptions;
import io.quarkiverse.cucumber.CucumberQuarkusTest;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@CucumberOptions(
        features = "classpath:specifications",
        glue = "org.acme.steps",
        snippets = SnippetType.CAMELCASE
)
public class AcceptanceTest extends CucumberQuarkusTest {
}
