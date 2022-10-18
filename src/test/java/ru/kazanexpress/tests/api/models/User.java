package ru.kazanexpress.tests.api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;


public class User {
    @JsonIgnoreProperties(ignoreUnknown = true)

        private String id;

        private String email;

        private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
