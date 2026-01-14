package com.example.shootingrange.test;

import com.example.shootingrange.ClientData;
import io.camunda.client.CamundaClient;
import io.camunda.client.annotation.Deployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Map;

@SpringBootApplication(scanBasePackages = "com.example.shootingrange")
@Deployment(resources = "classpath:bpmn/*.bpmn")
public class ShootingSessionWorkersTest {

    public static void main(String[] args) {
        SpringApplication.run(ShootingSessionWorkersTest.class, args);
        System.out.println("\nUruchomiono test");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startProcessAfterStartup() {
        CamundaClient client = CamundaClient.newClient();

        // Dane wejściowe klienta przekazywane do procesów
        Map<String, Object> variables = ClientData.getClientVariables();

        client.newCreateInstanceCommand()
                .bpmnProcessId("Process_000ozi1")// ID bpmn
                .latestVersion()
                .variables(variables)
                .send();

        System.out.println("[Proces sesji strzelniczej klienta]\n");
    }
}