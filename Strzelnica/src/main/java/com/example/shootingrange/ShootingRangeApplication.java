package com.example.shootingrange;

import io.camunda.client.CamundaClient;
import io.camunda.client.annotation.Deployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Deployment(resources = "classpath:bpmn/*.bpmn")
public class ShootingRangeApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShootingRangeApplication.class, args);
    System.out.println("Aplikacja strzelnicy została uruchomiona!");

    CamundaClient client = CamundaClient.newClient();

    // Dane wejściowe klienta przekazywane do procesów
    Map<String, Object> variables = new HashMap<>();
    variables.put("clientId", 2);
    variables.put("clientAction", "reserve");
    variables.put("age", 20);
    variables.put("hasLicense", true);
    variables.put("hasTraining", false);


    client.newCreateInstanceCommand()
            .bpmnProcessId("Process_0n3b101")
            .latestVersion()
            .variables(variables)
            .send();

  }
}