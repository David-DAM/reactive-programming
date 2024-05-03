package com.david.reactiveprogramming.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("personalEmail")
public record EmailConfigProperties(String username, String password) {
}
