package br.com.vemser.util;

import com.github.javafaker.Faker;

public class DataFakerGenerator {

    private static final Faker faker = new Faker();

    public String emailFaker() {
        return faker.internet().emailAddress();
    }

    public String firstNameFaker() {
        return faker.name().firstName();
    }

    public String lastNameFaker() {
        return faker.name().lastName();
    }

    public String fullNameFaker() {
        return faker.name().fullName();
    }

    public String passwordFaker() {
        return faker.internet().password();
    }

    public String companyFaker() {
        return faker.company().name();
    }

    public String addressFaker() {
        return faker.address().streetAddress();
    }

    public String cityFaker() {
        return faker.address().state();
    }

    public String zipCodeFaker() {
        return faker.number().digits(5);
    }

    public String phoneFaker() {
        return faker.phoneNumber().cellPhone();
    }

    public String messageFaker() {
        return faker.lorem().sentence();
    }

    public String orderReference() {
        return faker.number().digits(5);
    }

    public String emailInvalidFaker() {
        return faker.internet().emailAddress().replace("@", "");
    }

    public String aliasFaker() {
        return faker.address().streetName();
    }


}
