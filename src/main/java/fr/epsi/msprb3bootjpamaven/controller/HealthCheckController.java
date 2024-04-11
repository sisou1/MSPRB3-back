package fr.epsi.msprb3bootjpamaven.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/healthz")
    public String healthCheck() {
        return "OK";
    }
}