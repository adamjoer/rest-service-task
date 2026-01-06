package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/person")
public class PersonResource {
    private Person person = new Person("John Doe", "USA");

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson() {
        return person;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(Person newPerson) {
        this.person = newPerson;
    }
}
