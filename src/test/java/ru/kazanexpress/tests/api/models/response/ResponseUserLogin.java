package ru.kazanexpress.tests.api.models.response;


import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseUserLogin {

    public String message;
    public String detailMessage;
}
