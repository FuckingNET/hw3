package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.service.InfoPort;

@RestController
public class InfoController {
    private final InfoPort infoPort;

    public InfoController(InfoPort infoPort) {
        this.infoPort = infoPort;
    }

    @GetMapping("getPort")
    public String getPort() {
        return infoPort.getPort();
    }
}
