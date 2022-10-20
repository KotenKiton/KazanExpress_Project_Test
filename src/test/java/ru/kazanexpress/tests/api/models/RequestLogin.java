package ru.kazanexpress.tests.api.models;


import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class RequestLogin {

    private RequestLogin requestLogin;

}
