package ru.kazanexpress.tests.api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;

public class User {
    @JsonIgnoreProperties(ignoreUnknown = true)

        private String id;

        private String email;

        private String password;
    }
