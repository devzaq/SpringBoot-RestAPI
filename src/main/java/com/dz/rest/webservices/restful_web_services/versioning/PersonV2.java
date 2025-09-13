package com.dz.rest.webservices.restful_web_services.versioning;

public class PersonV2 {

    private Name name;

    public PersonV2(String firstName, String lastName) {
         this.name = new Name(firstName, lastName);
    }

    public Name getName() {
        return name;
    }
}
