package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("production")
public class InfoPortProduction implements InfoPort {
    @Value("${server.port}")
    private String port;

    @Override
    public String getPort() {
        return port;
    }
}
