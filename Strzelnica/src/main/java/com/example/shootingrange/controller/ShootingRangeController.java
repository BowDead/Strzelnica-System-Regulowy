package com.example.shootingrange.controller;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ShootingRangeController {

    @Autowired
    private ZeebeClient client;

    @PostMapping("/start-range")
    public void startProcess(@RequestBody Map<String, Object> variables) {
        client.newCreateInstanceCommand()
                .bpmnProcessId("Process_0n3b101")
                .latestVersion()
                .variables(variables)
                .send();
    }
}
