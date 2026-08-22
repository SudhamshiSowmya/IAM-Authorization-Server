package com.iam.server.config;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;

@Configuration
public class RegisteredClientConfig {

    @Bean
    public RegisteredClientRepository registeredClientRepository() {

        RegisteredClient registeredClient = RegisteredClient.withId(
                UUID.randomUUID().toString()
        )
                .clientId("iam-client")
                .clientSecret("{noop}iam-secret")

                .clientAuthenticationMethod(
                        ClientAuthenticationMethod.CLIENT_SECRET_BASIC
                )

                .authorizationGrantType(
                        AuthorizationGrantType.AUTHORIZATION_CODE
                )

                .authorizationGrantType(
                        AuthorizationGrantType.REFRESH_TOKEN
                )

                .redirectUri(
                        "http://127.0.0.1:8080/login/oauth2/code/iam-client"
                )

                .scope("openid")
                .scope("profile")

                .build();

        return new InMemoryRegisteredClientRepository(registeredClient);
    }
}