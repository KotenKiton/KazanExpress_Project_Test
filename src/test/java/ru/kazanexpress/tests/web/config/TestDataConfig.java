package ru.kazanexpress.tests.web.config;

import org.aeonbits.owner.Config;

public interface TestDataConfig extends Config {

    String userLogin();
    String userPassword();
}
