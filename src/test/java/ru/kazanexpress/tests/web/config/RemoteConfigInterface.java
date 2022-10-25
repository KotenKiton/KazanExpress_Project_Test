package ru.kazanexpress.tests.web.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/remote.properties")
public interface RemoteConfigInterface extends Config {
    String remoteUrl();

    String selenoidLogin();

    String selenoidPassword();
}

