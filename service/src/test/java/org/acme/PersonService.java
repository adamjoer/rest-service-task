package org.acme;

import jakarta.ws.rs.core.Response;

public class PersonService {
    private final String baseUrl;

    public PersonService() {
        this("http://localhost:8080");
    }

    public PersonService(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Person getPerson() {
        try (var client = jakarta.ws.rs.client.ClientBuilder.newBuilder().build()) {
            return client.target(baseUrl).path("person").request().get(Person.class);
        }
    }

    public Response updatePerson(Person person) {
        try (var client = jakarta.ws.rs.client.ClientBuilder.newBuilder().build()) {
            try (var response = client.target(baseUrl).path("person").request().post(jakarta.ws.rs.client.Entity.json(person))) {
                return response;
            }
        }
    }
}
